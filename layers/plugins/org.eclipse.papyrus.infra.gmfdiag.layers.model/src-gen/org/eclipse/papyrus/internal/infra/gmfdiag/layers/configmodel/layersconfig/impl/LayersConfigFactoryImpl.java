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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.*;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.InstanciationException;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayersConfigFactoryImpl extends EFactoryImpl implements LayersConfigFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LayersConfigFactory init() {
		try {
			LayersConfigFactory theLayersConfigFactory = (LayersConfigFactory)EPackage.Registry.INSTANCE.getEFactory(LayersConfigPackage.eNS_URI);
			if (theLayersConfigFactory != null) {
				return theLayersConfigFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LayersConfigFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersConfigFactoryImpl() {
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
			case LayersConfigPackage.FOLDER: return createFolder();
			case LayersConfigPackage.LAYER_OPERATOR_CONFIG: return createLayerOperatorConfig();
			case LayersConfigPackage.OPERATOR_CONFIG: return createOperatorConfig();
			case LayersConfigPackage.PROPERTY_ID: return createPropertyId();
			case LayersConfigPackage.TYPE_CONFIG: return createTypeConfig();
			case LayersConfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING: return createLayerOperatorMultipleBinding();
			case LayersConfigPackage.OPERATOR_BINDING: return createOperatorBinding();
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
			case LayersConfigPackage.CLASSNAME_KIND:
				return createClassnameKindFromString(eDataType, initialValue);
			case LayersConfigPackage.STRING:
				return createStringFromString(eDataType, initialValue);
			case LayersConfigPackage.INSTANCIATION_EXCEPTION:
				return createInstanciationExceptionFromString(eDataType, initialValue);
			case LayersConfigPackage.LAYER_OPERATOR_DESCRIPTOR:
				return createLayerOperatorDescriptorFromString(eDataType, initialValue);
			case LayersConfigPackage.PROPERTY_OPERATOR:
				return createPropertyOperatorFromString(eDataType, initialValue);
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
			case LayersConfigPackage.CLASSNAME_KIND:
				return convertClassnameKindToString(eDataType, instanceValue);
			case LayersConfigPackage.STRING:
				return convertStringToString(eDataType, instanceValue);
			case LayersConfigPackage.INSTANCIATION_EXCEPTION:
				return convertInstanciationExceptionToString(eDataType, instanceValue);
			case LayersConfigPackage.LAYER_OPERATOR_DESCRIPTOR:
				return convertLayerOperatorDescriptorToString(eDataType, instanceValue);
			case LayersConfigPackage.PROPERTY_OPERATOR:
				return convertPropertyOperatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
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
	public LayerOperatorConfig createLayerOperatorConfig() {
		LayerOperatorConfigImpl layerOperatorConfig = new LayerOperatorConfigImpl();
		return layerOperatorConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorConfig createOperatorConfig() {
		OperatorConfigImpl operatorConfig = new OperatorConfigImpl();
		return operatorConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyId createPropertyId() {
		PropertyIdImpl propertyId = new PropertyIdImpl();
		return propertyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeConfig createTypeConfig() {
		TypeConfigImpl typeConfig = new TypeConfigImpl();
		return typeConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorMultipleBinding createLayerOperatorMultipleBinding() {
		LayerOperatorMultipleBindingImpl layerOperatorMultipleBinding = new LayerOperatorMultipleBindingImpl();
		return layerOperatorMultipleBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorBinding createOperatorBinding() {
		OperatorBindingImpl operatorBinding = new OperatorBindingImpl();
		return operatorBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassnameKind createClassnameKindFromString(EDataType eDataType, String initialValue) {
		ClassnameKind result = ClassnameKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassnameKindToString(EDataType eDataType, Object instanceValue) {
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
	public InstanciationException createInstanciationExceptionFromString(EDataType eDataType, String initialValue) {
		return (InstanciationException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInstanciationExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorDescriptor createLayerOperatorDescriptorFromString(EDataType eDataType, String initialValue) {
		return (LayerOperatorDescriptor)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLayerOperatorDescriptorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyOperator createPropertyOperatorFromString(EDataType eDataType, String initialValue) {
		return (PropertyOperator)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertyOperatorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersConfigPackage getLayersConfigPackage() {
		return (LayersConfigPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LayersConfigPackage getPackage() {
		return LayersConfigPackage.eINSTANCE;
	}

} //LayersConfigFactoryImpl
