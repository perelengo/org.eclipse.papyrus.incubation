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
 * A representation of the model object '<em><b>Custom Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomType#getClassifier <em>Classifier</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getCustomType()
 * @model
 * @generated
 */
public interface CustomType extends Type {
	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier</em>' attribute.
	 * @see #setClassifier(String)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getCustomType_Classifier()
	 * @model dataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getClassifier();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomType#getClassifier <em>Classifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classifier</em>' attribute.
	 * @see #getClassifier()
	 * @generated
	 */
	void setClassifier(String value);

} // CustomType
