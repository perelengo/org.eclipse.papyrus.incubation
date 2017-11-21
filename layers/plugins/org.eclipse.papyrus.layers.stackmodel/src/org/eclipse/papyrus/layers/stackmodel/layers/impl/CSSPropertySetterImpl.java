/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.layers.CSSPropertySetter;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CSS Property Setter</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CSSPropertySetterImpl extends PropertySetterImpl implements CSSPropertySetter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected CSSPropertySetterImpl() {
		super();
		setPropertyName("css");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.CSS_PROPERTY_SETTER;
	}

	/**
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertySetterImpl#setValue(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance)
	 *
	 * @param view
	 * @param value
	 */
	@Override
	public void setValue(View view, TypeInstance value) {
		Diagram d = view.getDiagram();
		// d.getES
		EObject feview;
		EList<EStructuralFeature> features = view.eClass().getEStructuralFeatures();
		// TODO set the css path
		int i = 0;
		i++;
	}

} // CSSPropertySetterImpl
