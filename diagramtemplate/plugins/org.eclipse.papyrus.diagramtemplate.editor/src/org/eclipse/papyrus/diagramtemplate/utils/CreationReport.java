/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.diagramtemplate.utils;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Quentin Le Menez
 *
 */
public class CreationReport {

	private static CreationReport INSTANCE;

	private static HashMap<EObject, CreationReportKind> report;

	/**
	 * Enum used to report on diagram creation
	 */
	public enum CreationReportKind {
		SUCCESS, FAIL
	}

	private CreationReport() {
		// singleton
	}

	public static CreationReport getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CreationReport();
			report = new HashMap<>();
		}
		return INSTANCE;
	}

	public void addToReport(EObject elementToShow, CreationReportKind status) {
		report.put(elementToShow, status);
	}

	public HashMap<EObject, CreationReportKind> getReport() {
		return report;
	}

	public void clear() {
		INSTANCE = null;
		report.clear();
	}

}
