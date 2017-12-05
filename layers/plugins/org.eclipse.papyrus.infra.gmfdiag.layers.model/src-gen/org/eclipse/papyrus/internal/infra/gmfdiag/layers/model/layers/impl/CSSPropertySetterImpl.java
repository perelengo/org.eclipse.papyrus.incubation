/**
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl;

import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.AddAllModelStyleSheetCommand;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSPropertySetter;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance;

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
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertySetterImpl#setValue(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance)
	 *
	 * @param view
	 * @param value
	 */
	@Override
	public void setValue(View view, TypeInstance value) {
		Diagram d = view.getDiagram();
		StyleSheet ss;
		CSSDiagram cssD = null;
		TransactionalEditingDomain ted = null;

		EList<EStructuralFeature> features = view.eClass().getEStructuralFeatures();

		CSSInstance associatedCSS = (CSSInstance) value;
		ss = associatedCSS.getStylesheet();

		System.err.println(view);
		System.err.println(value);


		if (d instanceof CSSDiagram) {
			cssD = (CSSDiagram) d;
			if (ss != null && !cssD.getStyleSheets().contains(ss)) {
				try {
					ted = ServiceUtilsForResource.getInstance().getTransactionalEditingDomain(view.eResource());
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				StyleSheet sheet = associatedCSS.getStylesheet();
				if (sheet instanceof StyleSheetReference) {
					sheet = EcoreUtil.copy(sheet);
				} else if (sheet instanceof EmbeddedStyleSheet) {
					// TODO
				}
				AddAllModelStyleSheetCommand aamssc = new AddAllModelStyleSheetCommand(ted, view.eResource(), Collections.singletonList(sheet));

				ted.getCommandStack().execute(aamssc);

			}
		}
	}

} // CSSPropertySetterImpl
