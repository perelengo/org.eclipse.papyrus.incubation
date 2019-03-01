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
package org.eclipse.papyrus.gitlight.git.utils;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;

/**
 * Thi class allows to manage the static methods for the git process.
 */
public class GitProcessUtils {

	/**
	 * This allows to copy the project into the git folder and add files into the git.
	 * 
	 * @param git
	 *            The git where add the project.
	 * @param project
	 *            The project to copy.
	 */
	public static void copyProject(final Git git, final IProject project) {
		final Repository repository = git.getRepository();
		final URI gitPath = URI.createURI(repository.getWorkTree().toString().replace("\\", "/")); //$NON-NLS-1$ //$NON-NLS-2$

		// Copy all project and sub files
		copySubFolder(project, gitPath);

		// Add this copied files to git
		addGitFiles(git, repository.getWorkTree(), ""); //$NON-NLS-1$
	}

	/**
	 * This allows to copy a folder from a container info the folder represented by its path.
	 * 
	 * @param container
	 *            The container to copy.
	 * @param folderPath
	 *            The folder path where copy the container.
	 */
	private static void copySubFolder(final IContainer container, final URI folderPath) {
		final URI createdContainerPath = folderPath.appendSegment(container.getName());
		PapyrusFileUtils.copyFolder(container.getLocation().toString(), createdContainerPath.toString());
	}

	/**
	 * This allows to add the files into the git (to prepare commit).
	 * 
	 * @param git
	 *            The git.
	 * @param directory
	 *            The directory file.
	 * @param parentDirectory
	 *            The parent directory path.
	 */
	public static void addGitFiles(final Git git, final File directory, final String parentDirectory) {
		if (directory.isDirectory()) {
			for (final File subFile : directory.listFiles()) {
				if (subFile.isDirectory()) {
					final String newParentDirectory = parentDirectory.isEmpty() ? subFile.getName() : parentDirectory + "/" + subFile.getName(); //$NON-NLS-1$
					addGitFiles(git, subFile, newParentDirectory);
				} else {
					final String filePath = parentDirectory.isEmpty() ? subFile.getName() : parentDirectory + "/" + subFile.getName(); //$NON-NLS-1$
					GitUtils.addFile(git, filePath);
				}
			}
		}
	}
}
