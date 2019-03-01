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

import org.eclipse.compare.internal.CompareEditor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.gitlight.compare.ui.internal.properties.CompareEditorPropertySheetAdapterFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
@SuppressWarnings("restriction")
public class PapyrusCompareUIPlugin extends AbstractUIPlugin {

	/** ID of this plug-in. */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.gitlight.compare.ui"; //$NON-NLS-1$

	/** The shared instance. */
	private static PapyrusCompareUIPlugin plugin;

	/** The Papyrus Label Provder. */
	private LabelProviderService labelProviderService;

	/**
	 * The constructor.
	 */
	public PapyrusCompareUIPlugin() {
		// Do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		// This allows to manage the property sheet page for the CompareEditor
		Platform.getAdapterManager().registerAdapters(new CompareEditorPropertySheetAdapterFactory(), CompareEditor.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		if (labelProviderService != null) {
			try {
				labelProviderService.disposeService();
			} catch (ServiceException ex) {
				plugin.getLog().log(new Status(IStatus.WARNING, PLUGIN_ID,
						"Unable to dispose Papyrus Label Provider Service", ex)); //$NON-NLS-1$
			}
		}
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static PapyrusCompareUIPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the Papyrus Label Provider service. If the service does not exist yet it will be created.
	 * 
	 * @return the Papyrus Label Provider service. Can be {@code null} if the service can not be started.
	 */
	public LabelProviderService getLabelProviderService() {
		if (labelProviderService == null) {
			labelProviderService = new LabelProviderServiceImpl();
			try {
				labelProviderService.startService();
			} catch (ServiceException ex) {
				// prevent service from being used if it could not be started
				labelProviderService = null;
				getDefault().getLog().log(new Status(IStatus.WARNING, PLUGIN_ID,
						"Unable to start Papyrus Label Provider Service", ex)); //$NON-NLS-1$
			}
		}
		return labelProviderService;
	}

}
