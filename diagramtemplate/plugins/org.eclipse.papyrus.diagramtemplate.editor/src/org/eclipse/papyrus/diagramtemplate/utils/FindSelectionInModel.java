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

package org.eclipse.papyrus.diagramtemplate.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.diagramtemplate.AbstractSelection;
import org.eclipse.papyrus.diagramtemplate.editor.Activator;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.NamedElement;

/**
 * @author Quentin Le Menez
 *
 */
public class FindSelectionInModel {

	// private static FindSelectionInModel INSTANCE;

	// private static Map<ModelSet, List<EObject>> parsedElements;

	private FindSelectionInModel() {
		// singleton
	}

	// public static FindSelectionInModel getInstance() {
	// if (INSTANCE == null) {
	// INSTANCE = new FindSelectionInModel();
	// parsedElements = new HashMap<>();
	// }
	// return INSTANCE;
	// }

	public static EObject findSelectionInModel(ModelSet modelSet, AbstractSelection selection) {
		return findSelectionInModel(modelSet, selection.getElement());
	}


	public static EObject findSelectionInModel(ModelSet modelSet, EObject selection) {
		try {
			// if (!parsedElements.keySet().contains(modelSet)) {
			UmlModel umlModel = (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);
			List<EObject> containedElements = new ArrayList<>();
			umlModel.lookupRoot().eAllContents().forEachRemaining(containedElements::add);
			// parsedElements.put(modelSet, containedElements);
			// }

			// return loopOnContent(parsedElements.get(modelSet), selection);
			return loopOnContent(containedElements, selection);

		} catch (NotFoundException e) {
			Activator.log.error(e);
		}

		return null;

	}


	protected static EObject loopOnContent(List<EObject> containedElements, EObject selectionElement) {

		for (EObject eObject : containedElements) {
			if (eObject instanceof NamedElement && selectionElement instanceof NamedElement) {
				String eObjectURIf = eObject.eResource().getURIFragment(eObject);
				String selectionElementURIf = selectionElement.eResource().getURIFragment(selectionElement);

				if (eObjectURIf.equals(selectionElementURIf)) {
					return eObject;
				}
			}
		}

		return null;
	}


	// public void clear() {
	// INSTANCE = null;
	// parsedElements.clear();
	// }

}
