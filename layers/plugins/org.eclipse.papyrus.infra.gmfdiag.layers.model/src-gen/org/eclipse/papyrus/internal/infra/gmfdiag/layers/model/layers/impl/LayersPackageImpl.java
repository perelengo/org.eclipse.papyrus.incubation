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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.runtime.notation.NotationPackage;

import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.BadStateException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AllViewsDerivedLayer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ApplicationDependantElement;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHidePropertySetter;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideType;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSPropertySetter;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSType;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.EventLevel;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Folder;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FolderElement;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Layer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerApplicationFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptorRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerNamedStyle;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerStackDescriptorRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerState;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersContainer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NullInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NullPropertySetter;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyIndex;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.SimpleLayerDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StackedLayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StackedLayerOperatorDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperatorDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeRegistry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayersPackageImpl extends EPackageImpl implements LayersPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerNamedStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layersStackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationDependantElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layersStackApplicationEClass = null;

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
	private EClass layerStackDescriptorRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computePropertyValueCommandItfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToTypeMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerDescriptorRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerApplicationFactoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertySetterRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertySetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToPropertySetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerOperatorDescriptorRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerOperatorDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layersContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractLayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToTypeInstanceMapEClass = null;

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
	private EClass metamodelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLayerOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stackedLayerOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyIndexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToPropertyIndexMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleLayerDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullPropertySetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLayerOperatorDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stackedLayerOperatorDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allViewsDerivedLayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cssPropertySetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cssTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cssInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cssHidePropertySetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cssHideTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cssHideInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum layerStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eventLevelEEnum = null;

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
	private EDataType layersExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType intEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType badStateExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType notFoundExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType computePropertyValueCommandEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType booleanEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ePackageEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType objectEDataType = null;

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
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LayersPackageImpl() {
		super(eNS_URI, LayersFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LayersPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LayersPackage init() {
		if (isInited) return (LayersPackage)EPackage.Registry.INSTANCE.getEPackage(LayersPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredLayersPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		LayersPackageImpl theLayersPackage = registeredLayersPackage instanceof LayersPackageImpl ? (LayersPackageImpl)registeredLayersPackage : new LayersPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		NotationPackage.eINSTANCE.eClass();
		StylesheetsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLayersPackage.createPackageContents();

		// Initialize created meta-data
		theLayersPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLayersPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LayersPackage.eNS_URI, theLayersPackage);
		return theLayersPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerNamedStyle() {
		return layerNamedStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerNamedStyle_LayersStack() {
		return (EReference)layerNamedStyleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayersStack() {
		return layersStackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStack_Layers() {
		return (EReference)layersStackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayersStack_Name() {
		return (EAttribute)layersStackEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayersStack_Description() {
		return (EAttribute)layersStackEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStack_Diagram() {
		return (EReference)layersStackEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayersStack_State() {
		return (EAttribute)layersStackEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStack__GetComputePropertyValueCommand__View_Property() {
		return layersStackEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStack__GetPropertiesComputePropertyValueCommand__View_List() {
		return layersStackEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStack__GetViewsComputePropertyValueCommand__List_Property() {
		return layersStackEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStack__StartAfterCreation() {
		return layersStackEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStack__AttachLayers() {
		return layersStackEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStack__Attach() {
		return layersStackEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStack__Detach() {
		return layersStackEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStack__EnterAttachedState() {
		return layersStackEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStack__ExitAttachedState() {
		return layersStackEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerExpression() {
		return layerExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerExpression_Name() {
		return (EAttribute)layerExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerExpression_Description() {
		return (EAttribute)layerExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerExpression_IsLayerEnabledInternal() {
		return (EAttribute)layerExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerExpression_IsLayerEnabled() {
		return (EAttribute)layerExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerExpression_IsBranchEnabled() {
		return (EAttribute)layerExpressionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerExpression_OwningLayersStack() {
		return (EReference)layerExpressionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerExpression_State() {
		return (EAttribute)layerExpressionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerExpression__GetComputePropertyValueCommand__View_Property() {
		return layerExpressionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerExpression__GetViewsComputePropertyValueCommand__List_Property() {
		return layerExpressionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerExpression__GetPropertiesComputePropertyValueCommand__View_List() {
		return layerExpressionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerExpression__AttachToLayersStack__LayersStack() {
		return layerExpressionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerExpression__GetLayersStack() {
		return layerExpressionEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerExpression__EnterAttachedState() {
		return layerExpressionEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerExpression__Attach() {
		return layerExpressionEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerExpression__Detach() {
		return layerExpressionEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerExpression__ExitAttachedState() {
		return layerExpressionEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplicationDependantElement() {
		return applicationDependantElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationDependantElement_Application() {
		return (EReference)applicationDependantElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayersStackApplication() {
		return layersStackApplicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStackApplication_LayersStacks() {
		return (EReference)layersStackApplicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStackApplication_LayerStackRegistry() {
		return (EReference)layersStackApplicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStackApplication_PropertyRegistry() {
		return (EReference)layersStackApplicationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStackApplication_LayerDescriptorRegistry() {
		return (EReference)layersStackApplicationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStackApplication_Factory() {
		return (EReference)layersStackApplicationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStackApplication_PropertySetterRegistry() {
		return (EReference)layersStackApplicationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStackApplication_LayerOperatorDescriptorRegistry() {
		return (EReference)layersStackApplicationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStackApplication__GetLayersStackFor__Diagram() {
		return layersStackApplicationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStackApplication__RemoveLayersStackFor__Diagram() {
		return layersStackApplicationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStackApplication__IsLayersStackAttachedFor__Diagram() {
		return layersStackApplicationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStackApplication__CreateLayersStackFor__Diagram() {
		return layersStackApplicationEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStackApplication__LookupLayersStackFor__Diagram() {
		return layersStackApplicationEClass.getEOperations().get(4);
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
	public EClass getLayerStackDescriptorRegistry() {
		return layerStackDescriptorRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyRegistry() {
		return propertyRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyRegistry_Properties() {
		return (EReference)propertyRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyRegistry_TypeRegistry() {
		return (EReference)propertyRegistryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyRegistry_PropertiesCount() {
		return (EAttribute)propertyRegistryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyRegistry__GetPropertyIndex__String() {
		return propertyRegistryEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyRegistry__GetProperty__String() {
		return propertyRegistryEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyRegistry__AddProperty__Property() {
		return propertyRegistryEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProperty_Type() {
		return (EReference)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProperty_DefaultValue() {
		return (EReference)propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Description() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Index() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProperty__CreateInstance() {
		return propertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Name() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Description() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getType__CreateInstance() {
		return typeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeInstance() {
		return typeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeInstance__SetValueFromString__String() {
		return typeInstanceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeInstance__SetValueFromInstance__TypeInstance() {
		return typeInstanceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputePropertyValueCommandItf() {
		return computePropertyValueCommandItfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComputePropertyValueCommandItf__GetCmdValue() {
		return computePropertyValueCommandItfEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeRegistry() {
		return typeRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeRegistry_Types() {
		return (EReference)typeRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringToTypeMap() {
		return stringToTypeMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringToTypeMap_Value() {
		return (EReference)stringToTypeMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToTypeMap_Key() {
		return (EAttribute)stringToTypeMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerDescriptorRegistry() {
		return layerDescriptorRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerDescriptorRegistry_LayerDescriptors() {
		return (EReference)layerDescriptorRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerDescriptor() {
		return layerDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerDescriptor_PropertyRegistry() {
		return (EReference)layerDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerApplicationFactory() {
		return layerApplicationFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerApplicationFactory_Application() {
		return (EReference)layerApplicationFactoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertySetterRegistry() {
		return propertySetterRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySetterRegistry_PropertySetters() {
		return (EReference)propertySetterRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySetterRegistry_SetterMap() {
		return (EReference)propertySetterRegistryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySetterRegistry_Application() {
		return (EReference)propertySetterRegistryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertySetterRegistry__GetPropertySetter__Property() {
		return propertySetterRegistryEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertySetterRegistry__GetPropertySetter__String() {
		return propertySetterRegistryEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertySetterRegistry__AddPropertySetter__PropertySetter() {
		return propertySetterRegistryEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertySetter() {
		return propertySetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySetter_Property() {
		return (EReference)propertySetterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertySetter_PropertyName() {
		return (EAttribute)propertySetterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertySetter__SetValue__View_TypeInstance() {
		return propertySetterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringToPropertySetter() {
		return stringToPropertySetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToPropertySetter_Key() {
		return (EAttribute)stringToPropertySetterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringToPropertySetter_Value() {
		return (EReference)stringToPropertySetterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerOperatorDescriptorRegistry() {
		return layerOperatorDescriptorRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerOperatorDescriptorRegistry_Descriptors() {
		return (EReference)layerOperatorDescriptorRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerOperatorDescriptorRegistry_PropertyOperators() {
		return (EReference)layerOperatorDescriptorRegistryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerOperatorDescriptorRegistry_PropertyCollectionSize() {
		return (EAttribute)layerOperatorDescriptorRegistryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerOperatorDescriptorRegistry_DefaultOperator() {
		return (EReference)layerOperatorDescriptorRegistryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptorRegistry__AddLayerOperatorDescriptor__LayerOperatorDescriptor() {
		return layerOperatorDescriptorRegistryEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptorRegistry__GetLayerOperatorDescriptor__String() {
		return layerOperatorDescriptorRegistryEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptorRegistry__AddPropertyOperator__PropertyOperator() {
		return layerOperatorDescriptorRegistryEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptorRegistry__GetPropertyOperator__String() {
		return layerOperatorDescriptorRegistryEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptorRegistry__AttachOperatorToDescriptor__Property_String_String() {
		return layerOperatorDescriptorRegistryEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptorRegistry__CreateLayerOperator__String() {
		return layerOperatorDescriptorRegistryEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerOperatorDescriptor() {
		return layerOperatorDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerOperatorDescriptor_PropertyOperators() {
		return (EReference)layerOperatorDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerOperatorDescriptor_Name() {
		return (EAttribute)layerOperatorDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptor__GetPropertyOperator__Property() {
		return layerOperatorDescriptorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptor__SetPropertyOperator__Property_PropertyOperator() {
		return layerOperatorDescriptorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptor__CreateLayerOperator() {
		return layerOperatorDescriptorEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptor__SetPropertyCollectionSize__int_PropertyOperator() {
		return layerOperatorDescriptorEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyOperator() {
		return propertyOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyOperator_Name() {
		return (EAttribute)propertyOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyOperator_Classname() {
		return (EAttribute)propertyOperatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyOperator_OperatorInstance() {
		return (EReference)propertyOperatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyOperator_ClassBundleID() {
		return (EAttribute)propertyOperatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyOperator__GetComputePropertyValueCommand__List() {
		return propertyOperatorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyOperator__ResetOperatorInstance() {
		return propertyOperatorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerOperator() {
		return layerOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerOperator_Layers() {
		return (EReference)layerOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerOperator_LayerOperatorDescriptorName() {
		return (EAttribute)layerOperatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerOperator_LayerOperatorDescriptor() {
		return (EReference)layerOperatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperator__IsDescriptorSet() {
		return layerOperatorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperator__ResetDescriptor() {
		return layerOperatorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayersContainer() {
		return layersContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersContainer__AddLayer__LayerExpression() {
		return layersContainerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractLayer() {
		return abstractLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractLayer_PropertyValues() {
		return (EReference)abstractLayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractLayer_PropertyValueMap() {
		return (EReference)abstractLayerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractLayer_LayerDescriptor() {
		return (EReference)abstractLayerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractLayer_Views() {
		return (EReference)abstractLayerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractLayer_AttachedProperties() {
		return (EReference)abstractLayerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractLayer__AddPropertyInstance__Property() {
		return abstractLayerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractLayer__RemovePropertyInstance__Property() {
		return abstractLayerEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractLayer__GetPropertyInstance__Property() {
		return abstractLayerEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractLayer__GetPropertyInstance__String() {
		return abstractLayerEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringToTypeInstanceMap() {
		return stringToTypeInstanceMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToTypeInstanceMap_Key() {
		return (EAttribute)stringToTypeInstanceMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringToTypeInstanceMap_Value() {
		return (EReference)stringToTypeInstanceMapEClass.getEStructuralFeatures().get(1);
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
	public EReference getFolder_Elements() {
		return (EReference)folderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFolder_Name() {
		return (EAttribute)folderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetamodel() {
		return metamodelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodel_Name() {
		return (EAttribute)metamodelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodel_Description() {
		return (EAttribute)metamodelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodel_Nsuri() {
		return (EAttribute)metamodelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodel_PluginID() {
		return (EAttribute)metamodelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodel_EPackageInstanceName() {
		return (EAttribute)metamodelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodel_IsTypeValid() {
		return (EAttribute)metamodelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMetamodel__GetEPackage() {
		return metamodelEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopLayerOperator() {
		return topLayerOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStackedLayerOperator() {
		return stackedLayerOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyIndex() {
		return propertyIndexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyIndex_Property() {
		return (EReference)propertyIndexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyIndex_Index() {
		return (EAttribute)propertyIndexEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringToPropertyIndexMap() {
		return stringToPropertyIndexMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringToPropertyIndexMap_Value() {
		return (EReference)stringToPropertyIndexMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToPropertyIndexMap_Key() {
		return (EAttribute)stringToPropertyIndexMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleLayerDescriptor() {
		return simpleLayerDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNullInstance() {
		return nullInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNullInstance__GetInstance() {
		return nullInstanceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayer() {
		return layerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNullPropertySetter() {
		return nullPropertySetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopLayerOperatorDescriptor() {
		return topLayerOperatorDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStackedLayerOperatorDescriptor() {
		return stackedLayerOperatorDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllViewsDerivedLayer() {
		return allViewsDerivedLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCSSPropertySetter() {
		return cssPropertySetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCSSType() {
		return cssTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCSSInstance() {
		return cssInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCSSInstance_Stylesheet() {
		return (EReference)cssInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCSSInstance_Style() {
		return (EAttribute)cssInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCSSHidePropertySetter() {
		return cssHidePropertySetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCSSHideType() {
		return cssHideTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCSSHideInstance() {
		return cssHideInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCSSHideInstance_Stylesheet() {
		return (EReference)cssHideInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCSSHideInstance_Style() {
		return (EAttribute)cssHideInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLayerState() {
		return layerStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEventLevel() {
		return eventLevelEEnum;
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
	public EDataType getLayersException() {
		return layersExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getint() {
		return intEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBadStateException() {
		return badStateExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNotFoundException() {
		return notFoundExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getComputePropertyValueCommand() {
		return computePropertyValueCommandEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getboolean() {
		return booleanEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEPackage() {
		return ePackageEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getObject() {
		return objectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersFactory getLayersFactory() {
		return (LayersFactory)getEFactoryInstance();
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
		layerNamedStyleEClass = createEClass(LAYER_NAMED_STYLE);
		createEReference(layerNamedStyleEClass, LAYER_NAMED_STYLE__LAYERS_STACK);

		layersStackEClass = createEClass(LAYERS_STACK);
		createEReference(layersStackEClass, LAYERS_STACK__LAYERS);
		createEAttribute(layersStackEClass, LAYERS_STACK__NAME);
		createEAttribute(layersStackEClass, LAYERS_STACK__DESCRIPTION);
		createEReference(layersStackEClass, LAYERS_STACK__DIAGRAM);
		createEAttribute(layersStackEClass, LAYERS_STACK__STATE);
		createEOperation(layersStackEClass, LAYERS_STACK___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY);
		createEOperation(layersStackEClass, LAYERS_STACK___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_LIST);
		createEOperation(layersStackEClass, LAYERS_STACK___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__LIST_PROPERTY);
		createEOperation(layersStackEClass, LAYERS_STACK___START_AFTER_CREATION);
		createEOperation(layersStackEClass, LAYERS_STACK___ATTACH_LAYERS);
		createEOperation(layersStackEClass, LAYERS_STACK___ATTACH);
		createEOperation(layersStackEClass, LAYERS_STACK___DETACH);
		createEOperation(layersStackEClass, LAYERS_STACK___ENTER_ATTACHED_STATE);
		createEOperation(layersStackEClass, LAYERS_STACK___EXIT_ATTACHED_STATE);

		layerExpressionEClass = createEClass(LAYER_EXPRESSION);
		createEAttribute(layerExpressionEClass, LAYER_EXPRESSION__NAME);
		createEAttribute(layerExpressionEClass, LAYER_EXPRESSION__DESCRIPTION);
		createEAttribute(layerExpressionEClass, LAYER_EXPRESSION__IS_LAYER_ENABLED_INTERNAL);
		createEAttribute(layerExpressionEClass, LAYER_EXPRESSION__IS_LAYER_ENABLED);
		createEAttribute(layerExpressionEClass, LAYER_EXPRESSION__IS_BRANCH_ENABLED);
		createEReference(layerExpressionEClass, LAYER_EXPRESSION__OWNING_LAYERS_STACK);
		createEAttribute(layerExpressionEClass, LAYER_EXPRESSION__STATE);
		createEOperation(layerExpressionEClass, LAYER_EXPRESSION___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY);
		createEOperation(layerExpressionEClass, LAYER_EXPRESSION___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__LIST_PROPERTY);
		createEOperation(layerExpressionEClass, LAYER_EXPRESSION___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_LIST);
		createEOperation(layerExpressionEClass, LAYER_EXPRESSION___ATTACH_TO_LAYERS_STACK__LAYERSSTACK);
		createEOperation(layerExpressionEClass, LAYER_EXPRESSION___GET_LAYERS_STACK);
		createEOperation(layerExpressionEClass, LAYER_EXPRESSION___ENTER_ATTACHED_STATE);
		createEOperation(layerExpressionEClass, LAYER_EXPRESSION___ATTACH);
		createEOperation(layerExpressionEClass, LAYER_EXPRESSION___DETACH);
		createEOperation(layerExpressionEClass, LAYER_EXPRESSION___EXIT_ATTACHED_STATE);

		applicationDependantElementEClass = createEClass(APPLICATION_DEPENDANT_ELEMENT);
		createEReference(applicationDependantElementEClass, APPLICATION_DEPENDANT_ELEMENT__APPLICATION);

		layersStackApplicationEClass = createEClass(LAYERS_STACK_APPLICATION);
		createEReference(layersStackApplicationEClass, LAYERS_STACK_APPLICATION__LAYERS_STACKS);
		createEReference(layersStackApplicationEClass, LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY);
		createEReference(layersStackApplicationEClass, LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY);
		createEReference(layersStackApplicationEClass, LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY);
		createEReference(layersStackApplicationEClass, LAYERS_STACK_APPLICATION__FACTORY);
		createEReference(layersStackApplicationEClass, LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY);
		createEReference(layersStackApplicationEClass, LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY);
		createEOperation(layersStackApplicationEClass, LAYERS_STACK_APPLICATION___GET_LAYERS_STACK_FOR__DIAGRAM);
		createEOperation(layersStackApplicationEClass, LAYERS_STACK_APPLICATION___REMOVE_LAYERS_STACK_FOR__DIAGRAM);
		createEOperation(layersStackApplicationEClass, LAYERS_STACK_APPLICATION___IS_LAYERS_STACK_ATTACHED_FOR__DIAGRAM);
		createEOperation(layersStackApplicationEClass, LAYERS_STACK_APPLICATION___CREATE_LAYERS_STACK_FOR__DIAGRAM);
		createEOperation(layersStackApplicationEClass, LAYERS_STACK_APPLICATION___LOOKUP_LAYERS_STACK_FOR__DIAGRAM);

		folderElementEClass = createEClass(FOLDER_ELEMENT);

		layerStackDescriptorRegistryEClass = createEClass(LAYER_STACK_DESCRIPTOR_REGISTRY);

		propertyRegistryEClass = createEClass(PROPERTY_REGISTRY);
		createEReference(propertyRegistryEClass, PROPERTY_REGISTRY__PROPERTIES);
		createEReference(propertyRegistryEClass, PROPERTY_REGISTRY__TYPE_REGISTRY);
		createEAttribute(propertyRegistryEClass, PROPERTY_REGISTRY__PROPERTIES_COUNT);
		createEOperation(propertyRegistryEClass, PROPERTY_REGISTRY___GET_PROPERTY_INDEX__STRING);
		createEOperation(propertyRegistryEClass, PROPERTY_REGISTRY___GET_PROPERTY__STRING);
		createEOperation(propertyRegistryEClass, PROPERTY_REGISTRY___ADD_PROPERTY__PROPERTY);

		propertyEClass = createEClass(PROPERTY);
		createEReference(propertyEClass, PROPERTY__TYPE);
		createEReference(propertyEClass, PROPERTY__DEFAULT_VALUE);
		createEAttribute(propertyEClass, PROPERTY__NAME);
		createEAttribute(propertyEClass, PROPERTY__DESCRIPTION);
		createEAttribute(propertyEClass, PROPERTY__INDEX);
		createEOperation(propertyEClass, PROPERTY___CREATE_INSTANCE);

		typeEClass = createEClass(TYPE);
		createEAttribute(typeEClass, TYPE__NAME);
		createEAttribute(typeEClass, TYPE__DESCRIPTION);
		createEOperation(typeEClass, TYPE___CREATE_INSTANCE);

		typeInstanceEClass = createEClass(TYPE_INSTANCE);
		createEOperation(typeInstanceEClass, TYPE_INSTANCE___SET_VALUE_FROM_STRING__STRING);
		createEOperation(typeInstanceEClass, TYPE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE);

		computePropertyValueCommandItfEClass = createEClass(COMPUTE_PROPERTY_VALUE_COMMAND_ITF);
		createEOperation(computePropertyValueCommandItfEClass, COMPUTE_PROPERTY_VALUE_COMMAND_ITF___GET_CMD_VALUE);

		typeRegistryEClass = createEClass(TYPE_REGISTRY);
		createEReference(typeRegistryEClass, TYPE_REGISTRY__TYPES);

		stringToTypeMapEClass = createEClass(STRING_TO_TYPE_MAP);
		createEReference(stringToTypeMapEClass, STRING_TO_TYPE_MAP__VALUE);
		createEAttribute(stringToTypeMapEClass, STRING_TO_TYPE_MAP__KEY);

		layerDescriptorRegistryEClass = createEClass(LAYER_DESCRIPTOR_REGISTRY);
		createEReference(layerDescriptorRegistryEClass, LAYER_DESCRIPTOR_REGISTRY__LAYER_DESCRIPTORS);

		layerDescriptorEClass = createEClass(LAYER_DESCRIPTOR);
		createEReference(layerDescriptorEClass, LAYER_DESCRIPTOR__PROPERTY_REGISTRY);

		layerApplicationFactoryEClass = createEClass(LAYER_APPLICATION_FACTORY);
		createEReference(layerApplicationFactoryEClass, LAYER_APPLICATION_FACTORY__APPLICATION);

		propertySetterRegistryEClass = createEClass(PROPERTY_SETTER_REGISTRY);
		createEReference(propertySetterRegistryEClass, PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS);
		createEReference(propertySetterRegistryEClass, PROPERTY_SETTER_REGISTRY__SETTER_MAP);
		createEReference(propertySetterRegistryEClass, PROPERTY_SETTER_REGISTRY__APPLICATION);
		createEOperation(propertySetterRegistryEClass, PROPERTY_SETTER_REGISTRY___GET_PROPERTY_SETTER__PROPERTY);
		createEOperation(propertySetterRegistryEClass, PROPERTY_SETTER_REGISTRY___GET_PROPERTY_SETTER__STRING);
		createEOperation(propertySetterRegistryEClass, PROPERTY_SETTER_REGISTRY___ADD_PROPERTY_SETTER__PROPERTYSETTER);

		propertySetterEClass = createEClass(PROPERTY_SETTER);
		createEReference(propertySetterEClass, PROPERTY_SETTER__PROPERTY);
		createEAttribute(propertySetterEClass, PROPERTY_SETTER__PROPERTY_NAME);
		createEOperation(propertySetterEClass, PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE);

		stringToPropertySetterEClass = createEClass(STRING_TO_PROPERTY_SETTER);
		createEAttribute(stringToPropertySetterEClass, STRING_TO_PROPERTY_SETTER__KEY);
		createEReference(stringToPropertySetterEClass, STRING_TO_PROPERTY_SETTER__VALUE);

		layerOperatorDescriptorRegistryEClass = createEClass(LAYER_OPERATOR_DESCRIPTOR_REGISTRY);
		createEReference(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DESCRIPTORS);
		createEReference(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_OPERATORS);
		createEAttribute(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_COLLECTION_SIZE);
		createEReference(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DEFAULT_OPERATOR);
		createEOperation(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ADD_LAYER_OPERATOR_DESCRIPTOR__LAYEROPERATORDESCRIPTOR);
		createEOperation(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY___GET_LAYER_OPERATOR_DESCRIPTOR__STRING);
		createEOperation(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ADD_PROPERTY_OPERATOR__PROPERTYOPERATOR);
		createEOperation(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY___GET_PROPERTY_OPERATOR__STRING);
		createEOperation(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ATTACH_OPERATOR_TO_DESCRIPTOR__PROPERTY_STRING_STRING);
		createEOperation(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY___CREATE_LAYER_OPERATOR__STRING);

		layerOperatorDescriptorEClass = createEClass(LAYER_OPERATOR_DESCRIPTOR);
		createEReference(layerOperatorDescriptorEClass, LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS);
		createEAttribute(layerOperatorDescriptorEClass, LAYER_OPERATOR_DESCRIPTOR__NAME);
		createEOperation(layerOperatorDescriptorEClass, LAYER_OPERATOR_DESCRIPTOR___GET_PROPERTY_OPERATOR__PROPERTY);
		createEOperation(layerOperatorDescriptorEClass, LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_OPERATOR__PROPERTY_PROPERTYOPERATOR);
		createEOperation(layerOperatorDescriptorEClass, LAYER_OPERATOR_DESCRIPTOR___CREATE_LAYER_OPERATOR);
		createEOperation(layerOperatorDescriptorEClass, LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_COLLECTION_SIZE__INT_PROPERTYOPERATOR);

		propertyOperatorEClass = createEClass(PROPERTY_OPERATOR);
		createEAttribute(propertyOperatorEClass, PROPERTY_OPERATOR__NAME);
		createEAttribute(propertyOperatorEClass, PROPERTY_OPERATOR__CLASSNAME);
		createEReference(propertyOperatorEClass, PROPERTY_OPERATOR__OPERATOR_INSTANCE);
		createEAttribute(propertyOperatorEClass, PROPERTY_OPERATOR__CLASS_BUNDLE_ID);
		createEOperation(propertyOperatorEClass, PROPERTY_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__LIST);
		createEOperation(propertyOperatorEClass, PROPERTY_OPERATOR___RESET_OPERATOR_INSTANCE);

		layerOperatorEClass = createEClass(LAYER_OPERATOR);
		createEReference(layerOperatorEClass, LAYER_OPERATOR__LAYERS);
		createEAttribute(layerOperatorEClass, LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME);
		createEReference(layerOperatorEClass, LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR);
		createEOperation(layerOperatorEClass, LAYER_OPERATOR___IS_DESCRIPTOR_SET);
		createEOperation(layerOperatorEClass, LAYER_OPERATOR___RESET_DESCRIPTOR);

		layersContainerEClass = createEClass(LAYERS_CONTAINER);
		createEOperation(layersContainerEClass, LAYERS_CONTAINER___ADD_LAYER__LAYEREXPRESSION);

		abstractLayerEClass = createEClass(ABSTRACT_LAYER);
		createEReference(abstractLayerEClass, ABSTRACT_LAYER__PROPERTY_VALUES);
		createEReference(abstractLayerEClass, ABSTRACT_LAYER__PROPERTY_VALUE_MAP);
		createEReference(abstractLayerEClass, ABSTRACT_LAYER__LAYER_DESCRIPTOR);
		createEReference(abstractLayerEClass, ABSTRACT_LAYER__VIEWS);
		createEReference(abstractLayerEClass, ABSTRACT_LAYER__ATTACHED_PROPERTIES);
		createEOperation(abstractLayerEClass, ABSTRACT_LAYER___ADD_PROPERTY_INSTANCE__PROPERTY);
		createEOperation(abstractLayerEClass, ABSTRACT_LAYER___REMOVE_PROPERTY_INSTANCE__PROPERTY);
		createEOperation(abstractLayerEClass, ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__PROPERTY);
		createEOperation(abstractLayerEClass, ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__STRING);

		stringToTypeInstanceMapEClass = createEClass(STRING_TO_TYPE_INSTANCE_MAP);
		createEAttribute(stringToTypeInstanceMapEClass, STRING_TO_TYPE_INSTANCE_MAP__KEY);
		createEReference(stringToTypeInstanceMapEClass, STRING_TO_TYPE_INSTANCE_MAP__VALUE);

		folderEClass = createEClass(FOLDER);
		createEReference(folderEClass, FOLDER__ELEMENTS);
		createEAttribute(folderEClass, FOLDER__NAME);

		metamodelEClass = createEClass(METAMODEL);
		createEAttribute(metamodelEClass, METAMODEL__NAME);
		createEAttribute(metamodelEClass, METAMODEL__DESCRIPTION);
		createEAttribute(metamodelEClass, METAMODEL__NSURI);
		createEAttribute(metamodelEClass, METAMODEL__PLUGIN_ID);
		createEAttribute(metamodelEClass, METAMODEL__EPACKAGE_INSTANCE_NAME);
		createEAttribute(metamodelEClass, METAMODEL__IS_TYPE_VALID);
		createEOperation(metamodelEClass, METAMODEL___GET_EPACKAGE);

		topLayerOperatorEClass = createEClass(TOP_LAYER_OPERATOR);

		stackedLayerOperatorEClass = createEClass(STACKED_LAYER_OPERATOR);

		propertyIndexEClass = createEClass(PROPERTY_INDEX);
		createEReference(propertyIndexEClass, PROPERTY_INDEX__PROPERTY);
		createEAttribute(propertyIndexEClass, PROPERTY_INDEX__INDEX);

		stringToPropertyIndexMapEClass = createEClass(STRING_TO_PROPERTY_INDEX_MAP);
		createEReference(stringToPropertyIndexMapEClass, STRING_TO_PROPERTY_INDEX_MAP__VALUE);
		createEAttribute(stringToPropertyIndexMapEClass, STRING_TO_PROPERTY_INDEX_MAP__KEY);

		simpleLayerDescriptorEClass = createEClass(SIMPLE_LAYER_DESCRIPTOR);

		nullInstanceEClass = createEClass(NULL_INSTANCE);
		createEOperation(nullInstanceEClass, NULL_INSTANCE___GET_INSTANCE);

		layerEClass = createEClass(LAYER);

		nullPropertySetterEClass = createEClass(NULL_PROPERTY_SETTER);

		topLayerOperatorDescriptorEClass = createEClass(TOP_LAYER_OPERATOR_DESCRIPTOR);

		stackedLayerOperatorDescriptorEClass = createEClass(STACKED_LAYER_OPERATOR_DESCRIPTOR);

		allViewsDerivedLayerEClass = createEClass(ALL_VIEWS_DERIVED_LAYER);

		cssPropertySetterEClass = createEClass(CSS_PROPERTY_SETTER);

		cssTypeEClass = createEClass(CSS_TYPE);

		cssInstanceEClass = createEClass(CSS_INSTANCE);
		createEReference(cssInstanceEClass, CSS_INSTANCE__STYLESHEET);
		createEAttribute(cssInstanceEClass, CSS_INSTANCE__STYLE);

		cssHidePropertySetterEClass = createEClass(CSS_HIDE_PROPERTY_SETTER);

		cssHideTypeEClass = createEClass(CSS_HIDE_TYPE);

		cssHideInstanceEClass = createEClass(CSS_HIDE_INSTANCE);
		createEReference(cssHideInstanceEClass, CSS_HIDE_INSTANCE__STYLESHEET);
		createEAttribute(cssHideInstanceEClass, CSS_HIDE_INSTANCE__STYLE);

		// Create enums
		layerStateEEnum = createEEnum(LAYER_STATE);
		eventLevelEEnum = createEEnum(EVENT_LEVEL);

		// Create data types
		stringEDataType = createEDataType(STRING);
		layersExceptionEDataType = createEDataType(LAYERS_EXCEPTION);
		intEDataType = createEDataType(INT);
		badStateExceptionEDataType = createEDataType(BAD_STATE_EXCEPTION);
		notFoundExceptionEDataType = createEDataType(NOT_FOUND_EXCEPTION);
		computePropertyValueCommandEDataType = createEDataType(COMPUTE_PROPERTY_VALUE_COMMAND);
		booleanEDataType = createEDataType(BOOLEAN);
		ePackageEDataType = createEDataType(EPACKAGE);
		objectEDataType = createEDataType(OBJECT);
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

		// Obtain other dependent packages
		NotationPackage theNotationPackage = (NotationPackage)EPackage.Registry.INSTANCE.getEPackage(NotationPackage.eNS_URI);
		StylesheetsPackage theStylesheetsPackage = (StylesheetsPackage)EPackage.Registry.INSTANCE.getEPackage(StylesheetsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		layerNamedStyleEClass.getESuperTypes().add(theNotationPackage.getNamedStyle());
		layersStackEClass.getESuperTypes().add(this.getLayersContainer());
		layerExpressionEClass.getESuperTypes().add(this.getApplicationDependantElement());
		layersStackApplicationEClass.getESuperTypes().add(this.getFolderElement());
		propertyEClass.getESuperTypes().add(this.getFolderElement());
		typeEClass.getESuperTypes().add(this.getFolderElement());
		typeInstanceEClass.getESuperTypes().add(this.getComputePropertyValueCommandItf());
		layerOperatorEClass.getESuperTypes().add(this.getLayerExpression());
		layerOperatorEClass.getESuperTypes().add(this.getLayersContainer());
		abstractLayerEClass.getESuperTypes().add(this.getLayerExpression());
		folderEClass.getESuperTypes().add(this.getFolderElement());
		metamodelEClass.getESuperTypes().add(this.getFolderElement());
		topLayerOperatorEClass.getESuperTypes().add(this.getLayerOperator());
		stackedLayerOperatorEClass.getESuperTypes().add(this.getLayerOperator());
		simpleLayerDescriptorEClass.getESuperTypes().add(this.getLayerDescriptor());
		nullInstanceEClass.getESuperTypes().add(this.getTypeInstance());
		layerEClass.getESuperTypes().add(this.getAbstractLayer());
		nullPropertySetterEClass.getESuperTypes().add(this.getPropertySetter());
		topLayerOperatorDescriptorEClass.getESuperTypes().add(this.getLayerOperatorDescriptor());
		stackedLayerOperatorDescriptorEClass.getESuperTypes().add(this.getLayerOperatorDescriptor());
		allViewsDerivedLayerEClass.getESuperTypes().add(this.getAbstractLayer());
		cssPropertySetterEClass.getESuperTypes().add(this.getPropertySetter());
		cssTypeEClass.getESuperTypes().add(this.getType());
		cssInstanceEClass.getESuperTypes().add(this.getTypeInstance());
		cssHidePropertySetterEClass.getESuperTypes().add(this.getPropertySetter());
		cssHideTypeEClass.getESuperTypes().add(this.getType());
		cssHideInstanceEClass.getESuperTypes().add(this.getTypeInstance());

		// Initialize classes, features, and operations; add parameters
		initEClass(layerNamedStyleEClass, LayerNamedStyle.class, "LayerNamedStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLayerNamedStyle_LayersStack(), this.getLayersStack(), null, "layersStack", null, 0, -1, LayerNamedStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(layersStackEClass, LayersStack.class, "LayersStack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLayersStack_Layers(), this.getLayerExpression(), null, "layers", null, 0, 1, LayersStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLayersStack_Name(), this.getString(), "name", null, 1, 1, LayersStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLayersStack_Description(), this.getString(), "description", null, 1, 1, LayersStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getLayersStack_Diagram(), theNotationPackage.getDiagram(), null, "diagram", null, 0, 1, LayersStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLayersStack_State(), this.getLayerState(), "state", "detached", 1, 1, LayersStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		EOperation op = initEOperation(getLayersStack__GetComputePropertyValueCommand__View_Property(), this.getComputePropertyValueCommand(), "getComputePropertyValueCommand", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theNotationPackage.getView(), "view", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		op = initEOperation(getLayersStack__GetPropertiesComputePropertyValueCommand__View_List(), this.getComputePropertyValueCommand(), "getPropertiesComputePropertyValueCommand", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theNotationPackage.getView(), "view", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getProperty(), "property", 1, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		op = initEOperation(getLayersStack__GetViewsComputePropertyValueCommand__List_Property(), this.getComputePropertyValueCommand(), "getViewsComputePropertyValueCommand", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theNotationPackage.getView(), "view", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		initEOperation(getLayersStack__StartAfterCreation(), null, "startAfterCreation", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getLayersStack__AttachLayers(), null, "attachLayers", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		op = initEOperation(getLayersStack__Attach(), null, "attach", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		op = initEOperation(getLayersStack__Detach(), null, "detach", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		op = initEOperation(getLayersStack__EnterAttachedState(), null, "enterAttachedState", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		initEOperation(getLayersStack__ExitAttachedState(), null, "exitAttachedState", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(layerExpressionEClass, LayerExpression.class, "LayerExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLayerExpression_Name(), this.getString(), "name", null, 1, 1, LayerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLayerExpression_Description(), this.getString(), "description", null, 1, 1, LayerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLayerExpression_IsLayerEnabledInternal(), this.getboolean(), "isLayerEnabledInternal", null, 1, 1, LayerExpression.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLayerExpression_IsLayerEnabled(), this.getboolean(), "isLayerEnabled", "true", 1, 1, LayerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getLayerExpression_IsBranchEnabled(), this.getboolean(), "isBranchEnabled", "true", 1, 1, LayerExpression.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getLayerExpression_OwningLayersStack(), this.getLayersStack(), null, "owningLayersStack", null, 0, 1, LayerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLayerExpression_State(), this.getLayerState(), "state", "detached", 1, 1, LayerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		op = initEOperation(getLayerExpression__GetComputePropertyValueCommand__View_Property(), this.getComputePropertyValueCommand(), "getComputePropertyValueCommand", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theNotationPackage.getView(), "view", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		op = initEOperation(getLayerExpression__GetViewsComputePropertyValueCommand__List_Property(), this.getComputePropertyValueCommand(), "getViewsComputePropertyValueCommand", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theNotationPackage.getView(), "view", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		op = initEOperation(getLayerExpression__GetPropertiesComputePropertyValueCommand__View_List(), this.getComputePropertyValueCommand(), "getPropertiesComputePropertyValueCommand", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theNotationPackage.getView(), "view", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getProperty(), "property", 1, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		op = initEOperation(getLayerExpression__AttachToLayersStack__LayersStack(), null, "attachToLayersStack", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getLayersStack(), "owningLayersStack", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getLayerExpression__GetLayersStack(), this.getLayersStack(), "getLayersStack", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getNotFoundException());

		op = initEOperation(getLayerExpression__EnterAttachedState(), null, "enterAttachedState", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		op = initEOperation(getLayerExpression__Attach(), null, "attach", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		op = initEOperation(getLayerExpression__Detach(), null, "detach", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		initEOperation(getLayerExpression__ExitAttachedState(), null, "exitAttachedState", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(applicationDependantElementEClass, ApplicationDependantElement.class, "ApplicationDependantElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getApplicationDependantElement_Application(), this.getLayersStackApplication(), null, "application", null, 0, 1, ApplicationDependantElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(layersStackApplicationEClass, LayersStackApplication.class, "LayersStackApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLayersStackApplication_LayersStacks(), this.getLayersStack(), null, "layersStacks", null, 0, -1, LayersStackApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getLayersStackApplication_LayerStackRegistry(), this.getLayerStackDescriptorRegistry(), null, "layerStackRegistry", null, 1, 1, LayersStackApplication.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getLayersStackApplication_PropertyRegistry(), this.getPropertyRegistry(), null, "propertyRegistry", null, 1, 1, LayersStackApplication.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getLayersStackApplication_LayerDescriptorRegistry(), this.getLayerDescriptorRegistry(), null, "layerDescriptorRegistry", null, 1, 1, LayersStackApplication.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getLayersStackApplication_Factory(), this.getLayerApplicationFactory(), this.getLayerApplicationFactory_Application(), "factory", null, 1, 1, LayersStackApplication.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getLayersStackApplication_PropertySetterRegistry(), this.getPropertySetterRegistry(), this.getPropertySetterRegistry_Application(), "propertySetterRegistry", null, 0, 1, LayersStackApplication.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getLayersStackApplication_LayerOperatorDescriptorRegistry(), this.getLayerOperatorDescriptorRegistry(), null, "layerOperatorDescriptorRegistry", null, 0, 1, LayersStackApplication.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getLayersStackApplication__GetLayersStackFor__Diagram(), this.getLayersStack(), "getLayersStackFor", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theNotationPackage.getDiagram(), "diagram", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getLayersStackApplication__RemoveLayersStackFor__Diagram(), null, "removeLayersStackFor", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theNotationPackage.getDiagram(), "diagram", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getLayersStackApplication__IsLayersStackAttachedFor__Diagram(), this.getboolean(), "isLayersStackAttachedFor", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theNotationPackage.getDiagram(), "diagram", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getLayersStackApplication__CreateLayersStackFor__Diagram(), this.getLayersStack(), "createLayersStackFor", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theNotationPackage.getDiagram(), "diagram", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getLayersStackApplication__LookupLayersStackFor__Diagram(), this.getLayersStack(), "lookupLayersStackFor", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theNotationPackage.getDiagram(), "diagram", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getNotFoundException());

		initEClass(folderElementEClass, FolderElement.class, "FolderElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(layerStackDescriptorRegistryEClass, LayerStackDescriptorRegistry.class, "LayerStackDescriptorRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(propertyRegistryEClass, PropertyRegistry.class, "PropertyRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPropertyRegistry_Properties(), this.getProperty(), null, "properties", null, 0, -1, PropertyRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPropertyRegistry_TypeRegistry(), this.getTypeRegistry(), null, "typeRegistry", null, 0, 1, PropertyRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPropertyRegistry_PropertiesCount(), this.getint(), "propertiesCount", null, 1, 1, PropertyRegistry.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getPropertyRegistry__GetPropertyIndex__String(), this.getint(), "getPropertyIndex", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getString(), "propertyName", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getNotFoundException());

		op = initEOperation(getPropertyRegistry__GetProperty__String(), this.getProperty(), "getProperty", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getString(), "propertyName", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getNotFoundException());

		op = initEOperation(getPropertyRegistry__AddProperty__Property(), null, "addProperty", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getProperty_Type(), this.getType(), null, "type", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getProperty_DefaultValue(), this.getTypeInstance(), null, "defaultValue", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getProperty_Name(), this.getString(), "name", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getProperty_Description(), this.getString(), "description", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getProperty_Index(), this.getint(), "index", "-1", 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		op = initEOperation(getProperty__CreateInstance(), this.getTypeInstance(), "createInstance", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getBadStateException());

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getType_Name(), this.getString(), "name", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getType_Description(), this.getString(), "description", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEOperation(getType__CreateInstance(), this.getTypeInstance(), "createInstance", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(typeInstanceEClass, TypeInstance.class, "TypeInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		op = initEOperation(getTypeInstance__SetValueFromString__String(), null, "setValueFromString", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getString(), "value", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getTypeInstance__SetValueFromInstance__TypeInstance(), null, "setValueFromInstance", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getTypeInstance(), "value", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(computePropertyValueCommandItfEClass, ComputePropertyValueCommand.class, "ComputePropertyValueCommandItf", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		op = initEOperation(getComputePropertyValueCommandItf__GetCmdValue(), this.getTypeInstance(), "getCmdValue", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		initEClass(typeRegistryEClass, TypeRegistry.class, "TypeRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypeRegistry_Types(), this.getStringToTypeMap(), null, "types", null, 0, -1, TypeRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(stringToTypeMapEClass, Map.Entry.class, "StringToTypeMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getStringToTypeMap_Value(), this.getType(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getStringToTypeMap_Key(), this.getString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(layerDescriptorRegistryEClass, LayerDescriptorRegistry.class, "LayerDescriptorRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLayerDescriptorRegistry_LayerDescriptors(), this.getLayerDescriptor(), null, "layerDescriptors", null, 0, -1, LayerDescriptorRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(layerDescriptorEClass, LayerDescriptor.class, "LayerDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLayerDescriptor_PropertyRegistry(), this.getPropertyRegistry(), null, "propertyRegistry", null, 1, 1, LayerDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(layerApplicationFactoryEClass, LayerApplicationFactory.class, "LayerApplicationFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLayerApplicationFactory_Application(), this.getLayersStackApplication(), this.getLayersStackApplication_Factory(), "application", null, 0, 1, LayerApplicationFactory.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(propertySetterRegistryEClass, PropertySetterRegistry.class, "PropertySetterRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPropertySetterRegistry_PropertySetters(), this.getPropertySetter(), null, "propertySetters", null, 0, -1, PropertySetterRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPropertySetterRegistry_SetterMap(), this.getStringToPropertySetter(), null, "setterMap", null, 0, -1, PropertySetterRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getPropertySetterRegistry_Application(), this.getLayersStackApplication(), this.getLayersStackApplication_PropertySetterRegistry(), "application", null, 0, 1, PropertySetterRegistry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getPropertySetterRegistry__GetPropertySetter__Property(), this.getPropertySetter(), "getPropertySetter", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getNotFoundException());

		op = initEOperation(getPropertySetterRegistry__GetPropertySetter__String(), this.getPropertySetter(), "getPropertySetter", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getString(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getNotFoundException());

		op = initEOperation(getPropertySetterRegistry__AddPropertySetter__PropertySetter(), null, "addPropertySetter", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getPropertySetter(), "setter", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(propertySetterEClass, PropertySetter.class, "PropertySetter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPropertySetter_Property(), this.getProperty(), null, "property", null, 0, 1, PropertySetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPropertySetter_PropertyName(), this.getString(), "propertyName", null, 1, 1, PropertySetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getPropertySetter__SetValue__View_TypeInstance(), null, "setValue", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theNotationPackage.getView(), "view", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getTypeInstance(), "value", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(stringToPropertySetterEClass, Map.Entry.class, "StringToPropertySetter", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStringToPropertySetter_Key(), this.getString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getStringToPropertySetter_Value(), this.getPropertySetter(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(layerOperatorDescriptorRegistryEClass, LayerOperatorDescriptorRegistry.class, "LayerOperatorDescriptorRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLayerOperatorDescriptorRegistry_Descriptors(), this.getLayerOperatorDescriptor(), null, "descriptors", null, 0, -1, LayerOperatorDescriptorRegistry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getLayerOperatorDescriptorRegistry_PropertyOperators(), this.getPropertyOperator(), null, "propertyOperators", null, 0, -1, LayerOperatorDescriptorRegistry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLayerOperatorDescriptorRegistry_PropertyCollectionSize(), this.getint(), "propertyCollectionSize", null, 1, 1, LayerOperatorDescriptorRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getLayerOperatorDescriptorRegistry_DefaultOperator(), this.getPropertyOperator(), null, "defaultOperator", null, 1, 1, LayerOperatorDescriptorRegistry.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getLayerOperatorDescriptorRegistry__AddLayerOperatorDescriptor__LayerOperatorDescriptor(), null, "addLayerOperatorDescriptor", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getLayerOperatorDescriptor(), "descriptor", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getLayerOperatorDescriptorRegistry__GetLayerOperatorDescriptor__String(), this.getLayerOperatorDescriptor(), "getLayerOperatorDescriptor", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getNotFoundException());

		op = initEOperation(getLayerOperatorDescriptorRegistry__AddPropertyOperator__PropertyOperator(), null, "addPropertyOperator", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getPropertyOperator(), "operator", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getLayerOperatorDescriptorRegistry__GetPropertyOperator__String(), this.getPropertyOperator(), "getPropertyOperator", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getNotFoundException());

		op = initEOperation(getLayerOperatorDescriptorRegistry__AttachOperatorToDescriptor__Property_String_String(), null, "attachOperatorToDescriptor", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getString(), "operatorName", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getString(), "layerDescriptorName", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getNotFoundException());

		op = initEOperation(getLayerOperatorDescriptorRegistry__CreateLayerOperator__String(), this.getLayerOperator(), "createLayerOperator", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getString(), "layerOperatorID", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		initEClass(layerOperatorDescriptorEClass, LayerOperatorDescriptor.class, "LayerOperatorDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLayerOperatorDescriptor_PropertyOperators(), this.getPropertyOperator(), null, "propertyOperators", null, 0, -1, LayerOperatorDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLayerOperatorDescriptor_Name(), this.getString(), "name", null, 1, 1, LayerOperatorDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getLayerOperatorDescriptor__GetPropertyOperator__Property(), this.getPropertyOperator(), "getPropertyOperator", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getNotFoundException());

		op = initEOperation(getLayerOperatorDescriptor__SetPropertyOperator__Property_PropertyOperator(), null, "setPropertyOperator", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getPropertyOperator(), "operator", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEOperation(getLayerOperatorDescriptor__CreateLayerOperator(), this.getLayerOperator(), "createLayerOperator", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getLayerOperatorDescriptor__SetPropertyCollectionSize__int_PropertyOperator(), null, "setPropertyCollectionSize", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getint(), "size", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getPropertyOperator(), "defaultPropertyOperator", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(propertyOperatorEClass, PropertyOperator.class, "PropertyOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getPropertyOperator_Name(), this.getString(), "name", null, 1, 1, PropertyOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPropertyOperator_Classname(), this.getString(), "classname", null, 1, 1, PropertyOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getPropertyOperator_OperatorInstance(), this.getPropertyOperator(), null, "operatorInstance", null, 1, 1, PropertyOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPropertyOperator_ClassBundleID(), this.getString(), "classBundleID", null, 1, 1, PropertyOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getPropertyOperator__GetComputePropertyValueCommand__List(), this.getComputePropertyValueCommand(), "getComputePropertyValueCommand", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getComputePropertyValueCommand(), "property", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		op = initEOperation(getPropertyOperator__ResetOperatorInstance(), null, "resetOperatorInstance", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		initEClass(layerOperatorEClass, LayerOperator.class, "LayerOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLayerOperator_Layers(), this.getLayerExpression(), null, "layers", null, 0, -1, LayerOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLayerOperator_LayerOperatorDescriptorName(), this.getString(), "layerOperatorDescriptorName", null, 1, 1, LayerOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getLayerOperator_LayerOperatorDescriptor(), this.getLayerOperatorDescriptor(), null, "layerOperatorDescriptor", null, 1, 1, LayerOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEOperation(getLayerOperator__IsDescriptorSet(), this.getboolean(), "isDescriptorSet", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEOperation(getLayerOperator__ResetDescriptor(), null, "resetDescriptor", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(layersContainerEClass, LayersContainer.class, "LayersContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		op = initEOperation(getLayersContainer__AddLayer__LayerExpression(), null, "addLayer", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getLayerExpression(), "layer", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractLayerEClass, AbstractLayer.class, "AbstractLayer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAbstractLayer_PropertyValues(), this.getTypeInstance(), null, "propertyValues", null, 0, -1, AbstractLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractLayer_PropertyValueMap(), this.getStringToTypeInstanceMap(), null, "propertyValueMap", null, 0, -1, AbstractLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractLayer_LayerDescriptor(), this.getLayerDescriptor(), null, "layerDescriptor", null, 1, 1, AbstractLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractLayer_Views(), theNotationPackage.getView(), null, "views", null, 0, -1, AbstractLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractLayer_AttachedProperties(), this.getProperty(), null, "attachedProperties", null, 0, -1, AbstractLayer.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getAbstractLayer__AddPropertyInstance__Property(), this.getTypeInstance(), "addPropertyInstance", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		op = initEOperation(getAbstractLayer__RemovePropertyInstance__Property(), null, "removePropertyInstance", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getAbstractLayer__GetPropertyInstance__Property(), this.getTypeInstance(), "getPropertyInstance", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		op = initEOperation(getAbstractLayer__GetPropertyInstance__String(), this.getTypeInstance(), "getPropertyInstance", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getString(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getLayersException());

		initEClass(stringToTypeInstanceMapEClass, Map.Entry.class, "StringToTypeInstanceMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStringToTypeInstanceMap_Key(), this.getString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getStringToTypeInstanceMap_Value(), this.getTypeInstance(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(folderEClass, Folder.class, "Folder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getFolder_Elements(), this.getFolderElement(), null, "elements", null, 0, -1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getFolder_Name(), this.getString(), "name", null, 1, 1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(metamodelEClass, Metamodel.class, "Metamodel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMetamodel_Name(), this.getString(), "name", null, 1, 1, Metamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMetamodel_Description(), this.getString(), "description", null, 1, 1, Metamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMetamodel_Nsuri(), this.getString(), "nsuri", null, 1, 1, Metamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMetamodel_PluginID(), this.getString(), "pluginID", null, 1, 1, Metamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMetamodel_EPackageInstanceName(), this.getString(), "ePackageInstanceName", null, 1, 1, Metamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMetamodel_IsTypeValid(), this.getboolean(), "isTypeValid", null, 1, 1, Metamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEOperation(getMetamodel__GetEPackage(), this.getEPackage(), "getEPackage", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(topLayerOperatorEClass, TopLayerOperator.class, "TopLayerOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(stackedLayerOperatorEClass, StackedLayerOperator.class, "StackedLayerOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(propertyIndexEClass, PropertyIndex.class, "PropertyIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPropertyIndex_Property(), this.getProperty(), null, "property", null, 1, 1, PropertyIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPropertyIndex_Index(), this.getint(), "index", null, 1, 1, PropertyIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(stringToPropertyIndexMapEClass, Map.Entry.class, "StringToPropertyIndexMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getStringToPropertyIndexMap_Value(), this.getPropertyIndex(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getStringToPropertyIndexMap_Key(), this.getString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(simpleLayerDescriptorEClass, SimpleLayerDescriptor.class, "SimpleLayerDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(nullInstanceEClass, NullInstance.class, "NullInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEOperation(getNullInstance__GetInstance(), this.getNullInstance(), "getInstance", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(layerEClass, Layer.class, "Layer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(nullPropertySetterEClass, NullPropertySetter.class, "NullPropertySetter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(topLayerOperatorDescriptorEClass, TopLayerOperatorDescriptor.class, "TopLayerOperatorDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(stackedLayerOperatorDescriptorEClass, StackedLayerOperatorDescriptor.class, "StackedLayerOperatorDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(allViewsDerivedLayerEClass, AllViewsDerivedLayer.class, "AllViewsDerivedLayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(cssPropertySetterEClass, CSSPropertySetter.class, "CSSPropertySetter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(cssTypeEClass, CSSType.class, "CSSType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(cssInstanceEClass, CSSInstance.class, "CSSInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCSSInstance_Stylesheet(), theStylesheetsPackage.getStyleSheet(), null, "stylesheet", null, 1, 1, CSSInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getCSSInstance_Style(), this.getString(), "style", null, 0, 1, CSSInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(cssHidePropertySetterEClass, CSSHidePropertySetter.class, "CSSHidePropertySetter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(cssHideTypeEClass, CSSHideType.class, "CSSHideType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(cssHideInstanceEClass, CSSHideInstance.class, "CSSHideInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCSSHideInstance_Stylesheet(), theStylesheetsPackage.getStyleSheet(), null, "stylesheet", null, 1, 1, CSSHideInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getCSSHideInstance_Style(), this.getString(), "style", null, 0, 1, CSSHideInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(layerStateEEnum, LayerState.class, "LayerState"); //$NON-NLS-1$
		addEEnumLiteral(layerStateEEnum, LayerState.DETACHED);
		addEEnumLiteral(layerStateEEnum, LayerState.ATTACHED);

		initEEnum(eventLevelEEnum, EventLevel.class, "EventLevel"); //$NON-NLS-1$
		addEEnumLiteral(eventLevelEEnum, EventLevel.LEVEL1);
		addEEnumLiteral(eventLevelEEnum, EventLevel.ALL_LEVELS);

		// Initialize data types
		initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(layersExceptionEDataType, LayersException.class, "LayersException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(intEDataType, int.class, "int", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(badStateExceptionEDataType, BadStateException.class, "BadStateException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(notFoundExceptionEDataType, NotFoundException.class, "NotFoundException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(computePropertyValueCommandEDataType, ComputePropertyValueCommand.class, "ComputePropertyValueCommand", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(booleanEDataType, boolean.class, "boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(ePackageEDataType, EPackage.class, "EPackage", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(objectEDataType, Object.class, "Object", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
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
			   "originalName", "Layers" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$
		addAnnotation
		  (badStateExceptionEDataType,
		   source,
		   new String[] {
			   "baseType", "LayersException" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (notFoundExceptionEDataType,
		   source,
		   new String[] {
			   "baseType", "LayersException" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //LayersPackageImpl
