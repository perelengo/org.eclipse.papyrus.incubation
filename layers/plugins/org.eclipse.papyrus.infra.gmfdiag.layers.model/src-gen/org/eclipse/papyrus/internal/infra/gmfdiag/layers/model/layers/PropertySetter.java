/**
 * Copyright (c) 2013, 2017 CEA LIST & LIFL 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *   Quentin Le Menez quentin.lemenez@cea.fr
 * 
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.notation.View;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Setter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter#getProperty <em>Property</em>}</li>
 * <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter#getPropertyName <em>Property Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getPropertySetter()
 * @model abstract="true"
 * @generated
 */
public interface PropertySetter extends EObject {

	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(Property)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getPropertySetter_Property()
	 * @model ordered="false"
	 * @generated
	 */
	Property getProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(String)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getPropertySetter_PropertyName()
	 * @model dataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @model viewRequired="true" viewOrdered="false" valueRequired="true" valueOrdered="false"
	 * @generated
	 */
	void setValue(View view, TypeInstance value);

} // PropertySetter
