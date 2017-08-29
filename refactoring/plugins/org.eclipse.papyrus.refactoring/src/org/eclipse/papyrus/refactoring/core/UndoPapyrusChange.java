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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.refactoring.messages.Messages;


/**
 * This class manages the undo operation of the transformation based on the LTK refactoring framework
 *
 * @noextend This class is not intended to be extended by clients.
 *
 */
public class UndoPapyrusChange extends Change {

	/** The EMFOperation encappsulating the execution of the Change to enable a proper undo */
	private AbstractEMFOperation emfOperation;

	/** The name of the executed command */
	private String fName;

	/** The element to transform through the execution of the change */
	private Object fElementToTransform;

	/** Boolean used to mark if the change can be undone or not */
	private boolean fCanUndo;

	private static final String CHECKING_CONDITIONS = Messages.UNDOPAPYRUSCHANGE_VALIDITYCHECK;

	private static final String INVALID_UNDO = Messages.UNDOPAPYRUSCHANGE_ERROR;

	/**
	 * Constructor.
	 *
	 * @param emfOperation
	 *            The operation rewinded by the change
	 * @param elementToTransform
	 *            The element rewinded
	 * @param elementName
	 *            The name of the rewinded element
	 */
	public UndoPapyrusChange(AbstractEMFOperation emfOperation, Object elementToTransform, String elementName) {
		this.emfOperation = emfOperation;
		this.fName = elementName;
		this.fElementToTransform = elementToTransform;
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		try {
			emfOperation.undo(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Activator.log.error(e);
		}

		// Can't only return null if the command needs to be redone
		// This undoChange undo the previous one
		return new UndoPapyrusChange(emfOperation, fElementToTransform, fName);
	}

	@Override
	public String getName() {
		return fName + "_ChangeUndo"; // $NON-NLS-0$
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
		fCanUndo = emfOperation.canUndo();
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		RefactoringStatus status = new RefactoringStatus();
		try {
			pm.beginTask(CHECKING_CONDITIONS, 1);
			if (!fCanUndo) {
				status.merge(RefactoringStatus.createFatalErrorStatus(INVALID_UNDO));
			}
			return status;
		} finally {
			pm.done();
		}
	}

	@Override
	public Object getModifiedElement() {
		return fElementToTransform;
	}

}
