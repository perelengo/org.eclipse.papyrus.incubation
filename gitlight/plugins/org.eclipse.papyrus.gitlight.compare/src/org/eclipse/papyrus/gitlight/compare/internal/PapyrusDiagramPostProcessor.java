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

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;

/**
 * Post-processor used to manage interactions between papyrus diagrams (*.notation files) and the related UML
 * models (*.uml files).
 */
public class PapyrusDiagramPostProcessor implements IPostProcessor {

	/**
	 * {@inheritDoc}
	 */
	public void postMatch(Comparison comparison, Monitor monitor) {
		// Nothing to do here
	}

	/**
	 * {@inheritDoc}
	 */
	public void postDiff(Comparison comparison, Monitor monitor) {
		// Nothing to do here
	}

	/**
	 * {@inheritDoc}
	 */
	public void postRequirements(Comparison comparison, Monitor monitor) {
		// Nothing to do here
	}

	/**
	 * {@inheritDoc}
	 */
	public void postEquivalences(Comparison comparison, Monitor monitor) {
		// Nothing to do here
	}

	/**
	 * {@inheritDoc}
	 */
	public void postConflicts(Comparison comparison, Monitor monitor) {
		// Nothing to do here
	}

	/**
	 * creates links between notation and UML changes when they should be linked.
	 * 
	 * @param comparison
	 *            The comparison
	 * @param monitor
	 *            The progress monitor
	 */
	public void postComparison(Comparison comparison, Monitor monitor) {
		if (monitor == null || !monitor.isCanceled()) {
			new PapyrusDiagramPostComparison(comparison).run();
		}
	}
}
