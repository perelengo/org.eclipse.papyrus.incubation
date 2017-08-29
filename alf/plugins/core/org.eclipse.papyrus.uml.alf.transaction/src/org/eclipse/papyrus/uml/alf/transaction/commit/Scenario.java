/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Tatibouet
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.transaction.commit;

import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;
import org.eclipse.papyrus.uml.alf.text.representation.util.RepresentationParser;
import org.eclipse.papyrus.uml.alf.text.representation.util.RepresentationParsingError;
import org.eclipse.uml2.uml.NamedElement;

import static org.eclipse.papyrus.uml.alf.transaction.ActivatorTransaction.logger;

public abstract class Scenario implements IScenario {

	/**
	 * The textual representation of a model element from the user stand point
	 */
	protected AlfTextualRepresentation userModelState;

	/**
	 * The textual representation of a model element from the semantic model stand point
	 */
	protected AlfTextualRepresentation currentModelState;

	public Scenario() {
		this.userModelState = null;
		this.currentModelState = null;
	}

	protected void init(NamedElement target) throws IllegalArgumentException {
		if (target == null) {
			throw new IllegalArgumentException("The model element provided to the scenario cannot be null");
		}
		try {
			this.userModelState = RepresentationParser.getInstance().parse(target);
			this.currentModelState = RepresentationParser.getInstance().getSnapshot(target);
		} catch (RepresentationParsingError e) {
			logger.error("Parsing of ["+target.getName()+"]", e);
		} catch(RuntimeException e){
			logger.error("Serialization of ["+target.getName()+"] failed", e);
		}
	}
}
