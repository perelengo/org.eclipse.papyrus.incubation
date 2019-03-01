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
package org.eclipse.papyrus.gitlight.reviewprofile.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment;
import org.eclipse.papyrus.gitlight.reviewprofile.ReviewProfileFactory;
import org.eclipse.papyrus.gitlight.reviewprofile.ReviewProfilePackage;
import org.eclipse.papyrus.gitlight.reviewprofile.ReviewSeverity;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReviewProfilePackageImpl extends EPackageImpl implements ReviewProfilePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reviewCommentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum reviewSeverityEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.gitlight.reviewprofile.ReviewProfilePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ReviewProfilePackageImpl() {
		super(eNS_URI, ReviewProfileFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ReviewProfilePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ReviewProfilePackage init() {
		if (isInited) return (ReviewProfilePackage)EPackage.Registry.INSTANCE.getEPackage(ReviewProfilePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredReviewProfilePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ReviewProfilePackageImpl theReviewProfilePackage = registeredReviewProfilePackage instanceof ReviewProfilePackageImpl ? (ReviewProfilePackageImpl)registeredReviewProfilePackage : new ReviewProfilePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theReviewProfilePackage.createPackageContents();

		// Initialize created meta-data
		theReviewProfilePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theReviewProfilePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ReviewProfilePackage.eNS_URI, theReviewProfilePackage);
		return theReviewProfilePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReviewComment() {
		return reviewCommentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReviewComment_Base_Comment() {
		return (EReference)reviewCommentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReviewComment_Severity() {
		return (EAttribute)reviewCommentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getReviewSeverity() {
		return reviewSeverityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReviewProfileFactory getReviewProfileFactory() {
		return (ReviewProfileFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		reviewCommentEClass = createEClass(REVIEW_COMMENT);
		createEReference(reviewCommentEClass, REVIEW_COMMENT__BASE_COMMENT);
		createEAttribute(reviewCommentEClass, REVIEW_COMMENT__SEVERITY);

		// Create enums
		reviewSeverityEEnum = createEEnum(REVIEW_SEVERITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(reviewCommentEClass, ReviewComment.class, "ReviewComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getReviewComment_Base_Comment(), theUMLPackage.getComment(), null, "base_Comment", null, 1, 1, ReviewComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getReviewComment_Severity(), this.getReviewSeverity(), "severity", "INFO", 1, 1, ReviewComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		// Initialize enums and add enum literals
		initEEnum(reviewSeverityEEnum, ReviewSeverity.class, "ReviewSeverity"); //$NON-NLS-1$
		addEEnumLiteral(reviewSeverityEEnum, ReviewSeverity.INFO);
		addEEnumLiteral(reviewSeverityEEnum, ReviewSeverity.WARNING);
		addEEnumLiteral(reviewSeverityEEnum, ReviewSeverity.ERROR);

		// Create resource
		createResource(eNS_URI);
	}

} //ReviewProfilePackageImpl
