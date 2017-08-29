/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Jeremie Tatibouet (CEA LIST)
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.text.representation.compare;

import org.eclipse.swt.graphics.Point;

public interface IAdvancedDifference {

	/**
	 * Provide the start index and the end index of the region concerned by the modification (at the left)
	 */
	Point getLeftFragmentPosition();

	/**
	 * Provide the start index and the end index of the region concerned by the modification (at the right)
	 */
	Point getRightFragmentPosition();

	/**
	 * Returns the region of the left hand side representation concerned by the difference
	 */
	String getLeftState();

	/**
	 * Returns the region of the right hand side representation concerned by the difference
	 */
	String getRightState();


}
