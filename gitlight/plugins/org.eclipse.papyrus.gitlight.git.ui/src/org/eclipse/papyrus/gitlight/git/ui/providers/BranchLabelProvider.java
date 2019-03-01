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
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.papyrus.gitlight.git.ui.GitIcons;
import org.eclipse.papyrus.gitlight.git.utils.GitConstants;
import org.eclipse.papyrus.gitlight.git.utils.GitUtils;
import org.eclipse.swt.graphics.Image;

/**
 * The label provider for git branches.
 */
public class BranchLabelProvider extends LabelProvider {

	/**
	 * The cache for the image.
	 */
	private final ResourceManager imageCache = new LocalResourceManager(JFaceResources.getResources());

	/**
	 * The git.
	 */
	private final Git git;

	/**
	 * Default constructor.
	 * 
	 * @param git
	 *            The git.
	 */
	public BranchLabelProvider(final Git git) {
		this.git = git;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(final Object element) {
		if (element instanceof Ref) {
			return imageCache.createImage(GitIcons.BRANCH);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(final Object element) {
		if (element instanceof Ref) {
			final Ref branch = (Ref) element;
			final StringBuilder constructName = new StringBuilder();

			// First manage the name
			final String name = branch.getName();
			if (name.contains(GitConstants.CONTRIBUTION_BRANCH_PREFIX) && name.length() > (GitConstants.CONTRIBUTION_BRANCH_PREFIX.length() + 18)) {
				// 18 is the number of character for the unique identifier generated from the date (it is always the same size)
				constructName.append(name.substring(name.indexOf(GitConstants.CONTRIBUTION_BRANCH_PREFIX) + GitConstants.CONTRIBUTION_BRANCH_PREFIX.length() + 18));
			} else {
				constructName.append(name);
			}

			// Second (in parenthesis), manage a short message and the committer
			if (null != git && constructName.length() > 0) {
				final RevCommit lastCommit = GitUtils.getLastCommitOfBranch(git, branch);

				// Get the message (X char max)
				String shortMessage = lastCommit.getShortMessage();
				if (shortMessage.length() > 60) {
					shortMessage = shortMessage.substring(0, 56);
					shortMessage += "..."; //$NON-NLS-1$
				}

				// Get the author
				String author = null;
				if (lastCommit.getFullMessage().contains(Constants.SIGNED_OFF_BY_TAG)) {
					try {
						final String subSignedOff = lastCommit.getFullMessage().substring(lastCommit.getFullMessage().indexOf(Constants.SIGNED_OFF_BY_TAG) + Constants.SIGNED_OFF_BY_TAG.length());
						author = subSignedOff.contains("\n") ? subSignedOff.substring(0, subSignedOff.indexOf("\n")) : subSignedOff; //$NON-NLS-1$ //$NON-NLS-2$
					} catch (Exception e) {
						// Do nothing
					}
				}
				if (null == author || author.isEmpty()) {
					author = lastCommit.getAuthorIdent().getName();
				}

				if (!shortMessage.isEmpty() && !author.isEmpty()) {
					constructName.append("("); //$NON-NLS-1$
					if (!shortMessage.isEmpty()) {
						constructName.append("\""); //$NON-NLS-1$
						constructName.append(shortMessage);
						constructName.append("\", "); //$NON-NLS-1$
					}
					if (!author.isEmpty()) {
						constructName.append("by "); //$NON-NLS-1$
						constructName.append(author);
					}
					constructName.append(")"); //$NON-NLS-1$
				}
			}

			return constructName.toString();
		}
		return "No branch available"; //$NON-NLS-1$
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
