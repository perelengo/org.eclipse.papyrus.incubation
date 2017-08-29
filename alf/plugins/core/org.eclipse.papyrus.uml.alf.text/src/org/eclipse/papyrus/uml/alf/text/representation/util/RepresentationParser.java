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
package org.eclipse.papyrus.uml.alf.text.representation.util;

import java.sql.Timestamp;
import java.util.Calendar;

import org.eclipse.papyrus.uml.alf.libraries.helper.AlfUtil;
import org.eclipse.papyrus.uml.alf.libraries.helper.BackupState;
import org.eclipse.papyrus.uml.alf.libraries.helper.BackupUtil;
import org.eclipse.papyrus.uml.alf.libraries.helper.BackupState.EditionStatus;
import org.eclipse.papyrus.uml.alf.text.generation.DefaultEditStringRetrievalStrategy;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

public class RepresentationParser {

	private static RepresentationParser parser;

	private BackupUtil helperBackup;

	private AlfUtil helperAlf;

	private RepresentationParser() {
		this.helperBackup = BackupUtil.getInstance();
		this.helperAlf = AlfUtil.getInstance();
	}

	public static RepresentationParser getInstance() {
		if (parser == null) {
			parser = new RepresentationParser();
		}
		return parser;
	}

	/**
	 * Load the textual representation attached to a model element which is a NamedElement
	 * 
	 * @param modelElement
	 * @return representation
	 * @throws RepresentationParsingError
	 */
	public AlfTextualRepresentation parse(NamedElement modelElement) throws RepresentationParsingError {
		if (modelElement == null) {
			throw new RepresentationParsingError(
					"The model element for which the representation is calculated cannot be null");
		}
		AlfTextualRepresentation representation = new AlfTextualRepresentation(modelElement);
		Comment comment = helperAlf.getTextualRepresentationComment(modelElement);
		if (comment != null) {
			representation.setSource(comment);
			representation.setText(comment.getBody());
			if (helperBackup.isBackup(comment)) {
				Stereotype backup = helperBackup.getBackupStereotype(modelElement);
				if (backup != null) {
					representation.setEditionState(helperBackup.getBackupState(comment));
				}
			}
		} else {
			representation.setText(new DefaultEditStringRetrievalStrategy().getGeneratedEditString(modelElement));
		}
		return representation;
	}

	/**
	 * Capture the textual representation of a model element. It does not returns an already registered representation
	 * associated to this element. It captures the current state of a model element.
	 * 
	 * @param modelElement
	 * @return representation
	 * @throws RepresentationParsingError
	 */
	public AlfTextualRepresentation getSnapshot(NamedElement modelElement) throws RepresentationParsingError {
		if (modelElement == null) {
			throw new RepresentationParsingError(
					"The model element for which the representation is calculated cannot be null");
		}
		AlfTextualRepresentation representation = new AlfTextualRepresentation(modelElement);
		representation.setText(new DefaultEditStringRetrievalStrategy().getGeneratedEditString(modelElement));
		representation.setEditionState(new BackupState(
				new Timestamp(Calendar.getInstance().getTimeInMillis()),
				EditionStatus.MERGED));
		return representation;
	}
}
