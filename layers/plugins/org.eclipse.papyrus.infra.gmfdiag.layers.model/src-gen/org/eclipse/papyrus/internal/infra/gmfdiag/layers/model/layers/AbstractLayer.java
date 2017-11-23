/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Layer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getPropertyValues <em>Property Values</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getPropertyValueMap <em>Property Value Map</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getLayerDescriptor <em>Layer Descriptor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getViews <em>Views</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getAttachedProperties <em>Attached Properties</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getAbstractLayer()
 * @model abstract="true"
 * @generated
 */
public interface AbstractLayer extends LayerExpression {
	/**
	 * Returns the value of the '<em><b>Property Values</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Values</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Values</em>' reference list.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getAbstractLayer_PropertyValues()
	 * @model
	 * @generated
	 */
	EList<TypeInstance> getPropertyValues();

	/**
	 * Returns the value of the '<em><b>Property Value Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Value Map</em>' map isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Value Map</em>' map.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getAbstractLayer_PropertyValueMap()
	 * @model mapType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StringToTypeInstanceMap&lt;org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance&gt;" ordered="false"
	 * @generated
	 */
	EMap<String, TypeInstance> getPropertyValueMap();

	/**
	 * Returns the value of the '<em><b>Layer Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Descriptor</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Descriptor</em>' reference.
	 * @see #setLayerDescriptor(LayerDescriptor)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getAbstractLayer_LayerDescriptor()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	LayerDescriptor getLayerDescriptor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getLayerDescriptor <em>Layer Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Descriptor</em>' reference.
	 * @see #getLayerDescriptor()
	 * @generated
	 */
	void setLayerDescriptor(LayerDescriptor value);

	/**
	 * Returns the value of the '<em><b>Views</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.runtime.notation.View}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Views</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views</em>' reference list.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getAbstractLayer_Views()
	 * @model ordered="false"
	 * @generated
	 */
	EList<View> getViews();

	/**
	 * Returns the value of the '<em><b>Attached Properties</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attached Properties</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attached Properties</em>' reference list.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getAbstractLayer_AttachedProperties()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Property> getAttachedProperties();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exceptions="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersException" propertyRequired="true" propertyOrdered="false"
	 * @generated
	 */
	TypeInstance addPropertyInstance(Property property) throws LayersException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model propertyRequired="true" propertyOrdered="false"
	 * @generated
	 */
	void removePropertyInstance(Property property);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exceptions="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersException" propertyRequired="true" propertyOrdered="false"
	 * @generated
	 */
	TypeInstance getPropertyInstance(Property property) throws LayersException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exceptions="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersException" propertyDataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" propertyRequired="true" propertyOrdered="false"
	 * @generated
	 */
	TypeInstance getPropertyInstance(String property) throws LayersException;

} // AbstractLayer
