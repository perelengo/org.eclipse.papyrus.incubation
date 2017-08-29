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

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;

public abstract class AlfAbstractJob extends Job {

	protected AlfTextualRepresentation modelElementState;

	protected TransactionalEditingDomain getEditingDomain() {
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForResource.getInstance().getServiceRegistry(this.modelElementState.getOwner().eResource());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		TransactionalEditingDomain domain = null;
		if (registry != null) {
			try {
				domain = ServiceUtils.getInstance().getTransactionalEditingDomain(registry);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		return domain;
	}

	public AlfAbstractJob(String name, AlfTextualRepresentation modelElemtState) {
		super(name);
		this.modelElementState = modelElemtState;
	}
}
