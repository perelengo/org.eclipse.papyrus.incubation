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
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.papyrus.uml.diagram.menu.actions.ArrangeAction;

/**
 * @author Quentin Le Menez
 *
 */
public class DiagramUtils {

	/**
	 * Helper method used to arrange recursively editparts
	 *
	 * @param editpart
	 *            the editpart to process
	 */
	public static void arrangeRecursively(EditPart editPart) {
		ArrangeRequest request = new ArrangeRequest(RequestConstants.REQ_ARRANGE_DEFERRED);
		List<EditPart> listToArrange = new ArrayList<>();
		listToArrange.addAll(editPart.getChildren());

		if (!listToArrange.isEmpty()) {
			for (Object element : editPart.getChildren()) {
				if (element instanceof EditPart) {
					arrangeRecursively((EditPart) element);
				}
			}

			request.setViewAdaptersToArrange(listToArrange);

			Command command = editPart.getCommand(request);
			if (null != command && command.canExecute()) {
				command.execute();
			}
		}
	}

	// FIXME This does not seem to execute itself the same as the arrangeAction handler does...
	public static void arrangeAll(DiagramEditPart editPart) {
		ArrangeAction arrangeall = new ArrangeAction(ArrangeAction.ARRANGE_ALL, new ArrayList<>());
		arrangeall.getCommand().execute();
	}


}
