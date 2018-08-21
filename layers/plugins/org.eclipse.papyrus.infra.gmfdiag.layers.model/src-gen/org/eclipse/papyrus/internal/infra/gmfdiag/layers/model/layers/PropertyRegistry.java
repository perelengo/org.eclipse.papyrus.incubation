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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#getTypeRegistry <em>Type Registry</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#getPropertiesCount <em>Properties Count</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getPropertyRegistry()
 * @model
 * @generated
 */
public interface PropertyRegistry extends EObject {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getPropertyRegistry_Properties()
	 * @model containment="true"
	 * @generated
	 */
	List<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Type Registry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Registry</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Registry</em>' containment reference.
	 * @see #setTypeRegistry(TypeRegistry)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getPropertyRegistry_TypeRegistry()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	TypeRegistry getTypeRegistry();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#getTypeRegistry <em>Type Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Registry</em>' containment reference.
	 * @see #getTypeRegistry()
	 * @generated
	 */
	void setTypeRegistry(TypeRegistry value);

	/**
	 * Returns the value of the '<em><b>Properties Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties Count</em>' attribute.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getPropertyRegistry_PropertiesCount()
	 * @model dataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.int" required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	int getPropertiesCount();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.int" required="true" ordered="false" exceptions="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NotFoundException" propertyNameDataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" propertyNameRequired="true" propertyNameOrdered="false"
	 * @generated
	 */
	int getPropertyIndex(String propertyName) throws NotFoundException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exceptions="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NotFoundException" propertyNameDataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" propertyNameRequired="true" propertyNameOrdered="false"
	 * @generated
	 */
	Property getProperty(String propertyName) throws NotFoundException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model propertyRequired="true" propertyOrdered="false"
	 * @generated
	 */
	void addProperty(Property property);

} // PropertyRegistry
