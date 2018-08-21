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

package org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl.custom;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.ClassnameKind;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.configmodel.layersconfig.impl.OperatorConfigImpl;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.InstanciationException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceException;

/**
 * @author QL238289
 *
 */
public class CustomOperatorConfigImpl extends OperatorConfigImpl {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@Override
	public PropertyOperator createOperatorDescriptor() throws InstanciationException {

		switch (getClassnameKind()) {
		case UNDEFINED:
			// Try to find the exact type of classname
			PropertyOperator res;

			// Try as EMF instance
			try {
				res = createEmfInstance();
				setClassnameKind(ClassnameKind.EMF_CLASSNAME);
				return res;
			} catch (InstanciationException e) {
				// Not an EMF name. Try other solutions.
			} catch (ClassCastException e) {
				// specified class name is of wrong type
				setClassnameKind(ClassnameKind.NOT_FOUND);
				throw new InstanciationException("Can't create PropertyOperator for name '" + getClassname() + "'. Bad EMF type.");
			}

			// Try as java pojo
			try {
				res = createPojoInstance();
				setClassnameKind(ClassnameKind.POJO_CLASSNAME);
				return res;
			} catch (InstanciationException e) {
				setClassnameKind(ClassnameKind.NOT_FOUND);
				throw e;
			}


		case EMF_CLASSNAME:
			return createEmfInstance();

		case POJO_CLASSNAME:
			// Try to load a java class
			return createPojoInstance();


		case NOT_FOUND:
			// We already are in error. Do nothing

			break;

		default:
			break;
		}

		throw new InstanciationException("Can't create PropertyOperator for name '" + getClassname() + "'.");

	}

	/**
	 * @return
	 * @throws InstanciationException
	 * 
	 */
	@Override
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
	 */
	@Override
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
}
