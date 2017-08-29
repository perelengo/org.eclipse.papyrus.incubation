/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.papyrus.refactoring.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.refactoring.messages.messages"; //$NON-NLS-1$

	public static String PAPYRUSCHANGE_CHECKVALIDITY;
	public static String PAPYRUSCHANGE_MODELOPEN_ERROR;
	public static String PAPYRUSCHANGE_PREVIEWPROJECT_NAME;
	public static String PAPYRUSCHANGE_PREVIEWMODEL_NAME;
	public static String PAPYRUSCHANGE_PREVIEWCREATION_ERROR;
	public static String PAPYRUSCHANGE_PREVIEW_PERFORM;
	public static String PAPYRUSCHANGE_SET_PERFORM;

	public static String PAPYRUSREFACTORING_CHECKPRECONDITIONS;
	public static String PAPYRUSREFACTORING_RESOURCEOPEN_ERROR;
	public static String PAPYRUSREFACTORING_MODELVALIDITY;
	public static String PAPYRUSREFACTORING_MODELVALIDITY_ERROR;
	public static String PAPYRUSREFACTORING_EXECUTE;

	public static String UNDOPAPYRUSCHANGE_ERROR;
	public static String UNDOPAPYRUSCHANGE_EXECUTE;
	public static String UNDOPAPYRUSCHANGE_VALIDITYCHECK;

	public static String REFACTORINGPAGE_SCOPE_LABEL;
	public static String REFACTORINGPAGE_SCOPE_MODEL;
	public static String REFACTORINGPAGE_SCOPE_SELECTION;

	public static String PAPYRUSCOMPOSITECHANGE_CHANGELABEL_BEGIN;
	public static String PAPYRUSCOMPOSITECHANGE_CHANGELABEL_END;
	public static String PAPYRUSCOMPOSITECHANGE_PREVIEWPROJECT_NAME;
	public static String PAPYRUSCOMPOSITECHANGE_PREVIEWMODEL_NAME;
	public static String PAPYRUSCOMPOSITECHANGE_PREVIEWMODEL_CREATIONERROR;

	public static String PAPYRUSREFACTORPREVIEW_CHANGEDMODEL;
	public static String PAPYRUSREFACTORPREVIEW_ORIGINALMODEL;
	public static String PAPYRUSREFACTORPREVIEW_CHANGEDETAILS;

	public static String PAPYRUSREFACTORING_REPLACE_LABEL;
	public static String REFACTORINGPAGE_REPLACE_HINT;
	public static String REFACTORINGPAGE_REPLACE_EQUALERROR;
	public static String REFACTORINGPAGE_REPLACE_ORIGINALSTRINGLABEL;
	public static String REFACTORINGPAGE_REPLACE_TOREPLACESTRINGLABEL;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
