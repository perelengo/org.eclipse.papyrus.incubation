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

import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.internal.CompareEditor;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * This allows to define the property sheet page of CompareEditor to use.
 * We need this to define our proper property sheet page instead of the ExtendedPropertySheetPage.
 */
@SuppressWarnings("restriction")
public class CompareEditorPropertySheetAdapterFactory implements IAdapterFactory {

	/** The extended property sheet page provided by this adapter factory. */
	private TabbedPropertySheetPage propertySheetPage;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(Object, Class)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == IPropertySheetPage.class) {
			if (propertySheetPage == null) {
				if (adaptableObject instanceof CompareEditor) {
					IEditorInput editorInput = ((CompareEditor) adaptableObject).getEditorInput();
					if (editorInput instanceof CompareEditorInput) {
						final TabbedPropertySheetPage tabbedPropertySheetPage = new TabbedPropertySheetPage(new CompareEditorPropertySheetPageContributor()) {
							@Override
							public void dispose() {
								// Do not dispose
							}
						};
						propertySheetPage = tabbedPropertySheetPage;
					}
				}
			}
			return propertySheetPage;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class[] getAdapterList() {
		return new Class[] { IPropertySheetPage.class };
	}
}
