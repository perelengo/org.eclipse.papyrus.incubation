/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Jeremie Tatibouet (CEA LIST)
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf.transaction.job;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.uml.alf.MappingError;
import org.eclipse.papyrus.uml.alf.ParsingError;
import org.eclipse.papyrus.uml.alf.libraries.helper.AlfUtil;
import org.eclipse.papyrus.uml.alf.text.generation.DefaultEditStringRetrievalStrategy;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;
import org.eclipse.papyrus.uml.alf.transaction.ActivatorTransaction;
import org.eclipse.papyrus.uml.alf.transaction.commands.AlfCommand;
import org.eclipse.papyrus.uml.alf.transaction.commands.AlfCommandFactory;
import org.eclipse.uml2.uml.Activity;

public class AlfCompilationJob extends AlfAbstractJob {

	public static final String NAME = "Compile";

	private List<AlfCommand> executedCommands;

	public AlfCompilationJob(AlfTextualRepresentation representation) {
		super(NAME, representation);
		setUser(true);
		this.executedCommands = new ArrayList<AlfCommand>();
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		monitor.beginTask("Propagate Alf specification into the model", 4);
		this.executedCommands.clear();
		IStatus jobStatus = Status.OK_STATUS;
		TransactionalEditingDomain domain = this.getEditingDomain();
		if (domain != null) {
			/* Protect the resource in case of concurrent jobs */
			monitor.subTask("Prepare compilation");
			Resource resource = this.modelElementState.getOwner().eResource();
			monitor.worked(1);
			synchronized (resource) {
				/* 1. Do not listen to modifications that occur on the resource during compilation */
				resource.setTrackingModification(false);
				/* 2. Do compilation phase */
				jobStatus = this.doCompilation(domain, monitor);
				/* 3. Save the textual representation within the model */
				if (monitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				} else if (jobStatus.equals(Status.OK_STATUS)) {
					jobStatus = this.doSave(domain, monitor);
				} else {
					return jobStatus;
				}
				/* 4. Restore the modification tracking */
				resource.setTrackingModification(true);
			}
		}
		monitor.done();
		return jobStatus;
	}

	/**
	 * Execute the compilation procedure
	 * 
	 * @param domain
	 *            - the editing domain in which the modifications are done
	 * @param monitor
	 *            - the monitor used to report progress
	 * @return a status reporting the state of the job
	 */
	protected IStatus doCompilation(TransactionalEditingDomain domain, IProgressMonitor monitor) {
		monitor.subTask("Compiling");
		try {
			AlfCommand command = AlfCommandFactory.getInstance().createCompilationCommand(this.modelElementState);
			domain.getCommandStack().execute(command);
			this.executedCommands.add(command);
		} catch (WrappedException we) {
			Exception e = we.exception();
			if (e instanceof ParsingError) {
				return new Status(Status.ERROR, ActivatorTransaction.PLUGIN_ID, "The parsed specification is not valid");
			} else if (e instanceof MappingError) {
				return new Status(Status.ERROR, ActivatorTransaction.PLUGIN_ID, "It was not possible to map the specification into UML");
			} else {
				return new Status(Status.ERROR, ActivatorTransaction.PLUGIN_ID, "An unexpected error stopped the compilation phase");
			}
		} catch (Exception e) {
			return new Status(Status.ERROR, ActivatorTransaction.PLUGIN_ID, "An unexpected error stopped the compilation phase");
		}
		monitor.worked(1);
		return Status.OK_STATUS;
	}

	/**
	 * Execute the save procedure
	 * 
	 * @param domain
	 *            - the editing domain in which the modifications are done
	 * @param monitor
	 *            - the monitor used to report progress
	 * @return a status reporting the state of the job
	 */
	protected IStatus doSave(TransactionalEditingDomain domain, IProgressMonitor monitor) {
		/* The specification is only updated in case of elements that are not activites */
		if (!(this.modelElementState.getOwner() instanceof Activity)) {
			monitor.subTask("Format specification");
			this.modelElementState.setText(new DefaultEditStringRetrievalStrategy().getGeneratedEditString(this.modelElementState.getOwner()));
			monitor.worked(1);
		}
		try {
			if (this.modelElementState.getSource() == null) {
				this.modelElementState.setSource(AlfUtil.getInstance().getTextualRepresentationComment(this.modelElementState.getOwner()));
			}
			monitor.subTask("Save specification");
			AlfCommand command = AlfCommandFactory.getInstance().creatSaveCommand(this.modelElementState);
			domain.getCommandStack().execute(command);
			this.executedCommands.add(command);
			monitor.worked(1);
		} catch (Exception e) {
			return new Status(Status.ERROR, ActivatorTransaction.PLUGIN_ID, "An unexpected error stopped the compilation phase");
		}
		return Status.OK_STATUS;
	}

	@Override
	protected void canceling() {
		super.canceling();
		/*TODO: support cancellation*/
	}
}
