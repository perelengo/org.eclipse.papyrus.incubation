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
package org.eclipse.papyrus.refactoring.refactoringOnElement;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.refactoring.core.AbstractPapyrusTransformation;

/**
 * Clients who want to apply a transformation on a specified list of element should override this class
 *
 */
public abstract class AbstractTransformationOnElement extends AbstractPapyrusTransformation {

	public static final int ALL_MODEL_REFACTOR = 0;
	public static final int SELECTED_ELEMENTS_REFACTOR = 1;

	/**
	 * Constructor.
	 *
	 * @param label
	 *            The name of the user input page (name of the transformation)
	 */
	public AbstractTransformationOnElement(String label) {
		super(label);
	}


	@Override
	public void execute(ModelSet modelSetToTransform) {
		if (fElementToTransform != null) {
			// TODO return a status if the operations resulting in the mutation cannot be done
			// e.g. an association in an artifact
			transformElement(fElementToTransform);
		}
	}

	/** Return the list of elements which may be affected by the refactoring */
	public abstract Collection<EObject> getElementsListToTransform();

	/** @return The implementation of {@link ITransformationOnElement} */
	public abstract ITransformationOnElement getTransformationOnElement();

	/**
	 * 
	 * @param elementToTransform
	 *            the element that will be transformed.
	 */
	private void transformElement(EObject elementToTransform) {
		ITransformationOnElement refactoring = getTransformationOnElement();
		refactoring.transformationToExecute(elementToTransform);
	}

	@Override
	public void setElementToTransform(EObject elementToTransform) {
		fElementToTransform = elementToTransform;
	}

}
