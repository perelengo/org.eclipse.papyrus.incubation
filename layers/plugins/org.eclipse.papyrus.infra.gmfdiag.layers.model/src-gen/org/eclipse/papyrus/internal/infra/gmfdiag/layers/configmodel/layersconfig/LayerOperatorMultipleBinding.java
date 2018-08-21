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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Operator Multiple Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayerOperatorMultipleBinding#getLayerOperatorConfig <em>Layer Operator Config</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayerOperatorMultipleBinding#getBindings <em>Bindings</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayersConfigPackage#getLayerOperatorMultipleBinding()
 * @model
 * @generated
 */
public interface LayerOperatorMultipleBinding extends FolderElement {
	/**
	 * Returns the value of the '<em><b>Layer Operator Config</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Operator Config</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Operator Config</em>' reference.
	 * @see #setLayerOperatorConfig(LayerOperatorConfig)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayersConfigPackage#getLayerOperatorMultipleBinding_LayerOperatorConfig()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	LayerOperatorConfig getLayerOperatorConfig();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayerOperatorMultipleBinding#getLayerOperatorConfig <em>Layer Operator Config</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Operator Config</em>' reference.
	 * @see #getLayerOperatorConfig()
	 * @generated
	 */
	void setLayerOperatorConfig(LayerOperatorConfig value);

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.OperatorBinding}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.OperatorBinding#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayersConfigPackage#getLayerOperatorMultipleBinding_Bindings()
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.OperatorBinding#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	List<OperatorBinding> getBindings();

} // LayerOperatorMultipleBinding
