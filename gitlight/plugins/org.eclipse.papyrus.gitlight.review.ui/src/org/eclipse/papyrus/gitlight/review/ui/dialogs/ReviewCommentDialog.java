/*****************************************************************************
 * Copyright (c) 2019 CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gitlight.review.ui.dialogs;

import org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment;
import org.eclipse.papyrus.gitlight.reviewprofile.ReviewSeverity;
import org.eclipse.papyrus.infra.properties.ui.widgets.layout.PropertiesLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * This allows to define the dialog to edit to review comment.
 */
public class ReviewCommentDialog extends SelectionDialog {

	/** The properties composite for the package. */
	private Composite mainComposite;

	/** The review comment to edit. */
	private ReviewComment reviewComment;

	/** The severity combo will allow to define the review comment severity. */
	private Combo severityCombo;

	/** The text field will allow to define the comment body. */
	private Text bodyText;

	/**
	 * Constructor.
	 *
	 * @param parentShell
	 *            The parent shell.
	 * @param element
	 *            The element to edit
	 */
	public ReviewCommentDialog(final Shell parentShell, final ReviewComment reviewComment) {
		super(parentShell);

		this.reviewComment = reviewComment;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#create()
	 */
	@Override
	public void create() {
		super.create();
		if (getShell().getText() == null || getShell().getText().isEmpty()) {
			getShell().setText("Edit Review Comment"); //$NON-NLS-1$
		}
		getShell().setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("/icons/papyrus.png")); //$NON-NLS-1$

		// Create the parent composite
		final Composite parent = new Composite(getDialogArea(), SWT.NONE);
		parent.setLayout(new PropertiesLayout());
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Create properties view
		createMainComposite(parent);

		getShell().pack();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#getDialogArea()
	 */
	@Override
	public Composite getDialogArea() {
		return (Composite) super.getDialogArea();
	}

	/**
	 * Create the properties group.
	 * 
	 * @param parent
	 *            The parent composite.
	 */
	protected void createMainComposite(final Composite parent) {
		mainComposite = new Composite(parent, SWT.NONE);
		final GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		mainComposite.setLayout(layout);
		final GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.minimumHeight = 200;
		data.widthHint = 400;
		mainComposite.setLayoutData(data);

		// Manage the severity
		final Label severityLabel = new Label(mainComposite, SWT.NONE);
		severityLabel.setText("Severity:"); //$NON-NLS-1$
		severityCombo = new Combo(mainComposite, SWT.NONE);
		severityCombo.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		severityCombo.setItems(ReviewSeverity.INFO.getName(), ReviewSeverity.WARNING.getName(), ReviewSeverity.ERROR.getName());
		final int initialSeverityIndex = reviewComment.getSeverity().equals(ReviewSeverity.INFO) ? 0 : reviewComment.getSeverity().equals(ReviewSeverity.WARNING) ? 1 : 2;
		severityCombo.select(initialSeverityIndex);

		// Manage the comment body
		final Label bodyLabel = new Label(mainComposite, SWT.NONE);
		bodyLabel.setText("Body"); //$NON-NLS-1$
		final GridData bodyLabelLayoutData = new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false);
		bodyLabelLayoutData.horizontalSpan = 2;
		bodyLabel.setLayoutData(bodyLabelLayoutData);
		bodyText = new Text(mainComposite, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
		final GridData bodyLayoutData = new GridData(GridData.FILL_BOTH);
		bodyLayoutData.horizontalSpan = 2;
		bodyLayoutData.heightHint = 60;
		bodyText.setLayoutData(bodyLayoutData);
		if (null != reviewComment.getBase_Comment().getBody()) {
			bodyText.setText(reviewComment.getBase_Comment().getBody());
		}
		// set the focus to the body
		bodyText.forceFocus();
	}

	/**
	 * Manage review comment values before manage the ok button.
	 * [{@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 *
	 */
	@Override
	protected void okPressed() {
		// Add values to review comment
		switch (severityCombo.getSelectionIndex()) {
		case 0:
			reviewComment.setSeverity(ReviewSeverity.INFO);
			break;
		case 1:
			reviewComment.setSeverity(ReviewSeverity.WARNING);
			break;
		case 2:
			reviewComment.setSeverity(ReviewSeverity.ERROR);
			break;
		}
		reviewComment.getBase_Comment().setBody(bodyText.getText());

		super.okPressed();
	}
}
