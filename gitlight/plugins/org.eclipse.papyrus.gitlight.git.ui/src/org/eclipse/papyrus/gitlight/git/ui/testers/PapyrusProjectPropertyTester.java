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

import org.eclipse.core.resources.IFile;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.papyrus.gitlight.git.utils.PapyrusFileUtils;
import org.eclipse.papyrus.gitlight.git.utils.GitUtils;
import org.eclipse.uml2.uml.Element;

/**
 * The property tester to test if a project is already shared into a git.
 */
public class PapyrusProjectPropertyTester extends org.eclipse.core.expressions.PropertyTester {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		boolean result = false;
		if ("isSharedProject".equals(property)) { //$NON-NLS-1$
			final IFile file = PapyrusFileUtils.getFile(receiver);
			if (file != null) {
				final Element root = (Element) PapyrusFileUtils.getRootModel(file);
				final Repository repository = GitUtils.getRepository(root);
				result = root instanceof Element && null != repository;
			}
		} else if ("canCheckoutMaster".equals(property)) { //$NON-NLS-1$
			final IFile file = PapyrusFileUtils.getFile(receiver);
			if (file != null) {
				final Element root = (Element) PapyrusFileUtils.getRootModel(file);
				final Repository repository = GitUtils.getRepository(root);
				if (null != repository) {
					final Git git = GitUtils.openGit(repository.getWorkTree().getAbsolutePath());
					final Ref currentBranch = GitUtils.getCurrentBranch(git);
					result = !currentBranch.getName().endsWith(Constants.MASTER) || GitUtils.isCurrentBranchIsUpToDate(git);
				}
			}
		}
		final boolean expected = expectedValue instanceof Boolean ? ((Boolean) expectedValue).booleanValue() : true;
		return expected == result;
	}

}
