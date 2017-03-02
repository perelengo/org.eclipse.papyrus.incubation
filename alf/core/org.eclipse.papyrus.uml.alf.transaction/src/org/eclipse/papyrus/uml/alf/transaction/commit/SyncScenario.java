/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Tatibouet (CEA LIST)
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.transaction.commit;

import static org.eclipse.papyrus.uml.alf.transaction.ActivatorTransaction.logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.compare.CompareUI;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.uml.alf.text.merge.manual.AlfCompareEditor;
import org.eclipse.papyrus.uml.alf.text.merge.manual.MergeActionDialog;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;
import org.eclipse.papyrus.uml.alf.transaction.commands.AlfCommandFactory;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.UMLPackage;

public class SyncScenario extends Scenario implements ISyncScenario {

	/**
	 * The model state that is taken as reference to perform the synchronization
	 */
	protected AlfTextualRepresentation modelStateToBeCommitted;

	public SyncScenario() {
		super();
		this.modelStateToBeCommitted = null;
	}

	/**
	 * Checks required before to perform a synchronization
	 */
	public void before() {
		/* 1. It means the user model has not been saved in the current model */
		if (this.userModelState.isSaved()) {
			/* 1.1. The two models diverge */
			if (this.userModelState.isDifferent(this.currentModelState)) {
				MergeActionDialog mergeActionDialog = new MergeActionDialog(Display.getCurrent().getActiveShell(), this.currentModelState.getOwner());
				/* 1.1.1. The user has to choose what to do */
				if (mergeActionDialog.open() == Window.OK) {
					if (mergeActionDialog.getReturnCode() == MergeActionDialog.REBASE) {
						this.userModelState.rebase(this.currentModelState);
						this.modelStateToBeCommitted = this.userModelState;
					} else if (mergeActionDialog.getReturnCode() == MergeActionDialog.MERGE) {
						CompareUI.openCompareDialog(new AlfCompareEditor(this.userModelState, this.currentModelState));
					} else {
						this.currentModelState.reconcile(this.userModelState);
						this.currentModelState.setSource(this.userModelState.getSource());
						this.modelStateToBeCommitted = this.currentModelState;
					}
				}
			} else {
				this.modelStateToBeCommitted = this.userModelState.rebase(this.currentModelState);
			}
		} else {
			this.modelStateToBeCommitted = this.userModelState.rebase(this.currentModelState);
		}
	}

	public Command synchronize(HashMap<Element, List<Notification>> changes) {
		CompoundCommand compoundCommand = new CompoundCommand("synchronize");
		for (NamedElement affectedElement : this.getSynchronizationPoints(changes)) {
			compoundCommand.append(this._synchronize(affectedElement));
		}
		return compoundCommand;
	}

	/**
	 * Compute the set of element that need to have their serialization updated
	 * 
	 * @param changes
	 * 		  the list of changes per UML element
	 * 
	 * @return syncPoints
	 * 		   the list of UML elements that will have their serialization updated
	 */
	protected Set<NamedElement> getSynchronizationPoints(HashMap<Element, List<Notification>> changes) {
		Set<NamedElement> syncPoints = new HashSet<NamedElement>();
		/*1. Take out changes that cannot be handled*/
		this.preFilter(changes);
		/*2. Compute synchronization targets according to changes*/
		for (Element target : changes.keySet()) {
			//logger.info("[MODIFIED] "+ target.toString());
			if(target instanceof PackageImport ||target instanceof ElementImport){
				syncPoints.addAll(this.getUpdateTargets(target, changes.get(target)));
			}else if(target instanceof Association){
				syncPoints.addAll(this.getUpdateTargets((Association) target, changes.get(target)));
			}else if (target instanceof Generalization){
				syncPoints.addAll(this.getUpdateTargets((Generalization) target, changes.get(target)));
			}else if (target instanceof Package) {
				syncPoints.addAll(this.getUpdateTargets((Package) target, changes.get(target)));
			} else if (target instanceof Classifier) {
				syncPoints.addAll(this.getUpdateTargets((Classifier) target, changes.get(target)));
			} else if (target instanceof Feature) {
				syncPoints.addAll(this.getUpdateTargets((Feature) target, changes.get(target)));
			} else if(target instanceof EnumerationLiteral){
				syncPoints.addAll(this.getUpdateTargets((EnumerationLiteral) target, changes.get(target)));
			}
		}
		/*for (NamedElement element : syncPoints) {
			logger.info("[UPADTED] " + element);
		}*/
		return syncPoints;
	}

	/**
	 * Takes out from a map of changes those that cannot be computed by synchronization engine
	 * 
	 * @param changes
	 * 		  the list of notifications per modified object
	 */
	private void preFilter(HashMap<Element, List<Notification>> changes){
		for(Element element : changes.keySet()){
			Iterator<Notification> iterator =  changes.get(element).iterator();
			while(iterator.hasNext()){
				Notification notification = iterator.next();
				if(!this.isWorkable(notification)){
					iterator.remove();
				}
			}
		}
	}
	
	/**
	 * Determine if an ADD notification can be used by the synchronizer or not.
	 * Typically such notification can be used if the new value has a name.
	 * 
	 * NOTE: necessity of this check was introduced by the arrival of notification
	 * for which created values (newValue) had no name. 
	 * 
	 * @return true if the notification can be used false otherwise
	 */
	private boolean isWorkable(Notification notification){
		boolean isWorkable = true; 
		if(notification.getNewValue()!=null && notification.getEventType()==Notification.ADD){
			if(notification.getNewValue() instanceof NamedElement){
				isWorkable = ((NamedElement)notification.getNewValue()).getName() != null;
			}
		}
		return isWorkable;
	}
	
	/**
	 * Get the set of elements that are intended to have their serialization updated
	 * 
	 * @param element
	 * 		  the given element can only be an element import or a package import
	 * 
	 * @param changes
	 * 		  the list of changes having affected the given element
	 * 
	 * @return targets
	 * 		   the of elements that need to have their serialization updated due to the changes
	 */
	protected Set<NamedElement> getUpdateTargets(Element element, List<Notification> changes) {
		assert (element instanceof ElementImport || element instanceof PackageImport) : "element can only be an element import or a package import";
		Set<NamedElement> targets = new HashSet<NamedElement>();;
		Iterator<Notification> changesIterator = changes.iterator();
		while (changesIterator.hasNext()) {
			Notification notification = changesIterator.next();
			switch(notification.getEventType()){
			case Notification.SET:{
				EStructuralFeature feature = (EStructuralFeature) notification.getFeature();
				if(feature == UMLPackage.eINSTANCE.getElementImport_ImportingNamespace()
						|| feature == UMLPackage.eINSTANCE.getElementImport_ImportingNamespace()){
					/*The old importing namespace has to be updated*/
					if(notification.getNewValue()==null){
						targets.addAll(this.getParentPath((Element)notification.getOldValue()));
					}else{ /*The new importing namespace has to be updated*/
						targets.addAll(this.getParentPath((Element)notification.getNewValue()));
					}
				}else{
					if(feature == UMLPackage.eINSTANCE.getPackageImport_ImportedPackage()){
						if(element.getModel() != ((PackageImport)element).getImportingNamespace()){
							targets.addAll(this.getParentPath(element.getOwner()));
						}
					}else{
						targets.addAll(this.getParentPath(element.getOwner()));
					}
				}
			}break;
			}
		}
		return targets;
	}
	
	/**
	 * Get the set of elements that are intended to have their serialization updated
	 * 
	 * @param generalization
	 * 		  a generalization relationship that exists between two classifier
	 * 
	 * @param changes
	 * 		  the list of changes having affected the given element
	 * 
	 * @return targets
	 * 		    the of elements that need to have their serialization updated due to the changes
	 */
	protected Set<NamedElement> getUpdateTargets(Generalization generalization, List<Notification> changes) {
		Set<NamedElement> targets = new HashSet<NamedElement>();
		Iterator<Notification> changesIterator = changes.iterator();
		while (changesIterator.hasNext()) {
			Notification notification = changesIterator.next();
			switch(notification.getEventType()){
			case Notification.SET:{
				if(notification.getFeature()==UMLPackage.eINSTANCE.getGeneralization_General()){
					targets.addAll(this.getParentPath(generalization.getSpecific()));
				}else if (notification.getFeature()==UMLPackage.eINSTANCE.getGeneralization_Specific()){
					targets.addAll(this.getParentPath((Element)notification.getOldValue()));
					targets.addAll(this.getParentPath((Element)notification.getNewValue()));
				}
			}
			break;
			}
		}
		return targets;
	}
	
	/**
	 * Get the set of elements that are intended to have their serialization updated
	 * 
	 * @param element
	 *            the package that was modified
	 * 
	 * @param changes
	 *            the list of changes describing updates applied on this package
	 * 
	 * @return targets
	 *         the set of element to update
	 */
	protected Set<NamedElement> getUpdateTargets(Package element, List<Notification> changes) {
		Set<NamedElement> targets = new HashSet<NamedElement>();
		Iterator<Notification> changesIterator = changes.iterator();
		while (changesIterator.hasNext()) {
			Notification notification = changesIterator.next();
			switch (notification.getEventType()) {
			case Notification.ADD: {
				if (notification.getFeature() == UMLPackage.eINSTANCE.getPackage_PackagedElement()) {
					targets.addAll(this.getUpdateTarget((NamedElement) notification.getNewValue()));
				}
			}
				break;
			case Notification.REMOVE: {
				EStructuralFeature feature = (EStructuralFeature)notification.getFeature(); 
				if (feature == UMLPackage.eINSTANCE.getPackage_PackagedElement()) {
					NamedElement oldValue = (NamedElement) notification.getOldValue();
					if (oldValue.getModel() != null) {
						targets.addAll(this.getUpdateTarget((NamedElement) notification.getOldValue()));
					}
				}else if(feature == UMLPackage.eINSTANCE.getNamespace_PackageImport()
						|| feature == UMLPackage.eINSTANCE.getNamespace_ElementImport()){
					targets.addAll(this.getParentPath(element));
				}
			}
				break;
			}
		}
		targets.addAll(this.getUpdateTarget(element));
		return targets;
	}

	/**
	 * Retrieve the set of elements that need to be updated afterwards that the given target was modified
	 * 
	 * @param target
	 *            the source element
	 * 
	 * @return targets
	 *         the set of elements to update
	 */
	protected Set<NamedElement> getUpdateTarget(Element target) {
		Set<NamedElement> targets = new HashSet<NamedElement>();
		targets.addAll(this.getParentPath(target));
		targets.addAll(this.getChildren(target));
		return targets;
	}

	/**
	 * Find out from a given element the set of children that need to be updated
	 * 
	 * @param root
	 * 
	 * @return
	 */
	private Set<NamedElement> getChildren(Element root) {
		Set<NamedElement> children = new HashSet<NamedElement>();
		for (Element element : root.getOwnedElements()) {
			if (element instanceof Package
					|| element instanceof Class) {
				children.add((NamedElement) element);
				children.addAll(this.getChildren(element));
			} else if (element instanceof Enumeration) {
				children.add((NamedElement) element);
			} else if (element instanceof DataType) {
				children.add((NamedElement) element);
			} else if (element instanceof Signal) {
				children.add((NamedElement) element);
			} else if (element instanceof Association) {
				children.add((NamedElement) element);
			}
		}
		return children;
	}

	/**
	 * Rewind the parent of the target until the top level package or class
	 * 
	 * @param target
	 *            the starting point of the of the search
	 * 
	 * @return the list of elements that need to be traversed to reach the top level element
	 */
	private Set<NamedElement> getParentPath(Element target) {
		Set<NamedElement> targets = new HashSet<NamedElement>();
		Element owner = target.getOwner();
		if (owner == null || owner instanceof Model) {
			targets.add((NamedElement) target);
			return targets;
		} else if (owner instanceof Class || owner instanceof Package || owner instanceof Enumeration) {
			targets.addAll(this.getParentPath(owner));
			if(!(target instanceof Property)){
				targets.add((NamedElement) target);
			}
			return targets;
		} else {
			return targets;
		}
	}

	/**
	 * Retrieve all target that need to be updated when a class is modified (e.g. by the adding of a nested classifier)
	 * 
	 * @param classifier
	 *            the class that was modified
	 * 
	 * @param changes
	 *            the list of changes registered for this class
	 * 
	 * @return targets
	 *         the list of targets
	 */
	protected Set<NamedElement> getUpdateTargets(Classifier classifier, List<Notification> changes) {
		Set<NamedElement> targets = new HashSet<NamedElement>();
		Iterator<Notification> changesIterator = changes.iterator();
		while (changesIterator.hasNext()) {
			Notification notification = changesIterator.next();
			switch (notification.getEventType()) {

				/*
				 * 1. if a nested classifier is added, it means parents of the currently modified
				 * element must be synchronized as well as its children. Otherwise (e.g. when a property is added)
				 * only the parents are synchronized.
				 */
			case Notification.ADD: {
				if (notification.getFeature() == UMLPackage.eINSTANCE.getClass_NestedClassifier()) {
					targets.addAll(this.getUpdateTarget((Element) notification.getNewValue()));
				} else {
					if(notification.getNewValue() instanceof EnumerationLiteral){
						Enumeration owner = ((EnumerationLiteral) notification.getNewValue()).getClassifier();
						if(owner!=null){
							targets.addAll(this.getParentPath(owner));
						}
					}else if(notification.getNewValue() instanceof Generalization
							|| notification.getNewValue() instanceof ElementImport){
						targets.addAll(this.getParentPath(classifier));
					}else{
						targets.addAll(this.getParentPath((Element) notification.getNewValue()));
					}
				}
			}
				break;

			/*
			 * 2. if an element is removed from the class then only parents need to be synchronized
			 */
			case Notification.REMOVE: {
				EStructuralFeature feature = (EStructuralFeature) notification.getFeature();
				if(feature == UMLPackage.eINSTANCE.getClassifier_Generalization()
						|| feature == UMLPackage.eINSTANCE.getNamespace_ElementImport()){
					targets.addAll(this.getParentPath(classifier));
				}else{
					NamedElement oldValue = (NamedElement) notification.getOldValue();
					if (oldValue != null) {
						targets.addAll(this.getParentPath(classifier));
					}
				}
			}
				break;
			/*
			 * 3. When a property of the class (e.g. its name) is modified then both parents and children
			 * of the currently modified element need to be synchronized
			 */
			case Notification.SET: {
				targets.addAll(this.getUpdateTarget(classifier));
			}
				break;
			}
		}
		return targets;
	}

	/**
	 * Retrieve all target that need to be updated when a Feature (e.g. property, operation, reception) is modified
	 * 
	 * @param property
	 *            the property currently modified
	 * 
	 * @param changes
	 *            the list of changes registered for this property
	 * 
	 * @return target
	 *         the set of elements that need to be updated
	 */
	protected Set<NamedElement> getUpdateTargets(Feature feature, List<Notification> changes) {
		Set<NamedElement> targets = new HashSet<NamedElement>();
		Iterator<Notification> changesIterator = changes.iterator();
		while (changesIterator.hasNext()) {
			Notification notification = changesIterator.next();
			switch (notification.getEventType()) {
			case Notification.SET: {
				targets.addAll(this.getParentPath(feature.getOwner()));
			}
				break;
			case Notification.REMOVE:{
				if(notification.getFeature() == UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter()){
					targets.addAll(this.getParentPath(feature.getOwner()));
				}
			}
				break;
			case Notification.ADD_MANY:{
				if(notification.getFeature() == UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter()){
					targets.addAll(this.getParentPath(feature.getOwner()));
				}
			}
				break;
			}
		}
		return targets;
	}

	protected Set<NamedElement> getUpdateTargets(EnumerationLiteral enumerationLiteral, List<Notification> changes) {
		Set<NamedElement> targets = new HashSet<NamedElement>();
		Iterator<Notification> changesIterator = changes.iterator();
		while (changesIterator.hasNext()) {
			Notification notification = changesIterator.next();
			switch (notification.getEventType()) {
			case Notification.SET: {
				targets.addAll(this.getParentPath(enumerationLiteral.getOwner()));
			}
				break;
			}
		}
		return targets;
	}


	/**
	 * Provide a synchronization command for the given target
	 * 
	 * @param target
	 *            - the model element on which textual specification must be aligned
	 * @return command - a command to synchronize the model element and the text
	 */
	protected Command _synchronize(NamedElement target) {
		/* 1. Load the target states */
		this.init(target);
		/* 2. Do before checks */
		this.before();
		/* 3. Provide save command */
		return AlfCommandFactory.getInstance().creatSaveCommand(this.modelStateToBeCommitted);
	}

	public void after() {
		logger.info("Synchronization Done");
	}
}
