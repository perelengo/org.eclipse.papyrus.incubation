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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.handlers;

import org.eclipse.core.commands.IHandler;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Layer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;


/**
 * Create a layer stack to a diagram.
 * This is performed on the current LayerStack Viewer.
 *
 * @author cedric dumoulin
 *
 */
public class CreateLayerHandler extends AbstractCreateLayerExpressionHandler implements IHandler {


	/**
	 * @see org.eclipse.papyrus.layers2.ui.view.commands.AbstractLayerCommand#getCommandName()
	 *
	 * @return
	 */
	@Override
	public String getCommandName() {
		return "Create Layer";
	}


	/**
	 * @return
	 */
	@Override
	protected LayerExpression createLayer() {
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		return layer;
	}

}
