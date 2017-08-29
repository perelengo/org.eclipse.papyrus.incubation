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
package org.eclipse.papyrus.refactoring.tests.utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * Test {@link PapyrusRefactoring}
 *
 */
public class PapyrusRefactoringTestsUtils extends AbstractPapyrusRefactoringTestCase {

	public static Set<EObject> getAllContainedElements(EObject parent) {
		Set<EObject> containedElements = new HashSet<>();
		Iterator<EObject> iterator = parent.eAllContents();

		while (iterator.hasNext()) {
			containedElements.add(iterator.next());
		}

		return containedElements;
	}

}
