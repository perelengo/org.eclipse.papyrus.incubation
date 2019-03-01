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
package org.eclipse.papyrus.gitlight.compare.ui.dependency;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.ide.ui.dependency.IDependencyProvider;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.papyrus.gitlight.compare.util.ModelExtensionUtil;

/**
 * A client of the EMF Compare Dependency extension point providing a lightweight integration of the Papyrus
 * ModelSet approach with the EMF Model Resolution Strategy.
 */
public class PapyrusDependencyProvider implements IDependencyProvider {

	/**
	 * File extensions registered in Papyrus.
	 */
	private List<String> fileExtensions;

	/**
	 * Constructs and initializes the PapyrusDependencyIdentifier.
	 */
	public PapyrusDependencyProvider() {
		fileExtensions = new ArrayList<String>(ModelExtensionUtil.getRegisteredFileExtensions());
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean apply(URI uri) {
		return fileExtensions.contains(uri.fileExtension());
	}

	/**
	 * {@inheritDoc} Checks the Papyrus model extension point and tries to determine all dependencies from the
	 * registered information.
	 */
	public Set<URI> getDependencies(URI uri, URIConverter uriConverter) {
		final Set<URI> dependencies = new LinkedHashSet<URI>();
		final URI baseURI = uri.trimFileExtension();
		for (String fileExtension : fileExtensions) {
			final URI dependencyURI = baseURI.appendFileExtension(fileExtension);
			if (uriConverter.exists(dependencyURI, null)) {
				dependencies.add(dependencyURI);
			}
		}
		return dependencies;
	}
}
