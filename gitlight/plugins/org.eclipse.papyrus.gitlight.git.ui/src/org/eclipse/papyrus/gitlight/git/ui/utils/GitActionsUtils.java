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
package org.eclipse.papyrus.gitlight.git.ui.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.papyrus.gitlight.git.ui.Activator;
import org.eclipse.papyrus.gitlight.git.utils.PapyrusFileUtils;
import org.eclipse.papyrus.gitlight.git.utils.GitUtils;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;

/**
 * This allows to define git UI utils actions.
 */
public class GitActionsUtils {

	/**
	 * This allows to get the project corresponding to the contribution.
	 * 
	 * @param shell
	 *            The shell.
	 * @param git
	 *            The git.
	 * @param branch
	 *            The branch which one get.
	 * @param rootElement
	 *            The root element corresponding to the project to import.
	 * @param taskName
	 *            The UI task name.
	 * @return The (re-)imported project.
	 */
	public static IProject getIProjectContribution(final Shell shell, final Git git, final Ref branch, final Element rootElement, final String taskName) {
		return getIProjectContribution(shell, git, branch, PapyrusFileUtils.getFile(rootElement), taskName);
	}

	/**
	 * This allows to get the project corresponding to the contribution.
	 * 
	 * @param shell
	 *            The shell.
	 * @param git
	 *            The git.
	 * @param branch
	 *            The branch which one get.
	 * @param file
	 *            The file corresponding to the project to import.
	 * @param taskName
	 *            The UI task name.
	 * @return The (re-)imported project.
	 */
	public static IProject getIProjectContribution(final Shell shell, final Git git, final Ref branch, final IFile umlFile, final String taskName) {

		// Get the resources corresponding to the model
		final IProject project = umlFile.getProject();
		final String projectName = project.getName();

		// Get the branch name
		final String fullBranchName = branch.getName();
		final String shortBranchName = fullBranchName.substring(fullBranchName.indexOf(Constants.R_REMOTES) + Constants.R_REMOTES.length() + Constants.DEFAULT_REMOTE_NAME.length() + 1);

		final List<IProject> importedProject = new ArrayList<IProject>(1);

		try {
			new ProgressMonitorDialog(shell).run(true, false, monitor -> {
				monitor.beginTask(taskName, 6);

				try {
					// First, reset the current branch
					monitor.subTask("Reset the branch"); //$NON-NLS-1$
					GitUtils.resetHardCurrentBranch(git);
					monitor.worked(1);

					// First, checkout the master branch (else we can't delete the other branch)
					monitor.subTask("Checkout the master"); //$NON-NLS-1$
					GitUtils.checkoutExistingBranch(git, Constants.MASTER);
					monitor.worked(1);

					// Second, we have to delete local branch if exist
					monitor.subTask("Delete the local branch"); //$NON-NLS-1$
					GitUtils.deleteLocalBranch(git, shortBranchName);
					monitor.worked(1);

					// After, create the local branch from the remote branch
					monitor.subTask("Create the local branch from the remote branch"); //$NON-NLS-1$
					GitUtils.createBranch(git, shortBranchName, shortBranchName);
					monitor.worked(1);

					// Delete the project from workspace
					monitor.subTask("Delete the project from the workspace"); //$NON-NLS-1$
					project.delete(false, true, monitor);
					monitor.worked(1);

					// Create and open the project from its path
					final String repositoryPath = git.getRepository().getWorkTree().getAbsolutePath();
					monitor.subTask("Import the project from the repository"); //$NON-NLS-1$
					final URI gitPath = URI.createURI(repositoryPath.replace("\\", "/")); //$NON-NLS-1$ //$NON-NLS-2
					final String projectFilePath = gitPath.toString() + "/" + projectName + "/.project"; //$NON-NLS-1$ //$NON-NLS-2$
					final IWorkspace workspace = ResourcesPlugin.getWorkspace();
					final IProjectDescription description = workspace.loadProjectDescription(new Path(projectFilePath));
					final IProject reimportedProject = workspace.getRoot().getProject(description.getName());
					reimportedProject.create(description, monitor);
					reimportedProject.open(monitor);
					reimportedProject.refreshLocal(IResource.DEPTH_INFINITE, monitor);
					importedProject.add(reimportedProject);
					monitor.worked(1);
				} catch (final CoreException e) {
					Activator.getLogHelper().error("Error while deleting the project", e); //$NON-NLS-1$
				} finally {
					monitor.done();
				}
			});
		} catch (InvocationTargetException e) {
			Activator.getLogHelper().error(e);
		} catch (InterruptedException e) {
			Activator.getLogHelper().error(e);
		}

		return importedProject.isEmpty() ? null : importedProject.get(0);
	}

}
