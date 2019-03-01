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
package org.eclipse.papyrus.gitlight.git.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;

/**
 * The git icons.
 */
public class GitIcons {

	/** The branch icon. */
	public final static ImageDescriptor BRANCH;
	
	/** The review view icon. */
	public final static ImageDescriptor REVIEWS_VIEW;

	/** The repository icon. */
	public final static ImageDescriptor REPOSITORY;

	/** base URL */
	public final static URL base;

	static {
		base = init();
		BRANCH = map("resources/icons/branch.png"); //$NON-NLS-1$
		REVIEWS_VIEW = map("resources/icons/reviewsView.png"); //$NON-NLS-1$
		REPOSITORY = map("resources/icons/repository.png"); //$NON-NLS-1$
	}

	/**
	 * This allows to initialize the base url.
	 * 
	 * @return The base URL.
	 */
	private static URL init() {
		try {
			return new URL(Activator.getDefault().getBundle().getEntry("/"), "/"); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (MalformedURLException mux) {
			Activator.getLogHelper().error("Can't determine icon base.", mux); //$NON-NLS-1$
			return null;
		}
	}

	/**
	 * This allows to get the image descriptor with base URL.
	 * 
	 * @param icon
	 *            The icon path.
	 * @return The image descriptor.
	 */
	private static ImageDescriptor map(final String icon) {
		if (base != null) {
			try {
				return ImageDescriptor.createFromURL(new URL(base, icon));
			} catch (MalformedURLException mux) {
				Activator.getLogHelper().error("Can't load plug-in image.", mux); //$NON-NLS-1$
			}
		}
		return ImageDescriptor.getMissingImageDescriptor();
	}
}
