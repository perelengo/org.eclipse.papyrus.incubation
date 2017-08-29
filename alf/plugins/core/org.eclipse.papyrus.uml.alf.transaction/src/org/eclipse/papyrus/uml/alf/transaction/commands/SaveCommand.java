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

import org.eclipse.papyrus.uml.alf.libraries.helper.AlfUtil;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * This command enables the backup of the specification of particular model element
 * in a comment owned by this latter
 */
public class SaveCommand extends AlfCommand {

	protected SaveCommand(AlfTextualRepresentation representation) {
		super(AlfCommandLabels.CREATE_OR_UPDATE_TEXTUAL_REPRESENTATION, representation);
	}

	/**
	 * Saves the specification in a comment stereotyped TextualRepresentation
	 */
	protected void doExecute() {
		AlfUtil helper = AlfUtil.getInstance();
		/* 1. Make sure it exists a comment to save the model element description */
		Comment comment = this.modelElementState.getSource();
		if (comment == null) {
			comment = UMLFactory.eINSTANCE.createComment();
			this.modelElementState.setSource(comment);
		}
		/* 2. Make sure the comment used to save the model element description has a owner */
		if (comment.getOwner() == null) {
			this.modelElementState.getOwner().getOwnedComments().add(comment);
		}
		/* 3. Set the body of the comment with the model element description */
		comment.setBody(this.modelElementState.getContent());
		/* 4. Make sure the TextualRepresentation stereotype is applied onto the comment */
		if (!helper.isATextualRepresentationComment(comment)) {
			helper.applyTextualRepresentation(comment);
		}
	}
}
