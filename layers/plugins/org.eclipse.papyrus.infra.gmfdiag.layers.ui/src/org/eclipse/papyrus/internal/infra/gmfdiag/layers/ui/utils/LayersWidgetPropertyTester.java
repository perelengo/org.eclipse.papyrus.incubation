/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.internal.infra.gmfdiag.layers.ui.utils;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Layer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperator;

/**
 * @author Quentin Le Menez
 *
 */
public class LayersWidgetPropertyTester extends PropertyTester {

	private static final String CAN_CREATE_LAYER = "canCreateLayer"; //$NON-NLS-1$

	private static final String CAN_DELETE_LAYER = "canDeleteLayer"; //$NON-NLS-1$

	private static final String CAN_ATTACH_PROPERTIES = "canAttachProperties"; //$NON-NLS-1$

	private static final String CAN_ATTACH_CSS = "canAttachCSS"; //$NON-NLS-1$

	private static final String CAN_ATTACH_CSS_HIDE = "canAttachCSSHide"; //$NON-NLS-1$

	private static final String CAN_ATTACH_VIEWS = "canAttachViews"; //$NON-NLS-1$


	/**
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 *
	 * @param receiver
	 * @param property
	 * @param args
	 * @param expectedValue
	 * @return
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		// TODO these cases should be handled better, e.g. directly through the plugin.xml filters
		if (CAN_ATTACH_PROPERTIES.equals(property)) {
			return layerMenu(receiver);
		} else if (CAN_ATTACH_CSS.equals(property)) {
			return layerMenu(receiver);
		} else if (CAN_ATTACH_CSS_HIDE.equals(property)) {
			return layerMenu(receiver);
		} else if (CAN_ATTACH_VIEWS.equals(property)) {
			return layerMenu(receiver);
		} else if (CAN_CREATE_LAYER.equals(property)) {
			return stackMenu(receiver);
		} else if (CAN_DELETE_LAYER.equals(property)) {
			return layerMenu(receiver);
		}

		// the menu is not one of the above and should be added to the list if necessary
		return false;
	}


	private boolean layerMenu(Object receiver) {
		if (receiver instanceof TreeSelection) {
			TreeSelection ts = (TreeSelection) receiver;
			if (ts.getFirstElement() instanceof Layer) {
				return true;
			}
		}
		return false;
	}

	private boolean stackMenu(Object receiver) {
		if (receiver instanceof TreeSelection) {
			TreeSelection ts = (TreeSelection) receiver;
			if (ts.getFirstElement() instanceof TopLayerOperator) {
				return true;
			}
		}
		return false;
	}

}
