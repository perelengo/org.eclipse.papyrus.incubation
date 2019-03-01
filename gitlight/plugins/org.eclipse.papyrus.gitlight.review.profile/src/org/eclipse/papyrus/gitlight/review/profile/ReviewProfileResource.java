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
package org.eclipse.papyrus.gitlight.review.profile;

/**
 * Some needed constants depending to the profile.
 */
public class ReviewProfileResource {

	/**
	 * The path map.
	 */
	public static final String PROFILES_PATHMAP = "pathmap://REVIEWPROFILE/"; //$NON-NLS-1$

	/**
	 * The profile path.
	 */
	public static final String PROFILE_PATH = PROFILES_PATHMAP + "reviewprofile.uml"; //$NON-NLS-1$

	/**
	 * the profile URI.
	 */
	public static final String PROFILE_URI = "http://www.eclipse.org/papyrus/reviewprofile/0.1.0"; //$NON-NLS-1$
}
