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



import static org.eclipse.papyrus.infra.gmfdiag.layers.ui.Activator.log;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersContainer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication;

public abstract class AbstractCreateLayerExpressionHandler extends AbstractLayersCommand {

	/**
	 * Value used to compute new names.
	 */
	private static int creationCount = 0;

	public AbstractCreateLayerExpressionHandler() {
		super();
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.layers.ui.commands.AbstractLayersCommand#doExecute(org.eclipse.core.commands.ExecutionEvent, org.eclipse.core.expressions.IEvaluationContext, java.util.List)
	 *
	 * @param event
	 * @param context
	 * @param selections
	 */
	@Override
	protected void doExecute(ExecutionEvent event, IEvaluationContext context, List<Object> selections) {
		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + ".doExecute()");
		}

		if (!isEnabled(context, selections)) {
			return;
		}

		// Get application
		LayersStackApplication application;
		try {
			application = lookupLayersStackApplicationChecked(context);
		} catch (NotFoundException e) {
			// Silently fails
			return;
		} catch (org.eclipse.papyrus.infra.core.resource.NotFoundException e) {
			// Silently fails
			return;
		} catch (ServiceException e) {
			// Silently fails
			return;
		}


		// Create a layer !
		LayerExpression layer = createLayer();
		layer.setName("layer" + creationCount++);
		layer.setApplication(application);

		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + ". layerCreated");
		}

		// insert layer in selected object
		Object selection = selections.get(0);
		if (selection instanceof LayersContainer) {
			LayersContainer stack = (LayersContainer) selection;
			stack.addLayer(layer);
		}
		// if(selection instanceof LayersStack) {
		// LayersStack stack = (LayersStack)selection;
		// stack.setLayers(layer);
		// }
		// else {
		// LayerOperator operator = (LayerOperator)selection;
		// operator.getLayers().add(layer);
		// }

	}

	/**
	 * This method must create the Layer that will be populated and inserted in parent.
	 *
	 * @return
	 */
	protected abstract LayerExpression createLayer();


	/**
	 * Return true if it is possible to attach aLyerStack.
	 */
	@Override
	public boolean isEnabled(IEvaluationContext context, List<Object> selections) {
		if (selections.size() != 1) {
			return false;
		}
		Object first = selections.get(0);
		boolean res = (first instanceof LayerOperator) || (first instanceof LayersStack);
		// if(log.isDebugEnabled()) {
		// log.debug("isEnable(" + res + ")");
		// }
		return res;
	}

}
