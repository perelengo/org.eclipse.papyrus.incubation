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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.notifier;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication;


/**
 * This class listen to a {@link Diagram} and send following events to listeners:
 * <ul>
 * <li>view removed</li>
 * <li>view added</li>
 * </ul>
 *
 * @author cedric dumoulin
 * @deprecated use {@link DiagramViewChangedEventNotifier} instead.
 */
@Deprecated
public class DiagramViewEventNotifier {

	protected Diagram diagram;

	/**
	 * List of listener to notify.
	 */
	protected List<IDiagramViewEventListener> listeners = new ArrayList<IDiagramViewEventListener>();

	protected Adapter diagramViewListener = new EContentAdapter() {

		/**
		 * Something happen on the tree of object
		 *
		 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 *
		 * @param msg
		 */
		@Override
		public void notifyChanged(Notification notification) {

			// Self atttach
			super.notifyChanged(notification);

			// We are only interested in views (from newValue if set, or oldValue if removed)
			Object newValue = notification.getNewValue();
			if (!(newValue instanceof View || notification.getOldValue() instanceof View)) {
				return;
			}
			// Check diagram modification
			// There is 4 sources: View::persistedChildren and View::transientChildren
			// Diagram::persistedChildren and Diagram::transientChildren
			Object feature = notification.getFeature();
			if (feature == NotationPackage.eINSTANCE.getView_PersistedChildren()
					|| feature == NotationPackage.eINSTANCE.getView_TransientChildren()
					|| feature == NotationPackage.eINSTANCE.getDiagram_PersistedEdges()
					|| feature == NotationPackage.eINSTANCE.getDiagram_TransientEdges()) {
				// LayerOperator::layers || LayersStack::layers
				// check the event type.
				switch (notification.getEventType()) {
				case Notification.SET:

					break;
				case Notification.ADD:
					// A view is added
					fireDiagramViewAddedEvent(notification);
					break;
				case Notification.REMOVE:
					// A layer is removed
					fireDiagramViewRemovedEvent(notification);
					break;
				}
			}
		}

	};

	/**
	 * Constructor.
	 *
	 * @param layersModel
	 */
	public DiagramViewEventNotifier(Diagram diagram) {
		this.diagram = diagram;
		activate();
	}

	/**
	 * Activate the listeners.
	 *
	 */
	protected void activate() {
		// Listen on diagram removed events
		diagram.eAdapters().add(diagramViewListener);
	}

	/**
	 * Deactivate listeners
	 */
	protected void deactivate() {
		// Listen on diagram removed events
		diagram.eAdapters().remove(diagramViewListener);
	}

	/**
	 * Dispose the synchronizer
	 */
	public void dispose() {
		// Deactivate listeners
		deactivate();
		diagram = null;
	}

	/**
	 * Return true if the object is disposed.
	 *
	 * @return
	 */
	public boolean isDisposed() {
		return diagram == null;
	}

	/**
	 * Add the specified listener to the list of listener.
	 * Do not add it if the listener is already in the list.
	 *
	 * @param listener
	 */
	public void addEventListener(IDiagramViewEventListener listener) {

		if (listener == null) {
			return;
		}

		// Check if exist
		if (listeners.contains(listener)) {
			return;
		}

		listeners.add(listener);
	}

	/**
	 * Remove the specified listener from the list of listeners.
	 *
	 * @param listener
	 */
	public void removeEventListener(IDiagramViewEventListener listener) {

		listeners.remove(listener);
	}

	/**
	 * Called by events when a {@link LayersStack} is added to the {@link LayersStackApplication}
	 *
	 * @param msg
	 */
	protected void fireDiagramViewAddedEvent(Notification msg) {
		for (IDiagramViewEventListener listener : listeners) {
			listener.diagramViewAdded(msg);
		}
	}

	/**
	 * Called by events when a {@link LayersStack} is added to the {@link LayersStackApplication}
	 *
	 * @param msg
	 */
	protected void fireDiagramViewRemovedEvent(Notification msg) {
		for (IDiagramViewEventListener listener : listeners) {
			listener.diagramViewRemoved(msg);
		}
	}

	/**
	 * Get the removed diagram in case of diagramRemoved event
	 *
	 * @param msg
	 * @return
	 */
	public static View viewAddedEvent_getAddedView(Notification msg) {
		return (View) msg.getNewValue();
	}

	/**
	 * Get the removed diagram in case of diagramRemoved event
	 *
	 * @param msg
	 * @return
	 */
	public static View viewAddedEvent_getRemovedView(Notification msg) {
		return (View) msg.getOldValue();
	}

}
