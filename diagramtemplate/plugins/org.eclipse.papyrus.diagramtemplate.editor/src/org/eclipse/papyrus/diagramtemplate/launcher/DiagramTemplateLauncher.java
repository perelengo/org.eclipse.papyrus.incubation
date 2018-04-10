/*****************************************************************************
 * Copyright (c) 2010, 2018 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Florian Noyrit florian.noyrit@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagramtemplate.launcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.commands.CreationCommandRegistry;
import org.eclipse.papyrus.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.diagramtemplate.AbstractSelection;
import org.eclipse.papyrus.diagramtemplate.DiagramDefinition;
import org.eclipse.papyrus.diagramtemplate.Selection;
import org.eclipse.papyrus.diagramtemplate.SelectionKind;
import org.eclipse.papyrus.diagramtemplate.Template;
import org.eclipse.papyrus.diagramtemplate.editor.Activator;
import org.eclipse.papyrus.diagramtemplate.editor.commands.OpenDiagramsCommand;
import org.eclipse.papyrus.diagramtemplate.editor.commands.PopulateDiagramCommand;
import org.eclipse.papyrus.diagramtemplate.editor.messages.Messages;
import org.eclipse.papyrus.diagramtemplate.utils.CreationReport;
import org.eclipse.papyrus.diagramtemplate.utils.CreationReport.CreationReportKind;
import org.eclipse.papyrus.diagramtemplate.utils.DiagramUtils;
import org.eclipse.papyrus.diagramtemplate.utils.FindSelectionInModel;
import org.eclipse.papyrus.diagramtemplate.utils.ModelSetUtils;
import org.eclipse.papyrus.diagramtemplate.utils.ModelUtils;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.NamedElement;



/**
 * The template launcher class
 *
 */
public class DiagramTemplateLauncher {

	/**
	 * The instance used for the singleton pattern
	 */
	private static DiagramTemplateLauncher instance = null;

	/**
	 * The creation report information
	 */
	// protected HashMap<EObject, CreationReportKind> creationReport;

	/**
	 * The diagram added in the first part of the execution
	 */
	protected HashMap<Diagram, AbstractSelection> createdDiagrams;

	/**
	 * The Handled ModelSet
	 */
	protected ModelSet modelSet;

	/**
	 * Used to store the list of diagrams already present in the resource
	 */
	protected List<Diagram> existingDiagrams;

	/**
	 * Constructor.
	 * Private constructor for the singleton pattern
	 */
	private DiagramTemplateLauncher() {
	}

	/**
	 * Get the singleton
	 *
	 * @return
	 * 		the DiagramTemplateLauncher singleton
	 */
	public final synchronized static DiagramTemplateLauncher getInstance() {
		if (instance == null) {
			instance = new DiagramTemplateLauncher();
		}
		return instance;
	}


	/**
	 * Gets the creation command registry.
	 *
	 * @return the creation command registry
	 */
	private ICreationCommandRegistry getCreationCommandRegistry() {
		return CreationCommandRegistry.getInstance(org.eclipse.papyrus.infra.ui.Activator.PLUGIN_ID);
	}

	public Object[] getCommands(Object inputElement) {
		if (inputElement instanceof List) {
			List<ViewPrototype> categories = (List<ViewPrototype>) inputElement;

			List<CreationCommandDescriptor> result = new ArrayList<>();
			for (CreationCommandDescriptor desc : getCreationCommandRegistry().getCommandDescriptors()) {
				for (ViewPrototype category : categories) {
					if (category.getLabel().equalsIgnoreCase(desc.getLabel())) {
						result.add(desc);
						break;
					}
				}
			}

			return result.toArray();
		}
		return null;
	}

	/**
	 * Util method to get the CreationCommandDescriptor corresponding to a commandID
	 *
	 * @param commandID
	 *            the commandID to find
	 * @return
	 * 		the corresponding CreationCommandDescriptor
	 */
	protected CreationCommandDescriptor getCreation(String commandID) {
		// List<Object> diagramsKindlist = Arrays.asList(getCommands(ModelSetUtils.getInstance().getRepresentationKinds()));
		List<Object> diagramsKindlist = Arrays.asList(getCommands(ModelSetUtils.getRepresentationKinds()));

		for (Object object : diagramsKindlist) {
			CreationCommandDescriptor command = (CreationCommandDescriptor) object;

			if (command.getCommandId().equals(commandID)) {
				return command;
			}
		}

		return null;
	}




	/**
	 * Creates the diagrams in a specified Papyrus resource
	 *
	 * @param selectionList
	 *            The selection for which we must create diagrams corresponding to the diagram definition
	 * @param diagramDefinition
	 *            The diagram definition to create
	 * @param diResourceSet
	 *            The Papyrus resource to create the diagrams in
	 */
	protected void createDiagramFor(List<?> selectionList, DiagramDefinition diagramDefinition, ModelSet modelSet) {
		// Go through the selection and try to find elements in the target model that match
		for (Object object : selectionList) {

			if (!(object instanceof AbstractSelection)) {
				continue;
			}

			AbstractSelection selection = (AbstractSelection) object;
			CreationCommandDescriptor creationCommandDescriptor = getCreation(diagramDefinition.getDiagramKind());
			if (null == creationCommandDescriptor) {
				return;
			}

			EObject root;
			// If the template is under specified, try to guess
			if (null == diagramDefinition.getFromRoot()) {
				root = ((Template) diagramDefinition.eContainer()).getTargetRoot();
			} else {
				root = diagramDefinition.getFromRoot();
			}

			if (null == root) {
				return;
			}

			if (selection.getKind() == SelectionKind.FOR_ALL) {

				// Find elements that match
				List<EObject> content = new ArrayList<>();
				if (selection instanceof Selection) {
					if (((Selection) selection).isRecursively()) {
						// Go through all recursively
						// FIXME This will go through the dummy/reference ModelSet inside the template
						// As this ModelSet is not initialized the graphical executions will fail
						// This reference needs to be changed and point directly to the original ModelSet
						TreeIterator<EObject> it = root.eAllContents();
						while (it.hasNext()) {
							// EObject eObject = it.next();
							// EObject eObject = FindSelectionInModel.getInstance().findSelectionInModel(modelSet, it.next());
							EObject eObject = FindSelectionInModel.findSelectionInModel(modelSet, it.next());
							content.add(eObject);
						}
					} else {
						// content.addAll(root.eContents());
						for (Iterator<EObject> it = root.eContents().iterator(); it.hasNext();) {
							// EObject eObject = FindSelectionInModel.getInstance().findSelectionInModel(modelSet, it.next());
							EObject eObject = FindSelectionInModel.findSelectionInModel(modelSet, it.next());
							content.add(eObject);
						}
					}
					// content.add(root);
					// EObject eObject = FindSelectionInModel.getInstance().findSelectionInModel(modelSet, root);
					EObject eObject = FindSelectionInModel.findSelectionInModel(modelSet, root);
					content.add(eObject);
				} else {
					MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(), Messages.DiagramTemplateLauncher_3, Messages.DiagramTemplateLauncher_4);
				}


				for (EObject eObject : content) {
					// if (!(ModelUtils.getInstance().matchStereotypedBy(eObject, selection.getStereotypedBy()))) {
					if (!(ModelUtils.matchStereotypedBy(eObject, selection.getStereotypedBy()))) {
						continue;
					}

					String name = diagramDefinition.getPrefix();
					if (eObject instanceof NamedElement) {
						name += ((NamedElement) eObject).getName();
					} else {
						name += eObject.toString();
					}


					if (selection.isSubTypes()) {
						// Consider all subtypes
						if (eObject.eClass().getEAllSuperTypes().contains(selection.getElement()) || eObject.eClass() == selection.getElement()) {
							// System.err.println("FoundForAll Sub: " + diagramDefinition.getName());
							// It matches: create a diagram
							try {
								creationCommandDescriptor.getCommand().createDiagram(modelSet, eObject, name);

								// Identify the new diagram
								TreeIterator<EObject> it = NotationUtils.getNotationResource(modelSet).getAllContents();
								while (it.hasNext()) {
									EObject diagram = it.next();
									if (diagram instanceof Diagram) {
										if (!existingDiagrams.contains(diagram)) {
											createdDiagrams.put((Diagram) diagram, selection);
											existingDiagrams.add((Diagram) diagram);

											CreationReport.getInstance().addToReport(eObject, CreationReportKind.SUCCESS);
										}
									}
								}

							} catch (BackboneException e) {
								Activator.log.error(e);
							}
						}
					} else {
						if (eObject.eClass() == selection.getElement()) {
							// System.err.println("FoundForAll Strict: " + diagramDefinition.getName());
							// It matches: create a diagram

							try {
								creationCommandDescriptor.getCommand().createDiagram(modelSet, eObject, name);

								// Identify the new diagram
								TreeIterator<EObject> it = NotationUtils.getNotationResource(modelSet).getAllContents();
								while (it.hasNext()) {
									EObject diagram = it.next();
									if (diagram instanceof Diagram) {
										if (!existingDiagrams.contains(diagram)) {
											createdDiagrams.put((Diagram) diagram, selection);
											existingDiagrams.add((Diagram) diagram);

											CreationReport.getInstance().addToReport(eObject, CreationReportKind.SUCCESS);
										}
									}
								}

							} catch (BackboneException e) {
								Activator.log.error(e);
							}
						}
					}
				}
			}

			else if (selection.getKind() == SelectionKind.SPECIFIC) {

				// System.err.println("FoundSpecific");
				String name = diagramDefinition.getPrefix();
				if (selection.getElement() instanceof NamedElement) {
					name += ((NamedElement) selection.getElement()).getName();
				} else {
					name += selection.getElement().toString();
				}

				try {
					// EObject matchingModelSelection = FindSelectionInModel.getInstance().findSelectionInModel(modelSet, selection);
					EObject matchingModelSelection = FindSelectionInModel.findSelectionInModel(modelSet, selection);
					// creationCommandDescriptor.getCommand().createDiagram(modelSet, selection.getElement(), name);
					if (null == matchingModelSelection) {
						// We could not find an element matching the selection - FIXME
						return;
					}
					creationCommandDescriptor.getCommand().createDiagram(modelSet, matchingModelSelection, name);

					// Identify the new diagram
					Resource notationResource = NotationUtils.getNotationResource(modelSet);
					TreeIterator<EObject> it = notationResource.getAllContents();
					while (it.hasNext()) {
						EObject diagram = it.next();
						if (!(diagram instanceof Diagram)) {
							continue;
						}

						if (!existingDiagrams.contains(diagram)) {
							createdDiagrams.put((Diagram) diagram, selection);
							existingDiagrams.add((Diagram) diagram);

							CreationReport.getInstance().addToReport(selection.getElement(), CreationReportKind.SUCCESS);
						}
					}
				} catch (BackboneException e) {
					Activator.log.error(e);
				}
			}
		}
	}




	/**
	 * This is the main method for the template launcher. Executes the template
	 *
	 * @param template
	 *            The template to execute
	 */
	public void execute(Template template) {

		existingDiagrams = new ArrayList<>();
		createdDiagrams = new HashMap<>();

		if (null == template) {
			return;
		}
		// modelSet = ModelSetUtils.getInstance().getAssociatedModelSet(template);
		modelSet = ModelSetUtils.getAssociatedModelSet(template);

		if (null == template.getTargetRoot().eResource()) {
			return;
		}

		// Identify already available diagrams
		Resource notationResource = NotationUtils.getNotationResource(modelSet);
		if (null == notationResource) {
			MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(), Messages.DiagramTemplateLauncher_6, Messages.DiagramTemplateLauncher_7);
			return;
		}

		// Identify the existing diagrams so as to not use them for the upcoming populate action
		TreeIterator<EObject> it = notationResource.getAllContents();
		while (it.hasNext()) {
			EObject diagram = it.next();
			if (diagram instanceof Diagram) {
				// exitingDiagrams.add(diagram.eResource().getURIFragment(diagram));
				existingDiagrams.add((Diagram) diagram);
			}
		}

		TransactionalEditingDomain modelSetEditingDomain = modelSet.getTransactionalEditingDomain();

		RecordingCommand executeTemplateCommand = new RecordingCommand(modelSetEditingDomain, "TemplateExecution") {

			@Override
			protected void doExecute() {
				// TODO Auto-generated method stub


				// Create diagrams that match the template
				if (!template.getDiagramDefinitions().isEmpty()) {
					for (DiagramDefinition diagramDefinition : template.getDiagramDefinitions()) {
						createDiagramFor(diagramDefinition.getSelection(), diagramDefinition, modelSet);
					}
				} else {
					// Create empty diagrams
					// EditorUtils.getTransactionalIPageMngr(DiModelUtils.getDiResource(modelSet), modelSet.getTransactionalEditingDomain());
				}

				// IMultiDiagramEditor editor = ModelSetUtils.getInstance().getAssociatedPapyrusEditor(template);
				IMultiDiagramEditor editor = ModelSetUtils.getAssociatedPapyrusEditor(template);

				if (editor != null) {

					// FIXME Move this inside a single recording command
					try {

						final ServicesRegistry services = editor.getServicesRegistry();
						final TransactionalEditingDomain editingDomain = services.getService(TransactionalEditingDomain.class);

						IPageManager pageManager = services.getService(IPageManager.class);

						// Go through the diagrams available in the resource
						for (final Object pageDiagram : pageManager.allPages()) {

							if (!(pageDiagram instanceof Diagram)) {
								continue;
							}

							if (!(createdDiagrams.containsKey(pageDiagram))) {
								continue;
							}

							// We need to open the diagram to retrieve its editpart and drop the elements in it
							// org.eclipse.emf.common.command.Command openCreatedPagesCommand = new OpenDiagramsCommand(editingDomain, "Open created diagrams", createdDiagrams.keySet());
							org.eclipse.emf.common.command.Command openCreatedPagesCommand = new OpenDiagramsCommand(editingDomain, "Open created diagrams", (Diagram) pageDiagram);
							openCreatedPagesCommand.execute();

							final IEditorPart activePart = editor.getActiveEditor();
							// System.out.println(activePart);
							DiagramEditor diagramEditor = activePart.getAdapter(DiagramEditor.class);
							if (null == diagramEditor) {
								continue;
							}

							// Get the GraphicalViewer for this diagram
							final Object viewer = activePart.getAdapter(GraphicalViewer.class);
							if (null == viewer) {
								continue;
							}

							org.eclipse.emf.common.command.Command populateCreatedPagesCommand = new PopulateDiagramCommand(editingDomain, "Populate created pages", createdDiagrams.get(pageDiagram), diagramEditor);
							populateCreatedPagesCommand.execute();

							// Arrange all recursively
							DiagramUtils.arrangeRecursively(diagramEditor.getDiagramEditPart());
							// DiagramUtils.arrangeAll(diagramEditor.getDiagramEditPart());
						}

					} catch (ServiceException e) {
						Activator.log.error(e);
					}
				}
			}
		};

		modelSetEditingDomain.getCommandStack().execute(executeTemplateCommand);

		// Report
		DiagramTemplateLauncherReport.getInstance().showReport(CreationReport.getInstance().getReport());

		// Reset stored informations
		CreationReport.getInstance().clear();
	}

}
