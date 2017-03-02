/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.infra.gmfdiag.elk;

import org.eclipse.core.runtime.Platform;
import org.eclipse.elk.conn.gmf.GmfDiagramLayoutConnector;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Override {@link GmfDiagramLayoutConnector} to access the diagram editor
 */
public class PapyrusDiagramLayoutConnector extends GmfDiagramLayoutConnector {

	/**
	 * @see org.eclipse.elk.conn.gmf.GmfDiagramLayoutConnector#getDiagramEditor(org.eclipse.ui.IWorkbenchPart)
	 *
	 * @param workbenchPart
	 * @return
	 */
	@Override
	protected DiagramEditor getDiagramEditor(IWorkbenchPart workbenchPart) {
			if (workbenchPart == null) {
				return null;
			}
			IEditorPart activeEditor = Platform.getAdapterManager().getAdapter(workbenchPart, IEditorPart.class);
			if (activeEditor instanceof IMultiDiagramEditor) {
				activeEditor = ((IMultiDiagramEditor) activeEditor).getActiveEditor();
			}

			if (activeEditor instanceof DiagramEditor) {
				return (DiagramEditor) activeEditor;
			}

			return null;
	}
}
