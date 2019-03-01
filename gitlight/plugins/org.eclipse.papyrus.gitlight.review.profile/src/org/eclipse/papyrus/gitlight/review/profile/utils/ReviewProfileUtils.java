/*****************************************************************************
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
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gitlight.review.profile.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment;
import org.eclipse.papyrus.gitlight.reviewprofile.ReviewProfileFactory;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * The review profile utils methods.
 */
public class ReviewProfileUtils {

	/**
	 * This allows to create a review comment.
	 * 
	 * @return The created review comment.
	 */
	public static ReviewComment createReviewComment() {
		final ReviewComment createdReviewComment = ReviewProfileFactory.eINSTANCE.createReviewComment();
		final Comment createdComment = UMLFactory.eINSTANCE.createComment();
		createdReviewComment.setBase_Comment(createdComment);

		return createdReviewComment;
	}

	/**
	 * This allows to get the review comments representation of a model.
	 * 
	 * @param rootElement
	 *            The root element of the model.
	 * @return The review comments representation.
	 */
	public static String getModelReviewMessage(final Element rootElement) {
		final StringBuilder reviewMessage = new StringBuilder();

		// Search on resource contents to get stereotype applications
		for (final EObject content : rootElement.eResource().getContents()) {
			if (content instanceof ReviewComment) {
				if (reviewMessage.length() > 0) {
					reviewMessage.append("\n\n"); //$NON-NLS-1$
				}
				reviewMessage.append(((ReviewComment) content).getBase_Comment().getBody());
			}
		}

		return reviewMessage.toString();
	}

}
