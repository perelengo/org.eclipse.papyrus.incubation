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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.ClassnameKind;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.Folder;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.FolderElement;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.InstanciableElement;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayerOperatorConfig;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayerOperatorMultipleBinding;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayersConfigFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayersConfigPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.OperatorBinding;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.OperatorConfig;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.PropertyId;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.TypeConfig;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.InstanciationException;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayersConfigPackageImpl extends EPackageImpl implements LayersConfigPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass folderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass folderElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerOperatorConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanciableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyIdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerOperatorMultipleBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum classnameKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType instanciationExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType layerOperatorDescriptorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType propertyOperatorEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayersConfigPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LayersConfigPackageImpl() {
		super(eNS_URI, LayersConfigFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link LayersConfigPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LayersConfigPackage init() {
		if (isInited) return (LayersConfigPackage)EPackage.Registry.INSTANCE.getEPackage(LayersConfigPackage.eNS_URI);

		// Obtain or create and register package
		LayersConfigPackageImpl theLayersConfigPackage = (LayersConfigPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LayersConfigPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LayersConfigPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theLayersConfigPackage.createPackageContents();

		// Initialize created meta-data
		theLayersConfigPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLayersConfigPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LayersConfigPackage.eNS_URI, theLayersConfigPackage);
		return theLayersConfigPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFolder() {
		return folderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFolder_FolderElements() {
		return (EReference)folderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFolderElement() {
		return folderElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFolderElement_Name() {
		return (EAttribute)folderElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerOperatorConfig() {
		return layerOperatorConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorConfig__CreateLayersOperatorDescriptor() {
		return layerOperatorConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanciableElement() {
		return instanciableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanciableElement_Classname() {
		return (EAttribute)instanciableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanciableElement_BundleID() {
		return (EAttribute)instanciableElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanciableElement_DisplayName() {
		return (EAttribute)instanciableElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanciableElement_IconPath() {
		return (EAttribute)instanciableElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanciableElement_ClassnameKind() {
		return (EAttribute)instanciableElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorConfig() {
		return operatorConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperatorConfig__CreateOperatorDescriptor() {
		return operatorConfigEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyId() {
		return propertyIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyId_Type() {
		return (EReference)propertyIdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeConfig() {
		return typeConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerOperatorMultipleBinding() {
		return layerOperatorMultipleBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerOperatorMultipleBinding_LayerOperatorConfig() {
		return (EReference)layerOperatorMultipleBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerOperatorMultipleBinding_Bindings() {
		return (EReference)layerOperatorMultipleBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorBinding() {
		return operatorBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorBinding_Operator() {
		return (EReference)operatorBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorBinding_LayerOperatorConfig() {
		return (EReference)operatorBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorBinding_PropertyId() {
		return (EReference)operatorBindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorBinding_Owner() {
		return (EReference)operatorBindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getClassnameKind() {
		return classnameKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getString() {
		return stringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInstanciationException() {
		return instanciationExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLayerOperatorDescriptor() {
		return layerOperatorDescriptorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPropertyOperator() {
		return propertyOperatorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersConfigFactory getLayersConfigFactory() {
		return (LayersConfigFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		folderEClass = createEClass(FOLDER);
		createEReference(folderEClass, FOLDER__FOLDER_ELEMENTS);

		folderElementEClass = createEClass(FOLDER_ELEMENT);
		createEAttribute(folderElementEClass, FOLDER_ELEMENT__NAME);

		layerOperatorConfigEClass = createEClass(LAYER_OPERATOR_CONFIG);
		createEOperation(layerOperatorConfigEClass, LAYER_OPERATOR_CONFIG___CREATE_LAYERS_OPERATOR_DESCRIPTOR);

		instanciableElementEClass = createEClass(INSTANCIABLE_ELEMENT);
		createEAttribute(instanciableElementEClass, INSTANCIABLE_ELEMENT__CLASSNAME);
		createEAttribute(instanciableElementEClass, INSTANCIABLE_ELEMENT__BUNDLE_ID);
		createEAttribute(instanciableElementEClass, INSTANCIABLE_ELEMENT__DISPLAY_NAME);
		createEAttribute(instanciableElementEClass, INSTANCIABLE_ELEMENT__ICON_PATH);
		createEAttribute(instanciableElementEClass, INSTANCIABLE_ELEMENT__CLASSNAME_KIND);

		operatorConfigEClass = createEClass(OPERATOR_CONFIG);
		createEOperation(operatorConfigEClass, OPERATOR_CONFIG___CREATE_OPERATOR_DESCRIPTOR);

		propertyIdEClass = createEClass(PROPERTY_ID);
		createEReference(propertyIdEClass, PROPERTY_ID__TYPE);

		typeConfigEClass = createEClass(TYPE_CONFIG);

		layerOperatorMultipleBindingEClass = createEClass(LAYER_OPERATOR_MULTIPLE_BINDING);
		createEReference(layerOperatorMultipleBindingEClass, LAYER_OPERATOR_MULTIPLE_BINDING__LAYER_OPERATOR_CONFIG);
		createEReference(layerOperatorMultipleBindingEClass, LAYER_OPERATOR_MULTIPLE_BINDING__BINDINGS);

		operatorBindingEClass = createEClass(OPERATOR_BINDING);
		createEReference(operatorBindingEClass, OPERATOR_BINDING__OPERATOR);
		createEReference(operatorBindingEClass, OPERATOR_BINDING__LAYER_OPERATOR_CONFIG);
		createEReference(operatorBindingEClass, OPERATOR_BINDING__PROPERTY_ID);
		createEReference(operatorBindingEClass, OPERATOR_BINDING__OWNER);

		// Create enums
		classnameKindEEnum = createEEnum(CLASSNAME_KIND);

		// Create data types
		stringEDataType = createEDataType(STRING);
		instanciationExceptionEDataType = createEDataType(INSTANCIATION_EXCEPTION);
		layerOperatorDescriptorEDataType = createEDataType(LAYER_OPERATOR_DESCRIPTOR);
		propertyOperatorEDataType = createEDataType(PROPERTY_OPERATOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		folderEClass.getESuperTypes().add(this.getFolderElement());
		layerOperatorConfigEClass.getESuperTypes().add(this.getInstanciableElement());
		instanciableElementEClass.getESuperTypes().add(this.getFolderElement());
		operatorConfigEClass.getESuperTypes().add(this.getInstanciableElement());
		propertyIdEClass.getESuperTypes().add(this.getFolderElement());
		typeConfigEClass.getESuperTypes().add(this.getFolderElement());
		layerOperatorMultipleBindingEClass.getESuperTypes().add(this.getFolderElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(folderEClass, Folder.class, "Folder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getFolder_FolderElements(), this.getFolderElement(), null, "folderElements", null, 0, -1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(folderElementEClass, FolderElement.class, "FolderElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getFolderElement_Name(), this.getString(), "name", null, 1, 1, FolderElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(layerOperatorConfigEClass, LayerOperatorConfig.class, "LayerOperatorConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		EOperation op = initEOperation(getLayerOperatorConfig__CreateLayersOperatorDescriptor(), this.getLayerOperatorDescriptor(), "createLayersOperatorDescriptor", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getInstanciationException());

		initEClass(instanciableElementEClass, InstanciableElement.class, "InstanciableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getInstanciableElement_Classname(), this.getString(), "classname", null, 1, 1, InstanciableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInstanciableElement_BundleID(), this.getString(), "bundleID", null, 1, 1, InstanciableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInstanciableElement_DisplayName(), this.getString(), "displayName", null, 1, 1, InstanciableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInstanciableElement_IconPath(), this.getString(), "iconPath", null, 1, 1, InstanciableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInstanciableElement_ClassnameKind(), this.getClassnameKind(), "classnameKind", "UNDEFINED", 1, 1, InstanciableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(operatorConfigEClass, OperatorConfig.class, "OperatorConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		op = initEOperation(getOperatorConfig__CreateOperatorDescriptor(), this.getPropertyOperator(), "createOperatorDescriptor", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getInstanciationException());

		initEClass(propertyIdEClass, PropertyId.class, "PropertyId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPropertyId_Type(), this.getTypeConfig(), null, "type", null, 1, 1, PropertyId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(typeConfigEClass, TypeConfig.class, "TypeConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(layerOperatorMultipleBindingEClass, LayerOperatorMultipleBinding.class, "LayerOperatorMultipleBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLayerOperatorMultipleBinding_LayerOperatorConfig(), this.getLayerOperatorConfig(), null, "layerOperatorConfig", null, 1, 1, LayerOperatorMultipleBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getLayerOperatorMultipleBinding_Bindings(), this.getOperatorBinding(), this.getOperatorBinding_Owner(), "bindings", null, 0, -1, LayerOperatorMultipleBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(operatorBindingEClass, OperatorBinding.class, "OperatorBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOperatorBinding_Operator(), this.getOperatorConfig(), null, "operator", null, 1, 1, OperatorBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperatorBinding_LayerOperatorConfig(), this.getLayerOperatorConfig(), null, "layerOperatorConfig", null, 1, 1, OperatorBinding.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperatorBinding_PropertyId(), this.getPropertyId(), null, "propertyId", null, 1, 1, OperatorBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperatorBinding_Owner(), this.getLayerOperatorMultipleBinding(), this.getLayerOperatorMultipleBinding_Bindings(), "owner", null, 1, 1, OperatorBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(classnameKindEEnum, ClassnameKind.class, "ClassnameKind"); //$NON-NLS-1$
		addEEnumLiteral(classnameKindEEnum, ClassnameKind.UNDEFINED);
		addEEnumLiteral(classnameKindEEnum, ClassnameKind.EMF_CLASSNAME);
		addEEnumLiteral(classnameKindEEnum, ClassnameKind.POJO_CLASSNAME);
		addEEnumLiteral(classnameKindEEnum, ClassnameKind.NOT_FOUND);

		// Initialize data types
		initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(instanciationExceptionEDataType, InstanciationException.class, "InstanciationException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(layerOperatorDescriptorEDataType, LayerOperatorDescriptor.class, "LayerOperatorDescriptor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(propertyOperatorEDataType, PropertyOperator.class, "PropertyOperator", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML"; //$NON-NLS-1$	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "originalName", "LayersConfig" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //LayersConfigPackageImpl
