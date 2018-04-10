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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;

/**
 * @author Quentin Le Menez
 *
 */
public class ModelUtils {

	// private static ModelUtils INSTANCE;

	private ModelUtils() {
		// singleton
	}

	// public static ModelUtils getInstance() {
	// if (INSTANCE == null) {
	// return new ModelUtils();
	// }
	// return INSTANCE;
	// }

	/**
	 * Utils method that determine whether an element is stereotypedBy a certain stereotype qualiedName
	 *
	 * @param element
	 *            the element to test
	 * @param stereotypedBy
	 *            the qulifiedName of the stereotype to match
	 * @return
	 * 		true if matches false else.
	 */
	public static boolean matchStereotypedBy(EObject element, String stereotypedBy) {
		if (element instanceof Element) {
			// Read stereotypedBy
			stereotypedBy = stereotypedBy.replaceAll(" ", ""); //$NON-NLS-1$ //$NON-NLS-2$
			String[] stereotypes = stereotypedBy.split(","); //$NON-NLS-1$

			boolean matchStereotypes = true;
			for (String stereo : stereotypes) {
				if (stereo != null && stereo.length() > 0) {
					if (((Element) element).getAppliedStereotype(stereo) != null) {
						matchStereotypes = true;
					} else {
						matchStereotypes = false;
						break;
					}
				}
			}

			return matchStereotypes;
		}

		return false;
	}

}
