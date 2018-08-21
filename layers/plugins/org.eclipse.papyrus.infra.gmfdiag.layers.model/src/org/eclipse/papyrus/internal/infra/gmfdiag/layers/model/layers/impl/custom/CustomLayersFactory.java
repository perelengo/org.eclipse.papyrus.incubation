package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.custom;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AllViewsDerivedLayer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHidePropertySetter;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideType;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSPropertySetter;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSType;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NullPropertySetter;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StackedLayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StackedLayerOperatorDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperatorDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl;

public class CustomLayersFactory extends LayersFactoryImpl {

	public CustomLayersFactory() {
		// should never be required
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createCSSType()
	 *
	 * @return
	 */
	@Override
	public CSSType createCSSType() {
		return new CustomCSSTypeImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createCSSPropertySetter()
	 *
	 * @return
	 */
	@Override
	public CSSPropertySetter createCSSPropertySetter() {
		return new CustomCSSPropertySetterImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createCSSHidePropertySetter()
	 *
	 * @return
	 */
	@Override
	public CSSHidePropertySetter createCSSHidePropertySetter() {
		return new CustomCSSHidePropertySetterImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createCSSHideType()
	 *
	 * @return
	 */
	@Override
	public CSSHideType createCSSHideType() {
		return new CustomCSSHideTypeImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createAllViewsDerivedLayer()
	 *
	 * @return
	 */
	@Override
	public AllViewsDerivedLayer createAllViewsDerivedLayer() {
		return new CustomAllViewsDerivedLayerImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createStackedLayerOperator()
	 *
	 * @return
	 */
	@Override
	public StackedLayerOperator createStackedLayerOperator() {
		return new CustomStackedLayerOperatorImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createTopLayerOperatorDescriptor()
	 *
	 * @return
	 */
	@Override
	public TopLayerOperatorDescriptor createTopLayerOperatorDescriptor() {
		return new CustomTopLayerOperatorDescriptorImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createStackedLayerOperatorDescriptor()
	 *
	 * @return
	 */
	@Override
	public StackedLayerOperatorDescriptor createStackedLayerOperatorDescriptor() {
		return new CustomStackedLayerOperatorDescriptorImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createCSSInstance()
	 *
	 * @return
	 */
	@Override
	public CSSInstance createCSSInstance() {
		return new CustomCSSInstanceImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createCSSHideInstance()
	 *
	 * @return
	 */
	@Override
	public CSSHideInstance createCSSHideInstance() {
		return new CustomCSSHideInstanceImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createTypeRegistry()
	 *
	 * @return
	 */
	@Override
	public TypeRegistry createTypeRegistry() {
		return new CustomTypeRegistryImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createPropertySetterRegistry()
	 *
	 * @return
	 */
	@Override
	public PropertySetterRegistry createPropertySetterRegistry() {
		return new CustomPropertySetterRegistryImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createLayersStack()
	 *
	 * @return
	 */
	@Override
	public LayersStack createLayersStack() {
		return new CustomLayersStackImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createPropertyRegistry()
	 *
	 * @return
	 */
	@Override
	public PropertyRegistry createPropertyRegistry() {
		return new CustomPropertyRegistryImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createCustomPropertyOperator()
	 *
	 * @return
	 */
	@Override
	public PropertyOperator createPropertyOperator() {
		return new CustomPropertyOperatorImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createLayerOperatorDescriptorRegistry()
	 *
	 * @return
	 */
	@Override
	public LayerOperatorDescriptorRegistry createLayerOperatorDescriptorRegistry() {
		return new CustomLayerOperatorDescriptorRegistryImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createLayersStackApplication()
	 *
	 * @return
	 */
	@Override
	public LayersStackApplication createLayersStackApplication() {
		return new CustomLayersStackApplicationImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createNullPropertySetter()
	 *
	 * @return
	 */
	@Override
	public NullPropertySetter createNullPropertySetter() {
		return new CustomNullPropertySetterImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createProperty()
	 *
	 * @return
	 */
	@Override
	public Property createProperty() {
		return new CustomPropertyImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersFactoryImpl#createTopLayerOperator()
	 *
	 * @return
	 */
	@Override
	public TopLayerOperator createTopLayerOperator() {
		return new CustomTopLayerOperatorImpl();
	}



}
