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
package org.eclipse.papyrus.uml.alf.text.representation.compare;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.compare.contentmergeviewer.ITokenComparator;
import org.eclipse.compare.contentmergeviewer.TokenComparator;
import org.eclipse.compare.rangedifferencer.IRangeComparator;
import org.eclipse.compare.rangedifferencer.RangeDifference;
import org.eclipse.compare.rangedifferencer.RangeDifferencer;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;
import org.eclipse.swt.graphics.Point;

/**
 * This class represent a difference between regions of two representations
 */
public class LineDifference extends RegionDifference implements IAdvancedDifference {

	public LineDifference(RangeDifference d, AlfTextualRepresentation leftR,
			AlfTextualRepresentation rightR, IRangeComparator leftC, IRangeComparator rightC) {
		super(d, leftR, rightR, leftC, rightC);
	}

	public String getLeftState() {
		Point position = this.getLeftFragmentPosition();
		return this.leftR.getContent().substring(position.x, position.y);
	}

	public String getRightState() {
		Point position = this.getRightFragmentPosition();
		return this.rightR.getContent().substring(position.x, position.y);
	}

	public Point getLeftFragmentPosition() {
		String[] leftLines = this.leftR.getContent().split(StringUtil.EOL);
		int startIndex = 0;
		for (int i = 0; i < this.leftStart; i++) {
			startIndex += leftLines[i].length() + 1;
		}
		int endIndex = startIndex;
		for (int i = this.leftStart; i < this.leftEnd(); i++) {
			if (this.leftEnd() == leftLines.length) {
				endIndex += leftLines[i].length();
			} else {
				endIndex += leftLines[i].length() + 1;
			}
		}
		return new Point(startIndex, endIndex);
	}

	public Point getRightFragmentPosition() {
		String[] rightLines = this.rightR.getContent().split(StringUtil.EOL);
		int startIndex = 0;
		for (int i = 0; i < this.rightStart; i++) {
			startIndex += rightLines[i].length() + 1;
		}
		int endIndex = startIndex;
		for (int i = this.rightStart; i < this.rightEnd(); i++) {
			if (this.rightEnd() == rightLines.length) {
				endIndex += rightLines[i].length();
			} else {
				endIndex += rightLines[i].length() + 1;
			}
		}
		return new Point(startIndex, endIndex);
	}

	/**
	 * return all the differences between tokens present in the left line and
	 * those present at the right line
	 * 
	 * @return tokenDifferences - the list of differences
	 */
	public List<TokenDifference> getChildren() {
		ITokenComparator leftTokenComparator = new TokenComparator(this.getLeftState());
		ITokenComparator rightTokenComparator = new TokenComparator(this.getRightState());
		AlfTextualRepresentation leftRepresentation = new AlfTextualRepresentation(null);
		leftRepresentation.setText(this.getLeftState());
		AlfTextualRepresentation rightRepresentation = new AlfTextualRepresentation(null);
		leftRepresentation.setText(this.getRightState());
		RangeDifference[] differences = RangeDifferencer.findDifferences(leftTokenComparator, rightTokenComparator);
		List<TokenDifference> tokenDifferences = new ArrayList<TokenDifference>();
		for (RangeDifference difference : differences) {
			tokenDifferences.add(new TokenDifference(difference, leftRepresentation, rightRepresentation, leftTokenComparator, rightTokenComparator));
		}
		return tokenDifferences;
	}

}