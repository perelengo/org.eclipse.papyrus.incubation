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

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
//import org.eclipse.emf.compare.Comparison;
//import org.eclipse.emf.compare.EMFCompare;
//import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.emf.utils.ResourceUtils;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.refactoring.core.IPreviewablePapyrusChange;
import org.eclipse.papyrus.refactoring.messages.Messages;
import org.eclipse.swt.widgets.Display;

/**
 * {@link CompositeChange} for managing {@link AbstractTransformationOnElement}.
 * It is composed of {@link PapyrusRefactoringOnElementChange}.
 * 
 */
public class PapyrusCompositeChange extends CompositeChange implements IPreviewablePapyrusChange {

	/** The ModelSet on which we apply the change */
	private ModelSet fModelSet;

	/** The Papyrus Refactoring to execute */
	private AbstractTransformationOnElement fPapyrusRefactoringTransformation;

	/** The virtual {@link ModelSet} on which we executed the refactoring. */
	private ModelSet fPreviewModelSet;

	/** The Change to execute */
	private Change perfomChange;


	/**
	 * Constructor.
	 *
	 * @param papyrusRefactoringPage
	 *            The page contributed to the Refactoring wizard
	 * @param modelSet
	 *            The modelSet to which w eapply the Change
	 */
	public PapyrusCompositeChange(AbstractTransformationOnElement papyrusRefactoringPage, ModelSet modelSet) {
		super(papyrusRefactoringPage.getName());
		fPapyrusRefactoringTransformation = papyrusRefactoringPage;
		fModelSet = modelSet;

		// Display.getDefault().syncExec(new Runnable() {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				initChanges();
			}
		});

		// fPreviewModelSet = initPreviewModelSet();
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		Display.getDefault().syncExec(new Runnable() {
			// Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				try {
					perfomChange = PapyrusCompositeChange.super.perform(pm);
				} catch (Exception e) {
					Activator.log.error(e);
				}
			}
		});

		return perfomChange;
	}

	/**
	 * Create the {@link PapyrusRefactoringOnElementChange} that correspond to this refactoring.
	 */
	private void initChanges() {
		createAllChanges();

		// The following part slows the programm considerably without adding a lot of value as the empty changes are nearly non existant
		// Executing the comparator for each change takes about .5s per change
		// A possible solution could be to execute them in multiple threads but there need to be sufficient cores on the user's end

		// ModelSet initialModelSet = fModelSet;
		// EMFCompare comparator = EMFCompare.builder().build();
		//
		// for (Change change : getChildren()) {
		// if (change instanceof PapyrusRefactoringOnElementChange) {
		// PapyrusRefactoringOnElementChange changeToProceed = (PapyrusRefactoringOnElementChange) change;
		// ModelSet changeModelSet = changeToProceed.getChangePreviewModelSet();
		//
		// Comparison comparison = comparator.compare(new DefaultComparisonScope(initialModelSet, changeModelSet, null));
		//
		// // If there is any difference between the original model and the refactored model, this change doesn't modify the model so it is useless, we can delete it.
		// if (comparison.getDifferences().size() == 0) {
		// System.err.println("initChanges " + changeToProceed.getModifiedElement());
		// remove(changeToProceed);
		// }
		// }
		// }
	}

	/**
	 * Create one {@link PapyrusRefactoringOnElementChange} for each element from {@link AbstractTransformationOnElement#getElementsListToTransform()}.
	 */
	private void createAllChanges() {

		for (EObject element : fPapyrusRefactoringTransformation.getElementsListToTransform()) {
			LabelProviderService labelProvider = new LabelProviderServiceImpl();
			String elementText = Messages.PAPYRUSCOMPOSITECHANGE_CHANGELABEL_BEGIN + element.eClass().getName() + Messages.PAPYRUSCOMPOSITECHANGE_CHANGELABEL_END
					+ labelProvider.getLabelProvider().getText(element);

			// Create the PapyrusRefactoringOnElementChange
			PapyrusRefactoringOnElementChange change = new PapyrusRefactoringOnElementChange(fPapyrusRefactoringTransformation, elementText, fModelSet, element);

			// Add it to this CompositeChange
			this.add(change);
		}

	}

	// TODO a proper clone, so as to get the preview working !
	/**
	 * Clones the current modelSet to apply it the Changes
	 * 
	 * @return
	 * 		The preview modelSet
	 */
	public ModelSet getChangePreviewModelSet() {
		ModelSet previewModelSet = new ModelSet();
		ModelsReader reader = new ModelsReader();
		reader.readModel(previewModelSet);
		try {
			previewModelSet.loadModels(fModelSet.getURIWithoutExtension());

		} catch (ModelMultiException e) {
			Activator.log.error(e);
		}

		return previewModelSet;
		// getPreviewFile();
		// return fPreviewModelSet;
	}

	/**
	 * Creates a copy of the original ModelSet and execute the refactoring on it.
	 * 
	 * @return A preview file of the refactoring which shows the refactoring effects.
	 */
	@Override
	public IFile getPreviewFile() {
		String nameProject = Messages.PAPYRUSCOMPOSITECHANGE_PREVIEWPROJECT_NAME;
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(nameProject);
		// System.err.println("getPreviewFile");

		try {
			if (!project.exists()) {
				project.create(null);
			}
			project.open(null);
		} catch (CoreException e1) {
			Activator.log.error(e1);
		}

		IPath path = new Path(project.getFullPath().toString() + Messages.PAPYRUSCOMPOSITECHANGE_PREVIEWMODEL_NAME);
		IFile previewFile = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		fModelSet.saveCopy(path.removeFileExtension());
		ModelSet previewModelSet = new ModelSet();
		ModelsReader reader = new ModelsReader();
		reader.readModel(previewModelSet);
		// System.err.println("initPreviewModelSet");

		try {
			previewModelSet.loadModels(URI.createPlatformResourceURI(path.toString(), true));
		} catch (ModelMultiException e) {
			Activator.log.error(e);
		}

		for (Change changeChild : getChildren()) {
			if (changeChild.isEnabled()) {
				((PapyrusRefactoringOnElementChange) changeChild).performRefactor(previewModelSet, Messages.PAPYRUSCHANGE_PREVIEW_PERFORM);
			}
		}

		try {
			// modelSetForPreviewFile.saveAs(URI.createPlatformResourceURI(path.toString(), true));
			previewModelSet.saveAs(URI.createPlatformResourceURI(path.toString(), true));
		} catch (IOException e) {
			Activator.log.error(e);
		}
		// Assert.isNotNull(moelSetForPreviewFile, Messages.PAPYRUSCOMPOSITECHANGE_PREVIEWMODEL_CREATIONERROR);
		Assert.isNotNull(previewModelSet, Messages.PAPYRUSCOMPOSITECHANGE_PREVIEWMODEL_CREATIONERROR);
		fPreviewModelSet = previewModelSet;

		return previewFile;
	}


	@Override
	public IFile getInitialFile() {
		// Resource diResource = DiModelUtils.getDiResource(fModelSet);
		Resource diResource = ((DiModel) fModelSet.getModel(DiModel.DI_MODEL_ID)).getResource();
		IFile file = ResourceUtils.getFile(diResource);

		return file;
	}

}
