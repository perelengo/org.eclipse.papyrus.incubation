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
 *  Jeremie Tatibouet
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.text.merge.manual;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.NamedElement;

public class MergeActionDialog extends TitleAreaDialog {

	protected NamedElement modelElement;

	protected final int WIDTH = 590;

	protected final int HEIGHT = 280;

	private List<Button> checkboxes;

	private int returnCode;

	private final String REBASE_MSG = "Abandon the modifications you previously saved for this element";
	private final String MERGE_MSG = "Merge your ongoing modifications with the current state of this element [under construction]";
	private final String RECONCILE_MSG = "Try to automatically reconcile your ongoing modifications with the current state of this element (risky)";

	public static final int REBASE = 0;
	public static final int MERGE = 1;
	public static final int RECONCILE = 2;

	public MergeActionDialog(Shell parent, NamedElement modelElement) {
		super(parent);
		this.returnCode = 0;
		this.modelElement = modelElement;
		this.checkboxes = new ArrayList<Button>();
	}

	public void create() {
		super.create();
		this.setTitle("Warning");
		String value = "You have ongoing changes this model element: ";
		value += this.modelElement.getName() == null ? "<unknown>" : this.modelElement.getName();
		value += " (" + this.modelElement.eClass().getInstanceTypeName() + ")";
		this.setMessage(value, IMessageProvider.WARNING);
		this.getShell().setText("Potential conflict(s) detected");
		this.getShell().setSize(WIDTH, HEIGHT);
		Rectangle parentShellBounds = this.getParentShell().getBounds();
		this.getShell().setLocation((parentShellBounds.width - WIDTH) / 2 + parentShellBounds.x,
				(parentShellBounds.height - HEIGHT) / 2 + parentShellBounds.y);
	}

	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		GridLayout layout = new GridLayout();
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		container.setLayoutData(data);
		container.setLayout(layout);
		this.createActionGroup(container);
		return area;
	}

	private void createActionGroup(Composite parent) {
		Group actionsGroup = new Group(parent, SWT.NONE);
		actionsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		RowLayout layout = new RowLayout();
		layout.type = SWT.VERTICAL;
		layout.spacing = 12;
		actionsGroup.setLayout(layout);
		this.checkboxes.add(this.createAction(actionsGroup, true, REBASE_MSG));
		Button merge = this.createAction(actionsGroup, false, MERGE_MSG);
		merge.setEnabled(false);
		this.checkboxes.add(merge);
		this.checkboxes.add(this.createAction(actionsGroup, false, RECONCILE_MSG));
		this.returnCode = REBASE;
	}

	private Button createAction(Composite parent, final boolean checked, final String message) {
		Button checkbox = new Button(parent, SWT.CHECK);
		checkbox.setSelection(checked);
		checkbox.setText(message);
		checkbox.addSelectionListener(new CheckboxSelectionListener());
		return checkbox;
	}

	@Override
	public int getReturnCode() {
		if (super.getReturnCode() != 0) {
			this.returnCode = super.getReturnCode();
		}
		return this.returnCode;
	}

	private class CheckboxSelectionListener extends SelectionAdapter {

		public void widgetSelected(SelectionEvent e) {
			for (Button checkbox : MergeActionDialog.this.checkboxes) {
				if (checkbox == e.getSource()) {
					checkbox.setSelection(true);
					if (checkbox.getText().equals(REBASE_MSG)) {
						MergeActionDialog.this.returnCode = REBASE;
					} else if (checkbox.getText().equals(MERGE_MSG)) {
						MergeActionDialog.this.returnCode = MERGE;
					} else {
						MergeActionDialog.this.returnCode = RECONCILE;
					}
				} else {
					checkbox.setSelection(false);
				}
			}
		}
	}
}
