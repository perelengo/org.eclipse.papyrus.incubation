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

package org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl.custom;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl.LayerOperatorConfigImpl;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.InstanciationException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;

/**
 * @author QL238289
 *
 */
public class CustomLayerOperatorConfigImpl extends LayerOperatorConfigImpl {

	/**
	 * Create the requested descriptor
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl.InstanciableElementImpl#createLayersOperatorDescriptor()
	 *
	 * @return
	 * @throws NotFoundException
	 */
	@Override
	public LayerOperatorDescriptor createLayersOperatorDescriptor() throws InstanciationException {

		// Create instance of layer
		EClassifier classifier = LayersPackage.eINSTANCE.getEClassifier(getClassname());
		if (classifier == null) {
			throw new InstanciationException("Can't create LayerOperatorDescriptor for name '" + getClassname() + "'");
		}
		LayerOperatorDescriptor res = (LayerOperatorDescriptor) LayersFactory.eINSTANCE.create((EClass) classifier);

		// Set values
		res.setName(getName());

		return res;
	}
}
