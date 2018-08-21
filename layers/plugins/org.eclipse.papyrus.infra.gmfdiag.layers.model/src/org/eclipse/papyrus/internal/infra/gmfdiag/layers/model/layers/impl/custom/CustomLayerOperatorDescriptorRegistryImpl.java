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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorDescriptorRegistryImpl;

/**
 * @author QL238289
 *
 */
public class CustomLayerOperatorDescriptorRegistryImpl extends LayerOperatorDescriptorRegistryImpl {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	protected CustomLayerOperatorDescriptorRegistryImpl() {
		super();
		// Set the defaultOperator
		defaultOperator = LayersFactory.eINSTANCE.createPropertyOperator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public void setPropertyCollectionSize(int newPropertyCollectionSize) {
		int oldPropertyCollectionSize = propertyCollectionSize;
		propertyCollectionSize = newPropertyCollectionSize;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_COLLECTION_SIZE, oldPropertyCollectionSize, propertyCollectionSize));
		}

		// Propagate the size to registered LayerOperator
		if (newPropertyCollectionSize > oldPropertyCollectionSize) {
			for (LayerOperatorDescriptor descriptor : getDescriptors()) {
				descriptor.setPropertyCollectionSize(newPropertyCollectionSize, getDefaultOperator());
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public void addLayerOperatorDescriptor(LayerOperatorDescriptor descriptor) {

		// Ensure descriptor size
		descriptor.setPropertyCollectionSize(getPropertyCollectionSize(), getDefaultOperator());
		// Add descriptor
		getDescriptors().add(descriptor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public LayerOperatorDescriptor getLayerOperatorDescriptor(String name) throws NotFoundException {
		if (name == null) {
			throw new NotFoundException("Can't find LayerOperatorDescriptor for name 'null'.");
		}
		for (LayerOperatorDescriptor descriptor : getDescriptors()) {
			if (name.equals(descriptor.getName())) {
				return descriptor;
			}
		}
		// Not found
		throw new NotFoundException("Can't find LayerOperatorDescriptor for name '" + name + "'.");

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public void addPropertyOperator(PropertyOperator operator) {
		getPropertyOperators().add(operator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public PropertyOperator getPropertyOperator(String name) throws NotFoundException {

		if (name == null) {
			throw new NotFoundException("Can't find PropertyOperator for name 'null'.");
		}
		for (PropertyOperator op : getPropertyOperators()) {
			if (name.equals(op.getName())) {
				return op;
			}
		}
		// Not found
		throw new NotFoundException("Can't find PropertyOperator for name '" + name + "'.");

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @throws NotFoundException
	 */
	@Override
	public void attachOperatorToDescriptor(Property property, String operatorName, String layerDescriptorName) throws NotFoundException {

		// Ensure that PropertiesCollectionSize can contain the property index.
		if (getPropertyCollectionSize() <= property.getIndex()) {
			setPropertyCollectionSize(property.getIndex());
		}

		// Attach the operator to the LayerOperator
		PropertyOperator op = getPropertyOperator(operatorName);
		LayerOperatorDescriptor layerOp = getLayerOperatorDescriptor(layerDescriptorName);

		layerOp.setPropertyOperator(property, op);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public LayerOperator createLayerOperator(String layerOperatorID) throws LayersException {

		LayerOperatorDescriptor desc = getLayerOperatorDescriptor(layerOperatorID);

		LayerOperator newLayerOperator = desc.createLayerOperator();

		// newLayerOperator.setApplication();
		return newLayerOperator;
	}

}
