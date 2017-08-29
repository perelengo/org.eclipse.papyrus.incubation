/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.properties.xtext.sheet;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.alf.preferences.AlfIntegrationPreferencesUtil;
import org.eclipse.papyrus.uml.alf.transaction.observation.listener.filter.FUMLScopeUtil;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Element;

/**
 * This class constrains the availability of the embedded ALF editor.
 *
 * The ALF editor must only be available when:
 * 1. The selection is a Class (not composite)
 * 2. The selection is an Association
 * 3. The selection is a Signal
 * 4. The selection is a Datatype
 * 5. The selection is an Enumeration
 * 6. The selection is a Package
 * 7. The selection is an Activity
 */
public class AlfEditorPropertySectionFilter implements IFilter {

	/**
	 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
	 *
	 * @param toTest
	 *
	 * @return accepted
	 */
	@Override
	public boolean select(Object toTest) {
		Element element = this.resolveSemanticElement(toTest);
		boolean accepted = false;
		if (element != null &&
				AlfIntegrationPreferencesUtil.isAlfSupportEnabled()) {
			accepted = this.isValidInput(element);
		}
		return accepted;
	}

	/**
	 * Check the given input and returns true if it is a valid input for the embedded ALF editor
	 * false otherwise
	 *
	 * @param element
	 *            an input element for ALF embedded editor
	 *
	 * @return true if element is accepted as an input false otherwise
	 */
	private boolean isValidInput(Element element) {
		/* 1. First constraint: the element must be modifiable (i.e. not read only) */
		if (!this.isModifiable(element)) {
			return false;
		}
		/* 2. It should be in the scope supported by the ALF editor */
		if (FUMLScopeUtil.isClass(element)) {
			return true;
		} else if (FUMLScopeUtil.isPackage(element)) {
			return true;
		} else if (FUMLScopeUtil.isSignal(element)) {
			return true;
		} else if (FUMLScopeUtil.isEnumeration(element)) {
			return true;
		} else if (FUMLScopeUtil.isDataType(element)) {
			return true;
		} else if (FUMLScopeUtil.isAssociation(element)) {
			return true;
		} else if (FUMLScopeUtil.isActivity(element)) {
			return true;
		} else if (FUMLScopeUtil.isOperationWithImplementation(element)) {
			return true;
		}
		return false;
	}

	private boolean isModifiable(Element element) {
		Resource resource = element.eResource();
		if (resource != null) {
			return !EMFHelper.isReadOnly(element);
		}
		return false;
	}

	/**
	 * From a selection this methods tries to extract the underlying model element
	 *
	 * @param selectedElement
	 *            an object selected in the view (e.g., a class in a diagram)
	 *
	 * @return semanticElement
	 *         the model element that is under the graphical element (may be null)
	 */
	private Element resolveSemanticElement(Object selectedElement) {
		return UMLUtil.resolveUMLElement(selectedElement);
	}
}