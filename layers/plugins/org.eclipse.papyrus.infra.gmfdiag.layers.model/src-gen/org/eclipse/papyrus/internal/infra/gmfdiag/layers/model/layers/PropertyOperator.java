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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator#getClassname <em>Classname</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator#getOperatorInstance <em>Operator Instance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator#getClassBundleID <em>Class Bundle ID</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getPropertyOperator()
 * @model
 * @generated
 */
public interface PropertyOperator extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getPropertyOperator_Name()
	 * @model dataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classname</em>' attribute.
	 * @see #setClassname(String)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getPropertyOperator_Classname()
	 * @model dataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getClassname();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator#getClassname <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classname</em>' attribute.
	 * @see #getClassname()
	 * @generated
	 */
	void setClassname(String value);

	/**
	 * Returns the value of the '<em><b>Operator Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator Instance</em>' reference.
	 * @see #setOperatorInstance(PropertyOperator)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getPropertyOperator_OperatorInstance()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PropertyOperator getOperatorInstance();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator#getOperatorInstance <em>Operator Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator Instance</em>' reference.
	 * @see #getOperatorInstance()
	 * @generated
	 */
	void setOperatorInstance(PropertyOperator value);

	/**
	 * Returns the value of the '<em><b>Class Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Bundle ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Bundle ID</em>' attribute.
	 * @see #setClassBundleID(String)
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getPropertyOperator_ClassBundleID()
	 * @model dataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getClassBundleID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator#getClassBundleID <em>Class Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Bundle ID</em>' attribute.
	 * @see #getClassBundleID()
	 * @generated
	 */
	void setClassBundleID(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ComputePropertyValueCommand" required="true" ordered="false" exceptions="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersException" propertyDataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ComputePropertyValueCommand" propertyMany="true"
	 * @generated
	 */
	ComputePropertyValueCommand getComputePropertyValueCommand(List<ComputePropertyValueCommand> property) throws LayersException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersException"
	 * @generated
	 */
	void resetOperatorInstance() throws LayersException;

} // PropertyOperator
