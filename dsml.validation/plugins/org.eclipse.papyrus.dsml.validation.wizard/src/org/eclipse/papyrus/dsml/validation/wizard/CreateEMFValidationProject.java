/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - modification
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.wizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsManager;
import org.eclipse.pde.internal.ui.wizards.plugin.NewPluginProjectWizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Profile;

/**
 * This class represents the plugin project wizard and triggers creation of an
 * EMF Validation plugin when user clicks finish button on a plugin creation
 * wizard.
 *
 *
 */
@SuppressWarnings("restriction")
public class CreateEMFValidationProject extends NewPluginProjectWizard {

	private static final String GENERATION_MESSAGE = "Generation of EMF Validation Plugin";

	private IConstraintsManager constraintsManager;

	private JavaContentGenerator generateAllJava;


	protected Profile selectedProfile;

	protected EPackage definition = null;

	protected IProject createdProject;
	
	/**
	 *
	 * Constructor.
	 *
	 * @param selectedProfile
	 * @param constraintsExtractor
	 */
	public CreateEMFValidationProject(Profile selectedProfile, IConstraintsManager constraintsExtractor, EPackage definition) {
		super();
		setWindowTitle(GENERATION_MESSAGE);
		this.constraintsManager = constraintsExtractor;
		this.selectedProfile = selectedProfile;
		this.definition = definition;
		createdProject = null;
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page == fContentPage) { // Remove the template page
			return null;
		}
		return super.getNextPage(page);
	}

	@Override
	public void addPages() {
		super.addPages();
	}

	/**
	 * @return The project created by this wizard
	 */
	public IProject getProject() {
		return createdProject;
	}
	
	/**
	 * run the dialog
	 */
	public int openDialog() {
		WizardDialog dialog = new WizardDialog(Display.getDefault().getActiveShell(), this);
		return dialog.open();
	}

	@Override
	public boolean performFinish() {
		boolean result = super.performFinish();
		if (result) {
			createdProject = this.fMainPage.getProjectHandle();
		}
		return result;
	}
}
