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

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.egit.ui.internal.CompareUtils;
import org.eclipse.egit.ui.internal.selection.SelectionUtils;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.papyrus.gitlight.git.ui.Activator;
import org.eclipse.papyrus.gitlight.git.ui.utils.GitActionsUtils;
import org.eclipse.papyrus.gitlight.git.utils.GitConstants;
import org.eclipse.papyrus.gitlight.git.utils.GitInstance;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Element;

/**
 * The handler to review a contribution.
 */
@SuppressWarnings("restriction")
public class ReviewContributionHandler extends AbstractHandler {

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
			if (firstElement instanceof Ref) {

				final Shell shell = getShell(event);

				// Ask to user that he will lose all modifications on model to review it
				final MessageDialog dialog = new MessageDialog(shell, "Confirm review", null, "To review a contribution, you will lose modifications on the project to review.\nAre you sure you want to review this contribution ?", //$NON-NLS-1$ //$NON-NLS-2$
						MessageDialog.QUESTION, 0, IDialogConstants.YES_LABEL, IDialogConstants.CANCEL_LABEL);
				dialog.open();
				final int dialogResult = dialog.getReturnCode();

				// The user want to lose modifications
				if (dialogResult == 0) {

					// Manage the project (delete and re-import) and compare
					manageProjectAndCompare(GitInstance.getInstance().getRootElement(), (Ref) firstElement, shell);
				}
			}
		}

		return null;
	}

	/**
	 * This allows to get shell from the execution event.
	 * 
	 * @param event
	 *            The execution event.
	 * @return The correct shell.
	 * @throws ExecutionException
	 *             The possible execution exception.
	 */
	protected Shell getShell(final ExecutionEvent event) throws ExecutionException {
		return HandlerUtil.getActiveShellChecked(event);
	}

	/**
	 * This allows to update the git, update the project and compare it with master.
	 * 
	 * @param rootElement
	 *            The root element.
	 * @param branch
	 *            The branch.
	 * @param shell
	 *            The shell.
	 */
	protected void manageProjectAndCompare(final Element rootElement, final Ref branch, final Shell shell) {

		final Git git = GitInstance.getInstance().getGit();
		// Get the project of the contribution
		final IProject importedProject = GitActionsUtils.getIProjectContribution(shell, git, branch, rootElement, "Review a contribution"); //$NON-NLS-1$

		try {
			// We need to get the repo from the project because if we get this from the git instance, this one is not the correct one and there is no differences
			if (null != importedProject) {
				final Repository repository = SelectionUtils.getRepositoryOrWarn(new StructuredSelection(importedProject), shell);
				if (null != repository) {

					// Calculate the workbench page before to open the progress monitor
					final IWorkbenchPage workBenchPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

					// Compare the remote branch with the remote master
					CompareUtils.compare(new IResource[] { importedProject }, repository, Constants.HEAD, Constants.R_REMOTES + GitConstants.MASTER_REPOSITORY_PATH, true, workBenchPage);
				}
			}
		} catch (IOException e) {
			Activator.getLogHelper().error("Error while compare the two models", e); //$NON-NLS-1$
		}
	}
}
