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
package org.eclipse.papyrus.layers.runtime.tests;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.infra.gmfdiag.layers.runtime.LayersStackApplicationEventNotifier;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.notifier.IDiagramViewEventListener;
import org.eclipse.papyrus.layers.runtime.tests.utils.TriggeredEventTraces;


/**
 * A listener on {@link LayersStackApplicationEventNotifier}. This listener trace events from
 * the notifier.
 *
 * @author cedric dumoulin
 *
 */
public class TraceDiagramViewEventListener implements IDiagramViewEventListener {

	public TriggeredEventTraces traces = new TriggeredEventTraces();


	@Override
	public void diagramViewAdded(Notification msg) {
		traces.addTrace("diagramViewAdded", msg);

	}

	@Override
	public void diagramViewRemoved(Notification msg) {
		traces.addTrace("diagramViewRemoved", msg);

	}

}
