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
/**
 *
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.commands;

import static org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.Activator.log;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.NotationDiagramHelper;


/**
 * Add a layer stack to a diagram.
 * This is performed on the current LayerStack Viewer.
 *
 * @author cedric dumoulin
 *
 */
public class DetachLayerStackCommand extends AbstractLayerStackCommand implements IHandler {

	/**
	 * @see org.eclipse.papyrus.layers2.ui.view.commands.AbstractLayerCommand#getCommandName()
	 *
	 * @return
	 */
	@Override
	public String getCommandName() {
		return "Detach Layer Stack";
	}

	/**
	 * @see org.eclipse.papyrus.layers2.ui.view.commands.AbstractLayerCommand#doExecute(org.eclipse.papyrus.layers.application.NotationDiagramMngr)
	 *
	 * @param notationDiagramMngr
	 */
	@Override
	protected void doExecute(ExecutionEvent event, NotationDiagramHelper notationDiagramHelper) {
		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + ".doExecute()");
		}
		notationDiagramHelper.removeLayersStack();
	}


	/**
	 * Return true if it is possible to detach aLyerStack.
	 */
	@Override
	public boolean isEnabled(NotationDiagramHelper notationDiagramHelper) {
		return notationDiagramHelper.isLayersStackAttached();
	}


}
