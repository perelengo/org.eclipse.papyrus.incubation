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
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * A {@link RecordingCommand} to execute a Papyrus refactoring transformation
 *
 * @noextend This class is not intended to be extended by clients.
 */
public class PapyrusRefactoringCommand extends AbstractEMFOperation {

	/** The modelSet to transform */
	private ModelSet fModelSet;

	/** The papyrus transformation to execute */
	protected AbstractPapyrusTransformation fPapyrusRefactoringTransformation;


	/**
	 * Constructor.
	 *
	 * @param domain
	 *            The editingDomain used to executed the command
	 * @param papyrusRefactoringTransformation
	 *            The transformation to execute inside the command
	 * @param modelSet
	 *            The modelSet to change
	 * @param label
	 *            The label of the command
	 */
	public PapyrusRefactoringCommand(TransactionalEditingDomain domain, AbstractPapyrusTransformation papyrusRefactoringTransformation,
			ModelSet modelSet, String label) {
		super(domain, label);
		fPapyrusRefactoringTransformation = papyrusRefactoringTransformation;
		fPapyrusRefactoringTransformation.setModelSet(modelSet);
		fModelSet = modelSet;
	}

	@Override
	protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		fPapyrusRefactoringTransformation.execute(fModelSet);
		return null;
	}

}
