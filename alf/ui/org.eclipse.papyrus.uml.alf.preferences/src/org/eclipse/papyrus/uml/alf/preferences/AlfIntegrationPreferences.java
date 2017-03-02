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
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.preferences;

import org.eclipse.gmf.runtime.common.ui.preferences.CheckBoxFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class AlfIntegrationPreferences extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private final static String preferencePageTitle = "Configure Alf support in Papyrus Model";

	public AlfIntegrationPreferences() {
		super(GRID);
	}

	@Override
	protected void createFieldEditors() {
		final CheckBoxFieldEditor enableAlfSupport = new CheckBoxFieldEditor(
				AlfIntegrationPreferencesConstants.ALF_SUPPORT,
				AlfIntegrationPreferencesConstants.ALF_SUPPORT_LABEL,
				this.getFieldEditorParent());

		final CheckBoxFieldEditor enableSynchronization = new CheckBoxFieldEditor(
				AlfIntegrationPreferencesConstants.ALF_AUTOMATIC_SYNCHRONIZATION,
				AlfIntegrationPreferencesConstants.ALF_AUTOMATIC_SYNCHRONIZATION_LABEL,
				this.getFieldEditorParent());
		enableSynchronization.setEnabled(
				AlfIntegrationPreferencesUtil.isAlfSupportEnabled(),
				this.getFieldEditorParent());

		enableAlfSupport.getCheckbox().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (enableAlfSupport.getBooleanValue()) {
					enableSynchronization.setEnabled(true, AlfIntegrationPreferences.this.getFieldEditorParent());
				} else {
					enableSynchronization.setEnabled(false, AlfIntegrationPreferences.this.getFieldEditorParent());
				}
			}
		});

		this.addField(enableAlfSupport);
		this.addField(enableSynchronization);
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(preferencePageTitle);
	}
}
