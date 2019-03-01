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
package org.eclipse.papyrus.gitlight.compare.ui.contentmergeviewer;

import java.util.ResourceBundle;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.IViewerCreator;
import org.eclipse.emf.compare.ide.ui.internal.configuration.EMFCompareConfiguration;
import org.eclipse.emf.compare.ide.ui.internal.structuremergeviewer.provider.TreeNodeCompareInput;
import org.eclipse.emf.compare.ide.ui.internal.structuremergeviewer.provider.TreeNodeCompareInputLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * Creator for {@link PapyrusTreeContentMergeViewer}.
 */
@SuppressWarnings("restriction")
public class PapyrusTreeContentMergeViewerCreator implements IViewerCreator {

	/**
	 * {@inheritDoc}
	 */
	public Viewer createViewer(Composite parent, CompareConfiguration config) {
		final EMFCompareConfiguration emfConfig = new EMFCompareConfiguration(config);
		emfConfig.setLabelProvider(TreeNodeCompareInput.class, new TreeNodeCompareInputLabelProvider());
		final Viewer viewer = new PapyrusTreeContentMergeViewer(SWT.NONE,
				ResourceBundle.getBundle(PapyrusTreeContentMergeViewer.class.getName()), parent, emfConfig);
		return viewer;
	}

}
