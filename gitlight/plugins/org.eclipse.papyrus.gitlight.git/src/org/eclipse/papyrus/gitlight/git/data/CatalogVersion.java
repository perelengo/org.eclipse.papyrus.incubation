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
package org.eclipse.papyrus.gitlight.git.data;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * This class represent the catalog version.
 */
public class CatalogVersion {

	/** The major version number. */
	protected int major;

	/** The minor version number. */
	protected int minor;

	/** The separator for the version string. */
	private final static String SEPARATOR = "."; //$NON-NLS-1$

	/** The empty version "0.0". Equivalent to calling <code>new Version(0,0)</code>. */
	public static final CatalogVersion emptyVersion = new CatalogVersion(0, 0);

	/**
	 * Creates a new Version.
	 *
	 * @param major
	 *            The major version value (should be positive).
	 * @param minor
	 *            The minor version value (should be positive).
	 */
	public CatalogVersion(final int major, final int minor) {
		updateVersion(major, minor);
	}

	/**
	 * Creates a new Version, parsing a string value.
	 *
	 * @param value
	 *            The string representing the version.
	 */
	public CatalogVersion(final String value) throws IllegalArgumentException {
		try {
			final StringTokenizer st = new StringTokenizer(value, SEPARATOR, true);
			major = Integer.parseInt(st.nextToken());

			if (st.hasMoreTokens()) {
				st.nextToken(); // consume delimiter
				minor = Integer.parseInt(st.nextToken());

				if (st.hasMoreTokens()) {
					throw new IllegalArgumentException("invalid format"); //$NON-NLS-1$
				}
			}
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("invalid format"); //$NON-NLS-1$
		}
	}

	/**
	 * Returns the major version number.
	 *
	 * @return The major version number.
	 */
	public int getMajor() {
		return major;
	}

	/**
	 * Returns the minor version number.
	 *
	 * @return The minor version number.
	 */
	public int getMinor() {
		return minor;
	}

	/**
	 * Updates the version numbers.
	 *
	 * @param major
	 *            The new major value.
	 * @param minor
	 *            The new minor value.
	 */
	public void updateVersion(final int major, final int minor) {
		this.major = major;
		this.minor = minor;
	}

	/**
	 * Creates a version given the specific String.
	 *
	 * @param version
	 *            The string to parse.
	 * @return The version value corresponding to the String.
	 */
	public static CatalogVersion parseVersion(final String version) throws IllegalArgumentException {
		if (version == null) {
			return emptyVersion;
		}

		final String currentVersion = version.trim();
		if (currentVersion.length() == 0) {
			return emptyVersion;
		}
		return new CatalogVersion(currentVersion);
	}

	/**
	 * Returns the string corresponding to the version.
	 * 
	 * @return The string corresponding to the version.
	 */
	@Override
	public String toString() {
		return major + SEPARATOR + minor;
	}

}
