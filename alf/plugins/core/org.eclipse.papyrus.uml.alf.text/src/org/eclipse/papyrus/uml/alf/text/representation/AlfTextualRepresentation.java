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
package org.eclipse.papyrus.uml.alf.text.representation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.compare.IModificationDate;
import org.eclipse.compare.rangedifferencer.IRangeComparator;
import org.eclipse.compare.rangedifferencer.RangeDifference;
import org.eclipse.compare.rangedifferencer.RangeDifferencer;
import org.eclipse.papyrus.uml.alf.libraries.helper.BackupState;
import org.eclipse.papyrus.uml.alf.libraries.helper.BackupState.EditionStatus;
import org.eclipse.papyrus.uml.alf.text.representation.compare.LineComparator;
import org.eclipse.papyrus.uml.alf.text.representation.compare.LineDifference;
import org.eclipse.papyrus.uml.alf.text.representation.compare.StringUtil;
import org.eclipse.swt.graphics.Point;
import org.eclipse.uml2.uml.NamedElement;

public class AlfTextualRepresentation extends TextualRepresentation
		implements IAlfTextualRepresentation, IModificationDate {

	protected BackupState editionState;

	public AlfTextualRepresentation(NamedElement owner) {
		super(owner);
		this.editionState = new BackupState();
	}

	public boolean isSaved() {
		return this.editionState.status.equals(EditionStatus.SAVED);
	}

	public boolean isMerged() {
		return this.editionState.status.equals(EditionStatus.MERGED);
	}

	public void setEditionState(BackupState state) {
		this.editionState.timestamp = state.timestamp;
		this.editionState.status = state.status;
	}

	public BackupState getEditionState() {
		return this.editionState;
	}

	public EditionStatus getStatus() {
		if (this.editionState != null) {
			return this.editionState.status;
		}
		return null;
	}

	public long getModificationDate() {
		return this.editionState.timestamp.getTime();
	}

	/**
	 * Two representations are considered as different since the set of differences is not empty
	 */
	public boolean isDifferent(AlfTextualRepresentation representation) {
		return !this.compare(representation).isEmpty();
	}

	/**
	 * Returns the set of differences found between two representations
	 */
	public List<LineDifference> compare(AlfTextualRepresentation representation) {
		/* 1. Build comparator for each representation */
		IRangeComparator left = this.getRangeComparator();
		IRangeComparator right = representation.getRangeComparator();
		/* 2. Perform the differencing */
		RangeDifference[] differences = RangeDifferencer.findDifferences(left, right);
		/* 3. Build the result list */
		List<LineDifference> results = new ArrayList<LineDifference>();
		for (RangeDifference difference : differences) {
			results.add(new LineDifference(difference, this, representation, left, right));
		}
		return results;
	}

	public boolean merge(AlfTextualRepresentation representation) {
		// TODO
		return true;
	}

	/**
	 * Heuristic to reconcile to different textual representation of the same model element.
	 * If possible changes in <code>representation</code> are propagated into the current textual representation.
	 * There is no guarantee that the reconciliation phase does not introduce loss of data.
	 * 
	 * @return this - the current textual representation
	 */
	public AlfTextualRepresentation reconcile(AlfTextualRepresentation representation) {
		StringBuilder builder = new StringBuilder(this.text);
		int offset = 0;
		/* 1. Compute the list of differences */
		Iterator<LineDifference> differenceIterator = this.compare(representation).iterator();
		/* 2. Try to reconcile differences */
		while (differenceIterator.hasNext()) {

			/* 2.1. Retrieve the current difference and extract the position of the region to change (left) */
			LineDifference difference = differenceIterator.next();
			Point leftFragmentPosition = difference.getLeftFragmentPosition();

			/* 2.2. Split the regions impacted by the difference into lines */
			StringBuilder leftHandSideBuilder = new StringBuilder();
			String[] leftLines = difference.getLeftState().split(StringUtil.EOL);
			String[] rightLines = difference.getRightState().split(StringUtil.EOL);
			int maxLineCount = Math.max(leftLines.length, rightLines.length);

			/*
			 * 2.3. Integrate changes from left to right. In case where left hand side and right side
			 * have different sizes:
			 * A. right > left -> remaining lines in the right are preserved
			 * B. left > right -> remaining lines are integrated to the right
			 */
			for (int i = 0; i < maxLineCount; i++) {

				/* 2.3.1 Both sides have a definition of the same line */
				if (i < leftLines.length && i < rightLines.length) {
					if (!StringUtil.isNegligible(rightLines[i])) {
						leftHandSideBuilder.append(rightLines[i] + StringUtil.EOL);
					} else {
						leftHandSideBuilder.append(leftLines[i] + StringUtil.EOL);
					}
				} else {
					/* 2.3.2. The left side is larger than the right hand side */
					if (i < leftLines.length) {
						leftHandSideBuilder.append(leftLines[i] + StringUtil.EOL);
					} else {
						leftHandSideBuilder.append(rightLines[i] + StringUtil.EOL);
					}
				}
			}

			/* 2.4. Apply the change in the original representation */
			builder.delete(leftFragmentPosition.x + offset, leftFragmentPosition.y + offset);
			builder.insert(leftFragmentPosition.x + offset, leftHandSideBuilder);
			offset += leftHandSideBuilder.length() - difference.getLeftState().length();
		}

		/* 3. Delete the EOF separator added previously at the end and replace text of the current representation */
		if (builder.charAt(builder.length() - 1) == StringUtil.CHAR_EOL) {
			builder.deleteCharAt(builder.length());
		}
		this.setText(builder.toString());
		return this;
	}

	/**
	 * Rebase the current ALF representation onto the representation provided as parameter
	 * A rebase can only work if two representation concerns the same model element
	 * 
	 * @return this - the current textual representation
	 */
	public AlfTextualRepresentation rebase(AlfTextualRepresentation representation) {
		if (representation!= null && this.getOwner() == representation.getOwner()) {
			BackupState state = new BackupState();
			state.status = representation.getStatus();
			state.timestamp = new Timestamp(representation.getModificationDate());
			this.setEditionState(state);
			this.setText(representation.getContent());
		}
		return this;
	}

	/**
	 * Provide the comparator to be used to compare two textual representation
	 */
	protected IRangeComparator getRangeComparator() {
		return new LineComparator(this.text);
	}
}
