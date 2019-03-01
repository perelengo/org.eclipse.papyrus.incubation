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
package org.eclipse.papyrus.gitlight.compare.ui.contentmergeviewer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.compare.INavigatable;
import org.eclipse.compare.internal.Utilities;
import org.eclipse.compare.internal.ViewerSwitchingCancelled;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.command.ICompareCommandStack;
import org.eclipse.emf.compare.command.ICompareCopyCommand;
import org.eclipse.emf.compare.domain.ICompareEditingDomain;
import org.eclipse.emf.compare.domain.IMergeRunnable;
import org.eclipse.emf.compare.ide.ui.internal.configuration.EMFCompareConfiguration;
import org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.tree.TreeContentMergeViewer;
import org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.tree.provider.DelegatingTreeMergeViewerItemContentProvider;
import org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.tree.provider.MergeViewerItemProviderConfiguration;
import org.eclipse.emf.compare.ide.ui.internal.structuremergeviewer.actions.MergeAction;
import org.eclipse.emf.compare.internal.merge.MergeMode;
import org.eclipse.emf.compare.merge.IMerger;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractMergeViewer;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeMergeViewer.ElementComparer;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.TreeMergeViewer;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider.IMergeViewerItemProviderConfiguration;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.gitlight.compare.ui.PapyrusCompareUIPlugin;
import org.eclipse.papyrus.gitlight.compare.ui.contentmergeviewer.facet.PapyrusFacetContentProviderWrapperAdapterFactory;
import org.eclipse.papyrus.gitlight.compare.ui.contentmergeviewer.provider.PapyrusMergeViewerItem;
import org.eclipse.papyrus.gitlight.compare.ui.contentmergeviewer.provider.PapyrusTreeContentMergeViewerItemLabelProvider;
import org.eclipse.papyrus.gitlight.compare.ui.internal.commands.AddReviewCommentCommandWrapper;
import org.eclipse.papyrus.gitlight.compare.ui.internal.commands.CompoundCompareCommand;
import org.eclipse.papyrus.gitlight.compare.ui.internal.commands.PapyrusCompareCopyCommand;
import org.eclipse.papyrus.gitlight.compare.ui.internal.commands.RemoveDiffCommand;
import org.eclipse.papyrus.gitlight.review.profile.utils.ReviewProfileUtils;
import org.eclipse.papyrus.gitlight.review.ui.dialogs.ReviewCommentDialog;
import org.eclipse.papyrus.gitlight.reviewprofile.ReviewComment;
import org.eclipse.papyrus.gitlight.reviewprofile.ReviewSeverity;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.properties.ui.runtime.PropertiesRuntime;
import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Specialized Tree Content Merge Viewer for Papyrus.
 */
@SuppressWarnings("restriction")
public class PapyrusTreeContentMergeViewer extends TreeContentMergeViewer {

	/**
	 * Since Papyrus trees could in theory be infinite, we need a maximum search level.
	 */
	private static final int MAX_SEARCH_LEVEL = 20;

	/**
	 * Atomic boolean to manage the sync of selection.
	 */
	private AtomicBoolean syncingSelections;

	/**
	 * Map of objects to {@link PapyrusContentProviderMergeViewerItem Papyrus merge viewer items} used when changing the selection in order to find the merge viewer item to be selected when a specific object (model element or diff) is to be revealed.
	 */
	private Map<Object, IMergeViewerItem> cachedMapForSelection;

	/**
	 * A queue of computations for computing the content tree items in the {@linked #getLeftMergeViewer() right merge viewer}.
	 */
	private LinkedList<AbstractContentFunction> leftContentComputations;

	/**
	 * A queue of computations for computing the content tree items in the {@linked #getRightMergeViewer() left merge viewer}.
	 */
	private LinkedList<AbstractContentFunction> rightContentComputations;

	/**
	 * The accept action contribution item.
	 */
	private ActionContributionItem acceptAction;

	/**
	 * The reject action contribution item.
	 */
	private ActionContributionItem rejectAction;

	/**
	 * The next action contribution item.
	 */
	private ActionContributionItem nextAction;

	/**
	 * The previous action contribution item.
	 */
	private ActionContributionItem previousAction;

	/**
	 * The papyrus command category identifier
	 */
	private static final String PAPYRUS_CATEGORY = "Papyrus"; //$NON-NLS-1$

	/**
	 * The papyrus merge viewer items corresponding to the differences.
	 */
	private List<PapyrusMergeViewerItem> papyrusMergeViewerItems;

	/**
	 * This allows to store the current difference (to manage correctly the next and previous selection)
	 */
	protected PapyrusMergeViewerItem currentDiff = null;

	/**
	 * The adapter factory content provider for the property view when this one is an ExtendedPropertySheetPage.
	 */
	private AdapterFactoryContentProvider adapterFactoryContentProvider;

	/**
	 * Constructor.
	 * 
	 * @param style
	 *            The style parameter.
	 * @param bundle
	 *            The {@link ResourceBundle}.
	 * @param parent
	 *            The {@link Composite} parent.
	 * @param config
	 *            The {@link EMFCompareConfiguration}.
	 */
	public PapyrusTreeContentMergeViewer(final int style, final ResourceBundle bundle, final Composite parent, final EMFCompareConfiguration config) {
		super(style, bundle, parent, config);

		// This is needed to load the different elements for papyrus properties view
		PropertiesRuntime.getConfigurationManager();

		AdapterFactory currentAdapterFactory = getCompareConfiguration().getAdapterFactory();
		if (null != currentAdapterFactory) {
			adapterFactoryContentProvider = new AdapterFactoryContentProvider(currentAdapterFactory);
		}

		// Manage a selection change listener for the left and right merge tree viewer
		getLeftMergeViewer().addSelectionChangedListener(event -> updateToolBarForSelection(event));
		getRightMergeViewer().addSelectionChangedListener(event -> updateToolBarForSelection(null));
	}

	/**
	 * This allows to get the index of the diff containned in the list of papyrus merge viewer items.
	 * 
	 * @param diff
	 *            The diff to search.
	 * @return The index of the diff or -1 if not found.
	 */
	private int getDiffIndex(final Diff diff) {
		return IntStream.range(0, papyrusMergeViewerItems.size()).filter(index -> {
			PapyrusMergeViewerItem item = papyrusMergeViewerItems.get(index);
			return null != item ? diff.equals(papyrusMergeViewerItems.get(index).getDiff()) : false;
		}).findFirst().getAsInt();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.EMFCompareContentMergeViewer#createMergeViewer(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected AbstractMergeViewer createMergeViewer(final Composite parent, final MergeViewerSide side) {
		final TreeMergeViewer mergeTreeViewer = new TreeMergeViewer(parent, side, this, getCompareConfiguration()) {
			@Override
			protected IAction createAction(MergeMode mode, Diff diff) {
				return new MergeAction(getCompareConfiguration(), EMFCompareRCPPlugin.getDefault().getMergerRegistry(), mode, null, new StructuredSelection(diff));
			}
		};

		final IContentProvider contentProvider = createMergeViewerContentProvider(side);
		mergeTreeViewer.setContentProvider(contentProvider);

		final IBaseLabelProvider labelProvider = new PapyrusTreeContentMergeViewerItemLabelProvider(getResourceBundle(), getAdapterFactory(), side);
		mergeTreeViewer.setLabelProvider(labelProvider);

		hookListeners(mergeTreeViewer);

		return mergeTreeViewer;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.tree.TreeContentMergeViewer#createMergeViewerItemProviderConfiguration(org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide)
	 */
	@Override
	protected IMergeViewerItemProviderConfiguration createMergeViewerItemProviderConfiguration(final MergeViewerSide side) {
		ComposedAdapterFactory factory = new ComposedAdapterFactory(new AdapterFactory[] { new PapyrusFacetContentProviderWrapperAdapterFactory(), getAdapterFactory(), });
		return new MergeViewerItemProviderConfiguration(factory, getDifferenceGroupProvider(), getDifferenceFilterPredicate(), getCompareConfiguration().getComparison(), side);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.EMFCompareContentMergeViewer#updateContent(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	protected void updateContent(final Object ancestor, Object left, final Object right) {
		// Modify selection so it works with the Papyrus Merge Viewer Items

		// first check whether the input on any side has changed
		if (isDifferentInput(MergeViewerSide.LEFT, left) || isDifferentInput(MergeViewerSide.RIGHT, right)) {
			getAncestorMergeViewer().setInput(ancestor);
			getLeftMergeViewer().setInput(left);
			getRightMergeViewer().setInput(right);

			leftContentComputations = null;
			rightContentComputations = null;
			cachedMapForSelection = null;
		} else {
			getLeftMergeViewer().refresh();
			getRightMergeViewer().refresh();
		}

		// Get the papyrus merge viewer items of the right tree viewer
		if (null == papyrusMergeViewerItems && getLeftMergeViewer().getContentProvider() instanceof DelegatingTreeMergeViewerItemContentProvider) {

			if (left instanceof ICompareAccessor) {
				final IMergeViewerItem initialItem = ((ICompareAccessor) left).getInitialItem();
				final Object root = getRootItem(initialItem, MergeViewerSide.LEFT);
				final Object rootInput = null != root ? root : initialItem;

				final DelegatingTreeMergeViewerItemContentProvider contentProvider = (DelegatingTreeMergeViewerItemContentProvider) getLeftMergeViewer().getContentProvider();
				papyrusMergeViewerItems = getDiffPapyrusMergeViewerItems(rootInput, contentProvider);
			} else {
				papyrusMergeViewerItems = null;
			}
		}

		// Set the first diff
		if (null == currentDiff) {

			final IMergeViewerItem leftInitialItem = left instanceof ICompareAccessor ? ((ICompareAccessor) left).getInitialItem() : null;

			// This first lines allowed to initialize the cached map
			// Bug 458818: In some cases, the left initial item is null because the item that should be selected has been deleted on the right and this delete is part of a conflict
			if (leftInitialItem == null || leftInitialItem.getLeft() == null) {
				if (right instanceof ICompareAccessor) {
					IMergeViewerItem rightInitialItem = ((ICompareAccessor) right).getInitialItem();
					if (rightInitialItem == null) {
						getLeftMergeViewer().setSelection(StructuredSelection.EMPTY, true);
					} else {
						setSelection((ICompareAccessor) right);
					}
				} else {
					// Strange case: left is an ICompareAccessor but right is not?
					getLeftMergeViewer().setSelection(StructuredSelection.EMPTY, true);
				}
			} else {
				// others will synchronize on this one :)
				setSelection((ICompareAccessor) left);
			}

			if (null != papyrusMergeViewerItems && !papyrusMergeViewerItems.isEmpty()) {
				setCurrentDiff(papyrusMergeViewerItems.get(0));
			}
		}

		redrawCenterControl();
	}

	/**
	 * Check whether the given input is an instance of {@link ICompareAccessor}.
	 * 
	 * @param input
	 *            The given input to check.
	 * @return {@code true}, if the input is an instance of {@link ICompareAccessor}, {@code false} otherwise.
	 */
	private static boolean isCompareAccessor(final Object input) {
		return input instanceof ICompareAccessor;
	}

	/**
	 * Check whether the current input of the given side differs from the given one.
	 * 
	 * @param side
	 *            The side to be checked, either {@link MergeViewerSide#LEFT} or {@link MergeViewerSide#RIGHT}.
	 * @param input
	 *            The input to check against.
	 * @return {@code true}, if the input is different, {@code false} otherwise
	 */
	private boolean isDifferentInput(final MergeViewerSide side, final Object input) {
		TreeMergeViewer viewer = getMergeViewer(side);
		if (!isCompareAccessor(input) || !isCompareAccessor(viewer.getInput())) {
			return true;
		}
		ImmutableList<? extends IMergeViewerItem> inputItems = ICompareAccessor.class.cast(input).getItems();
		ImmutableList<? extends IMergeViewerItem> vieweritems = ICompareAccessor.class.cast(viewer.getInput()).getItems();
		if (inputItems.size() != vieweritems.size()) {
			return true;
		}
		ElementComparer comparer = new ElementComparer();
		for (int i = 0; i < vieweritems.size(); i++) {
			if (!comparer.equals(inputItems.get(i), vieweritems.get(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the {@link TreeMergeViewer} of the given side.
	 * 
	 * @param side
	 *            The side for which to return the {@link TreeMergeViewer}.
	 * @return the {@link TreeMergeViewer} of the respective side
	 */
	public TreeMergeViewer getMergeViewer(final MergeViewerSide side) {
		if (side == MergeViewerSide.LEFT) {
			return getLeftMergeViewer();
		} else if (side == MergeViewerSide.RIGHT) {
			return getRightMergeViewer();
		}
		return getAncestorMergeViewer();
	}

	/**
	 * This allows to initialize graphically the action.
	 * 
	 * @param action
	 *            The action to initialize.
	 * @param bundle
	 *            The current bundle.
	 * @param actionName
	 *            The name of the action.
	 * @param tooltip
	 *            The tooltip of the action.
	 * @param description
	 *            The description of the action.
	 */
	private void initGraphicalAction(final IAction action, final ResourceBundle bundle, final String actionName, final String tooltip, final String description) {
		action.setText(actionName);
		action.setToolTipText(tooltip);
		action.setDescription(description);

		final String path = "resources/icons/" + actionName + ".png"; //$NON-NLS-1$ //$NON-NLS-2$
		final ImageDescriptor imageDescriptor = PapyrusCompareUIPlugin.imageDescriptorFromPlugin(PapyrusCompareUIPlugin.PLUGIN_ID, path);
		if (null != imageDescriptor) {
			action.setImageDescriptor(imageDescriptor);
			action.setHoverImageDescriptor(imageDescriptor);
		}
	}

	/**
	 * This allows to create the merge action (left to right, right to left, accept or reject).
	 * 
	 * @param mergeMode
	 *            The merge mode (left to right, right to left, accept or reject).
	 * @param cc
	 *            The compare configuration.
	 * @param nav
	 *            The navigatable (can be <code>null</code>).
	 * @return The created merge action.
	 */
	private MergeAction createMergeAction(final MergeMode mergeMode, final EMFCompareConfiguration cc, final INavigatable nav) {
		IMerger.Registry mergerRegistry = EMFCompareRCPPlugin.getDefault().getMergerRegistry();
		MergeAction mergeAction = new MergeAction(cc, mergerRegistry, mergeMode, nav) {
			@Override
			protected Iterable<Diff> getSelectedDifferences(final IStructuredSelection selection) {
				final List<?> selectedObjects = selection.toList();
				final List<PapyrusMergeViewerItem> papyrusItems = selectedObjects.stream().filter(item -> item instanceof PapyrusMergeViewerItem).map(item -> (PapyrusMergeViewerItem) item).collect(Collectors.toList());
				Iterable<Diff> diffs = papyrusItems.stream().map(item -> item.getDiff()).collect(Collectors.toList());
				if (Iterables.isEmpty(diffs)) {
					diffs = Iterables.filter(selectedObjects, Diff.class);
				}
				return getSelectedDifferences(diffs);
			}

			@Override
			public void run() {
				int diffIndex = -1;
				if (null != papyrusMergeViewerItems && !papyrusMergeViewerItems.isEmpty() && null != currentDiff) {
					diffIndex = getDiffIndex(currentDiff.getDiff());
				}

				super.run();

				if (continueProcess) {
					// Manage the next selection (if this is not the last) or the previous if possible
					if (diffIndex >= 0 && (diffIndex < papyrusMergeViewerItems.size() || diffIndex > 0)) {
						selectDiffByIndex(diffIndex);
					} else {
						// If there is no next or previous diff, select the same
						selectDiff(currentDiff);
					}
				}
			}

			private boolean continueProcess = true;;

			@Override
			protected void execute(final ICompareCommandStack commandStack, final MergeMode mode, final List<Diff> diffs) {

				final CompoundCompareCommand command = new CompoundCompareCommand();

				continueProcess = true;
				ReviewComment createdReviewComment = null;

				// We this is a reject action, we need to comment the reject with a message
				if (getSelectedMode() == MergeMode.RIGHT_TO_LEFT || getSelectedMode() == MergeMode.REJECT) {
					createdReviewComment = ReviewProfileUtils.createReviewComment();
					createdReviewComment.setSeverity(ReviewSeverity.ERROR);

					// Open the dialog of the comment
					final ReviewCommentDialog dialog = new ReviewCommentDialog(getControl().getShell(), createdReviewComment);
					continueProcess = dialog.open() == Window.OK;

					// If this is a delete, the element will be removed (and we need to add something to comment's body to specify the deleted element).
					if (continueProcess) {
						updateCommentBody(createdReviewComment, currentDiff);
					}
				}

				if (continueProcess) {
					final IMergeRunnable runnable = createMergeRunnable(mode, isLeftEditable(), isRightEditable(), getDiffRelationshipComputer());
					final ICompareCopyCommand compareCopyCommand = editingDomain.createCopyCommand(diffs, mode.isLeftToRight(isLeftEditable(), isRightEditable()), mergerRegistry, runnable);

					IMergeViewerItem parentViewerItem = retrieveExistingPapyrusMergeViewerItem(currentDiff);
					Object leftValue = parentViewerItem.getSideValue(MergeViewerSide.LEFT);
					if (leftValue instanceof Element) {
						final TransactionalEditingDomain domain = retrieveTransactionalEditingDomain(((Element) leftValue).getModel());

						// Manage the remove of the diff from the papyrus items
						final Command transactionalCommand = GMFtoEMFCommandWrapper.wrap(new PapyrusCompareCopyCommand(domain, compareCopyCommand));
						command.append(new AddReviewCommentCommandWrapper(transactionalCommand, createdReviewComment, currentDiff, getCompareConfiguration()));
						command.append(new RemoveDiffCommand(papyrusMergeViewerItems, currentDiff));
						commandStack.execute(command);

						if (!isLeftDirty()) {
							setLeftDirty(true);
						}

						getLeftMergeViewer().refresh();
						getRightMergeViewer().refresh();
					}
				}
			}


		};
		if (mergeMode == MergeMode.RIGHT_TO_LEFT || mergeMode == MergeMode.REJECT) {
			mergeAction.setActionDefinitionId("org.eclipse.compare.copyRightToLeft"); //$NON-NLS-1$
		} else {
			mergeAction.setActionDefinitionId("org.eclipse.compare.copyLeftToRight"); //$NON-NLS-1$
		}
		return mergeAction;
	}

	/**
	 * This allows to update the comment body of a reject.
	 * 
	 * @param reviewComment
	 *            The review comment to modify.
	 * @param diff
	 *            The diff to manage.
	 */
	protected void updateCommentBody(final ReviewComment reviewComment, final PapyrusMergeViewerItem diff) {
		Object itemValue = diff.getSideValue(MergeViewerSide.LEFT);
		if (null == itemValue) {
			itemValue = diff.getSideValue(MergeViewerSide.RIGHT);
		}

		if (itemValue instanceof Element) {
			final StringBuilder commentBody = new StringBuilder();
			String identifier = "<Unknown>"; //$NON-NLS-1$
			if (itemValue instanceof NamedElement) {
				identifier = UMLLabelInternationalization.getInstance().getLabel((NamedElement) itemValue);
			} else if (itemValue instanceof Comment) {
				final EObject parent = ((Comment) itemValue).eContainer();
				if (parent instanceof NamedElement) {
					identifier = "comment of '" + UMLLabelInternationalization.getInstance().getLabel((NamedElement) itemValue) + "'"; //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
			commentBody.append("Modification of '" + identifier + "' rejected."); //$NON-NLS-1$ //$NON-NLS-2$
			commentBody.append("\n"); //$NON-NLS-1$
			commentBody.append("Reason: "); //$NON-NLS-1$
			if (null != reviewComment.getBase_Comment().getBody()) {
				commentBody.append(reviewComment.getBase_Comment().getBody());
			}

			reviewComment.getBase_Comment().setBody(commentBody.toString());
		}
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
			if (diff.getDiff() == null && leftValue instanceof Element) {
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

	/**
	 * This allows to retrieve the transactional editing domain associated to the element.
	 * 
	 * @param element
	 *            the UML element.
	 * @return The transactional editing domain or <code>null</code>.
	 */
	private TransactionalEditingDomain retrieveTransactionalEditingDomain(final Element element) {
		TransactionalEditingDomain transactionalEditingDomain = TransactionUtil.getEditingDomain(element);
		if (null == transactionalEditingDomain) {
			final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(element);
			if (editingDomain instanceof TransactionalEditingDomain) {
				transactionalEditingDomain = (TransactionalEditingDomain) editingDomain;
			}
		}
		return transactionalEditingDomain;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		synchronizeSelection(event);
		updateToolItems();
	}

	/**
	 * This allows to synchronize the selection.
	 * 
	 * @param event
	 *            the selection change event.
	 */
	private void synchronizeSelection(final SelectionChangedEvent event) {
		if (null == syncingSelections) {
			syncingSelections = new AtomicBoolean(false);
		}
		if (syncingSelections.compareAndSet(false, true)) { // prevents stack overflow
			try {
				final ISelection selection = event.getSelection();
				updatePropertiesView(selection);
				getLeftMergeViewer().setSelection(selection, true);
				getRightMergeViewer().setSelection(selection, true);
				getAncestorMergeViewer().setSelection(selection, true);
			} finally {
				syncingSelections.set(false);
			}
		}

	}

	/**
	 * Update the properties view with the given selection.
	 * 
	 * @param selection
	 *            the given selection.
	 */
	private void updatePropertiesView(final ISelection selection) {
		if (!PlatformUI.isWorkbenchRunning()) {
			// no update of property view outside of workbench
			return;
		}

		if (selection instanceof StructuredSelection) {
			final StructuredSelection structuredSelection = (StructuredSelection) selection;
			final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			final IPropertySheetPage propertySheetPage = getPropertySheetPage(page);
			if (propertySheetPage != null) {
				StructuredSelection selectionForPropertySheet = null;
				final IWorkbenchPart activePart = page.getActivePart();
				final Object firstElement = structuredSelection.getFirstElement();
				if (firstElement instanceof MergeViewerItem) {
					final MergeViewerItem mergeViewerItem = (MergeViewerItem) firstElement;
					final MergeViewerSide side = mergeViewerItem.getSide();
					final Object newSelectedObject = mergeViewerItem.getSideValue(side);
					if (propertySheetPage instanceof ExtendedPropertySheetPage) {
						((ExtendedPropertySheetPage) propertySheetPage).setPropertySourceProvider(adapterFactoryContentProvider);
					}
					getControl().addDisposeListener(new DisposeListener() {
						public void widgetDisposed(DisposeEvent e) {
							if (propertySheetPage instanceof ExtendedPropertySheetPage && null != propertySheetPage.getControl() && !propertySheetPage.getControl().isDisposed()) {
								((ExtendedPropertySheetPage) propertySheetPage).selectionChanged(activePart, null);
								((ExtendedPropertySheetPage) propertySheetPage).setPropertySourceProvider(null);
							}
						}
					});
					if (newSelectedObject != null) {
						if (newSelectedObject instanceof EObject) {
							manageReadOnly((EObject) newSelectedObject, side);
						}
						if (null != propertySheetPage.getControl() && !propertySheetPage.getControl().isDisposed()) {
							selectionForPropertySheet = new StructuredSelection(newSelectedObject);
							propertySheetPage.selectionChanged(activePart, selectionForPropertySheet);
						}
					}
				}
				if (selectionForPropertySheet == null && null != propertySheetPage.getControl() && !propertySheetPage.getControl().isDisposed()) {
					selectionForPropertySheet = new StructuredSelection(new Object());
					propertySheetPage.selectionChanged(activePart, selectionForPropertySheet);
				}
			}
		}
	}

	/**
	 * Returns the property sheet page.
	 * 
	 * @return the property sheet page.
	 */
	private IPropertySheetPage getPropertySheetPage(final IWorkbenchPage activePage) {
		IPropertySheetPage propertyPage = null;
		if (activePage != null) {
			final IViewPart view = activePage.findView("org.eclipse.ui.views.PropertySheet"); //$NON-NLS-1$
			if (view != null) {
				if (view instanceof PropertySheet) {
					final PropertySheet propertySheet = (PropertySheet) view;
					final IPage currentPage = propertySheet.getCurrentPage();
					final IEditorPart activeEditor = activePage.getActiveEditor();
					final IPropertySheetPage adapter = (IPropertySheetPage) Platform.getAdapterManager().getAdapter(activeEditor, IPropertySheetPage.class);
					if (null != activeEditor && null != adapter) {
						propertySheet.partActivated(activePage.getActivePart());
						propertyPage = adapter;
					} else if (currentPage instanceof ExtendedPropertySheetPage) {
						propertyPage = (ExtendedPropertySheetPage) currentPage;
					}

				}
			}
		}
		return propertyPage;
	}

	/**
	 * Manages the read-only state of the properties sheet page for the given selected object.
	 * 
	 * @param selectedObject
	 *            the given selected object.
	 * @param side
	 *            the side of the selected object.
	 */
	private void manageReadOnly(final EObject selectedObject, final MergeViewerSide side) {
		if (MergeViewerSide.RIGHT == side) {
			setToReadOnly(selectedObject);
		} else if (MergeViewerSide.ANCESTOR == side) {
			setToReadOnly(selectedObject);
		}
	}

	/**
	 * Sets the resource of the selected object to read-only in the appropriate editing domain.
	 * 
	 * @param selectedObject
	 *            the given selected object.
	 */
	private void setToReadOnly(final EObject selectedObject) {
		final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(selectedObject);
		if (editingDomain instanceof AdapterFactoryEditingDomain) {
			final Resource r = selectedObject.eResource();
			final Map<Resource, Boolean> resourceToReadOnlyMap = ((AdapterFactoryEditingDomain) editingDomain).getResourceToReadOnlyMap();
			if (!resourceToReadOnlyMap.containsKey(r)) {
				resourceToReadOnlyMap.put(r, Boolean.TRUE);
			}
		}
	}

	/**
	 * Denied the existing update buttons.
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.compare.contentmergeviewer.ContentMergeViewer#updateToolItems()
	 */
	@Override
	protected void updateToolItems() {
		// Do nothing
	}

	/**
	 * This allows to update the toolbar actions status depending to the selection.
	 * 
	 * @param event
	 *            The event of the selection change.
	 */
	protected void updateToolBarForSelection(final SelectionChangedEvent event) {

		PapyrusMergeViewerItem selectedPapyrusMergeViewerItem = null;
		final ISelection selection = null != event ? event.getSelection() : null;
		if (selection instanceof StructuredSelection) {
			final Object firstSelected = ((StructuredSelection) selection).getFirstElement();
			if (firstSelected instanceof PapyrusMergeViewerItem && null != ((PapyrusMergeViewerItem) firstSelected).getDiff()) {
				selectedPapyrusMergeViewerItem = (PapyrusMergeViewerItem) firstSelected;
			}
		}

		// Manage correctly the action and the reject action
		if (null != acceptAction) {
			if (null != event && null != selectedPapyrusMergeViewerItem) {
				((MergeAction) acceptAction.getAction()).selectionChanged(event);
			} else {
				((MergeAction) acceptAction.getAction()).selectionChanged(StructuredSelection.EMPTY);
			}
		}
		if (null != rejectAction) {
			if (null != event && null != selectedPapyrusMergeViewerItem) {
				((MergeAction) rejectAction.getAction()).selectionChanged(event);
			} else {
				((MergeAction) rejectAction.getAction()).selectionChanged(StructuredSelection.EMPTY);
			}
		}

		// We need to manage the next and previous action
		if (null != nextAction || null != previousAction) {
			boolean enableNext = false;
			boolean enablePrevious = false;
			if (null != papyrusMergeViewerItems && !papyrusMergeViewerItems.isEmpty() && null != selectedPapyrusMergeViewerItem) {
				final int diffIndex = getDiffIndex(selectedPapyrusMergeViewerItem.getDiff());
				enableNext = diffIndex > -1 && diffIndex < (papyrusMergeViewerItems.size() - 1);
				enablePrevious = diffIndex > 0;
			}
			if (null != nextAction) {
				nextAction.getAction().setEnabled(enableNext);
			}
			if (null != nextAction) {
				previousAction.getAction().setEnabled(enablePrevious);
			}
		}

		setCurrentDiff(selectedPapyrusMergeViewerItem);
	}

	/**
	 * Sets the selection according to the accessor.
	 * 
	 * @param accessor
	 *            The {@link ICompareAccessor} which contains the root tree elements and the initial selection.
	 */
	private void setSelection(final ICompareAccessor accessor) {
		// First try to set the initial item directly
		final IMergeViewerItem initialItem = accessor.getInitialItem();
		final TreeMergeViewer viewer = getMergeViewer(initialItem.getSide());
		viewer.setSelection(new StructuredSelection(initialItem), true);

		// if that didn't work (empty selection), use cache to find correct merge viewer item
		if (viewer.getSelection().isEmpty()) {
			final IMergeViewerItem itemToBeSelected = getItemToBeSelected(initialItem, viewer);
			if (itemToBeSelected != null) {
				viewer.setSelection(new StructuredSelection(itemToBeSelected), true);
			} else {
				viewer.setSelection(new StructuredSelection(), true);
			}
		}
	}

	/**
	 * Determines the item to select from the corresponding side viewer, given an input item.
	 * 
	 * @param item
	 *            The input item.
	 * @param viewer
	 *            The viewer in which to select the item.
	 * @return The item to be selected.
	 */
	private IMergeViewerItem getItemToBeSelected(final IMergeViewerItem item, final TreeMergeViewer viewer) {
		return getItemToBeSelected(item.getSideValue(viewer.getSide()), viewer);
	}

	/**
	 * Determines the item to select from the corresponding side viewer, given an input item.
	 * 
	 * @param itemValue
	 *            The input item value.
	 * @param viewer
	 *            The viewer in which to select the item.
	 * @return The item to be selected.
	 */
	private IMergeViewerItem getItemToBeSelected(final Object itemValue, final TreeMergeViewer viewer) {
		final MergeViewerSide side = viewer.getSide();
		IMergeViewerItem result;
		if (cachedMapForSelection == null) {
			cachedMapForSelection = Maps.newHashMap();
			result = null;
		} else {
			result = cachedMapForSelection.get(itemValue);
		}

		if (result == null && itemValue != null) {
			LinkedList<AbstractContentFunction> contentComputations;

			switch (side) {
			case LEFT:
				if (leftContentComputations == null) {
					leftContentComputations = Lists.newLinkedList();
					leftContentComputations.add(new ElementFunction(side, viewer, leftContentComputations, cachedMapForSelection));
				}
				contentComputations = leftContentComputations;
				break;

			case RIGHT:
				if (rightContentComputations == null) {
					rightContentComputations = Lists.newLinkedList();
					rightContentComputations.add(new ElementFunction(side, viewer, rightContentComputations, cachedMapForSelection));
				}
				contentComputations = rightContentComputations;
				break;

			default:
				throw new IllegalArgumentException();
			}

			final Collection<Object> containers = getContainers(itemValue);
			if (!containers.isEmpty()) {
				// move necessary computations to the front
				final List<AbstractContentFunction> containerComputations = extractComputations(contentComputations, containers);
				contentComputations.addAll(0, containerComputations);
			}

			result = computeItemToBeSelected(itemValue, containers, contentComputations);
		}

		return result;
	}

	/**
	 * Computes the item to be selected for the given item value, taking into account the containers, using
	 * the content computations.
	 * 
	 * @param itemValue
	 *            The item for which to base the selection.
	 * @param containers
	 *            The containers for that item.
	 * @param contentComputations
	 *            The computations for computing content.
	 * @return the item to be selected.
	 */
	private IMergeViewerItem computeItemToBeSelected(final Object itemValue, final Collection<Object> containers, final LinkedList<AbstractContentFunction> contentComputations) {
		// We try to limit the amount of time we spend looking for selection.
		// Sometimes the object will not be present in the tree at all, causing the whole tree to be visited.
		// So we keep track of which of the contains have not been visited, removing any containers for which there is already a selection computed.
		IMergeViewerItem result = null;
		final Collection<Object> unvistedContainers = Sets.newHashSet(containers);
		unvistedContainers.removeAll(cachedMapForSelection.keySet());
		long start = System.currentTimeMillis();
		while (!contentComputations.isEmpty()) {
			AbstractContentFunction contentFunction = contentComputations.removeFirst();

			// If we've visited all the containers and have been computing for more the 2 seconds, stop looking and select the container instead.
			unvistedContainers.remove(contentFunction.getValue());
			if (unvistedContainers.isEmpty() && (System.currentTimeMillis() - start) > 2 * 1000) {
				break;
			}

			result = contentFunction.apply(itemValue, containers);
			if (result != null) {
				break;
			}
		}

		// If we haven't found the selection, try to find a selection for the nearest container.
		if (result == null) {
			for (final Object container : containers) {
				result = cachedMapForSelection.get(container);
				if (result != null) {
					break;
				}
			}
		}

		return result;
	}

	/**
	 * This allows to select a difference (if the diff is <code>null</code>, select the first difference).
	 * 
	 * @param diff
	 *            The papyrus viewer item representing the difference.
	 * @param isNext
	 *            <code>true</code> if we find the next difference, <code>false</code> otherwise.
	 */
	protected void selectNextOrPreviousDiff(final PapyrusMergeViewerItem diff, final boolean isNext) {
		int index = -1;
		if (null != papyrusMergeViewerItems && !papyrusMergeViewerItems.isEmpty()) {
			index = 0;
			if (null != diff) {
				final int diffIndex = getDiffIndex(diff.getDiff());
				if (null != diff && diffIndex > -1 && ((isNext && diffIndex < papyrusMergeViewerItems.size() - 1) || (!isNext && diffIndex > 1))) {
					final int nextIndex = isNext ? 1 : -1;
					index = diffIndex + nextIndex;
				}
			}
		}

		selectDiffByIndex(index);
	}

	/**
	 * This allows to select a difference from its index.
	 * 
	 * @param index
	 *            The index to select.
	 */
	protected void selectDiffByIndex(final int index) {
		final PapyrusMergeViewerItem selectedDiff = -1 != index && index < papyrusMergeViewerItems.size() ? papyrusMergeViewerItems.get(index) : null;

		// Select the diff
		selectDiff(selectedDiff);
	}

	/**
	 * This allows to select the diff.
	 * 
	 * @param diff
	 *            The diff to select.
	 */
	protected void selectDiff(final PapyrusMergeViewerItem diff) {
		setCurrentDiff(diff);
		if (null != diff) {

			final Object leftValue = diff.getSideValue(MergeViewerSide.LEFT);
			if (null != leftValue) {
				expandUntilItem(diff, leftValue, getRightMergeViewer());
				getLeftMergeViewer().setSelection(new StructuredSelection(diff), true);
			} else {
				final Object rightValue = diff.getSideValue(MergeViewerSide.RIGHT);
				expandUntilItem(diff, rightValue, getLeftMergeViewer());
				getRightMergeViewer().setSelection(new StructuredSelection(diff), true);
			}
		}
	}

	/**
	 * Expand the tree until the item is displayed.
	 * 
	 * @param item
	 *            The item to display.
	 * @param itemValue
	 *            The item corresponding value.
	 * @param viewer
	 *            The viewer.
	 */
	protected void expandUntilItem(final IMergeViewerItem item, final Object itemValue, final TreeMergeViewer viewer) {
		final Collection<Object> containers = getContainers(itemValue);
		containers.forEach(container -> {
			if (null != cachedMapForSelection && cachedMapForSelection.containsKey(container)) {
				viewer.setExpandedState(cachedMapForSelection.get(container), true);
			} else {
				expandUntilItem(getItemToBeSelected(container, viewer), container, viewer);
			}
		});
	}

	/**
	 * This allows to set the current difference.
	 * 
	 * @param diff
	 *            The papyrus viewer item representing the difference.
	 */
	private void setCurrentDiff(final PapyrusMergeViewerItem diff) {
		currentDiff = diff;
	}

	/**
	 * Extracts all content functions for the given objects from the computation list.
	 * 
	 * @param computations
	 *            The computation list from which functions are extracted.
	 * @param values
	 *            The values specifying which functions should be extracted.
	 * @return Non-null list of computations covering the given objects.
	 */
	private List<AbstractContentFunction> extractComputations(final LinkedList<AbstractContentFunction> computations, final Collection<Object> values) {
		final List<AbstractContentFunction> extractedComputations = new ArrayList<>();
		final Iterator<AbstractContentFunction> computationsIterator = computations.iterator();
		while (computationsIterator.hasNext()) {
			final AbstractContentFunction contentFuction = computationsIterator.next();
			if (values.contains(contentFuction.getValue())) {
				computationsIterator.remove();
				extractedComputations.add(contentFuction);
			}
		}
		return extractedComputations;
	}

	/**
	 * Returns all EObject containers for the given value, if the given object is an EObject.
	 * 
	 * @param eObject
	 *            The eObject value.
	 * @return Non-null collection of containers.
	 */
	private Collection<Object> getContainers(final Object eObject) {
		Collection<Object> containers;
		if (eObject instanceof EObject) {
			containers = Sets.newLinkedHashSet();
			for (EObject container = ((EObject) eObject).eContainer(); container != null; container = container.eContainer()) {
				containers.add(container);
			}
		} else {
			containers = Collections.emptySet();
		}
		return containers;
	}

	/**
	 * Remove the existing buttons and add the needed ones. {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.EMFCompareContentMergeViewer#createToolItems(org.eclipse.jface.action.ToolBarManager)
	 */
	@Override
	protected void createToolItems(final ToolBarManager tbm) {
		if (tbm != null) {
			tbm.removeAll();

			tbm.add(new Separator(PAPYRUS_CATEGORY));

			// Create accept and reject bouton only if the left is editable
			if (isLeftEditable()) {
				// Create the accept and reject actions
				final EMFCompareConfiguration compareConfiguration = getCompareConfiguration();
				final boolean isLeftAndRightEditable = compareConfiguration.isLeftEditable() && compareConfiguration.isRightEditable();
				acceptAction = new ActionContributionItem(createMergeAction(isLeftAndRightEditable ? MergeMode.LEFT_TO_RIGHT : MergeMode.ACCEPT, compareConfiguration, null));
				tbm.appendToGroup(PAPYRUS_CATEGORY, acceptAction);
				initGraphicalAction(acceptAction.getAction(), getResourceBundle(), "Accept", "Accept", "This allows to accept a modification"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

				rejectAction = new ActionContributionItem(createMergeAction(isLeftAndRightEditable ? MergeMode.RIGHT_TO_LEFT : MergeMode.REJECT, compareConfiguration, null));
				tbm.appendToGroup(PAPYRUS_CATEGORY, rejectAction);
				initGraphicalAction(rejectAction.getAction(), getResourceBundle(), "Reject", "Reject", "This allows to reject a modification"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}

			// Manage correctly the previous and next actions
			previousAction = new ActionContributionItem(new Action() {
				@Override
				public void run() {
					selectNextOrPreviousDiff(currentDiff, false);
				}
			});
			tbm.appendToGroup(PAPYRUS_CATEGORY, previousAction);
			initGraphicalAction(previousAction.getAction(), getResourceBundle(), "Previous", "Previous", "This allows to go to previous modification"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			getHandlerService().registerAction(previousAction.getAction(), "org.eclipse.papyrus.gitlight.compare.ui.previous"); //$NON-NLS-1$

			nextAction = new ActionContributionItem(new Action() {
				@Override
				public void run() {
					selectNextOrPreviousDiff(currentDiff, true);
				}
			});
			tbm.appendToGroup(PAPYRUS_CATEGORY, nextAction);
			initGraphicalAction(nextAction.getAction(), getResourceBundle(), "Next", "Next", "This allows to go to next modification"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			getHandlerService().registerAction(nextAction.getAction(), "org.eclipse.papyrus.gitlight.compare.ui.next"); //$NON-NLS-1$
		}
	}

	/**
	 * This allows to get the root merge viewer item.
	 * 
	 * @param item
	 *            The initial item.
	 * @param side
	 *            The side of the tree viewer.
	 * @return The parent item or itself if parent is <code>null</code>.
	 */
	protected Object getRootItem(final IMergeViewerItem item, final MergeViewerSide side) {
		if (null != item) {
			if (null != item.getParent()) {
				return getRootItem(item.getParent(), side);
			} else {
				return item;
			}
		}
		return null;
	}

	/**
	 * This allows to get the papyrus merge viewer items where the diff is not <code>null</code>.
	 * 
	 * @param root
	 *            The root item.
	 * @param contentProvider
	 *            The content provider.
	 * @return The list of differences.
	 */
	protected List<PapyrusMergeViewerItem> getDiffPapyrusMergeViewerItems(final Object root, final ITreeContentProvider contentProvider) {
		List<PapyrusMergeViewerItem> diffs = null;

		final List<Object> children = Arrays.asList(contentProvider.getChildren(root));
		if (null != children && !children.isEmpty()) {

			diffs = children.stream().filter(element -> element instanceof PapyrusMergeViewerItem).map(element -> (PapyrusMergeViewerItem) element).collect(Collectors.toList());
			List<PapyrusMergeViewerItem> subDiffs = new ArrayList<PapyrusMergeViewerItem>();

			// Iterate on the list
			final Iterator<PapyrusMergeViewerItem> itemsIterator = diffs.iterator();
			while (itemsIterator.hasNext()) {
				final PapyrusMergeViewerItem item = itemsIterator.next();

				// If the current item has no diff, remove from the needed list
				if (null == item.getDiff()) {
					itemsIterator.remove();
				}

				// Manage the depth through
				List<PapyrusMergeViewerItem> subDiffsForItem = getDiffPapyrusMergeViewerItems(item, contentProvider);
				if (null != subDiffsForItem && !subDiffsForItem.isEmpty()) {
					subDiffs.addAll(subDiffsForItem);
				}
			}

			diffs.addAll(subDiffs);
		}

		return diffs;
	}

	/**
	 * Allows to save the resource.
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.EMFCompareContentMergeViewer#doSave(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected boolean doSave(final Object newInput, final Object oldInput) {
		if (isLeftEditable() && isLeftDirty()) {
			final MessageDialog dialog = new MessageDialog(getControl().getShell(),
					Utilities.getString(getResourceBundle(), "saveDialog.title"), //$NON-NLS-1$
					null, // accept the default window icon
					Utilities.getString(getResourceBundle(), "saveDialog.message"), //$NON-NLS-1$
					MessageDialog.QUESTION,
					new String[] { IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL },
					0); // default button index

			switch (dialog.open()) { // open returns index of pressed button
			case 0:
				flushContent(oldInput, null);
				break;
			case 1:
				setLeftDirty(false);
				setRightDirty(false);
				break;
			case 2:
				throw new ViewerSwitchingCancelled();
			}
			return true;
		}
		return false;
	}

	@Override
	public void commandStackChanged(EventObject event) {
		boolean leftDirty = isLeftDirty();
		super.commandStackChanged(event);
		setLeftDirty(leftDirty);
	}

	@Override
	protected void editingDomainChange(ICompareEditingDomain oldValue, ICompareEditingDomain newValue) {
		boolean leftDirty = isLeftDirty();
		super.editingDomainChange(oldValue, newValue);
		setLeftDirty(leftDirty);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.tree.TreeContentMergeViewer#handleDispose(org.eclipse.swt.events.DisposeEvent)
	 */
	@Override
	protected void handleDispose(final DisposeEvent event) {
		if (cachedMapForSelection != null) {
			cachedMapForSelection = null;
		}
		if (null != papyrusMergeViewerItems) {
			papyrusMergeViewerItems = null;
		}
		if (null != currentDiff) {
			currentDiff = null;
		}

		super.handleDispose(event);
	}

	/**
	 * A function for computing the items in the content tree induced by an item provider. Instances are managed in a {@link #contentComputations} queue and are processed to update the {@linked #selections selections} cache.
	 * 
	 * @see PapyrusTreeContentMergeViewer#getItemToBeSelected(IMergeViewerItem)
	 */
	private abstract static class AbstractContentFunction {

		/**
		 * The side for which the computation is being done.
		 */
		protected final MergeViewerSide side;

		/**
		 * The tree content provider which induces the content tree.
		 */
		protected final ITreeContentProvider provider;

		/**
		 * The queue of computations being managed.
		 * 
		 * @see PapyrusTreeContentMergeViewer#leftContentComputations
		 * @see PapyrusTreeContentMergeViewer#rightContentComputations
		 */
		protected final LinkedList<AbstractContentFunction> contentComputations;

		/**
		 * The selections being cached.
		 * 
		 * @see PapyrusTreeContentMergeViewer#cachedMapForSelection.
		 */
		protected final Map<Object, IMergeViewerItem> selections;

		/**
		 * Creates and instance for a given side that induces content based on the given providers and manages the queue of content computations, updating the selections.
		 * 
		 * @param side
		 *            The side for which the content is being computed.
		 * @param provider
		 *            The provider used to induce content.
		 * @param contentComputations
		 *            The queue of computations being managed.
		 * @param selections
		 *            The selection cache being managed.
		 */
		protected AbstractContentFunction(final MergeViewerSide side, final ITreeContentProvider provider, final LinkedList<AbstractContentFunction> contentComputations, final Map<Object, IMergeViewerItem> selections) {
			this.side = side;
			this.provider = provider;
			this.contentComputations = contentComputations;
			this.selections = selections;
		}

		/**
		 * Computes new content and if any of the new content item matches the given value, returns the corresponding item from the side viewer. The {@link #contentComputations queue} is updated with functions for the new content items. Any new item with a
		 * value that matches one of the containers is placed at the front of the queue, rather than the back.
		 * 
		 * @param matchValue
		 *            The value to match.
		 * @param containers
		 *            The items that are of high priority to process first.
		 * @return The corresponding side viewer item for the match value, or null.
		 */
		public abstract IMergeViewerItem apply(final Object matchValue, final Collection<?> containers);

		/**
		 * Returns the value for which content will be computed.
		 * 
		 * @return the value for which content will be computed.
		 */
		public abstract Object getValue();

		/**
		 * A base helper method that does the computation needed by {@link #apply(Object, Collection)}.
		 * 
		 * @param matchValue
		 *            The value to be matched.
		 * @param containers
		 *            The items that are of high priority to process first.
		 * @param values
		 *            The new content items to be processed.
		 * @param depth
		 *            The current tree depth of the traversal.
		 * @return the corresponding side viewer item for the match value, or null.
		 */
		protected IMergeViewerItem apply(final Object matchValue, final Collection<?> containers, final Object[] values, final int depth) {
			IMergeViewerItem result = null;
			for (final Object element : values) {
				if (element instanceof IMergeViewerItem) {
					final IMergeViewerItem item = (IMergeViewerItem) element;
					final Object sideValue = item.getSideValue(side);

					// If we don't yet have a result, and the new value is equal to the matching value, then cache it as the result.
					if (result == null) {
						if (sideValue != null && sideValue.equals(matchValue)) {
							result = item;
						}
					}

					// Create a new child function for the given item and add it to the front or the back of the queue depending on whether the high priority containers include the item's side value. So in general the content is build breadth first, but the
					// subtree of the containers is processed depth first.
					final ChildFunction childFunction = new ChildFunction(side, provider, item, depth, contentComputations, selections);
					if (containers.contains(sideValue)) {
						contentComputations.addFirst(childFunction);
					} else {
						contentComputations.addLast(childFunction);

					}
				}
			}
			return result;
		}
	}

	/**
	 * A content function that computes the root elements of a side viewer.
	 */
	private static final class ElementFunction extends AbstractContentFunction {

		/**
		 * The input object of the side viewer.
		 */
		private final Object input;

		/**
		 * Creates and instance for a given side viewer that induces content based on the viewer's provider and manages the queue of content computations, updating the selections.
		 * 
		 * @param side
		 *            The side for which the content is being computed.
		 * @param viewer
		 *            The side viewer for which to induce content.
		 * @param contentComputations
		 *            The queue of computations being managed.
		 * @param selections
		 *            The selection cache being managed.
		 */
		private ElementFunction(final MergeViewerSide side, final TreeMergeViewer viewer, final LinkedList<AbstractContentFunction> contentComputations, final Map<Object, IMergeViewerItem> selections) {
			super(side, (ITreeContentProvider) viewer.getContentProvider(), contentComputations, selections);
			this.input = viewer.getInput();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.papyrus.gitlight.compare.ui.contentmergeviewer.PapyrusTreeContentMergeViewer.AbstractContentFunction#getValue()
		 */
		@Override
		public Object getValue() {
			return input;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.papyrus.gitlight.compare.ui.contentmergeviewer.PapyrusTreeContentMergeViewer.AbstractContentFunction#apply(java.lang.Object, java.util.Collection)
		 */
		@Override
		public IMergeViewerItem apply(final Object matchValue, final Collection<?> containers) {
			return apply(matchValue, containers, provider.getElements(input), 0);
		}
	}

	/**
	 * A content function that computes the child elements of a side viewer.
	 */
	private static final class ChildFunction extends AbstractContentFunction {

		/**
		 * The item for which to induce child content.
		 */
		private final IMergeViewerItem item;

		/**
		 * The depth of the item.
		 */
		private final int depth;

		/**
		 * Creates and instance for a given side viewer's content provider that induces for the given item and the given depth and manages the queue of content computations, updating the selections.
		 * 
		 * @param side
		 *            The side for which the content is being computed.
		 * @param provider
		 *            The content provider of the side viewer.
		 * @param item
		 *            The item for which to induce child content.
		 * @param depth
		 *            The depth of the item.
		 * @param contentComputations
		 *            The queue of computations being managed.
		 * @param selections
		 *            The selection cache being managed.
		 */
		private ChildFunction(final MergeViewerSide side, final ITreeContentProvider provider, final IMergeViewerItem item, final int depth, final LinkedList<AbstractContentFunction> contentComputations, final Map<Object, IMergeViewerItem> selections) {
			super(side, provider, contentComputations, selections);
			this.item = item;
			this.depth = depth;

			final Object value = item.getSideValue(side);
			if (value != null) {
				selections.put(value, item);
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.papyrus.gitlight.compare.ui.contentmergeviewer.PapyrusTreeContentMergeViewer.AbstractContentFunction#getValue()
		 */
		@Override
		public Object getValue() {
			return item.getSideValue(side);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.papyrus.gitlight.compare.ui.contentmergeviewer.PapyrusTreeContentMergeViewer.AbstractContentFunction#apply(java.lang.Object, java.util.Collection)
		 */
		@Override
		public IMergeViewerItem apply(final Object matchValue, final Collection<?> containers) {
			return depth == MAX_SEARCH_LEVEL ? null : apply(matchValue, containers, provider.getChildren(item), depth + 1);
		}
	}
}
