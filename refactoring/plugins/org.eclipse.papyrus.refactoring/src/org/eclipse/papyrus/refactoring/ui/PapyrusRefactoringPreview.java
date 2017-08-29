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
package org.eclipse.papyrus.refactoring.ui;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.internal.CompareContainer;
import org.eclipse.compare.internal.CompareUIPlugin;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.ui.refactoring.ChangePreviewViewerInput;
import org.eclipse.ltk.ui.refactoring.IChangePreviewViewer;
import org.eclipse.papyrus.refactoring.Activator;
import org.eclipse.papyrus.refactoring.core.IPreviewablePapyrusChange;
import org.eclipse.papyrus.refactoring.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.team.internal.ui.synchronize.LocalResourceTypedElement;
import org.eclipse.team.internal.ui.synchronize.SaveablesCompareEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * The purpose of this class is to show the user the differences between the original model and the model after the transformation.
 * 
 */
@SuppressWarnings("restriction")
public class PapyrusRefactoringPreview implements IChangePreviewViewer {

	/** Main composite of the preview page */
	private ViewForm fComposite;

	/** Change storing the intial and preview file */
	private IPreviewablePapyrusChange fChange;

	/** Control used to manipulate the page's previewed content */
	private Control fPreviewControl;

	/** Resource from the preview model retrieved from the previewed change */
	private IFile fPreviewResource;

	/** Resource from the original model retrieved from the previewed change */
	private IFile fOriginalResource;


	@Override
	public void createControl(Composite parent) {

		if (fComposite == null) {
			fComposite = new ViewForm(parent, SWT.NONE);
			fComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			fComposite.setLayout(new GridLayout(1, true));
		}

	}


	@Override
	public Control getControl() {
		return fComposite;
	}


	@Override
	public void setInput(ChangePreviewViewerInput input) {
		if (fPreviewControl != null) {
			fPreviewControl.dispose();
		}
		if (input.getChange() instanceof IPreviewablePapyrusChange) {
			setChange(input);
			CompareEditorInput preview = initiateComparison();
			if (preview != null) {
				showPreview(preview);
			}
		}
	}


	/**
	 * Show the UI comparison between the original model and the refactored model
	 * 
	 * @param preview
	 *            The {@link CompareEditorInput} for the comparison between the preview model and the original model
	 */
	private void showPreview(final CompareEditorInput preview) {

		CompareUIPlugin plugin = CompareUIPlugin.getDefault();


		if (plugin != null) {
			if (plugin.compareResultOK(preview, null)) {
				Runnable runnable = new Runnable() {

					@Override
					public void run() {
						CompareConfiguration compareConfiguration = preview.getCompareConfiguration();
						compareConfiguration.setLeftEditable(false);
						compareConfiguration.setLeftLabel(Messages.PAPYRUSREFACTORPREVIEW_CHANGEDMODEL);
						compareConfiguration.setRightEditable(false);
						compareConfiguration.setRightLabel(Messages.PAPYRUSREFACTORPREVIEW_ORIGINALMODEL);

						preview.setContainer(new CompareContainer());

						fPreviewControl = preview.createContents(fComposite);

						fComposite.setContent(fPreviewControl);
					}
				};
				syncExec(runnable);

				fComposite.getShell().setSize(new Point(1000, 900));
			}
		}
		fPreviewControl.addDisposeListener(new DisposeListener() {

			@Override
			public void widgetDisposed(DisposeEvent e) {
				IProject projectToDestroy = fPreviewResource.getProject();
				if (projectToDestroy.exists()) {
					try {
						projectToDestroy.delete(true, true, new NullProgressMonitor());
					} catch (CoreException e1) {
						Activator.log.error(e1);
					}
				}
			}
		});
	}

	/** Sets the change variable from the input */
	private void setChange(ChangePreviewViewerInput input) {
		fChange = (IPreviewablePapyrusChange) input.getChange();
	}

	/** Just an util method */
	private void syncExec(Runnable runnable) {
		if (Display.getCurrent() == null) {
			Display.getDefault().syncExec(runnable);
		} else {
			runnable.run();
		}
	}


	/**
	 * Do the comparison between the original and the refactored model
	 * 
	 * @return
	 * 		the input that enables compare to display the result of the comparison between the original and the refactored model.
	 */
	private CompareEditorInput initiateComparison() {

		if (fOriginalResource == null) {
			fOriginalResource = fChange.getInitialFile();
		}

		fPreviewResource = fChange.getPreviewFile();

		LocalResourceTypedElement initialResource = new LocalResourceTypedElement(fPreviewResource);
		LocalResourceTypedElement previewResource = new LocalResourceTypedElement(fOriginalResource);

		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		SaveablesCompareEditorInput preview = new SaveablesCompareEditorInput(null, initialResource, previewResource, page);

		return preview;

	}

}
