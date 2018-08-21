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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.Style;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage
 * @generated
 */
public class LayersAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LayersPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = LayersPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayersSwitch<Adapter> modelSwitch =
		new LayersSwitch<Adapter>() {
			@Override
			public Adapter caseLayerNamedStyle(LayerNamedStyle object) {
				return createLayerNamedStyleAdapter();
			}
			@Override
			public Adapter caseLayersStack(LayersStack object) {
				return createLayersStackAdapter();
			}
			@Override
			public Adapter caseLayerExpression(LayerExpression object) {
				return createLayerExpressionAdapter();
			}
			@Override
			public Adapter caseApplicationDependantElement(ApplicationDependantElement object) {
				return createApplicationDependantElementAdapter();
			}
			@Override
			public Adapter caseLayersStackApplication(LayersStackApplication object) {
				return createLayersStackApplicationAdapter();
			}
			@Override
			public Adapter caseFolderElement(FolderElement object) {
				return createFolderElementAdapter();
			}
			@Override
			public Adapter caseLayerStackDescriptorRegistry(LayerStackDescriptorRegistry object) {
				return createLayerStackDescriptorRegistryAdapter();
			}
			@Override
			public Adapter casePropertyRegistry(PropertyRegistry object) {
				return createPropertyRegistryAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseTypeInstance(TypeInstance object) {
				return createTypeInstanceAdapter();
			}
			@Override
			public Adapter caseComputePropertyValueCommandItf(ComputePropertyValueCommand object) {
				return createComputePropertyValueCommandItfAdapter();
			}
			@Override
			public Adapter caseTypeRegistry(TypeRegistry object) {
				return createTypeRegistryAdapter();
			}
			@Override
			public Adapter caseStringToTypeMap(Map.Entry<String, Type> object) {
				return createStringToTypeMapAdapter();
			}
			@Override
			public Adapter caseLayerDescriptorRegistry(LayerDescriptorRegistry object) {
				return createLayerDescriptorRegistryAdapter();
			}
			@Override
			public Adapter caseLayerDescriptor(LayerDescriptor object) {
				return createLayerDescriptorAdapter();
			}
			@Override
			public Adapter caseLayerApplicationFactory(LayerApplicationFactory object) {
				return createLayerApplicationFactoryAdapter();
			}
			@Override
			public Adapter casePropertySetterRegistry(PropertySetterRegistry object) {
				return createPropertySetterRegistryAdapter();
			}
			@Override
			public Adapter casePropertySetter(PropertySetter object) {
				return createPropertySetterAdapter();
			}
			@Override
			public Adapter caseStringToPropertySetter(Map.Entry<String, PropertySetter> object) {
				return createStringToPropertySetterAdapter();
			}
			@Override
			public Adapter caseLayerOperatorDescriptorRegistry(LayerOperatorDescriptorRegistry object) {
				return createLayerOperatorDescriptorRegistryAdapter();
			}
			@Override
			public Adapter caseLayerOperatorDescriptor(LayerOperatorDescriptor object) {
				return createLayerOperatorDescriptorAdapter();
			}
			@Override
			public Adapter casePropertyOperator(PropertyOperator object) {
				return createPropertyOperatorAdapter();
			}
			@Override
			public Adapter caseLayerOperator(LayerOperator object) {
				return createLayerOperatorAdapter();
			}
			@Override
			public Adapter caseLayersContainer(LayersContainer object) {
				return createLayersContainerAdapter();
			}
			@Override
			public Adapter caseAbstractLayer(AbstractLayer object) {
				return createAbstractLayerAdapter();
			}
			@Override
			public Adapter caseStringToTypeInstanceMap(Map.Entry<String, TypeInstance> object) {
				return createStringToTypeInstanceMapAdapter();
			}
			@Override
			public Adapter caseFolder(Folder object) {
				return createFolderAdapter();
			}
			@Override
			public Adapter caseMetamodel(Metamodel object) {
				return createMetamodelAdapter();
			}
			@Override
			public Adapter caseTopLayerOperator(TopLayerOperator object) {
				return createTopLayerOperatorAdapter();
			}
			@Override
			public Adapter caseStackedLayerOperator(StackedLayerOperator object) {
				return createStackedLayerOperatorAdapter();
			}
			@Override
			public Adapter casePropertyIndex(PropertyIndex object) {
				return createPropertyIndexAdapter();
			}
			@Override
			public Adapter caseStringToPropertyIndexMap(Map.Entry<String, PropertyIndex> object) {
				return createStringToPropertyIndexMapAdapter();
			}
			@Override
			public Adapter caseSimpleLayerDescriptor(SimpleLayerDescriptor object) {
				return createSimpleLayerDescriptorAdapter();
			}
			@Override
			public Adapter caseNullInstance(NullInstance object) {
				return createNullInstanceAdapter();
			}
			@Override
			public Adapter caseLayer(Layer object) {
				return createLayerAdapter();
			}
			@Override
			public Adapter caseNullPropertySetter(NullPropertySetter object) {
				return createNullPropertySetterAdapter();
			}
			@Override
			public Adapter caseTopLayerOperatorDescriptor(TopLayerOperatorDescriptor object) {
				return createTopLayerOperatorDescriptorAdapter();
			}
			@Override
			public Adapter caseStackedLayerOperatorDescriptor(StackedLayerOperatorDescriptor object) {
				return createStackedLayerOperatorDescriptorAdapter();
			}
			@Override
			public Adapter caseAllViewsDerivedLayer(AllViewsDerivedLayer object) {
				return createAllViewsDerivedLayerAdapter();
			}
			@Override
			public Adapter caseCSSPropertySetter(CSSPropertySetter object) {
				return createCSSPropertySetterAdapter();
			}
			@Override
			public Adapter caseCSSType(CSSType object) {
				return createCSSTypeAdapter();
			}
			@Override
			public Adapter caseCSSInstance(CSSInstance object) {
				return createCSSInstanceAdapter();
			}
			@Override
			public Adapter caseCSSHidePropertySetter(CSSHidePropertySetter object) {
				return createCSSHidePropertySetterAdapter();
			}
			@Override
			public Adapter caseCSSHideType(CSSHideType object) {
				return createCSSHideTypeAdapter();
			}
			@Override
			public Adapter caseCSSHideInstance(CSSHideInstance object) {
				return createCSSHideInstanceAdapter();
			}
			@Override
			public Adapter caseStyle(Style object) {
				return createStyleAdapter();
			}
			@Override
			public Adapter caseNamedStyle(NamedStyle object) {
				return createNamedStyleAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerNamedStyle <em>Layer Named Style</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerNamedStyle
	 * @generated
	 */
	public Adapter createLayerNamedStyleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack <em>Stack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack
	 * @generated
	 */
	public Adapter createLayersStackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression <em>Layer Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression
	 * @generated
	 */
	public Adapter createLayerExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ApplicationDependantElement <em>Application Dependant Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ApplicationDependantElement
	 * @generated
	 */
	public Adapter createApplicationDependantElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication <em>Stack Application</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication
	 * @generated
	 */
	public Adapter createLayersStackApplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FolderElement <em>Folder Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FolderElement
	 * @generated
	 */
	public Adapter createFolderElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerStackDescriptorRegistry <em>Layer Stack Descriptor Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerStackDescriptorRegistry
	 * @generated
	 */
	public Adapter createLayerStackDescriptorRegistryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry <em>Property Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry
	 * @generated
	 */
	public Adapter createPropertyRegistryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance <em>Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance
	 * @generated
	 */
	public Adapter createTypeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand <em>Compute Property Value Command Itf</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand
	 * @generated
	 */
	public Adapter createComputePropertyValueCommandItfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeRegistry <em>Type Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeRegistry
	 * @generated
	 */
	public Adapter createTypeRegistryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String To Type Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStringToTypeMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptorRegistry <em>Layer Descriptor Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptorRegistry
	 * @generated
	 */
	public Adapter createLayerDescriptorRegistryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptor <em>Layer Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptor
	 * @generated
	 */
	public Adapter createLayerDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerApplicationFactory <em>Layer Application Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerApplicationFactory
	 * @generated
	 */
	public Adapter createLayerApplicationFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry <em>Property Setter Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry
	 * @generated
	 */
	public Adapter createPropertySetterRegistryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter <em>Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter
	 * @generated
	 */
	public Adapter createPropertySetterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String To Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStringToPropertySetterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry <em>Layer Operator Descriptor Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry
	 * @generated
	 */
	public Adapter createLayerOperatorDescriptorRegistryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor <em>Layer Operator Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor
	 * @generated
	 */
	public Adapter createLayerOperatorDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator <em>Property Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator
	 * @generated
	 */
	public Adapter createPropertyOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator <em>Layer Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator
	 * @generated
	 */
	public Adapter createLayerOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersContainer
	 * @generated
	 */
	public Adapter createLayersContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer <em>Abstract Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer
	 * @generated
	 */
	public Adapter createAbstractLayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String To Type Instance Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStringToTypeInstanceMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Folder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Folder
	 * @generated
	 */
	public Adapter createFolderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel
	 * @generated
	 */
	public Adapter createMetamodelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperator <em>Top Layer Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperator
	 * @generated
	 */
	public Adapter createTopLayerOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StackedLayerOperator <em>Stacked Layer Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StackedLayerOperator
	 * @generated
	 */
	public Adapter createStackedLayerOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyIndex <em>Property Index</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyIndex
	 * @generated
	 */
	public Adapter createPropertyIndexAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String To Property Index Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStringToPropertyIndexMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.SimpleLayerDescriptor <em>Simple Layer Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.SimpleLayerDescriptor
	 * @generated
	 */
	public Adapter createSimpleLayerDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NullInstance <em>Null Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NullInstance
	 * @generated
	 */
	public Adapter createNullInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Layer <em>Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Layer
	 * @generated
	 */
	public Adapter createLayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NullPropertySetter <em>Null Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NullPropertySetter
	 * @generated
	 */
	public Adapter createNullPropertySetterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperatorDescriptor <em>Top Layer Operator Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperatorDescriptor
	 * @generated
	 */
	public Adapter createTopLayerOperatorDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StackedLayerOperatorDescriptor <em>Stacked Layer Operator Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StackedLayerOperatorDescriptor
	 * @generated
	 */
	public Adapter createStackedLayerOperatorDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AllViewsDerivedLayer <em>All Views Derived Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AllViewsDerivedLayer
	 * @generated
	 */
	public Adapter createAllViewsDerivedLayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSPropertySetter <em>CSS Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSPropertySetter
	 * @generated
	 */
	public Adapter createCSSPropertySetterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSType <em>CSS Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSType
	 * @generated
	 */
	public Adapter createCSSTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSInstance <em>CSS Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSInstance
	 * @generated
	 */
	public Adapter createCSSInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHidePropertySetter <em>CSS Hide Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHidePropertySetter
	 * @generated
	 */
	public Adapter createCSSHidePropertySetterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideType <em>CSS Hide Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideType
	 * @generated
	 */
	public Adapter createCSSHideTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideInstance <em>CSS Hide Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideInstance
	 * @generated
	 */
	public Adapter createCSSHideInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.runtime.notation.Style <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.runtime.notation.Style
	 * @generated
	 */
	public Adapter createStyleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.runtime.notation.NamedStyle <em>Named Style</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.runtime.notation.NamedStyle
	 * @generated
	 */
	public Adapter createNamedStyleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //LayersAdapterFactory
