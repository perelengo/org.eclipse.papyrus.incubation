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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator#getLayers <em>Layers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator#getLayerOperatorDescriptorName <em>Layer Operator Descriptor Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator#getLayerOperatorDescriptor <em>Layer Operator Descriptor</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getLayerOperator()
 * @model abstract="true"
 * @generated
 */
public interface LayerOperator extends LayerExpression, LayersContainer {
	/**
	 * Returns the value of the '<em><b>Layers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layers</em>' containment reference list.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getLayerOperator_Layers()
	 * @model containment="true"
	 * @generated
	 */
	List<LayerExpression> getLayers();

	/**
	 * Returns the value of the '<em><b>Layer Operator Descriptor Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Operator Descriptor Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Operator Descriptor Name</em>' attribute.
	 * @see #setLayerOperatorDescriptorName(String)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getLayerOperator_LayerOperatorDescriptorName()
	 * @model dataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getLayerOperatorDescriptorName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator#getLayerOperatorDescriptorName <em>Layer Operator Descriptor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Operator Descriptor Name</em>' attribute.
	 * @see #getLayerOperatorDescriptorName()
	 * @generated
	 */
	void setLayerOperatorDescriptorName(String value);

	/**
	 * Returns the value of the '<em><b>Layer Operator Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Operator Descriptor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Operator Descriptor</em>' reference.
	 * @see #setLayerOperatorDescriptor(LayerOperatorDescriptor)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getLayerOperator_LayerOperatorDescriptor()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	LayerOperatorDescriptor getLayerOperatorDescriptor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator#getLayerOperatorDescriptor <em>Layer Operator Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Operator Descriptor</em>' reference.
	 * @see #getLayerOperatorDescriptor()
	 * @generated
	 */
	void setLayerOperatorDescriptor(LayerOperatorDescriptor value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isDescriptorSet();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void resetDescriptor();

} // LayerOperator
