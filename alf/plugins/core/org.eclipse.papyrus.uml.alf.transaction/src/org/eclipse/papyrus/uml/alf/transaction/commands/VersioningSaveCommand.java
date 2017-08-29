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
 * 	Jeremie Tatibouet (CEA LIST)
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.transaction.commands;

import org.eclipse.papyrus.uml.alf.libraries.helper.BackupUtil;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;

public class VersioningSaveCommand extends SaveCommand {

	protected VersioningSaveCommand(AlfTextualRepresentation representation) {
		super(representation);
	}

	/**
	 * In addition to save the specification of a model element, this command
	 * also serialization about edition time and status (i.e. is the specification
	 * merged into the model or is it just saved in the comment waiting to be propagated).
	 */
	protected void doExecute() {
		/* 1. Saves the stereotyped comment in the model */
		super.doExecute();
		/* 2. Save time and edition status */
		BackupUtil.getInstance().applyBackup(this.modelElementState.getSource(), this.modelElementState.getEditionState());
	}
}
