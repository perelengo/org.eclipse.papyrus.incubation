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
package org.eclipse.papyrus.uml.refactoring.replace.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.refactoring.helper.AbstractChoiceOnUIParticipantsTransformation;
import org.eclipse.papyrus.refactoring.refactoringOnElement.ITransformationOnElement;
import org.eclipse.papyrus.refactoring.refactoringOnElement.ReplaceTransformationOnElement;
import org.eclipse.papyrus.uml.refactoring.replace.messages.Messages;
import org.eclipse.papyrus.uml.search.ui.query.PapyrusQuery;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Refactoring Participant defining the Replace dialog and specifying the methods to call for a replace action
 * 
 */
public class ReplaceRefactoring extends AbstractChoiceOnUIParticipantsTransformation {

	/** The field where the user indicates the new string. */
	private Text fNewValueText;

	/** The field where the user indicates the string to replace. */
	private Text fOldValueText;

	/** A button to know if the string indicated by the user is case sensitive. */
	private Button fBtnCaseSensitive;

	/** A button to indicate if we have to replace all strings. */
	private Button fReplaceAllStringAttributes;

	/** A button to indicate if we have to replace only the name. */
	private Button fReplaceNameAttribute;


	/**
	 * Constructor.
	 *
	 */
	public ReplaceRefactoring() {
		super(Messages.REPLACEREFACTORING_PAGELABEL);
		// super(Messages.ReplaceRefactoring_8);
	}

	/**
	 * Create a {@link Text} in a composite.
	 * 
	 * @param result
	 *            The composite where we have to create the {@link Text}.
	 * @return
	 * 		The {@link Text} created.
	 */
	private Text createNameField(Composite result) {
		Text field = new Text(result, SWT.SINGLE | SWT.LEFT | SWT.BORDER);
		field.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return field;
	}



	@Override
	public RefactoringStatus checkFinalConditions() {
		RefactoringStatus status = new RefactoringStatus();
		if (fOldValueText.getText().isEmpty()) {
			status.merge(RefactoringStatus.createFatalErrorStatus(Messages.REPLACEREFACTORING_INITALTEXT));
		} else if (fNewValueText.getText().isEmpty()) {
			status.merge(RefactoringStatus.createFatalErrorStatus(Messages.REPLACEREFACTORING_NEWTEXT));

		}
		return status;
	}


	@Override
	public void createContent(Composite parent) {

		GridLayout layout = new GridLayout();

		Composite composite = new Composite(parent, SWT.NONE);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = 3;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		Label label = new Label(composite, SWT.NONE);
		label.setText(Messages.REPLACEREFACTORING_INITIALTEXT_LABEL);
		fOldValueText = createNameField(composite);
		fOldValueText.setFocus();

		fBtnCaseSensitive = new Button(composite, SWT.CHECK);
		fBtnCaseSensitive.setText(Messages.REPLACEREFACTORING_CASE);

		label = new Label(composite, SWT.NONE);
		label.setText(Messages.REPLACEREFACTORING_NEWTEXT_LABEL);

		fNewValueText = createNameField(composite);

		GridData data = new GridData();
		data.horizontalAlignment = SWT.END;


		fReplaceNameAttribute = new Button(parent, SWT.RADIO);
		fReplaceNameAttribute.setText(Messages.REPLACEREFACTORING_NAMESCOPE);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 3;
		data.verticalIndent = 15;
		fReplaceNameAttribute.setLayoutData(data);
		fReplaceNameAttribute.setSelection(true);

		fReplaceAllStringAttributes = new Button(parent, SWT.RADIO);
		fReplaceAllStringAttributes.setText(Messages.REPLACEREFACTORING_MODELSCOPE);
		GridData data2 = new GridData(GridData.FILL_HORIZONTAL);


		data2.horizontalSpan = 3;
		fReplaceAllStringAttributes.setLayoutData(data2);

	}


	@Override
	public ITransformationOnElement getTransformationOnElement() {

		Collection<ScopeEntry> scpEntry = new ArrayList<>();
		scpEntry.add(createScopeEntry());
		PapyrusQuery query = new PapyrusQuery(fOldValueText.getText(), fBtnCaseSensitive.getSelection(), false, scpEntry, getMetaClassesList(), fReplaceAllStringAttributes.getSelection());
		query.run(new NullProgressMonitor());
		return new ReplaceTransformationOnElement(query.getResults(), query, fNewValueText.getText());
	}

	/**
	 * Retrieves all the metaclasses of the UMLPackage in order to parse the model during the search query
	 * 
	 * @return
	 * 		The list containing the metaclasses
	 */
	private Object[] getMetaClassesList() {
		Set<EClassifier> umlMetaClasses = new HashSet<>();
		for (EClassifier eClassifier : UMLPackage.eINSTANCE.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				umlMetaClasses.add(eClassifier);
			}
		}
		return umlMetaClasses.toArray();
	}

	/**
	 * Sets the entry, i.e. the scope of the query, as the selected element's model
	 * 
	 * @return
	 */
	private ScopeEntry createScopeEntry() {
		// Resource diResource = DiModelUtils.getDiResource(fModelSet);
		Resource diResource = ((DiModel) fModelSet.getModel(DiModel.DI_MODEL_ID)).getResource();
		return new ScopeEntry(diResource.getURI());
	}


	@Override
	public String getName() {
		return Messages.REPLACEREFACTORING_PAGELABEL;
	}

	@Override
	public void performHelp() {
		// TODO Write the help
		// http://help.eclipse.org/mars/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fextension-points%2Forg_eclipse_help_contexts.html
		PlatformUI.getWorkbench().getHelpSystem().displayHelp("help context id");
	}

}


