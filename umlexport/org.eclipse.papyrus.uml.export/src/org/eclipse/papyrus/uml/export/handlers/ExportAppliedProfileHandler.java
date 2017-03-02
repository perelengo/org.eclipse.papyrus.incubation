/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.export.handlers;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.ui.command.AbstractCommandHandler;
import org.eclipse.papyrus.uml.export.messages.Messages;
import org.eclipse.uml2.uml.Package;





// TODO: Auto-generated Javadoc
/**
 * The Class ExportAppliedProfileHandler.
 */
public class ExportAppliedProfileHandler extends AbstractCommandHandler {



	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCommand(final IEvaluationContext context) {

		if (canExecute()) {

			AbstractTransactionalCommand cmd = new ExportProfilesCommand(getEditingDomain(context), Messages.ExportAppliedProfileHandler_0, null);
			return new GMFtoEMFCommandWrapper(cmd);
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}





	/**
	 * Can execute.
	 *
	 * @return true, if successful
	 */
	public boolean canExecute() {
		if (getSelectedElements().size() == 1) {
			return (getSelectedElement() instanceof Package);
		}
		return false;
	}



}
