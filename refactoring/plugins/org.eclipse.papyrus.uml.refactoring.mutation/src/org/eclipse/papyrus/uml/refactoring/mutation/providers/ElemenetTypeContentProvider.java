/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.refactoring.mutation.providers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * Provider used to get the possible types for the mutated element
 * 
 */
public class ElemenetTypeContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		// Map<IElementType, EObject> elementsToDisaplay = new HashMap<>();
		@SuppressWarnings("unchecked")
		HashMap<IElementType, EObject> inputElements = (HashMap<IElementType, EObject>) inputElement;
		// for (IElementType elementType : inputElements) {
		// if (!(elementType instanceof IHintedType)) {
		// continue;
		// }
		//
		// elementsToDisaplay.add(elementType);
		// }

		return inputElements.entrySet().toArray();
	}

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return null;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return false;
	}

}
