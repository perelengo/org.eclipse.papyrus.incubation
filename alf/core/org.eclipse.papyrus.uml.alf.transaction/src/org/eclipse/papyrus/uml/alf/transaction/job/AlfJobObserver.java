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
 * 	Jeremie Tatibouet (CEA LIST)
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.transaction.job;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.papyrus.uml.xtext.integration.job.XtextValidationJob;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;

public class AlfJobObserver extends JobChangeAdapter {

	private Button commitButtton;

	public AlfJobObserver(Button commitButton) {
		this.commitButtton = commitButton;
	}

	public void done(IJobChangeEvent event) {
		if (event.getJob() instanceof XtextValidationJob) {
			XtextValidationJob job = (XtextValidationJob) event.getJob();
			this.setCommitButtonState(job.hasValidationIssues());
		}
	}

	protected void setCommitButtonState(boolean validationIssues) {
		Display ui = Display.getDefault();
		if (ui != null) {
			if (!validationIssues) {
				ui.syncExec(new Runnable() {
					public void run() {
						if (!AlfJobObserver.this.commitButtton.isDisposed() &&
								!AlfJobObserver.this.commitButtton.isEnabled()) {
							AlfJobObserver.this.commitButtton.setEnabled(true);
						}
					}
				});
			}
			else {
				ui.syncExec(new Runnable() {
					public void run() {
						if (!AlfJobObserver.this.commitButtton.isDisposed() &&
								AlfJobObserver.this.commitButtton.isEnabled()) {
							AlfJobObserver.this.commitButtton.setEnabled(false);
						}
					}
				});
			}
		}
	}

}
