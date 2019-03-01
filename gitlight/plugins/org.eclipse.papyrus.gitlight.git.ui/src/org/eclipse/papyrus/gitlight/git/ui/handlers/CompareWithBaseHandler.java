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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egit.ui.internal.CompareUtils;
import org.eclipse.egit.ui.internal.selection.SelectionUtils;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.papyrus.gitlight.git.ui.Activator;
import org.eclipse.papyrus.gitlight.git.utils.PapyrusFileUtils;
import org.eclipse.papyrus.gitlight.git.utils.GitConstants;
import org.eclipse.papyrus.gitlight.git.utils.GitInstance;
import org.eclipse.papyrus.infra.emf.utils.ResourceUtils;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Element;

/**
 * The handler for the action of compare which allow to compare the branch with the master.
 */
@SuppressWarnings("restriction")
public class CompareWithBaseHandler extends AbstractHandler {

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

				// Get the current git instance and repository
				final Element rootElement = GitInstance.getInstance().getRootElement();

				// Compare the model
				final IWorkbenchPage workBenchPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

				// Get the resources corresponding to the model
				final IPath umlPath = getCurrentUMLPath(rootElement);
				final IFile umlFile = PapyrusFileUtils.getFile(rootElement);
				final IProject project = umlFile.getProject();

				// We need to get the repo from the project because if we get this from the git instance, this one is not the correct one and there is no differences
				final Repository repo = SelectionUtils.getRepositoryOrWarn(new StructuredSelection(project), getShell(event));
				if (null != repo) {
					try {
						// Compare the remote branch with the remote master
						CompareUtils.compare(umlFile, repo, umlPath.toString(), umlPath.toString(), ((Ref) firstElement).getName(), Constants.R_REMOTES + GitConstants.MASTER_REPOSITORY_PATH, false, workBenchPage);
					} catch (final IOException e) {
						Activator.getLogHelper().error(e);
					}
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
	 * Get the current path of the uml file.
	 * 
	 * @param rootElement
	 *            The root element.
	 * @return The path of the uml file.
	 */
	protected IPath getCurrentUMLPath(final Element rootElement) {
		// Get the workspace root location
		final Resource eResource = rootElement.eResource();
		return new Path(ResourceUtils.getFile(eResource).getProject().getName() + "/" + eResource.getURI().lastSegment()); //$NON-NLS-1$
	}
}
