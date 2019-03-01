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

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.papyrus.gitlight.git.ui.Activator;
import org.eclipse.papyrus.gitlight.git.ui.providers.BranchLabelProvider;
import org.eclipse.papyrus.gitlight.git.ui.providers.BranchesContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * This class define the contributions (branches) selection dialog.
 */
public class ContributionSelectionDialog extends SelectionDialog {

	/**
	 * The tree viewer.
	 */
	protected TreeViewer treeViewer;

	/**
	 * The git (and also the input of the treeviewer).
	 */
	protected Git git;

	/**
	 * The selected repository result.
	 */
	protected Ref selectedBranch;

	/**
	 * The validation message.
	 */
	protected Label statusMessage;

	/**
	 * Default constructor.
	 *
	 * @param parentShell
	 *            The parent shell.
	 * @param git
	 *            The git.
	 */
	public ContributionSelectionDialog(final Shell parentShell, final Git git) {
		super(parentShell);
		setTitle("Select contribution"); //$NON-NLS-1$
		this.git = git;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		// create composite
		final Composite area = (Composite) super.createDialogArea(parent);

		getShell().setImage(Activator.getDefault().getImage("org.eclipse.papyrus.infra.widgets", "/icons/papyrus.png")); //$NON-NLS-1$ //$NON-NLS-2$

		// container selection group
		final GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		area.setLayout(layout);
		area.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Label label = new Label(area, SWT.WRAP);
		label.setText("Contributions:"); //$NON-NLS-1$

		final Composite drillDown = new Composite(area, SWT.BORDER);
		GridData spec = new GridData(SWT.FILL, SWT.FILL, true, true);
		spec.widthHint = 620;
		spec.heightHint = 300;
		drillDown.setLayoutData(spec);
		drillDown.setLayout(new GridLayout());

		// Create tree viewer inside drill down.
		treeViewer = new TreeViewer(drillDown, SWT.BORDER | SWT.SINGLE);
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		treeViewer.setContentProvider(new BranchesContentProvider(false));
		treeViewer.setLabelProvider(new BranchLabelProvider(git));
		treeViewer.setUseHashlookup(true);
		treeViewer.addSelectionChangedListener(event -> {
			IStructuredSelection selection = event.getStructuredSelection();
			if (selection.getFirstElement() instanceof Ref) {
				branchSelectionChanged((Ref) selection.getFirstElement()); // allow null
			} else {
				branchSelectionChanged(null);
			}
		});
		treeViewer.addDoubleClickListener(event -> {
			ISelection selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				Object item = ((IStructuredSelection) selection)
						.getFirstElement();
				if (item == null) {
					return;
				}
				if (treeViewer.getExpandedState(item)) {
					treeViewer.collapseToLevel(item, 1);
				} else {
					treeViewer.expandToLevel(item, 1);
				}
			}
		});

		// This has to be done after the viewer has been laid out
		treeViewer.setInput(git);

		statusMessage = new Label(area, SWT.WRAP);
		statusMessage.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		statusMessage.setText(" \n "); //$NON-NLS-1$
		statusMessage.setFont(parent.getFont());

		drillDown.layout();

		return dialogArea;
	}

	/**
	 * Manage the selection changed to update the message.
	 * 
	 * @param selectedBranch
	 *            The selected branch.
	 */
	protected void branchSelectionChanged(final Ref selectedBranch) {
		this.selectedBranch = selectedBranch;

		if (null == this.selectedBranch) {
			statusMessage.setText("Please select a contribution"); //$NON-NLS-1$
			getOkButton().setEnabled(false);
		} else {
			statusMessage.setText(" \n "); //$NON-NLS-1$
			getOkButton().setEnabled(true);
		}
	}

	/**
	 * Get the result selected branch.
	 * 
	 * @return The result selected branch.
	 */
	public Ref getSelectedBranch() {
		return selectedBranch;
	}
}
