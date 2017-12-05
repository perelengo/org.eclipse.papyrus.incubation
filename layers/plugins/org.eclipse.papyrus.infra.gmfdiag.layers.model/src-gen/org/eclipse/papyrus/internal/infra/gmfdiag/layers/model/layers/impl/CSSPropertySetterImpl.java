/**
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringListValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSStyles;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.AddAllCSSStyleSheetCommand;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.AddAllModelStyleSheetCommand;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.AddCSSStyleSheetCommand;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.AddCssClassStyleCommand;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.RemoveAllCSSStyleSheetValueCommand;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.RemoveCSSStyleSheetCommand;
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
		StyleSheet ass;
		CSSDiagram cssD = null;
		TransactionalEditingDomain ted = null;

		EList<EStructuralFeature> features = view.eClass().getEStructuralFeatures();

		CSSInstance associatedCSS = (CSSInstance) value;
		StyleSheet sheet = associatedCSS.getStylesheet();

		// System.err.println(view);
		// System.err.println(value);

		// CHeck if there is a styleSheet reference associated
		if (sheet == null) {
			return;
		}

		if (d instanceof CSSDiagram) {
			cssD = (CSSDiagram) d;
			// Get the Transactional Editing Domain associated to the diagram
			try {
				ted = ServiceUtilsForResource.getInstance().getTransactionalEditingDomain(view.eResource());
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// TODO find a way to remove a reference
			// if (!(cssD.getStyleSheets().isEmpty())) {
			// RemoveAllCSSStyleSheetValueCommand racssvc = new RemoveAllCSSStyleSheetValueCommand(ted, cssD,
			// CSSStyles.CSS_DIAGRAM_STYLESHEETS_KEY,
			// NotationPackage.eINSTANCE.getEObjectListValueStyle(),
			// NotationPackage.eINSTANCE.getEObjectListValueStyle_EObjectListValue(),
			// Collections.singleton(sheet));
			// racssvc.execute();
			// System.out.println("done!");
			// }

			URI sheetURI = sheet.eResource().getURI();
			boolean sheetIsApplied = false;
			for (StyleSheet ss : cssD.getStyleSheets()) {
				if (ss.eResource() != null && sheetURI.equals(ss.eResource().getURI()))
					sheetIsApplied = true;
			}

			if (!sheetIsApplied) {
				if (sheet instanceof StyleSheetReference) {
					sheet = EcoreUtil.copy(sheet);
				} else if (sheet instanceof EmbeddedStyleSheet) {
					// TODO if needed
				}

				AddCSSStyleSheetCommand aacssc = new AddCSSStyleSheetCommand(ted, cssD,
						CSSStyles.CSS_DIAGRAM_STYLESHEETS_KEY,
						NotationPackage.eINSTANCE.getEObjectListValueStyle(),
						NotationPackage.eINSTANCE.getEObjectListValueStyle_EObjectListValue(),
						sheet);
				aacssc.execute();
			}

			// Apply the style to the view if it has not been previously
			String style = associatedCSS.getStyle();
			if (style == null) {
				return;
			}

			List<String> appliedStyles = new ArrayList<String>();
			for (Object o : view.getStyles()) {
				if (!(o instanceof StringListValueStyle)) {
					continue;
				}
				StringListValueStyle slvs = (StringListValueStyle) o;
				if (!slvs.getStringListValue().isEmpty()) {
					appliedStyles.add((String) slvs.getStringListValue().get(0));
				}
			}
			if (appliedStyles.isEmpty() || !appliedStyles.contains(style)) {
				AddCssClassStyleCommand accsc = new AddCssClassStyleCommand(ted, view, style);
				accsc.execute();
			}
		}
	}

} // CSSPropertySetterImpl
