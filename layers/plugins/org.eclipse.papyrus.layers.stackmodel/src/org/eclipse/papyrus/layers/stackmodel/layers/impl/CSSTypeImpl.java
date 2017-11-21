/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.papyrus.layers.stackmodel.layers.CSSType;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CSS Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CSSTypeImpl extends TypeImpl implements CSSType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated Not
	 */
	protected CSSTypeImpl() {
		super();
		setName("CSSType");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.CSS_TYPE;
	}

	@Override
	public org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance createInstance() {
		return LayersFactory.eINSTANCE.createCSSInstance();
	};

} // CSSTypeImpl
