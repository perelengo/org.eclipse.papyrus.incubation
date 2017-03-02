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
package org.eclipse.papyrus.uml.refactoring.mutation.helper;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewRefactorHelper;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.SemanticElementAdapter;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.service.visualtype.VisualTypeService;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.refactoring.refactoringOnElement.ITransformationOnElement;
import org.eclipse.papyrus.refactoring.util.PapyrusRefactoringUtils;
import org.eclipse.papyrus.uml.refactoring.mutation.Activator;
import org.eclipse.papyrus.uml.refactoring.mutation.utils.ElementCreationUtils;
import org.eclipse.papyrus.uml.refactoring.mutation.utils.ModelNotationUtils;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Class use to mutate an UML element
 *
 */
public class MutationTransformation extends ViewRefactorHelper implements ITransformationOnElement {
	/** The ModelSet where the element is defined. */
	private ModelSet fModelSet;

	/** The {@link IElementEditService} related to the new metaClass. */
	private IElementEditService fProvider;

	/** The elementType the element will be an instance of. */
	private IElementType fNewElementType;

	/** The actual metaClass the element is an instance of. */
	private EClass fOldMetaClass;

	/** The new element created */
	private EObject newElement;

	/** The new view created */
	private View newView;

	/** The container of the new element */
	private EObject fContainer;


	/**
	 * Basic Constructor
	 *
	 * @param modelSet
	 * @param metaClassToMutate
	 * @param typeSelected
	 */
	public MutationTransformation(ModelSet modelSet, EClass metaClassToMutate, IElementType typeSelected) {
		fModelSet = modelSet;
		fNewElementType = typeSelected;
		fOldMetaClass = metaClassToMutate;
	}

	/**
	 * Constructor used in case of a relationship transformation or if the user wants to specify the container
	 *
	 * @param modelSet
	 * @param metaClassToMutate
	 * @param typeSelected
	 * @param container
	 */
	public MutationTransformation(ModelSet modelSet, EClass metaClassToMutate, IElementType typeSelected, EObject container) {
		fModelSet = modelSet;
		fNewElementType = typeSelected;
		fOldMetaClass = metaClassToMutate;
		fContainer = container;
	}


	@Override
	public void transformationToExecute(EObject element) {
		if (fContainer != null) {
			mutateElement(element, fContainer);
		} else {
			mutateElement(element, element.eContainer());
		}
	}

	/**
	 * Execute the steps to Mutate the element.
	 * 
	 * @param oldElement
	 *            The {@link EObject} to Mutate.
	 */
	private void mutateElement(EObject oldElement, EObject parent) {

		if (oldElement.eClass() != fOldMetaClass) {
			return;
		}

		fProvider = ElementEditServiceUtils.getCommandProvider(fNewElementType);
		if (fProvider == null) {
			return;
		}

		EObject newElement = createElement(fNewElementType, parent, oldElement);
		if (newElement == null
				|| !(newElement instanceof Element && oldElement instanceof Element)) {
			return;
		}

		Element elementToMutate = (Element) oldElement;
		Element mutatedElement = (Element) newElement;

		copyAppliedStereotypes(elementToMutate, mutatedElement);
		copyStructuralFeaturesValue(elementToMutate, mutatedElement);

		reorientRelationship(elementToMutate, mutatedElement);
		moveOwnedElements(elementToMutate, mutatedElement);
		updateReferences(elementToMutate, mutatedElement);

		updateNotation(elementToMutate, mutatedElement);

		destroyElement(elementToMutate);
		this.newElement = newElement;

	}

	/**
	 * Update the *.notation file to add the newElement's view to the model
	 * 
	 * @param elementToMutate
	 *            The old element
	 * @param newElement
	 *            The new element
	 */
	private void updateNotation(Element elementToMutate, EObject newElement) {
		View oldView = ModelNotationUtils.getRelatedView(elementToMutate, fModelSet);

		// Create a View corresponding to the new element based on the old configuration
		if (oldView != null) {
			if (oldView instanceof Node) {
				createNewNode((Node) oldView, newElement);
			}
			if (oldView instanceof Edge) {
				createNewEdge((Edge) oldView, newElement);
			}
		}
	}

	/**
	 * Create a new node to replace the old one
	 * 
	 * @param oldNode
	 * @param newElement
	 */
	private void createNewNode(Node oldNode, EObject newElement) {
		// New view inside its designed container or the default
		View containerView = ViewUtil.getViewContainer(oldNode);
		// if (containerView == null) {
		View containerView2 = fContainer != null ? ModelNotationUtils.getRelatedView(fContainer, fModelSet) : null;
		// }
		String visualID = VisualTypeService.getInstance().getNodeType(containerView, newElement);

		Node newNode = ViewService.createNode(containerView, newElement, visualID, getPreferencesHint());

		if (newNode != null) {
			copyNodeFeatures(oldNode, newNode);
			addOldVisibleChildren(newNode, ModelNotationUtils.getVisibleChildren(oldNode));
		}

		newView = newNode;
	}


	/**
	 * Find, if any exists, the corresponding type from *.elementtypeconfigurations in *di.elementtypeconfigurations
	 * used to find and create the visual representation of the element
	 * 
	 * @param visualID
	 * @return
	 * 		The {@link ISpecializationType} corresponding to the {@link IElementType} selected
	 */
	private ISpecializationType getSpecializationType(String visualID) {
		// TODO find a better way to filter the found element, e.g. ask the user which he wants
		for (ISpecializationType specializationType : ElementTypeRegistry.getInstance().getSpecializationsOf(fNewElementType.getId())) {
			if (!(specializationType instanceof IHintedType)) {
				continue;
			}

			IHintedType hintedType = (IHintedType) specializationType;
			if (hintedType.getSemanticHint().equalsIgnoreCase(visualID)) {
				// A type has been found
				return specializationType;
			}
		}

		return null;
	}

	/**
	 * Add the pertinent views to the notation node depending on th previous visibility
	 * 
	 * @param newView
	 * @param oldVisibleChildren
	 */
	private void addOldVisibleChildren(View newView, Set<View> oldVisibleChildren) {
		EObject newViewElement = newView.getElement();
		for (View oldViewChild : oldVisibleChildren) {
			// This in order to filter out the compartments
			if (!(oldViewChild instanceof Shape || oldViewChild instanceof Edge)) {
				continue;
			}

			EObject oldViewChildElement = oldViewChild.getElement();
			if (newViewElement.eContents().contains(oldViewChildElement)) {
				String visualID = null;
				View newViewChild = null;
				// Iterate on the contents of the node to see who can accommodate the subNode
				for (Object object : newView.getChildren()) {
					if (!(object instanceof View) || visualID != null) {
						continue;
					}

					newViewChild = (View) object;
					visualID = VisualTypeService.getInstance().getNodeType(newViewChild, oldViewChildElement);
				}

				Node newNode = ViewService.createNode(newViewChild, oldViewChildElement, visualID, getPreferencesHint());
				if (newNode != null) {
					Node oldNode = oldViewChild instanceof Node ? (Node) oldViewChild : null;
					if (oldNode != null) {
						copyNodeFeatures(oldNode, newNode);
					}
				}
			}
		}
	}

	/**
	 * Get hte active diagram's editPart from the multi diagram editor
	 * 
	 * @return
	 * 		The active diagram's DiagramEditPart
	 */
	public DiagramEditPart getHost() {
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		PapyrusMultiDiagramEditor papyrusEditor = editorPart instanceof PapyrusMultiDiagramEditor ? (PapyrusMultiDiagramEditor) editorPart : null;
		DiagramEditPart diagramEditPart = (DiagramEditPart) papyrusEditor.getAdapter(DiagramEditPart.class);

		return diagramEditPart;
	}

	/**
	 * Create a new edge to replace the old one
	 * 
	 * @param oldEdge
	 * @param newElement
	 */
	private void createNewEdge(Edge oldEdge, EObject newElement) {
		// New view inside its designed container or the default
		View containerView = fContainer != null ? ModelNotationUtils.getRelatedView(fContainer, fModelSet) : ViewUtil.getViewContainer(oldEdge);
		String visualID = VisualTypeService.getInstance().getLinkType(containerView.getDiagram(), newElement);

		// The IElementTypes required by the creation of a graphical representation are those inside the *di.elementtypesconfigurations
		// Else the Hint required by the Providers does not match the view and the view and the view wont be created
		ISpecializationType specializationType = getSpecializationType(visualID);
		SemanticElementAdapter semanticElementAdapter = new SemanticElementAdapter(newElement, specializationType);

		Edge newEdge = (Edge) ViewService.getInstance().createEdge(semanticElementAdapter, oldEdge.getDiagram(),
				visualID, ViewUtil.APPEND, getPreferencesHint());

		if (newEdge != null) {
			// copyEdgeFeatures(oldEdge, newEdge);
			// copyStructuralFeaturesValue(oldEdge, newEdge);
			newEdge.setSource(oldEdge.getSource());
			newEdge.setSourceAnchor(oldEdge.getSourceAnchor());
			newEdge.setTarget(oldEdge.getTarget());
			newEdge.setTargetAnchor(oldEdge.getTargetAnchor());
			newEdge.setBendpoints(oldEdge.getBendpoints());
		}

		newView = newEdge;
	}

	/**
	 * Create a new UML element.
	 * 
	 * @param elementType
	 *            The UML elementType the new element will be instance of.
	 * @param container
	 *            Represents the container of the new element to create.
	 * @param elementToMutate
	 * @return The new UML element
	 */
	private Element createElement(IElementType elementType, EObject container, EObject elementToMutate) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container);
		CreateElementRequest creationRequest = ElementCreationUtils.createElementRequest(fNewElementType, container, elementToMutate, fModelSet);

		ICommand createElementCommand = createCommand(provider, creationRequest);
		executeCommand(createElementCommand);

		EObject newElement = creationRequest.getNewElement();

		return ((newElement instanceof Element) ? (Element) newElement : null);
	}


	/**
	 * Apply, to a given element, the stereotypes,which are actually applied to an other UML element.
	 * 
	 * @param elementToMutate
	 *            The element with the wanted stereotypes.
	 * @param newElement
	 *            The element on which we will apply the stereotypes.
	 */
	private void copyAppliedStereotypes(Element elementToMutate, Element newElement) {
		for (Stereotype stereotype : elementToMutate.getAppliedStereotypes()) {
			if (newElement.isStereotypeApplicable(stereotype)) {
				EObject stereotypeApplied = newElement.applyStereotype(stereotype);
				if (stereotypeApplied instanceof Element) {
					copyStructuralFeaturesValue(stereotype, (Element) stereotypeApplied);
				}
			}
		}
	}

	/**
	 * Do a copy/paste of the {@link EStructuralFeature} from a source element to a target element.
	 * 
	 * @param elementToMutate
	 *            The source element.
	 * @param newElement
	 *            The target element.
	 */
	private void copyStructuralFeaturesValue(Element elementToMutate, Element newElement) {
		ICommand compositeCommand = null;

		for (EStructuralFeature structuralFeature : elementToMutate.eClass().getEAllStructuralFeatures()) {
			if (elementToMutate.eGet(structuralFeature) != null
					&& newElement.eClass().getEAllStructuralFeatures().contains(structuralFeature)
					&& !newElement.eClass().getEStructuralFeature(structuralFeature.getFeatureID()).isUnsettable()) {

				Activator.log.trace(Activator.REFACTORING_MUTATION_TRACE, structuralFeature.getName() + ", " + elementToMutate.eGet(structuralFeature));
				// if (structuralFeature.getName().equalsIgnoreCase("owner") && newElement instanceof DirectedRelationship
				// && !(elementToMutate instanceof DirectedRelationship) && elementToMutate instanceof Relationship) {
				// SetRequest setRequest = new SetRequest(newElement, structuralFeature, fContainer);
				// compositeCommand = CompositeCommand.compose(compositeCommand, createCommand(fProvider, setRequest));
				// } else {
				SetRequest setRequest = new SetRequest(newElement, structuralFeature, elementToMutate.eGet(structuralFeature));
				compositeCommand = CompositeCommand.compose(compositeCommand, createCommand(fProvider, setRequest));
				// }
			}
		}

		executeCommand(compositeCommand);
	}

	/**
	 * Move each element contained in a sourceElement to a targetElement (if the targetElement can contain the
	 * element owned by the source).
	 * 
	 * @param elementToMutate
	 * @param newElement
	 */
	private void moveOwnedElements(Element elementToMutate, Element newElement) {
		MoveRequest moveReq;
		ICommand compositeCommand = null;

		if (fProvider != null) {
			for (Element ownedElement : elementToMutate.getOwnedElements()) {
				moveReq = new MoveRequest(TransactionUtil.getEditingDomain(newElement), newElement, ownedElement);
				compositeCommand = CompositeCommand.compose(compositeCommand, createCommand(fProvider, moveReq));
			}
		}

		executeCommand(compositeCommand);
	}

	/**
	 * Find all usage references of a source element, and set this references to a target element.
	 * 
	 * @param elementToMutate
	 *            The source element.
	 * @param newElement
	 *            The target element.
	 */
	private void updateReferences(Element elementToMutate, Element newElement) {
		Collection<Setting> settingReferences = EcoreUtil.UsageCrossReferencer.find(elementToMutate,
				PapyrusRefactoringUtils.getAllElements(fModelSet));
		ICommand compositeCommand = null;
		Set<EObject> cacheUpdatedObjects = new HashSet<>();

		for (Setting setting : settingReferences) {
			EObject objectToUpdate = setting.getEObject();
			if (!cacheUpdatedObjects.contains(objectToUpdate)) {
				cacheUpdatedObjects.add(objectToUpdate);
				SetRequest setRequest = new SetRequest(setting.getEObject(), setting.getEStructuralFeature(), newElement);
				compositeCommand = CompositeCommand.compose(compositeCommand, createCommand(fProvider, setRequest));
			}
		}

		executeCommand(compositeCommand);
	}

	/**
	 * Find all the {@link Relationship} in which a source element is involved, then replace this source element
	 * by a target element in each {@link Relationship} found.
	 * 
	 * @param elementToMutate
	 *            The source element.
	 * @param newElement
	 *            The target element.
	 */
	private void reorientRelationship(Element elementToMutate, Element newElement) {
		ICommand compositeCommand = null;

		for (Relationship relationship : elementToMutate.getRelationships()) {

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(relationship);
			ReorientRelationshipRequest reorientReq;
			if (relationship instanceof DirectedRelationship) {
				if (((DirectedRelationship) relationship).getSources().contains(elementToMutate)) {
					reorientReq = new ReorientRelationshipRequest(TransactionUtil.getEditingDomain(relationship), relationship,
							newElement, elementToMutate, ReorientRequest.REORIENT_SOURCE);
				} else {
					reorientReq = new ReorientRelationshipRequest(TransactionUtil.getEditingDomain(relationship), relationship,
							newElement, elementToMutate, ReorientRequest.REORIENT_TARGET);
				}

				if (provider != null && reorientReq != null) {
					compositeCommand = CompositeCommand.compose(compositeCommand, createCommand(provider, reorientReq));
				}
			} else {
				Element source = (fContainer != null && fContainer instanceof Element) ? (Element) fContainer : relationship.getRelatedElements().get(1);

				if (EcoreUtil.equals(source, elementToMutate)) {
					reorientReq = new ReorientRelationshipRequest(TransactionUtil.getEditingDomain(relationship), relationship,
							newElement, elementToMutate, ReorientRequest.REORIENT_SOURCE);
				} else {
					reorientReq = new ReorientRelationshipRequest(TransactionUtil.getEditingDomain(relationship), relationship,
							newElement, elementToMutate, ReorientRequest.REORIENT_TARGET);
				}

				if (provider != null && reorientReq != null) {
					compositeCommand = CompositeCommand.compose(compositeCommand, createCommand(provider, reorientReq));
				}
			}
		}

		executeCommand(compositeCommand);
	}

	/**
	 * Destroy an element
	 * 
	 * @param elementToDestroy
	 *            The element to destroy.
	 */
	private void destroyElement(Element elementToDestroy) {
		DestroyElementRequest destroyReq = new DestroyElementRequest(elementToDestroy, false);
		ICommand compositeCommand = null;

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToDestroy);
		if (provider != null) {
			compositeCommand = CompositeCommand.compose(compositeCommand, createCommand(provider, destroyReq));
		}

		executeCommand(compositeCommand);
	}



	/**
	 * Create a command for a given request
	 * 
	 * @param request
	 *            The request to create the command for.
	 * @return The wanted command.
	 */
	private ICommand createCommand(IElementEditService provider, AbstractEditCommandRequest request) {
		ICommand command = provider.getEditCommand(request);
		return command;
	}

	/**
	 * If the command is valid, we execute it.
	 * 
	 * @param command
	 */
	private void executeCommand(ICommand command) {
		if (command != null && command.canExecute() /* && command.canUndo() */) {
			// try {
			// command.execute(new NullProgressMonitor(), null);
			// } catch (ExecutionException e) {
			// Activator.log.error(e);
			// }
			Command emfCommand = GMFtoEMFCommandWrapper.wrap(command);
			if (emfCommand.canExecute() /* && emfCommand.canUndo() */) {
				emfCommand.execute();
			}
		}
	}

	public EObject getMutatedElement() {
		return newElement;
	}

	public View getMutatedView() {
		return newView;
	}

}
