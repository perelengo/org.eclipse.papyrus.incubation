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

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.BadStateException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerState;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersStackImpl;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.notifier.ILayersTreeEventListener;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.notifier.LayersTreeEventNotifier;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.notifier.LayersTreeEventNotifierFactory;

/**
 * @author QL238289
 *
 */
public class CustomLayersStackImpl extends LayersStackImpl {



	/**
	 * Listener on layers tree events.
	 * This listener take in charge the initialization of added layers.
	 */
	private ILayersTreeEventListener layersTreeEventListener = new ILayersTreeEventListener() {

		@Override
		public void layerSet(Notification notification) {
			CustomLayersStackImpl.this.layerAdded((LayerExpression) notification.getNewValue());
		}

		@Override
		public void layerRemoved(Notification notification) {
			// nothing to do

		}

		@Override
		public void layerMoved(Notification notification) {
			// nothing to do

		}

		@Override
		public void layerAdded(Notification notification) {
			CustomLayersStackImpl.this.layerAdded((LayerExpression) notification.getNewValue());
		}

	};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	protected CustomLayersStackImpl() {
		super();

		// Now, init should be called explicitly after creation.
		// init();
	}

	/**
	 * Init this object.
	 * Create a listener on tree events.
	 */
	private void init() {

		LayersTreeEventNotifier layersTreeEventnotifier = LayersTreeEventNotifierFactory.instance.adapt(this);

		layersTreeEventnotifier.addLayersModelEventListener(layersTreeEventListener);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @throws LayersException
	 */
	@Override
	public ComputePropertyValueCommand getComputePropertyValueCommand(View view, Property property) throws LayersException {
		LayerExpression layers = getLayers();
		if (layers == null) {
			throw new BadStateException("Layers should be set first.");
		}

		return layers.getComputePropertyValueCommand(view, property);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Start this LayersStack after its creation. This method should be explicitly called by
	 * user after the creation of a LayersStack.
	 * <!-- end-user-doc -->
	 *
	 * @deprecated Not used anymore
	 */
	@Deprecated
	@Override
	public void startAfterCreation() {
		// Ensure child is initialized, if any
		if (getLayers() != null) {
			getLayers().attachToLayersStack(this);
		}

		// Start local behaviors
		init();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Attach recursively the tree of layers.
	 * <!-- end-user-doc -->
	 *
	 * @throws LayersException
	 */
	@Override
	public void attachLayers() throws LayersException {
		// Ensure child is started, if any
		if (getLayers() != null) {
			getLayers().attach();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public void attach() throws LayersException {
		// Stop if already in ATTACHED state.
		if (getState() == LayerState.ATTACHED) {
			return;
		}

		// Check required attributes
		if (getDiagram() == null) {
			throw new BadStateException("A required attribute is not set. The Layer can't be attached."
					+ "[layerName=" + getName()
					+ ", diagram=" + (getDiagram() == null ? "null" : "ok")
					+ "]");
		}

		// Can go in attached mode
		setState(LayerState.ATTACHED);
		enterAttachedState();
		attachLayers();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public void detach() throws LayersException {
		// Change the state
		exitAttachedState();
		setState(LayerState.DETACHED);
		// Ensure child is started, if any
		if (getLayers() != null) {
			getLayers().detach();
		}

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public void enterAttachedState() throws LayersException {
		init();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @throws LayersException
	 */
	@Override
	public List<ComputePropertyValueCommand> getPropertiesComputePropertyValueCommand(View view, List<Property> property) throws LayersException {
		LayerExpression layers = getLayers();
		if (layers == null) {
			throw new BadStateException("Layers should be set first.");
		}

		return layers.getPropertiesComputePropertyValueCommand(view, property);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @throws BadStateException
	 */
	@Override
	public List<ComputePropertyValueCommand> getViewsComputePropertyValueCommand(List<View> view, Property property) throws LayersException {

		LayerExpression layers = getLayers();
		if (layers == null) {
			throw new BadStateException("Layers should be set first.");
		}

		return layers.getViewsComputePropertyValueCommand(view, property);
	}

	/**
	 * A layer has been added to the layerTree.
	 * Init this layer.
	 * This method is called by the listener on layerTree events.
	 *
	 * @param addedLayer
	 *            The added layer.
	 */
	protected void layerAdded(LayerExpression addedLayer) {
		// Stop if there is no layer
		if (addedLayer == null) {
			return;
		}
		// init the layer
		addedLayer.attachToLayersStack(this);

	}
}
