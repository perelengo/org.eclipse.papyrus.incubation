/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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

package org.eclipse.papyrus.operation.editor.xtext;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class OperationStandaloneSetup extends OperationStandaloneSetupGenerated {

	public static void doSetup() {
		new OperationStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
