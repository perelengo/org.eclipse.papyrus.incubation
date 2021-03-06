/**
 */
package org.eclipse.papyrus.infra.gmfdiag.layers.model.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StringType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>String Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class StringTypeTest extends TypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StringTypeTest.class);
	}

	/**
	 * Constructs a new String Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public StringTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this String Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected StringType getFixture() {
		return (StringType) fixture;
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
		setFixture(LayersFactory.eINSTANCE.createStringType());
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

} // StringTypeTest
