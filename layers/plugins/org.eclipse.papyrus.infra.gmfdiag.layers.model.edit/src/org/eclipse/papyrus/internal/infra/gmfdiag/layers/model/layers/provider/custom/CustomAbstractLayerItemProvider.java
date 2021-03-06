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
/**
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.custom;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NullInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToTypeInstanceMapImpl;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 */
public class CustomAbstractLayerItemProvider
		extends org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.AbstractLayerItemProvider {
	/**
	 * The extended object, used as a delegate. This delegate is usually the original implementation
	 * of the ItemProvider.
	 */
	protected org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.AbstractLayerItemProvider extendedDelegate;

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	public CustomAbstractLayerItemProvider(AdapterFactory adapterFactory,
			org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.AbstractLayerItemProvider extendedDelegate) {
		super(adapterFactory);
		this.extendedDelegate = extendedDelegate;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.provider.AbstractLayerItemProvider#getChildrenFeatures(java.lang.Object)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			// Add the Property values list. Like that, they will be available directly under the
			// Layer node.
			childrenFeatures.add(LayersPackage.Literals.ABSTRACT_LAYER__PROPERTY_VALUES);
		}
		return childrenFeatures;
	}

	/**
	 * We want has children:
	 * <ul>
	 * <li></li>
	 * <li></li>
	 * </ul>
	 *
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getChildren(java.lang.Object)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public Collection<?> getChildren(Object object) {
		ChildrenStore store = getChildrenStore(object);
		if (store != null) {
			return store.getChildren();
		}

		store = createChildrenStore(object);
		List<Object> result = store != null ? null : new ArrayList<Object>();
		EObject eObject = (EObject) object;

		for (EStructuralFeature feature : getChildrenFeatures(object)) {
			if (feature.isMany()) {
				List<?> children = (List<?>) getValue(eObject, feature);
				int index = 0;
				for (Object unwrappedChild : children) {
					if (!isValidChild(unwrappedChild)) {
						continue;
					}
					//
					Object child = wrap(eObject, feature, unwrappedChild, index);
					if (store != null) {
						store.getList(feature).add(child);
					} else if (result != null) {
						result.add(child);
					}
					index++;

				}
			} else {
				// Single value
				Object child = getValue(eObject, feature);
				if (child != null && isValidChild(child)) {
					child = wrap(eObject, feature, child, CommandParameter.NO_INDEX);
					if (store != null) {
						store.setValue(feature, child);
					} else if (result != null) {
						result.add(child);
					}
				}
			}
		}
		return store != null ? store.getChildren() : result;
	}

	/**
	 * Return true if the value should be a children of the node
	 *
	 * @param child
	 * @return
	 */
	private boolean isValidChild(Object child) {

		if (child instanceof StringToTypeInstanceMapImpl
				|| child instanceof NullInstance) {
			return false;
		}

		return true;
	}

	/**
	 * This returns RegExpLayer.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public Object getImage(Object object) {
		return extendedDelegate.getImage(object);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		return extendedDelegate.getPropertyDescriptors(object);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public String getText(Object object) {
		return extendedDelegate.getText(object);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}


}
