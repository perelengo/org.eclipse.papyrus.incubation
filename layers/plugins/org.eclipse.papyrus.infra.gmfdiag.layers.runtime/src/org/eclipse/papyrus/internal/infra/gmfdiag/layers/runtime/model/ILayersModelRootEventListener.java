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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication;


/**
 * Class implementing this interface can listen to event from a {@link LayersStackApplication}.
 *
 * @author cedric dumoulin
 *
 */
public interface ILayersModelRootEventListener {

	/**
	 * Called by events when a root of type {@link LayersStackApplication} is added to the {@link LayersModelResource} elements.
	 *
	 * @param msg
	 */
	public void layersModelRootAdded(Notification msg);

	/**
	 * Called by events when a root of type {@link LayersStackApplication} is removed from the {@link Diagram} or one of its contained
	 * elements.
	 *
	 * @param msg
	 */
	public void layersModelRootRemoved(Notification msg);


}
