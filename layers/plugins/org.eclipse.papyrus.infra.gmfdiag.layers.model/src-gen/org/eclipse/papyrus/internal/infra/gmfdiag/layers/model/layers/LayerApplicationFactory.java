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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Application Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerApplicationFactory#getApplication <em>Application</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getLayerApplicationFactory()
 * @model
 * @generated
 */
public interface LayerApplicationFactory extends EObject {
	/**
	 * Returns the value of the '<em><b>Application</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getFactory <em>Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application</em>' container reference.
	 * @see #setApplication(LayersStackApplication)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getLayerApplicationFactory_Application()
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getFactory
	 * @model opposite="factory" ordered="false"
	 * @generated
	 */
	LayersStackApplication getApplication();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerApplicationFactory#getApplication <em>Application</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application</em>' container reference.
	 * @see #getApplication()
	 * @generated
	 */
	void setApplication(LayersStackApplication value);

} // LayerApplicationFactory
