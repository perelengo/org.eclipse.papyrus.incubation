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
package org.eclipse.papyrus.gitlight.git.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.papyrus.gitlight.git.data.CatalogVersion;
import org.eclipse.papyrus.gitlight.git.ui.Activator;
import org.eclipse.papyrus.gitlight.git.utils.GitAnnotationUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Element;


/**
 * The dialog to create a review of the model.
 */
public class ReviewDialog extends TitleAreaDialog {

	/** Text area that displays previous version of the profile definition. */
	protected Text oldVersionText;

	/** Button to select the new version number (major release). */
	protected Button majorVersionButton;

	/** Button to select the new version number (minor release). */
	protected Button minorVersionButton;

	/** Button to select the new version number (custom version). */
	protected Button customVersionButton;

	/** Text area where custom version number can be entered. */
	protected Text customVersionText;

	/** The root model. */
	protected Element rootModel;

	/** The major version value. */
	private CatalogVersion majorVersionValue;

	/** The minor version value. */
	private CatalogVersion minorVersionValue;

	/** The oldVersion version value. */
	private CatalogVersion oldVersionValue;

	/** The custom version value. */
	private CatalogVersion customReleaseVersionValue;

	/** The new version value. */
	private CatalogVersion newVersionValue;

	/** Comment text area. */
	private Text commentText;

	/** Author text area. */
	private Text authorText;

	/** The comment value. */
	private String commentValue;

	/** The author value. */
	private String authorValue;

	/** Boolean to determinate if the version will be displayed or not. */
	private boolean displayVersion;


	/**
	 * Creates a new ProfileDefinitionDialog
	 *
	 * @param parentShell
	 *            The parent shell for this dialog.
	 * @param rootModel
	 *            The root model element.
	 * @param displayVersion
	 *            Boolean to determinate if the version will be displayed or not.
	 */
	public ReviewDialog(final Shell parentShell, final Element rootModel, final boolean displayVersion) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.rootModel = rootModel;
		this.displayVersion = displayVersion;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		commentValue = commentText.getText();
		authorValue = authorText.getText();
		super.okPressed();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		// top level composite
		final Composite parentComposite = (Composite) super.createDialogArea(parent);

		setTitle("Information about new version"); //$NON-NLS-1$
		getShell().setImage(Activator.getDefault().getImage("org.eclipse.papyrus.infra.widgets", "/icons/papyrus.png")); //$NON-NLS-1$ //$NON-NLS-2$

		// create a composite with standard margins and spacing
		final Composite composite = new Composite(parentComposite, SWT.NONE);
		final GridLayout layout = new GridLayout(2, true);
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setFont(parentComposite.getFont());

		// fill composite with information about new definition:
		// 1. version
		// 2. author
		// 3. comment

		GridData gd = null;
		if (displayVersion) {
			// compute initial values
			computeVersionValues();

			final Composite versionArea = createVersionArea(composite);
			gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
			versionArea.setLayoutData(gd);
		}

		final Composite infoArea = createInfoArea(composite);
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		if (!displayVersion) {
			gd.horizontalSpan = 2;
		}
		infoArea.setLayoutData(gd);

		final Composite commentArea = createCommentArea(composite);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, true, 2, 1);
		commentArea.setLayoutData(gd);

		applyDialogFont(parentComposite);
		return parentComposite;
	}

	/**
	 * Creates and returns the content of the information area.
	 *
	 * @param composite
	 *            The parent composite to contain the information area.
	 */
	private Composite createInfoArea(final Composite composite) {
		final Group group = new Group(composite, SWT.CENTER);
		group.setText("Info"); //$NON-NLS-1$
		final GridLayout layout = new GridLayout(2, false);
		group.setLayout(layout);

		final Label authorLabel = new Label(group, SWT.LEFT);
		authorLabel.setText("Author"); //$NON-NLS-1$
		GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		authorLabel.setLayoutData(gd);
		authorText = new Text(group, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		authorText.setLayoutData(gd);

		return group;
	}

	/**
	 * Creates and returns the content of the comment area.
	 *
	 * @param composite
	 *            The parent composite to contain the comment area.
	 */
	private Composite createCommentArea(final Composite composite) {
		final Group group = new Group(composite, SWT.CENTER);
		group.setText("Comment"); //$NON-NLS-1$
		final GridLayout layout = new GridLayout(1, false);
		group.setLayout(layout);

		// new comment area
		commentText = new Text(group, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentText.setText(""); //$NON-NLS-1$
		final GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, true);
		gd.heightHint = 60;
		commentText.setLayoutData(gd);

		return group;
	}

	/**
	 * Creates and returns the content of the version area.
	 *
	 * @param composite
	 *            The parent composite to contain the version area.
	 */
	private Composite createVersionArea(final Composite composite) {
		final Group group = new Group(composite, SWT.CENTER);
		group.setText("Version"); //$NON-NLS-1$
		final GridLayout layout = new GridLayout(2, false);
		group.setLayout(layout);

		// old version label
		final Label oldVersionLabel = new Label(group, SWT.LEFT);
		oldVersionLabel.setText("Previous Version"); //$NON-NLS-1$
		GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		oldVersionLabel.setLayoutData(gd);
		final Text oldVersionText = new Text(group, SWT.SINGLE | SWT.READ_ONLY | SWT.BORDER);
		oldVersionText.setText(oldVersionValue.toString());
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		oldVersionText.setLayoutData(gd);

		// new version:
		// 1. Minor
		// 2. Major
		// 3. Custom

		// Minor area
		minorVersionButton = new Button(group, SWT.CHECK);
		minorVersionButton.setText("Minor Version"); //$NON-NLS-1$
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		minorVersionButton.setLayoutData(gd);
		minorVersionButton.setSelection(true);
		minorVersionButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				minorVersionButtonPressed();
			}
		});
		final Text releaseVersionText = new Text(group, SWT.SINGLE | SWT.READ_ONLY | SWT.BORDER);
		releaseVersionText.setText(minorVersionValue.toString());
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		releaseVersionText.setLayoutData(gd);

		// Major area
		majorVersionButton = new Button(group, SWT.CHECK);
		majorVersionButton.setText("Major Version"); //$NON-NLS-1$
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		majorVersionButton.setLayoutData(gd);
		majorVersionButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				majorVersionButtonPressed();
			}
		});
		final Text majorReleaseVersionText = new Text(group, SWT.SINGLE | SWT.READ_ONLY | SWT.BORDER);
		majorReleaseVersionText.setText(majorVersionValue.toString());
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		majorReleaseVersionText.setLayoutData(gd);

		// Custom area
		customVersionButton = new Button(group, SWT.CHECK);
		customVersionButton.setText("Custom"); //$NON-NLS-1$
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		customVersionButton.setLayoutData(gd);
		customVersionButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				customVersionButtonPressed();
			}
		});
		customVersionText = new Text(group, SWT.SINGLE | SWT.BORDER);
		customVersionText.setEditable(false); // by default
		customVersionText.setText(customReleaseVersionValue.toString());
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		customVersionText.setLayoutData(gd);
		customVersionText.addFocusListener(new FocusListener() {

			public void focusGained(final FocusEvent e) {
				customVersionText.setText(customReleaseVersionValue.toString());
			}

			public void focusLost(final FocusEvent e) {
				try {
					customReleaseVersionValue = CatalogVersion.parseVersion(customVersionText.getText());
					newVersionValue = customReleaseVersionValue;
					setErrorMessage(null);
				} catch (IllegalArgumentException iae) {
					setErrorMessage("Custom version number format should be X.Y, not " + customVersionText.getText()); //$NON-NLS-1$
					customReleaseVersionValue = minorVersionValue; // default value
					minorVersionButtonPressed();
				}
			}
		});

		return group;
	}

	/**
	 * Compute the value of the versions.
	 */
	private void computeVersionValues() {
		oldVersionValue = GitAnnotationUtils.getVersionAnnotation(rootModel);
		minorVersionValue = new CatalogVersion(oldVersionValue.getMajor(), oldVersionValue.getMinor() + 1);
		majorVersionValue = new CatalogVersion(oldVersionValue.getMajor() + 1, 0);
		customReleaseVersionValue = minorVersionValue;
		newVersionValue = minorVersionValue;
	}

	/**
	 * Action called as the major version button is pressed.
	 */
	private void majorVersionButtonPressed() {
		minorVersionButton.setSelection(false);
		majorVersionButton.setSelection(true);
		customVersionButton.setSelection(false);
		newVersionValue = majorVersionValue;
		customVersionText.setEditable(false);
	}

	/**
	 * Action called as the minor version button is pressed.
	 */
	private void minorVersionButtonPressed() {
		minorVersionButton.setSelection(true);
		majorVersionButton.setSelection(false);
		customVersionButton.setSelection(false);
		newVersionValue = minorVersionValue;
		customVersionText.setEditable(false);
	}

	/**
	 * Action called as the custom version button is pressed.
	 */
	private void customVersionButtonPressed() {
		minorVersionButton.setSelection(false);
		majorVersionButton.setSelection(false);
		customVersionButton.setSelection(true);
		newVersionValue = customReleaseVersionValue;
		customVersionText.setEditable(true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(final Shell shell) {
		super.configureShell(shell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		shell.setText("Version Definition"); //$NON-NLS-1$
	}

	/**
	 * Get the new version value.
	 * 
	 * @return The new version value.
	 */
	public CatalogVersion getNewVersionValue() {
		return newVersionValue;
	}

	/**
	 * Get the comment value.
	 * 
	 * @return The comment value.
	 */
	public String getComment() {
		return commentValue;
	}

	/**
	 * Get the author value.
	 * 
	 * @return The author value.
	 */
	public String getAuthor() {
		return authorValue;
	}
}
