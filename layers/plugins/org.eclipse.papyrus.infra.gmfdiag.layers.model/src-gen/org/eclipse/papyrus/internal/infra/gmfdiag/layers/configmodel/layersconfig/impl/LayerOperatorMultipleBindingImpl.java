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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl;

import java.util.Collection;

import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayerOperatorConfig;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayerOperatorMultipleBinding;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayersConfigPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.OperatorBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer Operator Multiple Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl.LayerOperatorMultipleBindingImpl#getLayerOperatorConfig <em>Layer Operator Config</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl.LayerOperatorMultipleBindingImpl#getBindings <em>Bindings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LayerOperatorMultipleBindingImpl extends FolderElementImpl implements LayerOperatorMultipleBinding {
	/**
	 * The cached value of the '{@link #getLayerOperatorConfig() <em>Layer Operator Config</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerOperatorConfig()
	 * @generated
	 * @ordered
	 */
	protected LayerOperatorConfig layerOperatorConfig;

	/**
	 * The cached value of the '{@link #getBindings() <em>Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<OperatorBinding> bindings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerOperatorMultipleBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersConfigPackage.Literals.LAYER_OPERATOR_MULTIPLE_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorConfig getLayerOperatorConfig() {
		if (layerOperatorConfig != null && layerOperatorConfig.eIsProxy()) {
			InternalEObject oldLayerOperatorConfig = (InternalEObject)layerOperatorConfig;
			layerOperatorConfig = (LayerOperatorConfig)eResolveProxy(oldLayerOperatorConfig);
			if (layerOperatorConfig != oldLayerOperatorConfig) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LayersConfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__LAYER_OPERATOR_CONFIG, oldLayerOperatorConfig, layerOperatorConfig));
			}
		}
		return layerOperatorConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorConfig basicGetLayerOperatorConfig() {
		return layerOperatorConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerOperatorConfig(LayerOperatorConfig newLayerOperatorConfig) {
		LayerOperatorConfig oldLayerOperatorConfig = layerOperatorConfig;
		layerOperatorConfig = newLayerOperatorConfig;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersConfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__LAYER_OPERATOR_CONFIG, oldLayerOperatorConfig, layerOperatorConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<OperatorBinding> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentWithInverseEList<OperatorBinding>(OperatorBinding.class, this, LayersConfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__BINDINGS, LayersConfigPackage.OPERATOR_BINDING__OWNER);
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersConfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__BINDINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBindings()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersConfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__BINDINGS:
				return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersConfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__LAYER_OPERATOR_CONFIG:
				if (resolve) return getLayerOperatorConfig();
				return basicGetLayerOperatorConfig();
			case LayersConfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__BINDINGS:
				return getBindings();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LayersConfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__LAYER_OPERATOR_CONFIG:
				setLayerOperatorConfig((LayerOperatorConfig)newValue);
				return;
			case LayersConfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__BINDINGS:
				getBindings().clear();
				getBindings().addAll((Collection<? extends OperatorBinding>)newValue);
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
			case LayersConfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__LAYER_OPERATOR_CONFIG:
				setLayerOperatorConfig((LayerOperatorConfig)null);
				return;
			case LayersConfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__BINDINGS:
				getBindings().clear();
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
			case LayersConfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__LAYER_OPERATOR_CONFIG:
				return layerOperatorConfig != null;
			case LayersConfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__BINDINGS:
				return bindings != null && !bindings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LayerOperatorMultipleBindingImpl
