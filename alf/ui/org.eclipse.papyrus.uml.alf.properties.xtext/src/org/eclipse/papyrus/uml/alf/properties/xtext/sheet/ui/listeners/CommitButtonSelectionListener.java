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

import org.eclipse.papyrus.uml.alf.transaction.commit.CommitScenario;
import org.eclipse.papyrus.uml.alf.transaction.commit.ScenarioFactory;
import org.eclipse.papyrus.uml.alf.properties.xtext.sheet.AlfEditionPropertySection;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.uml2.uml.NamedElement;

public class CommitButtonSelectionListener extends SelectionAdapter {


	private AlfEditionPropertySection propertySection;

	public CommitButtonSelectionListener(AlfEditionPropertySection propertySection) {
		this.propertySection = propertySection;
	}

	/**
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent event) {
		/* 1. Retrieved the current model element */
		NamedElement semanticObject = (NamedElement) this.propertySection.getContextObject();
		/* 2. Retrieved its currently edited representation */
		StyledText editor = this.propertySection.getEditor();
		/* 3. Compile without blocking URI */
		if (semanticObject != null && editor != null) {
			CommitScenario commitScenario = (CommitScenario) ScenarioFactory.getInstance().createCommitScenario();
			commitScenario.bindView(editor);
			commitScenario.execute(semanticObject, editor.getText());
		}
	}
}
