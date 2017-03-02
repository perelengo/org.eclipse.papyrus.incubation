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
package org.eclipse.papyrus.refactoring.tests.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.types.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.types.core.registries.ElementTypeConfigurationTypeRegistry;
import org.eclipse.papyrus.infra.types.core.registries.ElementTypeSetConfigurationRegistry;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.eclipse.papyrus.refactoring.core.AbstractPapyrusTransformation;
import org.eclipse.papyrus.uml.refactoring.mutation.helper.MutationTransformation;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.osgi.framework.Bundle;


/**
 * {@link TestCase} tests the Papyrus Refactoring Framework
 *
 */
public class AbstractPapyrusRefactoringTestCase extends AbstractPapyrusTest implements ITestConstants {

	@ClassRule
	public static HouseKeeper.Static mainProjectHouseKeeper = new HouseKeeper.Static();

	public static HouseKeeper.Static secondaryProjectHouseKeeper = new HouseKeeper.Static();

	public static IProgressMonitor monitor = new NullProgressMonitor();

	/** The main project */
	protected static IProject mainProject;

	/** The file of the first main project's model */
	protected static ModelSet mainPModelSet1;

	public static Model mainPModel1RootModel;

	public static IFile mainPModel1File;

	/** The file of the second main project's model */
	protected static ModelSet mainPModelSet2;

	public static Model mainPModel2RootModel;

	public static IFile mainPModel2File;

	/** The secondary project */
	protected static IProject secondaryProject;

	/** The file of the first secondary project's model */
	protected static ModelSet secondaryPModelSet1;

	public static Model secondaryPModel1RootModel;

	public static IFile secondaryPModel1File;

	/** The workspace root */
	protected static IWorkspaceRoot root;

	/** The papyrus editor linked to the opened papyrus model */
	protected static IMultiDiagramEditor openPapyrusEditor;

	/** The editing domain of the modelSet */
	static TransactionalEditingDomain editingDomain;

	/** The Element of the First model */
	public static org.eclipse.uml2.uml.Class basicClass;
	public static org.eclipse.uml2.uml.Class classWithProperty;
	public static org.eclipse.uml2.uml.Property pClassWP;
	public static org.eclipse.uml2.uml.Class associationSource;
	public static org.eclipse.uml2.uml.Class associationTarget;
	public static org.eclipse.uml2.uml.Association association;
	public static org.eclipse.uml2.uml.Package parentPackage;
	public static org.eclipse.uml2.uml.Package childPackage;
	public static org.eclipse.uml2.uml.Class generalizationSource;
	public static org.eclipse.uml2.uml.Property gsProperty;
	public static org.eclipse.uml2.uml.Property gsHiddenProperty;
	public static org.eclipse.uml2.uml.Component generalizationTarget;
	public static org.eclipse.uml2.uml.Generalization generalization;

	public static Map<String, IElementType> IETypesMap;

	/** The papyrus mutation transformation */
	public static AbstractPapyrusTransformation fPapyrusMutationTransformation;
	public static MutationTransformation mutationTransformation;


	@BeforeClass
	public static void initWorkspace() {
		// Used to store the main mutation model and a second replace model
		createMainProject();
		// Used to test the mutation behavior throughout the workspace
		// createSecondaryProject();

		// import test model and profile
		try {
			Bundle bundle = Platform.getBundle("org.eclipse.papyrus.refactoring.tests");
			mainPModel1File = PapyrusProjectUtils.copyPapyrusModel(mainProject, bundle, "/resources/", "mainPModel1");
			PapyrusProjectUtils.copyPapyrusModel(mainProject, bundle, "/resources/", "refactoringProfile.profile");
			// mainPModel2File = PapyrusProjectUtils.copyPapyrusModel(mainProject, bundle, "/resources/", "mainPModel2");
			// secondaryPModel1File = PapyrusProjectUtils.copyPapyrusModel(secondaryProject, bundle, "/resources/", "secondaryPModel1");
		} catch (CoreException ce) {
			Assert.fail(ce.getMessage());
		} catch (IOException ioe) {
			Assert.fail(ioe.getMessage());
		}

		// open project
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				try {
					openPapyrusEditor = mainProjectHouseKeeper.cleanUpLater(EditorUtils.openPapyrusEditor(mainPModel1File));
				} catch (PartInitException pie) {
					Assert.fail(pie.getMessage());
				}
			}
		});

		editingDomain = openPapyrusEditor.getAdapter(TransactionalEditingDomain.class);
		Assert.assertTrue("Impossible to init editing domain", editingDomain instanceof TransactionalEditingDomain);

		// retrieve UML model from this editor
		try {
			mainPModelSet1 = ModelUtils.getModelSetChecked(openPapyrusEditor.getServicesRegistry());
			UmlModel umlIModel = UmlUtils.getUmlModel(mainPModelSet1);
			mainPModel1RootModel = (Model) umlIModel.lookupRoot();

			Assert.assertNotNull("root model should not be null", mainPModel1RootModel);

		} catch (ServiceException se) {
			Assert.fail(se.getMessage());
		} catch (NotFoundException nfe) {
			Assert.fail(nfe.getMessage());
		} catch (ClassCastException cce) {
			Assert.fail(cce.getMessage());
		}
		try {
			initExistingElements();
			initIETypesMap();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	private static void initIETypesMap() {
		IETypesMap = new HashMap<>();

		IETypesMap.put("Model", ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Model"));
		IETypesMap.put("Package", ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Package"));
		IETypesMap.put("Class", ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Class"));
		IETypesMap.put("Interface", ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Interface"));
		IETypesMap.put("Component", ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Component"));
		IETypesMap.put("Artifact", ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Artifact"));
		IETypesMap.put("Property", ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Property"));
		IETypesMap.put("Association", ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Association"));
		IETypesMap.put("Generalization", ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Generalization"));

	}

	/**
	 * Init fields corresponding to element in the test model
	 */
	public static void initExistingElements() throws Exception {
		// A basic named Class
		PackageableElement pEClass = mainPModel1RootModel.getPackagedElement("basicClass");
		Assert.assertNotNull("basicClass" + " should not be null", pEClass);
		Assert.assertTrue("basicClass" + " should be a Class", pEClass instanceof org.eclipse.uml2.uml.Class);
		basicClass = (org.eclipse.uml2.uml.Class) pEClass;


		// A named Class containing a Property
		PackageableElement pEClassWP = mainPModel1RootModel.getPackagedElement("classWithProperty");
		Assert.assertNotNull("classWithProperty" + " should not be null", pEClassWP);
		Assert.assertTrue("classWithProperty" + " should be a Class", pEClassWP instanceof org.eclipse.uml2.uml.Class);
		classWithProperty = (org.eclipse.uml2.uml.Class) pEClassWP;

		pClassWP = classWithProperty.getAttribute("classProperty", UMLFactory.eINSTANCE.createProperty().getType());
		Assert.assertNotNull(classWithProperty.getQualifiedName() + "should contain a property", pClassWP);


		// Two named Classes linked by an Association
		PackageableElement pEClassASource = mainPModel1RootModel.getPackagedElement("associationSource");
		Assert.assertNotNull("associationSource" + " should not be null", pEClassASource);
		Assert.assertTrue("associationSource" + " should be a Class", pEClassASource instanceof org.eclipse.uml2.uml.Class);
		associationSource = (org.eclipse.uml2.uml.Class) pEClassASource;

		PackageableElement pEClassATarget = mainPModel1RootModel.getPackagedElement("associationTarget");
		Assert.assertNotNull("associationTarget" + " should not be null", pEClassATarget);
		Assert.assertTrue("associationTarget" + " should be a Class", pEClassATarget instanceof org.eclipse.uml2.uml.Class);
		associationTarget = (org.eclipse.uml2.uml.Class) pEClassATarget;


		PackageableElement pEAssociation = mainPModel1RootModel.getPackagedElement("Association");
		Assert.assertNotNull("Association" + " should not be null", pEAssociation);
		Assert.assertTrue("Association" + " should be an Association", pEAssociation instanceof org.eclipse.uml2.uml.Association);
		association = (org.eclipse.uml2.uml.Association) pEAssociation;

		List<Type> memeberEnds = new ArrayList<>();
		for (Property property : association.getMemberEnds()) {
			Type type = property.getType();
			memeberEnds.add(type);
		}
		Assert.assertTrue(association.getQualifiedName() + "should have " + associationSource.getQualifiedName() + " as a memberEnd",
				memeberEnds.contains(associationSource));
		Assert.assertTrue(association.getQualifiedName() + "should have " + associationTarget.getQualifiedName() + " as a memberEnd",
				memeberEnds.contains(associationTarget));


		// A named Package, containing another named Package,
		// containing named Component Generalized by a named Class, containing a Property colored in pink
		PackageableElement pEPackageParent = mainPModel1RootModel.getPackagedElement("parentPackage");
		Assert.assertNotNull("parentPackage" + " should not be null", pEPackageParent);
		Assert.assertTrue("parentPackage" + " should be a Package", pEPackageParent instanceof org.eclipse.uml2.uml.Package);
		parentPackage = (org.eclipse.uml2.uml.Package) pEPackageParent;

		PackageableElement pEPackageChild = parentPackage.getPackagedElement("childPackage");
		Assert.assertNotNull("childPackage" + " should not be null", pEPackageChild);
		Assert.assertTrue("childPackage" + " should be a Package", pEPackageChild instanceof org.eclipse.uml2.uml.Package);
		childPackage = (org.eclipse.uml2.uml.Package) pEPackageChild;

		PackageableElement pEPackageCWP = childPackage.getPackagedElement("generalizationSource");
		Assert.assertNotNull("generalizationSource" + " should not be null", pEPackageCWP);
		Assert.assertTrue("generalizationSource" + " should be a Class", pEPackageCWP instanceof org.eclipse.uml2.uml.Class);
		generalizationSource = (org.eclipse.uml2.uml.Class) pEPackageCWP;

		gsProperty = generalizationSource.getAttribute("generalizationSourceProperty", UMLFactory.eINSTANCE.createProperty().getType());
		Assert.assertNotNull(generalizationSource.getQualifiedName() + "should contain a displayed property", gsProperty);
		gsHiddenProperty = generalizationSource.getAttribute("generalizationSourceHiddenProperty", UMLFactory.eINSTANCE.createProperty().getType());
		Assert.assertNotNull(generalizationSource.getQualifiedName() + "should contain a hidden property", gsHiddenProperty);

		PackageableElement pEPackageCp = childPackage.getPackagedElement("generalizationTarget");
		Assert.assertNotNull("generalizationTarget" + " should not be null", pEPackageCp);
		Assert.assertTrue("generalizationTarget" + " should be a Component", pEPackageCp instanceof org.eclipse.uml2.uml.Component);
		generalizationTarget = (org.eclipse.uml2.uml.Component) pEPackageCp;

		generalization = generalizationSource.getGeneralization(generalizationTarget);
		Assert.assertNotNull("Generalization" + " should not be null", generalization);

	}


	public static void createMainProject() {
		mainProject = mainProjectHouseKeeper.createProject(MAINP_NAME);
		// The root will be the same for both projects as they will share the same workspace
		root = mainProject.getWorkspace().getRoot();
	}

	public static void createSecondaryProject() {
		secondaryProject = secondaryProjectHouseKeeper.createProject(SECONDARYP_NAME);
	}


	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void test() {
		Assert.assertTrue(true);
	}

}
