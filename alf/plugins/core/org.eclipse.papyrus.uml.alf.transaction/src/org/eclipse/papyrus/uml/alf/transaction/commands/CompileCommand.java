/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Tatibouet
 *  Arnaud Cuccuru
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.transaction.commands;

import org.eclipse.core.runtime.AssertionFailedException;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.papyrus.uml.alf.AlfCompiler;
import org.eclipse.papyrus.uml.alf.MappingError;
import org.eclipse.papyrus.uml.alf.ParsingError;
import org.eclipse.papyrus.uml.alf.libraries.helper.AlfUtil;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This command enables the compilation (ALF->fUML) of the given textual representation
 */
public class CompileCommand extends AlfCommand {

	protected CompileCommand(AlfTextualRepresentation modelElementState) {
		super(AlfCommandLabels.COMPILATION, modelElementState);
	}

	/**
	 * Compile the description provided by the textual representation and merge
	 * them within the current model element
	 */
	protected void doExecute() {
		NamedElement context = this.modelElementState.getOwner();
		Model root = context.getModel();
		if (root != null) {
			AlfCompiler alfCompiler = new AlfCompiler(
					(NamedElement) this.modelElementState.getOwner(),
					AlfUtil.getInstance().getStandardProfile(root),
					AlfUtil.getInstance().getActionLanguageProfile(root));
			try {
				alfCompiler.compile(this.modelElementState.getContent());
			} catch (ParsingError e) {
				e.printStackTrace();
				throw new WrappedException(e);
			} catch (MappingError e) {
				e.printStackTrace();
				throw new WrappedException(e);
			} catch (AssertionFailedException e) {
				e.printStackTrace();
			}
		}
	}

}
