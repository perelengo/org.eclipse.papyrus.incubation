/*****************************************************************************
 * Copyright (c) 2010, 2018 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Florian Noyrit florian.noyrit@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagramtemplate.editor.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.commands.CreationCommandRegistry;
import org.eclipse.papyrus.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 *
 * Content provider for the diagram kinds
 *
 */
public class DiagramKindContentProvider implements IStructuredContentProvider {

	private static List<String> allowedDiagrams = Arrays.asList("org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand");


	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 *
	 */
	@Override
	public void dispose() {
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 *
	 * @param viewer
	 * @param oldInput
	 * @param newInput
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	/**
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 *
	 * @param inputElement
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof List) {
			List<ViewPrototype> categories = (List<ViewPrototype>) inputElement;

			List<ViewPrototype> result = new ArrayList<>();
			for (CreationCommandDescriptor desc : getCreationCommandRegistry().getCommandDescriptors()) {
				// FIXME This is used to filter out problematic diagrams
				// This will of course need to be remedied when all the available diagrams are working again
				if (!allowedDiagrams.contains(desc.getCommandId())) {
					continue;
				}

				for (ViewPrototype category : categories) {
					if (category.getLabel().equalsIgnoreCase(desc.getLabel())) {
						result.add(category);
						break;
					}
				}
			}

			return result.toArray();
		}
		return null;
	}

	/**
	 * Gets the creation command registry.
	 *
	 * @return the creation command registry
	 */
	private ICreationCommandRegistry getCreationCommandRegistry() {
		return CreationCommandRegistry.getInstance(org.eclipse.papyrus.infra.ui.Activator.PLUGIN_ID);
	}
}
