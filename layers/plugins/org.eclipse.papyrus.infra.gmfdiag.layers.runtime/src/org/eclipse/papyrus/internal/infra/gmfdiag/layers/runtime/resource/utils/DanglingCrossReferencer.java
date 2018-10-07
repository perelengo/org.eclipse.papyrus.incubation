/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.resource.utils;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author QL238289
 *
 */
public class DanglingCrossReferencer extends EcoreUtil.CrossReferencer {
	public DanglingCrossReferencer(Resource resource) {
		super(resource);
	}

	@Override
	protected boolean crossReference(EObject eObject, EReference eReference, EObject crossReferencedEObject) {
		return crossReferencedEObject.eResource() == null && !crossReferencedEObject.eIsProxy() && !eReference.isTransient();
	}

	public Map<EObject, Collection<EStructuralFeature.Setting>> findDanglingCrossReferences() {
		crossReference();
		done();
		return this;
	}
}
