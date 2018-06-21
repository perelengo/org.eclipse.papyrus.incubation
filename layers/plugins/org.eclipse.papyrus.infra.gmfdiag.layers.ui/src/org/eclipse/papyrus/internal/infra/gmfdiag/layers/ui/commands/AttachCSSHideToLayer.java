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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.commands;

import static org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.Activator.log;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ListSelectionDialog;


/**
 * Attach a property to the selected Layer.
 * Property are proposed in a list.
 *
 * @author cedric dumoulin
 *
 */
public class AttachCSSHideToLayer extends AbstractLayersCommand {

	/**
	 * Constructor.
	 *
	 */
	public AttachCSSHideToLayer() {
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.commands.AbstractLayersCommand#getCommandName()
	 *
	 * @return
	 */
	@Override
	public String getCommandName() {
		return "Attach a CSS Hide";
	}

	/**
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.commands.AbstractLayersCommand#doExecute(org.eclipse.core.commands.ExecutionEvent, org.eclipse.core.expressions.IEvaluationContext, java.util.List)
	 *
	 * @param event
	 * @param context
	 * @param selections
	 */
	@Override
	protected void doExecute(ExecutionEvent event, IEvaluationContext context, List<Object> selections) {
		// check enable
		if (!isEnabled(context, selections)) {
			return;
		}

		// Open the dialog to ask the new name
		// TODO dialog should not be in the transaction !! put it outside !

		try {
			// Get the layer and application
			LayersStackApplication application = lookupLayersStackApplicationChecked(context);
			AbstractLayer layer = (AbstractLayer) getSelections(context).get(0);

			// Get the CSS property
			Property CSSproperty = application.getPropertyRegistry().getProperty("cssHide");

			layer.addPropertyInstance(CSSproperty);

		} catch (LayersException e) {
			// silently fails
			e.printStackTrace();
		} catch (org.eclipse.papyrus.infra.core.resource.NotFoundException e) {
			// silently fails
			e.printStackTrace();
		} catch (ServiceException e) {
			// silently fails
			e.printStackTrace();
		}


	}

	/**
	 * Return true if it is possible to attach a property.
	 */
	@Override
	public boolean isEnabled(IEvaluationContext context, List<Object> selections) {

		return selectionFirstElementInstanceOf(selections, AbstractLayer.class);
	}
}
