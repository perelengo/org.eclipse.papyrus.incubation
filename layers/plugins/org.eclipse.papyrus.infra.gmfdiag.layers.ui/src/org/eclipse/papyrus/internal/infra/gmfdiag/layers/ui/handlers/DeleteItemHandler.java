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

import static org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.Activator.log;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.RemoveCssClassStyleCommand;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Layer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.commands.AbstractLayersCommand;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.commands.DeleteLayersCommand;


/**
 * Handle a "Delete Item" command.
 * Use the EMF {@link RemoveCommand}
 *
 * @author cedric dumoulin
 *
 */
public class DeleteItemHandler extends AbstractLayersCommand {

	/**
	 *
	 * Constructor.
	 *
	 */
	public DeleteItemHandler() {
		super();
	}

	/**
	 * Prepare the execution of the command
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.commands.AbstractLayersCommand#preExecute(org.eclipse.core.commands.ExecutionEvent, org.eclipse.core.expressions.IEvaluationContext, java.util.List)
	 *
	 * @param event
	 * @param context
	 * @param selections
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected boolean preExecute(ExecutionEvent event, IEvaluationContext context, List<Object> selections) throws ExecutionException {

		if (!isEnabled(context, selections)) {
			return false;
		}


		return true;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.commands.AbstractLayersCommand#doExecute(org.eclipse.core.commands.ExecutionEvent, org.eclipse.core.expressions.IEvaluationContext, java.util.List)
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

		TransactionalEditingDomain domain;
		try {
			domain = lookupTransactionalEditingDomain(context);
		} catch (ServiceException e) {
			// sylently fails
			return;
		}

		final CompoundCommand compoundCmd = new CompoundCommand("DeleteSelectedLayersCommand");
		// TODO support multiple deletion
		Object selection = selections.get(0);
		// for (Object selection : selections) {
		if (selection instanceof Layer) {
			compoundCmd.append(new DeleteLayersCommand(domain, (Layer) selection));
		}
		// }

		Command removeCmd = RemoveCommand.create(domain, selection);
		compoundCmd.append(removeCmd);

		RecordingCommand rc = new RecordingCommand(domain, "DeleteIntemHandlerCommand") {

			@Override
			protected void doExecute() {
				compoundCmd.execute();
			}
		};

		// We are already in a transaction but we need to execute it inside a Recording for the Redo
		rc.execute();
	}

	/**
	 * Delete is enable on all items except the root layer.
	 */
	@Override
	public boolean isEnabled(IEvaluationContext context, List<Object> selections) {
		if (selections.size() != 1) {
			return false;
		}
		Object first = selections.get(0);
		boolean res = (first instanceof LayerExpression && !(((EObject) first).eContainer() instanceof LayersStack));
		return res;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.commands.AbstractLayersCommand#getCommandName()
	 *
	 * @return
	 */
	@Override
	public String getCommandName() {
		return "Create Layer Operator";
	}

}
