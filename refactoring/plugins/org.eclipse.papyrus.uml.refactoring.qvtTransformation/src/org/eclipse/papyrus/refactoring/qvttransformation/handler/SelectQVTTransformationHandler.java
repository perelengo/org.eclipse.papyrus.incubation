/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.refactoring.qvttransformation.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.refactoring.core.PapyrusRefactoringOperation;
import org.eclipse.papyrus.refactoring.qvttransformation.popup.actions.SelectQVTTransformation;

/**
 * handler linked to refactoring the dropdown menu for the QVTo transformation
 * 
 */
public class SelectQVTTransformationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		PapyrusRefactoringOperation refactoringOperation = new PapyrusRefactoringOperation(new SelectQVTTransformation());
		refactoringOperation.run();
		return null;
	}

}
