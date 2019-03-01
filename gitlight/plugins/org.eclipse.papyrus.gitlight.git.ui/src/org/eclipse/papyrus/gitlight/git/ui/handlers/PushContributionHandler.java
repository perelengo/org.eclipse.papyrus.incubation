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
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.papyrus.gitlight.git.ui.Activator;
import org.eclipse.papyrus.gitlight.git.utils.GitInstance;
import org.eclipse.papyrus.gitlight.git.utils.GitUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * The handler to merge a review into the master.
 */
public class PushContributionHandler extends AbstractHandler {

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
				if (null != git) {

					// Merge the version
					mergeVersion(git, (Ref) firstElement);
				}
			}
		}

		return null;
	}

	/**
	 * This allows to merge a version branch into master.
	 * 
	 * @param git
	 *            The git.
	 * @param branch
	 *            The branch to merge.
	 */
	protected void mergeVersion(final Git git, final Ref branch) {
		try {
			new ProgressMonitorDialog(Display.getCurrent().getActiveShell()).run(true, false, monitor -> {
				monitor.beginTask("Merging a contribution", 4); //$NON-NLS-1$

				// Merge the branch into master
				monitor.subTask("Merge the branch into master"); //$NON-NLS-1$
				GitUtils.mergeBranch(git, Constants.MASTER, branch);
				monitor.worked(1);

				monitor.subTask("Push the merge"); //$NON-NLS-1$
				GitUtils.pushCommit(git);
				monitor.worked(1);
				
				// First, checkout the master branch (else we can't delete the other branch)
				monitor.subTask("Checkout the master"); //$NON-NLS-1$
				GitUtils.checkoutExistingBranch(git, Constants.MASTER);
				monitor.worked(1);

				// Delete the existing branch
				monitor.subTask("Delete the contribution branch"); //$NON-NLS-1$
				final String branchShortName = GitUtils.getBranchShortName(branch);
				final Ref localBranch = GitUtils.getLocalBranch(git, branchShortName);
				GitUtils.deleteBranch(git, localBranch.getName());
				monitor.worked(1);

				monitor.done();
			});
		} catch (final InvocationTargetException e) {
			Activator.getLogHelper().error(e);
		} catch (final InterruptedException e) {
			Activator.getLogHelper().error("Merge cancelled.", e); //$NON-NLS-1$
		}
	}

}
