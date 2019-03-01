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

import org.eclipse.jgit.api.Git;
import org.eclipse.uml2.uml.Element;

/**
 * This singleton allows to store the current git and the current root element.
 * This allows to simplify the management.
 */
public class GitInstance {

	/**
	 * The singleton instance.
	 */
	private static GitInstance instance;

	/**
	 * The current git to manage.
	 */
	private Git git;

	/**
	 * The current root element.
	 */
	private Element rootElement;

	/**
	 * Private constructor to avoid external initialization.
	 */
	private GitInstance() {
		// Do nothing
	}

	/**
	 * Get the instance.
	 * 
	 * @return The instance.
	 */
	public static GitInstance getInstance() {
		if (null == instance) {
			instance = new GitInstance();
		}
		return instance;
	}

	/**
	 * This allows to get the current git.
	 * 
	 * @return The current git.
	 */
	public Git getGit() {
		return git;
	}

	/**
	 * This allows to get the root element.
	 * 
	 * @return The current root element.
	 */
	public Element getRootElement() {
		return rootElement;
	}

	/**
	 * This allows to set the current git and root element.
	 * 
	 * @param git
	 *            The current git to store.
	 * @param rootElement
	 *            The current root element.
	 */
	public void setCurrentGitAndRootElement(final Git git, final Element rootElement) {
		this.git = git;
		this.rootElement = rootElement;
	}

}
