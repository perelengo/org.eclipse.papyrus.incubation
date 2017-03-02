/**
 */
package org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.MessageHandling;
import org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.NameBasedMsgMode;
import org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Handling</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.MessageHandlingImpl#getMessageMode <em>Message Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.MessageHandlingImpl#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.MessageHandlingImpl#getCustomTemplate <em>Custom Template</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageHandlingImpl extends MinimalEObjectImpl.Container implements MessageHandling {
	/**
	 * The default value of the '{@link #getMessageMode() <em>Message Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageMode()
	 * @generated
	 * @ordered
	 */
	protected static final NameBasedMsgMode MESSAGE_MODE_EDEFAULT = NameBasedMsgMode.DEFAULT;

	/**
	 * The cached value of the '{@link #getMessageMode() <em>Message Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageMode()
	 * @generated
	 * @ordered
	 */
	protected NameBasedMsgMode messageMode = MESSAGE_MODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Package() <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_Package;

	/**
	 * The default value of the '{@link #getCustomTemplate() <em>Custom Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOM_TEMPLATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCustomTemplate() <em>Custom Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomTemplate()
	 * @generated
	 * @ordered
	 */
	protected String customTemplate = CUSTOM_TEMPLATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageHandlingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrusDSMLValidationRulePackage.Literals.MESSAGE_HANDLING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameBasedMsgMode getMessageMode() {
		return messageMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageMode(NameBasedMsgMode newMessageMode) {
		NameBasedMsgMode oldMessageMode = messageMode;
		messageMode = newMessageMode == null ? MESSAGE_MODE_EDEFAULT : newMessageMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__MESSAGE_MODE, oldMessageMode, messageMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package getBase_Package() {
		if (base_Package != null && base_Package.eIsProxy()) {
			InternalEObject oldBase_Package = (InternalEObject)base_Package;
			base_Package = (org.eclipse.uml2.uml.Package)eResolveProxy(oldBase_Package);
			if (base_Package != oldBase_Package) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__BASE_PACKAGE, oldBase_Package, base_Package));
			}
		}
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_Package() {
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Package(org.eclipse.uml2.uml.Package newBase_Package) {
		org.eclipse.uml2.uml.Package oldBase_Package = base_Package;
		base_Package = newBase_Package;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomTemplate() {
		return customTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomTemplate(String newCustomTemplate) {
		String oldCustomTemplate = customTemplate;
		customTemplate = newCustomTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__CUSTOM_TEMPLATE, oldCustomTemplate, customTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__MESSAGE_MODE:
				return getMessageMode();
			case PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__BASE_PACKAGE:
				if (resolve) return getBase_Package();
				return basicGetBase_Package();
			case PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__CUSTOM_TEMPLATE:
				return getCustomTemplate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__MESSAGE_MODE:
				setMessageMode((NameBasedMsgMode)newValue);
				return;
			case PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)newValue);
				return;
			case PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__CUSTOM_TEMPLATE:
				setCustomTemplate((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__MESSAGE_MODE:
				setMessageMode(MESSAGE_MODE_EDEFAULT);
				return;
			case PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)null);
				return;
			case PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__CUSTOM_TEMPLATE:
				setCustomTemplate(CUSTOM_TEMPLATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__MESSAGE_MODE:
				return messageMode != MESSAGE_MODE_EDEFAULT;
			case PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__BASE_PACKAGE:
				return base_Package != null;
			case PapyrusDSMLValidationRulePackage.MESSAGE_HANDLING__CUSTOM_TEMPLATE:
				return CUSTOM_TEMPLATE_EDEFAULT == null ? customTemplate != null : !CUSTOM_TEMPLATE_EDEFAULT.equals(customTemplate);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (messageMode: ");
		result.append(messageMode);
		result.append(", customTemplate: ");
		result.append(customTemplate);
		result.append(')');
		return result.toString();
	}

} //MessageHandlingImpl
