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

import java.util.Collection;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.papyrus.gitlight.git.ui.Activator;
import org.eclipse.papyrus.gitlight.git.ui.providers.RepositoryAsStringLabelProvider;
import org.eclipse.papyrus.infra.widgets.providers.CollectionContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * This class define the repository selection dialog.
 */
public class RepositorySelectionDialog extends SelectionDialog {

	/**
	 * The tree viewer.
	 */
	protected TreeViewer treeViewer;

	/**
	 * The collection of repositories to display.
	 */
	protected Collection<String> repositories;

	/**
	 * The selected repository result.
	 */
	protected String selectedRepository;

	/**
	 * The validation message.
	 */
	protected Label statusMessage;

	/**
	 * Default constructor.
	 *
	 * @param parentShell
	 *            The parent shell.
	 * @param repositories
	 *            The list of existing repositories.
	 */
	public RepositorySelectionDialog(final Shell parentShell, final Collection<String> repositories) {
		super(parentShell);
		setTitle("Select Git repository"); //$NON-NLS-1$
		this.repositories = repositories;
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
		label.setText("Repositories:"); //$NON-NLS-1$

		final Composite drillDown = new Composite(area, SWT.BORDER);
		GridData spec = new GridData(SWT.FILL, SWT.FILL, true, true);
		spec.widthHint = 320;
		spec.heightHint = 300;
		drillDown.setLayoutData(spec);
		drillDown.setLayout(new GridLayout());

		// Create tree viewer inside drill down.
		treeViewer = new TreeViewer(drillDown, SWT.BORDER | SWT.SINGLE);
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		treeViewer.setContentProvider(CollectionContentProvider.instance);
		treeViewer.setLabelProvider(new RepositoryAsStringLabelProvider());
		treeViewer.setComparator(new ViewerComparator());
		treeViewer.setUseHashlookup(true);
		treeViewer.addSelectionChangedListener(event -> {
			IStructuredSelection selection = event.getStructuredSelection();
			repositorySelectionChanged((String) selection.getFirstElement()); // allow null
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
		treeViewer.setInput(repositories);

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
	 * @param selectedRepository
	 *            The selected repository.
	 */
	protected void repositorySelectionChanged(final String selectedRepository) {
		this.selectedRepository = selectedRepository;

		if (this.selectedRepository.isEmpty()) {
			statusMessage.setText("Please select a repository"); //$NON-NLS-1$
			getOkButton().setEnabled(false);
		} else {
			statusMessage.setText(" \n "); //$NON-NLS-1$
			getOkButton().setEnabled(true);
		}
	}

	/**
	 * Get the result selected repository.
	 * 
	 * @return The result selected repository.
	 */
	public String getSelectedRepository() {
		return selectedRepository;
	}
}
