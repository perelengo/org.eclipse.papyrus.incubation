/*****************************************************************************
 * Copyright (c) 2019 CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gitlight.compare.ui.internal.logical.view;

import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.compare.ide.ui.internal.logical.view.AbstractLogicalModelViewHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.ISubResourceFile;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Handle, for the Logical Model View, the Papyrus editors activations & files selections.
 */
public class PapyrusLMVHandler extends AbstractLogicalModelViewHandler {

	/**
	 * Retrieve the files associated with the given editor (via its {@link IWorkbenchPart}) or the given selection.
	 * 
	 * @param part
	 *            the {@link IWorkbenchPart}.
	 * @param selection
	 *            the {@link ISelection}.
	 * @return the files associated with the given editor or the given selection.
	 */
	@Override
	public Collection<IFile> getFiles(IWorkbenchPart part, ISelection selection) {
		final Set<IFile> files = Sets.newLinkedHashSet();
		if (part instanceof IEditorPart) {
			IEditorInput editorInput = ((IEditorPart)part).getEditorInput();
			if (editorInput instanceof IFileEditorInput) {
				files.add(((IFileEditorInput)editorInput).getFile());
			}
		}
		if (files.isEmpty() && selection instanceof TreeSelection) {
			Object element = ((TreeSelection)selection).getFirstElement();
			if (element instanceof IPapyrusFile) {
				files.add(((IPapyrusFile)element).getMainFile());
			} else if (element instanceof ISubResourceFile) {
				files.add(((ISubResourceFile)element).getFile());
			}
		}
		return files;
	}
}
