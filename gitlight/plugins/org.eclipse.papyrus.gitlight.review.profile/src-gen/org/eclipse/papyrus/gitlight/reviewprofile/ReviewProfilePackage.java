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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.gitlight.reviewprofile.ReviewProfileFactory
 * @model kind="package"
 * @generated
 */
public interface ReviewProfilePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "reviewprofile";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/reviewprofile/0.1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "reviewprofile";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ReviewProfilePackage eINSTANCE = org.eclipse.papyrus.gitlight.reviewprofile.impl.ReviewProfilePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.gitlight.reviewprofile.impl.ReviewCommentImpl <em>Review Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.gitlight.reviewprofile.impl.ReviewCommentImpl
	 * @see org.eclipse.papyrus.gitlight.reviewprofile.impl.ReviewProfilePackageImpl#getReviewComment()
	 * @generated
	 */
	int REVIEW_COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVIEW_COMMENT__BASE_COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVIEW_COMMENT__SEVERITY = 1;

	/**
	 * The number of structural features of the '<em>Review Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVIEW_COMMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Review Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVIEW_COMMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.gitlight.reviewprofile.ReviewSeverity <em>Review Severity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.gitlight.reviewprofile.ReviewSeverity
	 * @see org.eclipse.papyrus.gitlight.reviewprofile.impl.ReviewProfilePackageImpl#getReviewSeverity()
	 * @generated
	 */
	int REVIEW_SEVERITY = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment <em>Review Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Review Comment</em>'.
	 * @see org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment
	 * @generated
	 */
	EClass getReviewComment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment#getBase_Comment()
	 * @see #getReviewComment()
	 * @generated
	 */
	EReference getReviewComment_Base_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment#getSeverity()
	 * @see #getReviewComment()
	 * @generated
	 */
	EAttribute getReviewComment_Severity();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.gitlight.reviewprofile.ReviewSeverity <em>Review Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Review Severity</em>'.
	 * @see org.eclipse.papyrus.gitlight.reviewprofile.ReviewSeverity
	 * @generated
	 */
	EEnum getReviewSeverity();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ReviewProfileFactory getReviewProfileFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.gitlight.reviewprofile.impl.ReviewCommentImpl <em>Review Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.gitlight.reviewprofile.impl.ReviewCommentImpl
		 * @see org.eclipse.papyrus.gitlight.reviewprofile.impl.ReviewProfilePackageImpl#getReviewComment()
		 * @generated
		 */
		EClass REVIEW_COMMENT = eINSTANCE.getReviewComment();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVIEW_COMMENT__BASE_COMMENT = eINSTANCE.getReviewComment_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVIEW_COMMENT__SEVERITY = eINSTANCE.getReviewComment_Severity();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.gitlight.reviewprofile.ReviewSeverity <em>Review Severity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.gitlight.reviewprofile.ReviewSeverity
		 * @see org.eclipse.papyrus.gitlight.reviewprofile.impl.ReviewProfilePackageImpl#getReviewSeverity()
		 * @generated
		 */
		EEnum REVIEW_SEVERITY = eINSTANCE.getReviewSeverity();

	}

} //ReviewProfilePackage
