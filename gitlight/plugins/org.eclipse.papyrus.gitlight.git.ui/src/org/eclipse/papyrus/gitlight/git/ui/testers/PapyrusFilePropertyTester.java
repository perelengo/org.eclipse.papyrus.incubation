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
import org.eclipse.papyrus.gitlight.git.utils.PapyrusFileUtils;

/**
 * The papyrus file property tester.
 */
public class PapyrusFilePropertyTester extends org.eclipse.core.expressions.PropertyTester {

	/**
	 * [{@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		boolean result = false;
		if ("isEnabled".equals(property)) { //$NON-NLS-1$
			final IFile file = PapyrusFileUtils.getFile(receiver);
			result = file != null;
		}
		return result;

	}

}
