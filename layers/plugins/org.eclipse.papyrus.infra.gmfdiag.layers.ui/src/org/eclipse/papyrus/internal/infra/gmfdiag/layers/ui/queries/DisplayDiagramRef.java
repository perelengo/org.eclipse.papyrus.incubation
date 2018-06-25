/**
 *  Copyright (c) 2011 Atos, Christian W. Damus, and others.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *    Atos - Initial API and implementation
 *    Christian W. Damus - bug 485220
 *
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.queries;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;

public class DisplayDiagramRef implements IJavaQuery2<EObject, Boolean> {

	/**
	 * Return true if the element is a Diagram Container and the Ereference is diagrams
	 */

	public Boolean evaluate(EObject source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		ParameterValue parameterValue = parameterValues.getParameterValueByName("eStructuralFeature");
		EStructuralFeature eStructuralFeature = (EStructuralFeature) parameterValue.getValue();
		if ((eStructuralFeature instanceof FacetReference) && ("diagrams".equals((eStructuralFeature).getName()))) {

			ResourceSet resourceSet = EMFHelper.getResourceSet(source);

			if (resourceSet != null) {
				for (Diagram diagram : NotationUtils.getAllNotations(resourceSet, Diagram.class)) {
					if (EcoreUtil.equals(DiagramUtils.getOwner(diagram), source)) {
						return true;
					}
				}
			}
			return false;
		}
		return true;
	}
}