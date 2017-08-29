/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.infra.gmfdiag.elk.tests;

import org.eclipse.papyrus.infra.gmfdiag.elk.tests.classdiag.ClassDiagramLayoutTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for this plugin 
 */
@RunWith(Suite.class)
@SuiteClasses({
		ClassDiagramLayoutTests.class,
})
public class AllTests {
	// Test suite
}
