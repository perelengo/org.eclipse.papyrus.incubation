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
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.preferences;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;

public class AlfIntegrationPreferencesUtil {

	private final static String qualifier = "org.eclipse.papyrus.uml.alf.preferences";

	public static boolean isAlfSupportEnabled() {
		IPreferencesService preferencesService = Platform.getPreferencesService();
		return preferencesService.getBoolean(qualifier,
				AlfIntegrationPreferencesConstants.ALF_SUPPORT, false, null);
	}

	public static boolean isAlfAutoSyncEnabled() {
		IPreferencesService preferencesService = Platform.getPreferencesService();
		boolean syncEnabled = preferencesService.getBoolean(qualifier,
				AlfIntegrationPreferencesConstants.ALF_AUTOMATIC_SYNCHRONIZATION, false, null);
		return syncEnabled && isAlfSupportEnabled();
	}
}
