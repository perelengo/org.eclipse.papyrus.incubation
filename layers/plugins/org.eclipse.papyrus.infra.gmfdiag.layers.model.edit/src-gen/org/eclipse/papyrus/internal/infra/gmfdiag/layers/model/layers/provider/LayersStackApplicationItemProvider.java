/**
 * Copyright (c) 2013, 2017 CEA LIST & LIFL 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *   Quentin Le Menez quentin.lemenez@cea.fr
 * 
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LayersStackApplicationItemProvider extends FolderElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersStackApplicationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(LayersPackage.Literals.LAYERS_STACK_APPLICATION__LAYERS_STACKS);
			childrenFeatures.add(LayersPackage.Literals.LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY);
			childrenFeatures.add(LayersPackage.Literals.LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY);
			childrenFeatures.add(LayersPackage.Literals.LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY);
			childrenFeatures.add(LayersPackage.Literals.LAYERS_STACK_APPLICATION__FACTORY);
			childrenFeatures.add(LayersPackage.Literals.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY);
			childrenFeatures.add(LayersPackage.Literals.LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns LayersStackApplication.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LayersStackApplication")); //$NON-NLS-1$
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_LayersStackApplication_type"); //$NON-NLS-1$
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(LayersStackApplication.class)) {
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYERS_STACKS:
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY:
			case LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY:
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY:
			case LayersPackage.LAYERS_STACK_APPLICATION__FACTORY:
			case LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY:
			case LayersPackage.LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(LayersPackage.Literals.LAYERS_STACK_APPLICATION__LAYERS_STACKS,
				 LayersFactory.eINSTANCE.createLayersStack()));

		newChildDescriptors.add
			(createChildParameter
				(LayersPackage.Literals.LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY,
				 LayersFactory.eINSTANCE.createLayerStackDescriptorRegistry()));

		newChildDescriptors.add
			(createChildParameter
				(LayersPackage.Literals.LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY,
				 LayersFactory.eINSTANCE.createPropertyRegistry()));

		newChildDescriptors.add
			(createChildParameter
				(LayersPackage.Literals.LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY,
				 LayersFactory.eINSTANCE.createLayerDescriptorRegistry()));

		newChildDescriptors.add
			(createChildParameter
				(LayersPackage.Literals.LAYERS_STACK_APPLICATION__FACTORY,
				 LayersFactory.eINSTANCE.createLayerApplicationFactory()));

		newChildDescriptors.add
			(createChildParameter
				(LayersPackage.Literals.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY,
				 LayersFactory.eINSTANCE.createPropertySetterRegistry()));

		newChildDescriptors.add
			(createChildParameter
				(LayersPackage.Literals.LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY,
				 LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry()));
	}

}
