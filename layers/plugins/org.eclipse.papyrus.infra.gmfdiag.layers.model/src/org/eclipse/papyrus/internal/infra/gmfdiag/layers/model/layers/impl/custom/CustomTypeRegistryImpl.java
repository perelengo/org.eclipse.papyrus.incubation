/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
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

package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.custom;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TypeRegistryImpl;

/**
 * @author QL238289
 *
 */
public class CustomTypeRegistryImpl extends TypeRegistryImpl {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	protected CustomTypeRegistryImpl() {
		super();
		init();
	}

	/**
	 * Init the Registry.
	 * Register standard types.
	 */
	protected void init() {
		addType(LayersFactory.eINSTANCE.createCSSType());
		addType(LayersFactory.eINSTANCE.createCSSHideType());
	}

	/**
	 * Add the type in the registry
	 *
	 * @param type
	 */
	public void addType(Type type) {
		String typeName = type.getName();

		getTypes().put(typeName, type);
	}

}
