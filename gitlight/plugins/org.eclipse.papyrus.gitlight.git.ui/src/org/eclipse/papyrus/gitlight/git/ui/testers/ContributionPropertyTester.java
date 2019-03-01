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
import org.eclipse.core.resources.IFile;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.papyrus.gitlight.git.utils.PapyrusFileUtils;
import org.eclipse.papyrus.gitlight.git.utils.GitUtils;

/**
 * This defines the property tester to calculate if the contribution menus will be displayed.
 */
public class ContributionPropertyTester extends PropertyTester {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {

		boolean result = false;

		// We have to check that branches are available to do update
		if ("canUpdateContribution".equals(property)) { //$NON-NLS-1$
			final IFile file = PapyrusFileUtils.getFile(receiver);
			if (null != file) {
				final Repository repository = GitUtils.getRepository(file.getProject());
				final Git git = GitUtils.openGit(repository.getWorkTree().getAbsolutePath());
				if (null != git) {
					result = !GitUtils.getReviewBranches(git).isEmpty();
				}
			}
		}

		final boolean expected = expectedValue instanceof Boolean ? ((Boolean) expectedValue).booleanValue() : true;
		return expected == result;
	}
}
