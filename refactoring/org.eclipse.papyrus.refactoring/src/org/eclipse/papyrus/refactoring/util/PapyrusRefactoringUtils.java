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
package org.eclipse.papyrus.refactoring.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.refactoring.Activator;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Utils methods used to browse through the UML models and their {@link org.eclipse.papyrus.infra.core.resource.ModelSet ModelSet}
 * 
 */
public class PapyrusRefactoringUtils {


	/**
	 * Utils methods for refactoring.
	 * 
	 * @param modelSet
	 *            The provided modelSet
	 * @return
	 * 		The EObject associated with the root of the model or null
	 */
	public static EObject getUMLRoot(ModelSet modelSet) {
		try {
			UmlModel umlModel = (UmlModel) modelSet.getModelChecked(UmlModel.MODEL_ID);
			EObject root = umlModel.lookupRoot();
			return root;
		} catch (NotFoundException e) {
			Activator.log.error(e);

		}
		return null;
	}


	/**
	 * Get the semantic element associated to the specified adapter
	 * 
	 * @param semanticAdapter
	 *            The provided IAdatptable
	 * @return
	 * 		The associated EObject or null if none can be found
	 */
	protected EObject getSemanticElement(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		EObject eObject = semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			return EMFCoreUtil.resolve(TransactionUtil.getEditingDomain(eObject), eObject);
		}
		return null;
	}

	/**
	 * Fetch the owner of the provided element, if any
	 * 
	 * @param element
	 *            The provided element
	 * @return
	 * 		The owner or itself if none can be found
	 */
	public static Element getOwner(Element element) {
		Element rootElement = element;
		while (rootElement.getOwner() != null) {
			rootElement = rootElement.getOwner();
		}

		return rootElement;
	}


	private static EObject getRootElement(EObject element) {
		return EcoreUtil.getRootContainer(element);
	}

	/**
	 * Get all the elements contained in the provided modelSet
	 * 
	 * @param modelSet
	 *            The modelSet
	 * @return
	 * 		All the elements of the given modelSet.
	 */
	public static Collection<EObject> getAllElements(ModelSet modelSet) {
		List<EObject> elements = new ArrayList<>();
		EObject root = getUMLRoot(modelSet);
		if (root != null) {
			TreeIterator<EObject> iterator = root.eAllContents();
			while (iterator.hasNext()) {
				EObject element = iterator.next();
				if (element instanceof EObject) {
					elements.add(element);
				}
			}
		}
		return elements;
	}

	/**
	 * Method to get the selected elements in the Papyrus Editor and in the Model Explorer.
	 * 
	 * @param modelSet
	 *            The modelSet on which we want to get the selected elements.
	 * @return The UML elements selected by the user in the Papyrus editor.
	 */
	public static Collection<EObject> getSelectedElements(ModelSet modelSet) {
		Object[] selections = lookupSelectedElements();
		Collection<EObject> results = new ArrayList<>();
		Collection<EObject> allElements = getAllElements(modelSet);
		for (Object selectedObject : selections) {

			EObject selectedElement = null;
			if (selectedObject instanceof GraphicalEditPart) {
				Object graphicalElement = ((GraphicalEditPart) selectedObject).getModel();
				if ((graphicalElement instanceof View) && ((View) graphicalElement).getElement() instanceof EObject) {
					selectedElement = ((View) graphicalElement).getElement();
				}
			} else if (selectedObject instanceof IAdaptable) {
				EObject selectedEObject = ((IAdaptable) selectedObject).getAdapter(EObject.class);
				if (selectedEObject instanceof EObject) {
					selectedElement = selectedEObject;
				}
			}

			if (selectedElement != null) {
				for (EObject modelElement : allElements) {
					if (EcoreUtil.equals(selectedElement, modelElement)) {
						results.add(modelElement);
						break;
					}
				}
			}

		}
		return results;
	}


	private static Collection<EObject> searchElements(EClass[] participantsTypes, ModelSet modelSet) {
		Collection<EClass> participantsTypesList = Arrays.asList(participantsTypes);
		Collection<EObject> results = new HashSet<>();
		for (EObject modelElement : getAllElements(modelSet)) {
			if (participantsTypesList.contains(modelElement.eClass())) {
				results.add(modelElement);
			}
		}
		return results;
	}

	/**
	 * Search, in a given ModelSet, a specific EObject.
	 * 
	 * @param target
	 *            The EObject to search.
	 * @param modelSet
	 *            The modelSet from which we want the element.
	 * @return The EObject wanted in the given modelSet, null if not found.
	 */
	public static EObject findEObjectInModelSet(EObject target, ModelSet modelSet) {
		for (EObject element : PapyrusRefactoringUtils.getAllElements(modelSet)) {
			if (EcoreUtil.equals(element, target)) {
				return element;
			}
		}
		return null;
	}

	/**
	 * Fetch all the currently selected elements in the active workbench window
	 * 
	 * @return
	 * 		The graphicaly selected elements
	 */
	private static Object[] lookupSelectedElements() {

		IWorkbenchWindow page = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		ISelectionService service = page.getSelectionService();
		// set structured selection
		ISelection selection = service.getSelection();

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			return structuredSelection.toArray();
		} else if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			return treeSelection.toArray();
		}

		return null;
	}


	/**
	 * Get the associated UID of a selected EObject from the provided modelSet, if any
	 * 
	 * @param element
	 *            The provided element
	 * @param fModelSet
	 *            The provided modelSet in xhich the element should be
	 * @return
	 * 		The element's UID or null if it deos not exists in the provided modelSet
	 */
	public static String getRelatedXMIID(EObject element, ModelSet fModelSet) {
		String oldID = null;
		for (Resource resource : fModelSet.getResources()) {
			if (!(resource instanceof UMLResource) || oldID != null) {
				continue;
			}

			UMLResource umlResource = (UMLResource) resource;
			oldID = umlResource.getID(element);
		}

		return oldID;
	}

	/**
	 * Retrives the Eobject from its UID and the provided modelSet
	 * 
	 * @param XMIID
	 *            THe provided UID
	 * @param fModelSet
	 *            The provided modelSet in which the element should be referenced by the provided XMIID
	 * @return
	 * 		The element or null if there is no instance of the provided UID in the modelSet
	 */
	public static EObject getRelatedElement(String XMIID, ModelSet fModelSet) {
		EObject eObject = null;
		for (Resource resource : fModelSet.getResources()) {
			if (!(resource instanceof UMLResource) || eObject != null) {
				continue;
			}

			UMLResource umlResource = (UMLResource) resource;
			eObject = umlResource.getEObject(XMIID);
		}

		return eObject;
	}


	private static void setXMIID(Element elementToMutate, EObject newElement, ModelSet fModelSet) {
		String oldID = getRelatedXMIID(elementToMutate, fModelSet);
		for (Resource resource : fModelSet.getResources()) {
			if (!(resource instanceof UMLResource)) {
				continue;
			}

			UMLResource umlResource = (UMLResource) resource;
			if (umlResource.getID(newElement) == null) {
				continue;
			}

			umlResource.setID(newElement, oldID);
		}
	}

}
