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

package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.emf.resources.AbstractEMFResourceWithUUID;

/**
 * @author QL238289
 * 
 *         This, in conjunction with the extension point org.eclipse.emf.ecore.extension_parser,
 *         is used to make the layers resource serialize itself with xmi IDs instead of positional IDs
 *
 */
public class CustomLayersModelResource extends AbstractEMFResourceWithUUID {

	public static final String LAYERS_RESOURCE_FILE_EXTENSION = "layers"; //$NON-NLS-1$

	/**
	 * Constructor.
	 *
	 * @param uri
	 */
	public CustomLayersModelResource(URI uri) {
		super(uri);
	}



}
