/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr modification
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.generation.ui;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.dsml.validation.model.elements.impl.ConstraintManagerImpl;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsManager;
import org.eclipse.papyrus.dsml.validation.model.profilenames.Utils;
import org.eclipse.papyrus.dsml.validation.wizard.CreateEMFValidationProject;
import org.eclipse.papyrus.dsml.validation.wizard.JavaContentGenerator;
import org.eclipse.papyrus.dsml.validation.wizard.ValidationPluginGenerator;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;
import org.eclipse.uml2.uml.Profile;


/**
 * this handler launch the creation of the plugin to validate contraints of the profile
 *
 */
public class CreateJavaValidationPluginHandler extends AbstractHandler {

	private IConstraintsManager constraintsManager;


	/**
	 * <pre>
	 * Get the selected element, the first selected element if several are selected or null
	 * if no selection or the selection is not an {@link EObject}.
	 * 
	 * @return selected {@link EObject} or null
	 * </pre>
	 *
	 */
	protected EObject getSelectedElement() {
		EObject eObject = null;
		Object selection = null;

		// Get current selection
		selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

		// Get first element if the selection is an IStructuredSelection
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			selection = structuredSelection.getFirstElement();
		}

		// Treat non-null selected object (try to adapt and return EObject)
		if (selection != null) {

			eObject = EMFHelper.getEObject(selection);
		}
		return eObject;
	}


	/**
	 *
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return null
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EObject selection = getSelectedElement();

		if (selection instanceof Profile) {
			Profile profileSelection = (Profile) selection;

			constraintsManager = new ConstraintManagerImpl(profileSelection);
			EPackage definition = null;

			IProject hostingProject = null;		// project that is hosting the profile
			URI uri = profileSelection.eResource().getURI();

			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			if (uri.segmentCount() >= 2) {
				hostingProject = root.getProject(uri.segment(1));
			}
			IProject targetProject = null;
			Shell shell = Display.getDefault().getActiveShell();

			boolean isPlugin = false;
			try {
				isPlugin = hostingProject.getNature("org.eclipse.pde.PluginNature") != null; //$NON-NLS-1$
				if (!isPlugin) {
					// hosting project is not a plugin
					MessageDialog.openWarning(shell, Messages.CreateJavaValidationPluginHandler_ProfileIsNotAPlugin, String.format(Messages.CreateJavaValidationPluginHandler_ProfileIsNotAPluginExplication, hostingProject.getName()));
				}
			}
			catch (CoreException e) {
				Activator.log.error(e);
			}
		
			int question = 0;
			if ((hostingProject != null) && hostingProject.exists() && isPlugin) {
				MessageDialog dialog = new MessageDialog(shell,
						Messages.CreateJavaValidationPluginHandler_ChoosePluginGeneration, null,
						Messages.CreateJavaValidationPluginHandler_HowtoGeneratePlugin, MessageDialog.QUESTION,
						new String[] { Messages.CreateJavaValidationPluginHandler_CreateNewPlugin, Messages.CreateJavaValidationPluginHandler_SelectExisting, Messages.CreateJavaValidationPluginHandler_HostCurrent }, 2);
				question = dialog.open();
			}
			else if (root.getProjects().length > 0) {
				MessageDialog dialog = new MessageDialog(shell,
						Messages.CreateJavaValidationPluginHandler_ChoosePluginGeneration, null,
						Messages.CreateJavaValidationPluginHandler_HowtoGeneratePlugin, MessageDialog.QUESTION,
						new String[] { Messages.CreateJavaValidationPluginHandler_CreateNewPlugin, Messages.CreateJavaValidationPluginHandler_SelectExisting }, 1);
				question = dialog.open();
			}

			boolean verboseDependency = true;

			if ((question == 1) || (question == 2)) {
				if (question == 1) {
					// get object which represents the workspace

					ResourceListSelectionDialog dialog =
						    new ResourceListSelectionDialog(shell, root, IResource.PROJECT);
					dialog.setTitle(Messages.CreateJavaValidationPluginHandler_SelectExisting);
				
					if (dialog.open() == Window.OK) {
						targetProject = (IProject) dialog.getResult()[0];
					}
				}
				else {
					targetProject = hostingProject;
				}
			}
			else if (question == 0) {

				CreateEMFValidationProject wizard = new CreateEMFValidationProject(profileSelection, constraintsManager, definition);
				if (wizard.openDialog() == Window.OK) {
					targetProject = wizard.getProject();
				}
				// don't create a dialog for added dependency (since the project is new, this information is not useful)
				verboseDependency = false;
			}
			if (targetProject != null) {
				// generate java code
				JavaContentGenerator generateAllJava = new JavaContentGenerator(targetProject, profileSelection);
				try {
					generateAllJava.run();
					// generate plugin + extension point
					ValidationPluginGenerator.instance.generate(targetProject, constraintsManager, definition);
					addDependencyToProject(shell, hostingProject, ValidationPluginGenerator.UML_DSML_VALIDATION_PROFILE_PLUGIN, true);
					if (Utils.isStaticProfile()) {
						// add dependency to existing project (project hosting the static profile)
						addDependencyToProject(shell, targetProject, hostingProject.getName(), verboseDependency);
					}
				} catch (Exception e) {
					Activator.log.error(e);
					MessageDialog.openInformation(shell, Messages.CreateJavaValidationPluginHandler_ExceptionDuringPluginGeneration, Messages.CreateJavaValidationPluginHandler_CheckErrorLog);
				}
			}
		}
		return null;
	}

	/**
	 * @param shell An active shell
	 * @param dependingProject the project that will host the validation constraints
	 * @param dependsOnPlugin the name of the plugin on which it depends
	 * @param verbose if true, create a shell message
	 * @throws CoreException
	 * @throws IOException
	 */
	public void addDependencyToProject(Shell shell, IProject dependingProject, String dependsOnPlugin, boolean verbose) throws CoreException, IOException {
		if (ValidationPluginGenerator.instance.addDependency(dependingProject, dependsOnPlugin)) {
			if (verbose) {
				String message = Messages.CreateJavaValidationPluginHandler_DependencyAddedMsg;
				if (dependsOnPlugin.equals(ValidationPluginGenerator.UML_DSML_VALIDATION_PROFILE_PLUGIN)) {
					message += " " + Messages.CreateJavaValidationPluginHandler_DSMLDependencyAddedMsg; //$NON-NLS-1$
				}
				MessageDialog.openInformation(shell, Messages.CreateJavaValidationPluginHandler_DependencyAdded,
						String.format(message, dependsOnPlugin, dependingProject.getName()));
			}
		}
	}
	
	@Override
	public boolean isEnabled() {
		EObject eObject = getSelectedElement();
		if (eObject instanceof Profile) {
			return true;
		}
		return false;
	}

}
