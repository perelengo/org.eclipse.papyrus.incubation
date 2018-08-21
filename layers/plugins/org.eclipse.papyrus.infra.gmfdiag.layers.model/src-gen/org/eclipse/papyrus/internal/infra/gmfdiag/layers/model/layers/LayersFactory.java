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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage
 * @generated
 */
public interface LayersFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayersFactory eINSTANCE = org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Layer Named Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Named Style</em>'.
	 * @generated
	 */
	LayerNamedStyle createLayerNamedStyle();

	/**
	 * Returns a new object of class '<em>Stack</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stack</em>'.
	 * @generated
	 */
	LayersStack createLayersStack();

	/**
	 * Returns a new object of class '<em>Stack Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stack Application</em>'.
	 * @generated
	 */
	LayersStackApplication createLayersStackApplication();

	/**
	 * Returns a new object of class '<em>Layer Stack Descriptor Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Stack Descriptor Registry</em>'.
	 * @generated
	 */
	LayerStackDescriptorRegistry createLayerStackDescriptorRegistry();

	/**
	 * Returns a new object of class '<em>Property Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Registry</em>'.
	 * @generated
	 */
	PropertyRegistry createPropertyRegistry();

	/**
	 * Returns a new object of class '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	Property createProperty();

	/**
	 * Returns a new object of class '<em>Type Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Registry</em>'.
	 * @generated
	 */
	TypeRegistry createTypeRegistry();

	/**
	 * Returns a new object of class '<em>Layer Descriptor Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Descriptor Registry</em>'.
	 * @generated
	 */
	LayerDescriptorRegistry createLayerDescriptorRegistry();

	/**
	 * Returns a new object of class '<em>Layer Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Descriptor</em>'.
	 * @generated
	 */
	LayerDescriptor createLayerDescriptor();

	/**
	 * Returns a new object of class '<em>Layer Application Factory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Application Factory</em>'.
	 * @generated
	 */
	LayerApplicationFactory createLayerApplicationFactory();

	/**
	 * Returns a new object of class '<em>Property Setter Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Setter Registry</em>'.
	 * @generated
	 */
	PropertySetterRegistry createPropertySetterRegistry();

	/**
	 * Returns a new object of class '<em>Layer Operator Descriptor Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Operator Descriptor Registry</em>'.
	 * @generated
	 */
	LayerOperatorDescriptorRegistry createLayerOperatorDescriptorRegistry();

	/**
	 * Returns a new object of class '<em>Layer Operator Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Operator Descriptor</em>'.
	 * @generated
	 */
	LayerOperatorDescriptor createLayerOperatorDescriptor();

	/**
	 * Returns a new object of class '<em>Property Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Operator</em>'.
	 * @generated
	 */
	PropertyOperator createPropertyOperator();

	/**
	 * Returns a new object of class '<em>Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Folder</em>'.
	 * @generated
	 */
	Folder createFolder();

	/**
	 * Returns a new object of class '<em>Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metamodel</em>'.
	 * @generated
	 */
	Metamodel createMetamodel();

	/**
	 * Returns a new object of class '<em>Top Layer Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Layer Operator</em>'.
	 * @generated
	 */
	TopLayerOperator createTopLayerOperator();

	/**
	 * Returns a new object of class '<em>Stacked Layer Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stacked Layer Operator</em>'.
	 * @generated
	 */
	StackedLayerOperator createStackedLayerOperator();

	/**
	 * Returns a new object of class '<em>Property Index</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Index</em>'.
	 * @generated
	 */
	PropertyIndex createPropertyIndex();

	/**
	 * Returns a new object of class '<em>Simple Layer Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Layer Descriptor</em>'.
	 * @generated
	 */
	SimpleLayerDescriptor createSimpleLayerDescriptor();

	/**
	 * Returns a new object of class '<em>Null Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Instance</em>'.
	 * @generated
	 */
	NullInstance createNullInstance();

	/**
	 * Returns a new object of class '<em>Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer</em>'.
	 * @generated
	 */
	Layer createLayer();

	/**
	 * Returns a new object of class '<em>Null Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Property Setter</em>'.
	 * @generated
	 */
	NullPropertySetter createNullPropertySetter();

	/**
	 * Returns a new object of class '<em>Top Layer Operator Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Layer Operator Descriptor</em>'.
	 * @generated
	 */
	TopLayerOperatorDescriptor createTopLayerOperatorDescriptor();

	/**
	 * Returns a new object of class '<em>Stacked Layer Operator Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stacked Layer Operator Descriptor</em>'.
	 * @generated
	 */
	StackedLayerOperatorDescriptor createStackedLayerOperatorDescriptor();

	/**
	 * Returns a new object of class '<em>All Views Derived Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All Views Derived Layer</em>'.
	 * @generated
	 */
	AllViewsDerivedLayer createAllViewsDerivedLayer();

	/**
	 * Returns a new object of class '<em>CSS Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CSS Property Setter</em>'.
	 * @generated
	 */
	CSSPropertySetter createCSSPropertySetter();

	/**
	 * Returns a new object of class '<em>CSS Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CSS Type</em>'.
	 * @generated
	 */
	CSSType createCSSType();

	/**
	 * Returns a new object of class '<em>CSS Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CSS Instance</em>'.
	 * @generated
	 */
	CSSInstance createCSSInstance();

	/**
	 * Returns a new object of class '<em>CSS Hide Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CSS Hide Property Setter</em>'.
	 * @generated
	 */
	CSSHidePropertySetter createCSSHidePropertySetter();

	/**
	 * Returns a new object of class '<em>CSS Hide Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CSS Hide Type</em>'.
	 * @generated
	 */
	CSSHideType createCSSHideType();

	/**
	 * Returns a new object of class '<em>CSS Hide Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CSS Hide Instance</em>'.
	 * @generated
	 */
	CSSHideInstance createCSSHideInstance();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LayersPackage getLayersPackage();

} //LayersFactory
