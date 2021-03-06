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

import static org.eclipse.papyrus.compare.uml2.internal.postprocessor.ResourceRefactoringChange.isResourceRefactoringChange;

import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.compare.provider.spec.CompareItemProviderAdapterFactorySpec;
import org.eclipse.emf.compare.util.CompareSwitch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.DecoratorAdapterFactory;
import org.eclipse.emf.edit.provider.IItemProviderDecorator;

/**
 * Decorator adapter factory for comparison elements (diffs and such) in Papyrus UML comparisons.
 */
public class PapyrusCompareItemProviderAdapterFactoryDecorator extends DecoratorAdapterFactory {

	private final DecoratorSwitch decoratorSwitch = createDecoratorSwitch();

	/**
	 * Initializes me.
	 */
	public PapyrusCompareItemProviderAdapterFactoryDecorator() {
		super(new CompareItemProviderAdapterFactorySpec());
	}

	@Override
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		super.setParentAdapterFactory(parentAdapterFactory);

		if (parentAdapterFactory != null) {
			// Compose our delegate after us so that its item delegators may
			// find the entire factory space
			parentAdapterFactory.addAdapterFactory(getDecoratedAdapterFactory());
		}
	}

	protected DecoratorSwitch createDecoratorSwitch() {
		return new DecoratorSwitch();
	}

	@Override
	protected final IItemProviderDecorator createItemProviderDecorator(Object target, Object type) {
		return decoratorSwitch.doSwitch(target);
	}

	protected IItemProviderDecorator createDefaultItemProviderDecorator() {
		return new ForwardingItemProviderDecorator(this);
	}

	protected IItemProviderDecorator createResourceRefactoringChangeItemProviderDecorator() {
		return new ResourceRefactoringChangeItemProviderDecorator(this);
	}

	//
	// Nested types
	//

	protected class DecoratorSwitch extends CompareSwitch<IItemProviderDecorator> {
		public IItemProviderDecorator doSwitch(Object object) {
			if (object instanceof EObject) {
				return doSwitch((EObject)object);
			} else {
				return createDefaultItemProviderDecorator();
			}
		}

		@Override
		public IItemProviderDecorator defaultCase(EObject object) {
			return createDefaultItemProviderDecorator();
		}

		@SuppressWarnings("restriction")
		@Override
		public IItemProviderDecorator caseResourceAttachmentChange(ResourceAttachmentChange object) {
			if (isResourceRefactoringChange(object)) {
				return createResourceRefactoringChangeItemProviderDecorator();
			}
			return null;
		}
	}
}
