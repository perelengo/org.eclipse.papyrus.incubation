/*****************************************************************************
 * Copyright (c) 2019 CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gitlight.git.utils;

import java.io.IOException;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.gitlight.git.Activator;
import org.eclipse.papyrus.gitlight.git.data.CatalogVersion;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;

/**
 * This class allows to manage the annotation concerning the git management.
 */
public class GitAnnotationUtils {

	/**
	 * This allows to add the 'version' annotation to an element.
	 * 
	 * @param element
	 *            The element to which one add the annotation.
	 * @param version
	 *            The version to store.
	 */
	public static void addVersionAnnotation(final Element element, final CatalogVersion version) {
		final Resource resource = element.eResource();
		if (null != resource) {
			final EAnnotation eAnnotation = UML2Util.getEAnnotation(element, GitConstants.VERSION_ANNOTATION, true);
			eAnnotation.getDetails().put(GitConstants.VERSION_DETAILS_NAME, version.toString());

			try {
				resource.save(null);
			} catch (IOException e) {
				Activator.getLogHelper().error("Error during save of UML file", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * This allows to get the 'version' annotation from the element.
	 * 
	 * @param element
	 *            The element to check.
	 * @return The 'version' annotation value or <code>null</code>.
	 */
	public static CatalogVersion getVersionAnnotation(final Element element) {
		CatalogVersion result = CatalogVersion.emptyVersion;
		if (null != element) {
			final EAnnotation eAnnotation = UML2Util.getEAnnotation(element, GitConstants.VERSION_ANNOTATION, false);
			if (null != eAnnotation && eAnnotation.getDetails().containsKey(GitConstants.VERSION_DETAILS_NAME)) {
				result = CatalogVersion.parseVersion(eAnnotation.getDetails().get(GitConstants.VERSION_DETAILS_NAME));
			}
		}

		return result;
	}

}
