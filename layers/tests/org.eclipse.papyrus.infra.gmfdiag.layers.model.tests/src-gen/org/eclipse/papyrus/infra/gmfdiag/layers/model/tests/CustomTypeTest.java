/**
 */
package org.eclipse.papyrus.infra.gmfdiag.layers.model.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomType;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Custom Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CustomTypeTest extends TypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CustomTypeTest.class);
	}

	/**
	 * Constructs a new Custom Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public CustomTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Custom Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected CustomType getFixture() {
		return (CustomType) fixture;
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
		setFixture(LayersFactory.eINSTANCE.createCustomType());
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

} // CustomTypeTest
