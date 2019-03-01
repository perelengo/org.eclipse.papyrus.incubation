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

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.papyrus.gitlight.git.utils.GitInstance;
import org.eclipse.papyrus.gitlight.git.utils.GitUtils;
import org.eclipse.uml2.uml.Element;

/**
 * The content provider for git branches.
 */
public class BranchesContentProvider implements ITreeContentProvider {

	/**
	 * The empty children definition.
	 */
	private final Object[] children = new Object[0];

	/**
	 * This allows to determinate if the git must be updated or not.
	 */
	private final boolean updateGit;

	/**
	 * Default constructor.
	 * 
	 * @param updateGit
	 *            Boolean to determinate if the git must be updated or not.
	 */
	public BranchesContentProvider(final boolean updateGit) {
		this.updateGit = updateGit;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(final Object inputElement) {
		if (inputElement instanceof Element) {
			final Repository repository = GitUtils.getRepository((Element) inputElement);
			if (null != repository) {
				final Git git = GitUtils.openGit(repository.getWorkTree().getAbsolutePath());
				if (null != git) {
					if (updateGit) {
						GitInstance.getInstance().setCurrentGitAndRootElement(git, (Element) inputElement);
					}
					final List<Ref> branches = GitUtils.getReviewBranches(git);
					return branches.toArray();
				}
			}
		} else if (inputElement instanceof Git) {
			final List<Ref> branches = GitUtils.getReviewBranches((Git) inputElement);
			return branches.toArray();
		}
		if (updateGit) {
			GitInstance.getInstance().setCurrentGitAndRootElement(null, null);
		}
		return children;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(final Object parentElement) {
		// only first level of tree
		return children;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(final Object element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(final Object element) {
		// only first level of tree
		return false;
	}

}
