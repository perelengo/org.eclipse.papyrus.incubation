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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeRegistry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Registry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyRegistryImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyRegistryImpl#getTypeRegistry <em>Type Registry</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyRegistryImpl#getPropertiesCount <em>Properties Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyRegistryImpl extends EObjectImpl implements PropertyRegistry {
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

	/**
	 * The cached value of the '{@link #getTypeRegistry() <em>Type Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeRegistry()
	 * @generated
	 * @ordered
	 */
	protected TypeRegistry typeRegistry;

	/**
	 * The default value of the '{@link #getPropertiesCount() <em>Properties Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertiesCount()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTIES_COUNT_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyRegistryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.PROPERTY_REGISTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<Property>(Property.class, this, LayersPackage.PROPERTY_REGISTRY__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeRegistry getTypeRegistry() {
		return typeRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeRegistry(TypeRegistry newTypeRegistry, NotificationChain msgs) {
		TypeRegistry oldTypeRegistry = typeRegistry;
		typeRegistry = newTypeRegistry;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayersPackage.PROPERTY_REGISTRY__TYPE_REGISTRY, oldTypeRegistry, newTypeRegistry);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeRegistry(TypeRegistry newTypeRegistry) {
		if (newTypeRegistry != typeRegistry) {
			NotificationChain msgs = null;
			if (typeRegistry != null)
				msgs = ((InternalEObject)typeRegistry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayersPackage.PROPERTY_REGISTRY__TYPE_REGISTRY, null, msgs);
			if (newTypeRegistry != null)
				msgs = ((InternalEObject)newTypeRegistry).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LayersPackage.PROPERTY_REGISTRY__TYPE_REGISTRY, null, msgs);
			msgs = basicSetTypeRegistry(newTypeRegistry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.PROPERTY_REGISTRY__TYPE_REGISTRY, newTypeRegistry, newTypeRegistry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertiesCount() {
		// TODO: implement this method to return the 'Properties Count' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertyIndex(String propertyName) throws NotFoundException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProperty(String propertyName) throws NotFoundException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addProperty(Property property) {
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersPackage.PROPERTY_REGISTRY__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case LayersPackage.PROPERTY_REGISTRY__TYPE_REGISTRY:
				return basicSetTypeRegistry(null, msgs);
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
			case LayersPackage.PROPERTY_REGISTRY__PROPERTIES:
				return getProperties();
			case LayersPackage.PROPERTY_REGISTRY__TYPE_REGISTRY:
				return getTypeRegistry();
			case LayersPackage.PROPERTY_REGISTRY__PROPERTIES_COUNT:
				return getPropertiesCount();
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
			case LayersPackage.PROPERTY_REGISTRY__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case LayersPackage.PROPERTY_REGISTRY__TYPE_REGISTRY:
				setTypeRegistry((TypeRegistry)newValue);
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
			case LayersPackage.PROPERTY_REGISTRY__PROPERTIES:
				getProperties().clear();
				return;
			case LayersPackage.PROPERTY_REGISTRY__TYPE_REGISTRY:
				setTypeRegistry((TypeRegistry)null);
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
			case LayersPackage.PROPERTY_REGISTRY__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case LayersPackage.PROPERTY_REGISTRY__TYPE_REGISTRY:
				return typeRegistry != null;
			case LayersPackage.PROPERTY_REGISTRY__PROPERTIES_COUNT:
				return getPropertiesCount() != PROPERTIES_COUNT_EDEFAULT;
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
			case LayersPackage.PROPERTY_REGISTRY___GET_PROPERTY_INDEX__STRING:
				try {
					return getPropertyIndex((String)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.PROPERTY_REGISTRY___GET_PROPERTY__STRING:
				try {
					return getProperty((String)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.PROPERTY_REGISTRY___ADD_PROPERTY__PROPERTY:
				addProperty((Property)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //PropertyRegistryImpl
