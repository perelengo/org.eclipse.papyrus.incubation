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
package org.eclipse.papyrus.gitlight.compare.ui.contentmergeviewer.facet;

import com.google.common.base.Function;

import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;

/**
 * Util class for handling Papyrus Facet.
 */
public final class FacetUtil {

	/**
	 * Un-Wraps the Objects returned by the Papyrus Facet mechanism.
	 */
	public static final Function<Object, Object> UN_WRAP = new Function<Object, Object>() {
		public Object apply(Object input) {
			if (EObjectTreeElement.class.isInstance(input)) {
				return EObjectTreeElement.class.cast(input).getEObject();
			}
			return input;
		}

	};

	/**
	 * Private Constructor for Util classes.
	 */
	private FacetUtil() {

	}
}
