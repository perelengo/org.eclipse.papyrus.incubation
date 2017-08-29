/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.refactoring.mutation.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.refactoring.core.PapyrusRefactoringOperation;
import org.eclipse.papyrus.uml.refactoring.mutation.ui.MutationRefactoring;


/**
 * Handler called by the dropdown menu to mutate the selected element
 * 
 */
public class MutationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		MutationRefactoring mutationRefactoring = new MutationRefactoring();
		PapyrusRefactoringOperation operation = new PapyrusRefactoringOperation(mutationRefactoring);
		operation.run();
		return null;
	}

}
