/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - modification
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.model.elements.interfaces;

/**
 * Enumeration that specifies modes for the constraints validation: Batch -
 * constraints validation is triggered on user demand Live - constraints
 * validation is triggered every time when change in the model occures
 *
 *
 */
public enum Mode {

	Batch, Live;

}
