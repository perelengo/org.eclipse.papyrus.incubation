/*******************************************************************************
 * Copyright (c) 2013, 2016 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 *     Christian W. Damus - bug 485220
 *     
 ******************************************************************************/
package org.eclipse.papyrus.layers3.ui.utils;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.ui.util.ServiceUtilsForWorkbenchPage;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;


/**
 * Set of utilities methods for handlers {@link AbstractHandler}.
 *
 * @author cedric dumoulin
 *
 */
public class HandlersUtils {

	/**
	 * Constructor.
	 *
	 */
	public HandlersUtils() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Get the diagram associated to the currently selected editor.
	 * Throw events if no diagram is associated. <br>
	 * Warnings: This method is for handlers only. It can return unpredictable
	 * results if used during the application initialization phase.
	 *
	 * @return
	 * @throws NotFoundException
	 * @throws ServiceException
	 */
	public Diagram getDiagramFromCurrentEditor() throws ServiceException, NotFoundException {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (page == null) {
			throw new NotFoundException("No active IWorkbenchPage");
		}

		IEditorPart editor = ServiceUtilsForWorkbenchPage.getInstance().getService(ISashWindowsContainer.class, page).getActiveEditor();

		if (!(editor instanceof DiagramDocumentEditor)) {
			throw new NotFoundException("Selected editor do not contains Diagram");
		}
		DiagramDocumentEditor diagramEditor = (DiagramDocumentEditor) editor;

		Diagram diagram = diagramEditor.getDiagram();
		if (diagram == null) {
			throw new NotFoundException("Selected editor do not contains Diagram");
		}

		return diagram;
	}

}
