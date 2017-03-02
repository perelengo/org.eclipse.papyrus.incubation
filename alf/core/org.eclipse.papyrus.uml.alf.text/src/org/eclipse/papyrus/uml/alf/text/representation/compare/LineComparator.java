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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.compare.rangedifferencer.IRangeComparator;

public class LineComparator implements IRangeComparator {

	private List<String> lines;

	public LineComparator(final String content) {
		this.lines = new ArrayList<String>();
		for (String line : content.split("\n")) {
			lines.add(line);
		}
	}

	public String getLine(int index) {
		return this.lines.get(index);
	}

	@Override
	public int getRangeCount() {
		return this.lines.size();
	}

	@Override
	public boolean rangesEqual(int thisIndex, IRangeComparator other, int otherIndex) {
		String l1 = this.lines.get(thisIndex);
		String l2 = ((LineComparator) other).lines.get(otherIndex);
		return l1.equals(l2);
	}

	@Override
	public boolean skipRangeComparison(int length, int maxLength, IRangeComparator other) {
		return false;
	}

}
