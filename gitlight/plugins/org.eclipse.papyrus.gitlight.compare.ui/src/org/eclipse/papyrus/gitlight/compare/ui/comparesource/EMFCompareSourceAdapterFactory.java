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
package org.eclipse.papyrus.gitlight.compare.ui.comparesource;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.compare.ide.ui.source.IEMFComparisonSource;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;

/**
 * The {@link IAdapterFactory} for {@link IEMFComparisonSource}s.
 */
@SuppressWarnings({"unchecked", "rawtypes" })
public class EMFCompareSourceAdapterFactory implements IAdapterFactory {

	/**
	 * {@inheritDoc}
	 */
	public Class[] getAdapterList() {
		return new Class[] {IEMFComparisonSource.class };
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (IEMFComparisonSource.class.equals(adapterType)) {
			return new PapyrusFileEMFCompareSourceAdapter((IPapyrusFile)adaptableObject);
		}
		return null;
	}

}
