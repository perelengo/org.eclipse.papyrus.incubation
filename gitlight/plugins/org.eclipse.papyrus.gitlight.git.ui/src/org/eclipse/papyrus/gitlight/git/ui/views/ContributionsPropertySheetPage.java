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
package org.eclipse.papyrus.gitlight.git.ui.views;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.operation.DelegatingUndoContext;
import org.eclipse.papyrus.infra.tools.util.PlatformHelper;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.google.common.base.Supplier;

/**
 * The property sheet page for the requirements dependence views.
 */
public class ContributionsPropertySheetPage extends TabbedPropertySheetPage implements IContributionsViewPageListener {

	/**
	 * The view to manage.
	 */
	private final ContributionsView reviewsView;

	/**
	 * The undo.
	 */
	private UndoActionHandler undo = null;

	/**
	 * The redo.
	 */
	private RedoActionHandler redo = null;

	/**
	 * The undo context.
	 */
	private DelegatingUndoContext undoContext = null;

	/**
	 * Constructor.
	 *
	 * @param reviewsView
	 *            The reviews view that owns me.
	 */
	public ContributionsPropertySheetPage(final ContributionsView reviewsView) {
		super(reviewsView);

		this.reviewsView = reviewsView;
		reviewsView.addPageListener(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage#setActionBars(org.eclipse.ui.IActionBars)
	 */
	@Override
	public void setActionBars(final IActionBars actionBars) {
		super.setActionBars(actionBars);

		undoContext = new DelegatingUndoContext.Dynamic(new Supplier<IUndoContext>() {

			public IUndoContext get() {
				return PlatformHelper.getAdapter(reviewsView, IUndoContext.class);
			}
		});

		undo = new UndoActionHandler(getSite().getPage().getActivePart().getSite(), undoContext);
		redo = new RedoActionHandler(getSite().getPage().getActivePart().getSite(), undoContext);

		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undo);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redo);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage#dispose()
	 */
	@Override
	public void dispose() {
		reviewsView.removePageListener(this);

		if (undo != null) {
			undo.dispose();
		}
		if (redo != null) {
			redo.dispose();
		}

		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.gitlight.git.ui.views.IContributionsViewPageListener#pageActivated(org.eclipse.papyrus.gitlight.git.ui.views.ContributionsView)
	 */
	@Override
	public void pageActivated(final ContributionsView reviewsView) {
		// Ensure that I am showing the up-to-date selection
		selectionChanged(reviewsView, reviewsView.getSite().getSelectionProvider().getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.gitlight.git.ui.views.IContributionsViewPageListener#pageClosing(org.eclipse.papyrus.gitlight.git.ui.views.ContributionsView)
	 */
	@Override
	public void pageClosing(final ContributionsView reviewsView) {
		// Forget the selection because it is now invalid and we don't want to show it when next the Model Explorer is activated
		selectionChanged(reviewsView, StructuredSelection.EMPTY);
	}

}
