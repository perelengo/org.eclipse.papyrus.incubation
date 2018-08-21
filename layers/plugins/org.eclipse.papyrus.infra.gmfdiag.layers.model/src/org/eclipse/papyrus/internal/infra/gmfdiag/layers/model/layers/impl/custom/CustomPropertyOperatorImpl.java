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

import static org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.Activator.log;

import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyOperatorImpl;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceException;

/**
 * @author QL238289
 *
 */
public class CustomPropertyOperatorImpl extends PropertyOperatorImpl {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public void setClassname(String newClassname) {
		String oldClassname = classname;
		classname = newClassname;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.PROPERTY_OPERATOR__CLASSNAME, oldClassname, classname));
		}
		// Reset the actual instance
		setOperatorInstance(null);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public PropertyOperator getOperatorInstance() {
		if (operatorInstance == null) {
			try {
				resetOperatorInstance();
			} catch (LayersException e) {
				// TODO log the error
				log.error("LOG-" + this.getClass().getName()
						+ "- Can't set custom operator instance '" + e.getMessage() + "'.", e);

			}
		}

		return operatorInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @throws LayersException
	 */
	@Override
	public void resetOperatorInstance() throws LayersException {
		if (getClassname() == null) {
			return;
		}

		Class<?> opClass = loadClass();
		try {
			setOperatorInstance((PropertyOperator) opClass.newInstance());
		} catch (Exception e) {
			throw new LayersException("Can't create instance for CustomOperator " + getName(), e);
		}
	}

	/**
	 *
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyOperatorImpl#getComputePropertyValueCommand(org.eclipse.emf.common.util.EList)
	 *
	 * @param property
	 * @return
	 * @throws LayersException
	 */
	@Override
	public ComputePropertyValueCommand getComputePropertyValueCommand(List<ComputePropertyValueCommand> property) throws LayersException {
		return getOperatorInstance().getComputePropertyValueCommand(property);
	}

	/**
	 * Load the Class object. Try from current ClassLoader, then try using the
	 * plugin referenced in the serviceDescriptor.PluginId
	 *
	 * @return
	 * @throws ServiceException
	 */
	private Class<?> loadClass() throws LayersException {
		String classname = getClassname();
		Class<?> classDesc;
		try {
			classDesc = Class.forName(classname);
		} catch (ClassNotFoundException e1) {
			// Try using bundle
			try {
				String bundleID = getClassBundleID();
				Bundle bundle = Platform.getBundle(bundleID);
				classDesc = bundle.loadClass(classname);
			} catch (ClassNotFoundException e2) {
				throw new LayersException("Can't find class for the name '" + classname + "'.", e2);
			} catch (NullPointerException e) {
				throw new LayersException("Can't find bundle '" + getClassBundleID()
						+ "' for class for the name '" + classname + "'.", e);
			}
		}

		return classDesc;
	}

}
