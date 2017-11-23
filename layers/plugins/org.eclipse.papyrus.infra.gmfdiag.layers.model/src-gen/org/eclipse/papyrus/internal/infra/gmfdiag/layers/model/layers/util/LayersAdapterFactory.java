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
	protected LayersSwitch<Adapter> modelSwitch = new LayersSwitch<Adapter>() {
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
			public Adapter caseMetamodel(Metamodel object) {
				return createMetamodelAdapter();
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
			public Adapter caseAbstractLayerOperator(AbstractLayerOperator object) {
				return createAbstractLayerOperatorAdapter();
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
			public Adapter caseDefaultPropertyOperator(DefaultPropertyOperator object) {
				return createDefaultPropertyOperatorAdapter();
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
			public Adapter caseIntInstance(IntInstance object) {
				return createIntInstanceAdapter();
			}
			@Override
			public Adapter caseBooleanInstance(BooleanInstance object) {
				return createBooleanInstanceAdapter();
			}
			@Override
			public Adapter caseStringInstance(StringInstance object) {
				return createStringInstanceAdapter();
			}
			@Override
			public Adapter caseIntType(IntType object) {
				return createIntTypeAdapter();
			}
			@Override
			public Adapter caseBooleanType(BooleanType object) {
				return createBooleanTypeAdapter();
			}
			@Override
			public Adapter caseStringType(StringType object) {
				return createStringTypeAdapter();
			}
			@Override
			public Adapter caseCustomType(CustomType object) {
				return createCustomTypeAdapter();
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
			public Adapter caseCustomLayerOperator(CustomLayerOperator object) {
				return createCustomLayerOperatorAdapter();
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
			public Adapter caseRegExpLayerDescriptor(RegExpLayerDescriptor object) {
				return createRegExpLayerDescriptorAdapter();
			}
			@Override
			public Adapter caseNullInstance(NullInstance object) {
				return createNullInstanceAdapter();
			}
			@Override
			public Adapter caseRegExpLayer(RegExpLayer object) {
				return createRegExpLayerAdapter();
			}
			@Override
			public Adapter caseLayer(Layer object) {
				return createLayerAdapter();
			}
			@Override
			public Adapter caseColor(Color object) {
				return createColorAdapter();
			}
			@Override
			public Adapter caseColorInstance(ColorInstance object) {
				return createColorInstanceAdapter();
			}
			@Override
			public Adapter caseFillInstance(FillInstance object) {
				return createFillInstanceAdapter();
			}
			@Override
			public Adapter caseFill(Fill object) {
				return createFillAdapter();
			}
			@Override
			public Adapter caseFillPropertySetter(FillPropertySetter object) {
				return createFillPropertySetterAdapter();
			}
			@Override
			public Adapter caseIsValidPropertySetter(IsValidPropertySetter object) {
				return createIsValidPropertySetterAdapter();
			}
			@Override
			public Adapter caseNullPropertySetter(NullPropertySetter object) {
				return createNullPropertySetterAdapter();
			}
			@Override
			public Adapter caseLineType(LineType object) {
				return createLineTypeAdapter();
			}
			@Override
			public Adapter caseLineInstance(LineInstance object) {
				return createLineInstanceAdapter();
			}
			@Override
			public Adapter caseLinePropertySetter(LinePropertySetter object) {
				return createLinePropertySetterAdapter();
			}
			@Override
			public Adapter caseFontPropertySetter(FontPropertySetter object) {
				return createFontPropertySetterAdapter();
			}
			@Override
			public Adapter caseFontInstance(FontInstance object) {
				return createFontInstanceAdapter();
			}
			@Override
			public Adapter caseFontType(FontType object) {
				return createFontTypeAdapter();
			}
			@Override
			public Adapter caseIsVisiblePropertySetter(IsVisiblePropertySetter object) {
				return createIsVisiblePropertySetterAdapter();
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
			public Adapter caseCustomPropertyOperator(CustomPropertyOperator object) {
				return createCustomPropertyOperatorAdapter();
			}
			@Override
			public Adapter caseAndStackedLayerOperatorDescriptor(AndStackedLayerOperatorDescriptor object) {
				return createAndStackedLayerOperatorDescriptorAdapter();
			}
			@Override
			public Adapter caseOrStackedLayerOperatorDescriptor(OrStackedLayerOperatorDescriptor object) {
				return createOrStackedLayerOperatorDescriptorAdapter();
			}
			@Override
			public Adapter caseIsAbstractUmlSetter(IsAbstractUmlSetter object) {
				return createIsAbstractUmlSetterAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Color <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Color
	 * @generated
	 */
	public Adapter createColorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ColorInstance <em>Color Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ColorInstance
	 * @generated
	 */
	public Adapter createColorInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillInstance <em>Fill Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillInstance
	 * @generated
	 */
	public Adapter createFillInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Fill <em>Fill</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Fill
	 * @generated
	 */
	public Adapter createFillAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillPropertySetter <em>Fill Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillPropertySetter
	 * @generated
	 */
	public Adapter createFillPropertySetterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IsValidPropertySetter <em>Is Valid Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IsValidPropertySetter
	 * @generated
	 */
	public Adapter createIsValidPropertySetterAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LineType <em>Line Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LineType
	 * @generated
	 */
	public Adapter createLineTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LineInstance <em>Line Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LineInstance
	 * @generated
	 */
	public Adapter createLineInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LinePropertySetter <em>Line Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LinePropertySetter
	 * @generated
	 */
	public Adapter createLinePropertySetterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontPropertySetter <em>Font Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontPropertySetter
	 * @generated
	 */
	public Adapter createFontPropertySetterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontInstance <em>Font Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontInstance
	 * @generated
	 */
	public Adapter createFontInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontType <em>Font Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontType
	 * @generated
	 */
	public Adapter createFontTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IsVisiblePropertySetter <em>Is Visible Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IsVisiblePropertySetter
	 * @generated
	 */
	public Adapter createIsVisiblePropertySetterAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomPropertyOperator <em>Custom Property Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomPropertyOperator
	 * @generated
	 */
	public Adapter createCustomPropertyOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AndStackedLayerOperatorDescriptor <em>And Stacked Layer Operator Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AndStackedLayerOperatorDescriptor
	 * @generated
	 */
	public Adapter createAndStackedLayerOperatorDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.OrStackedLayerOperatorDescriptor <em>Or Stacked Layer Operator Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.OrStackedLayerOperatorDescriptor
	 * @generated
	 */
	public Adapter createOrStackedLayerOperatorDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IsAbstractUmlSetter <em>Is Abstract Uml Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IsAbstractUmlSetter
	 * @generated
	 */
	public Adapter createIsAbstractUmlSetterAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IntInstance <em>Int Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IntInstance
	 * @generated
	 */
	public Adapter createIntInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.BooleanInstance <em>Boolean Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.BooleanInstance
	 * @generated
	 */
	public Adapter createBooleanInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StringInstance <em>String Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StringInstance
	 * @generated
	 */
	public Adapter createStringInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IntType <em>Int Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IntType
	 * @generated
	 */
	public Adapter createIntTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.BooleanType
	 * @generated
	 */
	public Adapter createBooleanTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StringType
	 * @generated
	 */
	public Adapter createStringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomType <em>Custom Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomType
	 * @generated
	 */
	public Adapter createCustomTypeAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayerDescriptor <em>Reg Exp Layer Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayerDescriptor
	 * @generated
	 */
	public Adapter createRegExpLayerDescriptorAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer <em>Reg Exp Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer
	 * @generated
	 */
	public Adapter createRegExpLayerAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator <em>Abstract Layer Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator
	 * @generated
	 */
	public Adapter createAbstractLayerOperatorAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.DefaultPropertyOperator <em>Default Property Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.DefaultPropertyOperator
	 * @generated
	 */
	public Adapter createDefaultPropertyOperatorAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomLayerOperator <em>Custom Layer Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomLayerOperator
	 * @generated
	 */
	public Adapter createCustomLayerOperatorAdapter() {
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

} // LayersAdapterFactory
