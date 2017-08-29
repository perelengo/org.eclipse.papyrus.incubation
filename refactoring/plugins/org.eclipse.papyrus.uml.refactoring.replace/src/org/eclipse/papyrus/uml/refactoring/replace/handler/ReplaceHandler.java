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
package org.eclipse.papyrus.uml.refactoring.replace.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.refactoring.core.PapyrusRefactoringOperation;
import org.eclipse.papyrus.uml.refactoring.replace.ui.ReplaceRefactoring;

/**
 * Replace handler linked to the dropdown menu
 * 
 */
public class ReplaceHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ReplaceRefactoring replaceRefactoring = new ReplaceRefactoring();
		PapyrusRefactoringOperation operation = new PapyrusRefactoringOperation(replaceRefactoring);
		operation.run();
		return null;
	}



}
