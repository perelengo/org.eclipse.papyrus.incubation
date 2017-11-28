/**
 */
package org.eclipse.papyrus.infra.gmfdiag.layers.model.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeRegistry;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Type Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TypeRegistryTest extends TestCase {

	/**
	 * The fixture for this Type Registry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected TypeRegistry fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TypeRegistryTest.class);
	}

	/**
	 * Constructs a new Type Registry test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public TypeRegistryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Type Registry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void setFixture(TypeRegistry fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Type Registry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected TypeRegistry getFixture() {
		return fixture;
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
		setFixture(LayersFactory.eINSTANCE.createTypeRegistry());
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

} // TypeRegistryTest
