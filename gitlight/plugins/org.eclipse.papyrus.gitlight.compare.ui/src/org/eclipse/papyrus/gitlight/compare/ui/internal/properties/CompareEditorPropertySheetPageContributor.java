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
package org.eclipse.papyrus.gitlight.compare.ui.internal.properties;

import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

/**
 * This allows to declare a property sheet page contributor for the CompareEditor of EMF Compare.
 */
public class CompareEditorPropertySheetPageContributor implements ITabbedPropertySheetPageContributor {

	/**
	 * Default constructor.
	 */
	public CompareEditorPropertySheetPageContributor() {
		// Do nothing
	}

	/**
	 * Define the contributor id corresponding to the identifier of papyrus property view.
	 * [{@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor#getContributorId()
	 */
	@Override
	public String getContributorId() {
		return "TreeOutlinePage"; //$NON-NLS-1$ a
	}

}
