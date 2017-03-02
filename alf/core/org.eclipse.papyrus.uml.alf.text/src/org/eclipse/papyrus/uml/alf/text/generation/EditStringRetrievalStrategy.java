/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Jeremie Tatibouet (CEA LIST)
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.text.generation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.uml.alf.MappingError;
import org.eclipse.papyrus.uml.alf.UMLMapper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;

public abstract class EditStringRetrievalStrategy {

	/**
	 * Provide a resource containing the ALF model corresponding to the given UML element
	 * 
	 * @param UMLelement
	 *            - the element from which the ALF model is computed
	 * @return alfModelResource - the resource containing the ALF model
	 */
	protected Resource getAlfModel(NamedElement UMLelement) {
		UMLMapper mapper = new UMLMapper();
		Resource alfModelResource = null;
		try {
			if (UMLelement instanceof Property) {
				alfModelResource = mapper.map(((Property) UMLelement).getNamespace());
			} else {
				alfModelResource = mapper.map(UMLelement);
			}
		} catch (MappingError e) {
			e.printStackTrace();
		}
		return alfModelResource;
	}

	public abstract String getEditString(Element element);
}
