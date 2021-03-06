/**
 */
package org.eclipse.papyrus.infra.gmfdiag.layers.model.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LineType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Line Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class LineTypeTest extends TypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LineTypeTest.class);
	}

	/**
	 * Constructs a new Line Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public LineTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Line Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected LineType getFixture() {
		return (LineType) fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayersFactory.eINSTANCE.createLineType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} // LineTypeTest
