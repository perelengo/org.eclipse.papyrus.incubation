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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TopLayerOperatorImpl;

/**
 * @author QL238289
 *
 */
public class CustomTopLayerOperatorImpl extends TopLayerOperatorImpl {

	/**
	 * Get the command to compute the required property value.
	 * Walk all layers and return the first cmd that is not null for specified view and property.
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl#getComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property)
	 *
	 * @param view
	 * @param property
	 * @return
	 * @throws LayersException
	 */
	@Override
	public ComputePropertyValueCommand getComputePropertyValueCommand(View view, Property property) throws LayersException {

		// Walk all layers and return the first cmd that is not null for specified view and property.
		for (LayerExpression layer : getLayers()) {

			ComputePropertyValueCommand cmd = layer.getComputePropertyValueCommand(view, property);
			if (cmd != null) {
				return cmd;
			}
		}
		// Nothing found
		return null;

	}

	/**
	 * For each property, add the first property value in the list of result.
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl#getPropertiesComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, java.util.List)
	 *
	 * @param view
	 * @param property
	 * @return
	 * @throws LayersException
	 */
	@Override
	public List<ComputePropertyValueCommand> getPropertiesComputePropertyValueCommand(View view, List<Property> properties) throws LayersException {

		// Simple implementation
		// TODO Check if we can optimize

		// the result list
		List<ComputePropertyValueCommand> resCmds = new ArrayList<>(properties.size());
		boolean isCmdFound = false;

		for (Property property : properties) {
			if (property == null) {
				resCmds.add(null);
				continue;
			}

			ComputePropertyValueCommand cmd = getComputePropertyValueCommand(view, property);
			if (cmd != null) {
				isCmdFound = true;
			}
			resCmds.add(cmd);


		}
		// Return appropriate result
		if (isCmdFound) {
			return resCmds;
		} else {
			// No command ==> null
			return null;
		}
	}

	/**
	 * For each view, add the first property value in the list of result.
	 *
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl#getViewsComputePropertyValueCommand(java.util.List, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property)
	 *
	 * @param view
	 * @param property
	 * @return
	 * @throws LayersException
	 */
	@Override
	public List<ComputePropertyValueCommand> getViewsComputePropertyValueCommand(List<View> views, Property property) throws LayersException {

		// Simple implementation
		// TODO Check if we can optimize

		// the result list
		List<ComputePropertyValueCommand> resCmds = new ArrayList<>(views.size());
		boolean isCmdFound = false;

		for (View view : views) {
			if (view == null) {
				resCmds.add(null);
				continue;
			}

			ComputePropertyValueCommand cmd = getComputePropertyValueCommand(view, property);
			if (cmd != null) {
				isCmdFound = true;
			}
			resCmds.add(cmd);
		}

		// Return appropriate result
		if (isCmdFound) {
			return resCmds;
		} else {
			// No command ==> null
			return null;
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
