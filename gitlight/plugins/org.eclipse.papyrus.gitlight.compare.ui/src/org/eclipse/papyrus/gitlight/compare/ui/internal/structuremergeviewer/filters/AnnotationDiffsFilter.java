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

import org.eclipse.emf.common.util.BasicEMap.Entry;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.internal.spec.ReferenceChangeSpec;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.AbstractDifferenceFilter;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.tree.TreeNode;
import org.eclipse.papyrus.gitlight.git.utils.GitConstants;

/**
 * The filter to hide papyrus annotations differences.
 */
@SuppressWarnings("restriction")
public class AnnotationDiffsFilter extends AbstractDifferenceFilter {

	/**
	 * The predicate provided by this filter when it is selected.
	 */
	private static final Predicate<EObject> SELECTED_PREDICATE = new Predicate<EObject>() {
		public boolean apply(final EObject input) {
			EObject data = input;
			if (input instanceof TreeNode) {
				data = ((TreeNode) input).getData();
			}

			Diff diff = null;
			if (data instanceof Diff) {
				diff = (Diff) data;
			}

			boolean isPapyrusAnnotation = false;
			if (null != diff && null != diff.getMatch()) {
				EObject eObject = diff.getMatch().getLeft();
				if (null == eObject) {
					eObject = diff.getMatch().getRight();
				}

				// Remove the EAnnotation if this is a papyrus EAnnotation
				if (eObject instanceof EAnnotation) {
					isPapyrusAnnotation = ((EAnnotation) eObject).getSource().equals(GitConstants.VERSION_ANNOTATION);
					// Remove too if this is a detail entry of papyrus EAnnotation
				} else if (eObject instanceof Entry<?, ?> && eObject.eContainer() instanceof EAnnotation) {
					final EAnnotation parentAnnotation = (EAnnotation) eObject.eContainer();
					isPapyrusAnnotation = parentAnnotation.getSource().equals(GitConstants.VERSION_ANNOTATION);
				}

				// In some cases, the managed element is the parent byt the real value is the EAnnotation, we need to check it
				if (!isPapyrusAnnotation && diff instanceof ReferenceChangeSpec) {
					final ReferenceChangeSpec rcs = (ReferenceChangeSpec) diff;
					final EObject value = rcs.getValue();

					if (value instanceof EAnnotation) {
						isPapyrusAnnotation = ((EAnnotation) value).getSource().equals(GitConstants.VERSION_ANNOTATION);
					}
				}
			}

			return isPapyrusAnnotation;
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
