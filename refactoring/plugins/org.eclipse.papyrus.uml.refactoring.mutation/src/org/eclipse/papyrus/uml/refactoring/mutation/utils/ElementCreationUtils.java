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
package org.eclipse.papyrus.uml.refactoring.mutation.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Relationship;

/**
 * Utils methods used to create new elements from the old elements when the refactoring occurs
 * 
 */
public class ElementCreationUtils {

	/**
	 * Create a new UML element.
	 * 
	 * @param elementType
	 *            The UML elementType the new element will be instance of.
	 * @param container
	 *            Represents the container of the new element to create.
	 * @param elementToMutate
	 * @return The new UML element
	 */
	public static CreateElementRequest createElementRequest(IElementType elementType, EObject container, EObject elementToMutate, ModelSet fModelSet) {

		TransactionalEditingDomain editingDomain = fModelSet.getTransactionalEditingDomain();
		if (elementToMutate instanceof Relationship) {
			Element relationshipSource = null;
			Element relationshipTarget = null;
			if (elementToMutate instanceof DirectedRelationship) {
				relationshipSource = ((DirectedRelationship) elementToMutate).getSources().get(0);
				relationshipTarget = ((DirectedRelationship) elementToMutate).getTargets().get(0);
			} else {
				relationshipSource = ((Relationship) elementToMutate).getRelatedElements().get(1);
				relationshipTarget = ((Relationship) elementToMutate).getRelatedElements().get(0);
			}

			return new CreateRelationshipRequest(editingDomain, container, relationshipSource, relationshipTarget, elementType);

		} else {

			return new CreateElementRequest(editingDomain, container, elementType);
		}

	}
}
