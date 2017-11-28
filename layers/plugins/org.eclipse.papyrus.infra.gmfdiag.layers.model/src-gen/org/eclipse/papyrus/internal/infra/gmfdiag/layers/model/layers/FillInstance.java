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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fill Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillInstance#getTransparency <em>Transparency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillInstance#getFillColor <em>Fill Color</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getFillInstance()
 * @model
 * @generated
 */
public interface FillInstance extends TypeInstance {
	/**
	 * Returns the value of the '<em><b>Transparency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transparency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transparency</em>' attribute.
	 * @see #setTransparency(int)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getFillInstance_Transparency()
	 * @model dataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.int" required="true" ordered="false"
	 * @generated
	 */
	int getTransparency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillInstance#getTransparency <em>Transparency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transparency</em>' attribute.
	 * @see #getTransparency()
	 * @generated
	 */
	void setTransparency(int value);

	/**
	 * Returns the value of the '<em><b>Fill Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fill Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fill Color</em>' containment reference.
	 * @see #setFillColor(ColorInstance)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getFillInstance_FillColor()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ColorInstance getFillColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillInstance#getFillColor <em>Fill Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fill Color</em>' containment reference.
	 * @see #getFillColor()
	 * @generated
	 */
	void setFillColor(ColorInstance value);

} // FillInstance