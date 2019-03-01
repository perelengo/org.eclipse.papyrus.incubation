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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.papyrus.gitlight.git.ui.Activator;
import org.eclipse.papyrus.gitlight.git.ui.dialogs.ContributionSelectionDialog;
import org.eclipse.papyrus.gitlight.git.ui.dialogs.ReviewDialog;
import org.eclipse.papyrus.gitlight.git.utils.PapyrusFileUtils;
import org.eclipse.papyrus.gitlight.git.utils.GitAnnotationUtils;
import org.eclipse.papyrus.gitlight.git.utils.GitConstants;
import org.eclipse.papyrus.gitlight.git.utils.GitProcessUtils;
import org.eclipse.papyrus.gitlight.git.utils.GitUtils;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Element;

/**
 * The handler to create a review of the model.
 */
public class UpdateModelContributionHandler extends AbstractHandler {

	/**
	 * [{@inheritDoc}
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

			// Check that the selection is an papyrus file
			final IFile file = PapyrusFileUtils.getFile(firstElement);
			if (null != file) {

				// Get the model
				URI modelURI = URI.createPlatformResourceURI(file.getFullPath().toString(), false);
				if (!UmlModel.UML_FILE_EXTENSION.equals(modelURI.fileExtension())) {
					modelURI = modelURI.trimFileExtension().appendFileExtension(UmlModel.UML_FILE_EXTENSION);
				}
				final EObject root = PapyrusFileUtils.getRootModel(modelURI);
				if (root instanceof Element) {

					final Repository repository = GitUtils.getRepository((Element) root);
					if (null != repository) {
						final Git git = GitUtils.openGit(repository.getWorkTree().getAbsolutePath());
						if (null != git) {

							// Get the parent project
							final IProject project = file.getProject();

							// Call the reiew dialog to create the version
							final ContributionSelectionDialog contributionDialog = new ContributionSelectionDialog(Display.getCurrent().getActiveShell(), git);
							if (contributionDialog.open() == Window.OK) {
								final Ref branch = contributionDialog.getSelectedBranch();

								final ReviewDialog reviewDialog = new ReviewDialog(Display.getCurrent().getActiveShell(), (Element) root, false);
								if (reviewDialog.open() == Window.OK) {
									final String commentValue = reviewDialog.getComment();
									final String authorValue = reviewDialog.getAuthor();

									// Share the project
									createNewCommit(project, git, repository, branch, commentValue, authorValue, (Element) root);
								}
							}
						}
					}
				}
			}
		}

		return null;
	}

	/**
	 * This allows to create a version of the model.
	 * 
	 * @param project
	 *            The project.
	 * @param git
	 *            The git.
	 * @param repository
	 *            The repository.
	 * @param branch
	 *            The branch.
	 * @param commentValue
	 *            The message of the commit.
	 * @param authorValue
	 *            The author of the commit.
	 * @param rootElement
	 *            The root element.
	 */
	protected void createNewCommit(final IProject project, final Git git, final Repository repository, final Ref branch, final String commentValue, final String authorValue, final Element rootElement) {

		// Retrieve the repository from the project
		try {
			// Get the branch name
			final String fullBranchName = branch.getName();
			final String shortBranchName = fullBranchName.substring(fullBranchName.indexOf(Constants.R_REMOTES) + Constants.R_REMOTES.length() + Constants.DEFAULT_REMOTE_NAME.length() + 1);

			new ProgressMonitorDialog(Display.getCurrent().getActiveShell()).run(true, false, monitor -> {
				monitor.beginTask("Update a contribution", 5); //$NON-NLS-1$

				// Build the branch comment
				String message = commentValue;
				if (message.isEmpty()) {
					message = "Update of version " + GitAnnotationUtils.getVersionAnnotation(rootElement).toString(); //$NON-NLS-1$
				}
				message += "\n\n" + GitConstants.CHANGE_ID; //$NON-NLS-1$
				if (null != authorValue && !authorValue.isEmpty()) {
					message += "\n" + Constants.SIGNED_OFF_BY_TAG + authorValue; //$NON-NLS-1$
				}

				// Search about a local branch with correct name
				monitor.subTask("Search local branch"); //$NON-NLS-1$
				final Ref localBranch = GitUtils.getLocalBranch(git, shortBranchName);
				monitor.worked(1);

				// The local branch exist, checkout it and pull
				if (null != localBranch) {
					monitor.subTask("Checkout and pull local branch"); //$NON-NLS-1$
					GitUtils.checkoutExistingBranch(git, shortBranchName);
					GitUtils.pull(git);
					monitor.worked(1);
				} else {
					// Create the local branch
					monitor.subTask("Create the branch"); //$NON-NLS-1$
					GitUtils.createBranch(git, shortBranchName);
					monitor.worked(1);
				}

				// Add git model files
				monitor.subTask("Add git files"); //$NON-NLS-1$
				GitProcessUtils.addGitFiles(git, repository.getWorkTree(), ""); //$NON-NLS-1$
				monitor.worked(1);

				// Create the commit message
				monitor.subTask("Create the commit"); //$NON-NLS-1$
				GitUtils.createCommit(git, message);
				monitor.worked(1);

				// Push the commit
				monitor.subTask("Push the commit"); //$NON-NLS-1$
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
