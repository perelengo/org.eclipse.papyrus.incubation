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

public class ScenarioFactory {

	private static ScenarioFactory INSTANCE;

	private ScenarioFactory() {
	}

	public static ScenarioFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ScenarioFactory();
		}
		return INSTANCE;
	}

	public IChangeScenario createSaveScenario() {
		return new SaveScenario();
	}

	public IChangeScenario createCommitScenario() {
		return new CommitScenario();
	}

	public ISyncScenario createSyncScenario() {
		return new SyncScenario();
	}
}
