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
package org.eclipse.papyrus.uml.alf.transaction.observation.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.uml.alf.preferences.AlfIntegrationPreferencesUtil;
import org.eclipse.papyrus.uml.alf.transaction.commit.ISyncScenario;
import org.eclipse.papyrus.uml.alf.transaction.commit.ScenarioFactory;
import org.eclipse.papyrus.uml.alf.transaction.observation.listener.filter.FUMLFilter;
import org.eclipse.uml2.uml.Element;

public class FUMLElementListener extends ResourceSetListenerImpl {

	public FUMLElementListener(TransactionalEditingDomain editingDomain) {
		this(editingDomain.getResourceSet());
	}

	protected FUMLElementListener(ResourceSet resourceSet) {
		super();
	}

	public NotificationFilter getFilter() {
		return new FUMLFilter();
	}

	/**
	 * If a changes occurs on a model element supported by fUML then
	 * 1. If this change is implied by the ALF framework then we do nothing
	 * 2. If this change is not implied by the ALF framework then we try to automatically
	 * align the textual representation onto the current state of the edited model element.
	 * Note this is not always possible (e.g. the user has ongoing changes in the text)
	 */
	public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
		/* 0. If the user disabled the synchronization then we do not exploit notifications*/
		if(!AlfIntegrationPreferencesUtil.isAlfAutoSyncEnabled()){
			return null;
		}
		/* 1. Initialization */
		CompoundCommand subCommands = new CompoundCommand("Synchronization");
		HashMap<Element, List<Notification>> modifications = new HashMap<Element, List<Notification>>();
		/* 2. Notification handling */
		if (!event.getNotifications().isEmpty()) {
			/* 2.1. Notification registration phase */
			for (Notification notification : event.getNotifications()) {
				Element target = (Element) notification.getNotifier();
				if (modifications.get(target) == null) {
					modifications.put(target, new ArrayList<Notification>());
				}
				modifications.get(target).add(notification);
			}
			/* 2.2. Calculate synchronization actions through a synchronization scenario */
			ISyncScenario scenario = ScenarioFactory.getInstance().createSyncScenario();
			subCommands.append(scenario.synchronize(modifications));
		}
		return subCommands;
	}
	
	
}

