/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.custom;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertySetterRegistryImpl;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.util.PropertyIndexedList;

/**
 * @author QL238289
 *
 */
public class CustomPropertySetterRegistryImpl extends PropertySetterRegistryImpl {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	protected CustomPropertySetterRegistryImpl() {
		super();
		init();
	}

	/**
	 * Initialize the registry with some setters
	 */
	protected void init() {
		addPropertySetter(LayersFactory.eINSTANCE.createCSSPropertySetter());
		addPropertySetter(LayersFactory.eINSTANCE.createCSSHidePropertySetter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public EList<PropertySetter> getPropertySetters() {
		// if (propertySetters == null) {
		// propertySetters = new EObjectResolvingEList<PropertySetter>(PropertySetter.class, this, LayersPackage.PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS);
		// }
		if (propertySetters == null) {
			propertySetters = new PropertyIndexedList<PropertySetter>(getSetterMap(), PropertySetter.class, this, LayersPackage.PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS, LayersPackage.PROPERTY_SETTER_REGISTRY__SETTER_MAP,
					LayersFactory.eINSTANCE.createNullPropertySetter());
		}
		return propertySetters;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public void setApplication(LayersStackApplication newApplication) {
		if (newApplication != eInternalContainer() || (eContainerFeatureID() != LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION && newApplication != null)) {
			if (EcoreUtil.isAncestor(this, newApplication)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newApplication != null) {
				msgs = ((InternalEObject) newApplication).eInverseAdd(this, LayersPackage.LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY, LayersStackApplication.class, msgs);
			}
			msgs = basicSetApplication(newApplication, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.PROPERTY_SETTER_REGISTRY__APPLICATION, newApplication, newApplication));
		}


		// update the list of PropertySetters
		if (newApplication != null) {
			List<Property> list = newApplication.getPropertyRegistry().getProperties();
			((PropertyIndexedList<PropertySetter>) getPropertySetters()).setPropertyList(list);
		}
		;

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public PropertySetter getPropertySetter(Property property) throws NotFoundException {

		try {
			return getPropertySetters().get(property.getIndex());
		} catch (IndexOutOfBoundsException e) {
			// Try by name
			PropertySetter setter = getPropertySetter(property.getName());
			if (setter != null) {
				return setter;
			}
			throw new NotFoundException("No setter found for property '" + property.getName() + "'");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public PropertySetter getPropertySetter(String property) throws NotFoundException {
		return getSetterMap().get(property);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public void addPropertySetter(PropertySetter setter) {

		String key = setter.getPropertyName();
		if (key == null || key.length() == 0) {
			throw new UnsupportedOperationException("Setter must have a valid name.");
		}

		getSetterMap().put(key, setter);
	}

}
