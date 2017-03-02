/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation;

/**
 * This interface contains all constants to work with the profile DSMLValidationRule
 *
 */
public interface IDSMLValidation {
	/** Qualified name of the stereotype ValidationRule */
	public static final String VALIDATIONRULE_STEREOTYPE = "PapyrusDSMLValidationRule::ValidationRule"; //$NON-NLS-1$
	
	/** name of property severity of the stereotype ValidationRule */
	public static final String VALIDATIONRULE_SEVERITY_ATT = "severity"; //$NON-NLS-1$
	
	/** name of property mode of the stereotype ValidationRule */
	public static final String VALIDATIONRULE_MODE_ATT = "mode"; //$NON-NLS-1$
	
	/** name of property isEnabledByDefault of the stereotype ValidationRule */
	public static final String VALIDATIONRULE_ISENABLEDBYDEFAULT_ATT = "isEnabledByDefault"; //$NON-NLS-1$
	
	/** name of property base_Constraint of the stereotype ValidationRule */
	public static final String VALIDATIONRULE_BASE_CONSTRAINT_ATT = "base_Constraint"; //$NON-NLS-1$
	
	/** name of property statusCode of the stereotype ValidationRule */
	public static final String VALIDATIONRULE_STATUSCODE_ATT = "statusCode"; //$NON-NLS-1$
	
	/** name of property message of the stereotype ValidationRule */
	public static final String VALIDATIONRULE_MESSAGE_ATT = "message"; //$NON-NLS-1$
	
	/** name of property description of the stereotype ValidationRule */
	public static final String VALIDATIONRULE_DESCRIPTION_ATT = "description"; //$NON-NLS-1$
	
	/** name of property target of the stereotype ValidationRule */
	public static final String VALIDATIONRULE_TARGET_ATT = "target"; //$NON-NLS-1$
	
	/** name of property class of the stereotype ValidationRule */
	public static final String VALIDATIONRULE_CLASS_ATT = "class"; //$NON-NLS-1$
	
	/** name of property id of the stereotype ValidationRule */
	public static final String VALIDATIONRULE_ID_ATT = "id"; //$NON-NLS-1$
	
	/** name of literal ERROR of the Enumeration Severity */
	public static final String SEVERITY_ERROR_ENUM = "ERROR"; //$NON-NLS-1$
	
	/** name of literal WARNING of the Enumeration Severity */
	public static final String SEVERITY_WARNING_ENUM = "WARNING"; //$NON-NLS-1$
	
	/** name of literal INFO of the Enumeration Severity */
	public static final String SEVERITY_INFO_ENUM = "INFO"; //$NON-NLS-1$
	
	/** name of literal CANCEL of the Enumeration Severity */
	public static final String SEVERITY_CANCEL_ENUM = "CANCEL"; //$NON-NLS-1$
	
	/** name of literal Batch of the Enumeration Mode */
	public static final String MODE_BATCH_ENUM = "Batch"; //$NON-NLS-1$
	/** name of literal Live of the Enumeration Mode */
	
	public static final String MODE_LIVE_ENUM = "Live"; //$NON-NLS-1$
}
