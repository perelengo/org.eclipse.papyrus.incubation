/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Tatibouet
 *  Arnaud Cuccuru
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.transaction.commands;

import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Transaction used by the ALF framework to persist modification of UML model
 */
public abstract class AlfCommand extends RecordingCommand {

	/**
	 * The state of a particular model element given as text
	 */
	protected AlfTextualRepresentation modelElementState;


	public AlfCommand(String commandLabel, AlfTextualRepresentation state) {
		super(TransactionUtil.getEditingDomain(state.getOwner()));
		this.modelElementState = state;
	}

	/**
	 * Returns the UML named element target by the command execution
	 */
	public NamedElement getCommandTarget() {
		return this.modelElementState.getOwner();
	}

	/**
	 * Returns the modification that need to be applied to a particular model element
	 */
	public AlfTextualRepresentation getModelElementState() {
		return this.modelElementState;
	}
}
