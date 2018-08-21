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

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Operator Descriptor Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getDescriptors <em>Descriptors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getPropertyOperators <em>Property Operators</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getPropertyCollectionSize <em>Property Collection Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getDefaultOperator <em>Default Operator</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getLayerOperatorDescriptorRegistry()
 * @model
 * @generated
 */
public interface LayerOperatorDescriptorRegistry extends EObject {
	/**
	 * Returns the value of the '<em><b>Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptors</em>' containment reference list.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getLayerOperatorDescriptorRegistry_Descriptors()
	 * @model containment="true" transient="true" ordered="false"
	 * @generated
	 */
	List<LayerOperatorDescriptor> getDescriptors();

	/**
	 * Returns the value of the '<em><b>Property Operators</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Operators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Operators</em>' containment reference list.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getLayerOperatorDescriptorRegistry_PropertyOperators()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	List<PropertyOperator> getPropertyOperators();

	/**
	 * Returns the value of the '<em><b>Property Collection Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Collection Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Collection Size</em>' attribute.
	 * @see #setPropertyCollectionSize(int)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getLayerOperatorDescriptorRegistry_PropertyCollectionSize()
	 * @model dataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.int" required="true" ordered="false"
	 * @generated
	 */
	int getPropertyCollectionSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getPropertyCollectionSize <em>Property Collection Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Collection Size</em>' attribute.
	 * @see #getPropertyCollectionSize()
	 * @generated
	 */
	void setPropertyCollectionSize(int value);

	/**
	 * Returns the value of the '<em><b>Default Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Operator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Operator</em>' reference.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getLayerOperatorDescriptorRegistry_DefaultOperator()
	 * @model required="true" transient="true" changeable="false" ordered="false"
	 * @generated
	 */
	PropertyOperator getDefaultOperator();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model descriptorRequired="true" descriptorOrdered="false"
	 * @generated
	 */
	void addLayerOperatorDescriptor(LayerOperatorDescriptor descriptor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exceptions="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NotFoundException" nameDataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	LayerOperatorDescriptor getLayerOperatorDescriptor(String name) throws NotFoundException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model operatorRequired="true" operatorOrdered="false"
	 * @generated
	 */
	void addPropertyOperator(PropertyOperator operator);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exceptions="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NotFoundException" nameDataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	PropertyOperator getPropertyOperator(String name) throws NotFoundException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NotFoundException" propertyRequired="true" propertyOrdered="false" operatorNameDataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" operatorNameRequired="true" operatorNameOrdered="false" layerDescriptorNameDataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" layerDescriptorNameRequired="true" layerDescriptorNameOrdered="false"
	 * @generated
	 */
	void attachOperatorToDescriptor(Property property, String operatorName, String layerDescriptorName) throws NotFoundException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exceptions="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersException" layerOperatorIDDataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" layerOperatorIDRequired="true" layerOperatorIDOrdered="false"
	 * @generated
	 */
	LayerOperator createLayerOperator(String layerOperatorID) throws LayersException;

} // LayerOperatorDescriptorRegistry
