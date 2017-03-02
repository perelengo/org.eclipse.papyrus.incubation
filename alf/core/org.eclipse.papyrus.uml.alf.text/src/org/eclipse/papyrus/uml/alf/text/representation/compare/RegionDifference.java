package org.eclipse.papyrus.uml.alf.text.representation.compare;

import org.eclipse.compare.rangedifferencer.IRangeComparator;
import org.eclipse.compare.rangedifferencer.RangeDifference;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;

public abstract class RegionDifference extends RangeDifference implements IAdvancedDifference {

	/**
	 * The left hand side comparator
	 */
	protected IRangeComparator leftC;

	/**
	 * The right hand side comparator
	 */
	protected IRangeComparator rightC;

	/**
	 * The left side representation
	 */
	protected AlfTextualRepresentation leftR;

	/**
	 * The right side representation
	 */
	protected AlfTextualRepresentation rightR;

	protected RegionDifference(RangeDifference d, AlfTextualRepresentation leftR,
			AlfTextualRepresentation rightR, IRangeComparator leftC, IRangeComparator rightC) {
		this(d.kind(), d.rightStart(), d.rightLength(), d.leftStart(),
				d.leftLength(), d.ancestorStart(), d.ancestorLength());
		this.leftC = leftC;
		this.rightC = rightC;
		this.leftR = leftR;
		this.rightR = rightR;
	}

	public RegionDifference(int kind, int rightStart, int rightLength, int leftStart, int leftLength,
			int ancestorStart, int ancestorLength) {
		super(kind, rightStart, rightLength, leftStart, leftLength, ancestorStart, ancestorLength);
	}

	/**
	 * Return true if the current difference represents a deletion. Typically a deletion means
	 * a member in the right state disappeared in the left state
	 */
	public boolean isDeletion() {
		return !StringUtil.isNegligible(this.getLeftState()) && StringUtil.isNegligible(this.getRightState());
	}

	/**
	 * Return true if the current difference represents an addition. An addition is the exact reverse
	 * of a deletion (i.e. we have a member in the left that does exists in the right states).
	 */
	public boolean isAddition() {
		return StringUtil.isNegligible(this.getLeftState()) && !StringUtil.isNegligible(this.getRightState());
	}

	/**
	 * Return true if the current difference represents a change. A change is an update of a member
	 * existing in the right state
	 */
	public boolean isChange() {
		return !StringUtil.isNegligible(this.getLeftState()) && !StringUtil.isNegligible(this.getRightState());
	}

	public String toString() {
		String serialization = "\n=======================DIFF=======================\n";
		serialization += this.getLeftState();
		serialization += "\n==================================================\n";
		serialization += this.getRightState();
		serialization += "\n=====================END DIFF=====================\n";
		return serialization;
	}

}
