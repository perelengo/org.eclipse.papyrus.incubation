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
package org.eclipse.papyrus.refactoring.core;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ltk.core.refactoring.RefactoringStatusContext;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;

/**
 * {@link RefactoringStatusContext} for annotating a the {@link RefactoringStatusEntry} linked to
 * the verification of the model validity after the refactoring.
 *
 */
public class PapyrusRefactoringValidationStatusContext extends RefactoringStatusContext {

	/** The {@link Diagnostic} that represents the model validity after the refactoring. */
	private Diagnostic fDiagnostic;


	public PapyrusRefactoringValidationStatusContext(Diagnostic diagnostic) {
		fDiagnostic = diagnostic;
	}

	public Diagnostic getfDiagnostic() {
		return fDiagnostic;
	}

	@Override
	public Object getCorrespondingElement() {
		return fDiagnostic;
	}



}
