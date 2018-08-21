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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyOperatorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyOperatorImpl#getClassname <em>Classname</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyOperatorImpl#getOperatorInstance <em>Operator Instance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyOperatorImpl#getClassBundleID <em>Class Bundle ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyOperatorImpl extends EObjectImpl implements PropertyOperator {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassname() <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassname()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassname() <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassname()
	 * @generated
	 * @ordered
	 */
	protected String classname = CLASSNAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOperatorInstance() <em>Operator Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorInstance()
	 * @generated
	 * @ordered
	 */
	protected PropertyOperator operatorInstance;

	/**
	 * The default value of the '{@link #getClassBundleID() <em>Class Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassBundleID()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_BUNDLE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassBundleID() <em>Class Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassBundleID()
	 * @generated
	 * @ordered
	 */
	protected String classBundleID = CLASS_BUNDLE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.PROPERTY_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.PROPERTY_OPERATOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClassname() {
		return classname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassname(String newClassname) {
		String oldClassname = classname;
		classname = newClassname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.PROPERTY_OPERATOR__CLASSNAME, oldClassname, classname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyOperator getOperatorInstance() {
		if (operatorInstance != null && operatorInstance.eIsProxy()) {
			InternalEObject oldOperatorInstance = (InternalEObject)operatorInstance;
			operatorInstance = (PropertyOperator)eResolveProxy(oldOperatorInstance);
			if (operatorInstance != oldOperatorInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LayersPackage.PROPERTY_OPERATOR__OPERATOR_INSTANCE, oldOperatorInstance, operatorInstance));
			}
		}
		return operatorInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyOperator basicGetOperatorInstance() {
		return operatorInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperatorInstance(PropertyOperator newOperatorInstance) {
		PropertyOperator oldOperatorInstance = operatorInstance;
		operatorInstance = newOperatorInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.PROPERTY_OPERATOR__OPERATOR_INSTANCE, oldOperatorInstance, operatorInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClassBundleID() {
		return classBundleID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassBundleID(String newClassBundleID) {
		String oldClassBundleID = classBundleID;
		classBundleID = newClassBundleID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.PROPERTY_OPERATOR__CLASS_BUNDLE_ID, oldClassBundleID, classBundleID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputePropertyValueCommand getComputePropertyValueCommand(List<ComputePropertyValueCommand> property) throws LayersException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void resetOperatorInstance() throws LayersException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersPackage.PROPERTY_OPERATOR__NAME:
				return getName();
			case LayersPackage.PROPERTY_OPERATOR__CLASSNAME:
				return getClassname();
			case LayersPackage.PROPERTY_OPERATOR__OPERATOR_INSTANCE:
				if (resolve) return getOperatorInstance();
				return basicGetOperatorInstance();
			case LayersPackage.PROPERTY_OPERATOR__CLASS_BUNDLE_ID:
				return getClassBundleID();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LayersPackage.PROPERTY_OPERATOR__NAME:
				setName((String)newValue);
				return;
			case LayersPackage.PROPERTY_OPERATOR__CLASSNAME:
				setClassname((String)newValue);
				return;
			case LayersPackage.PROPERTY_OPERATOR__OPERATOR_INSTANCE:
				setOperatorInstance((PropertyOperator)newValue);
				return;
			case LayersPackage.PROPERTY_OPERATOR__CLASS_BUNDLE_ID:
				setClassBundleID((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LayersPackage.PROPERTY_OPERATOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LayersPackage.PROPERTY_OPERATOR__CLASSNAME:
				setClassname(CLASSNAME_EDEFAULT);
				return;
			case LayersPackage.PROPERTY_OPERATOR__OPERATOR_INSTANCE:
				setOperatorInstance((PropertyOperator)null);
				return;
			case LayersPackage.PROPERTY_OPERATOR__CLASS_BUNDLE_ID:
				setClassBundleID(CLASS_BUNDLE_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LayersPackage.PROPERTY_OPERATOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LayersPackage.PROPERTY_OPERATOR__CLASSNAME:
				return CLASSNAME_EDEFAULT == null ? classname != null : !CLASSNAME_EDEFAULT.equals(classname);
			case LayersPackage.PROPERTY_OPERATOR__OPERATOR_INSTANCE:
				return operatorInstance != null;
			case LayersPackage.PROPERTY_OPERATOR__CLASS_BUNDLE_ID:
				return CLASS_BUNDLE_ID_EDEFAULT == null ? classBundleID != null : !CLASS_BUNDLE_ID_EDEFAULT.equals(classBundleID);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LayersPackage.PROPERTY_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__LIST:
				try {
					return getComputePropertyValueCommand((List<ComputePropertyValueCommand>)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.PROPERTY_OPERATOR___RESET_OPERATOR_INSTANCE:
				try {
					resetOperatorInstance();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", classname: "); //$NON-NLS-1$
		result.append(classname);
		result.append(", classBundleID: "); //$NON-NLS-1$
		result.append(classBundleID);
		result.append(')');
		return result.toString();
	}

} // PropertyOperatorImpl
