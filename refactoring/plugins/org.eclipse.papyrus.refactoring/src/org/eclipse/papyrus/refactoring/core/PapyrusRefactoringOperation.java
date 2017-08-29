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

import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.refactoring.ui.PapyrusRefactoringWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Activate the refactoring cycle.
 * 
 * @noextend This class is not intended to be extended by clients.
 */
public class PapyrusRefactoringOperation {

	/** The papyrus transformation to execute */
	private AbstractPapyrusTransformation fPapyrusTransformation;

	/**
	 * Constructor.
	 *
	 * @param PapyrusTransformation
	 *            The transformation linked to this operation
	 */
	public PapyrusRefactoringOperation(AbstractPapyrusTransformation PapyrusTransformation) {
		fPapyrusTransformation = PapyrusTransformation;
	}

	/**
	 * Create the refactoring linked to the transformation, then create the wizard related to this refactoring, then the operation to run
	 * {@link org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation.RefactoringWizardOpenOperation(RefactoringWizard wizard)}
	 * 
	 */
	public void run() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		ModelSet modelSet = getModelSet();
		fPapyrusTransformation.setModelSet(modelSet);
		String label = fPapyrusTransformation.getName();
		PapyrusRefactoring currentRefactoring = new PapyrusRefactoring(label, modelSet, fPapyrusTransformation);
		PapyrusRefactoringWizard refactoringWizard = new PapyrusRefactoringWizard(currentRefactoring, label);
		RefactoringWizardOpenOperation operation = new RefactoringWizardOpenOperation(refactoringWizard);

		try {
			operation.run(win.getShell(), label);
		} catch (InterruptedException e) {
			Activator.log.error(e);
		}

	}


	/**
	 * Get the model which is the target of this refactoring operation
	 * 
	 * @return
	 * 		The modelSet to transform
	 */
	public ModelSet getModelSet() {
		try {
			ModelSet modelSet = org.eclipse.papyrus.infra.ui.util.ServiceUtilsForHandlers.getInstance().getModelSet(null);
			return modelSet;

		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}


}
