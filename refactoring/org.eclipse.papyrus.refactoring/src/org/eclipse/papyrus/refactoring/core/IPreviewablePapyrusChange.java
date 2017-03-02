/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.refactoring.core;

import org.eclipse.core.resources.IFile;

/**
 * Interface to present comparison between two files.
 * 
 * @noimplement This class is not intended to be implemented by clients.
 *
 */
public interface IPreviewablePapyrusChange {

	/**
	 * 
	 * @return The preview "di" file.
	 */
	public IFile getPreviewFile();

	/**
	 * 
	 * @return The original "di" file.
	 */
	public IFile getInitialFile();

}
