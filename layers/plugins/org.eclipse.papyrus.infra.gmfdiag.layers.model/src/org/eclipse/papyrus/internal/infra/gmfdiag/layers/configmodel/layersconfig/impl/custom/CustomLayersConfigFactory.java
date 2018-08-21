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

package org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl.custom;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayerOperatorConfig;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.OperatorBinding;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.OperatorConfig;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl.LayersConfigFactoryImpl;

/**
 * @author QL238289
 *
 */
public class CustomLayersConfigFactory extends LayersConfigFactoryImpl {

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl.LayersConfigFactoryImpl#createLayerOperatorConfig()
	 *
	 * @return
	 */
	@Override
	public LayerOperatorConfig createLayerOperatorConfig() {
		return new CustomLayerOperatorConfigImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl.LayersConfigFactoryImpl#createOperatorBinding()
	 *
	 * @return
	 */
	@Override
	public OperatorBinding createOperatorBinding() {
		return new CustomOperatorBindingImpl();
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl.LayersConfigFactoryImpl#createOperatorConfig()
	 *
	 * @return
	 */
	@Override
	public OperatorConfig createOperatorConfig() {
		return new CustomOperatorConfigImpl();
	}

}
