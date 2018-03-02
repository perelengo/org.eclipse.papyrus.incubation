/*****************************************************************************
 * Copyright (c) 2010, 2018 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Florian Noyrit florian.noyrit@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagramtemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Selection Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getSelectionKind()
 * @model
 * @generated
 */
public enum SelectionKind implements Enumerator {
	/**
	 * The '<em><b>For All</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #FOR_ALL_VALUE
	 * @generated
	 * @ordered
	 */
	FOR_ALL(0, "ForAll", "ForAll"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Specific</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #SPECIFIC_VALUE
	 * @generated
	 * @ordered
	 */
	SPECIFIC(1, "Specific", "Specific"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Query</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #QUERY_VALUE
	 * @generated
	 * @ordered
	 */
	QUERY(2, "Query", "Query"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>For All</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>For All</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #FOR_ALL
	 * @model name="ForAll"
	 * @generated
	 * @ordered
	 */
	public static final int FOR_ALL_VALUE = 0;

	/**
	 * The '<em><b>Specific</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Specific</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #SPECIFIC
	 * @model name="Specific"
	 * @generated
	 * @ordered
	 */
	public static final int SPECIFIC_VALUE = 1;

	/**
	 * The '<em><b>Query</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Query</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #QUERY
	 * @model name="Query"
	 * @generated
	 * @ordered
	 */
	public static final int QUERY_VALUE = 2;

	/**
	 * An array of all the '<em><b>Selection Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static final SelectionKind[] VALUES_ARRAY = new SelectionKind[] {
			FOR_ALL,
			SPECIFIC,
			QUERY,
	};

	/**
	 * A public read-only list of all the '<em><b>Selection Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final List<SelectionKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Selection Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param literal
	 *            the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SelectionKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SelectionKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Selection Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param name
	 *            the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SelectionKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SelectionKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Selection Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SelectionKind get(int value) {
		switch (value) {
		case FOR_ALL_VALUE:
			return FOR_ALL;
		case SPECIFIC_VALUE:
			return SPECIFIC;
		case QUERY_VALUE:
			return QUERY;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private SelectionKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // SelectionKind
