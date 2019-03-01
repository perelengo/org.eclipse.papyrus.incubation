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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Comment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Review Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment#getBase_Comment <em>Base Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment#getSeverity <em>Severity</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.gitlight.reviewprofile.ReviewProfilePackage#getReviewComment()
 * @model
 * @generated
 */
public interface ReviewComment extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Comment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Comment</em>' reference.
	 * @see #setBase_Comment(Comment)
	 * @see org.eclipse.papyrus.gitlight.reviewprofile.ReviewProfilePackage#getReviewComment_Base_Comment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Comment getBase_Comment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment#getBase_Comment <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Comment</em>' reference.
	 * @see #getBase_Comment()
	 * @generated
	 */
	void setBase_Comment(Comment value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The default value is <code>"INFO"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.gitlight.reviewprofile.ReviewSeverity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.papyrus.gitlight.reviewprofile.ReviewSeverity
	 * @see #setSeverity(ReviewSeverity)
	 * @see org.eclipse.papyrus.gitlight.reviewprofile.ReviewProfilePackage#getReviewComment_Severity()
	 * @model default="INFO" required="true" ordered="false"
	 * @generated
	 */
	ReviewSeverity getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.papyrus.gitlight.reviewprofile.ReviewSeverity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(ReviewSeverity value);

} // ReviewComment
