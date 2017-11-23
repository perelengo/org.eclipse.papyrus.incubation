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
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ColorInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Fill;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fill</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class FillImpl extends TypeImpl implements Fill {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected FillImpl() {
		super();
		setName("Fill");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public TypeInstance createInstance() {
		FillInstance instance = LayersFactory.eINSTANCE.createFillInstance();
		ColorInstance color = LayersFactory.eINSTANCE.createColorInstance();
		instance.setFillColor(color);
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.FILL;
	}

} // FillImpl
