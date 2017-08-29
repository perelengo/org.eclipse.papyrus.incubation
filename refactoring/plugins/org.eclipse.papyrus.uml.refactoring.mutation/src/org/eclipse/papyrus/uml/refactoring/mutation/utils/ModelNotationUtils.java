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
package org.eclipse.papyrus.uml.refactoring.mutation.utils;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.resource.CSSNotationResource;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * Utils methods used to browse through the notation model
 * 
 */
public class ModelNotationUtils {

	/**
	 * Retrieves all the {@link org.eclipse.gmf.runtime.notation.Edge edges} of the diagram
	 * 
	 * @param cssDiagram
	 * @return
	 * 		The list of the diagram edges
	 */
	public static Set<View> getAllEdges(CSSDiagram cssDiagram) {
		Set<View> allChildren = new HashSet<>();
		for (Object object : cssDiagram.getEdges()) {
			if (!(object instanceof Edge)) {
				continue;
			}

			Edge view = (Edge) object;
			allChildren.add(view);
			allChildren.addAll(getAllEdges(view));
		}

		return allChildren;
	}

	/**
	 * Retrieves all the children {@link org.eclipse.gmf.runtime.notation.Edge edges} of the provided View
	 * 
	 * @param currentView
	 * @return
	 * 		The list of the children edges
	 */
	public static Set<View> getAllEdges(Edge currentView) {
		Set<View> allChildren = new HashSet<>();
		for (Object object : currentView.getChildren()) {
			if (!(object instanceof Edge)) {
				continue;
			}

			Edge view = (Edge) object;
			allChildren.add(view);
			allChildren.addAll(getAllEdges(view));
		}

		return allChildren;
	}

	/**
	 * Retrieves all the {@link org.eclipse.gmf.runtime.notation.View views} of the diagram
	 * 
	 * @param cssDiagram
	 * @return
	 * 		The list of the diagram views
	 */
	public static Set<View> getAllChildren(CSSDiagram cssDiagram) {
		Set<View> allChildren = new HashSet<>();
		for (Object object : cssDiagram.getChildren()) {
			if (!(object instanceof View)) {
				continue;
			}

			View view = (View) object;
			allChildren.add(view);
			allChildren.addAll(getAllChildren(view));
		}

		return allChildren;
	}

	/**
	 * Retrieves all the children {@link org.eclipse.gmf.runtime.notation.View views} of the provided View
	 * 
	 * @param currentView
	 * @return
	 * 		The list of the children views
	 */
	public static Set<View> getAllChildren(View currentView) {
		Set<View> allChildren = new HashSet<>();
		for (Object object : currentView.getChildren()) {
			if (!(object instanceof View)) {
				continue;
			}

			View view = (View) object;
			allChildren.add(view);
			allChildren.addAll(getAllChildren(view));
		}

		return allChildren;
	}

	/**
	 * Get all the visible {@link org.eclipse.gmf.runtime.notation.View children} of the old node
	 * 
	 * @param oldView
	 * @return
	 * 		The list of all the views
	 */
	public static Set<View> getVisibleChildren(View oldView) {
		Set<View> visibleChildren = new HashSet<>();

		for (Object viewChild : oldView.getVisibleChildren()) {
			if (!(viewChild instanceof View)) {
				continue;
			}

			View view = (View) viewChild;
			visibleChildren.add(view);
			visibleChildren.addAll(getVisibleChildren(view));
		}

		return visibleChildren;
	}

	/**
	 * Retrive the {@link org.eclipse.gmf.runtime.notation.View View} associated with the provided element in the provided model
	 * 
	 * @param element
	 *            The {@link org.eclipse.emf.ecore.EObject element} to match
	 * @param fModelSet
	 *            The {@link org.eclipse.papyrus.infra.core.resource.ModelSet model} to search
	 * @return
	 * 		The associated View or null if none can be found
	 */
	public static View getRelatedView(EObject element, ModelSet fModelSet) {

		NotationModel notationModel = (NotationModel) fModelSet.getModel(NotationModel.MODEL_ID);

		CSSNotationResource notationResource = (CSSNotationResource) notationModel.getResource();
		for (EObject eObject : notationResource.getContents()) {
			if (!(eObject instanceof CSSDiagram)) {
				continue;
			}

			CSSDiagram cssDiagram = (CSSDiagram) eObject;
			// if (!(EcoreUtil.equals(element, cssDiagram.getElement()))) {
			// if (cssDiagram instanceof View) {
			// // The View has been found in case of the element to mutate is the root model
			// return cssDiagram;
			// }
			// }

			// First iterate through all the Nodes
			for (Object object : ModelNotationUtils.getAllChildren(cssDiagram)) {
				if (!(object instanceof Shape)) {
					continue;
				}

				Shape shape = (Shape) object;
				if (!(EcoreUtil.equals(element, shape.getElement()))) {
					continue;
				}

				if (object instanceof Node) {
					// The View has been found
					return (Node) object;
				}
			}

			// Then iterate through all the Edges
			for (Object object : ModelNotationUtils.getAllEdges(cssDiagram)) {
				if (!(object instanceof Connector)) {
					continue;
				}

				Connector connector = (Connector) object;
				if (!(EcoreUtil.equals(element, connector.getElement()))) {
					continue;
				}

				if (object instanceof Edge) {
					// The View has been found
					return (Edge) object;
				}
			}
		}

		// The element has no *.notation representation
		return null;
	}


	private static String getVisualID(View containerView, EObject newElement, ModelSet modelSet) {
		// View diagramView = containerView.getDiagram();
		// Diagram diagram = (Diagram) diagramView;
		// List<View> children = diagram.getChildren();
		// String diagramType = diagram.getType();
		//
		// DropObjectsRequest dropRequest = new DropObjectsRequest();
		// RequestUtils.setUseGUI(dropRequest, false);
		// dropRequest.setObjects(Collections.singletonList(newElement));
		// dropRequest.setLocation(new Point());

		// DiagramExpansionsRegistry registry = new DiagramExpansionsRegistry();
		// UseContext useContent = registry.getUsage(diagramType);
		// ChildrenListRepresentation childrenListRepresentation = registry.mapChildreen.get(diagramType);
		// List<String> childrenList = childrenListRepresentation.parentChildrenRelation.get(diagramType);

		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		PapyrusMultiDiagramEditor papyrusEditor = editorPart instanceof PapyrusMultiDiagramEditor ? (PapyrusMultiDiagramEditor) editorPart : null;
		// DiagramEditPart diagramEditPart = multiDiagramEditor.getDiagramEditPart();
		// diagramEditPart.getChildren();
		DiagramEditPart diagramEditPart = (DiagramEditPart) papyrusEditor.getAdapter(DiagramEditPart.class);
		// List<EditPart> childrenPart = diagramEditPart.getChildren();
		// for (EditPart editPart : childrenPart) {
		// GraphicalEditPart graphicalEditPart = editPart instanceof GraphicalEditPart ? (GraphicalEditPart) editPart : null;
		// if (EcoreUtil.equals(containerView.getElement(), graphicalEditPart.getNotationView().getElement())) {
		// Command command = graphicalEditPart.getCommand(dropRequest);
		// editPart.getViewer().getEditDomain().getCommandStack().execute(command);
		// }
		// }
		// if (EcoreUtil.equals(containerView.getElement(), diagramEditPart.getNotationView().getElement())) {
		// Command command = diagramEditPart.getCommand(dropRequest);
		// diagramEditPart.getViewer().getEditDomain().getCommandStack().execute(command);
		// }



		return null;
	}

}
