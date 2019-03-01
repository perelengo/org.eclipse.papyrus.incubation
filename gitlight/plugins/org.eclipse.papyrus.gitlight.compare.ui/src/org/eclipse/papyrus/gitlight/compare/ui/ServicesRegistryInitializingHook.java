/*****************************************************************************
 * Copyright (c) 2019 CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gitlight.compare.ui;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.ide.hook.IResourceSetHook;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.core.editor.ModelSetServiceFactory;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;

/**
 * An {@link IResourceSetHook} to initialize a Papyrus Services Registry attached to the resource set. This
 * will help Papyrus Diagrams to render properly, by giving them access to (a subset of) Papyrus services.
 */
public class ServicesRegistryInitializingHook extends AbstractPapyrusResourceSetHook {
	@Override
	public void preLoadingHook(ResourceSet resourceSet, Collection<? extends URI> uris) {
		super.preLoadingHook(resourceSet, uris);

		try {
			ExtensionServicesRegistry servicesRegistry = new ExtensionServicesRegistry();
			servicesRegistry.add(ResourceSet.class, Integer.MAX_VALUE, resourceSet);
			try {
				servicesRegistry.startRegistry();
			} catch (ServiceException ex) {
				// Ignore: ServiceExceptions are expected here, because some services registered via the
				// extension point have a dependency on the Papyrus editor. The only consequence is that
				// editor-bound services won't be started. We don't need them anyway (Probably :) )
				// The services registry is still started properly (At least the services without any
				// unresolved dependency)
			}

			ModelSetServiceFactory.setServiceRegistry(resourceSet, servicesRegistry);
		} catch (ServiceException ex) {
			PapyrusCompareUIPlugin.getDefault().getLog()
					.log(new Status(IStatus.WARNING, PapyrusCompareUIPlugin.PLUGIN_ID,
							"Unable to attach the Papyrus Services Registry to the Resource Set", ex)); //$NON-NLS-1$
		}
	}
}
