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
import org.eclipse.papyrus.uml.alf.transaction.job.AlfCompilationJob;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.NamedElement;


/**
 * This class describes the process of propagating the state of a particular
 * model element in a given UML model
 */
public class CommitScenario extends ChangeScenario {

	/**
	 * Flag use to know if the commit is required. it may change in the before method
	 */
	private boolean isCommitRequired;
	
	/**
	 * Text editor that can be updated when the commit scenario is done
	 */
	private StyledText view;

	public CommitScenario() {
		super();
		this.isCommitRequired = true;
	}

	public void bindView(StyledText view){
		this.view = view;
	}
	
	/**
	 * Update the user model state edition status
	 */
	public void before() {
		/* 1. Check parent constraints */
		super.before();
		/* 2. Update user model state meta-data */
		BackupState editionState = new BackupState();
		editionState.status = EditionStatus.MERGED;
		editionState.timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
		this.userModelState.setEditionState(editionState);
		this.modelStateToBeCommitted = this.userModelState;
	}

	/**
	 * Propagate the model state specified in text within the model
	 * 
	 * @param - the model element to update with the specified changes
	 */
	public void execute(NamedElement target, final String lastEditedVersion) {
		/* 1. Load the states of the target */
		this.init(target);
		if (!this.userModelState.getContent().equals(lastEditedVersion)) {
			this.userModelState.setText(lastEditedVersion);
		}
		/* 2. Realize before actions */
		this.before();
		if (this.isCommitRequired) {
			/* 3.1. Schedule a job in charge of propagated the changes in the model */
			Job job = new AlfCompilationJob(this.modelStateToBeCommitted);
			job.setPriority(Job.SHORT);
			job.addJobChangeListener(new JobChangeAdapter() {
				@Override
				public void done(IJobChangeEvent event) {
					CommitScenario.this.after();
				}
			});
			job.schedule();
		} else {
			this.isCommitRequired = true;
		}
	}

	/**
	 * This method is automatically called after the job scheduled by this scenario terminates.
	 */
	public void after() {
		if(this.view!=null && !this.view.isDisposed()){
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					CommitScenario.this.view.setText(CommitScenario.this.modelStateToBeCommitted.getContent());
				}
			});
		}
	}

}
