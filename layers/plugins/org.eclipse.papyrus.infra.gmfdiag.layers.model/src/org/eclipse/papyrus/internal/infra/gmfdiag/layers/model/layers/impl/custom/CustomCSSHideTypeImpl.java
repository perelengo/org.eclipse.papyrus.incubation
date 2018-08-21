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
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHideTypeImpl;

/**
 * @author QL238289
 *
 */
public class CustomCSSHideTypeImpl extends CSSHideTypeImpl {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	protected CustomCSSHideTypeImpl() {
		super();
		setName("CSSHideType");
	}

	@Override
	public org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance createInstance() {
		return LayersFactory.eINSTANCE.createCSSHideInstance();
	};

}
