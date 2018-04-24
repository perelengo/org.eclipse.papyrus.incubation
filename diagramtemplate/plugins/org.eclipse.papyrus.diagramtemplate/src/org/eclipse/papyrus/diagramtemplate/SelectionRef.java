/*****************************************************************************
 * Copyright (c) 2010, 2018 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Florian Noyrit florian.noyrit@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagramtemplate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.diagramtemplate.SelectionRef#getEReference <em>EReference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getSelectionRef()
 * @model
 * @generated
 */
public interface SelectionRef extends AbstractSelection {
	/**
	 * Returns the value of the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EReference</em>' reference.
	 * @see #setEReference(EObject)
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getSelectionRef_EReference()
	 * @model
	 * @generated
	 */
	EObject getEReference();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.diagramtemplate.SelectionRef#getEReference <em>EReference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>EReference</em>' reference.
	 * @see #getEReference()
	 * @generated
	 */
	void setEReference(EObject value);

} // SelectionRef
