/*****************************************************************************
 * Copyright (c) 2010, 2018 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Florian Noyrit florian.noyrit@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagramtemplate;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage
 * @generated
 */
public interface DiagramTemplateFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	DiagramTemplateFactory eINSTANCE = org.eclipse.papyrus.diagramtemplate.impl.DiagramTemplateFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Diagram Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Diagram Definition</em>'.
	 * @generated
	 */
	DiagramDefinition createDiagramDefinition();

	/**
	 * Returns a new object of class '<em>Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Selection</em>'.
	 * @generated
	 */
	Selection createSelection();

	/**
	 * Returns a new object of class '<em>Selection Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Selection Ref</em>'.
	 * @generated
	 */
	SelectionRef createSelectionRef();

	/**
	 * Returns a new object of class '<em>Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Template</em>'.
	 * @generated
	 */
	Template createTemplate();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the package supported by this factory.
	 * @generated
	 */
	DiagramTemplatePackage getDiagramTemplatePackage();

} // DiagramTemplateFactory
