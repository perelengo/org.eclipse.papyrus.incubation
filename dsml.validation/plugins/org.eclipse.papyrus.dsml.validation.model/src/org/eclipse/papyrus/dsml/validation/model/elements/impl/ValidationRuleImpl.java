/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - modifications
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - clean-up, bug 464249 (constraints without ValidationRule stereotype)
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.model.elements.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.dsml.validation.IDSMLValidation;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Category;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IValidationRule;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Mode;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Severity;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Implementation of an interface relating to the ValidationRule interface.
 *
 */
public class ValidationRuleImpl implements IValidationRule {

	/**
	 * 
	 */
	private static final String CONSTRAINT_POSTFIX = "Constraint";

	/**
	 * 
	 */
	private static final String DPT = ".";

	/**
	 * 
	 */
	private static final String CONSTRAINT_PKG = "constraints";

	/**
	 * Attributes of stereotype ValidationRule
	 */
	private static final String SA_TARGET = "target"; //$NON-NLS-1$

	private static final String SA_ID = "id"; //$NON-NLS-1$

	private static final String SA_STATUS_CODE = "statusCode"; //$NON-NLS-1$

	private static final String SA_SEVERITY = "severity"; //$NON-NLS-1$

	private static final String SA_MODE = "mode"; //$NON-NLS-1$

	private static final String SA_IS_ENABLED_BY_DEFAULT = "isEnabledByDefault"; //$NON-NLS-1$

	private static final String SA_DESCRIPTION = "description"; //$NON-NLS-1$

	private static final String SA_MESSAGE = "message"; //$NON-NLS-1$

	private String id;

	private Constraint constraint;

	private Stereotype stereotype;

	private List<String> targets;

	private String implementingClass;

	/**
	 * Constructor which takes as an parameter constraint from the model.
	 *
	 * @param constraint
	 *            constraint from the model
	 * @throws WrongStereotypeException
	 *             exception in case when constraint passed to the constructor
	 *             is not stereotyped with IValidationRule stereotype
	 */
	public ValidationRuleImpl(Constraint constraint) throws WrongStereotypeException {
		this.constraint = constraint;
		stereotype = constraint.getAppliedStereotype(IDSMLValidation.VALIDATIONRULE_STEREOTYPE);
		if (stereotype == null) {
			// throw new WrongStereotypeException(ERROR);
		}
	}

	/**
	 * Constructor which takes as an parameter constraint from the model and
	 * category to which this constraint will belong.
	 *
	 * @param constraint
	 *            constraint from the model
	 * @param parentCategory
	 *            parent category
	 * @throws WrongStereotypeException
	 *             exception in case when constraint passed to the constructor
	 *             is not stereotyped with IValidationRule stereotype
	 */
	@SuppressWarnings("rawtypes")
	public ValidationRuleImpl(Constraint constraint, Category parentCategory) throws WrongStereotypeException {

		this(constraint);

		/*
		 * If the value of id has not been declared by the user, generated id
		 * value will be assigned and saved in the model.
		 */
		if ((getStereoAttribValue(SA_ID) instanceof String) && ((String) getStereoAttribValue(SA_ID)).length() > 0) {
			id = (String) getStereoAttribValue(SA_ID);
		}
		else {
			String qname = constraint.getQualifiedName().replace("::", DPT);
			id = qname;
		}

		implementingClass = CONSTRAINT_PKG + DPT + this.getName() + CONSTRAINT_POSTFIX;

		// unused
		// this.contextID = parentCategory.getID();

		targets = new ArrayList<String>();

		/*
		 * If there is no target specified, plugin will automatically assign as
		 * a target for a constraint, those elements which are extended by the
		 * stereotype to which the constraint applies.
		 */
		Object targetsObj = getStereoAttribValue(SA_TARGET);
		if ((targetsObj instanceof EDataTypeUniqueEList) && ((EDataTypeUniqueEList) targetsObj).size() > 0) {
			for (Object target : (EDataTypeUniqueEList) targetsObj) {
				if (target instanceof String) {
					targets.add((String) target);
				}
			}
		}
	}

	public String getName() {
		return constraint.getName();
	}

	public String getID() {
		return id == null ? (String) getStereoAttribValue(SA_ID) : id;
	}

	public Integer getStatusCode() {
		Integer statusCode = (Integer) getStereoAttribValue(SA_STATUS_CODE);
		return statusCode == null ? new Integer(1) : statusCode;
	}

	public Severity getSeverity() {
		Object severityObj = getStereoAttribValue(SA_SEVERITY);
		if (severityObj instanceof Enumerator) {
			Enumerator severity = (Enumerator) severityObj;

			String severityType = severity.getName();

			if (severityType.compareTo(Severity.INFO.name()) == 0) {
				return Severity.INFO;
			} else if (severityType.compareTo(Severity.WARNING.name()) == 0) {
				return Severity.WARNING;
			} else if (severityType.compareTo(Severity.CANCEL.name()) == 0) {
				return Severity.CANCEL;
			}
		}
		return Severity.ERROR;
	}

	public String getImplementingClass() {
		return implementingClass;
	}

	public Mode getMode() {
		Object modeObj = (stereotype != null) ? constraint.getValue(stereotype, SA_MODE) : null;
		if (modeObj instanceof Enumerator) {
			Enumerator mode = (Enumerator) modeObj;

			String modeType = mode.getName();

			if (modeType.compareTo(Mode.Batch.name()) == 0) {
				return Mode.Batch;
			} else if (modeType.compareTo(Mode.Live.name()) == 0) {
				return Mode.Live;
			}
		}
		return Mode.Batch;
	}

	public boolean isEnabledByDefault() {
		Object enabledByDefault = getStereoAttribValue(SA_IS_ENABLED_BY_DEFAULT);
		return enabledByDefault instanceof Boolean ? ((Boolean) enabledByDefault).booleanValue() : true;
	}

	public String getMessage() {
		return (String) getStereoAttribValue(SA_MESSAGE);
	}

	public String getDescription() {
		return (String) getStereoAttribValue(SA_DESCRIPTION);
	}

	public List<String> getTargets() {
		return targets;
	}

	public Constraint getConstraint() {
		return this.constraint;
	}
	
	/**
	 * Helper function that returns the value of the ValidationRule stereotype,
	 * if applied to the underlying constraint
	 * @param attributeName the name of the stereotype attribute
	 * @return null or value of stereotype attribute
	 */
	public Object getStereoAttribValue(String attributeName) {
		if (stereotype != null) {
			return constraint.getValue(stereotype, attributeName);
		}
		return null;
	}
}
