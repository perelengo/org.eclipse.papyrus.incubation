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

package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.custom;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.StackedLayerOperatorItemProvider;

/**
 * @author QL238289
 *
 */
public class CustomStackedLayerOperatorItemProvider extends StackedLayerOperatorItemProvider {

	/**
	 * Constructor.
	 *
	 * @param adapterFactory
	 */
	public CustomStackedLayerOperatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	// /**
	// * This returns the label text for the adapted class.
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// *
	// */
	// @Override
	// public String getText(Object object) {
	// String label = ((AbstractLayerOperator) object).getName();
	// return label == null || label.length() == 0 ? getString("_UI_AbstractLayerOperator_type") : getString("_UI_AbstractLayerOperator_type") + " " + label;
	// }

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public String getText(Object object) {
		// String label = ((StackedLayerOperator)object).getName();
		// return label == null || label.length() == 0 ?
		// getString("_UI_StackedLayerOperator_type") :
		// getString("_UI_StackedLayerOperator_type") + " " + label;

		// Actually, we use an StackedLayerOperator as a concrete class for every type of layer operator
		// (to be changed))
		LayerOperator layer = ((LayerOperator) object);
		if (!layer.isDescriptorSet()) {
			// Original behavior
			String label = ((LayerOperator) object).getName();
			return label == null || label.length() == 0 ? getString("_UI_AbstractLayerOperator_type") : getString("_UI_AbstractLayerOperator_type") + " " + label;
		}

		// Custom behavior
		String label = layer.getName();
		return label == null || label.length() == 0 ? getString("_UI_AbstractLayerOperator_type") : getString("_UI_AbstractLayerOperator_type") + " (" + layer.getLayerOperatorDescriptorName() + ") " + label;

	}

}
