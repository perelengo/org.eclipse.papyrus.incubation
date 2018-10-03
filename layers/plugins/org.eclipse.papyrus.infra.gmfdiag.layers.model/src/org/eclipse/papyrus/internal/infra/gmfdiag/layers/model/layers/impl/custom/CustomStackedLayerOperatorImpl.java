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

import static org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.Activator.log;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerImpl;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StackedLayerOperatorImpl;

/**
 * @author QL238289
 *
 */
public class CustomStackedLayerOperatorImpl extends StackedLayerOperatorImpl {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	protected CustomStackedLayerOperatorImpl() {
		super();

		// Add an observer
		Adapter adapter = new LayerDescriptorSynchronizer();
		this.eAdapters().add(adapter);
	}

	/**
	 * Reset the descriptor accordingly to the descriptor name.
	 * The descriptor is resseted only if the ::application and ::layerOperatorDescriptorName are set.
	 * Nothing is done if one of the attribute is not set.
	 * Nothing is done if the descriptor can not be found (maybe a log is issue).
	 * <!-- begin-user-doc -->
	 * Not used ?
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public void resetDescriptor() {

		if (getApplication() == null || getLayerOperatorDescriptorName() == null) {
			// A property is not yet set.
			// do nothing
			return;
		}

		try {
			LayerOperatorDescriptor descriptor = getApplication().getLayerOperatorDescriptorRegistry().getLayerOperatorDescriptor(getLayerOperatorDescriptorName());
			setLayerOperatorDescriptor(descriptor);
		} catch (NotFoundException e) {
			// Not found
			log.error(this.getClass().getName()
					+ "- Can't get LayerOperatorDescriptor for descriptorName '" + getLayerOperatorDescriptorName() + "'.", e);
		}
	}

	/**
	 * This class listen to #propertyValueMap, and synchronize propertyValues accordingly.
	 *
	 *
	 */
	public class LayerDescriptorSynchronizer extends AdapterImpl {

		@Override
		public void notifyChanged(Notification msg) {
			// System.err.println("event " + msg.getEventType());

			switch (msg.getFeatureID(AbstractLayer.class)) {
			case LayersPackage.STACKED_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME:
				notifyDescriptorNameChanged(msg);
				break;

			case LayersPackage.STACKED_LAYER_OPERATOR__APPLICATION:
				notifyLayerApplicationFeatureChanged(msg);
				break;

			default:
				break;
			}
		}

		/**
		 * The {@link LayerImpl#propertyValueMap} has changed. Synchronize the {@link LayerImpl#propertyValues} list.
		 *
		 * @param msg
		 */
		protected void notifyDescriptorNameChanged(Notification msg) {
			// System.err.println("descriptor name changed " + msg.getEventType());
			switch (msg.getEventType()) {
			case Notification.SET: {
				// Name is set
				resetDescriptor();
				break;
			}
			default:
				break;
			}

		}

		/**
		 * The {@link LayerImpl#propertyValueMap} has changed. Synchronize the {@link LayerImpl#propertyValues} list.
		 *
		 * @param msg
		 */
		protected void notifyLayerApplicationFeatureChanged(Notification msg) {
			// System.err.println("application changed " + msg.getEventType());
			switch (msg.getEventType()) {
			case Notification.SET: {
				// Application is set
				resetDescriptor();
				break;
			}
			}
		}

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void addLayer(LayerExpression layer) {
		// getLayers().add(layer);
		// Add layer on top of the stack.
		getLayers().add(0, layer);
	}

	/**
	 * Propagate the change to children
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl#setIsBranchEnabled(boolean)
	 *
	 * @param newIsBranchEnabled
	 * 
	 * @generated
	 */
	@Override
	public void setIsBranchEnabled(boolean newIsBranchEnabled) {
		// First, set the value.
		super.setIsBranchEnabled(newIsBranchEnabled);
		// Now, propagate
		boolean value = isBranchEnabled();
		for (LayerExpression layer : getLayers()) {
			layer.setIsBranchEnabled(value);
		}
	}

	/**
	 * Set the value then propagate to children nodes.
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl#setOwningLayersStack(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack)
	 *
	 * @param newOwningLayersStack
	 * 
	 * @generated
	 */
	@Override
	public void setOwningLayersStack(LayersStack newOwningLayersStack) {
		// Set the value
		super.setOwningLayersStack(newOwningLayersStack);
		// Now propagate to children
		LayersStack value = getOwningLayersStack();
		for (LayerExpression layer : getLayers()) {
			layer.setOwningLayersStack(value);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Start this element after its reloading by EMF
	 * This method is called recursively by the parent of this element.
	 *
	 * <!-- end-user-doc -->
	 *
	 * @throws LayersException
	 * @generated
	 */
	@Override
	public void attach() throws LayersException {
		// Try to attach this Layer
		super.attach();
		// attach children
		for (LayerExpression l : getLayers()) {
			l.attach();
		}
	}

	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl#detach()
	 *
	 * @throws LayersException
	 * @generated
	 */
	@Override
	public void detach() throws LayersException {
		// Detach this Layer
		super.detach();
		// detach children
		for (LayerExpression l : getLayers()) {
			l.detach();
		}
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorImpl#isDescriptorSet()
	 *
	 * @return
	 */
	@Override
	public boolean isDescriptorSet() {
		return getLayerOperatorDescriptor() != null;
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl#isLayerEnabledInternal()
	 *
	 * @return
	 */
	@Override
	public boolean isLayerEnabledInternal() {
		return isLayerEnabled && isDescriptorSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @deprecated unless we need it again
	 * @generated
	 */
	@Deprecated
	@Override
	public void attachToLayersStack(LayersStack owningLayersStack) {

		// the owning stack
		setOwningLayersStack(owningLayersStack);

		// Ensure child is started, if any
		for (LayerExpression l : getLayers()) {
			l.attachToLayersStack(owningLayersStack);
		}

		// Start local behaviors
		startBehaviors();
	}


}
