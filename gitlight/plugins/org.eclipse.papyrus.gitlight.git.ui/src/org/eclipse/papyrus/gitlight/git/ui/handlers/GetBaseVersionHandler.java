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
package org.eclipse.papyrus.gitlight.git.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.papyrus.gitlight.git.ui.utils.GitActionsUtils;
import org.eclipse.papyrus.gitlight.git.utils.PapyrusFileUtils;
import org.eclipse.papyrus.gitlight.git.utils.GitUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * The handler to get the base of a project in the workspace.
 */
public class GetBaseVersionHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {

		// Get the selection
		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection selec = (IStructuredSelection) selection;
			final Object firstElement = selec.getFirstElement();

			// Check if the selection is a branch
			final IFile file = PapyrusFileUtils.getFile(firstElement);
			if (null != file) {

				final Shell shell = Display.getCurrent().getActiveShell();

				// Ask to user that he will lose all modifications on model to review it
				final MessageDialog dialog = new MessageDialog(shell, "Confirm", null, "You will lose modifications on the project if you have it in your workspace.\nAre you sure you want to get this contribution ?", MessageDialog.QUESTION, 0,
						IDialogConstants.YES_LABEL, IDialogConstants.CANCEL_LABEL);
				dialog.open();
				final int dialogResult = dialog.getReturnCode();

				// The user want to lose modifications
				if (dialogResult == 0) {

					final IProject project = file.getProject();
					final Repository repository = GitUtils.getRepository(project);
					if (null != repository) {
						final Git git = GitUtils.openGit(repository.getWorkTree().getAbsolutePath());
						if (null != git) {
							final Ref masterBranch = GitUtils.getBranchForName(git, Constants.MASTER);
							// Get the project of the contribution
							GitActionsUtils.getIProjectContribution(shell, git, masterBranch, file, "Get the base"); //$NON-NLS-1$
						}
					}
				}
			}
		}

		return null;
	}
}
