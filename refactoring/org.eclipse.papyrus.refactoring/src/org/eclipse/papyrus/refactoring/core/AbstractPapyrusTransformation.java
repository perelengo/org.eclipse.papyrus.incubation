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
package org.eclipse.papyrus.refactoring.core;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.swt.widgets.Composite;

/**
 * Class to be subclassed by clients who want to implement their own refactoring.
 * Represents a specific transformation in the Papyrus refactoring tool.
 * 
 * <p>
 * The {@link #checkFinalConditions} method is called when the 'OK' or 'Preview' button is pressed. If the requested conditions for executing
 * this transformation are fulfilled the {@link #execute} method is called.
 * </p>
 * 
 * @see org.eclipse.ltk.core.refactoring.RefactoringStatus
 * @see org.eclipse.jface.wizard.IWizardPage
 */
public abstract class AbstractPapyrusTransformation extends UserInputWizardPage {

	/** The {@link ModelSet} on which the transformation will be done. */
	protected ModelSet fModelSet;

	/** The element selected to transform */
	protected EObject fElementToTransform;

	/**
	 * Constructor.
	 *
	 * @param label
	 *            The label provided to the transformation
	 */
	public AbstractPapyrusTransformation(String label) {
		super(label);

	}

	/**
	 * Check the conditions before opening the UI page of this refactoring.
	 * The default status is 'OK'. Clients may override this method if they have some initial conditions to check.
	 * 
	 * @return refactoring status if the initial conditions are fulfilled or not. If the status is <code>RefactoringStatus#FATAL</code>
	 *         the refactoring is considered as not being executable.
	 */
	public RefactoringStatus checkInitialConditions() {
		return new RefactoringStatus();
	}

	/**
	 * Checks if all conditions for executing this transformation are fulfilled. This method is called after the {@link #checkInitialConditions},
	 * when the 'OK' or 'Preview' button is pressed to check if we can execute the transformation.
	 * 
	 * @return refactoring status if the final conditions are fulfilled or not.If the status is <code>RefactoringStatus#FATAL</code>
	 *         the refactoring is considered as not being executable.
	 */
	public abstract RefactoringStatus checkFinalConditions();

	/**
	 * 
	 */
	/**
	 * Method where the source code of the transformation has to be implemented.
	 * If all conditions are fulfilled this method is called to execute this Papyrus transformation.
	 * The transformation has to be done on modelSetToTransform parameter (which is an instance of ModelSet).
	 * 
	 * @param modelSetToTransform
	 */
	public abstract void execute(ModelSet modelSetToTransform);

	/**
	 * Construct the UI for this transformation
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 *            The shell in which to create it
	 */
	@Override
	public abstract void createControl(Composite parent);



	/**
	 * @return true if it is possible to launch the refactoring, false otherwise.
	 */
	public boolean isEnable() {
		if (checkInitialConditions().getSeverity() == RefactoringStatus.OK) {
			return true;
		}
		return false;
	}

	/**
	 * Set the modelSet in order to fetch it later
	 * 
	 * @param modelSet
	 */
	public void setModelSet(ModelSet modelSet) {
		fModelSet = modelSet;
	}

	/**
	 * Set the element to transform in order to fetch it later
	 * 
	 * @param elementToTransform
	 */
	public void setElementToTransform(EObject elementToTransform) {
		fElementToTransform = elementToTransform;
	}

}
