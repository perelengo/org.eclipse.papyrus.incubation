/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.custom;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerApplicationFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptorRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerStackDescriptorRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersStackApplicationImpl;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.loaders.LayersConfigModel;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.loaders.RegistriesLoader;

/**
 * @author QL238289
 *
 */
public class CustomLayersStackApplicationImpl extends LayersStackApplicationImpl {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	protected CustomLayersStackApplicationImpl() {
		super();
		init();
	}

	/**
	 * Init the class
	 * Create the internal objects : {@link PropertyRegistry}, {@link LayerStackDescriptorRegistry}.
	 */
	protected void init() {
		// Create the PropertyRegistry
		PropertyRegistry propertyRegistry = LayersFactory.eINSTANCE.createPropertyRegistry();
		setPropertyRegistry(propertyRegistry);

		// Create the LayerStackDescriptorRegistry
		LayerStackDescriptorRegistry layerStackDescriptorRegistry = LayersFactory.eINSTANCE.createLayerStackDescriptorRegistry();
		setLayerStackRegistry(layerStackDescriptorRegistry);

		// Create the LayerDescriptorRegistry
		LayerDescriptorRegistry layerDescriptorRegistry = LayersFactory.eINSTANCE.createLayerDescriptorRegistry();
		setLayerDescriptorRegistry(layerDescriptorRegistry);

		// Create the config model and the registries loader
		LayersConfigModel configModel = LayersConfigModel.getInstance();
		RegistriesLoader registriesLoader = new RegistriesLoader(configModel);

		// Create the LayerOperatorDescriptorRegistry
		LayerOperatorDescriptorRegistry layerOperatorDescriptorRegistry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		layerOperatorDescriptorRegistry.setPropertyCollectionSize(propertyRegistry.getPropertiesCount());

		registriesLoader.loadLayerOperatorDescriptorRegistry(layerOperatorDescriptorRegistry, propertyRegistry);
		setLayerOperatorDescriptorRegistry(layerOperatorDescriptorRegistry);

		// Create the LayerApplicationFactory
		LayerApplicationFactory layerApplicationFactory = LayersFactory.eINSTANCE.createLayerApplicationFactory();
		setFactory(layerApplicationFactory);

		// Create the PropertySetterRegistry
		PropertySetterRegistry propertySetterRegistry = LayersFactory.eINSTANCE.createPropertySetterRegistry();
		propertySetterRegistry.setApplication(this);
		setPropertySetterRegistry(propertySetterRegistry);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public void removeLayersStackFor(Diagram diagram) {

		try {
			LayersStack stack = lookupLayersStackFor(diagram);
			getLayersStacks().remove(stack);
		} catch (NotFoundException e) {
			// silently fails
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public boolean isLayersStackAttachedFor(Diagram diagram) {
		try {
			lookupLayersStackFor(diagram);
			return true;
		} catch (NotFoundException e) {
			// not found
			return false;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public LayersStack lookupLayersStackFor(Diagram diagram) throws NotFoundException {
		for (LayersStack stack : getLayersStacks()) {
			if (stack.getDiagram() == diagram) {
				return stack;
			}
		}

		// Not found
		throw new NotFoundException("No LayersStack attached for diagram: " + diagram);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Get the {@link LayersStack} for the specified diagram. Create it if
	 * necessary.
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public LayersStack getLayersStackFor(Diagram diagram) {
		try {
			return lookupLayersStackFor(diagram);
		} catch (NotFoundException e) {
			// Create a new one
			return createLayersStackFor(diagram);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Create a new LayersStack for the specified diagram.
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public LayersStack createLayersStackFor(Diagram diagram) {

		// Create a new LayerStack and add it to application (this)
		LayersStack layer = LayersFactory.eINSTANCE.createLayersStack();
		layer.startAfterCreation();
		layer.setDiagram(diagram);

		// Create first layer in stack
		TopLayerOperator rootLayer = LayersFactory.eINSTANCE.createTopLayerOperator();
		rootLayer.setName("Top Layer");
		rootLayer.setApplication(this);
		layer.setLayers(rootLayer);

		// attach stack to application
		getLayersStacks().add(layer);


		return layer;
	}

}
