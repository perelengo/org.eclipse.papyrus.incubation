/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers;

import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CSS Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.CSSInstance#getStylesheet <em>Stylesheet</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getCSSInstance()
 * @model
 * @generated
 */
public interface CSSInstance extends TypeInstance {
	/**
	 * Returns the value of the '<em><b>Stylesheet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stylesheet</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Stylesheet</em>' containment reference.
	 * @see #setStylesheet(stylesheets.StyleSheet)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getCSSInstance_Stylesheet()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	StyleSheet getStylesheet();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.CSSInstance#getStylesheet <em>Stylesheet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Stylesheet</em>' containment reference.
	 * @see #getStylesheet()
	 * @generated
	 */
	void setStylesheet(StyleSheet value);

} // CSSInstance
