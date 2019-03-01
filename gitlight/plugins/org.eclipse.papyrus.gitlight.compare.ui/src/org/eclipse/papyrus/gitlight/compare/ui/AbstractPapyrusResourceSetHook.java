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
package org.eclipse.papyrus.gitlight.compare.ui;

import com.google.common.collect.ImmutableSet;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.ide.hook.AbstractResourceSetHooks;
import org.eclipse.papyrus.gitlight.compare.util.ModelExtensionUtil;

/**
 * Abstract resource set hook that is activated for Papyrus files.
 */
public abstract class AbstractPapyrusResourceSetHook extends AbstractResourceSetHooks {

	/**
	 * File extensions registered in Papyrus.
	 */
	protected final Set<String> fileExtensions = ImmutableSet
			.copyOf(ModelExtensionUtil.getRegisteredFileExtensions());

	/**
	 * Hooks in when any of the file extensions registered in Papyrus are loaded. {@inheritDoc}
	 */
	@Override
	public boolean isHookFor(final Collection<? extends URI> uris) {
		for (final URI uri : uris) {
			if (fileExtensions.contains(uri.fileExtension())) {
				return true;
			}
		}
		return false;
	}
}
