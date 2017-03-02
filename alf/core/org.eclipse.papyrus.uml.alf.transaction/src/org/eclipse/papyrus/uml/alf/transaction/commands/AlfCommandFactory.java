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
 *  Jérémie Tatibouet
 *  Arnaud Cuccuru
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.transaction.commands;

import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;

/**
 * Factory providing facilities to instantiate ALF commands.
 */
public class AlfCommandFactory {

	/** The factory. */
	private static AlfCommandFactory factory;

	/**
	 * Instantiates a new alf command factory.
	 */
	private AlfCommandFactory() {
	}

	/**
	 * Gets the single instance of AlfCommandFactory.
	 *
	 * @return single instance of AlfCommandFactory
	 */
	public static AlfCommandFactory getInstance() {
		if (factory == null) {
			factory = new AlfCommandFactory();
		}
		return factory;
	}

	/**
	 * Creates a new AlfCommand object.
	 *
	 * @param element
	 *            the element
	 * @param textualRepresentation
	 *            the textual representation
	 * @return the abstract transactional command
	 */
	public AlfCommand createCompilationCommand(AlfTextualRepresentation representation) {
		return new CompileCommand(representation);
	}

	/**
	 * Creates a new AlfCommand object.
	 *
	 * @param element
	 *            the element
	 * @param textualRepresentation
	 *            the textual representation
	 * @return the abstract transactional command
	 */
	public AlfCommand creatSaveCommand(AlfTextualRepresentation representation) {
		return new VersioningSaveCommand(representation);
	}
}
