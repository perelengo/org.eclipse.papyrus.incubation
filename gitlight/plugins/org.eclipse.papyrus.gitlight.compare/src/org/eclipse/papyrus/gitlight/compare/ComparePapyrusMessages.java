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
package org.eclipse.papyrus.gitlight.compare;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Utility class to access externalized Strings for this bundle.
 * 
 * @author <a href="mailto:laurent.delaigue@obeo.fr">Laurent Delaigue</a>
 */
public final class ComparePapyrusMessages {
	/** Fully qualified path to the properties file in which to seek the keys. */
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.gitlight.compare.compare_papyrus_messages"; //$NON-NLS-1$

	/** Contains the locale specific {@link String}s needed by this plug-in. */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	/**
	 * Utility classes don't need to (and shouldn't) be instantiated.
	 */
	private ComparePapyrusMessages() {
		// prevents instantiation
	}

	/**
	 * Returns a specified {@link String} from the resource bundle.
	 * 
	 * @param key
	 *            Key of the String we seek.
	 * @return The String from the resource bundle associated with <code>key</code>.
	 */
	public static String getString(String key) {
		// Pass through MessageFormat to be consistent in the handling of special chars such as the apostrophe
		return MessageFormat.format(internalGetString(key), new Object[] {});
	}

	/**
	 * Returns a String from the resource bundle bound with the given arguments.
	 * 
	 * @param key
	 *            Key of the String we seek.
	 * @param arguments
	 *            Arguments for the String formatting.
	 * @return formatted {@link String}.
	 * @see MessageFormat#format(String, Object[])
	 */
	public static String getString(String key, Object... arguments) {
		if (arguments == null) {
			return getString(key);
		}
		return MessageFormat.format(internalGetString(key), arguments);
	}

	/**
	 * This will return an unformatted String from the resource bundle.
	 * 
	 * @param key
	 *            Key of the String we seek.
	 * @return An unformatted String from the bundle.
	 */
	private static String internalGetString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!'; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
