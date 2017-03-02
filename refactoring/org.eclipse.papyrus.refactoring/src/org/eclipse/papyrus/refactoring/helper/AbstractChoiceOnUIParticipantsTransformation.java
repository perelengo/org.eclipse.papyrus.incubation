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
package org.eclipse.papyrus.refactoring.helper;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.refactoring.messages.Messages;
import org.eclipse.papyrus.refactoring.refactoringOnElement.AbstractTransformationOnElement;
import org.eclipse.papyrus.refactoring.util.PapyrusRefactoringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * This class offers a generic graphical interface which gives the user the possibility to choose the kind of refactoring he wants.
 * He can choose between doing the refactor on:
 * - All the elements of the current Papyrus model
 * - Selected elements on the Papyrus Editor
 */
public abstract class AbstractChoiceOnUIParticipantsTransformation extends AbstractTransformationOnElement {

	/** Combobox containing the scope of the transformation to execute */
	protected Combo fSelectParticipants;

	private static final int ALL_MODEL_REFACTOR = 0;

	private static final int SELECTED_ELEMENTS_REFACTOR = 1;

	/**
	 * Constructor.
	 *
	 * @param label
	 *            The name of the user input page (name of the transformation)
	 */
	public AbstractChoiceOnUIParticipantsTransformation(String label) {
		super(label);
	}

	/**
	 * Create the specific input of this Papyrus Refactoring Wizard Page
	 *
	 * @param parent
	 */
	public abstract void createContent(Composite parent);


	@Override
	public void createControl(Composite parent) {
		Composite result = new Composite(parent, SWT.NONE);

		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		result.setLayout(layout);
		setControl(result);
		Label label = new Label(result, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		label.setText(Messages.REFACTORINGPAGE_SCOPE_LABEL);

		fSelectParticipants = new Combo(result, SWT.VERTICAL | SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		fSelectParticipants.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false, 1, 1));
		fSelectParticipants.add(Messages.REFACTORINGPAGE_SCOPE_MODEL);
		fSelectParticipants.add(Messages.REFACTORINGPAGE_SCOPE_SELECTION);
		// Default selection
		fSelectParticipants.select(ALL_MODEL_REFACTOR);


		Composite composite = new Composite(result, SWT.NONE);
		GridLayout layout2 = new GridLayout();
		layout2.numColumns = 1;
		composite.setLayout(layout2);

		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		data.verticalIndent = 8;
		composite.setLayoutData(data);

		createContent(composite);

	}

	/**
	 * @see org.eclipse.papyrus.refactoring.refactoringOnElement.AbstractTransformationOnElement#getElementsListToTransform()
	 *
	 * @return
	 * 		The elements found inside the scope of the transformation
	 */
	@Override
	public Collection<EObject> getElementsListToTransform() {
		if (fSelectParticipants.getSelectionIndex() == ALL_MODEL_REFACTOR) {
			return PapyrusRefactoringUtils.getAllElements(fModelSet);
		} else if (fSelectParticipants.getSelectionIndex() == SELECTED_ELEMENTS_REFACTOR) {
			return PapyrusRefactoringUtils.getSelectedElements(fModelSet);
		}
		return null;
	}

}
