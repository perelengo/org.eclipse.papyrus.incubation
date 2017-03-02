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
import org.eclipse.papyrus.refactoring.refactoringOnElement.AbstractTransformationOnElement;
import org.eclipse.papyrus.refactoring.util.PapyrusRefactoringUtils;


/**
 * Clients who want to implement a Papyrus Refactoring which affects only the selected elements by the user may override this class.
 * By overriding this class you don't need to override {@link #getElementsListToTransform()}
 * 
 */
public abstract class AbstractSelectedElementsTransformation extends AbstractTransformationOnElement {

	/**
	 * Constructor.
	 *
	 * @param label
	 *            The name of the user input page (name of the transformation)
	 */
	public AbstractSelectedElementsTransformation(String label) {
		super(label);
	}

	@Override
	public Collection<EObject> getElementsListToTransform() {
		return PapyrusRefactoringUtils.getSelectedElements(fModelSet);
	}


}
