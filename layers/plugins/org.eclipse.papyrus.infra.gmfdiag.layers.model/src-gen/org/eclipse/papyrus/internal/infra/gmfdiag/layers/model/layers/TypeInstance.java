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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getTypeInstance()
 * @model abstract="true" superTypes="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ComputePropertyValueCommandItf"
 * @generated
 */
public interface TypeInstance extends EObject, ComputePropertyValueCommand {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model valueDataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" valueRequired="true" valueOrdered="false"
	 * @generated
	 */
	void setValueFromString(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model valueRequired="true" valueOrdered="false"
	 * @generated
	 */
	void setValueFromInstance(TypeInstance value);

} // TypeInstance
