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
package org.eclipse.papyrus.gitlight.compare.ui.internal.logical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.compare.ide.logical.IModelInclusionTester;

/**
 * This {@link IModelInclusionTester} includes the <code>properties</code>-file when dealing with Papyrus
 * models.
 * <p>
 * It does so not by blindly including any <code>properties</code>-file, but tests whether there is a
 * <code>di</code>-file next to it and only includes the <code>properties</code>-file if a
 * <code>di</code>-file was found.
 * </p>
 */
public class InternationalizationFileInclusionTester implements IModelInclusionTester {

	/** di-file extension. */
	private static final String DI = ".di"; //$NON-NLS-1$

	/** properties-file extension. */
	private static final String PROPERTIES_EXT = "properties"; //$NON-NLS-1$

	/** Regexp pattern to match locale and properties-file extension. */
	private static final String PATTERN_STRING = "[.]*(?:_..|_.._..)\\." + PROPERTIES_EXT + "$"; //$NON-NLS-1$ //$NON-NLS-2$

	/** Compiled regexp pattern. */
	private static final Pattern PATTERN = Pattern.compile(PATTERN_STRING);

	/**
	 * {@inheritDoc}
	 */
	public boolean shouldInclude(IFile file) {
		if (file != null && file.getParent() != null) {
			if (PROPERTIES_EXT.equals(file.getFileExtension())) {
				Matcher matcher = PATTERN.matcher(file.getName());
				if (matcher.find()) {
					String diFileName = matcher.replaceFirst(DI);
					Path diFilePath = new Path(diFileName);
					IFile equallyNamedDiFile = file.getParent().getFile(diFilePath);
					return equallyNamedDiFile.exists();
				}
			}
		}
		return false;
	}

}
