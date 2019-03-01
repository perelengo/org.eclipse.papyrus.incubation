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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.papyrus.gitlight.git.ui.Activator;
import org.eclipse.papyrus.gitlight.git.ui.dialogs.ReviewDialog;
import org.eclipse.papyrus.gitlight.git.utils.GitConstants;
import org.eclipse.papyrus.gitlight.git.utils.GitInstance;
import org.eclipse.papyrus.gitlight.git.utils.GitProcessUtils;
import org.eclipse.papyrus.gitlight.git.utils.GitUtils;
import org.eclipse.papyrus.gitlight.review.profile.utils.ReviewProfileUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Element;

/**
 * The handler to commit a review on the branch.
 */
public class ContributeReviewHandler extends AbstractHandler {

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

				// Get the current git instance
				final Git git = GitInstance.getInstance().getGit();
				final Element rootElement = GitInstance.getInstance().getRootElement();
				if (null != git && null != rootElement) {

					final ReviewDialog dialog = new ReviewDialog(Display.getCurrent().getActiveShell(), rootElement, false);
					if (dialog.open() == Window.OK) {
						final String commentValue = dialog.getComment();
						final String authorValue = dialog.getAuthor();

						final String reviewsComment = ReviewProfileUtils.getModelReviewMessage(rootElement);
						String commitMessage = commentValue;
						if (!commitMessage.isEmpty() && !reviewsComment.isEmpty()) {
							commitMessage += "\n\n"; //$NON-NLS-1$
						}
						commitMessage += reviewsComment;

						// Merge the version
						mergeVersion(git, (Ref) firstElement, commitMessage, authorValue, rootElement);
					}
				}
			}
		}

		return null;
	}

	protected void mergeVersion(final Git git, final Ref branch, final String message, final String reviewerValue, final Element rootElement) {
		if (null != git) {

			try {
				new ProgressMonitorDialog(Display.getCurrent().getActiveShell()).run(true, false, monitor -> {
					monitor.beginTask("Contribute review", 3); //$NON-NLS-1$

					final String fullBranchName = branch.getName();
					final String shortBranchName = fullBranchName.substring(fullBranchName.indexOf(Constants.R_REMOTES) + Constants.R_REMOTES.length() + Constants.DEFAULT_REMOTE_NAME.length() + 1);

					// Manage the message
					String commitMessage = message;
					if (commitMessage.isEmpty()) {
						commitMessage = ""; //$NON-NLS-1$
					}
					commitMessage += "\n\n" + GitConstants.CHANGE_ID; //$NON-NLS-1$
					if (null != reviewerValue && !reviewerValue.isEmpty()) {
						commitMessage += "\n" + Constants.SIGNED_OFF_BY_TAG + reviewerValue; //$NON-NLS-1$
					}

					// Add git model files
					monitor.subTask("Add git files"); //$NON-NLS-1$
					final Repository repository = git.getRepository();
					GitProcessUtils.addGitFiles(git, repository.getWorkTree(), ""); //$NON-NLS-1$
					monitor.worked(1);

					// Create the commit message
					monitor.subTask("Create the commit"); //$NON-NLS-1$
					GitUtils.createCommit(git, commitMessage);
					monitor.worked(1);

					// Push the commit
					monitor.subTask("Push the commit on branch"); //$NON-NLS-1$
					GitUtils.pushBranchCommit(git, shortBranchName);
					monitor.worked(1);

					monitor.done();
				});
			} catch (final InvocationTargetException e) {
				Activator.getLogHelper().error(e);
			} catch (final InterruptedException e) {
				Activator.getLogHelper().error("Creation cancelled.", e); //$NON-NLS-1$
			}
		}
	}
}
