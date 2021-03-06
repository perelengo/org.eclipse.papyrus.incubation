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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.loaders;

import static org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.Activator.log;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayerOperatorConfig;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.OperatorBinding;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.OperatorConfig;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.InstanciationException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry;


/**
 * A loader used to load various Registries from a unique {@link LayersConfigModel}.
 *
 * @author cedric dumoulin
 *
 */
public class RegistriesLoader implements ILayerOperatorDescriptorRegistryLoader {

	/**
	 * The model used to load the registries.
	 *
	 */
	protected LayersConfigModel model;

	/**
	 * Constructor.
	 *
	 * @param model
	 */
	public RegistriesLoader(LayersConfigModel model) {
		this.model = model;
	}

	/**
	 * Load the {@link LayerOperatorDescriptorRegistry} from the {@link LayersConfigModel}.
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.loaders.ILayerOperatorDescriptorRegistryLoader#loadLayerOperatorDescriptorRegistry(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry,
	 *      org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry)
	 *
	 * @param descriptorRegistry
	 * @param propertyRegistry
	 */
	@Override
	public void loadLayerOperatorDescriptorRegistry(LayerOperatorDescriptorRegistry descriptorRegistry, PropertyRegistry propertyRegistry) {

		// Load LayerOperators
		for (LayerOperatorConfig layerOperatorConfig : model.getAllLayerOperatorConfig()) {
			try {
				LayerOperatorDescriptor descriptor = layerOperatorConfig.createLayersOperatorDescriptor();
				descriptorRegistry.addLayerOperatorDescriptor(descriptor);
			} catch (InstanciationException e) {
				log.error("LOG - " + this.getClass().getName() + " - " + e.getMessage(), e);
			}
		}

		// Load operators
		for (OperatorConfig operatorConfig : model.getAllOperatorConfig()) {
			try {
				PropertyOperator operator = operatorConfig.createOperatorDescriptor();
				descriptorRegistry.addPropertyOperator(operator);
			} catch (InstanciationException e) {
				log.error("LOG - " + this.getClass().getName() + " - " + e.getMessage(), e);
			}

		}

		// Populate LayerOperator with operators
		for (OperatorBinding binding : model.getAllOperatorBinding()) {
			try {
				System.err.println("binding.getPropertyId().getName(): " + binding.getPropertyId().getName());
				Property property = propertyRegistry.getProperty(binding.getPropertyId().getName());
				String layerDescriptorName = binding.getLayerOperatorConfig().getName();
				String operatorName = binding.getOperator().getName();
				descriptorRegistry.attachOperatorToDescriptor(property, operatorName, layerDescriptorName);
			} catch (NotFoundException e) {
				log.error("LOG - " + this.getClass().getName() + " - " + e.getMessage(), e);
			}

		}

	}

}
