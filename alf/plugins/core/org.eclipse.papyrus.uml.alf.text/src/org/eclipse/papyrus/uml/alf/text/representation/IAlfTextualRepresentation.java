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
package org.eclipse.papyrus.uml.alf.text.representation;

import java.util.List;

import org.eclipse.papyrus.uml.alf.text.representation.compare.LineDifference;

public interface IAlfTextualRepresentation {

	public boolean isDifferent(AlfTextualRepresentation representation);

	public List<LineDifference> compare(AlfTextualRepresentation representation);

	public boolean merge(AlfTextualRepresentation representation);

	public AlfTextualRepresentation reconcile(AlfTextualRepresentation representation);

	public AlfTextualRepresentation rebase(AlfTextualRepresentation representation);
}
