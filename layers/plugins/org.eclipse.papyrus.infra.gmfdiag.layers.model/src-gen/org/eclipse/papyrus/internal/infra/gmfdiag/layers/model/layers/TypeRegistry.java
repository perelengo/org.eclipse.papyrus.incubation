/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeRegistry#getTypes <em>Types</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getTypeRegistry()
 * @model
 * @generated
 */
public interface TypeRegistry extends EObject {
	/**
	 * Returns the value of the '<em><b>Types</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' map isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' map.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getTypeRegistry_Types()
	 * @model mapType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StringToTypeMap&lt;org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type&gt;" ordered="false"
	 * @generated
	 */
	EMap<String, Type> getTypes();

} // TypeRegistry
