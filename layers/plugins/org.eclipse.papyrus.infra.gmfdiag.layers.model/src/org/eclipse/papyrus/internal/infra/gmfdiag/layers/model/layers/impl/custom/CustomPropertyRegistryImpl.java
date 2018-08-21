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

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeRegistry;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyRegistryImpl;

/**
 * @author QL238289
 *
 */
public class CustomPropertyRegistryImpl extends PropertyRegistryImpl {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	protected CustomPropertyRegistryImpl() {
		super();
		// initialie transient ref
		init();
	}

	/**
	 * Init the transient references
	 * Create the internal objects : TypeRegistry.
	 */
	protected void init() {
		// Create the TypeRegistry
		TypeRegistry typeRegistry = LayersFactory.eINSTANCE.createTypeRegistry();
		setTypeRegistry(typeRegistry);

		// Initialize the list of properties
		String[] properties = new String[] {
				"css", "CSSType", "",
				"cssHide", "CSSHideType", "",
		};

		for (int i = 0; i < properties.length; i += 3) {


			Property property = LayersFactory.eINSTANCE.createProperty();
			property.setName(properties[i]);
			Type propertyType = typeRegistry.getTypes().get(properties[i + 1]);
			property.setType(propertyType);
			// Create Default value
			String defaultValueStr = properties[i + 2];
			if (defaultValueStr != null && defaultValueStr.length() > 0) {
				TypeInstance defaultValue = propertyType.createInstance();
				defaultValue.setValueFromString(defaultValueStr);
				property.setDefaultValue(defaultValue);
			}

			addProperty(property);
			// getProperties().add(property);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public int getPropertiesCount() {
		return getProperties().size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public int getPropertyIndex(String propertyName) throws NotFoundException {

		if (propertyName == null) {
			throw new NotFoundException("Null not Allowed");
		}
		List<Property> props = getProperties();
		for (int i = 0; i < props.size(); i++) {
			if (propertyName.equals(props.get(i).getName())) {
				return i;
			}
		}

		// Not found
		throw new NotFoundException("No property found with name '" + propertyName + "'");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public Property getProperty(String propertyName) throws NotFoundException {

		int index = getPropertyIndex(propertyName);
		return getProperties().get(index);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public void addProperty(Property property) {

		// Check if the property already exist
		try {
			getProperty(property.getName());
			// Already exist ==> return
			return;
		} catch (NotFoundException e) {
			// ok
		}

		// set the index
		property.setIndex(getProperties().size());
		// Add the property
		getProperties().add(property);
	}

}
