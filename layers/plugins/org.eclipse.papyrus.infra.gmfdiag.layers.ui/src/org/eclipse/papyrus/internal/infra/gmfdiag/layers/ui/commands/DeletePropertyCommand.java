/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.ui.util.ServiceUtilsForIEvaluationContext;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.model.LayersModelResource;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.Activator;

/**
 * @author Quentin Le Menez
 *
 */
public class DeletePropertyCommand extends RecordingCommand implements Command {

	private Collection<TypeInstance> typeInstances;

	private IEvaluationContext context;

	/**
	 * Constructor.
	 *
	 * @param namedStyle
	 * @param newValue
	 */
	public DeletePropertyCommand(TransactionalEditingDomain domain, IEvaluationContext context, TypeInstance typeInstance) {
		this(domain, context, Collections.singleton(typeInstance));
	}

	public DeletePropertyCommand(TransactionalEditingDomain domain, IEvaluationContext context, Collection<TypeInstance> typeInstances) {
		super(domain);
		this.typeInstances = typeInstances;
		this.context = context;
	}

	/**
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 *
	 */
	@Override
	protected void doExecute() {
		CompoundCommand cc = new CompoundCommand("DeleteLayersCommand");

		try {
			LayersStackApplication layerStackApplication = lookupLayersStackApplicationChecked(context);
			List<LayersStack> layerStacks = layerStackApplication.getLayersStacks();
			TopLayerOperator topLayerOperator = null;
			for (LayersStack layerStack : layerStacks) {
				topLayerOperator = layerStack.getLayers() instanceof TopLayerOperator ? (TopLayerOperator) layerStack.getLayers() : null;
				if (null == topLayerOperator || topLayerOperator.getLayers().isEmpty()) {
					continue;
				}
			}

			if (null == topLayerOperator) {
				return;
			}

			for (LayerExpression layerExpression : topLayerOperator.getLayers()) {
				AbstractLayer layer = layerExpression instanceof AbstractLayer ? (AbstractLayer) layerExpression : null;

				if (null == layer) {
					return;
				}

				List<Property> propertiesToRemove = new ArrayList<Property>();
				for (Property property : layer.getAttachedProperties()) {
					if (typeInstances.contains(layer.getPropertyInstance(property))) {
						propertiesToRemove.add(property);
					}
				}

				for (Property property : propertiesToRemove) {
					layer.removePropertyInstance(property);
				}
			}
		} catch (org.eclipse.papyrus.infra.core.resource.NotFoundException e) {
			Activator.log.error("DeletePropertyCommand The LayerStackApplication could not be resolved from the context", e); //$NON-NLS-1$
		} catch (ServiceException e) {
			Activator.log.error("DeletePropertyCommand The LayerStackApplication could not be resolved from the context", e); //$NON-NLS-1$
		} catch (LayersException e) {
			Activator.log.error("DeletePropertyCommand The layer property could not be resolved", e); //$NON-NLS-1$
		}

		cc.execute();
	}

	protected LayersStackApplication lookupLayersStackApplicationChecked(IEvaluationContext context) throws NotFoundException, ServiceException, org.eclipse.papyrus.infra.core.resource.NotFoundException {

		ModelSet modelSet = ServiceUtilsForIEvaluationContext.getInstance().getModelSet(context);
		LayersModelResource model = (LayersModelResource) modelSet.getModelChecked(LayersModelResource.MODEL_ID);

		return model.lookupLayerStackApplication();
	}

}
