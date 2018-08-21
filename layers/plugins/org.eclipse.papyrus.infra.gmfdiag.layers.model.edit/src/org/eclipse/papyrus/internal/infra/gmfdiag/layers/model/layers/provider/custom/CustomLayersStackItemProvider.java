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
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.LayersStackItemProvider;

/**
 * @author QL238289
 *
 */
public class CustomLayersStackItemProvider extends LayersStackItemProvider {

	/**
	 * Constructor.
	 *
	 * @param adapterFactory
	 */
	public CustomLayersStackItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public String getText(Object object) {
		LayersStack stack = (LayersStack) object;
		String label = ((LayersStack) object).getName();

		if (label == null || label.length() == 0) {
			try {
				label = stack.getDiagram().getName();
			} catch (NullPointerException e) {
				return getString("_UI_LayersStack_type");
			}
		}

		return "Stack " + label;
	}
}
