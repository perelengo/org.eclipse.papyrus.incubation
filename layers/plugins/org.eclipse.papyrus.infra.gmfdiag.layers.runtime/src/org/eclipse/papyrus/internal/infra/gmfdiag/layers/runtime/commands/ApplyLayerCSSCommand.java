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

package org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.commands;

import static org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.Activator.log;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.Activator;

/**
 * @author Quentin Le Menez
 *
 */
public class ApplyLayerCSSCommand extends RecordingCommand {

	private List<View> views;

	private LayersStackApplication application;

	private String propertyName;

	private LayersStack layerStack;

	/**
	 * Constructor.
	 *
	 * @param ted
	 * @param label
	 */
	public ApplyLayerCSSCommand(TransactionalEditingDomain ted, List<View> views, String propertyName, LayersStackApplication application, LayersStack layerStack, String label) {
		super(ted, label);
		this.views = views;
		this.application = application;
		this.propertyName = propertyName;
		this.layerStack = layerStack;
	}

	/**
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 *
	 */
	@Override
	protected void doExecute() {

		Property property;
		try {
			property = application.getPropertyRegistry().getProperty(propertyName);

			final List<ComputePropertyValueCommand> commands = layerStack.getViewsComputePropertyValueCommand(views, property);

			final PropertySetter setter = application.getPropertySetterRegistry().getPropertySetter(property);

			// Walk each view and set the property
			for (int i = 0; i < views.size(); i++) {

				// set the value from the provided cmds.
				// Do it if the cmd is not null
				if (commands != null && commands.get(i) != null) {
					try {
						setter.setValue(views.get(i), commands.get(i).getCmdValue());
					} catch (LayersException e) {
						Activator.log.error("ApplyLayerCSSCommand setter has failed", e); //$NON-NLS-1$
					}
				} else {
					log.info(this.getClass().getSimpleName() + "ERROR - a cmd is null " + commands);
				}
			}
		} catch (NotFoundException e) {
			Activator.log.error("ApplyLayerCSSCommand could not retreive the setter associated to the property", e); //$NON-NLS-1$
		} catch (LayersException e) {
			Activator.log.error("ApplyLayerCSSCommand could not compute the propertyValueCommand", e); //$NON-NLS-1$
		}
	}

}
