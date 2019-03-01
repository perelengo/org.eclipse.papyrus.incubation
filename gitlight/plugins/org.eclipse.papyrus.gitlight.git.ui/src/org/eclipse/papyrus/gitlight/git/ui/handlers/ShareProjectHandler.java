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
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.egit.core.RepositoryUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jgit.api.Git;
import org.eclipse.papyrus.gitlight.git.ui.Activator;
import org.eclipse.papyrus.gitlight.git.ui.dialogs.RepositorySelectionDialog;
import org.eclipse.papyrus.gitlight.git.utils.PapyrusFileUtils;
import org.eclipse.papyrus.gitlight.git.utils.GitConstants;
import org.eclipse.papyrus.gitlight.git.utils.GitProcessUtils;
import org.eclipse.papyrus.gitlight.git.utils.GitUtils;
import org.eclipse.papyrus.gitlight.review.profile.ReviewProfileResource;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * The handler which allow to share a project.
 */
@SuppressWarnings("restriction")
public class ShareProjectHandler extends AbstractHandler {

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

			// Check that the selection is an papyrus file
			final IFile file = PapyrusFileUtils.getFile(firstElement);
			if (null != file) {

				// Get the model
				URI modelURI = URI.createPlatformResourceURI(file.getFullPath().toString(), false);
				if (!"uml".equals(modelURI.fileExtension())) { //$NON-NLS-1$
					modelURI = modelURI.trimFileExtension().appendFileExtension("uml"); //$NON-NLS-1$
				}
				final EObject root = PapyrusFileUtils.getRootModel(modelURI);

				if (root instanceof Element) {

					// Get the parent project
					final IProject project = file.getProject();

					// Get the repository util which allow to get all the repositories
					RepositoryUtil repositoryUtil = org.eclipse.egit.ui.Activator.getDefault().getRepositoryUtil();
					String selectedRepository = null;

					// Open the dialog to select a repository
					final RepositorySelectionDialog dialog = new RepositorySelectionDialog(Display.getCurrent().getActiveShell(), repositoryUtil.getRepositories());
					if (dialog.open() == Window.OK) {
						selectedRepository = dialog.getSelectedRepository();

						// Share the project
						manageShareProject(selectedRepository, project, (Element) root);
					}
				}
			}
		}

		return null;
	}

	/**
	 * This allows to share a project into git.
	 * 
	 * @param selectedRepository
	 *            The repository path.
	 * @param project
	 *            The project to share.
	 * @param rootElement
	 *            The root element.
	 */
	protected void manageShareProject(final String selectedRepository, final IProject project, final Element rootElement) {

		// Only continue if the selected repository path is not null or empty
		if (null != selectedRepository && !selectedRepository.isEmpty()) {

			// Get the git
			final Git git = GitUtils.openGit(selectedRepository);
			if (null != git) {
				try {
					new ProgressMonitorDialog(Display.getCurrent().getActiveShell()).run(true, false, monitor -> {
						monitor.beginTask("Share project", 6); //$NON-NLS-1$

						// Add the review profile
						monitor.subTask("Add the review profile"); //$NON-NLS-1$
						addReviewProfile((Package) rootElement);
						monitor.worked(1);

						// Build the parent git folder (where the data are)
						monitor.subTask("Copy the project into the repository"); //$NON-NLS-1$
						GitProcessUtils.copyProject(git, project);
						monitor.worked(1);

						// Create the commit message
						monitor.subTask("Create the commit"); //$NON-NLS-1$
						GitUtils.createCommit(git, GitConstants.INITIAL_COMMIT_MESSAGE);
						monitor.worked(1);

						// Push the commit
						monitor.subTask("Push the commit"); //$NON-NLS-1$
						GitUtils.pushCommit(git);
						monitor.worked(1);

						try {
							// Keep the project name
							final String projectName = project.getName();

							// Delete the project from workspace
							monitor.subTask("Delete the project from the workspace"); //$NON-NLS-1$
							project.delete(false, true, monitor);
							monitor.worked(1);

							// Create and open the project from the new path
							monitor.subTask("Import the project from the repository"); //$NON-NLS-1$
							final URI gitPath = URI.createURI(selectedRepository.replace("\\", "/")).trimSegments(1); //$NON-NLS-1$ //$NON-NLS-2
							final String projectFilePath = gitPath.toString() + "/" + projectName + "/.project"; //$NON-NLS-1$ //$NON-NLS-2$
							final IWorkspace workspace = ResourcesPlugin.getWorkspace();
							final IProjectDescription description = workspace.loadProjectDescription(new Path(projectFilePath));
							final IProject newProject = workspace.getRoot().getProject(description.getName());
							newProject.create(description, monitor);
							newProject.open(monitor);
							newProject.refreshLocal(IResource.DEPTH_INFINITE, monitor);
							monitor.worked(1);
						} catch (CoreException e) {
							Activator.getLogHelper().error("Unknown error while deleting project from workspace", e); //$NON-NLS-1$
						} finally {
							monitor.done();
						}
					});
				} catch (final InvocationTargetException e) {
					Activator.getLogHelper().error(e);
				} catch (final InterruptedException e) {
					Activator.getLogHelper().error("Share cancelled.", e); //$NON-NLS-1$
				}
			}
		}
	}

	/**
	 * This allows to apply the profile to the model.
	 * 
	 * @param rootElement
	 *            The root element (as package).
	 */
	protected void addReviewProfile(final Package rootElement) {
		final Resource resource = rootElement.eResource();
		final Profile review = (Profile) PackageUtil.loadPackage(URI.createURI(ReviewProfileResource.PROFILE_PATH), resource.getResourceSet());
		if (review != null && !rootElement.getAppliedProfiles().contains(review)) {
			PackageUtil.applyProfile(rootElement, review, true);

			try {
				resource.save(null);
			} catch (IOException e) {
				Activator.getLogHelper().error("Error during save of UML file", e); //$NON-NLS-1$
			}
		}
	}

}
