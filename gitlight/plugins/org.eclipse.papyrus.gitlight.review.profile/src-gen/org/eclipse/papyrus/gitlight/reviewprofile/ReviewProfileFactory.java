/**
 * Copyright (c) 2019 CEA LIST, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.gitlight.reviewprofile;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.gitlight.reviewprofile.ReviewProfilePackage
 * @generated
 */
public interface ReviewProfileFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ReviewProfileFactory eINSTANCE = org.eclipse.papyrus.gitlight.reviewprofile.impl.ReviewProfileFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Review Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Review Comment</em>'.
	 * @generated
	 */
	ReviewComment createReviewComment();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ReviewProfilePackage getReviewProfilePackage();

} //ReviewProfileFactory
