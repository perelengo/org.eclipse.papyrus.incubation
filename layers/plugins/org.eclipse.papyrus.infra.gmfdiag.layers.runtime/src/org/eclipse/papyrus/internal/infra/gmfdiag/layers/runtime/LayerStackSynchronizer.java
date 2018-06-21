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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime;

import static org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.Activator.log;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.AddCssClassStyleCommand;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.RemoveCssClassStyleCommand;
import org.eclipse.papyrus.infra.gmfdiag.css.provider.CSSClassContentProvider;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.BadStateException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.notifier.DiagramViewEventNotifier;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.notifier.IDiagramViewEventListener;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.commands.ApplyLayerCSSChangedCommand;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.commands.ApplyLayerCSSCommand;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.commands.HideLayerElementsCommand;


/**
 * This class is used to synchronize the diagram's properties when something
 * change in the LayerStack.
 * It listen on events from {@link LayersStack} and {@link Diagram}.
 *
 * @author cedric dumoulin
 *
 */
public class LayerStackSynchronizer implements IDiagramViewEventListener, ILayersModelEventListener {

	/**
	 * The observed diagram.
	 */
	protected Diagram diagram;

	/**
	 * The observed LayerStack.
	 */
	protected LayersStack layersStack;

	/**
	 * The application object. Required by some methods. <br>
	 * Method requiring this object must check it before any use,
	 * as this object can be null.
	 *
	 */
	protected LayersStackApplication application;

	/**
	 * The notifier of layer model events.
	 */
	protected LayersModelEventNotifier layersModelEventNotifier;

	/**
	 * The notifier of layer model events.
	 */
	protected DiagramViewEventNotifier diagramViewEventNotifier;

	/**
	 * Constructor.
	 *
	 * @param layersStack
	 *            The layerStack to listen to. It should have an associated diagram.
	 *
	 */
	public LayerStackSynchronizer(LayersStack layersStack) {
		this.diagram = layersStack.getDiagram();
		this.layersStack = layersStack;

		// try to get the application object
		// it is the container of the layerStack
		application = (LayersStackApplication) layersStack.eContainer();


		activate();
		// System.err.println("LayerStackSynchronizer( " +diagram.getName()+ " ) started");
	}



	/**
	 * @return the diagram
	 */
	public Diagram getDiagram() {
		return diagram;
	}



	/**
	 * @return the layersStack
	 */
	public LayersStack getLayersStack() {
		return layersStack;
	}



	/**
	 * Activate the listeners.
	 *
	 */
	protected void activate() {

		diagramViewEventNotifier = new DiagramViewEventNotifier(diagram);
		diagramViewEventNotifier.addEventListener(this);

		layersModelEventNotifier = new LayersModelEventNotifier(layersStack);
		layersModelEventNotifier.addLayersModelEventListener(this);

	}

	/**
	 * Deactivate listeners
	 */
	protected void deactivate() {
		diagramViewEventNotifier.removeEventListener(this);
		diagramViewEventNotifier = null;

		layersModelEventNotifier.removeLayersModelEventListener(this);
		layersModelEventNotifier = null;
	}

	/**
	 * Dispose the synchronizer
	 */
	protected void dispose() {
		// Deactivate listeners
		deactivate();
		diagramViewEventNotifier = null;
		layersModelEventNotifier = null;
	}

	/**
	 * Return true if the object is disposed.
	 *
	 * @return
	 */
	protected boolean isDisposed() {
		return diagramViewEventNotifier == null;
	}

	/**
	 * Check if the application object is not null.
	 * Throw an exception if the application object is null. <br>
	 * In normal use, the Application is the container of the LayerStack.
	 * It is set in the constructor of this class.
	 *
	 * @throws BadStateException
	 */
	protected void checkApplication() throws BadStateException {
		if (application == null) {
			throw new BadStateException("Attempt to call a method requireing the 'application object, but the Application object is not set. You must provide a LayerStack contained in its Application.");
		}
	}

	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.ILayersModelEventListener#propertyValueAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void propertyValueAdded(Notification notification) {

		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + ".propertyValueAdded " + notification.getNewValue());
		}

		try {
			// Name of the property
			String propertyName = LayersModelEventUtils.PropertyEvents.getPropertyNameFromValueAdd(notification);

			// Need to recompute the associated views
			AbstractLayer layer = LayersModelEventUtils.PropertyEvents.getAbstractLayer(notification);
			List<View> views = layer.getViews();
			// The views are not supposed to be always defined (in the case of filters for example)
			if (views.size() == 0) {
				views = layer.getLayersStack().getDiagram().getChildren();
				return;
			}

			checkApplication();
			try {
				TransactionalEditingDomain ted = ServiceUtilsForResource.getInstance().getTransactionalEditingDomain(views.get(0).eResource());

				RecordingCommand applyLayerCSSCommand = new ApplyLayerCSSCommand(ted, views, propertyName, application, layersStack, "RecordingCommand aggregating the CSS and style applications from a single layer");

				// ted.getCommandStack().execute(applyLayerCSSCommand);
				applyLayerCSSCommand.execute();

			} catch (ServiceException e) {
				Activator.log.error("PropertyValueAdded applyLayerCSSCommand has failed", e); //$NON-NLS-1$
			}

		} catch (NotFoundException e) {
			log.error(e);
		} catch (LayersException e) {
			log.error(e);
		} catch (UnsupportedOperationException e) {
			// A setter or getter is not implemented
			// throw new UnsupportedOperationException("setter='" + setter.getClass().getName() + "'", e);
			throw new UnsupportedOperationException("a setter is not implemented", e);
		}
	}



	@SuppressWarnings("unchecked")
	@Override
	public void propertyValueRemoved(Notification notification) {
		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + ".propertyValueRemoved " + notification.getOldValue());
		}

		try {
			// Name of the property
			String propertyName = LayersModelEventUtils.PropertyEvents.getPropertyNameFromValueRemove(notification);

			// Need to recompute the associated views
			AbstractLayer layer = LayersModelEventUtils.PropertyEvents.getAbstractLayer(notification);
			List<View> views = layer.getViews();
			// The views may not be set yet, if any will be
			if (views.size() == 0) {
				views = layer.getLayersStack().getDiagram().getChildren();
				// return;
			}

			checkApplication();
			Property property = application.getPropertyRegistry().getProperty(propertyName);

			List<ComputePropertyValueCommand> commands = layersStack.getViewsComputePropertyValueCommand(views, property);
			if (commands == null) {
				// no command
				return;
			}

			PropertySetter setter = application.getPropertySetterRegistry().getPropertySetter(property);

			// Walk each view and set the property
			for (int i = 0; i < views.size(); i++) {
				// A command can be null
				ComputePropertyValueCommand cmd = commands.get(i).getCmdValue();
				if (cmd != null) {
					setter.setValue(views.get(i), cmd.getCmdValue());
				}

			}
		} catch (NotFoundException e) {
			log.error(e);
		} catch (LayersException e) {
			log.error(e);
		}
	}



	@SuppressWarnings("unchecked")
	@Override
	public void propertyValueChanged(Notification notification) {
		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + ".propertyValueChanged " + notification.getNewValue());
		}

		// If LayerExpression::IsLayerEnabled() is changed, treat it separately.
		if (notification.getFeature() == LayersPackage.eINSTANCE.getLayerExpression_IsLayerEnabled()) {
			propertyValueChangedIsLayerEnabled(notification);
			return;
		}

		// Here, this should be a regular property that is modified
		try {
			// Name of the property
			String propertyName = LayersModelEventUtils.PropertyEvents.getPropertyNameFromValueSet(notification);

			// Need to recompute the associated views
			AbstractLayer layer = LayersModelEventUtils.PropertyEvents.getAbstractLayer(notification);
			List<View> views = layer.getViews();
			if (views.size() == 0) {
				// The views may not be set yet, if any will be
				views = layer.getLayersStack().getDiagram().getChildren();
				// return;
			}

			checkApplication();

			try {
				TransactionalEditingDomain ted = ServiceUtilsForResource.getInstance().getTransactionalEditingDomain(layer.getLayersStack().getDiagram().eResource());

				RecordingCommand applyLayerCSSChangedCommand = new ApplyLayerCSSChangedCommand(ted, views, propertyName, layer, application, layersStack, "RecordingCommand aggregating the CSS and style applications from a single layer");

				// ted.getCommandStack().execute(applyLayerCSSChangedCommand);
				applyLayerCSSChangedCommand.execute();

			} catch (ServiceException e) {
				Activator.log.error("PropertyValueChanged applyLayerCSSChangedCommand has failed", e); //$NON-NLS-1$
			}

		} catch (LayersException e) {
			log.error(e);
		}
	}



	/**
	 * The LayerExpression::IsLayerEnabled() is changed. Refresh views and properties of the layer.
	 *
	 *
	 * @param notification
	 */
	private void propertyValueChangedIsLayerEnabled(Notification notification) {

		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + ".propertyValueChangedIsLayerEnabled " + notification.getNewValue());

		}

		try {

			checkApplication();

			// Extract the affected layer
			// AbstractLayer layer = LayersModelEventUtils.PropertyEvents.getAbstractLayer(notification);
			AbstractLayer layer = (AbstractLayer) notification.getNotifier();

			// This needs to be updated if the layer's elements are visible
			if (layer.isLayerEnabled()) {
				recomputePropertiesForAllViewsOf(layer);
			}

			setVisibility(layer);

		} catch (NotFoundException e) {
			log.error(e);
		} catch (LayersException e) {
			log.error(e);
		}
	}


	private void setVisibility(final AbstractLayer layer) {
		// This used a style in order to apply a specific strategy for 'hiding' elements
		// Using a dedicated stylesheet removes the need to retreive the views
		// List<View> views = new ArrayList<View>();
		// if (layer.getViews().isEmpty()) {
		// views = diagram.getChildren();
		// // return;
		// } else {
		// views = layer.getViews();
		// }

		try {
			final TransactionalEditingDomain ted = ServiceUtilsForResource.getInstance().getTransactionalEditingDomain(diagram.eResource());
			if (ted == null) {
				return;
			}

			ExtendedCSSEngine cssEngine = diagram instanceof CSSDiagram ? ((CSSDiagram) diagram).getEngine() : null;
			CSSClassContentProvider cssccp = new CSSClassContentProvider("*", cssEngine);
			cssccp.getAvailableClasses();

			RecordingCommand rc = new HideLayerElementsCommand(ted, layer, "HideLayerElementsCommand"); //$NON-NLS-1$

			rc.execute();

		} catch (ServiceException e) {
			Activator.log.error("setVisibility hideLayerElementsCommand has failed", e); //$NON-NLS-1$
		}

	}

	/**
	 * Recompute the specified properties for the specified views.
	 *
	 * @param views
	 * @param properties
	 * @throws LayersException
	 */
	private void recompute(List<View> views, List<Property> properties) throws LayersException {

		// Iterate on views
		for (View view : views) {
			recompute(view, properties);
		}

	}



	/**
	 * Recompute the specified properties for the specified view.
	 *
	 * @param view
	 * @param properties
	 * @throws LayersException
	 */
	private void recompute(View view, List<Property> properties) throws LayersException {

		List<ComputePropertyValueCommand> commands = layersStack.getPropertiesComputePropertyValueCommand(view, properties);
		if (commands == null) {
			// No property to set
			return;
		}

		PropertySetter setter;
		// Walk each cmd and set the property
		for (int i = 0; i < commands.size(); i++) {
			try {
				Property property = properties.get(i);
				setter = application.getPropertySetterRegistry().getPropertySetter(property);
				// Set the value only if we have a getter command.
				ComputePropertyValueCommand getterCmd = commands.get(i);
				if (getterCmd != null) {
					setter.setValue(view, getterCmd.getCmdValue());
				}

			} catch (NotFoundException e) {
				// No setter found
				log.error(e);
			} catch (NullPointerException e) {
				// A command is null
			}
		}

	}



	@Override
	public void layerAdded(Notification notification) {
		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + ".layerAdded() " + notification.getNewValue());
		}

		if (!(notification.getNewValue() instanceof AbstractLayer)) {
			log.info("TODO: " + this.getClass().getSimpleName() + ".layerAdded() " + notification.getOldValue() + " - recompute for LayerOperator not implemented yet.");
			;
			return;
		}

		// Extract the affected layer
		AbstractLayer layer = (AbstractLayer) notification.getNewValue();
		// FIXME The layerStack is not properly set during creation phase. THis should be set elsewhere.
		layer.setOwningLayersStack(layersStack);

		try {
			checkApplication();
			recomputePropertiesForAllViewsOf(layer);
		} catch (LayersException e) {
			log.error(e);
		}

	}



	@Override
	public void layerRemoved(Notification notification) {
		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + " layerRemoved() " + notification.getOldValue());
		}

		if (!(notification.getOldValue() instanceof AbstractLayer)) {
			log.info("TODO: " + this.getClass().getSimpleName() + ".layerRemoved() " + notification.getOldValue() + " - recompute() after removing layerOperator not implemented yet.");
			;
			return;
		}
		// Extract the affected layer
		AbstractLayer layer = (AbstractLayer) notification.getOldValue();

		try {
			checkApplication();
			recomputePropertiesForAllViewsOf(layer);
		} catch (LayersException e) {
			log.error(e);
		}

	}



	/**
	 * Recompute the properties of the views attached to the specified layers.
	 *
	 * @param layer
	 * @throws LayersException
	 */
	@SuppressWarnings("unchecked")
	private void recomputePropertiesForAllViewsOf(AbstractLayer layer) throws LayersException {
		// We need the list of affected properties
		List<Property> properties = layer.getAttachedProperties();

		// We need the list of affected Views.
		List<View> views = layer.getViews();
		if (views.size() == 0) {
			// If no views have been selected it is deemed by default that all should be
			recompute(this.diagram.getChildren(), properties);
			return;
		}

		// For each view, recompute the Properties
		recompute(views, properties);
	}



	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.ILayersModelEventListener#layerMoved(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void layerMoved(Notification notification) {
		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + " layerMoved(not tested) " + notification.getNewValue());
		}

		// Extract the affected layer
		AbstractLayer layer = (AbstractLayer) notification.getNewValue();

		try {
			checkApplication();
			recomputePropertiesForAllViewsOf(layer);
		} catch (LayersException e) {
			log.error(e);
		}

	}

	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.ILayersModelEventListener#layerSet(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void layerSet(Notification notification) {
		log.info(this.getClass().getSimpleName() + " layerSet(not implemented) " + notification.getNewValue());

	}



	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.ILayersModelEventListener#viewAddedToLayer(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void viewAddedToLayer(Notification notification) {

		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + " viewAddedToLayer( " + notification.getNewValue() + " )");
		}

		// We need to find the view, the layer in which it is added,
		// and the properties attached to this layer.
		// Then, we compute this property and set it to the view.
		try {
			AbstractLayer layer = LayersModelEventUtils.PropertyEvents.getAbstractLayer(notification);
			View view = LayersModelEventUtils.ViewEvents.getViewAdded(notification);


			checkApplication();
			List<Property> properties = layer.getAttachedProperties();

			List<ComputePropertyValueCommand> commands = layersStack.getPropertiesComputePropertyValueCommand(view, properties);
			if (commands == null) {
				// No property to set
				return;
			}

			PropertySetter setter;
			// Walk each cmd and set the property
			for (int i = 0; i < commands.size(); i++) {
				try {
					Property property = properties.get(i);
					setter = application.getPropertySetterRegistry().getPropertySetter(property);
					setter.setValue(view, commands.get(i).getCmdValue());
				} catch (NotFoundException e) {
					// No setter found
					log.error("No setter found", e);
				} catch (NullPointerException e) {
					// A command is null
				}
			}
		} catch (LayersException e) {
			log.error(e);
		}
	}


	@Override
	public void multiViewsAddedToLayer(Notification notification) {

		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + ".multiViewsAddedToLayer( " + notification.getNewValue() + " )");
		}

		// We need to find the view, the layer in which it is added,
		// and the properties attached to this layer.
		// Then, we compute this property and set it to the view.
		try {
			AbstractLayer layer = LayersModelEventUtils.PropertyEvents.getAbstractLayer(notification);
			List<View> views = LayersModelEventUtils.ViewEvents.getViewsAdded(notification);

			checkApplication();
			List<Property> properties = layer.getAttachedProperties();
			recompute(views, properties);

		} catch (LayersException e) {
			log.error(e);
		}

	}



	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.ILayersModelEventListener#viewRemovedFromLayer(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void viewRemovedFromLayer(Notification notification) {
		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + " viewRemovedFromLayer( " + notification.getOldValue() + " )");
		}

		// We need to find the view, the layer in which it is added,
		// and the properties attached to this layer.
		// Then, we compute this property and set it to the view.
		try {
			AbstractLayer layer = LayersModelEventUtils.PropertyEvents.getAbstractLayer(notification);
			View view = LayersModelEventUtils.ViewEvents.getViewRemoved(notification);

			checkApplication();
			List<Property> properties = layer.getAttachedProperties();

			List<ComputePropertyValueCommand> commands = layersStack.getPropertiesComputePropertyValueCommand(view, properties);
			if (commands == null) {
				// No property to set
				return;
			}

			PropertySetter setter;
			// Walk each cmd and set the property
			for (int i = 0; i < commands.size(); i++) {
				try {
					Property property = properties.get(i);
					setter = application.getPropertySetterRegistry().getPropertySetter(property);
					setter.setValue(view, commands.get(i).getCmdValue());
				} catch (NotFoundException e) {
					// No setter found
					log.error("No setter found", e);
				} catch (NullPointerException e) {
					// A command is null
				}
			}
		} catch (LayersException e) {
			Activator.log.error("LayersException upon removind the view from the Layer", e); //$NON-NLS-1$
		}
	}

	@Override
	public void multiViewsRemovedFromLayer(Notification notification) {

		if (log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + " multiViewsRemovedFromLayer( " + notification.getOldValue() + " )");
		}

		// We need to find the view, the layer in which it is added,
		// and the properties attached to this layer.
		// Then, we compute this property and set it to the view.
		try {
			AbstractLayer layer = LayersModelEventUtils.PropertyEvents.getAbstractLayer(notification);
			List<View> views = LayersModelEventUtils.ViewEvents.getViewsRemoved(notification);

			checkApplication();
			List<Property> properties = layer.getAttachedProperties();
			recompute(views, properties);

		} catch (LayersException e) {
			log.error(e);
		}

	}




	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.ILayersModelEventListener#viewMovedBetweenLayer(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void viewMovedBetweenLayer(Notification notification) {
		log.info(this.getClass().getSimpleName() + " viewMovedBetweenLayer(not implemented) " + notification.getNewValue());

	}



	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.notifier.IDiagramViewEventListener#diagramViewAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param msg
	 */
	@Override
	public void diagramViewAdded(Notification msg) {
		log.info(this.getClass().getSimpleName() + " diagramViewAdded(not implemented) " + msg.getNewValue());

		// WARNING !!!
		// Some filtering should be done on the event.
		// When a View is removed, the event is sent for each of its parts. This
		// result in multiple events receiving.
		// Only events on Shape and Links are useful. So, we need to
		// do some filtering (in the DiagramViewEventNotifier ?).
	}



	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.notifier.IDiagramViewEventListener#diagramViewRemoved(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param msg
	 */
	@Override
	public void diagramViewRemoved(Notification msg) {
		log.info(this.getClass().getSimpleName() + " diagramViewRemoved(not implemented) " + msg.getOldValue());

		// WARNING !!!
		// Some filtering should be done on the event.
		// When a View is removed, the event is sent for each of its parts. This
		// result in multiple events receiving.
		// Only events on Shape and Links are useful. So, we need to
		// do some filtering (in the DiagramViewEventNotifier ?).
	}





}
