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
package org.eclipse.papyrus.gitlight.git.ui.providers;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.gitlight.git.ui.GitIcons;
import org.eclipse.papyrus.gitlight.git.utils.GitConstants;
import org.eclipse.swt.graphics.Image;

/**
 * The label provider for the git repositories.
 */
public final class RepositoryAsStringLabelProvider extends LabelProvider {

	/**
	 * The cache for the image.
	 */
	private final ResourceManager imageCache = new LocalResourceManager(JFaceResources.getResources());

	/**
	 * Default constructor.
	 */
	public RepositoryAsStringLabelProvider() {
		// Do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(final Object element) {
		return !element.toString().isEmpty() ? imageCache.createImage(GitIcons.REPOSITORY) : null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(final Object element) {
		String repositoryString = element.toString();
		if (repositoryString.endsWith(GitConstants.GIT_FOLDER)) {
			repositoryString = repositoryString.substring(0, repositoryString.length() - GitConstants.GIT_FOLDER.length());
		}
		return repositoryString;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		imageCache.dispose();
	}

}
