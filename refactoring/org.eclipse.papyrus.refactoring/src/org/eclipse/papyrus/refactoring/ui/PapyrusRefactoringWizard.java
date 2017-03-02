/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.refactoring.ui;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.papyrus.refactoring.Activator;
import org.eclipse.papyrus.refactoring.core.PapyrusRefactoring;

/**
 * {@link RefactoringWizard} for Papyrus Refactoring
 * 
 * @noextend This class is not intended to be extended by clients.
 */
public class PapyrusRefactoringWizard extends RefactoringWizard {


	/**
	 * Constructor.
	 *
	 * @param refactoring
	 *            The refactoring linked to this wizard (replace, mutate, ...)
	 * @param pageTitle
	 *            The default page title
	 */
	public PapyrusRefactoringWizard(PapyrusRefactoring refactoring, String pageTitle) {
		super(refactoring, DIALOG_BASED_USER_INTERFACE | SHOW_HELP_CONTROL);
		setDefaultPageTitle(pageTitle);
		// Window.setDefaultImage(Activator.shellImage);
	}

	@Override
	protected void addUserInputPages() {
		// Adds the user page built with the tranformation by default
		addPage(((PapyrusRefactoring) getRefactoring()).getPapyrusTransformation());
	}

	@Override
	public void setContainer(IWizardContainer wizardContainer) {
		// Used to deactivate the Help button until the help is created
		super.setContainer(wizardContainer);
		if (getContainer() instanceof TrayDialog) {
			((TrayDialog) getContainer()).setHelpAvailable(false);
		}
	}

}
