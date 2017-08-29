/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.wizard;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.dsml.validation.generator.xtend.Generate;

/**
 * Main entry point of the 'UML To Java' generation module.
 *
 */
public class ClassesGenerator {

	/**
	 * The profile for which to generate code.
	 */
	private Resource resource;

	/**
	 * The output folder.
	 */
	private IProject project;

	/**
	 * Constructor.
	 *
	 * @param modelURI
	 *            is the URI of the model.
	 * @param targetFolder
	 *            is the output folder
	 * @param arguments
	 *            are the other arguments
	 * @throws IOException
	 *             Thrown when the output cannot be saved.
	 * @generated
	 */
	public ClassesGenerator(Resource resource, IProject project) {
		this.resource = resource;
		this.project = project;
	}

	/**
	 * execute the generation
	 *
	 * @param monitor
	 * @throws IOException
	 */
	public void doGenerate(IProgressMonitor monitor) throws IOException {
		if (!project.getLocation().toFile().exists()) {
			project.getLocation().toFile().mkdirs();
		}

		monitor.worked(1);

		Generate.generateClientSelector(resource, project, monitor);
		Generate.generateConstraints(resource, project, monitor);
	}
}
