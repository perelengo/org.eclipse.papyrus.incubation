/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.diagramtemplate.editor.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagramtemplate.AbstractSelection;
import org.eclipse.papyrus.diagramtemplate.SelectionKind;
import org.eclipse.papyrus.diagramtemplate.SelectionRef;
import org.eclipse.papyrus.diagramtemplate.utils.CreationReport;
import org.eclipse.papyrus.diagramtemplate.utils.CreationReport.CreationReportKind;
import org.eclipse.papyrus.diagramtemplate.utils.ModelUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Relationship;

/**
 * @author Quentin Le Menez
 *
 */
public class PopulateDiagramCommand extends RecordingCommand {

	/**
	 * The diagram edit part
	 */
	DiagramEditPart diagramEditPart;

	/**
	 * The selection used for this diagram
	 */
	AbstractSelection selection;

	DiagramEditor diagramEditor;

	Diagram pageDiagram;

	/**
	 * The view of the elements added
	 */
	protected List<View> elementProcessed = new ArrayList<>();

	/**
	 * Constructor.
	 *
	 * @param domain
	 * @param label
	 */
	public PopulateDiagramCommand(TransactionalEditingDomain domain, String label, AbstractSelection selection, DiagramEditor diagramEditor) {
		super(domain, label);
		this.selection = selection;
		this.diagramEditor = diagramEditor;
		this.diagramEditPart = diagramEditor.getDiagramEditPart();
		this.pageDiagram = diagramEditor.getDiagram();
	}

	/**
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 *
	 */
	@Override
	protected void doExecute() {
		addElementsFor(selection.getSelectionRef(), pageDiagram.getElement(), diagramEditor, diagramEditPart);
	}


	/**
	 * Find the element to show depending on a list and try to add them to a specific editPart
	 *
	 * @param selectionList
	 *            The selection list of elements to add to the editPart
	 * @param root
	 *            The root to search the elements from
	 * @param activeEditor
	 *            the editor corresponding to the editPart
	 * @param editPartToShowIn
	 *            the editPart to show elements in
	 */
	protected void addElementsFor(List<?> selectionList, EObject root, DiagramEditor activeEditor, EditPart editPartToShowIn) {
		// Go through the SelectionRef
		for (Object object : selectionList) {
			if (!(object instanceof SelectionRef)) {
				continue;
			}

			SelectionRef selectionRef = (SelectionRef) object;

			// Retrieve the values
			Object result = root.eGet((EStructuralFeature) selectionRef.getEReference());
			List<EObject> resultsToProcess = new ArrayList<>();

			if (result instanceof List) {
				resultsToProcess.addAll((Collection<? extends EObject>) result);
			} else {
				resultsToProcess.add((EObject) result);
			}

			System.err.println(diagramEditor.getDiagram().getName() + ": " + diagramEditPart);

			if (selectionRef.getKind() == SelectionKind.FOR_ALL) {

				List<EObject> resultsToShow = new ArrayList<>();
				// Try to match constraints
				for (EObject elementToMatch : resultsToProcess) {
					// if (!(ModelUtils.getInstance().matchStereotypedBy(elementToMatch, selectionRef.getStereotypedBy()))) {
					if (!(ModelUtils.matchStereotypedBy(elementToMatch, selectionRef.getStereotypedBy()))) {
						continue;
					}

					if (selectionRef.isSubTypes()) {
						// Consider all subtypes
						if (elementToMatch.eClass().getEAllSuperTypes().contains(selectionRef.getElement()) || elementToMatch.eClass() == selectionRef.getElement()) {
							// It matches
							resultsToShow.add(elementToMatch);
						}
					} else {
						if (elementToMatch.eClass() == selectionRef.getElement()) {
							// It matches
							resultsToShow.add(elementToMatch);
						}
					}
				}

				// Process them all
				int i = 0;
				for (EObject elementToShow : resultsToShow) {

					// if (elementToShow instanceof org.eclipse.uml2.uml.Property) {
					// continue;
					// }
					EditPart actualEditPart = showElementIn(elementToShow, activeEditor, editPartToShowIn, i);
					if (null != actualEditPart) {
						// actualEditPart.refresh();
						processRecursively(actualEditPart, elementToShow, selectionRef, activeEditor);
					}
					i++;
				}

			} else {
				// FIXME Kind of very dirty
				for (EObject eObject : resultsToProcess) {
					String eObjectID = eObject.eResource().getURIFragment(eObject);
					String elementID = selectionRef.getElement().eResource().getURIFragment(selectionRef.getElement());
					if (eObjectID.equals(elementID)) {
						EditPart actualEditPart = showElementIn(eObject, activeEditor, editPartToShowIn, 0);
						// actualEditPart.refresh();
						processRecursively(actualEditPart, eObject, selectionRef, activeEditor);
					}
				}
			}
		}
	}


	/**
	 * Used to recursively process the template definition. It identifies the newly created editpart and recurses on it
	 *
	 * @param actualEditPart
	 *            the editpart elements was added to. It is used to find the newly created editpart
	 * @param elementToShow
	 *            the semantic element added
	 * @param selectionRef
	 *            the corresponding selectionRed
	 * @param activeEditor
	 *            the editor used
	 */
	protected void processRecursively(EditPart actualEditPart, EObject elementToShow,
			SelectionRef selectionRef, DiagramEditor activeEditor) {

		// Refresh the editPart of the newly added element
		actualEditPart.refresh();

		// Guess which of the View is the new one
		EditPartViewer viewer = actualEditPart.getViewer();
		Map<?, ?> map = viewer.getEditPartRegistry();

		// We must have a copy since map may change during the loop
		Map<?, ?> mapCopy = new HashMap<>(map);
		Iterator<?> it = mapCopy.keySet().iterator();
		boolean found = false;
		while (it.hasNext() && !found) {
			Object view = it.next();

			Object value = mapCopy.get(view);
			if (!(value instanceof GraphicalEditPart)) {
				continue;
			}
			GraphicalEditPart editPart = (GraphicalEditPart) value;

			// The element of the editPart and the element we just added must match
			String editPartSemanticElementID = editPart.resolveSemanticElement().eResource().getURIFragment(editPart.resolveSemanticElement());
			String elementToShowID = elementToShow.eResource().getURIFragment(elementToShow);
			if (!(editPartSemanticElementID.equals(elementToShowID))) {
				continue;
			}

			// The view should be the editpart whose parent's element is not the elementToShow
			boolean foundParentWithElementToShowAsElement = false;

			EditPart elementToProcess = editPart.getParent();
			while (elementToProcess != null && !foundParentWithElementToShowAsElement) {
				if (elementToProcess instanceof GraphicalEditPart) {
					String elementToProcessSemanticElementID = ((GraphicalEditPart) elementToProcess).resolveSemanticElement().eResource().getURIFragment(((GraphicalEditPart) elementToProcess).resolveSemanticElement());
					if (elementToProcessSemanticElementID.equals(elementToShowID)) {
						foundParentWithElementToShowAsElement = true;
						continue;
					}
				}

				elementToProcess = elementToProcess.getParent();
			}

			if (!foundParentWithElementToShowAsElement) {
				// Last we must be sure that it is really new one
				if (!elementProcessed.contains(view)) {
					// We can process it
					addElementsFor(selectionRef.getSelectionRef(), elementToShow, activeEditor, editPart);

					// FIXME we may need to add all new elements as processed
					// Record that it is processed
					elementProcessed.add((View) view);

					found = true;
				}
			}
		}
	}

	/**
	 * Try to show an element in an editPart (or its children)
	 *
	 * @param elementToShow
	 *            the element to show
	 * @param activeEditor
	 *            the editor corresponding to the editPart
	 * @param editPart
	 *            the editPart to show the element in
	 * @param position
	 *            position is used to try to distribute the drop
	 * @return
	 * 		the editPart in which the element has been actually added
	 */
	protected EditPart showElementIn(EObject elementToShow, DiagramEditor activeEditor, EditPart editPart, int position) {


		EditPart returnEditPart = null;

		if (elementToShow instanceof Element) {

			System.out.println(elementToShow);
			// We can't drop associations without the existing ends
			// FIXME This may be fixable if the existing drop strategies implemented in Papyrus are used
			if (elementToShow instanceof Relationship) {
				boolean hasEnds = true;
				List<EObject> test = new ArrayList<>();
				for (Object view : activeEditor.getDiagram().getChildren()) {
					EObject element = ((View) view).getElement();
					test.add(element);
				}
				for (Iterator<?> requiredEnds = ((Relationship) elementToShow).getRelatedElements().iterator(); requiredEnds.hasNext();) {
					Element end = (Element) requiredEnds.next();
					if (!(test.contains(end))) {
						hasEnds = false;
					}
					;
				}

				if (!hasEnds) {
					// we lack the ends to drop the relationship
					return returnEditPart;
				}

				// The editParts need to be refreshed in order to be able to drop connections
				// org.eclipse.papyrus.infra.gmfdiag.common.commands.CommonDeferredCreateConnectionViewCommand.doExecuteWithResult
				// editPart.refresh(); // May not be necessary anymore as we refresh the created elements one by one when we look for recursive creation
			}

			DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
			ArrayList<Element> list = new ArrayList<>();
			list.add((Element) elementToShow);
			dropObjectsRequest.setObjects(list);
			dropObjectsRequest.setLocation(new Point(20, 100 * position));
			Command commandDrop = editPart.getCommand(dropObjectsRequest);

			boolean processChildren = false;
			if (commandDrop == null) {
				processChildren = true;
			} else {
				if (commandDrop.canExecute()) {
					activeEditor.getDiagramEditDomain().getDiagramCommandStack().execute(commandDrop);
					returnEditPart = editPart;
					CreationReport.getInstance().addToReport(elementToShow, CreationReportKind.SUCCESS);
				} else {
					processChildren = true;
				}
			}

			if (processChildren) {
				// If the element is intended to be dropped inside a specific compartment/container
				// try to add to one of its children
				boolean found = false;

				ArrayList<EditPart> childrenList = new ArrayList<>();
				findAllChildren(childrenList, editPart);
				for (Object child : childrenList) {
					if (child instanceof EditPart) {
						Command commandDropChild = ((EditPart) child).getCommand(dropObjectsRequest);
						if (commandDropChild != null) {
							if (commandDropChild.canExecute()) {
								activeEditor.getDiagramEditDomain().getDiagramCommandStack().execute(commandDropChild);
								found = true;
								returnEditPart = (EditPart) child;
								CreationReport.getInstance().addToReport(elementToShow, CreationReportKind.SUCCESS);
								break;
							}
						}
					}
				}
				if (!found) {
					CreationReport.getInstance().addToReport(elementToShow, CreationReportKind.FAIL);
					returnEditPart = editPart;
				}
			}
		}

		return returnEditPart;
	}




	/**
	 * Util method used to find all the children of a certain editpart
	 *
	 * @param list
	 *            the children found recursively
	 * @param root
	 *            the root editpart to start the search from
	 */
	public static void findAllChildren(List<EditPart> list, EditPart root) {
		list.addAll(root.getChildren());
		for (Object editPart : root.getChildren()) {
			if (editPart instanceof EditPart) {
				findAllChildren(list, (EditPart) editPart);
			}
		}
	}


}
