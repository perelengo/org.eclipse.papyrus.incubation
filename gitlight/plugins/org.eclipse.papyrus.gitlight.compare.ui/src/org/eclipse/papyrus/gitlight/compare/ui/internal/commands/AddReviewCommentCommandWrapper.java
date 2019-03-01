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
package org.eclipse.papyrus.gitlight.compare.ui.internal.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.compare.CompareFactory;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ide.ui.internal.configuration.EMFCompareConfiguration;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.gitlight.compare.ui.PapyrusCompareUIPlugin;
import org.eclipse.papyrus.gitlight.compare.ui.contentmergeviewer.provider.PapyrusMergeViewerItem;
import org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This review comment command wrapper allows to wrap the accept or reject action with a review comment added to the added/removed/changed/moved element.
 */
@SuppressWarnings("restriction")
public class AddReviewCommentCommandWrapper extends CommandWrapper {

	/**
	 * The review comment to add.
	 */
	private ReviewComment reviewComment;

	/**
	 * The diff to manage.
	 */
	private PapyrusMergeViewerItem diff;

	/**
	 * The emf compare configuration to get the comparison (and also add the match difference of the review comment to add).
	 */
	private EMFCompareConfiguration config;

	/**
	 * The review command (we needed this one ad global variable to manage the undo).
	 */
	private AbstractTransactionalCommand reviewCommand;

	/**
	 * Constructor.
	 *
	 * @param command
	 *            The command to wrap.
	 * @param reviewComment
	 *            The review comment.
	 * @param diff
	 *            The diff to manage.
	 * @param config
	 *            The emf compare configuration.
	 */
	public AddReviewCommentCommandWrapper(final Command command, final ReviewComment reviewComment, final PapyrusMergeViewerItem diff, final EMFCompareConfiguration config) {
		super(command);
		this.reviewComment = reviewComment;
		this.diff = diff;
		this.config = config;
	}

	/**
	 * Create the review command and execute it after the wrapped command.
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.command.CommandWrapper#execute()
	 *
	 */
	@Override
	public void execute() {
		super.execute();

		if (null != reviewComment) {

			final List<Element> ownersCommentElement = getOwnersCommentElement(diff);
			if (null != ownersCommentElement && ownersCommentElement.size() == 2) {
				final Element leftOwnerCommentElement = ownersCommentElement.get(0);
				final Element rightOwnerCommentElement = ownersCommentElement.get(1);
				if (null != rightOwnerCommentElement && null != leftOwnerCommentElement) {

					// Copy the review comment for right tree if it is editable
					final ReviewComment copiedReviewComment = config.isRightEditable() ? EcoreUtil.copy(reviewComment) : null;
					if (null != copiedReviewComment) {
						final Comment copiedComment = EcoreUtil.copy(reviewComment.getBase_Comment());
						copiedReviewComment.setBase_Comment(copiedComment);
					}

					final TransactionalEditingDomain domain = retrieveTransactionalEditingDomain(leftOwnerCommentElement.getModel());

					// Get the editing domain
					if (null != domain) {

						reviewCommand = new AbstractTransactionalCommand(domain, getCommand().getLabel(), null) {

							@Override
							protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {

								// Annotate the owner comment element
								reviewComment.getBase_Comment().getAnnotatedElements().add(leftOwnerCommentElement);
								// Add the comment to its owner
								leftOwnerCommentElement.getOwnedComments().add(reviewComment.getBase_Comment());
								// Add the review comment stereotype to the resource
								leftOwnerCommentElement.eResource().getContents().add(reviewComment);

								if (null != copiedReviewComment) {
									// Annotate the owner comment element
									copiedReviewComment.getBase_Comment().getAnnotatedElements().add(rightOwnerCommentElement);
									// Add the comment to its owner
									rightOwnerCommentElement.getOwnedComments().add(copiedReviewComment.getBase_Comment());
									// Add the review comment stereotype to the resource
									rightOwnerCommentElement.eResource().getContents().add(copiedReviewComment);
								}
								return CommandResult.newOKCommandResult();
							}

							@Override
							public boolean canUndo() {
								return true;
							}

							@Override
							protected IStatus doUndo(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
								// Remove the review comment stereotype from the resource
								leftOwnerCommentElement.eResource().getContents().remove(reviewComment);
								// Remove the comment from its owner
								leftOwnerCommentElement.getOwnedComments().remove(reviewComment.getBase_Comment());

								if (null != copiedReviewComment) {
									// Remove the review comment stereotype from the resource
									rightOwnerCommentElement.eResource().getContents().remove(copiedReviewComment);
									// Remove the comment from its owner
									rightOwnerCommentElement.getOwnedComments().remove(copiedReviewComment.getBase_Comment());
								}

								return new Status(IStatus.OK, PapyrusCompareUIPlugin.PLUGIN_ID, ""); //$NON-NLS-1$
							}

							@Override
							public boolean canRedo() {
								return true;
							}

							@Override
							protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
								// Add the comment to its owner
								leftOwnerCommentElement.getOwnedComments().add(reviewComment.getBase_Comment());
								// Add the review comment stereotype to the resource
								leftOwnerCommentElement.eResource().getContents().add(reviewComment);

								if (null != copiedReviewComment) {
									// Add the comment to its owner
									rightOwnerCommentElement.getOwnedComments().add(copiedReviewComment.getBase_Comment());
									// Add the review comment stereotype to the resource
									rightOwnerCommentElement.eResource().getContents().add(copiedReviewComment);
								}

								return new Status(IStatus.OK, PapyrusCompareUIPlugin.PLUGIN_ID, ""); //$NON-NLS-1$
							}
						};
						try {
							reviewCommand.execute(new NullProgressMonitor(), null);
						} catch (ExecutionException e) {
							e.printStackTrace();
						}
					}

					final Match createdMatch = CompareFactory.eINSTANCE.createMatch();
					createdMatch.setLeft(reviewComment.getBase_Comment());
					createdMatch.setRight(null != copiedReviewComment ? copiedReviewComment.getBase_Comment() : null);
					createdMatch.setOrigin(reviewComment.getBase_Comment());
					config.getComparison().getMatches().add(createdMatch);
				}
			}
		}
	}

	/**
	 * Check that the command is not <code>null</code>.
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.command.CommandWrapper#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return true;
	}

	/**
	 * Undo the command.
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.command.CommandWrapper#undo()
	 */
	@Override
	public void undo() {
		super.undo();
		if (null != reviewCommand) {
			try {
				reviewCommand.undo(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void redo() {
		super.redo();
		if (null != reviewCommand) {
			try {
				reviewCommand.redo(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This allows to retrieve the transactional editing domain associated to the element.
	 * 
	 * @param element
	 *            the UML element.
	 * @return The transactional editing domain or <code>null</code>.
	 */
	private TransactionalEditingDomain retrieveTransactionalEditingDomain(final Element element) {
		TransactionalEditingDomain transactionalEditingDomain = TransactionUtil.getEditingDomain(element);
		if (transactionalEditingDomain == null) {
			final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(element);
			if (editingDomain instanceof TransactionalEditingDomain) {
				transactionalEditingDomain = (TransactionalEditingDomain) editingDomain;
			}
		}
		return transactionalEditingDomain;
	}

	/**
	 * This allows to get the owners (left and right) where add the review comment.
	 * 
	 * @param diff
	 *            The diff to manage.
	 * @return List of 2 elements of comments' owners (left and right) (can be empty).
	 */
	private List<Element> getOwnersCommentElement(final PapyrusMergeViewerItem diff) {
		List<Element> ownersCommentElement = new ArrayList<Element>(2);

		if (null != diff) {
			// Manage it differently if this is an DELETE because the object will not be added
			if (diff.getDiff().getKind().equals(DifferenceKind.ADD)) {
				ownersCommentElement = getParentOwnersCommentElementForAdd(diff);
				// If this is an ADD, we need to recalculate the re-created item
			} else if (diff.getDiff().getKind().equals(DifferenceKind.DELETE)) {

				final Object rightValue = diff.getSideValue(MergeViewerSide.RIGHT);
				if (rightValue instanceof Element) {
					final IMergeViewerItem existingMergeViewerItem = retrieveExistingPapyrusMergeViewerItem(diff);

					final Element leftValue = getElementByPath((Element) rightValue, existingMergeViewerItem);
					if (leftValue instanceof Element) {
						ownersCommentElement.add((Element) leftValue);
						ownersCommentElement.add((Element) rightValue);
					}
				}

			} else {
				// If this is a MOVE or a CHANGE, there is no problem
				final Object leftValue = diff.getSideValue(MergeViewerSide.LEFT);
				final Object rightValue = diff.getSideValue(MergeViewerSide.RIGHT);

				if (leftValue instanceof Element && rightValue instanceof Element) {
					ownersCommentElement.add((Element) leftValue);
					ownersCommentElement.add((Element) rightValue);
				}
			}
		}

		return ownersCommentElement;
	}

	/**
	 * This allows to get an element by its path (UML) from the left tree to the right one.
	 * 
	 * @param leftValue
	 *            The left value.
	 * @param existingMergeViewerItem
	 *            The viewer item where both of elements are same.
	 * @return The right found element corresponding to the left one.
	 */
	private Element getElementByPath(final Element rightValue, final IMergeViewerItem existingMergeViewerItem) {
		Element result = null;
		final Object parentLeftValue = existingMergeViewerItem.getSideValue(MergeViewerSide.LEFT);
		final Object parentRightValue = existingMergeViewerItem.getSideValue(MergeViewerSide.RIGHT);

		if (parentLeftValue instanceof Element && parentRightValue instanceof Element) {
			final TreeMap<String, String> path = new TreeMap<>();

			// Climb the right tree until found the parent
			EObject currentRightElement = rightValue;
			while (null != currentRightElement && !currentRightElement.equals(parentLeftValue)) {
				if (currentRightElement instanceof Comment) {
					path.put(((Comment) currentRightElement).getBody(), currentRightElement.getClass().getName());
				} else if (currentRightElement instanceof NamedElement) {
					path.put(((NamedElement) currentRightElement).getName(), currentRightElement.getClass().getName());
				}
				currentRightElement = currentRightElement.eContainer();
			}

			// Browse the left tree from the parent right to the correct element
			EObject currentLeftElement = (Element) parentRightValue;
			for (final Entry<String, String> entry : path.descendingMap().entrySet()) {
				if (currentLeftElement instanceof Element) {
					if (entry.getValue().equals(Comment.class.getName())) {
						final Iterator<Comment> comments = ((Element) currentLeftElement).getOwnedComments().iterator();
						boolean found = false;
						while (comments.hasNext() && !found) {
							final Comment nextComment = comments.next();
							if (nextComment.getBody().equals(entry.getKey())) {
								currentLeftElement = nextComment;
								found = true;
							}
						}
					} else {
						final Iterator<EObject> contents = currentLeftElement.eContents().iterator();
						boolean found = false;
						while (contents.hasNext() && !found) {
							final EObject nextContent = contents.next();
							if (nextContent.getClass().getName().equals(entry.getValue()) && nextContent instanceof NamedElement) {
								currentLeftElement = nextContent;
								found = true;
							}
						}
					}
				}
			}

			if (currentLeftElement instanceof Element && !currentLeftElement.equals(parentRightValue)) {
				result = (Element) currentLeftElement;
			}
		}

		return result;
	}

	/**
	 * This allows to get the parent of the diff for add to add the review comment to this one.
	 * 
	 * @param diff
	 *            The diff to manage.
	 * @return The parent element that is same for both side.
	 */
	private List<Element> getParentOwnersCommentElementForAdd(final PapyrusMergeViewerItem diff) {
		List<Element> ownersCommentElement = new ArrayList<Element>(2);

		if (null != diff) {
			final IMergeViewerItem papyrusParent = diff.getPapyrusParent();
			if (papyrusParent instanceof IMergeViewerItem) {
				final Object leftValue = diff.getSideValue(MergeViewerSide.LEFT);
				final Object rightValue = diff.getSideValue(MergeViewerSide.RIGHT);

				if ((null == leftValue || null == rightValue) && papyrusParent instanceof PapyrusMergeViewerItem) {
					ownersCommentElement = getParentOwnersCommentElementForAdd((PapyrusMergeViewerItem) papyrusParent);
				} else {
					ownersCommentElement.add((Element) leftValue);
					ownersCommentElement.add((Element) rightValue);
				}
			}
		}

		return ownersCommentElement;
	}

	/**
	 * This allows to retrieve the first upper merge viewer item where the element is the same for both side.
	 * 
	 * @param diff
	 *            The diff to manage.
	 * @return The first upper merge viewer item.
	 */
	private IMergeViewerItem retrieveExistingPapyrusMergeViewerItem(final IMergeViewerItem diff) {
		if (null != diff) {
			final Object leftValue = diff.getSideValue(MergeViewerSide.LEFT);
			final Object rightValue = diff.getSideValue(MergeViewerSide.LEFT);
			if (diff.getDiff() == null && leftValue.equals(rightValue)) {
				return diff;
			} else {
				final IMergeViewerItem papyrusParent = diff.getParent();
				if (papyrusParent instanceof IMergeViewerItem) {
					return retrieveExistingPapyrusMergeViewerItem(papyrusParent);
				}
			}
		}
		return null;
	}

}
