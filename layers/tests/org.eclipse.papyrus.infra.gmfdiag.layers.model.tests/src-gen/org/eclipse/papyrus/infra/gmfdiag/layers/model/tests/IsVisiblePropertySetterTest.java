/**
 */
package org.eclipse.papyrus.infra.gmfdiag.layers.model.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IsVisiblePropertySetter;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Is Visible Property Setter</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class IsVisiblePropertySetterTest extends PropertySetterTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IsVisiblePropertySetterTest.class);
	}

	/**
	 * Constructs a new Is Visible Property Setter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public IsVisiblePropertySetterTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Is Visible Property Setter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected IsVisiblePropertySetter getFixture() {
		return (IsVisiblePropertySetter) fixture;
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
		setFixture(LayersFactory.eINSTANCE.createIsVisiblePropertySetter());
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

} // IsVisiblePropertySetterTest
