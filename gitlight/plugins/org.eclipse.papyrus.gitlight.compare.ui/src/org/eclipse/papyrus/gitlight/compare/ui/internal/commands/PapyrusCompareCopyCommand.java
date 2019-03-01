/*****************************************************************************
 * Copyright (c) 2019 CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gitlight.compare.ui.internal.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.gitlight.compare.ui.PapyrusCompareUIPlugin;

/**
 * This allows to manage the compare copy command as transactional command to avoid transactional error while executing.
 */
public class PapyrusCompareCopyCommand extends AbstractTransactionalCommand {

	/**
	 * The compare copy command to wrap as transactional.
	 */
	private Command compareCopyCommand;

	/**
	 * 
	 * Constructor.
	 *
	 * @param domain
	 *            The editing domain.
	 * @param compareCopyCommand
	 *            The compare copy command to wrap as transactional.
	 */
	public PapyrusCompareCopyCommand(final TransactionalEditingDomain domain, final Command compareCopyCommand) {
		super(domain, compareCopyCommand.getLabel(), null);
		this.compareCopyCommand = compareCopyCommand;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		compareCopyCommand.execute();
		return CommandResult.newOKCommandResult();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.workspace.AbstractEMFOperation#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doUndo(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected IStatus doUndo(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		compareCopyCommand.undo();
		return new Status(IStatus.OK, PapyrusCompareUIPlugin.PLUGIN_ID, "Undo merge"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.workspace.AbstractEMFOperation#canRedo()
	 */
	@Override
	public boolean canRedo() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doRedo(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected IStatus doRedo(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		compareCopyCommand.undo();
		return new Status(IStatus.OK, PapyrusCompareUIPlugin.PLUGIN_ID, "Undo merge"); //$NON-NLS-1$
	}

}
