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
package org.eclipse.papyrus.gitlight.compare.internal;

import org.eclipse.emf.compare.Diff;

/**
 * A Diff handler performs some treatment on a given {@link Diff}.
 */
public interface IDiffHandler {

	/**
	 * Handles the given diff.
	 * 
	 * @param diff
	 *            The diff ta handle.
	 */
	void handle(Diff diff);
}
