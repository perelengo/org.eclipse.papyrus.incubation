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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.transaction.job;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;
import org.eclipse.papyrus.uml.alf.transaction.commands.AlfCommandFactory;

public class SaveTextualRepresentationJob extends AlfAbstractJob {

	public static final String NAME = "Save";

	public SaveTextualRepresentationJob(AlfTextualRepresentation representation) {
		super(NAME, representation);
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		/* 1. Retrieve the editing domain */
		TransactionalEditingDomain domain = this.getEditingDomain();
		/* 3. Ask for the execution of the command */
		if (domain != null) {
			/* Protect the resource in case of concurrent jobs */
			Resource resource = this.modelElementState.getOwner().eResource();
			synchronized (resource) {
				domain.getCommandStack().execute(AlfCommandFactory.getInstance().creatSaveCommand(this.modelElementState));
			}
		} else {
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

}
