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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.papyrus.gitlight.git.Activator;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.widgets.util.FileUtil;

/**
 * The file utils methods needed.
 */
public class PapyrusFileUtils {

	/**
	 * This allows to copy file by streams (with source as URL).
	 * 
	 * @param source
	 *            The source path.
	 * @param dest
	 *            The destination path.
	 * @throws IOException
	 *             The possible Input output exception.
	 */
	public static void copyFileWithURL(final String source, final String dest) throws IOException {
		final File destFile = FileUtil.getFile(dest);
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			final URL url = new URL(source);
			inputStream = url.openConnection().getInputStream();
			outputStream = new FileOutputStream(destFile);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, length);
			}
		} finally {
			inputStream.close();
			outputStream.close();
		}
	}

	/**
	 * This allows to copy file by streams.
	 * 
	 * @param source
	 *            The source path.
	 * @param dest
	 *            The destination path.
	 * @throws IOException
	 *             The possible Input output exception.
	 */
	public static void copyFile(final String source, final String dest) throws IOException {
		final File destFile = FileUtil.getFile(dest);
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			final File srcFile = FileUtil.getFile(source);
			inputStream = new FileInputStream(srcFile);
			outputStream = new FileOutputStream(destFile);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, length);
			}
		} finally {
			inputStream.close();
			outputStream.close();
		}
	}

	/**
	 * This allows to create the folder if needed.
	 * 
	 * @param folderLocation
	 *            The folder location.
	 */
	public static void copyFolder(final String source, final String dest) {
		final File srcFolder = getFolder(source);
		final File destFolder = getFolder(dest);
		if (srcFolder.exists()) {
			if (!destFolder.exists()) {
				destFolder.mkdir();
			}
			// Copy sub folders and files
			for (final File subFile : srcFolder.listFiles()) {
				if (subFile.isDirectory()) {
					copyFolder(subFile.getAbsolutePath(), dest + "/" + subFile.getName()); //$NON-NLS-1$
				} else {
					try {
						copyFile(subFile.getAbsolutePath(), dest + "/" + subFile.getName()); //$NON-NLS-1$
					} catch (IOException e) {
						Activator.getLogHelper().error(e);
					}
				}
			}
		}
	}

	/**
	 * Returns the Java File from the given location.
	 * The location may be either absolute (From the FileSystem) or relative to the workspace root.
	 *
	 * @param location
	 *            The location of the folder.
	 * @return The file
	 */
	public static File getFolder(String location) {
		final IContainer iFolder = getIContainer(location);
		if (iFolder == null || !iFolder.exists()) {
			return new File(location);
		}

		return new File(iFolder.getLocationURI());
	}

	/**
	 * Returns the IFolder (Workspace folder) from the given location.
	 * The location may be either absolute (From the FileSystem) or relative to the workspace root.
	 *
	 * @param location
	 *            The location of the folder.
	 * @return The container.
	 */
	public static IContainer getIContainer(String location) {
		// Search the file in the workspace
		final IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		final IPath path = new Path(location);
		IContainer currentFolder = null;
		try {
			currentFolder = workspace.getFolder(path);
		} catch (IllegalArgumentException ex) {
			// Ignore
		}

		// Then search it on the disk
		if (currentFolder == null || !currentFolder.exists()) {
			currentFolder = (IContainer) workspace.getContainerForLocation(path);
		}

		return currentFolder;
	}

	/**
	 * This allows to get the input stream corresponding to a file.
	 * 
	 * @param urlString
	 *            The url corresponding to the string.
	 * @return The input stream corresponding to the url.
	 */
	public static InputStream getInputStream(final String urlString) {
		String realURL = urlString.replace("\\\\", "/"); //$NON-NLS-1$ //$NON-NLS-2$
		realURL = urlString.replace("\\", "/"); //$NON-NLS-1$ //$NON-NLS-2$

		InputStream inputStream = null;

		if (realURL.startsWith("platform:/resource/")) { //$NON-NLS-1$
			try {
				URL url = new URL(realURL);
				inputStream = url.openConnection().getInputStream();
			} catch (MalformedURLException e) {
				Activator.getLogHelper().error("The link of the file '" + urlString + "' is not correct", e); //$NON-NLS-1$ //$NON-NLS-2$
			} catch (IOException e) {
				Activator.getLogHelper().error(e);
			}
		} else {
			try {
				inputStream = new FileInputStream(realURL);
			} catch (FileNotFoundException e) {
				Activator.getLogHelper().error("The link of the file '" + urlString + "' is not correct", e); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return inputStream;
	}

	/**
	 * This allows to get the output stream corresponding to a file.
	 * 
	 * @param urlString
	 *            The url corresponding to the string.
	 * @return The output stream corresponding to the url.
	 */
	public static OutputStream getOutputStream(final String urlString) {
		String realURL = urlString.replace("\\\\", "/"); //$NON-NLS-1$ //$NON-NLS-2$
		realURL = urlString.replace("\\", "/"); //$NON-NLS-1$ //$NON-NLS-2$

		OutputStream outputStream = null;

		if (realURL.startsWith("platform:/resource/")) { //$NON-NLS-1$
			try {
				URL url = new URL(realURL);
				outputStream = url.openConnection().getOutputStream();
			} catch (MalformedURLException e) {
				Activator.getLogHelper().error("The link of the file '" + urlString + "' is not correct", e); //$NON-NLS-1$ //$NON-NLS-2$
			} catch (IOException e) {
				Activator.getLogHelper().error(e);
			}
		} else {
			try {
				outputStream = new FileOutputStream(realURL);
			} catch (FileNotFoundException e) {
				Activator.getLogHelper().error("The link of the file '" + urlString + "' is not correct", e); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return outputStream;
	}

	/**
	 * This allows to refresh a project where a file (specified by its file name) is available.
	 * 
	 * @param fileName
	 *            The file name of file which is in the project to refresh or <code>null</code> to refresh all projects.
	 */
	public static void refreshProject(final String fileName) {
		try {
			for (final IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
				if (null == fileName || fileName.isEmpty() || fileName.contains(project.getFullPath().toOSString())) {
					project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				}
			}
		} catch (CoreException e) {
			Activator.getLogHelper().error(e);
		}
	}

	/**
	 * This allows to refresh all projects of workspace.
	 */
	public static void refreshProjects() {
		refreshProject(null);
	}

	/**
	 * This allows to get the corresponding file of the parameter (if this is possible).
	 * 
	 * @param selectedObject
	 *            The initial selected object.
	 * @return The file or <code>null</code>.
	 */
	public static IFile getFile(final Object selectedObject) {
		IFile selectedFile = null;
		if (selectedObject != null) {
			if (selectedObject instanceof IPapyrusFile) {
				for (IResource resource : ((IPapyrusFile) selectedObject).getAssociatedResources()) {
					if ((resource instanceof IFile) && (isUMLFile((IFile) resource))) {
						selectedFile = (IFile) resource;
						break;
					} // else continue
				}
			} else if (selectedObject instanceof EObject) {
				EObject eobject = (EObject) selectedObject;
				selectedFile = WorkspaceSynchronizer.getFile(eobject.eResource());
			} else if (selectedObject instanceof IAdaptable) {
				selectedFile = (IFile) ((IAdaptable) selectedObject).getAdapter(IFile.class); // Can be null
				if (selectedFile == null) {
					EObject eobject = (EObject) ((IAdaptable) selectedObject).getAdapter(EObject.class);
					if (eobject != null) {
						selectedFile = WorkspaceSynchronizer.getFile(eobject.eResource());
					}
				}
			} else if (selectedObject instanceof IFile) {
				selectedFile = (IFile) selectedObject;
			} else {
				// No valid selection
			}

		} else {
			// No valid selection
		}

		return selectedFile;
	}

	/**
	 * Check if this is an UML file.
	 * 
	 * @param file
	 *            The file to check.
	 * @return <code>true</code> if this is an UML file, <code>false</code> otherwise.
	 */
	private static boolean isUMLFile(final IFile file) {
		return "uml".equals(file.getFileExtension()); //$NON-NLS-1$
	}

	/**
	 * This allows to get the root model for a file.
	 * 
	 * @param file
	 *            The file.
	 * @return The root content of the file.
	 */
	public static EObject getRootModel(final IFile file) {
		URI modelURI = URI.createPlatformResourceURI(file.getFullPath().toString(), false);
		if (!"uml".equals(modelURI.fileExtension())) { //$NON-NLS-1$
			modelURI = modelURI.trimFileExtension().appendFileExtension("uml"); //$NON-NLS-1$
		}
		return getRootModel(modelURI);
	}

	/**
	 * This allows to get the root model for an URI.
	 * 
	 * @param modelURI
	 *            The model URI.
	 * @return The root content of the file.
	 */
	public static EObject getRootModel(final URI modelURI) {
		final ModelSet modelSet = new ModelSet();
		final Resource resource = modelSet.getResource(modelURI, true);
		return resource.getContents().get(0);
	}
}
