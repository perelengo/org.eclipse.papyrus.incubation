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
package org.eclipse.papyrus.gitlight.compare.uml2.edit.internal.decorator;

import java.util.Map;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.adapterfactory.context.AbstractContextTester;
import org.eclipse.papyrus.gitlight.compare.ui.internal.context.PapyrusContextUtil;

/**
 * Context Tester for a Papyrus comparison.
 * 
 * @see PapyrusContextUtil#isPapyrusContext(Comparison)
 * @author <a href="mailto:mfleck@eclipsesource.com">Martin Fleck</a>
 */
public class PapyrusItemProviderContextTester extends AbstractContextTester {

	/**
	 * {@inheritDoc}
	 */
	public boolean apply(Map<Object, Object> context) {
		Comparison comparison = getComparison(context);
		return comparison != null && PapyrusContextUtil.isPapyrusContext(comparison);
	}
}
