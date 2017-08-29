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
package org.eclipse.papyrus.refactoring.core;

import java.io.IOException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.emf.utils.ResourceUtils;
import org.eclipse.papyrus.refactoring.Activator;
import org.eclipse.papyrus.refactoring.messages.Messages;


/**
 * A {@link Change} for Papyrus refactoring.
 * 
 * @noextend This class is not intended to be extended by clients.
 * 
 */
public class PapyrusChange extends Change implements IPreviewablePapyrusChange {

	/** The ModelSet on which we apply the change. */
	protected ModelSet fModelSet;

	/** The Papyrus Refactoring to execute. */
	protected AbstractPapyrusTransformation fPapyrusRefactoringTransformation;

	/** The name of the refactoring. */
	private final String fName;

	/** The preview modelSet containing the change used to compare it to the original in the compare view */
	private ModelSet fPreviewModelSet;

	/** The element to change */
	private Object fElementToTransform;

	/**
	 * Constructor.
	 *
	 * @param papyrusRefactoringTransformation
	 *            The transformation to execute
	 * @param name
	 *            The tag associated to the transformation
	 * @param modelSet
	 *            The modelSet containing the element to transform
	 */
	public PapyrusChange(AbstractPapyrusTransformation papyrusRefactoringTransformation, String name, ModelSet modelSet) {
		fName = name;
		fModelSet = modelSet;
		fPapyrusRefactoringTransformation = papyrusRefactoringTransformation;
		fElementToTransform = papyrusRefactoringTransformation.fElementToTransform;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return fName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initializeValidationData(IProgressMonitor pm) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		RefactoringStatus status = new RefactoringStatus();
		try {
			pm.beginTask(Messages.PAPYRUSCHANGE_CHECKVALIDITY, 3);
			if (fModelSet == null) {
				status.merge(RefactoringStatus.createFatalErrorStatus(Messages.PAPYRUSCHANGE_MODELOPEN_ERROR));
			}
			return status;
		} finally {
			pm.done();
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		return performRefactor(fModelSet, Messages.PAPYRUSCHANGE_SET_PERFORM);
	}

	/**
	 * Apply the refactoring on the given ModelSet
	 *
	 * @param modelSet
	 *            The ModelSet on which we do the refactoring.
	 * @return
	 */
	protected Change performRefactor(ModelSet modelSet, String label) {
		final TransactionalEditingDomain editingDomain = modelSet.getTransactionalEditingDomain();
		// final PapyrusRefactoringCommand refactoringCommand = new PapyrusRefactoringCommand(editingDomain, fPapyrusRefactoringTransformation, modelSet);
		final PapyrusRefactoringCommand emfOperation = new PapyrusRefactoringCommand(editingDomain, fPapyrusRefactoringTransformation, modelSet, label + fName);

		try {
			emfOperation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return new UndoPapyrusChange(emfOperation, fElementToTransform, fName);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getModifiedElement() {
		// return fModelSet;
		return fElementToTransform;
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
		String nameProject = Messages.PAPYRUSCHANGE_PREVIEWPROJECT_NAME;
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

		IPath path = new Path(project.getFullPath().toString() + Messages.PAPYRUSCHANGE_PREVIEWMODEL_NAME);
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

		performRefactor(previewModelSet, Messages.PAPYRUSCHANGE_PREVIEW_PERFORM);

		try {
			// modelSetForPreviewFile.saveAs(URI.createPlatformResourceURI(path.toString(), true));
			previewModelSet.saveAs(URI.createPlatformResourceURI(path.toString(), true));
		} catch (IOException e) {
			Activator.log.error(e);
		}
		// Assert.isNotNull(modelSetForPreviewFile, Messages.PAPYRUSCHANGE_PREVIEWCREATION_ERROR);
		Assert.isNotNull(previewModelSet, Messages.PAPYRUSCHANGE_PREVIEWCREATION_ERROR);

		return previewFile;
	}


	/**
	 * Return the original "di" file.
	 */
	@Override
	public IFile getInitialFile() {
		// Resource diResource = DiModelUtils.getDiResource(fModelSet);
		Resource diResource = ((DiModel) fModelSet.getModel(DiModel.DI_MODEL_ID)).getResource();
		IFile file = ResourceUtils.getFile(diResource);

		return file;
	}


}
