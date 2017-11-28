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
package org.eclipse.papyrus.infra.gmfdiag.layers.runtime.model;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.gmfdiag.layers.runtime.LayersStackAndApplicationLifeCycleEventNotifier;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication;


/**
 * This class declare the model used by the layer.
 * This model is registered to Papyrus core ModelSet which take care to load the
 * corresponding EMF resource.
 *
 * @author cedric dumoulin
 *
 */
public class LayersModelResource extends AbstractModelWithSharedResource<LayersStackApplication> implements IModel {

	/**
	 * File extension used for notation.
	 */
	public static final String MODEL_FILE_EXTENSION = "layers"; //$NON-NLS-1$

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.layers.resource.LayersModel"; //$NON-NLS-1$

	private LayersStackAndApplicationLifeCycleEventNotifier layersStackAndApplicationLifeCycleEventNotifier = null;


	/**
	 * Constructor.
	 *
	 */
	public LayersModelResource() {
		this.modelKind = modelKind.master;
	}


	/**
	 * Identifier used to retrieve the model from the ModelManager
	 *
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getIdentifier()
	 *
	 * @return
	 */
	@Override
	public String getIdentifier() {
		return MODEL_ID;
	}

	/**
	 * Get the extension used for TraceModel resources
	 *
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getModelFileExtension()
	 *
	 * @return
	 */
	@Override
	protected String getModelFileExtension() {
		return MODEL_FILE_EXTENSION;
	}

	/**
	 * Return true if the provided object is a root of the model, false otherwise.
	 * This method should be implemented by subclasses.
	 *
	 * @param object
	 * @return
	 */
	@Override
	protected boolean isModelRoot(EObject object) {
		return object instanceof LayersStackApplication;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#loadModel(org.eclipse.emf.common.util.URI)
	 *
	 * @param uriWithoutExtension
	 */
	@Override
	public void loadModel(URI uriWithoutExtension) {
		// It is a common use case that this resource does not (and will not) exist

		if (exists(uriWithoutExtension)) {
			try {
				super.loadModel(uriWithoutExtension);
			} catch (Exception e) {
				createModel(uriWithoutExtension);
			}
		}

		if (resource == null) {
			createModel(uriWithoutExtension);
		}

		try {
			saveModel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#saveModel()
	 *
	 * @throws IOException
	 */
	@Override
	public void saveModel() throws IOException {
		// TODO Override the saveModel method in order to remove the modelKind=master
		// This should be saved if the resource has been modified and is not empty
		// i.e. contains at least one reference to a CSS
		super.saveModel();
	}

	/**
	 * Lookup for the {@link LayersStackApplication} instance
	 *
	 * @return the {@link LayersStackApplication} or null if not found.
	 */
	public LayersStackApplication lookupLayerStackApplication() {
		return getModelRoot();
	}

	/**
	 * Get the {@link LayersStackApplication} object. Create it if not found.
	 *
	 * @return
	 */
	public LayersStackApplication getLayerStackApplication() {
		LayersStackApplication application = getModelRoot();
		if (application != null) {
			return application;
		}
		// Not found, create it
		application = LayersFactory.eINSTANCE.createLayersStackApplication();
		addModelRoot(application);

		return application;
	}

	/**
	 * Remove the specified application from the model.
	 *
	 * @param application
	 */
	public void removeRoot(LayersStackApplication application) {
		getResource().getContents().remove(application);
	}

	/**
	 * Get the associated {@link LayersStackAndApplicationLifeCycleEventNotifier}.
	 * There is only one such notifier associated to the model.
	 *
	 * @return
	 */
	public LayersStackAndApplicationLifeCycleEventNotifier getLayersStackLifeCycleEventNotifier() {
		// TODO Use an adapter to share a single instance in the model itself.
		if (layersStackAndApplicationLifeCycleEventNotifier == null) {
			// Create it
			layersStackAndApplicationLifeCycleEventNotifier = new LayersStackAndApplicationLifeCycleEventNotifier(this);
		}

		return layersStackAndApplicationLifeCycleEventNotifier;
	}

}