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
package org.eclipse.papyrus.gitlight.compare.ui.internal.structuremergeviewer.filters;

import com.google.common.base.Predicate;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceState;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.AbstractDifferenceFilter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.tree.TreeNode;

/**
 * The filter to hide managed differences.
 */
public class ManagedDiffsFilter extends AbstractDifferenceFilter {

	/**
	 * The predicate provided by this filter when it is selected.
	 */
	private static final Predicate<EObject> SELECTED_PREDICATE = new Predicate<EObject>() {
		public boolean apply(EObject input) {
			EObject data = input;
			if (input instanceof TreeNode) {
				data = ((TreeNode) input).getData();
			}

			Diff diff = null;
			if (data instanceof Diff) {
				diff = (Diff) data;
			}

			return null != diff ? !diff.getState().equals(DifferenceState.UNRESOLVED) : false;
		}
	};

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.AbstractDifferenceFilter#getPredicateWhenSelected()
	 */
	@Override
	public Predicate<? super EObject> getPredicateWhenSelected() {
		return SELECTED_PREDICATE;
	}
}
