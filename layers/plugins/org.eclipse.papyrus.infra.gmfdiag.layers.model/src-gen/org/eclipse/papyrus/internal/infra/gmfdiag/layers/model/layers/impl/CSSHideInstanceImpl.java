/**
 * Copyright (c) 2013, 2017 CEA LIST & LIFL 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *   Quentin Le Menez quentin.lemenez@cea.fr
 * 
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;

import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CSS Hide Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHideInstanceImpl#getStylesheet <em>Stylesheet</em>}</li>
 * <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHideInstanceImpl#getStyle <em>Style</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CSSHideInstanceImpl extends TypeInstanceImpl implements CSSHideInstance {
	/**
	 * The cached value of the '{@link #getStylesheet() <em>Stylesheet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStylesheet()
	 * @generated
	 * @ordered
	 */
	protected StyleSheet stylesheet;

	/**
	 * The default value of the '{@link #getStyle() <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStyle()
	 * @generated
	 * @ordered
	 */
	protected static final String STYLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStyle() <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStyle()
	 * @generated
	 * @ordered
	 */
	protected String style = STYLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CSSHideInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.CSS_HIDE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public StyleSheet getStylesheet() {
		return stylesheet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetStylesheet(StyleSheet newStylesheet, NotificationChain msgs) {
		StyleSheet oldStylesheet = stylesheet;
		stylesheet = newStylesheet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayersPackage.CSS_HIDE_INSTANCE__STYLESHEET, oldStylesheet, newStylesheet);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setStylesheet(StyleSheet newStylesheet) {
		if (newStylesheet != stylesheet) {
			NotificationChain msgs = null;
			if (stylesheet != null)
				msgs = ((InternalEObject) stylesheet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayersPackage.CSS_HIDE_INSTANCE__STYLESHEET, null, msgs);
			if (newStylesheet != null)
				msgs = ((InternalEObject) newStylesheet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LayersPackage.CSS_HIDE_INSTANCE__STYLESHEET, null, msgs);
			msgs = basicSetStylesheet(newStylesheet, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.CSS_HIDE_INSTANCE__STYLESHEET, newStylesheet, newStylesheet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getStyle() {
		return style;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setStyle(String newStyle) {
		String oldStyle = style;
		style = newStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.CSS_HIDE_INSTANCE__STYLE, oldStyle, style));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case LayersPackage.CSS_HIDE_INSTANCE__STYLESHEET:
			return basicSetStylesheet(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case LayersPackage.CSS_HIDE_INSTANCE__STYLESHEET:
			return getStylesheet();
		case LayersPackage.CSS_HIDE_INSTANCE__STYLE:
			return getStyle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case LayersPackage.CSS_HIDE_INSTANCE__STYLESHEET:
			setStylesheet((StyleSheet) newValue);
			return;
		case LayersPackage.CSS_HIDE_INSTANCE__STYLE:
			setStyle((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case LayersPackage.CSS_HIDE_INSTANCE__STYLESHEET:
			setStylesheet((StyleSheet) null);
			return;
		case LayersPackage.CSS_HIDE_INSTANCE__STYLE:
			setStyle(STYLE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case LayersPackage.CSS_HIDE_INSTANCE__STYLESHEET:
			return stylesheet != null;
		case LayersPackage.CSS_HIDE_INSTANCE__STYLE:
			return STYLE_EDEFAULT == null ? style != null : !STYLE_EDEFAULT.equals(style);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (style: "); //$NON-NLS-1$
		result.append(style);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void setValueFromString(String value) {
		int i = 0;
		i++;
		// TODO
		// if (value == null || value.length() == 0) {
		// return;
		// }
		//
		// // The value should contains the values, separated by comma
		// // "FontName, FontHeight, FontColor, Bold"
		// String[] values = value.split(",");
		// int i = 0;
		// try {
		// setFontName(values[i++].trim());
		// setFontHeigh(Integer.parseInt(values[i++].trim()));
		// setFontColor(Integer.parseInt(values[i++].trim()));
		// setBold(Boolean.parseBoolean(values[i++].trim()));
		// } catch (NumberFormatException e) {
		// // fail silently
		// e.printStackTrace();
		// }
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void setValueFromInstance(TypeInstance value) {
		int i = 0;
		i++;
		// TODO
		// Check if the value is of the right instance
		// if (!getClass().isInstance(value)) {
		// return;
		// }
		//
		// FontInstance instance = (FontInstance) value;
		// setFontName(instance.getFontName());
		// setFontHeigh(instance.getFontHeigh());
		// setFontColor(instance.getFontColor());
		// setBold(instance.isBold());
	}

} // CSSHideInstanceImpl
