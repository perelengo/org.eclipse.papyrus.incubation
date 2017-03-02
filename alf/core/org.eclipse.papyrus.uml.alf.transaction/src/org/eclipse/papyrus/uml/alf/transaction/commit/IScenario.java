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
 *  Jeremie Tatibouet
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.transaction.commit;

public abstract interface IScenario {

	/**
	 * Computations that need to be realized before the main method of the scenario
	 */
	public void before();

	/**
	 * Computations that need to be realized after the main method of the scenario
	 */
	public void after();

}
