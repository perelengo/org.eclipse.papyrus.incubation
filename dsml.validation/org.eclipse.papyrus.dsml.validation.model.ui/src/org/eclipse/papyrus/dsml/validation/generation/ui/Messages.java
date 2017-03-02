/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.dsml.validation.generation.ui;

import org.eclipse.osgi.util.NLS;

/**
 * @author ansgar
 *
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.dsml.validation.generation.ui.messages"; //$NON-NLS-1$
	public static String CreateJavaValidationPluginHandler_CheckErrorLog;
	public static String CreateJavaValidationPluginHandler_ChoosePluginGeneration;
	public static String CreateJavaValidationPluginHandler_CreateNewPlugin;
	public static String CreateJavaValidationPluginHandler_DependencyAdded;
	public static String CreateJavaValidationPluginHandler_DependencyAddedMsg;
	public static String CreateJavaValidationPluginHandler_DSMLDependencyAddedMsg;
	public static String CreateJavaValidationPluginHandler_ExceptionDuringPluginGeneration;
	public static String CreateJavaValidationPluginHandler_GenerateIntoExisting;
	public static String CreateJavaValidationPluginHandler_SelectExisting;
	public static String CreateJavaValidationPluginHandler_HostCurrent;
	public static String CreateJavaValidationPluginHandler_HowtoGeneratePlugin;
	public static String CreateJavaValidationPluginHandler_ProfileIsNotAPlugin;
	public static String CreateJavaValidationPluginHandler_ProfileIsNotAPluginExplication;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
