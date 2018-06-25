/**
 *  Copyright (c) 2011, 2016 Atos, CEA LIST, Christian W. Damus, and others.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *    Atos - Initial API and implementation
 *    Patrick Tessier (CEA LIST) - Modification
 *    Christian W. Damus - bug 485220
 *
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.queries;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.ImageUtils;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.ui.editorsfactory.AbstractGetEditorIconQuery;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/** Return the path to the icon of the corresponding diagram */
public class GetDiagramIcon extends AbstractGetEditorIconQuery implements IJavaQuery2<Diagram, IImage> {


	public IImage evaluate(Diagram source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		
		ParameterValue parameterValue = parameterValues.getParameterValueByName("eStructuralFeature");
		EStructuralFeature eStructuralFeature = (EStructuralFeature) parameterValue.getValue();
		if ((eStructuralFeature !=null) ) {
				return null;
		}
		ViewPrototype prototype = DiagramUtils.getPrototype(source);
		return ImageUtils.wrap(prototype.getIconURI());
	}
}
