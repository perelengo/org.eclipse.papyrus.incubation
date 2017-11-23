/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StackedLayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperatorDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Layer Operator Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TopLayerOperatorDescriptorImpl extends LayerOperatorDescriptorImpl implements TopLayerOperatorDescriptor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected TopLayerOperatorDescriptorImpl() {
		super();
		init();
	}

	/**
	 * Init the descriptor.
	 */
	private void init() {
		setName("TopLayerOperator");

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
	public AbstractLayerOperator createLayerOperator() {


		TopLayerOperator layerOperator = LayersFactory.eINSTANCE.createTopLayerOperator();
		layerOperator.setLayerOperatorDescriptor(this);
		layerOperator.setName(getName() + count++);

		return layerOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.TOP_LAYER_OPERATOR_DESCRIPTOR;
	}

} // TopLayerOperatorDescriptorImpl
