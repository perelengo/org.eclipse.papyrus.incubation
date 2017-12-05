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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.RemoveCssClassStyleCommand;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Layer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance;

/**
 * @author Quentin Le Menez
 *
 */
public class DeleteLayersCommand extends RecordingCommand implements Command {

	private Collection<Layer> layers;

	private TransactionalEditingDomain domain;

	/**
	 * Constructor.
	 *
	 * @param namedStyle
	 * @param newValue
	 */
	public DeleteLayersCommand(TransactionalEditingDomain domain, Layer layer) {
		this(domain, Collections.singleton(layer));
	}

	public DeleteLayersCommand(TransactionalEditingDomain domain, Collection<Layer> layers) {
		super(domain);
		this.layers = layers;
		this.domain = domain;
	}

	/**
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 *
	 */
	@Override
	protected void doExecute() {
		CompoundCommand cc = new CompoundCommand("DeleteLayersCommand");

		for (Layer layer : layers) {
			String style = null;
			for (TypeInstance type : layer.getPropertyValues()) {
				if (type instanceof CSSInstance) {
					style = ((CSSInstance) type).getStyle();
					cc.append(new RemoveCssClassStyleCommand(domain, layer.getViews(), style));
				}
			}
		}
		cc.execute();
	}

}
