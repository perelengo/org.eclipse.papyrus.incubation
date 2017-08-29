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
package org.eclipse.papyrus.refactoring.ui;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ltk.core.refactoring.RefactoringStatusContext;
import org.eclipse.ltk.ui.refactoring.IStatusContextViewer;
import org.eclipse.papyrus.refactoring.core.PapyrusRefactoringValidationStatusContext;
import org.eclipse.papyrus.refactoring.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;

/**
 * Implementation of {@link IStatusContextViewer} to present a {@link PapyrusRefactoringValidationStatusContext} to review potential conflicts
 *
 */
public class PapyrusStatusContextViewer implements IStatusContextViewer {

	/** Page's main composite doubling as the Control for the status page */
	private Composite fParentComposite;

	/** Child composite */
	private Composite childDiagComposite;

	/** Expanding the details from the status check */
	private ExpandBar fBar;


	@Override
	public void createControl(Composite parent) {
		fParentComposite = new Composite(parent, SWT.BORDER | SWT.FLAT);
		fParentComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		fParentComposite.setLayout(new GridLayout(1, true));

		Composite detailComposite = new Composite(fParentComposite, SWT.BORDER | SWT.FLAT);

		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		detailComposite.setLayout(new GridLayout(1, true));

		Device device = Display.getCurrent();

		fBar = new ExpandBar(detailComposite, SWT.V_SCROLL | SWT.H_SCROLL);
		fBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		fBar.setBackground(new Color(device, 255, 255, 255));
		fBar.setForeground(new Color(device, 0, 0, 255));

		// First item
		childDiagComposite = new Composite(fBar, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginLeft = layout.marginTop = layout.marginRight = layout.marginBottom = 10;
		layout.verticalSpacing = 10;
		childDiagComposite.setLayout(layout);
		childDiagComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

	}

	@Override
	public Control getControl() {
		return fParentComposite;
	}

	@Override
	public void setInput(RefactoringStatusContext input) {
		if (input instanceof PapyrusRefactoringValidationStatusContext && fBar == null) {
			Diagnostic diagnostic = ((PapyrusRefactoringValidationStatusContext) input).getfDiagnostic();

			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				Label label = new Label(childDiagComposite, SWT.NONE);
				label.setText(childDiagnostic.getMessage());
			}

			ExpandItem item0 = new ExpandItem(fBar, SWT.V_SCROLL | SWT.H_SCROLL, 0);
			item0.setText(Messages.PAPYRUSREFACTORPREVIEW_CHANGEDETAILS);
			item0.setHeight(childDiagComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
			item0.setControl(childDiagComposite);

			item0.setExpanded(false);
		}
	}

}
