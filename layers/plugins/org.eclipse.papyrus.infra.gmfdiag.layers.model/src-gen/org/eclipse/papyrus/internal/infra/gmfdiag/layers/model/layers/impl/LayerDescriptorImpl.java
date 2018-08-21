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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerDescriptorImpl#getPropertyRegistry <em>Property Registry</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LayerDescriptorImpl extends EObjectImpl implements LayerDescriptor {
	/**
	 * The cached value of the '{@link #getPropertyRegistry() <em>Property Registry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyRegistry()
	 * @generated
	 * @ordered
	 */
	protected PropertyRegistry propertyRegistry;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.LAYER_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyRegistry getPropertyRegistry() {
		if (propertyRegistry != null && propertyRegistry.eIsProxy()) {
			InternalEObject oldPropertyRegistry = (InternalEObject)propertyRegistry;
			propertyRegistry = (PropertyRegistry)eResolveProxy(oldPropertyRegistry);
			if (propertyRegistry != oldPropertyRegistry) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LayersPackage.LAYER_DESCRIPTOR__PROPERTY_REGISTRY, oldPropertyRegistry, propertyRegistry));
			}
		}
		return propertyRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyRegistry basicGetPropertyRegistry() {
		return propertyRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyRegistry(PropertyRegistry newPropertyRegistry) {
		PropertyRegistry oldPropertyRegistry = propertyRegistry;
		propertyRegistry = newPropertyRegistry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_DESCRIPTOR__PROPERTY_REGISTRY, oldPropertyRegistry, propertyRegistry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersPackage.LAYER_DESCRIPTOR__PROPERTY_REGISTRY:
				if (resolve) return getPropertyRegistry();
				return basicGetPropertyRegistry();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LayersPackage.LAYER_DESCRIPTOR__PROPERTY_REGISTRY:
				setPropertyRegistry((PropertyRegistry)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LayersPackage.LAYER_DESCRIPTOR__PROPERTY_REGISTRY:
				setPropertyRegistry((PropertyRegistry)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LayersPackage.LAYER_DESCRIPTOR__PROPERTY_REGISTRY:
				return propertyRegistry != null;
		}
		return super.eIsSet(featureID);
	}

} //LayerDescriptorImpl
