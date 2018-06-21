/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
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

package org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSStyles;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.AddCSSStyleSheetCommand;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.AddCssClassStyleCommand;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.RemoveCSSStyleSheetCommand;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.RemoveCssClassStyleCommand;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance;
import org.eclipse.papyrus.internal.infra.gmfdiag.layers.runtime.Activator;

/**
 * @author Quentin Le Menez
 *
 */
public class HideLayerElementsCommand extends RecordingCommand {

	private AbstractLayer layer;

	private TransactionalEditingDomain ted;

	private StyleSheet cssToHide;

	private StyleSheet css;

	private CSSDiagram cssDiagram;

	private boolean isAppliedCSS;

	/**
	 * Constructor.
	 *
	 * @param domain
	 * @param label
	 */
	public HideLayerElementsCommand(TransactionalEditingDomain ted, AbstractLayer layer, String label) {
		super(ted, label);
		this.layer = layer;
		this.ted = ted;

		try {
			Diagram diagram = layer.getLayersStack().getDiagram();
			if (diagram instanceof CSSDiagram) {
				this.cssDiagram = ((CSSDiagram) diagram);
			}

			List<String> layerPropertiesName = new ArrayList<String>();
			for (Property layerProperty : layer.getAttachedProperties()) {
				layerPropertiesName.add(layerProperty.getName());
			}

			TypeInstance cssHideInstance = layerPropertiesName.contains("cssHide") ? layer.getPropertyInstance("cssHide") : null;
			TypeInstance cssInstance = layerPropertiesName.contains("css") ? layer.getPropertyInstance("css") : null;

			if (null == cssHideInstance && null != cssInstance) {
				this.cssToHide = ((CSSInstance) cssInstance).getStylesheet();
			} else if (null != cssHideInstance) {
				this.cssToHide = ((CSSHideInstance) cssHideInstance).getStylesheet();
			}

		} catch (LayersException e) {
			Activator.log.error("There should be a CSS dedicated to hide the layer views", e);
		}

		if (cssToHide == null) {
			return;
		}
		String sheetPath = ((StyleSheetReference) cssToHide).getPath();
		for (StyleSheet ss : cssDiagram.getStyleSheets()) {
			String ssPath = ((StyleSheetReference) ss).getPath();
			if (sheetPath.equals(ssPath)) {
				isAppliedCSS = true;
				// There may be discrepancies in the memory addresses between the layer's CSS and the model's
				// Always revert to the model's CSS as it is the one being used
				cssToHide = ss;
				break;
			}
		}

	}


	/**
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 *
	 */
	@Override
	protected void doExecute() {
		// This used to call upon a style but the possibility of a style being present in multiple applied CSS broke the functionality
		// The style strategy can be reintroduced if there is a way to only call upon one applied CSS instead of All of them

		if (layer.isLayerEnabled() && !isAppliedCSS && null != cssToHide) {
			AddCSSStyleSheetCommand acssc = new AddCSSStyleSheetCommand(ted, cssDiagram,
					CSSStyles.CSS_DIAGRAM_STYLESHEETS_KEY,
					NotationPackage.eINSTANCE.getEObjectListValueStyle(),
					NotationPackage.eINSTANCE.getEObjectListValueStyle_EObjectListValue(),
					cssToHide);
			acssc.execute();
		}
		if (!layer.isLayerEnabled() && isAppliedCSS && null != cssToHide) {
			RemoveCSSStyleSheetCommand rcssc = new RemoveCSSStyleSheetCommand(ted, cssDiagram,
					CSSStyles.CSS_DIAGRAM_STYLESHEETS_KEY,
					NotationPackage.eINSTANCE.getEObjectListValueStyle(),
					NotationPackage.eINSTANCE.getEObjectListValueStyle_EObjectListValue(),
					cssToHide);
			rcssc.execute();
		}
	}

}
