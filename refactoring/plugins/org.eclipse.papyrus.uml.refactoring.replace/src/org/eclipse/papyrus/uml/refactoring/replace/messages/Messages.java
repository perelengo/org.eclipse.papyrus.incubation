/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.refactoring.replace.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.refactoring.replace.messages.messages"; //$NON-NLS-1$

	public static String REPLACEREFACTORING_PAGELABEL;
	public static String REPLACEREFACTORING_INITALTEXT;
	public static String REPLACEREFACTORING_NEWTEXT;
	public static String REPLACEREFACTORING_INITIALTEXT_LABEL;
	public static String REPLACEREFACTORING_CASE;
	public static String REPLACEREFACTORING_NEWTEXT_LABEL;
	public static String REPLACEREFACTORING_NAMESCOPE;
	public static String REPLACEREFACTORING_MODELSCOPE;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
