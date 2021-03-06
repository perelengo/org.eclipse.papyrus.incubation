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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.custom;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.LayersItemProviderAdapterFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.StackedLayerOperatorItemProvider;


/**
 * A custom {@link LayersItemProviderAdapterFactory} used to render layers element
 * in a tree.
 * This factory and its overloaded Providers removed extra nodes in the tree. <br>
 * The factory extends the original one {@link LayersItemProviderAdapterFactory}. <br>
 * To override an ItemProvider, different strategies can be used, depending if we override one single node,
 * or a hierarchy of node (inheritance).
 * <h2>Single Node</h2>
 * <ul>
 * <li>Create, in custom, a new XxxItemProvider extending the original one.</li>
 * <li>Add corresponding createXxxItemProvider() in {@link LayersItemProviderAdapterFactory}</li>
 * </ul>
 *
 * <h2>Hierarchy of node</h2> By hierarchy, we mean classes with inheritance, with one common ancestor.
 * See {@link CustomAbstractLayerItemProvider} as example.
 * <ul>
 * <li>Create, in custom package, a new XxxItemProvider for the common ancestor, extending the original ItemProvider.</li>
 * <ul>
 * <li>Create a property 'extendedDelegate :: OriginalAncestorItemProvider</li>
 * <li>Override getImage(), getText(), getPropertyDescriptors() and notifyChanged(), let them return their counterpart from extendedDelegate (i.e.: extendedDelegate.getText()).</li>
 * <li>This will allow subclasses to use the counterpart methods from their original implementation.</li>
 * <li>Create a constructor with the factory and the extendedDelegate as parameter</li>
 * <li></li>
 * </ul>
 * <li>in custom {@link LayersItemProviderAdapterFactory}:</li>
 * <ul>
 * <li>Add a property XxxItemAdapter xxxItemAdapter; for each each class of the hierarchy</li>
 * <li>Override methods createXxxItemAdapter() for each class of the hierarchy.</li>
 * <li>in the method, create the instance of the property, provide the factory, and an instance of the extendedClass</li>
 * <li></li>
 * </ul>
 * <li></li>
 * </ul>
 *
 * <br>
 * To use a custom Providers, it is necessary to create it in this factory.
 *
 * @author cedric dumoulin
 *
 */
public class CustomLayersItemProviderAdapterFactory extends LayersItemProviderAdapterFactory {

	protected CustomLayerItemProvider layerItemProvider;
	protected CustomAllViewsDerivedLayerItemProvider allViewsDerivedLayerItemProvider;

	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.LayersItemProviderAdapterFactory#createLayersStackApplicationAdapter()
	 *
	 * @return
	 */
	@Override
	public Adapter createLayersStackApplicationAdapter() {
		if (layersStackApplicationItemProvider == null) {
			layersStackApplicationItemProvider = new CustomLayersStackApplicationItemProvider(this);
		}

		return layersStackApplicationItemProvider;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.LayersItemProviderAdapterFactory#createLayerAdapter()
	 *
	 * @return
	 */
	@Override
	public Adapter createLayerAdapter() {
		if (layerItemProvider == null) {
			layerItemProvider = new CustomLayerItemProvider(this,
					(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.LayerItemProvider) super.createLayerAdapter());
		}

		return layerItemProvider;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.LayersItemProviderAdapterFactory#createAllViewsDerivedLayerAdapter()
	 *
	 * @return
	 */
	@Override
	public Adapter createAllViewsDerivedLayerAdapter() {
		if (allViewsDerivedLayerItemProvider == null) {
			allViewsDerivedLayerItemProvider = new CustomAllViewsDerivedLayerItemProvider(this,
					(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.AllViewsDerivedLayerItemProvider) super.createAllViewsDerivedLayerAdapter());
		}

		return allViewsDerivedLayerItemProvider;
	}
	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.LayersItemProviderAdapterFactory#createStringToTypeInstanceMapAdapter()
	 *
	 * @return
	 */
	// @Override
	// public Adapter createStringToTypeInstanceMapAdapter() {
	// if (stringToTypeInstanceMapItemProvider == null) {
	// stringToTypeInstanceMapItemProvider = new StringToTypeInstanceMapItemProvider(this);
	// }
	//
	// return stringToTypeInstanceMapItemProvider;
	// }

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.LayersItemProviderAdapterFactory#createStackedLayerOperatorAdapter()
	 *
	 * @return
	 */
	@Override
	public Adapter createStackedLayerOperatorAdapter() {
		return new CustomStackedLayerOperatorItemProvider(this);
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.LayersItemProviderAdapterFactory#createTopLayerOperatorAdapter()
	 *
	 * @return
	 */
	@Override
	public Adapter createTopLayerOperatorAdapter() {
		return new CustomTopLayerOperatorItemProvider(this);
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.LayersItemProviderAdapterFactory#createLayerNamedStyleAdapter()
	 *
	 * @return
	 */
	@Override
	public Adapter createLayerNamedStyleAdapter() {
		return new CustomLayerNamedStyleItemProvider(this);
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.LayersItemProviderAdapterFactory#createLayersStackAdapter()
	 *
	 * @return
	 */
	@Override
	public Adapter createLayersStackAdapter() {
		return new CustomLayersStackItemProvider(this);
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.LayersItemProviderAdapterFactory#createStringToTypeInstanceMapAdapter()
	 *
	 * @return
	 */
	@Override
	public Adapter createStringToTypeInstanceMapAdapter() {
		return new CustomStringToTypeInstanceMapItemProvider(this);
	}

}
