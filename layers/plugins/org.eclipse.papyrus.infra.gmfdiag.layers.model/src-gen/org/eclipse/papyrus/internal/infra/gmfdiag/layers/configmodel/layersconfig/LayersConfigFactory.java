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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayersConfigPackage
 * @generated
 */
public interface LayersConfigFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayersConfigFactory eINSTANCE = org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl.LayersConfigFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Folder</em>'.
	 * @generated
	 */
	Folder createFolder();

	/**
	 * Returns a new object of class '<em>Layer Operator Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Operator Config</em>'.
	 * @generated
	 */
	LayerOperatorConfig createLayerOperatorConfig();

	/**
	 * Returns a new object of class '<em>Operator Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operator Config</em>'.
	 * @generated
	 */
	OperatorConfig createOperatorConfig();

	/**
	 * Returns a new object of class '<em>Property Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Id</em>'.
	 * @generated
	 */
	PropertyId createPropertyId();

	/**
	 * Returns a new object of class '<em>Type Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Config</em>'.
	 * @generated
	 */
	TypeConfig createTypeConfig();

	/**
	 * Returns a new object of class '<em>Layer Operator Multiple Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Operator Multiple Binding</em>'.
	 * @generated
	 */
	LayerOperatorMultipleBinding createLayerOperatorMultipleBinding();

	/**
	 * Returns a new object of class '<em>Operator Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operator Binding</em>'.
	 * @generated
	 */
	OperatorBinding createOperatorBinding();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LayersConfigPackage getLayersConfigPackage();

} //LayersConfigFactory
