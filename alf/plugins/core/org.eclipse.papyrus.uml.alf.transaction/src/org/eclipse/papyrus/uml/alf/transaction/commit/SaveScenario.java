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

//import static org.eclipse.papyrus.uml.alf.transaction.ActivatorTransaction.logger;

import java.sql.Timestamp;
import java.util.Calendar;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.papyrus.uml.alf.libraries.helper.BackupState;
import org.eclipse.papyrus.uml.alf.libraries.helper.BackupState.EditionStatus;
import org.eclipse.papyrus.uml.alf.transaction.job.SaveTextualRepresentationJob;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This class describes the process of persisting the state description
 * attached to a particular model element.
 */
public class SaveScenario extends ChangeScenario {

	/**
	 * Flag use to know if the backup is required. It may change in the before method
	 */
	private boolean isBackupRequired;

	public SaveScenario() {
		super();
		this.isBackupRequired = true;
	}

	/**
	 * If the <code>userModelState<code> and the <code>currentModelState<code> are not different
	 * then consider the textual specification was MERGED. Otherwise, the user model stand point
	 * is considered as SAVED. Typically it diverges from state of the current model.
	 */
	public void before() {
		super.before();
		if (!this.userModelState.isDifferent(this.currentModelState)) {
			this.userModelState.rebase(this.currentModelState);
		} else {
			BackupState editionState = new BackupState();
			editionState.status = EditionStatus.SAVED;
			editionState.timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
			this.userModelState.setEditionState(editionState);
		}
		this.modelStateToBeCommitted = this.userModelState;
	}

	/**
	 * Persist in the model the state of the target as a comment
	 * 
	 * @param target
	 *            - the model element state to persist
	 */
	public void execute(NamedElement target, final String lastEditedVersion) {
		/* 1. Load the states of the target */
		this.init(target);
		if (!this.userModelState.getContent().equals(lastEditedVersion)) {
			this.userModelState.setText(lastEditedVersion);
		}
		/* 2. Realize before actions */
		this.before();
		/* 3. Is a backup required */
		if (this.isBackupRequired) {
			/* 3.1. Schedule a job in charge of saving target state */
			Job job = new SaveTextualRepresentationJob(this.modelStateToBeCommitted);
			job.setPriority(Job.SHORT);
			job.addJobChangeListener(new JobChangeAdapter() {
				@Override
				public void done(IJobChangeEvent event) {
					SaveScenario.this.after();
				}
			});
			job.schedule();
		} else {
			this.isBackupRequired = true;
		}
	}

	/**
	 * This method is automatically called after the job scheduled by this scenario terminates.
	 */
	public void after() {
		//logger.info("Save Job Done");
	}
}
