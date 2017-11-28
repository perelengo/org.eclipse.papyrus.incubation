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
package org.eclipse.papyrus.infra.gmfdiag.layers.ui.commands;

import org.eclipse.core.commands.IHandler;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperator;


/**
 * Create a {@link TopLayerOperator}.
 *
 * @author cedric dumoulin
 *
 */
public class CreateTopLayerOperatorHandler extends AbstractCreateLayerExpressionHandler implements IHandler {

	@Override
	protected LayerExpression createLayer() {
		TopLayerOperator operator = LayersFactory.eINSTANCE.createTopLayerOperator();
		return operator;
	}

	@Override
	public String getCommandName() {
		return "Create Top Layer Operator";
	}


}
