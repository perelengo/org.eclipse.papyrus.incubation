/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.notationmodel.edit;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.gmf.runtime.notation.Node;



/**
 * @author dumoulin
 *
 */
public class NodeItemProvider extends org.eclipse.gmf.runtime.notation.provider.NodeItemProvider {

	protected AdapterFactory domainAdapterFactory;

	/**
	 * Constructor.
	 *
	 * @param adapterFactory
	 */
	public NodeItemProvider(AdapterFactory adapterFactory, AdapterFactory domainAdapterFactory) {
		super(adapterFactory);
		this.domainAdapterFactory = domainAdapterFactory;
	}


	/**
	 * Return the text of the underlying UML element if any.
	 *
	 * @see org.eclipse.gmf.runtime.notation.provider.ShapeItemProvider#getText(java.lang.Object)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public String getText(Object object) {

		// System.err.println("getText()");
		Node shape = (Node) object;

		Object domainObject = shape.getElement();
		if (domainObject != null) {
			IItemLabelProvider nestedProvider = (IItemLabelProvider) domainAdapterFactory.adapt(domainObject, IItemLabelProvider.class);
			if (nestedProvider != null) {
				return nestedProvider.getText(domainObject);
			}
		}
		return super.getText(object);
	}


	/**
	 * Return the image of the underlying UML element if any.
	 *
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getImage(java.lang.String)
	 *
	 * @param key
	 * @return
	 */
	@Override
	public Object getImage(Object object) {
		// System.err.println("getImage()");
		Node shape = (Node) object;

		Object domainObject = shape.getElement();
		if (domainObject != null) {
			IItemLabelProvider nestedProvider = (IItemLabelProvider) domainAdapterFactory.adapt(domainObject, IItemLabelProvider.class);
			if (nestedProvider != null) {
				return nestedProvider.getImage(domainObject);
			}
		}
		return super.getImage(object);
	}
}
