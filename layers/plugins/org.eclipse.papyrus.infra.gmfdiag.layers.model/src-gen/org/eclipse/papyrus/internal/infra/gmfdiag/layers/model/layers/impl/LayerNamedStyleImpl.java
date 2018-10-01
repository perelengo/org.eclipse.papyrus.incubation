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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.runtime.notation.impl.NamedStyleImpl;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerNamedStyle;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer Named Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerNamedStyleImpl#getLayersStack <em>Layers Stack</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LayerNamedStyleImpl extends NamedStyleImpl implements LayerNamedStyle {
	/**
	 * The cached value of the '{@link #getLayersStack() <em>Layers Stack</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayersStack()
	 * @generated
	 * @ordered
	 */
	protected EList<LayersStack> layersStack;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerNamedStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.LAYER_NAMED_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<LayersStack> getLayersStack() {
		if (layersStack == null) {
			layersStack = new EObjectContainmentEList<LayersStack>(LayersStack.class, this, LayersPackage.LAYER_NAMED_STYLE__LAYERS_STACK);
		}
		return layersStack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersPackage.LAYER_NAMED_STYLE__LAYERS_STACK:
				return ((InternalEList<?>)getLayersStack()).basicRemove(otherEnd, msgs);
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
			case LayersPackage.LAYER_NAMED_STYLE__LAYERS_STACK:
				return getLayersStack();
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
			case LayersPackage.LAYER_NAMED_STYLE__LAYERS_STACK:
				getLayersStack().clear();
				getLayersStack().addAll((Collection<? extends LayersStack>)newValue);
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
			case LayersPackage.LAYER_NAMED_STYLE__LAYERS_STACK:
				getLayersStack().clear();
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
			case LayersPackage.LAYER_NAMED_STYLE__LAYERS_STACK:
				return layersStack != null && !layersStack.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LayerNamedStyleImpl
