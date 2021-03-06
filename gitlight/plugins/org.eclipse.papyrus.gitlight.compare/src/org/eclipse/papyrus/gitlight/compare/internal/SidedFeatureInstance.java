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

import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Instance of a feature for an EObject on a side of a comparison.
 */
class SidedFeatureInstance extends FeatureInstance {
	/** The side. */
	private final DifferenceSource side;

	/**
	 * Constructor.
	 * 
	 * @param eObject
	 *            The EObject
	 * @param feature
	 *            The feature
	 * @param side
	 *            The side
	 */
	SidedFeatureInstance(EObject eObject, EStructuralFeature feature, DifferenceSource side) {
		super(eObject, feature);
		this.side = side;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		// CHECKSTYLE:OFF Code generated by JDT
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		// CHECKSTYLE:ON
		return result;
	}

	// CHECKSTYLE:OFF Code generated by JDT
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SidedFeatureInstance other = (SidedFeatureInstance)obj;
		if (side != other.side) {
			return false;
		}
		return true;
		// CHECKSTYLE:ON
	}

	@Override
	public String toString() {
		return super.toString() + '-' + side.getName(); //$NON-NLS-1$
	}
}
