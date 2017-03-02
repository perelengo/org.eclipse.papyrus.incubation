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

import org.eclipse.emf.ecore.EObject;

/**
 * Interface to be implemented by clients who override {@link AbstractTransformationOnElement}
 *
 */
public abstract interface ITransformationOnElement {


	/**
	 * Runs the transformation using the given element.
	 * 
	 * @param element
	 *            the {@link EObject} on which the transformation will be done.
	 */
	public void transformationToExecute(EObject element);


}
