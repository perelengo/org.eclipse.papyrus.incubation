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

/**
 * The page listener for the reviews views.
 */
public interface IContributionsViewPageListener {

	/**
	 * This will be called when a page is activated.
	 * 
	 * @param reviewsView
	 *            The reviews view.
	 */
	public void pageActivated(final ContributionsView reviewsView);

	/**
	 * This will be called when a page is closing.
	 * 
	 * @param reviewsView
	 *            The reviews view.
	 */
	public void pageClosing(final ContributionsView reviewsView);

}
