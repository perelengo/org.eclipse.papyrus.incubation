/**
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSType;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;

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
	 * @generated NOT
	 */
	protected CSSTypeImpl() {
		super();
		setName("CSSType");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.CSS_TYPE;
	}

	@Override
	public org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance createInstance() {
		return LayersFactory.eINSTANCE.createCSSInstance();
	};

} // CSSTypeImpl
