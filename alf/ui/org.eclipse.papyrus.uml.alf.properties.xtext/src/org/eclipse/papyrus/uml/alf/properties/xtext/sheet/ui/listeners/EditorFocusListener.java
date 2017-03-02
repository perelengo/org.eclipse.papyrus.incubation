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
 *   Jérémie Tatibouet (CEA LIST)
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf.properties.xtext.sheet.ui.listeners;

import org.eclipse.papyrus.uml.alf.transaction.commit.ScenarioFactory;
import org.eclipse.papyrus.uml.alf.properties.xtext.sheet.AlfEditionPropertySection;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.uml2.uml.NamedElement;

public class EditorFocusListener extends FocusAdapter {


	private AlfEditionPropertySection section;

	public EditorFocusListener(AlfEditionPropertySection section) {
		this.section = section;
	}

	/**
	 * When the ALF editor looses the focus, this triggers the execution of a backup sequence.
	 * This backup sequence saves the current state of the textual definition of the current model element.
	 * Modifications introduced in text are not propagated in the current model element.
	 */
	@Override
	public void focusLost(FocusEvent event) {
		/* 1. Retrieve the alf editor */
		StyledText alfEditor = null;
		if (event.getSource() instanceof StyledText) {
			alfEditor = (StyledText) event.getSource();
		}
		/* 2. Save the textual representation */
		if (alfEditor != null) {
			ScenarioFactory.getInstance().createSaveScenario().
					execute((NamedElement) this.section.getContextObject(), alfEditor.getText());
		}

	}
}
