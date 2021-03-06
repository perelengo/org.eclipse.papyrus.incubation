/**
 */
package org.eclipse.papyrus.infra.gmfdiag.layers.model.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptor;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Layer Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class LayerDescriptorTest extends TestCase {

	/**
	 * The fixture for this Layer Descriptor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected LayerDescriptor fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LayerDescriptorTest.class);
	}

	/**
	 * Constructs a new Layer Descriptor test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public LayerDescriptorTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Layer Descriptor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void setFixture(LayerDescriptor fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Layer Descriptor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected LayerDescriptor getFixture() {
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
		setFixture(LayersFactory.eINSTANCE.createLayerDescriptor());
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

} // LayerDescriptorTest
