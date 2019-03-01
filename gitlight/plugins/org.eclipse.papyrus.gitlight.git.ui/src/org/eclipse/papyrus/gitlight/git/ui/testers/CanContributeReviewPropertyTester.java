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
package org.eclipse.papyrus.gitlight.git.ui.testers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.egit.core.RepositoryUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.papyrus.gitlight.git.utils.GitInstance;

/**
 * This defines the property tester to calculate if the selected contribution has been reviewed (if there is at least one modification).
 */
@SuppressWarnings("restriction")
public class CanContributeReviewPropertyTester extends PropertyTester {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {

		boolean result = false;
		if ("canContributeReview".equals(property)) { //$NON-NLS-1$
			final Ref getRef = getRef(receiver);
			if (null != getRef) {
				final Git git = GitInstance.getInstance().getGit();
				final Repository repository = git.getRepository();
				if (null != repository) {
					result = RepositoryUtil.hasChanges(repository);
				}
			}
		}

		return result;
	}

	/**
	 * This allows to get the branch depending to the object in parameter.
	 * 
	 * @param receiver
	 *            The initial object.
	 * @return The branch found or <code>null</code>.
	 */
	private Ref getRef(final Object receiver) {
		Ref result = null;

		if (null != receiver) {
			if (receiver instanceof Ref) {
				result = (Ref) receiver;
			} else if (receiver instanceof IAdaptable) {
				final Ref selectedRef = (Ref) ((IAdaptable) receiver).getAdapter(Ref.class); // Can be null
				if (null != selectedRef) {
					result = selectedRef;
				}
			} else if (receiver instanceof IStructuredSelection && ((IStructuredSelection) receiver).size() == 1) {
				final Object firstElement = ((IStructuredSelection) receiver).getFirstElement();
				if (firstElement instanceof Ref) {
					result = (Ref) firstElement;
				}
			}
		}

		return result;
	}
}
