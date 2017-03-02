/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.refactoring.mutation.ui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.newchild.CreationMenuRegistry;
import org.eclipse.papyrus.infra.newchild.elementcreationmenumodel.CreationMenu;
import org.eclipse.papyrus.infra.newchild.elementcreationmenumodel.Folder;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.refactoring.Activator;
import org.eclipse.papyrus.refactoring.helper.AbstractSelectedElementsTransformation;
import org.eclipse.papyrus.refactoring.refactoringOnElement.ITransformationOnElement;
import org.eclipse.papyrus.refactoring.util.PapyrusRefactoringUtils;
import org.eclipse.papyrus.uml.refactoring.mutation.helper.MutationTransformation;
import org.eclipse.papyrus.uml.refactoring.mutation.messages.Messages;
import org.eclipse.papyrus.uml.refactoring.mutation.providers.ElemenetTypeContentProvider;
import org.eclipse.papyrus.uml.refactoring.mutation.providers.ElementTypeLabelProvider;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Relationship;



/**
 * Class used to propose the next type of the mutated element through a new wizard page and {@link AbstractSelectedElementsTransformation} used to mutate the selected elements.
 * 
 */
@SuppressWarnings("restriction")
public class MutationRefactoring extends AbstractSelectedElementsTransformation {

	/** The {@link TreeViewer} that displays the UML Meta-Classes in the UI. */
	private TreeViewer fNewTypeTreeViewer;

	/** The {@link FilteredTree} to help the user to find the UML Meta-class he is looking for. */
	private FilteredTree fNewMetaClassTree;

	/** The {@link Composite} for this UI. */
	private Composite mutationComposite;


	public MutationRefactoring() {
		super(Messages.MUTATIONREFACTORING_PAGETITLE);
	}

	@Override
	public void createControl(Composite parent) {
		mutationComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = 1;

		mutationComposite.setLayout(layout);
		mutationComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		setControl(mutationComposite);

		initElementTypesViewer();
	}


	/**
	 * Initiate and display {@link #fNewTypeTreeViewer}.
	 */
	private void initElementTypesViewer() {
		Label newMetaClassLabel = new Label(mutationComposite, SWT.NONE);
		newMetaClassLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		newMetaClassLabel.setText(Messages.MUTATIONREFACTORING_SELECTIONLABEL);

		fNewMetaClassTree = new FilteredTree(mutationComposite, SWT.RIGHT | SWT.V_SCROLL | SWT.H_SCROLL, new PatternFilter(), true);
		fNewTypeTreeViewer = fNewMetaClassTree.getViewer();
		GridData listViewerGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		listViewerGridData.heightHint = 300;

		fNewMetaClassTree.setLayoutData(listViewerGridData);
		fNewTypeTreeViewer.setComparator(new ViewerComparator());

		Map<IElementType, EObject> umlTypesInput = new HashMap<>();
		try {
			// EObject modelRoot = PapyrusRefactoringUtils.getUMLRoot(fModelSet);
			// Model model = modelRoot instanceof Model ? (Model) modelRoot : null;
			// if (model != null) {
			// for (Profile profile : model.getAllAppliedProfiles()) {
			// // TODO retrieve the elementTypes according to the applied profiles
			// }
			// }


			ElementTypeRegistry registry = ElementTypeRegistry.getInstance();
			EObject elementToMutate = getElementToMutate();
			EObject elementToMutateParent = elementToMutate.eContainer() != null ? elementToMutate.eContainer() : elementToMutate;
			IElementType relationshipType = UMLElementTypes.RELATIONSHIP;
			IClientContext clientContext = TypeContext.getContext();
			IElementType elementToMutateType = registry.getElementType(elementToMutate, clientContext);
			boolean elementToMutateIsRelationship = Arrays.asList(elementToMutateType.getAllSuperTypes()).contains(relationshipType);

			Set<IElementType> relationshipTypes = new HashSet<>();
			Set<IElementType> nodeTypes = new HashSet<>();

			for (Folder folder : CreationMenuRegistry.getInstance().getRootFolder()) {
				// System.err.println(folder.getLabel() + ", " + folder.eContents().size());
				for (EObject eObject : folder.eContents()) {
					if (eObject instanceof CreationMenu) {
						CreationMenu creationMenu = (CreationMenu) eObject;
						IElementType menuElementType = registry.getType(creationMenu.getElementTypeIdRef());
						if (menuElementType == null) {
							continue;
						}

						if (Arrays.asList(menuElementType.getAllSuperTypes()).contains(relationshipType)) {
							relationshipTypes.add(menuElementType);
						} else {
							nodeTypes.add(menuElementType);
						}
					}
				}
			}

			if (elementToMutateIsRelationship) {
				umlTypesInput = getRelationshipTypes(elementToMutateParent, elementToMutate, relationshipTypes);
			} else {
				umlTypesInput = getNodeTypes(elementToMutateParent, elementToMutate, nodeTypes);
			}

			umlTypesInput.remove(elementToMutateType);
			// System.err.println("finalMenu, " + umlTypesInput.size());


		} catch (ServiceException e) {
			Activator.log.error(e);
		}

		fNewTypeTreeViewer.setLabelProvider(new ElementTypeLabelProvider());
		fNewTypeTreeViewer.setContentProvider(new ElemenetTypeContentProvider());
		fNewTypeTreeViewer.setInput(umlTypesInput);

	}

	/**
	 * Retrieves all the possible relationship that can be created from the selected element's context
	 * 
	 * @param elementToMutateParent
	 *            The relationship's container
	 * @param elementToMutate
	 *            The relationship
	 * @param relationshipTypes
	 *            The possible relationship types the are declared in the registry
	 * @return
	 * 		The filtered relationships to display in the viewer
	 */
	private Map<IElementType, EObject> getRelationshipTypes(EObject elementToMutateParent, EObject elementToMutate, Set<IElementType> relationshipTypes) {
		Map<IElementType, EObject> filteredTypes = new HashMap<>();

		Relationship relationshipToMutate = (Relationship) elementToMutate;
		Element relationshipSource = null;
		Element relationshipTarget = null;
		if (relationshipToMutate instanceof DirectedRelationship) {
			// System.err.println("DirectedRelationship");
			// System.err.println(relationshipToMutate.getRelatedElements());
			relationshipSource = ((DirectedRelationship) relationshipToMutate).getSources().get(0);
			relationshipTarget = ((DirectedRelationship) relationshipToMutate).getTargets().get(0);
		} else {
			// System.err.println("Relationship");
			// System.err.println(relationshipToMutate.getRelatedElements());
			// This is to check the validity of the create command, hence the inverted ends are not that problematic
			relationshipSource = relationshipToMutate.getRelatedElements().get(1);
			relationshipTarget = relationshipToMutate.getRelatedElements().get(0);
		}
		// System.err.println(relationshipSource);
		// System.err.println(relationshipTarget);

		IElementEditService parentProvider = ElementEditServiceUtils.getCommandProvider(elementToMutateParent);
		IElementEditService sourceProvider = ElementEditServiceUtils.getCommandProvider(relationshipSource);
		if (parentProvider == null && sourceProvider == null) {
			return null;
		}

		for (IElementType elementType : relationshipTypes) {
			if (parentProvider != null) {
				ICommand createGMFCommandParent = null;
				TransactionalEditingDomain editingDomainParent = TransactionUtil.getEditingDomain(elementToMutateParent);
				CreateRelationshipRequest relationshipParentRequest = new CreateRelationshipRequest(editingDomainParent, elementToMutateParent, relationshipSource, relationshipTarget, elementType);
				createGMFCommandParent = parentProvider.getEditCommand(relationshipParentRequest);

				if (createGMFCommandParent != null && createGMFCommandParent.canExecute()) {
					filteredTypes.putIfAbsent(elementType, relationshipSource);
				}
			}

			if (sourceProvider != null) {
				ICommand createGMFCommandSource = null;
				TransactionalEditingDomain editingDomainSource = TransactionUtil.getEditingDomain(relationshipSource);
				CreateRelationshipRequest relationshipRequestSource = new CreateRelationshipRequest(editingDomainSource, relationshipSource, relationshipSource, relationshipTarget, elementType);
				createGMFCommandSource = parentProvider.getEditCommand(relationshipRequestSource);

				if (createGMFCommandSource != null && createGMFCommandSource.canExecute()) {
					filteredTypes.putIfAbsent(elementType, relationshipSource);
				}
			}

		}

		return filteredTypes;
	}

	/**
	 * Retrieves all the possible nodes that can be created from the element's context
	 * 
	 * @param elementToMutateParent
	 *            The element's parent
	 * @param elementToMutate
	 *            The element
	 * @param nodeTypes
	 *            The possible nodes that are declared in the registry
	 * @return
	 * 		The filtered nodes to be displayed in the viewer
	 */
	private Map<IElementType, EObject> getNodeTypes(EObject elementToMutateParent, EObject elementToMutate, Set<IElementType> nodeTypes) {
		Map<IElementType, EObject> filteredTypes = new HashMap<>();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToMutateParent);
		if (provider == null) {
			return null;
		}

		for (IElementType elementType : nodeTypes) {
			ICommand createGMFCommand = null;
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(elementToMutate);
			CreateElementRequest elementRequest = new CreateElementRequest(editingDomain, elementToMutateParent, elementType);
			createGMFCommand = provider.getEditCommand(elementRequest);

			if (createGMFCommand == null || !createGMFCommand.canExecute()) {
				continue;
			}
			filteredTypes.putIfAbsent(elementType, elementToMutateParent);
		}

		return filteredTypes;
	}

	@Override
	public ITransformationOnElement getTransformationOnElement() {
		Entry selectedEntry = getTypeSelected(fNewTypeTreeViewer.getSelection());
		// The null condition is already checked by the finalConditions method
		IElementType selectedType = (IElementType) selectedEntry.getKey();
		EObject associatedContainer = selectedEntry.getValue() != null ? (EObject) selectedEntry.getValue() : null;

		MutationTransformation mutation = new MutationTransformation(fModelSet, getMetaClassToMutate(),
				selectedType, associatedContainer);

		return mutation;
	}


	@Override
	/**
	 * Check that a meta-class is selected by the user in the {@link #fNewMetaClassTreeViewer}.
	 */
	public RefactoringStatus checkFinalConditions() {
		RefactoringStatus status = new RefactoringStatus();
		if (getTypeSelected(fNewTypeTreeViewer.getSelection()) == null) {
			status.addFatalError(Messages.MUTATIONREFACTORING_SELECTIONLABEL);
		}

		return status;
	}


	/**
	 * Verify that the operation can proceed and is not lacking parameters
	 * 
	 * @param selection
	 *            The selected Type to transform the object into
	 * @return
	 * 		The {@link IElementType} that represents the new UML element.
	 */
	private Entry<IElementType, EObject> getTypeSelected(ISelection selection) {

		if (selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
			if (selectedElement instanceof Entry) {
				Entry selectedEntry = (Entry) selectedElement;
				Object selectedType = selectedEntry.getKey();
				Object associatedContainer = selectedEntry.getValue();

				if (selectedType instanceof IElementType) {
					if (associatedContainer instanceof EObject) {
						return selectedEntry;
					}

					// We can't simply resolve the provided container therefore fall back on the default transformation
					selectedEntry.setValue(null);
					return selectedEntry;
				}
			}
		}

		return null;
	}


	/**
	 * Retrieves the EClass of the element to mutate
	 * 
	 * @return
	 */
	// We have checked in the checkIntialConditions method that all selected elements are instances of the same
	// UML metaClass, so to get the EClass to mutate we just need to get the EClass of one element of the selected
	// elements list.
	private EClass getMetaClassToMutate() {
		EObject elementToMutate = getElementToMutate();
		if (elementToMutate != null) {
			return elementToMutate.eClass();
		}

		return null;
	}

	/**
	 * Retrieves the EObject linked to the element to mutate
	 * 
	 * @return
	 */
	private EObject getElementToMutate() {
		if (fModelSet != null) {
			Iterator<EObject> it = PapyrusRefactoringUtils.getSelectedElements(fModelSet).iterator();
			if (it.hasNext()) {
				return it.next();
			}
		}

		return null;
	}


	@Override
	/**
	 * Check that at least one element is selected,and that all selected elements are instances of the same UML metaClass.
	 */
	public RefactoringStatus checkInitialConditions() {
		RefactoringStatus status = new RefactoringStatus();
		HashSet<EClass> eClassSelectedList = new HashSet<>();
		if (PapyrusRefactoringUtils.getSelectedElements(fModelSet).size() == 0) {
			status.addFatalError(Messages.MUTATIONREFACTORING_SELECTIONWARNING_EMPTY);

		} else {
			for (EObject element : PapyrusRefactoringUtils.getSelectedElements(fModelSet)) {
				eClassSelectedList.add(element.eClass());
			}

			if (eClassSelectedList.size() != 1) {
				status.addFatalError(Messages.MUTATIONREFACTORING_SELECTIONWARNING_UNIFORM);
			}
		}

		return status;
	}


	@Override
	public String getName() {
		return Messages.MUTATIONREFACTORING_PAGETITLE;
	}

	@Override
	public void performHelp() {
		// TODO Write the help
		// http://help.eclipse.org/mars/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fextension-points%2Forg_eclipse_help_contexts.html
		PlatformUI.getWorkbench().getHelpSystem().displayHelp("help context id");
	}


}
