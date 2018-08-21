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

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AllViewsDerivedLayerImpl;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.util.DiagramViewToListSynchronizer;

/**
 * @author QL238289
 *
 */
public class CustomAllViewsDerivedLayerImpl extends AllViewsDerivedLayerImpl {
	/**
	 * Object used to synchronize a list with the diagram's views.
	 *
	 * @generated
	 */
	protected DiagramViewToListSynchronizer viewsListSynchronizer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	protected CustomAllViewsDerivedLayerImpl() {
		super();
		// init the synchronizer
		viewsListSynchronizer = new DiagramViewToListSynchronizer(getViews());
	}

	/**
	 * This layer has just been added to a LayerStack.
	 * Set the root of the expression.
	 * Set the views to match the result of the expression.
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl#initLayer(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack)
	 *
	 * @param owningLayersStack
	 */
	@Override
	public void initLayer(LayersStack owningLayersStack) {
		super.initLayer(owningLayersStack);

		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + ".initLayer(" + owningLayersStack + ")");
		}

		// Set the diagram associated to this tree of layers
		viewsListSynchronizer.setDiagram(owningLayersStack.getDiagram());
	}

}
