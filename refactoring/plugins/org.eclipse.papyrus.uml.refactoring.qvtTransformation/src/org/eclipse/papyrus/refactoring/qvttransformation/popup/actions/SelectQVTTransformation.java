/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.refactoring.qvttransformation.popup.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.refactoring.core.AbstractPapyrusTransformation;
import org.eclipse.papyrus.refactoring.qvttransformation.Activator;
import org.eclipse.papyrus.refactoring.util.PapyrusRefactoringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * This class implements a possible integration of QVTo transformation in Papyrus
 * 
 */
@SuppressWarnings("restriction")
public class SelectQVTTransformation extends AbstractPapyrusTransformation {

	private IFile fTransformationFile;
	private TreeViewer fViewer;
	private Composite selectionComposite;


	public SelectQVTTransformation() {
		super("QVT Transformation");
	}


	@Override
	public RefactoringStatus checkFinalConditions() {
		RefactoringStatus status = new RefactoringStatus();
		if (((IStructuredSelection) fViewer.getSelection()).size() == 0) {
			status.addFatalError("You have to select one \"qvto\" file.");
		} else if (((IStructuredSelection) fViewer.getSelection()).size() > 1) {
			status.addFatalError("You can not select several files.");
		} else {
			Object selectedElement = ((IStructuredSelection) fViewer.getSelection()).getFirstElement();
			if (selectedElement instanceof IFile) {
				fTransformationFile = (IFile) selectedElement;
				if (!fTransformationFile.getFileExtension().contains("qvt")) {
					status.addFatalError("You have to select a \"qvto\" file.");
				}
			}
		}

		return status;
	}


	@Override
	public void execute(ModelSet modelSetToTransform) {

		// Reification of the transformation
		QvtTransformation transfo = new QvtInterpretedTransformation(fTransformationFile);
		// Retrieve transformation's parameters
		List<TransformationParameter> params;
		try {
			params = transfo.getParameters();

			// The transformation must have only one parameter.
			if (params.size() == 1) {
				// Retrieve first parameter's metamodels
				List<EPackage> metamodels = params.get(0).getMetamodels();

				// The parameter must be INOUT and it only have UML as metamodel
				if (params.get(0).getDirectionKind() == DirectionKind.INOUT && metamodels.size() == 1 && metamodels.get(0).getNsPrefix().compareToIgnoreCase("uml") == 0) {

					// Define the command in Papyrus' editing domain

					URI uri = URI.createPlatformResourceURI(fTransformationFile.getFullPath().toString(), true);

					// Create a executor for the transformation
					TransformationExecutor executor = new TransformationExecutor(uri);

					// Define the input as the model that contains the selected diagramEditPart
					List<EObject> contents = new ArrayList<EObject>();

					if (PapyrusRefactoringUtils.getSelectedElements(modelSetToTransform).size() == 0) {
						contents.add(PapyrusRefactoringUtils.getUMLRoot(modelSetToTransform));
					} else {
						contents.addAll(PapyrusRefactoringUtils.getSelectedElements(modelSetToTransform));
					}


					ModelExtent input = new BasicModelExtent(contents);
					// ModelExtent output = new BasicModelExtent();

					ExecutionContextImpl context = new ExecutionContextImpl();
					// Execute the transformation

					// ExecutionDiagnostic diagnostic = executor.execute(context, input);
					executor.execute(context, input);

				}
			}
		} catch (MdaException e) {
			Activator.log.error(e);
		}

	}


	@Override
	public void createControl(Composite parent) {

		selectionComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = 1;

		selectionComposite.setLayout(layout);
		selectionComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		setControl(selectionComposite);

		fViewer = new TreeViewer(selectionComposite, SWT.FILL);
		fViewer.setContentProvider(new BaseWorkbenchContentProvider());
		fViewer.setLabelProvider(new WorkbenchLabelProvider());
		fViewer.setInput(ResourcesPlugin.getWorkspace().getRoot());

		GridData data = new GridData(GridData.FILL_BOTH);
		Tree treeWidget = fViewer.getTree();
		treeWidget.setLayoutData(data);
		treeWidget.setFont(parent.getFont());
	}

	@Override
	public void performHelp() {
		// TODO Write the help
		// http://help.eclipse.org/mars/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fextension-points%2Forg_eclipse_help_contexts.html
		PlatformUI.getWorkbench().getHelpSystem().displayHelp("help context id");
	}

}
