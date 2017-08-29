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
package org.eclipse.papyrus.refactoring.refactoringOnElement;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.refactoring.core.IPreviewablePapyrusChange;
import org.eclipse.papyrus.refactoring.core.PapyrusChange;
import org.eclipse.papyrus.refactoring.util.PapyrusRefactoringUtils;

/**
 * A {@link Change} for managing the transformation of a specified element.
 */
public class PapyrusRefactoringOnElementChange extends PapyrusChange {

	/** The element to transform */
	private EObject fElementToApplyChange;


	/**
	 * Constructor.
	 *
	 * @param papyrusRefactoringTransformation
	 *            The transformation to execute
	 * @param name
	 *            The name of the transformation
	 * @param modelSet
	 *            The modelSet containing the element to transform
	 * @param elementToTransform
	 *            The element to transform
	 */
	public PapyrusRefactoringOnElementChange(AbstractTransformationOnElement papyrusRefactoringTransformation, String name, ModelSet modelSet, EObject elementToTransform) {
		super(papyrusRefactoringTransformation, name, modelSet);
		fModelSet = modelSet;
		fElementToApplyChange = elementToTransform;
	}

	/**
	 * Override the perform of the original LTK Refactoring to substitute the PapyrusChange one
	 * 
	 * @see org.eclipse.papyrus.refactoring.core.PapyrusChange#performRefactor(org.eclipse.papyrus.infra.core.resource.ModelSet, java.lang.String)
	 *
	 * @param modelSet
	 *            The modelSet containing the element to transform
	 * @param label
	 *            The label of the transformation
	 * @return
	 * 		The change computed for the transformation
	 */
	@Override
	protected Change performRefactor(ModelSet modelSet, String label) {
		EObject elementToApplyRefactoring = PapyrusRefactoringUtils.findEObjectInModelSet(fElementToApplyChange, modelSet);
		((AbstractTransformationOnElement) fPapyrusRefactoringTransformation).setElementToTransform(elementToApplyRefactoring);

		return super.performRefactor(modelSet, label);
	}

	/**
	 * @see org.eclipse.papyrus.refactoring.core.PapyrusChange#getPreviewFile()
	 *
	 * @return
	 * 		The modified model's IFile
	 */
	@Override
	public IFile getPreviewFile() {
		return ((IPreviewablePapyrusChange) getParent()).getPreviewFile();
	}

	/**
	 * @see org.eclipse.papyrus.refactoring.core.PapyrusChange#getModifiedElement()
	 *
	 * @return
	 * 		The element to modify
	 */
	@Override
	public Object getModifiedElement() {
		return fElementToApplyChange;
	}

}
