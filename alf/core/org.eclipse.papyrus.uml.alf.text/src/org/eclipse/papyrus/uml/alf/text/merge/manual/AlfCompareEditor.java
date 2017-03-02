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
package org.eclipse.papyrus.uml.alf.text.merge.manual;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;

public class AlfCompareEditor extends CompareEditorInput {

	protected final AlfTextualRepresentation registeredRep;

	protected final AlfTextualRepresentation generatedRep;

	public AlfCompareEditor(AlfTextualRepresentation registeredTextualRepresentation,
			AlfTextualRepresentation generatedTextualRepresentation) {
		super(new CompareConfiguration());
		this.registeredRep = registeredTextualRepresentation;
		this.generatedRep = generatedTextualRepresentation;
	}

	@Override
	protected Object prepareInput(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		return null;
	}

	@Override
	public void saveChanges(IProgressMonitor monitor) throws CoreException {
		super.saveChanges(monitor);
	}

}
