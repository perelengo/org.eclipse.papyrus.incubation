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
package org.eclipse.papyrus.gitlight.compare.ui.contentmergeviewer.provider;

import static org.eclipse.papyrus.gitlight.compare.ui.internal.context.PapyrusContextUtil.isPapyrusContext;

import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.adapterfactory.context.AbstractContextTester;

/**
 * Indicates whether we are in a Papyrus context.
 */
public class PapyrusContextTester extends AbstractContextTester {

	/**
	 * A weak cache of comparisons that have been already been tested.
	 */
	private final Map<Comparison, Boolean> cache = new WeakHashMap<>();

	/**
	 * {@inheritDoc}
	 */
	public boolean apply(Map<Object, Object> context) {
		Comparison comparison = getComparison(context);
		if (comparison != null) {
			Boolean result = cache.get(comparison);
			if (result == null) {
				result = Boolean.valueOf(isPapyrusContext(comparison));
				cache.put(comparison, result);
			}
			return result.booleanValue();
		}
		return false;
	}

}
