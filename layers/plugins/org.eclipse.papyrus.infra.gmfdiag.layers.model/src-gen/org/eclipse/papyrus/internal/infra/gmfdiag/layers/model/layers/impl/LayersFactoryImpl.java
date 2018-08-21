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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.BadStateException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayersFactoryImpl extends EFactoryImpl implements LayersFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LayersFactory init() {
		try {
			LayersFactory theLayersFactory = (LayersFactory)EPackage.Registry.INSTANCE.getEFactory(LayersPackage.eNS_URI);
			if (theLayersFactory != null) {
				return theLayersFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LayersFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LayersPackage.LAYER_NAMED_STYLE: return createLayerNamedStyle();
			case LayersPackage.LAYERS_STACK: return createLayersStack();
			case LayersPackage.LAYERS_STACK_APPLICATION: return createLayersStackApplication();
			case LayersPackage.LAYER_STACK_DESCRIPTOR_REGISTRY: return createLayerStackDescriptorRegistry();
			case LayersPackage.PROPERTY_REGISTRY: return createPropertyRegistry();
			case LayersPackage.PROPERTY: return createProperty();
			case LayersPackage.TYPE_REGISTRY: return createTypeRegistry();
			case LayersPackage.STRING_TO_TYPE_MAP: return (EObject)createStringToTypeMap();
			case LayersPackage.LAYER_DESCRIPTOR_REGISTRY: return createLayerDescriptorRegistry();
			case LayersPackage.LAYER_DESCRIPTOR: return createLayerDescriptor();
			case LayersPackage.LAYER_APPLICATION_FACTORY: return createLayerApplicationFactory();
			case LayersPackage.PROPERTY_SETTER_REGISTRY: return createPropertySetterRegistry();
			case LayersPackage.STRING_TO_PROPERTY_SETTER: return (EObject)createStringToPropertySetter();
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY: return createLayerOperatorDescriptorRegistry();
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR: return createLayerOperatorDescriptor();
			case LayersPackage.PROPERTY_OPERATOR: return createPropertyOperator();
			case LayersPackage.STRING_TO_TYPE_INSTANCE_MAP: return (EObject)createStringToTypeInstanceMap();
			case LayersPackage.FOLDER: return createFolder();
			case LayersPackage.METAMODEL: return createMetamodel();
			case LayersPackage.TOP_LAYER_OPERATOR: return createTopLayerOperator();
			case LayersPackage.STACKED_LAYER_OPERATOR: return createStackedLayerOperator();
			case LayersPackage.PROPERTY_INDEX: return createPropertyIndex();
			case LayersPackage.STRING_TO_PROPERTY_INDEX_MAP: return (EObject)createStringToPropertyIndexMap();
			case LayersPackage.SIMPLE_LAYER_DESCRIPTOR: return createSimpleLayerDescriptor();
			case LayersPackage.NULL_INSTANCE: return createNullInstance();
			case LayersPackage.LAYER: return createLayer();
			case LayersPackage.NULL_PROPERTY_SETTER: return createNullPropertySetter();
			case LayersPackage.TOP_LAYER_OPERATOR_DESCRIPTOR: return createTopLayerOperatorDescriptor();
			case LayersPackage.STACKED_LAYER_OPERATOR_DESCRIPTOR: return createStackedLayerOperatorDescriptor();
			case LayersPackage.ALL_VIEWS_DERIVED_LAYER: return createAllViewsDerivedLayer();
			case LayersPackage.CSS_PROPERTY_SETTER: return createCSSPropertySetter();
			case LayersPackage.CSS_TYPE: return createCSSType();
			case LayersPackage.CSS_INSTANCE: return createCSSInstance();
			case LayersPackage.CSS_HIDE_PROPERTY_SETTER: return createCSSHidePropertySetter();
			case LayersPackage.CSS_HIDE_TYPE: return createCSSHideType();
			case LayersPackage.CSS_HIDE_INSTANCE: return createCSSHideInstance();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case LayersPackage.LAYER_STATE:
				return createLayerStateFromString(eDataType, initialValue);
			case LayersPackage.EVENT_LEVEL:
				return createEventLevelFromString(eDataType, initialValue);
			case LayersPackage.STRING:
				return createStringFromString(eDataType, initialValue);
			case LayersPackage.LAYERS_EXCEPTION:
				return createLayersExceptionFromString(eDataType, initialValue);
			case LayersPackage.INT:
				return createintFromString(eDataType, initialValue);
			case LayersPackage.BAD_STATE_EXCEPTION:
				return createBadStateExceptionFromString(eDataType, initialValue);
			case LayersPackage.NOT_FOUND_EXCEPTION:
				return createNotFoundExceptionFromString(eDataType, initialValue);
			case LayersPackage.COMPUTE_PROPERTY_VALUE_COMMAND:
				return createComputePropertyValueCommandFromString(eDataType, initialValue);
			case LayersPackage.BOOLEAN:
				return createbooleanFromString(eDataType, initialValue);
			case LayersPackage.EPACKAGE:
				return createEPackageFromString(eDataType, initialValue);
			case LayersPackage.OBJECT:
				return createObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case LayersPackage.LAYER_STATE:
				return convertLayerStateToString(eDataType, instanceValue);
			case LayersPackage.EVENT_LEVEL:
				return convertEventLevelToString(eDataType, instanceValue);
			case LayersPackage.STRING:
				return convertStringToString(eDataType, instanceValue);
			case LayersPackage.LAYERS_EXCEPTION:
				return convertLayersExceptionToString(eDataType, instanceValue);
			case LayersPackage.INT:
				return convertintToString(eDataType, instanceValue);
			case LayersPackage.BAD_STATE_EXCEPTION:
				return convertBadStateExceptionToString(eDataType, instanceValue);
			case LayersPackage.NOT_FOUND_EXCEPTION:
				return convertNotFoundExceptionToString(eDataType, instanceValue);
			case LayersPackage.COMPUTE_PROPERTY_VALUE_COMMAND:
				return convertComputePropertyValueCommandToString(eDataType, instanceValue);
			case LayersPackage.BOOLEAN:
				return convertbooleanToString(eDataType, instanceValue);
			case LayersPackage.EPACKAGE:
				return convertEPackageToString(eDataType, instanceValue);
			case LayersPackage.OBJECT:
				return convertObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerNamedStyle createLayerNamedStyle() {
		LayerNamedStyleImpl layerNamedStyle = new LayerNamedStyleImpl();
		return layerNamedStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersStack createLayersStack() {
		LayersStackImpl layersStack = new LayersStackImpl();
		return layersStack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersStackApplication createLayersStackApplication() {
		LayersStackApplicationImpl layersStackApplication = new LayersStackApplicationImpl();
		return layersStackApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerStackDescriptorRegistry createLayerStackDescriptorRegistry() {
		LayerStackDescriptorRegistryImpl layerStackDescriptorRegistry = new LayerStackDescriptorRegistryImpl();
		return layerStackDescriptorRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyRegistry createPropertyRegistry() {
		PropertyRegistryImpl propertyRegistry = new PropertyRegistryImpl();
		return propertyRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeRegistry createTypeRegistry() {
		TypeRegistryImpl typeRegistry = new TypeRegistryImpl();
		return typeRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Type> createStringToTypeMap() {
		StringToTypeMapImpl stringToTypeMap = new StringToTypeMapImpl();
		return stringToTypeMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerDescriptorRegistry createLayerDescriptorRegistry() {
		LayerDescriptorRegistryImpl layerDescriptorRegistry = new LayerDescriptorRegistryImpl();
		return layerDescriptorRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerDescriptor createLayerDescriptor() {
		LayerDescriptorImpl layerDescriptor = new LayerDescriptorImpl();
		return layerDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerApplicationFactory createLayerApplicationFactory() {
		LayerApplicationFactoryImpl layerApplicationFactory = new LayerApplicationFactoryImpl();
		return layerApplicationFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertySetterRegistry createPropertySetterRegistry() {
		PropertySetterRegistryImpl propertySetterRegistry = new PropertySetterRegistryImpl();
		return propertySetterRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, PropertySetter> createStringToPropertySetter() {
		StringToPropertySetterImpl stringToPropertySetter = new StringToPropertySetterImpl();
		return stringToPropertySetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorDescriptorRegistry createLayerOperatorDescriptorRegistry() {
		LayerOperatorDescriptorRegistryImpl layerOperatorDescriptorRegistry = new LayerOperatorDescriptorRegistryImpl();
		return layerOperatorDescriptorRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorDescriptor createLayerOperatorDescriptor() {
		LayerOperatorDescriptorImpl layerOperatorDescriptor = new LayerOperatorDescriptorImpl();
		return layerOperatorDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyOperator createPropertyOperator() {
		PropertyOperatorImpl propertyOperator = new PropertyOperatorImpl();
		return propertyOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, TypeInstance> createStringToTypeInstanceMap() {
		StringToTypeInstanceMapImpl stringToTypeInstanceMap = new StringToTypeInstanceMapImpl();
		return stringToTypeInstanceMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Folder createFolder() {
		FolderImpl folder = new FolderImpl();
		return folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metamodel createMetamodel() {
		MetamodelImpl metamodel = new MetamodelImpl();
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopLayerOperator createTopLayerOperator() {
		TopLayerOperatorImpl topLayerOperator = new TopLayerOperatorImpl();
		return topLayerOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackedLayerOperator createStackedLayerOperator() {
		StackedLayerOperatorImpl stackedLayerOperator = new StackedLayerOperatorImpl();
		return stackedLayerOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyIndex createPropertyIndex() {
		PropertyIndexImpl propertyIndex = new PropertyIndexImpl();
		return propertyIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, PropertyIndex> createStringToPropertyIndexMap() {
		StringToPropertyIndexMapImpl stringToPropertyIndexMap = new StringToPropertyIndexMapImpl();
		return stringToPropertyIndexMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleLayerDescriptor createSimpleLayerDescriptor() {
		SimpleLayerDescriptorImpl simpleLayerDescriptor = new SimpleLayerDescriptorImpl();
		return simpleLayerDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullInstance createNullInstance() {
		NullInstanceImpl nullInstance = new NullInstanceImpl();
		return nullInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layer createLayer() {
		LayerImpl layer = new LayerImpl();
		return layer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullPropertySetter createNullPropertySetter() {
		NullPropertySetterImpl nullPropertySetter = new NullPropertySetterImpl();
		return nullPropertySetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopLayerOperatorDescriptor createTopLayerOperatorDescriptor() {
		TopLayerOperatorDescriptorImpl topLayerOperatorDescriptor = new TopLayerOperatorDescriptorImpl();
		return topLayerOperatorDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackedLayerOperatorDescriptor createStackedLayerOperatorDescriptor() {
		StackedLayerOperatorDescriptorImpl stackedLayerOperatorDescriptor = new StackedLayerOperatorDescriptorImpl();
		return stackedLayerOperatorDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllViewsDerivedLayer createAllViewsDerivedLayer() {
		AllViewsDerivedLayerImpl allViewsDerivedLayer = new AllViewsDerivedLayerImpl();
		return allViewsDerivedLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSSPropertySetter createCSSPropertySetter() {
		CSSPropertySetterImpl cssPropertySetter = new CSSPropertySetterImpl();
		return cssPropertySetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSSType createCSSType() {
		CSSTypeImpl cssType = new CSSTypeImpl();
		return cssType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSSInstance createCSSInstance() {
		CSSInstanceImpl cssInstance = new CSSInstanceImpl();
		return cssInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSSHidePropertySetter createCSSHidePropertySetter() {
		CSSHidePropertySetterImpl cssHidePropertySetter = new CSSHidePropertySetterImpl();
		return cssHidePropertySetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSSHideType createCSSHideType() {
		CSSHideTypeImpl cssHideType = new CSSHideTypeImpl();
		return cssHideType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSSHideInstance createCSSHideInstance() {
		CSSHideInstanceImpl cssHideInstance = new CSSHideInstanceImpl();
		return cssHideInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerState createLayerStateFromString(EDataType eDataType, String initialValue) {
		LayerState result = LayerState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLayerStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventLevel createEventLevelFromString(EDataType eDataType, String initialValue) {
		EventLevel result = EventLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEventLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStringFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersException createLayersExceptionFromString(EDataType eDataType, String initialValue) {
		return (LayersException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLayersExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createintFromString(EDataType eDataType, String initialValue) {
		return (Integer)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertintToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BadStateException createBadStateExceptionFromString(EDataType eDataType, String initialValue) {
		return (BadStateException)createLayersExceptionFromString(LayersPackage.Literals.LAYERS_EXCEPTION, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBadStateExceptionToString(EDataType eDataType, Object instanceValue) {
		return convertLayersExceptionToString(LayersPackage.Literals.LAYERS_EXCEPTION, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotFoundException createNotFoundExceptionFromString(EDataType eDataType, String initialValue) {
		return (NotFoundException)createLayersExceptionFromString(LayersPackage.Literals.LAYERS_EXCEPTION, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNotFoundExceptionToString(EDataType eDataType, Object instanceValue) {
		return convertLayersExceptionToString(LayersPackage.Literals.LAYERS_EXCEPTION, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputePropertyValueCommand createComputePropertyValueCommandFromString(EDataType eDataType, String initialValue) {
		return (ComputePropertyValueCommand)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertComputePropertyValueCommandToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean createbooleanFromString(EDataType eDataType, String initialValue) {
		return (Boolean)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertbooleanToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage createEPackageFromString(EDataType eDataType, String initialValue) {
		return (EPackage)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEPackageToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createObjectFromString(EDataType eDataType, String initialValue) {
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersPackage getLayersPackage() {
		return (LayersPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LayersPackage getPackage() {
		return LayersPackage.eINSTANCE;
	}

} //LayersFactoryImpl
