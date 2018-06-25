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

package org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.queries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.DiagramUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Layer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.model.LayersModelResource;
import org.eclipse.ui.PlatformUI;

/**
 * @author Quentin Le Menez
 *
 */
public class GetAssociatedLayers implements IJavaQuery2<Diagram, Collection<AbstractLayer>> {

	/**
	 * @see org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2#evaluate(org.eclipse.emf.ecore.EObject, org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2, org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager)
	 *
	 * @param source
	 * @param parameterValues
	 * @param facetManager
	 * @return
	 * @throws DerivedTypedElementException
	 */
	@Override
	public Collection<AbstractLayer> evaluate(Diagram source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		List<AbstractLayer> result = new ArrayList<AbstractLayer>();

		try {
			ModelSet modelSet = org.eclipse.papyrus.infra.ui.util.ServiceUtilsForHandlers.getInstance().getModelSet(null);
			// DiagramEditPart diagEP = DiagramUtil.getOpenedDiagramEditor(source, PlatformUI.getWorkbench().getActiveWorkbenchWindow()).getDiagramEditPart();
			// diagEP.getDiagramView().getDiagram().eResource().getResourceSet()
			// if (diagEP instanceof IMultiDiagramEditor) {
			// ServicesRegistry registry = ((IMultiDiagramEditor) diagEP).getServicesRegistry();
			// modelSet = registry.getService(ModelSet.class);
			// }
			ServicesRegistry registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(source);
			IMultiDiagramEditor editor = registry.getService(IMultiDiagramEditor.class);
			if (null != editor) {
				modelSet = registry.getService(ModelSet.class);
			}

			LayersModelResource model = (LayersModelResource) modelSet.getModelChecked(LayersModelResource.MODEL_ID);

			if (null == model) {
				return result;
			}
			LayersStack layerStack = model.getLayerStackApplication().getLayersStackFor(source);

			if (!(layerStack.getLayers() instanceof TopLayerOperator)) {
				return result;
			}
			TopLayerOperator topLayerOperator = (TopLayerOperator) (layerStack.getLayers());

			for (LayerExpression layerExpression : topLayerOperator.getLayers()) {
				if (layerExpression instanceof AbstractLayer) {
					result.add((AbstractLayer) layerExpression);
				}
			}

			return result;

		} catch (ServiceException e) {
			org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.Activator.log.error("Unable to find the current ModelSet", e);
		} catch (NotFoundException e) {
			org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.Activator.log.error("Unable to retrieve the LayerResource associated to the modelSet", e);
		}


		return result;
	}


}
