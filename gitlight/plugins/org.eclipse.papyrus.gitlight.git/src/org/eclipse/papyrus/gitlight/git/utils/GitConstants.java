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

import org.eclipse.jgit.lib.Constants;

/**
 * This allows to define the constants needed for the git management.
 */
public interface GitConstants {

	/**
	 * The 'version' annotation key.
	 */
	public static final String VERSION_ANNOTATION = "version"; //$NON-NLS-1$

	/**
	 * The 'version' details name key.
	 */
	public static final String VERSION_DETAILS_NAME = "current"; //$NON-NLS-1$

	/**
	 * The master repository path.
	 */
	public static final String MASTER_REPOSITORY_PATH = Constants.DEFAULT_REMOTE_NAME + "/" + Constants.MASTER; //$NON-NLS-1$

	/**
	 * The contribution branch name prefix.
	 */
	public static final String CONTRIBUTION_BRANCH_PREFIX = "Review_"; //$NON-NLS-1$

	/**
	 * The initial commit message.
	 */
	public static final String INITIAL_COMMIT_MESSAGE = "Initial commit"; //$NON-NLS-1$
	
	/**
	 * The git folder.
	 */
	public static final String GIT_FOLDER = "\\" + Constants.DOT_GIT; //$NON-NLS-1$
	
	/**
	 * The change id.
	 */
	public static final String CHANGE_ID = "Change-Id: I0000000000000000000000000000000000000000"; //$NON-NLS-1$
}
