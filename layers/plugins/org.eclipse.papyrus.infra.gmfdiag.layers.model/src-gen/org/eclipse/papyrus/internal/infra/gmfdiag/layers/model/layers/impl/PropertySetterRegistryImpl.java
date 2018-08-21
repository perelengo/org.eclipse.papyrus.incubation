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
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Setter Registry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertySetterRegistryImpl#getPropertySetters <em>Property Setters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertySetterRegistryImpl#getSetterMap <em>Setter Map</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertySetterRegistryImpl#getApplication <em>Application</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertySetterRegistryImpl extends EObjectImpl implements PropertySetterRegistry {
	/**
	 * The cached value of the '{@link #getPropertySetters() <em>Property Setters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertySetters()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertySetter> propertySetters;

	/**
	 * The cached value of the '{@link #getSetterMap() <em>Setter Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetterMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, PropertySetter> setterMap;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertySetterRegistryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.PROPERTY_SETTER_REGISTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<PropertySetter> getPropertySetters() {
		if (propertySetters == null) {
			propertySetters = new EObjectResolvingEList<PropertySetter>(PropertySetter.class, this, LayersPackage.PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS);
		}
		return propertySetters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, PropertySetter> getSetterMap() {
		if (setterMap == null) {
			setterMap = new EcoreEMap<String,PropertySetter>(LayersPackage.Literals.STRING_TO_PROPERTY_SETTER, StringToPropertySetterImpl.class, this, LayersPackage.PROPERTY_SETTER_REGISTRY__SETTER_MAP);
		}
		return setterMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersStackApplication getApplication() {
		if (eContainerFeatureID() != LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION) return null;
		return (LayersStackApplication)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplication(LayersStackApplication newApplication, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newApplication, LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplication(LayersStackApplication newApplication) {
		if (newApplication != eInternalContainer() || (eContainerFeatureID() != LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION && newApplication != null)) {
			if (EcoreUtil.isAncestor(this, newApplication))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newApplication != null)
				msgs = ((InternalEObject)newApplication).eInverseAdd(this, LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY, LayersStackApplication.class, msgs);
			msgs = basicSetApplication(newApplication, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION, newApplication, newApplication));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertySetter getPropertySetter(Property property) throws NotFoundException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertySetter getPropertySetter(String property) throws NotFoundException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addPropertySetter(PropertySetter setter) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetApplication((LayersStackApplication)otherEnd, msgs);
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
			case LayersPackage.PROPERTY_SETTER_REGISTRY__SETTER_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<String, PropertySetter>)getSetterMap()).eMap()).basicRemove(otherEnd, msgs);
			case LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION:
				return basicSetApplication(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION:
				return eInternalContainer().eInverseRemove(this, LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY, LayersStackApplication.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersPackage.PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS:
				return getPropertySetters();
			case LayersPackage.PROPERTY_SETTER_REGISTRY__SETTER_MAP:
				if (coreType) return ((EMap.InternalMapView<String, PropertySetter>)getSetterMap()).eMap();
				else return getSetterMap();
			case LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION:
				return getApplication();
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
			case LayersPackage.PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS:
				getPropertySetters().clear();
				getPropertySetters().addAll((Collection<? extends PropertySetter>)newValue);
				return;
			case LayersPackage.PROPERTY_SETTER_REGISTRY__SETTER_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<String, PropertySetter>)getSetterMap()).eMap()).set(newValue);
				return;
			case LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION:
				setApplication((LayersStackApplication)newValue);
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
			case LayersPackage.PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS:
				getPropertySetters().clear();
				return;
			case LayersPackage.PROPERTY_SETTER_REGISTRY__SETTER_MAP:
				getSetterMap().clear();
				return;
			case LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION:
				setApplication((LayersStackApplication)null);
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
			case LayersPackage.PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS:
				return propertySetters != null && !propertySetters.isEmpty();
			case LayersPackage.PROPERTY_SETTER_REGISTRY__SETTER_MAP:
				return setterMap != null && !setterMap.isEmpty();
			case LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION:
				return getApplication() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LayersPackage.PROPERTY_SETTER_REGISTRY___GET_PROPERTY_SETTER__PROPERTY:
				try {
					return getPropertySetter((Property)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.PROPERTY_SETTER_REGISTRY___GET_PROPERTY_SETTER__STRING:
				try {
					return getPropertySetter((String)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.PROPERTY_SETTER_REGISTRY___ADD_PROPERTY_SETTER__PROPERTYSETTER:
				addPropertySetter((PropertySetter)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //PropertySetterRegistryImpl
