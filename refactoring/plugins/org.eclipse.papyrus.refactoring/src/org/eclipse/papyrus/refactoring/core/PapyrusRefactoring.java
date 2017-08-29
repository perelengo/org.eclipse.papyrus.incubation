/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.refactoring.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.services.validation.internal.EcoreDiagnostician;
import org.eclipse.papyrus.refactoring.Activator;
import org.eclipse.papyrus.refactoring.messages.Messages;
import org.eclipse.papyrus.refactoring.refactoringOnElement.AbstractTransformationOnElement;
import org.eclipse.papyrus.refactoring.refactoringOnElement.PapyrusCompositeChange;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.swt.widgets.Display;

/**
 * This class represents the {@link Refactoring} for Papyrus refactoring.
 * 
 * @noextend This class is not intended to be extended by clients.
 * 
 */
@SuppressWarnings("restriction")
public class PapyrusRefactoring extends Refactoring {

	/** The human readable name */
	protected String fName;

	/** The ModelSet to be modified */
	protected ModelSet fModelSet;

	/** The {@link AbstractPapyrusTransformation} corresponding to this Papyrus refactoring */
	protected AbstractPapyrusTransformation fPapyrusRefactoringTransformation;

	/** Parameter used to remove duplicates when running the diagnostic on the preview and the getting the related change */
	private Change change;

	/**
	 * A {@link Runnable} to check final conditions before executing the transformation
	 */
	private class FinalConditionsRunnable implements Runnable {

		private RefactoringStatus finalRefactoringStatus;

		@Override
		public void run() {
			finalRefactoringStatus = fPapyrusRefactoringTransformation.checkFinalConditions();
		}

		public RefactoringStatus getfinalRefactoringStatus() {
			return finalRefactoringStatus;
		}
	}

	/**
	 * A {@link Runnable} to check initial conditions before executing the transformation
	 */
	private class InitialConditionsRunnable implements Runnable {

		private RefactoringStatus initialRefactoringStatus;

		@Override
		public void run() {
			initialRefactoringStatus = fPapyrusRefactoringTransformation.checkInitialConditions();
		}

		public RefactoringStatus getInitialRefactoringStatus() {
			return initialRefactoringStatus;
		}
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 *            The name associated to this transformation
	 * @param modelSet
	 *            The modelSet to modify
	 * @param papyrusRefactoringTransformation
	 *            The transformation to execute (rename, mutation,...)
	 */
	public PapyrusRefactoring(String name, ModelSet modelSet, AbstractPapyrusTransformation papyrusRefactoringTransformation) {
		fName = name;
		fModelSet = modelSet;
		fPapyrusRefactoringTransformation = papyrusRefactoringTransformation;
	}


	@Override
	public String getName() {
		return fName;
	}

	/**
	 * Verify that the modelSet to transform has been provided prior to the execution
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Refactoring#checkInitialConditions(org.eclipse.core.runtime.IProgressMonitor)
	 *
	 * @param pm
	 * @return
	 * 		OK status if the modelSet was provided, null otherwise
	 * @throws CoreException
	 * @throws OperationCanceledException
	 */
	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws CoreException, OperationCanceledException {

		RefactoringStatus status = new RefactoringStatus();

		try {
			pm.beginTask(Messages.PAPYRUSREFACTORING_CHECKPRECONDITIONS, 1);
			if (fModelSet == null) {
				status.merge(RefactoringStatus.createFatalErrorStatus(Messages.PAPYRUSREFACTORING_RESOURCEOPEN_ERROR));

			} else {
				InitialConditionsRunnable initialConditionsRunnable = new InitialConditionsRunnable();
				Display.getDefault().syncExec(initialConditionsRunnable);
				// Display.getDefault().asyncExec(initialConditionsRunnable);
				return initialConditionsRunnable.getInitialRefactoringStatus();
			}

		} finally {
			pm.done();
		}

		return null;
	}

	/**
	 * Verify that the transformation has not been canceled and that the transformation executed itself without errors
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Refactoring#checkFinalConditions(org.eclipse.core.runtime.IProgressMonitor)
	 *
	 * @param pm
	 * @return
	 * @throws CoreException
	 * @throws OperationCanceledException
	 */
	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor pm) throws CoreException, OperationCanceledException {

		try {
			pm.beginTask(Messages.PAPYRUSREFACTORING_MODELVALIDITY, 2);
			FinalConditionsRunnable finalConditionRunnable = new FinalConditionsRunnable();
			Display.getDefault().syncExec(finalConditionRunnable);
			// Display.getDefault().asyncExec(finalConditionRunnable);

			RefactoringStatus status = finalConditionRunnable.getfinalRefactoringStatus();

			if (status.getSeverity() != RefactoringStatus.FATAL) {
				Diagnostic diagnostic = diagnosticRefactoring();

				if (diagnostic != null && diagnostic.getSeverity() != Diagnostic.OK) {
					status.addError(Messages.PAPYRUSREFACTORING_MODELVALIDITY_ERROR, new PapyrusRefactoringValidationStatusContext(diagnostic));
				}
			}

			return status;

		} finally {
			pm.done();
		}

	}

	/**
	 * Verify if the refactoring will affect the model validity.
	 * 
	 * @return a Diagnostic of the impact of the refactoring.
	 */
	private Diagnostic diagnosticRefactoring() {
		ModelSet previewModelSet = null;
		if (fPapyrusRefactoringTransformation instanceof AbstractTransformationOnElement) {
			change = new PapyrusCompositeChange((AbstractTransformationOnElement) fPapyrusRefactoringTransformation, fModelSet);
			// previewModelSet = change.getCompositePreviewModelSet();
			previewModelSet = ((PapyrusCompositeChange) change).getChangePreviewModelSet();
		} else {
			change = new PapyrusChange(fPapyrusRefactoringTransformation, fName, fModelSet);
			previewModelSet = ((PapyrusChange) change).getChangePreviewModelSet();
		}

		if (previewModelSet != null) {
			UmlModel umlModel = UmlUtils.getUmlModel(previewModelSet);
			if (umlModel != null) {
				EObject root;
				try {
					root = umlModel.lookupRoot();
					TransactionalEditingDomain domain = previewModelSet.getTransactionalEditingDomain();
					EcoreDiagnostician diagnostician = new EcoreDiagnostician();
					AdapterFactory adapterFactory = domain instanceof AdapterFactoryEditingDomain ? ((AdapterFactoryEditingDomain) domain).getAdapterFactory() : null;
					diagnostician.initialize(adapterFactory, new NullProgressMonitor());

					return diagnostician.validate(root);
				} catch (NotFoundException e) {
					Activator.log.error(e);
				}

			}
		}

		return null;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		try {
			pm.beginTask(Messages.PAPYRUSREFACTORING_EXECUTE, 1);

			if (fPapyrusRefactoringTransformation instanceof AbstractTransformationOnElement) {
				fPapyrusRefactoringTransformation.setModelSet(fModelSet);
				// PapyrusCompositeChange compositeChange = new PapyrusCompositeChange((AbstractTransformationOnElement) fPapyrusRefactoringTransformation, fModelSet);
				// return compositeChange;
			} else {
				// PapyrusChange change = new PapyrusChange(fPapyrusRefactoringTransformation, fName, fModelSet);
				// return change;
			}

			return change;

		} finally {
			pm.done();
		}
	}



	/**
	 * @return The corresponding {@link AbstractPapyrusTransformation}
	 */
	public AbstractPapyrusTransformation getPapyrusTransformation() {
		return fPapyrusRefactoringTransformation;
	}
}
