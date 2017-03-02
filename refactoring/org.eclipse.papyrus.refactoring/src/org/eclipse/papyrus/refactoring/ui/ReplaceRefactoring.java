/// *****************************************************************************
// * Copyright (c) 2016 CEA LIST.
// *
// *
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// *
// * Contributors:
// * CEA LIST - Initial API and implementation
// *
// *****************************************************************************/
// package org.eclipse.papyrus.refactoring.ui;
//
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collection;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;
//
// import org.eclipse.emf.ecore.EObject;
// import org.eclipse.ltk.core.refactoring.RefactoringStatus;
// import org.eclipse.papyrus.refactoring.messages.Messages;
// import org.eclipse.papyrus.refactoring.refactoringOnElement.AbstractTransformationOnElement;
// import org.eclipse.papyrus.refactoring.refactoringOnElement.ITransformationOnElement;
// import org.eclipse.papyrus.refactoring.refactoringOnElement.ReplaceTransformationOnElement;
// import org.eclipse.papyrus.uml.search.ui.pages.PapyrusSearchResultPage;
// import org.eclipse.papyrus.uml.search.ui.query.AbstractPapyrusQuery;
// import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
// import org.eclipse.papyrus.views.search.results.AttributeMatch;
// import org.eclipse.papyrus.views.search.utils.MatchUtils;
// import org.eclipse.swt.SWT;
// import org.eclipse.swt.layout.GridData;
// import org.eclipse.swt.layout.GridLayout;
// import org.eclipse.swt.widgets.Composite;
// import org.eclipse.swt.widgets.Label;
// import org.eclipse.swt.widgets.Text;
//
//
/// **
// * Refactoring based on the {@link org.eclipse.papyrus.uml.search.ui.pages.PapyrusSearchResultPage}
// *
// */
// @SuppressWarnings("restriction")
// public class ReplaceRefactoring extends AbstractTransformationOnElement {
//
// /** The String to replace the old one */
// private Text fNewValueText;
//
// /** The old String to be replaced */
// private Text fOldValueText;
//
// /** */
// private PapyrusSearchResultPage fResultPage;
//
// private AbstractPapyrusQuery fQuery;
//
// private Object[] fSelection;
//
// private Set<AbstractResultEntry> fListMatch;
//
//
// /**
// * Constructor.
// *
// * @param resultPage
// * @param selection
// */
// public ReplaceRefactoring(PapyrusSearchResultPage resultPage, Object[] selection) {
// super(Messages.PAPYRUSREFACTORING_REPLACE_LABEL);
// fResultPage = resultPage;
// fSelection = selection;
// fQuery = (AbstractPapyrusQuery) fResultPage.getInput().getQuery();
// initListMatches();
// }
//
//
// private Text createNameField(Composite result) {
// Text field = new Text(result, SWT.SINGLE | SWT.LEFT | SWT.BORDER);
// field.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
// return field;
// }
//
//
// @Override
// public RefactoringStatus checkFinalConditions() {
// RefactoringStatus status = new RefactoringStatus();
//
// if (fNewValueText.getText().isEmpty()) {
// status.merge(RefactoringStatus.createFatalErrorStatus(Messages.REFACTORINGPAGE_REPLACE_HINT));
// } else if (fNewValueText.getText().equals(fQuery.getSearchQueryText())) {
// status.merge(RefactoringStatus.createFatalErrorStatus(Messages.REFACTORINGPAGE_REPLACE_EQUALERROR));
// }
//
// return status;
// }
//
//
// @Override
// public void createControl(Composite parent) {
//
// GridLayout layout = new GridLayout();
//
// Composite composite = new Composite(parent, SWT.NONE);
// layout.marginHeight = 0;
// layout.marginWidth = 0;
// layout.numColumns = 2;
// composite.setLayout(layout);
// composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
//
// setControl(composite);
//
// Label label = new Label(composite, SWT.NONE);
// label.setText(Messages.REFACTORINGPAGE_REPLACE_ORIGINALSTRINGLABEL);
// fOldValueText = createNameField(composite);
// fOldValueText.setFocus();
// fOldValueText.setText(fQuery.getSearchQueryText());
// fOldValueText.setEnabled(false);
//
// label = new Label(composite, SWT.NONE);
// label.setText(Messages.REFACTORINGPAGE_REPLACE_TOREPLACESTRINGLABEL);
//
// fNewValueText = createNameField(composite);
//
// GridData data = new GridData();
// data.horizontalAlignment = SWT.END;
//
// }
//
//
// private void initListMatches() {
// fListMatch = new HashSet<>();
// if (fSelection == null) {
// for (AbstractResultEntry resultEntry : MatchUtils.getMatches(fResultPage.getInput(), false)) {
// if (resultEntry instanceof AttributeMatch) {
// fListMatch.add(resultEntry);
// }
// }
// } else {
// for (Object selected : Arrays.asList(fSelection)) {
// if (selected instanceof AttributeMatch) {
// fListMatch.add((AttributeMatch) selected);
// }
// }
// }
// }
//
//
// @Override
// public Collection<EObject> getElementsListToTransform() {
// List<EObject> toProcess = new ArrayList<>();
// for (AbstractResultEntry match : fListMatch) {
// if (match.getSource() instanceof EObject) {
// if (!toProcess.contains(match.getSource())) {
// toProcess.add((EObject) match.getSource());
// }
// }
// }
// return toProcess;
// }
//
// @Override
// public ITransformationOnElement getTransformationOnElement() {
// return new ReplaceTransformationOnElement(fListMatch, fQuery, fNewValueText.getText());
// }
//
// @Override
// public String getName() {
// return Messages.PAPYRUSREFACTORING_REPLACE_LABEL;
// }
// }
