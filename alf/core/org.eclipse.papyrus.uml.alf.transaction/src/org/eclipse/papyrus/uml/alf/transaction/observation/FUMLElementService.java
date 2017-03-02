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
package org.eclipse.papyrus.uml.alf.transaction.observation;

import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.uml.alf.transaction.observation.listener.FUMLElementListener;

public class FUMLElementService implements IService {

	protected TransactionalEditingDomain editingDomain;

	protected ResourceSetListenerImpl listener;

	public FUMLElementService() {
		this.editingDomain = null;
		this.listener = null;
	}

	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.editingDomain = ServiceUtils.getInstance().getTransactionalEditingDomain(servicesRegistry);
		this.listener = new FUMLElementListener(this.editingDomain);
	}

	public TransactionalEditingDomain getEditingDomain() {
		return this.editingDomain;
	}

	public void startService() throws ServiceException {
		this.editingDomain.addResourceSetListener(this.listener);
	}

	public void disposeService() throws ServiceException {
		this.editingDomain.removeResourceSetListener(this.listener);
		this.listener = null;
	}

	public ResourceSetListenerImpl getListener() {
		return this.listener;
	}
}
