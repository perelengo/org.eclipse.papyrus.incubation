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
package org.eclipse.papyrus.refactoring.tests.mutate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.Bendpoints;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.refactoring.tests.Activator;
import org.eclipse.papyrus.refactoring.tests.utils.AbstractPapyrusRefactoringTestCase;
import org.eclipse.papyrus.refactoring.tests.utils.PapyrusRefactoringTestsUtils;
import org.eclipse.papyrus.refactoring.util.PapyrusRefactoringUtils;
import org.eclipse.papyrus.uml.refactoring.mutation.helper.MutationTransformation;
import org.eclipse.papyrus.uml.refactoring.mutation.utils.ModelNotationUtils;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Class containing the tests for the Mutation part of the refactoring tool
 * 
 */
public class RefactoringMutationTest extends AbstractPapyrusRefactoringTestCase {

	/**
	 * This test mutates a single unlinked Node in the model
	 */
	@Test
	public void nodeMutationTest() {
		mutationTransformation = new MutationTransformation(mainPModelSet1, UMLPackage.eINSTANCE.getClass_(),
				IETypesMap.get("Interface"));

		TransactionalEditingDomain editingDomain = mainPModelSet1.getTransactionalEditingDomain();
		CommandStack commandStack = editingDomain.getCommandStack();
		RecordingCommand mutationCommand = new RecordingCommand(editingDomain, "mutate basicClass") {

			@Override
			protected void doExecute() {
				mutationTransformation.transformationToExecute(basicClass);
			}
		};

		Assert.assertTrue("The command should be executable", mutationCommand.canExecute());
		String oldXMIID = PapyrusRefactoringUtils.getRelatedXMIID(basicClass, mainPModelSet1);
		EObject oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		Assert.assertNotNull("The reference element couldnt be retrieved", oldElement);

		commandStack.execute(mutationCommand);
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during nodeMutationTest", ioe);
		}
		String newXMIID = PapyrusRefactoringUtils.getRelatedXMIID(mutationTransformation.getMutatedElement(), mainPModelSet1);
		oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		EObject newElement = PapyrusRefactoringUtils.getRelatedElement(newXMIID, mainPModelSet1);
		Assert.assertNull("The initial element should have been deleted from the model", oldElement);
		Assert.assertTrue("The created mutation should be an instance of Interface", newElement instanceof org.eclipse.uml2.uml.Interface);

		Assert.assertTrue("can undo the most recent refactoring command", commandStack.canUndo());
		commandStack.undo();
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during the test", ioe);
		}
		oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		newElement = PapyrusRefactoringUtils.getRelatedElement(newXMIID, mainPModelSet1);
		Assert.assertTrue("The initial element should have restored in the model", oldElement instanceof org.eclipse.uml2.uml.Class);
		Assert.assertNull("The created mutation should have been deleted from the model", newElement);

	}


	/**
	 * This test mutates a Node linked to another
	 */
	@Test
	public void linkedNodeMutationTest() {
		mutationTransformation = new MutationTransformation(mainPModelSet1, UMLPackage.eINSTANCE.getClass_(),
				IETypesMap.get("Component"));

		TransactionalEditingDomain editingDomain = mainPModelSet1.getTransactionalEditingDomain();
		CommandStack commandStack = editingDomain.getCommandStack();
		RecordingCommand mutationCommand = new RecordingCommand(editingDomain, "mutate associationSource") {

			@Override
			protected void doExecute() {
				mutationTransformation.transformationToExecute(associationSource);
			}
		};

		Assert.assertTrue("The command should be executable", mutationCommand.canExecute());
		String oldXMIID = PapyrusRefactoringUtils.getRelatedXMIID(associationSource, mainPModelSet1);
		EObject oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		Assert.assertNotNull("The reference element couldnt be retrieved", oldElement);

		commandStack.execute(mutationCommand);
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during linkedNodeMutationTest", ioe);
		}
		String newXMIID = PapyrusRefactoringUtils.getRelatedXMIID(mutationTransformation.getMutatedElement(), mainPModelSet1);
		oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		EObject newElement = PapyrusRefactoringUtils.getRelatedElement(newXMIID, mainPModelSet1);
		Assert.assertNull("The initial element should have been deleted from the model", oldElement);
		Assert.assertTrue("The created mutation should be an instance of Component", newElement instanceof org.eclipse.uml2.uml.Component);

		// The mutation should have been reconnected with any previously existing links
		org.eclipse.uml2.uml.Component component = ((org.eclipse.uml2.uml.Component) newElement);
		List<org.eclipse.uml2.uml.Type> memeberEnds = new ArrayList<>();
		for (org.eclipse.uml2.uml.Property property : association.getMemberEnds()) {
			org.eclipse.uml2.uml.Type type = property.getType();
			memeberEnds.add(type);
		}
		Assert.assertTrue("After the mutation, " + association.getQualifiedName() + "should have " + component.getQualifiedName() + " as a memberEnd",
				memeberEnds.contains(newElement));
		Assert.assertFalse("The mutation should inherit any previously owned attributes", component.getAllAttributes().isEmpty());

		Assert.assertTrue("can undo the most recent refactoring command", commandStack.canUndo());
		commandStack.undo();
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during the test", ioe);
		}
		oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		newElement = PapyrusRefactoringUtils.getRelatedElement(newXMIID, mainPModelSet1);
		Assert.assertTrue("The initial element should have restored in the model", oldElement instanceof org.eclipse.uml2.uml.Class);
		Assert.assertNull("The created mutation should have been deleted from the model", newElement);

		// The model should revert back into its original state
		memeberEnds.clear();
		for (org.eclipse.uml2.uml.Property property : association.getMemberEnds()) {
			org.eclipse.uml2.uml.Type type = property.getType();
			memeberEnds.add(type);
		}
		Assert.assertTrue("After undoing the mutation, " + association.getQualifiedName() + "should have " + associationSource.getQualifiedName() + " as a memberEnd",
				memeberEnds.contains(associationSource));

	}


	/**
	 * This test mutates a Node containg children
	 */
	@Test
	public void parentNodeMutationTest() {
		mutationTransformation = new MutationTransformation(mainPModelSet1, UMLPackage.eINSTANCE.getPackage(),
				IETypesMap.get("Model"));

		TransactionalEditingDomain editingDomain = mainPModelSet1.getTransactionalEditingDomain();
		CommandStack commandStack = editingDomain.getCommandStack();
		RecordingCommand mutationCommand = new RecordingCommand(editingDomain, "mutate parentPackage") {

			@Override
			protected void doExecute() {
				mutationTransformation.transformationToExecute(parentPackage);
			}
		};

		Assert.assertTrue("The command should be executable", mutationCommand.canExecute());
		String oldXMIID = PapyrusRefactoringUtils.getRelatedXMIID(parentPackage, mainPModelSet1);
		EObject oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		Assert.assertNotNull("The reference element couldnt be retrieved", oldElement);

		commandStack.execute(mutationCommand);
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during parentNodeMutationTest", ioe);
		}
		String newXMIID = PapyrusRefactoringUtils.getRelatedXMIID(mutationTransformation.getMutatedElement(), mainPModelSet1);
		oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		EObject newElement = PapyrusRefactoringUtils.getRelatedElement(newXMIID, mainPModelSet1);
		Assert.assertNull("The initial element should have been deleted from the model", oldElement);
		Assert.assertTrue("The created mutation should be an instance of Model", newElement instanceof org.eclipse.uml2.uml.Model);

		Set<EObject> containedElements = PapyrusRefactoringTestsUtils.getAllContainedElements(newElement);
		Assert.assertTrue("The mutation should contain a childPackage", containedElements.contains(childPackage));
		Assert.assertTrue("The mutation should contain a generalization source", containedElements.contains(generalizationSource));
		Assert.assertTrue("The mutation should contain a generalization target", containedElements.contains(generalizationTarget));
		Assert.assertTrue("The mutation should contain a generalization source property", containedElements.contains(gsProperty));
		Assert.assertTrue("The mutation should contain a generalization", containedElements.contains(generalization));

		Assert.assertTrue("can undo the most recent refactoring command", commandStack.canUndo());
		commandStack.undo();
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during the parentNodeMutationTest", ioe);
		}
		oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		newElement = PapyrusRefactoringUtils.getRelatedElement(newXMIID, mainPModelSet1);
		Assert.assertTrue("The initial element should have restored in the model", oldElement instanceof org.eclipse.uml2.uml.Package);
		Assert.assertNull("The created mutation should have been deleted from the model", newElement);

	}


	/**
	 * This test verifies that the previously applied stereotypes are still applied, if they can be, on the mutated element
	 */
	@Test
	public void stereotypeApplicationTest() {
		mutationTransformation = new MutationTransformation(mainPModelSet1, UMLPackage.eINSTANCE.getClass_(),
				IETypesMap.get("Artifact"));

		TransactionalEditingDomain editingDomain = mainPModelSet1.getTransactionalEditingDomain();
		CommandStack commandStack = editingDomain.getCommandStack();
		RecordingCommand mutationCommand = new RecordingCommand(editingDomain, "mutate associationTarget") {

			@Override
			protected void doExecute() {
				mutationTransformation.transformationToExecute(associationTarget);
			}
		};

		Assert.assertTrue("The command should be executable", mutationCommand.canExecute());
		String oldXMIID = PapyrusRefactoringUtils.getRelatedXMIID(associationTarget, mainPModelSet1);
		EObject oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		Assert.assertNotNull("The reference element couldnt be retrieved", oldElement);
		Assert.assertTrue("The element should be an instance of Element", oldElement instanceof org.eclipse.uml2.uml.Element);
		List<org.eclipse.uml2.uml.Stereotype> oldStereotypes = ((org.eclipse.uml2.uml.Element) oldElement).getAppliedStereotypes();
		Assert.assertFalse("The list of applied stereotypes should not be empty", oldStereotypes.isEmpty());

		commandStack.execute(mutationCommand);
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during childrenViewTest", ioe);
		}
		String newXMIID = PapyrusRefactoringUtils.getRelatedXMIID(mutationTransformation.getMutatedElement(), mainPModelSet1);
		EObject newElement = PapyrusRefactoringUtils.getRelatedElement(newXMIID, mainPModelSet1);
		oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		Assert.assertNull("The old element should have been removed from the model", oldElement);
		Assert.assertNotNull("The new element should have been created", newElement);
		Assert.assertTrue("The new element should be an instance of Interface", newElement instanceof org.eclipse.uml2.uml.Artifact);
		Assert.assertTrue("The element should be an instance of Element", newElement instanceof org.eclipse.uml2.uml.Element);
		List<org.eclipse.uml2.uml.Stereotype> newStereotypes = ((org.eclipse.uml2.uml.Element) newElement).getAppliedStereotypes();
		Assert.assertFalse("The list of applied stereotypes should not be empty", newStereotypes.isEmpty());

		for (org.eclipse.uml2.uml.Stereotype stereotype : newStereotypes) {
			Assert.assertTrue("The new element should be burdened with the applicable stereotypes",
					oldStereotypes.contains(stereotype) && newStereotypes.size() == oldStereotypes.size() - 1);
		}

		Assert.assertTrue("can undo the most recent refactoring command", commandStack.canUndo());
		commandStack.undo();
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during the childrenViewTest", ioe);
		}

		oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		List<org.eclipse.uml2.uml.Stereotype> undoOldStereotypes = ((org.eclipse.uml2.uml.Element) oldElement).getAppliedStereotypes();
		for (org.eclipse.uml2.uml.Stereotype stereotype : oldStereotypes) {
			Assert.assertTrue("The old element should have been restored with its original stereotypes", undoOldStereotypes.contains(stereotype));
		}
	}


	/**
	 * This test verifies that the children of a mutated element are still visible after the mutation
	 */
	@Test
	public void childrenViewTest() {
		mutationTransformation = new MutationTransformation(mainPModelSet1, UMLPackage.eINSTANCE.getClass_(),
				IETypesMap.get("Interface"));

		TransactionalEditingDomain editingDomain = mainPModelSet1.getTransactionalEditingDomain();
		CommandStack commandStack = editingDomain.getCommandStack();
		RecordingCommand mutationCommand = new RecordingCommand(editingDomain, "mutate generalizationSource") {

			@Override
			protected void doExecute() {
				mutationTransformation.transformationToExecute(generalizationSource);
			}
		};

		Assert.assertTrue("The command should be executable", mutationCommand.canExecute());
		String oldXMIID = PapyrusRefactoringUtils.getRelatedXMIID(generalizationSource, mainPModelSet1);
		EObject oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		Assert.assertNotNull("The reference element couldnt be retrieved", oldElement);
		View oldView = ModelNotationUtils.getRelatedView(oldElement, mainPModelSet1);
		Assert.assertNotNull("The reference view couldnt be retrieved", oldView);
		Set<View> oldVisibleChildren = ModelNotationUtils.getVisibleChildren(oldView);
		Assert.assertFalse("The reference view should have visible children", oldVisibleChildren.isEmpty());
		// Need to build this list now has the nested objects wont be available after the execution of the command
		Set<EObject> oldVisibleObjects = new HashSet<>();
		for (View view : oldVisibleChildren) {
			EObject viewObject = view.getElement();
			oldVisibleObjects.add(viewObject);
		}
		Assert.assertTrue("The reference view's visible children should include the generalizationSourceProperty", oldVisibleObjects.contains(gsProperty));
		Assert.assertFalse("The reference view's visible children should not include the generalizationSourceHiddenProperty", oldVisibleObjects.contains(gsHiddenProperty));

		commandStack.execute(mutationCommand);
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during childrenViewTest", ioe);
		}
		String newXMIID = PapyrusRefactoringUtils.getRelatedXMIID(mutationTransformation.getMutatedElement(), mainPModelSet1);
		EObject newElement = PapyrusRefactoringUtils.getRelatedElement(newXMIID, mainPModelSet1);
		oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		Assert.assertNull("The old element should have been removed from the model", oldElement);
		Assert.assertNotNull("The new element should have been created", newElement);
		Assert.assertTrue("The new element should be an instance of Interface", newElement instanceof org.eclipse.uml2.uml.Interface);

		Set<EObject> containedElements = PapyrusRefactoringTestsUtils.getAllContainedElements(newElement);
		Assert.assertTrue("The new element should contain a generalization source property", containedElements.contains(gsProperty));
		Assert.assertTrue("The new element should contain a generalization source hidden property", containedElements.contains(gsHiddenProperty));
		Assert.assertTrue("The new element should contain a generalization", containedElements.contains(generalization));

		View newView = ModelNotationUtils.getRelatedView(newElement, mainPModelSet1);
		Assert.assertNotNull("The new view couldnt be retrieved", newView);
		Set<View> newVisibleChildren = ModelNotationUtils.getVisibleChildren(newView);
		Assert.assertFalse("The new view should have visible children", newVisibleChildren.isEmpty());
		Set<EObject> newVisibleObjects = new HashSet<>();
		for (View view : newVisibleChildren) {
			EObject viewObject = view.getElement();
			newVisibleObjects.add(viewObject);
		}
		Assert.assertTrue("The new view's visible children should include the generalizationSourceProperty", oldVisibleObjects.contains(gsProperty));
		Assert.assertFalse("The new view's visible children should not include the generalizationSourceHiddenProperty", oldVisibleObjects.contains(gsHiddenProperty));


		Assert.assertTrue("can undo the most recent refactoring command", commandStack.canUndo());
		commandStack.undo();
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during the childrenViewTest", ioe);
		}

	}


	/**
	 * This test verifies that a mutated link retains its former bendpoints
	 */
	@Test
	public void bendpointsAndAchorTest() {
		mutationTransformation = new MutationTransformation(mainPModelSet1, UMLPackage.eINSTANCE.getAssociation(),
				IETypesMap.get("Generalization"));
		TransactionalEditingDomain editingDomain = mainPModelSet1.getTransactionalEditingDomain();
		CommandStack commandStack = editingDomain.getCommandStack();
		RecordingCommand mutationCommand = new RecordingCommand(editingDomain, "mutate association") {

			@Override
			protected void doExecute() {
				mutationTransformation.transformationToExecute(association);
			}
		};
		String oldXMIID = PapyrusRefactoringUtils.getRelatedXMIID(association, mainPModelSet1);
		EObject oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		Assert.assertNotNull("The reference element couldnt be retrieved", oldElement);
		View oldView = ModelNotationUtils.getRelatedView(oldElement, mainPModelSet1);
		Assert.assertNotNull("The reference view couldnt be retrieved", oldView);
		Edge oldEdge = (Edge) oldView;
		Bendpoints oldBendpoints = oldEdge.getBendpoints();
		Anchor oldTargetAnchor = oldEdge.getTargetAnchor();
		Anchor oldSourceAnchor = oldEdge.getSourceAnchor();
		View oldSource = oldEdge.getSource();
		View oldTarget = oldEdge.getTarget();

		Assert.assertTrue("The mutation command should be executable", mutationCommand.canExecute());
		commandStack.execute(mutationCommand);
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during the bendpointsAndAnchorTest", ioe);
		}

		String newXMIID = PapyrusRefactoringUtils.getRelatedXMIID(mutationTransformation.getMutatedElement(), mainPModelSet1);
		EObject newElement = PapyrusRefactoringUtils.getRelatedElement(newXMIID, mainPModelSet1);
		Assert.assertTrue("The new element should be an instance of Generalization", newElement instanceof org.eclipse.uml2.uml.Generalization);
		Assert.assertNotNull("The reference element couldnt be retrieved", newElement);
		View newView = ModelNotationUtils.getRelatedView(newElement, mainPModelSet1);
		Assert.assertNotNull("The reference view couldnt be retrieved", newView);
		Edge newEdge = (Edge) newView;
		Bendpoints newBendpoints = newEdge.getBendpoints();
		Assert.assertEquals("The bendpoints should be the same on the new element", oldBendpoints, newBendpoints);
		Anchor newTargetAnchor = newEdge.getTargetAnchor();
		Assert.assertEquals("The target anchor should be the same on the new element", oldTargetAnchor, newTargetAnchor);
		Anchor newSourceAnchor = newEdge.getSourceAnchor();
		Assert.assertEquals("The source anchor should be the same on the new element", oldSourceAnchor, newSourceAnchor);
		View newSource = newEdge.getSource();
		Assert.assertEquals("The source should be the same on the new element", oldSource, newSource);
		View newTarget = newEdge.getTarget();
		Assert.assertEquals("The target should be the same on the new element", oldTarget, newTarget);

		Assert.assertTrue("The mutation command should be undoable", mutationCommand.canUndo());
		commandStack.undo();
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during the bendpointsAndAnchorTest", ioe);
		}

	}


	/**
	 * This test checks that the previously applied style, through a user manipulation, is still applied on the mutated element
	 */
	@Test
	public void styleTest() {
		mutationTransformation = new MutationTransformation(mainPModelSet1, UMLPackage.eINSTANCE.getComponent(),
				IETypesMap.get("Class"));
		TransactionalEditingDomain editingDomain = mainPModelSet1.getTransactionalEditingDomain();
		CommandStack commandStack = editingDomain.getCommandStack();
		RecordingCommand mutationCommand = new RecordingCommand(editingDomain, "mutate generalizationTarget") {

			@Override
			protected void doExecute() {
				mutationTransformation.transformationToExecute(generalizationTarget);
			}
		};
		String oldXMIID = PapyrusRefactoringUtils.getRelatedXMIID(generalizationTarget, mainPModelSet1);
		EObject oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		Assert.assertNotNull("The reference element couldnt be retrieved", oldElement);
		View oldView = ModelNotationUtils.getRelatedView(oldElement, mainPModelSet1);
		Assert.assertNotNull("The reference view couldnt be retrieved", oldView);
		Shape oldShape = (Shape) oldView;
		int oldFillColor = oldShape.getFillColor();

		Assert.assertTrue("The mutation command should be executable", mutationCommand.canExecute());
		commandStack.execute(mutationCommand);
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during the compartmentViewTest", ioe);
		}

		String newXMIID = PapyrusRefactoringUtils.getRelatedXMIID(mutationTransformation.getMutatedElement(), mainPModelSet1);
		EObject newElement = PapyrusRefactoringUtils.getRelatedElement(newXMIID, mainPModelSet1);
		Assert.assertTrue("The new element should be an instance of Class", newElement instanceof org.eclipse.uml2.uml.Class);
		Assert.assertNotNull("The reference element couldnt be retrieved", newElement);
		View newView = ModelNotationUtils.getRelatedView(newElement, mainPModelSet1);
		Assert.assertNotNull("The reference view couldnt be retrieved", newView);
		Shape newShape = (Shape) newView;
		int newFillColor = newShape.getFillColor();
		Assert.assertEquals("The new element fillColor should be the same as the old one", oldFillColor, newFillColor);

		Assert.assertTrue("The mutation command should be undoable", mutationCommand.canUndo());
		commandStack.undo();
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during the compartmentViewTest", ioe);
		}

	}


	// @Test
	// Not yet possible as there are no way to compare the hidden/shown compartments by their ids from an element to the next
	public void compartmentViewTest() {
		mutationTransformation = new MutationTransformation(mainPModelSet1, UMLPackage.eINSTANCE.getComponent(),
				IETypesMap.get("Class"));
		TransactionalEditingDomain editingDomain = mainPModelSet1.getTransactionalEditingDomain();
		CommandStack commandStack = editingDomain.getCommandStack();
		RecordingCommand mutationCommand = new RecordingCommand(editingDomain, "mutate generalizationTarget") {

			@Override
			protected void doExecute() {
				mutationTransformation.transformationToExecute(generalizationTarget);
			}
		};
		String oldXMIID = PapyrusRefactoringUtils.getRelatedXMIID(generalizationTarget, mainPModelSet1);
		EObject oldElement = PapyrusRefactoringUtils.getRelatedElement(oldXMIID, mainPModelSet1);
		Assert.assertNotNull("The reference element couldnt be retrieved", oldElement);
		View oldView = ModelNotationUtils.getRelatedView(oldElement, mainPModelSet1);
		Assert.assertNotNull("The reference view couldnt be retrieved", oldView);

		Assert.assertTrue("The mutation command should be executable", mutationCommand.canExecute());
		commandStack.execute(mutationCommand);
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during the compartmentViewTest", ioe);
		}

		String newXMIID = PapyrusRefactoringUtils.getRelatedXMIID(mutationTransformation.getMutatedElement(), mainPModelSet1);
		EObject newElement = PapyrusRefactoringUtils.getRelatedElement(newXMIID, mainPModelSet1);
		Assert.assertTrue("The new element should be an instance of Class", newElement instanceof org.eclipse.uml2.uml.Class);
		Assert.assertNotNull("The reference element couldnt be retrieved", newElement);
		View newView = ModelNotationUtils.getRelatedView(newElement, mainPModelSet1);
		Assert.assertNotNull("The reference view couldnt be retrieved", newView);

		Assert.assertTrue("The mutation command should be undoable", mutationCommand.canUndo());
		commandStack.undo();
		try {
			mainPModelSet1.save(new NullProgressMonitor());
		} catch (IOException ioe) {
			Activator.log.error("Failed to save the modified resource during the compartmentViewTest", ioe);
		}

	}

}
