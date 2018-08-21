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
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.ClassnameKind;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.LayersConfigPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.OperatorConfig;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.InstanciationException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class OperatorConfigImpl extends InstanciableElementImpl implements OperatorConfig {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OperatorConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersConfigPackage.Literals.OPERATOR_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public PropertyOperator createOperatorDescriptor() throws InstanciationException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case LayersConfigPackage.OPERATOR_CONFIG___CREATE_OPERATOR_DESCRIPTOR:
			try {
				return createOperatorDescriptor();
			} catch (Throwable throwable) {
				throw new InvocationTargetException(throwable);
			}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * @return
	 * @throws InstanciationException
	 * 
	 * @generated
	 */
	protected PropertyOperator createPojoInstance() throws InstanciationException {
		try {
			Class<?> opClass = loadClass();
			PropertyOperator operator = LayersFactory.eINSTANCE.createPropertyOperator();
			operator.setOperatorInstance((PropertyOperator) opClass.newInstance());
			operator.setName(getName());

			return operator;
		} catch (Exception e) {
			setClassnameKind(ClassnameKind.NOT_FOUND);
			throw new InstanciationException("Can't create PropertyOperator for name '" + getClassname() + "'. " + e.getMessage());
		}
	}

	/**
	 * Create an EMF instance from the classname.
	 *
	 * @return
	 * @throws InstanciationException
	 * 
	 * @generated
	 */
	protected PropertyOperator createEmfInstance() throws InstanciationException {
		// Try to load an EMF type
		EClassifier classifier = LayersPackage.eINSTANCE.getEClassifier(getClassname());
		if (classifier == null) {
			throw new InstanciationException("Can't create PropertyOperator for name '" + getClassname() + "'. Bad classname.");
		}
		PropertyOperator res;
		try {
			res = (PropertyOperator) LayersFactory.eINSTANCE.create((EClass) classifier);
		} catch (ClassCastException e) {
			// specified class name is of
			throw new InstanciationException("Can't create PropertyOperator for name '" + getClassname() + "'. Bad type.");
		}
		return res;
	}

	/**
	 * Load the Class object. Try from current ClassLoader, then try using the
	 * plugin referenced in the serviceDescriptor.PluginId
	 *
	 * @return
	 * @throws ServiceException
	 * 
	 * @generated
	 */
	private Class<?> loadClass() throws LayersException {
		String classname = getClassname();
		Class<?> classDesc;
		try {
			classDesc = Class.forName(classname);
		} catch (ClassNotFoundException e1) {
			// Try using bundle
			try {
				String bundleID = getBundleID();
				Bundle bundle = Platform.getBundle(bundleID);
				classDesc = bundle.loadClass(classname);
			} catch (ClassNotFoundException e2) {
				throw new LayersException("Can't find class for the name '" + classname + "'.", e2);
			} catch (NullPointerException e) {
				throw new LayersException("Can't find bundle '" + getBundleID()
						+ "' for class for the name '" + classname + "'.", e);
			}
		}

		return classDesc;
	}



} // OperatorConfigImpl
