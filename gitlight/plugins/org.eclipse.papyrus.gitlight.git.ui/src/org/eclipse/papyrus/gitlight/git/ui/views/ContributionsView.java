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
package org.eclipse.papyrus.gitlight.git.ui.views;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.papyrus.gitlight.git.ui.Activator;
import org.eclipse.papyrus.gitlight.git.ui.providers.BranchesContentProvider;
import org.eclipse.papyrus.gitlight.git.utils.PapyrusFileUtils;
import org.eclipse.papyrus.gitlight.git.utils.GitConstants;
import org.eclipse.papyrus.gitlight.git.utils.GitInstance;
import org.eclipse.papyrus.gitlight.git.utils.GitUtils;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * The Reviews view.
 */
public class ContributionsView extends ViewPart implements ITabbedPropertySheetPageContributor {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.papyrus.gitlight.git.ui.contributions.view"; //$NON-NLS-1$

	/**
	 * The menu id.
	 */
	public static final String MENU_ID = "org.eclipse.papyrus.gitlight.git.ui.contributions.view.popup"; //$NON-NLS-1$

	/**
	 * The used page book.
	 */
	private PageBook pagebook;

	/**
	 * The used table viewer for the branches.
	 */
	private TableViewer tableViewer;

	/**
	 * The property sheet pages.
	 */
	private List<IPropertySheetPage> propertiesSheetPages = new LinkedList<IPropertySheetPage>();

	/**
	 * The page listeners.
	 */
	private final CopyOnWriteArrayList<IContributionsViewPageListener> pageListeners = new CopyOnWriteArrayList<IContributionsViewPageListener>();

	/**
	 * The table layout for columns.
	 */
	private AutoResizeTableLayout tableLayout;


	/**
	 * The listener we register with the selection service.
	 */
	private ISelectionListener listener = new ISelectionListener() {
		public void selectionChanged(IWorkbenchPart sourcepart, ISelection selection) {
			// we ignore our own selections
			if (sourcepart != ContributionsView.this) {
				showSelection(sourcepart, selection);
			}
		}
	};

	/**
	 * Default constructor.
	 */
	public ContributionsView() {
		// Do nothing
	}

	/**
	 * Shows the given selection in this view.
	 * 
	 * @param sourcepart
	 *            The source part workbench.
	 * @param selection
	 *            The selection.
	 */
	public void showSelection(final IWorkbenchPart sourcepart, final ISelection selection) {
		String contentDescription = "Selection is not managed"; //$NON-NLS-1$
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1) {
				final Element element = getRootElement(structuredSelection.getFirstElement());
				tableViewer.setInput(element);
				if (null != element) {
					if (element instanceof NamedElement) {
						contentDescription = "Contributions for model '" + ((NamedElement) element).getName() + "'"; //$NON-NLS-1$ //$NON-NLS-2$
					}
				}
				pagebook.showPage(tableViewer.getControl());
			}
		}
		setContentDescription(contentDescription);
	}

	/**
	 * Get the root of the selected element (it ban be file, EObject, others...).
	 * 
	 * @param selectedObject
	 *            The selected object.
	 * @return The root element or <code>null</code>.
	 */
	protected Element getRootElement(final Object selectedObject) {
		Element result = null;

		// Manage the possible selected file
		final IFile file = PapyrusFileUtils.getFile(selectedObject);
		if (null != file) {
			String fullPath = file.getFullPath().toString();
			URI modelURI = URI.createPlatformResourceURI(fullPath, false);
			if (!"uml".equals(modelURI.fileExtension())) { //$NON-NLS-1$
				modelURI = modelURI.trimFileExtension().appendFileExtension("uml"); //$NON-NLS-1$
			}
			final ModelSet modelSet = new ModelSet();
			final Resource resource = modelSet.getResource(modelURI, true);

			if (null != resource) {
				final EObject root = resource.getContents().get(0);

				if (root instanceof Element) {
					result = (Element) root;
				}
			}
		}

		// Manage other possibilities
		if (null == result && selectedObject instanceof IAdaptable) {
			final Element adapter = ((IAdaptable) selectedObject).getAdapter(Element.class);
			if (null != adapter) {
				result = adapter.getModel();
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(final Composite parent) {
		pagebook = new PageBook(parent, SWT.NONE);

		tableViewer = new TableViewer(pagebook, SWT.SINGLE | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		tableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		tableViewer.setContentProvider(new BranchesContentProvider(true));
		tableViewer.getTable().setHeaderVisible(true);
		tableViewer.getTable().setLinesVisible(true);

		// Initialize the columns layout data
		tableLayout = new AutoResizeTableLayout(tableViewer.getTable());
		tableViewer.getTable().setLayout(tableLayout);

		// Create the columns
		createReviewDateColumn();
		createReviewVersionColumn();
		createReviewAuthorColumn();
		createReviewCommentColumn();

		final MenuManager menuManager = new MenuManager("#PopupMenu"); //$NON-NLS-1$
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager manager) {
				manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
			}

		});

		final Menu menu = menuManager.createContextMenu(tableViewer.getTable());
		tableViewer.getTable().setMenu(menu);
		getSite().registerContextMenu(MENU_ID, menuManager, tableViewer);

		// Provider the table selection
		getSite().setSelectionProvider(tableViewer);

		// Add the selection listener
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(listener);
	}

	/**
	 * This allows to create the date column.
	 */
	protected void createReviewDateColumn() {
		final TableViewerColumn dateColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		dateColumn.getColumn().setText("Date"); //$NON-NLS-1$
		dateColumn.getColumn().setWidth(150);
		dateColumn.getColumn().setResizable(true);
		tableLayout.addColumnData(new ColumnWeightData(150, 100, true));
		dateColumn.setLabelProvider(new ColumnLabelProvider() {

			/**
			 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
			 *
			 * @param element
			 * @return
			 */
			@Override
			public String getText(Object element) {
				if (element instanceof Ref) {
					final Git git = GitInstance.getInstance().getGit();
					final RevCommit lastCommit = GitUtils.getLastCommitOfBranch(git, (Ref) element);
					PersonIdent authorIdent = lastCommit.getAuthorIdent();
					Date authorDate = authorIdent.getWhen();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); //$NON-NLS-1$
					return dateFormat.format(authorDate);
				}
				return "Not specified"; //$NON-NLS-1$
			}
		});
	}

	/**
	 * This allows to create the version column.
	 */
	protected void createReviewVersionColumn() {
		final TableViewerColumn versionColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		versionColumn.getColumn().setText("Version"); //$NON-NLS-1$
		versionColumn.getColumn().setWidth(100);
		versionColumn.getColumn().setResizable(true);
		tableLayout.addColumnData(new ColumnWeightData(100, 50, true));
		versionColumn.setLabelProvider(new ColumnLabelProvider() {

			/**
			 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
			 *
			 * @param element
			 * @return
			 */
			@Override
			public String getText(Object element) {
				if (element instanceof Ref) {
					final String name = ((Ref) element).getName();
					if (name.contains(GitConstants.CONTRIBUTION_BRANCH_PREFIX) && name.length() > (GitConstants.CONTRIBUTION_BRANCH_PREFIX.length() + 18)) {
						// 18 is the number of character for the unique identifier generated from the date (it is always the same size)
						return name.substring(name.indexOf(GitConstants.CONTRIBUTION_BRANCH_PREFIX) + GitConstants.CONTRIBUTION_BRANCH_PREFIX.length() + 18);
					}
					return name;
				}
				return "Not specified"; //$NON-NLS-1$
			}
		});
	}

	/**
	 * This allows to create the author column.
	 */
	protected void createReviewAuthorColumn() {
		final TableViewerColumn authorColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		authorColumn.getColumn().setText("Author"); //$NON-NLS-1$
		authorColumn.getColumn().setWidth(200);
		authorColumn.getColumn().setResizable(true);
		tableLayout.addColumnData(new ColumnWeightData(200, 100, true));
		authorColumn.setLabelProvider(new ColumnLabelProvider() {

			/**
			 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
			 *
			 * @param element
			 * @return
			 */
			@Override
			public String getText(Object element) {
				if (element instanceof Ref) {
					final Git git = GitInstance.getInstance().getGit();
					final RevCommit lastCommit = GitUtils.getLastCommitOfBranch(git, (Ref) element);

					String author = null;
					if (lastCommit.getFullMessage().contains(Constants.SIGNED_OFF_BY_TAG)) {
						try {
							final String subSignedOff = lastCommit.getFullMessage().substring(lastCommit.getFullMessage().indexOf(Constants.SIGNED_OFF_BY_TAG) + Constants.SIGNED_OFF_BY_TAG.length());
							author = subSignedOff.contains("\n") ? subSignedOff.substring(0, subSignedOff.indexOf("\n")) : subSignedOff; //$NON-NLS-1$ //$NON-NLS-2$
						} catch (Exception e) {
							// Do nothing
						}
					}
					if (null == author || author.isEmpty()) {
						author = lastCommit.getAuthorIdent().getName();
					}

					return author;
				}
				return "Unknown"; //$NON-NLS-1$
			}
		});
	}

	/**
	 * This allows to create the comment column.
	 */
	protected void createReviewCommentColumn() {
		final TableViewerColumn commentColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		commentColumn.getColumn().setText("Comment"); //$NON-NLS-1$
		commentColumn.getColumn().setWidth(600);
		commentColumn.getColumn().setResizable(true);
		tableLayout.addColumnData(new ColumnPixelData(600, true));
		commentColumn.setLabelProvider(new ColumnLabelProvider() {

			/**
			 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
			 *
			 * @param element
			 * @return
			 */
			@Override
			public String getText(Object element) {
				if (element instanceof Ref) {
					final Git git = GitInstance.getInstance().getGit();
					final RevCommit lastCommit = GitUtils.getLastCommitOfBranch(git, (Ref) element);
					return lastCommit.getShortMessage();
				}
				return "Not specified"; //$NON-NLS-1$
			}
		});
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		pagebook.setFocus();
		firePageActivated();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {

		if (IPropertySheetPage.class == adapter) {
			// Do not test if tabbedPropertySheetPage is null before calling new
			// this is managed by Eclipse which only call current method when necessary
			return getPropertySheetPage();
		}

		return super.getAdapter(adapter);
	}

	/**
	 * This allows to define the property sheet page associated to this view.
	 * 
	 * @return The property sheet page.
	 */
	private IPropertySheetPage getPropertySheetPage() {
		IPropertySheetPage propertySheetPage = new ContributionsPropertySheetPage(this);
		propertiesSheetPages.add(propertySheetPage);
		return propertySheetPage;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		// important: We need do unregister our listener when the view is disposed
		getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(listener);

		for (final IPropertySheetPage page : propertiesSheetPages) {
			page.dispose();
		}
		propertiesSheetPages.clear();
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor#getContributorId()
	 */
	@Override
	public String getContributorId() {
		return "TreeOutlinePage"; //$NON-NLS-1$
	}

	/**
	 * This allows to add a page listener.
	 * 
	 * @param listener
	 *            The page listener to add.
	 */
	void addPageListener(final IContributionsViewPageListener listener) {
		pageListeners.addIfAbsent(listener);
	}

	/**
	 * This allows to remove a page listener.
	 * 
	 * @param listener
	 *            The page listener to remove.
	 */
	void removePageListener(final IContributionsViewPageListener listener) {
		pageListeners.remove(listener);
	}

	/**
	 * This allows to call the activated pages.
	 */
	private void firePageActivated() {
		for (final IContributionsViewPageListener next : pageListeners) {
			try {
				next.pageActivated(this);
			} catch (Exception e) {
				Activator.getLogHelper().error("Uncaught exception in page activation listener.", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * This class allows to manage correctly the columns in the table viewer.
	 */
	public class AutoResizeTableLayout extends TableLayout implements ControlListener {

		/**
		 * The table to manage.
		 */
		private final Table table;

		/**
		 * The columns layout data.
		 */
		private List<ColumnLayoutData> columns = new ArrayList<ColumnLayoutData>();

		/**
		 * This manage the auto sizing of the columns.
		 */
		private boolean autosizing = false;

		/**
		 * Default constructor.
		 *
		 * @param table
		 *            The table to manage.
		 */
		public AutoResizeTableLayout(final Table table) {
			this.table = table;
			table.addControlListener(this);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.TableLayout#addColumnData(org.eclipse.jface.viewers.ColumnLayoutData)
		 */
		@Override
		public void addColumnData(final ColumnLayoutData data) {
			columns.add(data);
			super.addColumnData(data);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.swt.events.ControlListener#controlMoved(org.eclipse.swt.events.ControlEvent)
		 */
		@Override
		public void controlMoved(final ControlEvent e) {
			// Do nothing
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.swt.events.ControlListener#controlResized(org.eclipse.swt.events.ControlEvent)
		 */
		@Override
		public void controlResized(final ControlEvent e) {
			if (autosizing)
				return;
			autosizing = true;
			try {
				autoSizeColumns();
			} finally {
				autosizing = false;
			}
		}

		/**
		 * This allows to auto resize the columns depending to the space available.
		 */
		private void autoSizeColumns() {
			int width = table.getClientArea().width;

			// Layout is being called with an invalid value the first time it is being called on Linux.
			// This method resets the layout to null, so we run it only when the value is OK.
			if (width <= 1) {
				return;
			}

			final TableColumn[] tableColumns = table.getColumns();
			int size = Math.min(columns.size(), tableColumns.length);
			int[] widths = new int[size];
			int fixedWidth = 0;
			int numberOfWeightColumns = 0;
			int totalWeight = 0;

			// First calc space occupied by fixed columns.
			for (int i = 0; i < size; i++) {
				final ColumnLayoutData col = columns.get(i);
				if (col instanceof ColumnPixelData) {
					int pixels = ((ColumnPixelData) col).width;
					widths[i] = pixels;
					fixedWidth += pixels;
				} else if (col instanceof ColumnWeightData) {
					final ColumnWeightData cw = (ColumnWeightData) col;
					numberOfWeightColumns++;
					int weight = cw.weight;
					totalWeight += weight;
				} else {
					throw new IllegalStateException("Unknown column layout data");
				}
			}

			// Do we have columns that have a weight?
			if (numberOfWeightColumns > 0) {
				// Now, distribute the rest to the columns with weight.
				// Make sure there's enough room, even if we have to scroll.
				if (width < fixedWidth + totalWeight) {
					width = fixedWidth + totalWeight;
				}
				int rest = width - fixedWidth;
				int totalDistributed = 0;
				for (int i = 0; i < size; i++) {
					final ColumnLayoutData col = columns.get(i);
					if (col instanceof ColumnWeightData) {
						final ColumnWeightData cw = (ColumnWeightData) col;
						int weight = cw.weight;
						int pixels = totalWeight == 0 ? 0 : weight * rest / totalWeight;
						if (pixels < cw.minimumWidth) {
							pixels = cw.minimumWidth;
						}
						totalDistributed += pixels;
						widths[i] = pixels;
					}
				}

				// Distribute any remaining pixels to columns with weight.
				int diff = rest - totalDistributed;
				for (int i = 0; diff > 0; i++) {
					if (i == size) {
						i = 0;
					}
					final ColumnLayoutData col = columns.get(i);
					if (col instanceof ColumnWeightData) {
						++widths[i];
						--diff;
					}
				}
			}

			for (int i = 0; i < size; i++) {
				if (tableColumns[i].getWidth() != widths[i]) {
					tableColumns[i].setWidth(widths[i]);
				}
			}
		}
	}

}
