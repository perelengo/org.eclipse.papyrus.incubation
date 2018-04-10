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

package org.eclipse.papyrus.diagramtemplate.editor.commands;

import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.commands.OpenDiagramCommand;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;

/**
 * @author Quentin Le Menez
 *
 */
public class OpenDiagramsCommand extends RecordingCommand {

	// Set<Diagram> diagramsToOpen;
	Diagram diagramToOpen;

	TransactionalEditingDomain editingDomain;

	/**
	 * Constructor.
	 *
	 * @param domain
	 * @param label
	 */
	// public OpenDiagramsCommand(TransactionalEditingDomain domain, String label, Set<Diagram> diagramsToOpen) {
	public OpenDiagramsCommand(TransactionalEditingDomain domain, String label, Diagram diagramToOpen) {
		super(domain, label);
		// this.diagramsToOpen = diagramsToOpen;
		this.diagramToOpen = diagramToOpen;
		this.editingDomain = domain;
	}

	/**
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 *
	 */
	@Override
	protected void doExecute() {
		// for (Diagram diagram : diagramsToOpen) {
		// editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(new OpenDiagramCommand(editingDomain, diagram)));
		AbstractCommand command = new GMFtoEMFCommandWrapper(new OpenDiagramCommand(editingDomain, diagramToOpen));
		if (command.canExecute()) {
			command.execute();
		}
		// }
	}

}
