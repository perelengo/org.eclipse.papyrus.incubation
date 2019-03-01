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
package org.eclipse.papyrus.gitlight.compare.uml2.edit.internal.decorator;

import org.eclipse.emf.compare.provider.ExtendedItemProviderDecorator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.gitlight.compare.uml2.edit.Activator;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;

/**
 * Decorator that reuses the label provider of Papyrus.
 * 
 * @see org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService
 */
public class PapyrusItemProviderDecorator extends ExtendedItemProviderDecorator implements IEditingDomainItemProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IItemColorProvider, IItemFontProvider {

	/**
	 * Default constructor.
	 * 
	 * @param adapterFactory
	 *            the adapter factory to be used by the label providers.
	 */
	public PapyrusItemProviderDecorator(ComposeableAdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		LabelProviderService labelProviderService = Activator.getDefault().getLabelProviderService();
		if (labelProviderService != null) {
			ILabelProvider labelProvider = labelProviderService.getLabelProvider(object);
			if (labelProvider != null) {
				return labelProvider.getText(object);
			}
		}
		return super.getText(object);
	}

	@Override
	public Object getImage(Object object) {
		LabelProviderService labelProviderService = Activator.getDefault().getLabelProviderService();
		if (labelProviderService != null) {
			ILabelProvider labelProvider = labelProviderService.getLabelProvider(object);
			if (labelProvider != null) {
				return labelProvider.getImage(object);
			}
		}
		return super.getImage(object);
	}
}
