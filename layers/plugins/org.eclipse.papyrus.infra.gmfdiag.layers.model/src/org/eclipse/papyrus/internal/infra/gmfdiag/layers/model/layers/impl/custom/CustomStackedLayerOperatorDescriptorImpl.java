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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StackedLayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StackedLayerOperatorDescriptorImpl;

/**
 * @author QL238289
 *
 */
public class CustomStackedLayerOperatorDescriptorImpl extends StackedLayerOperatorDescriptorImpl {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	protected CustomStackedLayerOperatorDescriptorImpl() {
		super();
		init();
	}

	/**
	 * Init the descriptor.
	 */
	private void init() {
		setName("StackedLayerOperator");

	}

	/**
	 * New instance creation counter.
	 */
	static int count = 0;

	/**
	 * Create the requested {@link StackedLayerOperator} and init it.
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorDescriptorImpl#createLayerOperator()
	 *
	 * @return
	 */
	@Override
	public LayerOperator createLayerOperator() {


		StackedLayerOperator layerOperator = LayersFactory.eINSTANCE.createStackedLayerOperator();
		layerOperator.setLayerOperatorDescriptor(this);
		layerOperator.setLayerOperatorDescriptorName(this.getName());
		layerOperator.setName(getName() + count++);

		return layerOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public List<PropertyOperator> getPropertyOperators() {
		if (propertyOperators == null) {
			propertyOperators = new EObjectResolvingEList<PropertyOperator>(PropertyOperator.class, this, LayersPackage.LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS) {
				// Allows double
				@Override
				protected boolean isUnique() {
					return false;
				}

			};
		}
		return propertyOperators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public PropertyOperator getPropertyOperator(Property property) throws NotFoundException {
		try {
			return getPropertyOperators().get(property.getIndex());
		} catch (IndexOutOfBoundsException e) {
			throw new NotFoundException("Can't find operator for property '" + property.getName() + "' at index " + property.getIndex());
		}
	}

	/**
	 * Set the operator at the property's index.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setPropertyOperator(Property property, PropertyOperator operator) {

		// Set the operator at the property's index.
		getPropertyOperators().set(property.getIndex(), operator);
	}

	/**
	 * Initialize all list indexed by Properties'index.
	 * Increase the actual list in order that they can contains the specified number of properties.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setPropertyCollectionSize(int size, PropertyOperator defaultPropertyOperator) {
		List<PropertyOperator> operators = getPropertyOperators();
		int actualSize = operators.size();
		// Check if we need to increase the size.
		if (actualSize >= size) {
			// do nothing
			return;
		}

		// Add missing elements
		for (int i = actualSize; i < size; i++) {
			operators.add(defaultPropertyOperator);
		}
	}
}
