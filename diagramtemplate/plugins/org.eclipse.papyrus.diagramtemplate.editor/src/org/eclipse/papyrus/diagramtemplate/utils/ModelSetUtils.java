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

package org.eclipse.papyrus.diagramtemplate.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.diagramtemplate.Template;
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager;
import org.eclipse.papyrus.infra.architecture.representation.PapyrusRepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureViewpoint;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * @author Quentin Le Menez
 *
 */
public class ModelSetUtils {

	/**
	 * List of diagram categories to consider
	 */
	// protected List<ViewPrototype> representationsKinds;

	// private static ModelSetUtils INSTANCE;

	// protected ModelSet modelSet;


	// public static ModelSetUtils getInstance() {
	// if (INSTANCE == null) {
	// INSTANCE = new ModelSetUtils();
	// }
	// return INSTANCE;
	// }


	/**
	 * Get the last opened ModelSet associated to the currently opened window
	 * 
	 * @return
	 * 		the ModelSet or null if none was found
	 */
	public static ModelSet getAssociatedModelSet() {
		return getAssociatedModelSet(null);
	}

	/**
	 * Get the ModelSet associated to the executed template in the currently opened window
	 * 
	 * @return
	 * 		the ModelSet or null if none was found
	 */
	public static ModelSet getAssociatedModelSet(Template template) {

		ModelSet modelSet = null;
		IMultiDiagramEditor part = getAssociatedPapyrusEditor(template);

		if (null != part && null == modelSet) {
			// try to resolve the modelSet from the active editor if no template has been provided
			try {
				modelSet = part.getServicesRegistry().getService(ModelSet.class);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}

		// initialize the available viewprototypes that will be used to match against the diagram creations (types)
		initializeDiagramCategories();

		return modelSet;
	}


	/**
	 * Used to get the the last opened MultiDiagramEditor part
	 * 
	 * @return
	 * 		The part or null if none has been found
	 */
	public static IMultiDiagramEditor getAssociatedPapyrusEditor() {
		return resolvePapyrusEditor(getActivePage(), null);
	}

	/**
	 * Used to get the the MultiDiagramEditor part associated to the executed template
	 * 
	 * @return
	 * 		The part or null if none has been found
	 */
	public static IMultiDiagramEditor getAssociatedPapyrusEditor(Template template) {
		return resolvePapyrusEditor(getActivePage(), template);
	}


	/**
	 * 
	 * @return
	 * 		The active workbench page
	 */
	private static IWorkbenchPage getActivePage() {
		try {
			IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if (activeWorkbenchWindow == null) {
				return null;
			}

			IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
			if (activePage == null) {
				return null;
			}

			return activePage;
		} catch (NullPointerException e) {
			// An element is not active yet
			return null;
		}
	}


	/**
	 * 
	 * @param activePage
	 * @param template
	 * @return
	 * 		The IMultiDiagramEditor or null if none has been found
	 */
	private static IMultiDiagramEditor resolvePapyrusEditor(IWorkbenchPage activePage, Template template) {
		// FIXME - This needs to ask the last handled (IMulti)DiangramEditor from the workspace
		// Eclipse can see it, as its tab is still in front of the others when switching to other editors
		// As it is this will work if the template points to a model but reverts to the last editor if not
		IMultiDiagramEditor part = null;

		if (null == activePage) {
			return part;
		}

		for (IEditorReference editorRef : activePage.getEditorReferences()) {
			IEditorPart editorPart = editorRef.getEditor(true);

			IMultiDiagramEditor multiDiagramEditor = editorPart instanceof IAdaptable ? ((IAdaptable) editorPart).getAdapter(IMultiDiagramEditor.class) : null;
			if (null != multiDiagramEditor) {
				part = multiDiagramEditor;
			}

			if (null != template) {
				EObject templateRoot = template.getTargetRoot();
				if (null == templateRoot) {
					continue;
				}

				URI modelURI = templateRoot.eResource().getURI().trimFileExtension();
				try {
					ModelSet modelSet = part.getServicesRegistry().getService(ModelSet.class);
					if (null == modelSet) {
						continue;
					}

					if (!modelSet.getURIWithoutExtension().equals(modelURI)) {
						continue;
					}

					return part;
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}
		}

		return part;
	}


	/**
	 * Get the ViewPrototypes associated to the Papyrus diagrams
	 * 
	 * @return
	 * 		The list of the ViewPrototypes or null if none can be found
	 */
	public static List<ViewPrototype> getRepresentationKinds() {
		// if (representationsKinds == null || representationsKinds.isEmpty()) {
		// initializeDiagramCategories();
		// }
		//
		// return representationsKinds;
		return initializeDiagramCategories();
	}


	/**
	 * Get the ViewPrototypes associated to the viewpoint
	 * 
	 * @param modelSet
	 */
	// private void initializeDiagramCategories() {
	private static List<ViewPrototype> initializeDiagramCategories() {
		List<ViewPrototype> representationsKinds = new ArrayList<>();

		ArchitectureDomainManager manager = ArchitectureDomainManager.getInstance();
		Collection<MergedArchitectureContext> contexts = manager.getVisibleArchitectureContexts();

		for (MergedArchitectureContext mergedArchitectureContext : contexts) {
			Collection<MergedArchitectureViewpoint> viewpoints = mergedArchitectureContext.getViewpoints();

			for (MergedArchitectureViewpoint mergedArchitectureViewpoint : viewpoints) {
				Collection<RepresentationKind> representations = mergedArchitectureViewpoint.getRepresentationKinds();
				for (RepresentationKind representationKind : representations) {
					if (representationKind instanceof PapyrusRepresentationKind) {
						representationsKinds.add(ViewPrototype.get((PapyrusRepresentationKind) representationKind));
					}
				}
			}
		}

		return representationsKinds;
	}

	// public void clear() {
	// INSTANCE = null;
	// modelSet = null;
	// representationsKinds.clear();
	// }
}
