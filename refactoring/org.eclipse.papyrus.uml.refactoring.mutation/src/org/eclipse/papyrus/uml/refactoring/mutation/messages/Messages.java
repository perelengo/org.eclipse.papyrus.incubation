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
package org.eclipse.papyrus.uml.refactoring.mutation.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.refactoring.Mutation.messages.messages"; //$NON-NLS-1$

	public static String MUTATIONREFACTORING_PAGETITLE;
	public static String MUTATIONREFACTORING_SELECTIONLABEL;
	public static String MUTATIONREFACTORING_SELECTIONWARNING_EMPTY;
	public static String MUTATIONREFACTORING_SELECTIONWARNING_UNIFORM;

	public static String MUTATIONREFACTORING_PAGEICON;
	public static String MUTATIONREFACTORING_PAGEICON_TYPE;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
