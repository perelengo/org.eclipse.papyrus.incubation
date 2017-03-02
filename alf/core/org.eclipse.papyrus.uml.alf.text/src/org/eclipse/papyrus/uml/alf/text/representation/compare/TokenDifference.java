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

import org.eclipse.compare.contentmergeviewer.ITokenComparator;
import org.eclipse.compare.rangedifferencer.IRangeComparator;
import org.eclipse.compare.rangedifferencer.RangeDifference;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;
import org.eclipse.swt.graphics.Point;

public class TokenDifference extends RegionDifference implements IAdvancedDifference {

	public TokenDifference(RangeDifference d, AlfTextualRepresentation leftR,
			AlfTextualRepresentation rightR, IRangeComparator leftC, IRangeComparator rightC) {
		super(d, leftR, rightR, leftC, rightC);
	}

	public String getLeftState() {
		String result = "";
		int startIndex = ((ITokenComparator) this.leftC).getTokenStart(this.leftStart);
		int endIndex = 0;
		for (int i = this.leftStart; i <= this.leftEnd(); i++) {
			endIndex += ((ITokenComparator) this.leftC).getTokenLength(i);
		}
		result = this.leftR.getContent().substring(startIndex, startIndex + endIndex);
		return result;
	}

	@Override
	public String getRightState() {
		String result = "";
		int endIndex = 0;
		int startIndex = ((ITokenComparator) this.rightC).getTokenStart(this.rightStart);
		for (int i = this.rightStart; i <= this.rightEnd(); i++) {
			endIndex += ((ITokenComparator) this.rightC).getTokenLength(i);
		}
		result = this.rightR.getContent().substring(startIndex, startIndex + endIndex);
		return result;
	}

	public Point getLeftFragmentPosition() {
		return new Point(((ITokenComparator) this.leftC).getTokenStart(this.leftStart),
				((ITokenComparator) this.leftC).getTokenStart(this.leftEnd()) + ((ITokenComparator) this.leftC).getTokenLength(this.leftEnd()));
	}

	public Point getRightFragmentPosition() {
		return new Point(((ITokenComparator) this.rightC).getTokenStart(this.rightStart),
				((ITokenComparator) this.rightC).getTokenStart(this.rightEnd()) + ((ITokenComparator) this.rightC).getTokenLength(this.rightEnd()));
	}

}
