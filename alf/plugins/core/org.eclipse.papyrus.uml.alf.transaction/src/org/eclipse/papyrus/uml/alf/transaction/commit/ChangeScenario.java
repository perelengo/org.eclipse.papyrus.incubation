/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Tatibouet
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.transaction.commit;

import org.eclipse.papyrus.uml.alf.libraries.helper.AlfUtil;
import org.eclipse.papyrus.uml.alf.libraries.helper.BackupUtil;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;

public abstract class ChangeScenario extends Scenario implements IChangeScenario {

	/**
	 * The model state that is taken as reference to perform a change
	 */
	protected AlfTextualRepresentation modelStateToBeCommitted;

	public ChangeScenario() {
		super();
		this.modelStateToBeCommitted = null;
	}

	public void before() {
		/* 1. Apply action language profile if it is not already applied */
		if (!AlfUtil.getInstance().isActionLanguageProfileApplied(this.currentModelState.getOwner())) {
			AlfUtil.getInstance().applyActionLanguageProfile(this.currentModelState.getOwner());
		}
		/* 2. Apply standard profile if it is not already applied */
		if (!AlfUtil.getInstance().isStandardProfileApplied(this.currentModelState.getOwner())) {
			AlfUtil.getInstance().applyStandardProfile(this.currentModelState.getOwner());
		}
		/* 3. Apply backup profile if it is not already applied */
		if (!BackupUtil.getInstance().isBackupProfileApplied(this.currentModelState.getOwner())) {
			BackupUtil.getInstance().applyBackupProfile(this.currentModelState.getOwner());
		}
	}
}
