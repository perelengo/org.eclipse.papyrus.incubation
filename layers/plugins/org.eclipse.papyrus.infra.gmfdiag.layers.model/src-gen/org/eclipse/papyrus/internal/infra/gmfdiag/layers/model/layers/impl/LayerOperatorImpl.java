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

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersContainer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorImpl#getLayers <em>Layers</em>}</li>
 * <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorImpl#getLayerOperatorDescriptorName <em>Layer Operator Descriptor Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorImpl#getLayerOperatorDescriptor <em>Layer Operator Descriptor</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LayerOperatorImpl extends LayerExpressionImpl implements LayerOperator {
	/**
	 * The cached value of the '{@link #getLayers() <em>Layers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLayers()
	 * @generated
	 * @ordered
	 */
	protected EList<LayerExpression> layers;

	/**
	 * The default value of the '{@link #getLayerOperatorDescriptorName() <em>Layer Operator Descriptor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLayerOperatorDescriptorName()
	 * @generated
	 * @ordered
	 */
	protected static final String LAYER_OPERATOR_DESCRIPTOR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLayerOperatorDescriptorName() <em>Layer Operator Descriptor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLayerOperatorDescriptorName()
	 * @generated
	 * @ordered
	 */
	protected String layerOperatorDescriptorName = LAYER_OPERATOR_DESCRIPTOR_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLayerOperatorDescriptor() <em>Layer Operator Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLayerOperatorDescriptor()
	 * @generated
	 * @ordered
	 */
	protected LayerOperatorDescriptor layerOperatorDescriptor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected LayerOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.LAYER_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<LayerExpression> getLayers() {
		if (layers == null) {
			layers = new EObjectContainmentEList<LayerExpression>(LayerExpression.class, this, LayersPackage.LAYER_OPERATOR__LAYERS);
		}
		return layers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getLayerOperatorDescriptorName() {
		return layerOperatorDescriptorName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setLayerOperatorDescriptorName(String newLayerOperatorDescriptorName) {
		String oldLayerOperatorDescriptorName = layerOperatorDescriptorName;
		layerOperatorDescriptorName = newLayerOperatorDescriptorName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME, oldLayerOperatorDescriptorName, layerOperatorDescriptorName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public LayerOperatorDescriptor getLayerOperatorDescriptor() {
		if (layerOperatorDescriptor != null && layerOperatorDescriptor.eIsProxy()) {
			InternalEObject oldLayerOperatorDescriptor = (InternalEObject) layerOperatorDescriptor;
			layerOperatorDescriptor = (LayerOperatorDescriptor) eResolveProxy(oldLayerOperatorDescriptor);
			if (layerOperatorDescriptor != oldLayerOperatorDescriptor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LayersPackage.LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR, oldLayerOperatorDescriptor, layerOperatorDescriptor));
			}
		}
		return layerOperatorDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LayerOperatorDescriptor basicGetLayerOperatorDescriptor() {
		return layerOperatorDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setLayerOperatorDescriptor(LayerOperatorDescriptor newLayerOperatorDescriptor) {
		LayerOperatorDescriptor oldLayerOperatorDescriptor = layerOperatorDescriptor;
		layerOperatorDescriptor = newLayerOperatorDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR, oldLayerOperatorDescriptor, layerOperatorDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void addLayer(LayerExpression layer) {
		// getLayers().add(layer);
		// Add layer on top of the stack.
		getLayers().add(0, layer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isDescriptorSet() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void resetDescriptor() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case LayersPackage.LAYER_OPERATOR__LAYERS:
			return ((InternalEList<?>) getLayers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case LayersPackage.LAYER_OPERATOR__LAYERS:
			return getLayers();
		case LayersPackage.LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME:
			return getLayerOperatorDescriptorName();
		case LayersPackage.LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR:
			if (resolve)
				return getLayerOperatorDescriptor();
			return basicGetLayerOperatorDescriptor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case LayersPackage.LAYER_OPERATOR__LAYERS:
			getLayers().clear();
			getLayers().addAll((Collection<? extends LayerExpression>) newValue);
			return;
		case LayersPackage.LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME:
			setLayerOperatorDescriptorName((String) newValue);
			return;
		case LayersPackage.LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR:
			setLayerOperatorDescriptor((LayerOperatorDescriptor) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case LayersPackage.LAYER_OPERATOR__LAYERS:
			getLayers().clear();
			return;
		case LayersPackage.LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME:
			setLayerOperatorDescriptorName(LAYER_OPERATOR_DESCRIPTOR_NAME_EDEFAULT);
			return;
		case LayersPackage.LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR:
			setLayerOperatorDescriptor((LayerOperatorDescriptor) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case LayersPackage.LAYER_OPERATOR__LAYERS:
			return layers != null && !layers.isEmpty();
		case LayersPackage.LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME:
			return LAYER_OPERATOR_DESCRIPTOR_NAME_EDEFAULT == null ? layerOperatorDescriptorName != null : !LAYER_OPERATOR_DESCRIPTOR_NAME_EDEFAULT.equals(layerOperatorDescriptorName);
		case LayersPackage.LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR:
			return layerOperatorDescriptor != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == LayersContainer.class) {
			switch (baseOperationID) {
			case LayersPackage.LAYERS_CONTAINER___ADD_LAYER__LAYEREXPRESSION:
				return LayersPackage.LAYER_OPERATOR___ADD_LAYER__LAYEREXPRESSION;
			default:
				return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case LayersPackage.LAYER_OPERATOR___ADD_LAYER__LAYEREXPRESSION:
			addLayer((LayerExpression) arguments.get(0));
			return null;
		case LayersPackage.LAYER_OPERATOR___IS_DESCRIPTOR_SET:
			return isDescriptorSet();
		case LayersPackage.LAYER_OPERATOR___RESET_DESCRIPTOR:
			resetDescriptor();
			return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (layerOperatorDescriptorName: "); //$NON-NLS-1$
		result.append(layerOperatorDescriptorName);
		result.append(')');
		return result.toString();
	}


	/**
	 * Propagate the change to children
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl#setIsBranchEnabled(boolean)
	 *
	 * @param newIsBranchEnabled
	 * 
	 * @generated
	 */
	@Override
	public void setIsBranchEnabled(boolean newIsBranchEnabled) {
		// First, set the value.
		super.setIsBranchEnabled(newIsBranchEnabled);
		// Now, propagate
		boolean value = isBranchEnabled();
		for (LayerExpression layer : getLayers()) {
			layer.setIsBranchEnabled(value);
		}
	}

	/**
	 * Set the value then propagate to children nodes.
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl#setOwningLayersStack(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack)
	 *
	 * @param newOwningLayersStack
	 * 
	 * @generated
	 */
	@Override
	public void setOwningLayersStack(LayersStack newOwningLayersStack) {
		// Set the value
		super.setOwningLayersStack(newOwningLayersStack);
		// Now propagate to children
		LayersStack value = getOwningLayersStack();
		for (LayerExpression layer : getLayers()) {
			layer.setOwningLayersStack(value);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Start this element after its reloading by EMF
	 * This method is called recursively by the parent of this element.
	 *
	 * <!-- end-user-doc -->
	 *
	 * @throws LayersException
	 * @generated
	 */
	@Override
	public void attach() throws LayersException {
		// Try to attach this Layer
		super.attach();
		// attach children
		for (LayerExpression l : getLayers()) {
			l.attach();
		}
	}

	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl#detach()
	 *
	 * @throws LayersException
	 * @generated
	 */
	@Override
	public void detach() throws LayersException {
		// Detach this Layer
		super.detach();
		// detach children
		for (LayerExpression l : getLayers()) {
			l.detach();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @deprecated unless we need it again
	 * @generated
	 */
	@Deprecated
	@Override
	public void attachToLayersStack(LayersStack owningLayersStack) {

		// the owning stack
		setOwningLayersStack(owningLayersStack);

		// Ensure child is started, if any
		for (LayerExpression l : getLayers()) {
			l.attachToLayersStack(owningLayersStack);
		}

		// Start local behaviors
		startBehaviors();
	}

} // LayerOperatorImpl
