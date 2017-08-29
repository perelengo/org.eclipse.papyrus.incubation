/**
 */
package org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Handling</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.MessageHandling#getMessageMode <em>Message Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.MessageHandling#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.MessageHandling#getCustomTemplate <em>Custom Template</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getMessageHandling()
 * @model
 * @generated
 */
public interface MessageHandling extends EObject {
	/**
	 * Returns the value of the '<em><b>Message Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.NameBasedMsgMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Mode</em>' attribute.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.NameBasedMsgMode
	 * @see #setMessageMode(NameBasedMsgMode)
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getMessageHandling_MessageMode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NameBasedMsgMode getMessageMode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.MessageHandling#getMessageMode <em>Message Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Mode</em>' attribute.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.NameBasedMsgMode
	 * @see #getMessageMode()
	 * @generated
	 */
	void setMessageMode(NameBasedMsgMode value);

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getMessageHandling_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.MessageHandling#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Custom Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Template</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Template</em>' attribute.
	 * @see #setCustomTemplate(String)
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getMessageHandling_CustomTemplate()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getCustomTemplate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.MessageHandling#getCustomTemplate <em>Custom Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Template</em>' attribute.
	 * @see #getCustomTemplate()
	 * @generated
	 */
	void setCustomTemplate(String value);

} // MessageHandling
