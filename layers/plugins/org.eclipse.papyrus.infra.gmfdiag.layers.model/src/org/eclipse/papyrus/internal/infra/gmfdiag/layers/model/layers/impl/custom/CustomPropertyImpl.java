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

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.BadStateException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyImpl;

/**
 * @author QL238289
 *
 */
public class CustomPropertyImpl extends PropertyImpl {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @throws BadStateException
	 */
	@Override
	public TypeInstance createInstance() throws BadStateException {

		if (type == null) {
			throw new BadStateException("Property '" + getName() + "', type must be set to create an instance");
		}

		// Create an instance
		TypeInstance instance = type.createInstance();
		// Set the default value if needed
		if (getDefaultValue() != null) {
			instance.setValueFromInstance(getDefaultValue());
		}

		return instance;
	}

}
