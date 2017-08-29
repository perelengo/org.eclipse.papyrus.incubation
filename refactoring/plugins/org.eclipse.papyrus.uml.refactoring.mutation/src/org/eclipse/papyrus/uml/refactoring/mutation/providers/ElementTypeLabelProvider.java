/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.refactoring.mutation.providers;

import java.util.Arrays;
import java.util.Map.Entry;

/**
 * Label provider used to display the possible types of the mmutated element
 * 
 */
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * The label provider used to display the input in the viewer
 * 
 */
public class ElementTypeLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object element) {
		if (element instanceof Entry) {
			Entry entry = (Entry) element;
			Object key = entry.getKey();

			if (key instanceof IElementType) {
				IElementType elementType = (IElementType) key;

				return IconService.getInstance().getIcon(elementType);
			}
		}
		return null;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof Entry) {
			Entry entry = (Entry) element;
			Object key = entry.getKey();

			if (key instanceof IElementType) {
				IElementType elementType = (IElementType) key;
				String defaultName = elementType.getDisplayName();
				String name = "";
				if (defaultName.contains("::")) {
					name = Arrays.asList(elementType.getDisplayName().split("::")).get(1);
				} else {
					name = defaultName;
				}

				return name;
			}
		}

		return "ElementNotFound";
	}

}
