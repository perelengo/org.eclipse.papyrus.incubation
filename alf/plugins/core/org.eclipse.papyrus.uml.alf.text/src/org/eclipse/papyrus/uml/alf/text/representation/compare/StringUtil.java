/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Tatibouet
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.text.representation.compare;

public class StringUtil {

	public static final char CHAR_EOL = '\n';
	public static final String EOL = "\n";

	/**
	 * Return true if the given string is not negligible to be used in a comparison
	 * 
	 * @param str
	 *            - the assessed string
	 * @return negligible
	 */
	public static final boolean isNegligible(String str) {
		boolean negligible = true;
		if (!str.isEmpty()) {
			int i = 0;
			while (negligible && i < str.length()) {
				if (str.charAt(i) != '\n'
						&& str.charAt(i) != '\r'
						&& str.charAt(i) != ' '
						&& str.charAt(i) != '\t') {
					negligible = false;
				}
				i++;
			}
		}
		return negligible;
	}
}
