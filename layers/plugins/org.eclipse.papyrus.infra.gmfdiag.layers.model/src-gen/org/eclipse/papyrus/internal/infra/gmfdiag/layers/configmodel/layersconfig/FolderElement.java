/**
 * Copyright (c) 2013, 2017 CEA LIST & LIFL 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *   Quentin Le Menez quentin.lemenez@cea.fr
 * 
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Folder Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.FolderElement#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayersConfigPackage#getFolderElement()
 * @model abstract="true"
 * @generated
 */
public interface FolderElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayersConfigPackage#getFolderElement_Name()
	 * @model dataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.String" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.FolderElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // FolderElement
