package org.eclipse.papyrus.uml.alf.text;

import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.uml.alf.AlfRuntimeModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * The activator class controls the plug-in life cycle
 */
public class ActivatorText extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.uml.alf.text"; //$NON-NLS-1$

	// The shared instance
	private static ActivatorText plugin;

	private Injector injector;

	public static LogHelper logger;

	/**
	 * The constructor
	 */
	public ActivatorText() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		this.injector = Guice.createInjector(new AlfRuntimeModule());
		logger = new LogHelper(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		logger = null;
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ActivatorText getDefault() {
		return plugin;
	}

	public Injector getInjector() {
		return this.injector;
	}
}
