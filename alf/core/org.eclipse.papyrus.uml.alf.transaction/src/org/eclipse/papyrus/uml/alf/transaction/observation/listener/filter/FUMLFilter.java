/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Jeremie Tatibouet (CEA LIST)
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.transaction.observation.listener.filter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

public class FUMLFilter extends NotificationFilter.Custom {

	public FUMLFilter() {
	}

	/**
	 * Filter starting point
	 */
	public boolean matches(Notification notification) {
		Object notifier = notification.getNotifier();
		if (!this.isNotifierAllowed(notifier)) {
			return false;
		}
		Object feature = notification.getFeature();
		if (notifier != null && feature != null) {
			if (FUMLScopeUtil.isEnumeration(notifier)) {
				return this.isEnumerationFeatureListened((EStructuralFeature) feature);
			} else if (FUMLScopeUtil.isDataType(notifier)) {
				return this.isDatatypeFeatureListened((EStructuralFeature) feature);
			} else if (FUMLScopeUtil.isPackage(notifier)) {
				return this.isPackageFeatureListened((EStructuralFeature) feature);
			}/* else if (this.isAssociation(notifier)) {
				return this.isAssociationFeatureListener((EStructuralFeature) feature);
			}*/ else if (FUMLScopeUtil.isSignal(notifier)) {
				return this.isSignalFeatureListened((EStructuralFeature) feature);
			} else if (FUMLScopeUtil.isClass(notifier)) {
				return this.isClassFeatureListened((EStructuralFeature) feature);
			} else if (FUMLScopeUtil.isGeneralization(notifier)) {
				return this.isGeneralizationtFeatureListened((EStructuralFeature) feature);
			}else if(FUMLScopeUtil.isProperty(notifier)){
				return this.isPropertyFeatureListened((EStructuralFeature)feature);
			}else if(FUMLScopeUtil.isOperation(notifier)){
				return this.isOperationFeatureListened((EStructuralFeature)feature);
			}else if(FUMLScopeUtil.isReception(notifier)){
				return this.isReceptionFeatureListened((EStructuralFeature)feature);
			}else if(FUMLScopeUtil.isLiteralUnlimitedNatural(notifier)){
				return this.isLiteralUnlimitedNaturalFeatureListened((EStructuralFeature)feature);
			}else if(FUMLScopeUtil.isEnumerationLiteral(notifier)){
				return this.isEnumerationLiteralFeatureListened((EStructuralFeature)feature);
			}else if(FUMLScopeUtil.isPackageImport(notifier)){
				return this.isPackageImportFeatureListened((EStructuralFeature)feature);
			}else if(FUMLScopeUtil.isElementImport(notifier)){
				return this.isElementImportFeatureListened((EStructuralFeature)feature);
			}
		}
		return false;
	}

	private boolean isNotifierAllowed(Object notifier) {
		boolean allowed = false;
		if (notifier instanceof Element) {
			EObject target = (EObject) notifier;
			if (target.eResource() != null && target.eResource() instanceof UMLResource) {
				allowed = target.eResource().isTrackingModification();
			}
		}
		return allowed;
	}
	
	/*----------------------------------------------------------------------------*/
	/* Low level checks encoding the UML meta-model hierarchy */
	/*----------------------------------------------------------------------------*/

	private boolean isGeneralizationtFeatureListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getGeneralization_General() == feature
				|| UMLPackage.eINSTANCE.getGeneralization_Specific() == feature) {
			return true;
		}
		return false;
	}

	private boolean isNamedElementFeatureListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getNamedElement_Name() == feature
				|| UMLPackage.eINSTANCE.getNamedElement_QualifiedName() == feature
				|| UMLPackage.eINSTANCE.getNamedElement_Namespace() == feature
				|| UMLPackage.eINSTANCE.getNamedElement_Visibility() == feature
				|| UMLPackage.eINSTANCE.getNamedElement_Namespace() == feature) {
			return true;
		}
		return false;
	}

	private boolean isTypeFeatureListened(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getType_Package() == feature || this.isPackageableElementFeatureListened(feature);
	}

	private boolean isNamespaceFeatureListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getNamespace_ElementImport() == feature
				//|| UMLPackage.eINSTANCE.getNamespace_ImportedMember() == feature [Detected when element import changes]
				|| UMLPackage.eINSTANCE.getNamespace_Member() == feature
				|| UMLPackage.eINSTANCE.getNamespace_OwnedMember() == feature
				|| UMLPackage.eINSTANCE.getNamespace_PackageImport() == feature
				|| this.isNamedElementFeatureListened(feature)) {
			return true;
		}
		return false;
	}

	private boolean isPackageableElementFeatureListened(EStructuralFeature feature) {
		return this.isNamedElementFeatureListened(feature);
	}

	private boolean isPackageFeatureListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getPackage_URI() == feature
				|| UMLPackage.eINSTANCE.getPackage_NestedPackage() == feature
				|| UMLPackage.eINSTANCE.getPackage_NestingPackage() == feature
				|| UMLPackage.eINSTANCE.getPackage_OwnedType() == feature
				|| UMLPackage.eINSTANCE.getPackage_PackagedElement() == feature
				|| this.isPackageableElementFeatureListened(feature)
				|| this.isNamespaceFeatureListened(feature)) {
			return true;
		}
		return false;
	}

	private boolean isClassifierFeatureListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getClassifier_IsFinalSpecialization() == feature
				|| UMLPackage.eINSTANCE.getClassifier_IsAbstract() == feature
				|| UMLPackage.eINSTANCE.getClassifier_Attribute() == feature
				|| UMLPackage.eINSTANCE.getClassifier_Feature() == feature
				//|| UMLPackage.eINSTANCE.getClassifier_General() == feature [Detected when generalization changes]
				|| UMLPackage.eINSTANCE.getClassifier_Generalization() == feature
				|| this.isNamespaceFeatureListened(feature)
				|| this.isTypeFeatureListened(feature)) {
			return true;
		}
		return false;
	}

	private boolean isStructuredClassifierFeatureListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute() == feature
				|| this.isClassifierFeatureListened(feature)) {
			return true;
		}
		return false;
	}

	private boolean isEncapsulatedClassifierFeatureListened(EStructuralFeature feature) {
		return this.isStructuredClassifierFeatureListened(feature);
	}

	private boolean isBehavioredClassifierListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getBehavioredClassifier_ClassifierBehavior() == feature
				|| UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior() == feature
				|| this.isClassifierFeatureListened(feature)) {
			return true;
		}
		return false;
	}

	private boolean isClassFeatureListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getClass_IsActive() == feature
				|| UMLPackage.eINSTANCE.getClass_NestedClassifier() == feature
				|| UMLPackage.eINSTANCE.getClass_OwnedOperation() == feature
				|| UMLPackage.eINSTANCE.getClass_OwnedReception() == feature
				|| UMLPackage.eINSTANCE.getClass_SuperClass() == feature
				|| this.isEncapsulatedClassifierFeatureListened(feature)
				|| this.isBehavioredClassifierListened(feature)) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	private boolean isAssociationFeatureListener(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getAssociation_OwnedEnd() == feature || this.isClassifierFeatureListened(feature);
	}

	private boolean isSignalFeatureListened(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getSignal_OwnedAttribute() == feature || this.isClassifierFeatureListened(feature);
	}

	private boolean isDatatypeFeatureListened(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getDataType_OwnedAttribute() == feature || this.isClassifierFeatureListened(feature);
	}

	private boolean isEnumerationFeatureListened(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getEnumeration_OwnedLiteral() == feature || this.isDatatypeFeatureListened(feature);
	}
	
	private boolean isRedefinableElementFeatureListened(EStructuralFeature feature){
		if(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf() == feature
				|| UMLPackage.eINSTANCE.getRedefinableElement_RedefinedElement() == feature
				|| UMLPackage.eINSTANCE.getRedefinableElement_RedefinitionContext() == feature
				|| this.isNamedElementFeatureListened(feature)){
			return true;
		}
		return false;
	}
	
	private boolean isFeatureFeatureListened(EStructuralFeature feature){
		if(UMLPackage.eINSTANCE.getFeature_IsStatic() == feature
				|| UMLPackage.eINSTANCE.getFeature_FeaturingClassifier() == feature
				|| this.isRedefinableElementFeatureListened(feature)){
			return true;
		}
		return false;
	}
	
	private boolean isMultiplicityElementFeatureListened(EStructuralFeature feature){
		if(UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered() == feature
				|| UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique() == feature
				|| UMLPackage.eINSTANCE.getMultiplicityElement_Lower() == feature
				|| UMLPackage.eINSTANCE.getMultiplicityElement_Upper() == feature){
			return true;
		}
		return false;
	}
	
	private boolean isTypedElementFeatureListened(EStructuralFeature feature){
		if(UMLPackage.eINSTANCE.getTypedElement_Type() == feature
				|| this.isNamedElementFeatureListened(feature)){
			return true;
		}
		return false;
	}
	
	private boolean isStructuralFeatureListened(EStructuralFeature feature){
		if(UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly() == feature
				|| this.isFeatureFeatureListened(feature)
				|| this.isMultiplicityElementFeatureListened(feature)
				|| this.isTypedElementFeatureListened(feature)){
			return true;
		}
		return false;
	}
	
	private boolean isPropertyFeatureListened(EStructuralFeature feature){
		if(UMLPackage.eINSTANCE.getProperty_Aggregation() == feature
				|| UMLPackage.eINSTANCE.getProperty_IsComposite() == feature
				|| UMLPackage.eINSTANCE.getProperty_IsDerived() == feature
				|| UMLPackage.eINSTANCE.getProperty_IsDerivedUnion() == feature
				|| UMLPackage.eINSTANCE.getProperty_IsID()==feature
				|| UMLPackage.eINSTANCE.getProperty_Association() == feature
				|| UMLPackage.eINSTANCE.getProperty_Class() == feature
				|| UMLPackage.eINSTANCE.getProperty_Datatype() == feature
				|| UMLPackage.eINSTANCE.getProperty_Opposite() == feature
				|| UMLPackage.eINSTANCE.getProperty_OwningAssociation() == feature
				|| this.isStructuralFeatureListened(feature)){
			return true;
		}
		return false;
	}
	
	private boolean isValueSpecificationFeatureListened(EStructuralFeature feature){
		if(this.isTypedElementFeatureListened(feature)){
			return true;
		}
		return false;
	}
	
	private boolean isLiteralSpecificationFeatureListened(EStructuralFeature feature){
		if(this.isValueSpecificationFeatureListened(feature)){
			return true;
		}
		return false;
	}
	
	private boolean isLiteralUnlimitedNaturalFeatureListened(EStructuralFeature feature){
		if(UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value() == feature
				|| this.isLiteralSpecificationFeatureListened(feature)){
			return true;
		}
		return false;
	}
	
	private boolean isBehavioralFeatureListened(EStructuralFeature feature){
		if(UMLPackage.eINSTANCE.getBehavioralFeature_Concurrency() == feature
				|| UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter() == feature
				|| UMLPackage.eINSTANCE.getBehavioralFeature_Method() == feature
				|| this.isFeatureFeatureListened(feature)){
			return true;
		}
		return false;
	}
	
	private boolean isOperationFeatureListened(EStructuralFeature feature){
		if(UMLPackage.eINSTANCE.getOperation_IsQuery() == feature
				|| UMLPackage.eINSTANCE.getOperation_RedefinedOperation() == feature
				|| UMLPackage.eINSTANCE.getOperation_Type() == feature
				|| UMLPackage.eINSTANCE.getOperation_Class() == feature
				|| this.isBehavioralFeatureListened(feature)){
			return true;
		}
		return false;
	}
	
	private boolean isReceptionFeatureListened(EStructuralFeature feature){
		if(UMLPackage.eINSTANCE.getReception_Signal() == feature
				|| this.isBehavioralFeatureListened(feature)){
			return true;
		}
		return false;
	}
	
	private boolean isInstanceSpecificationFeatureListener(EStructuralFeature feature){
		if(UMLPackage.eINSTANCE.getInstanceSpecification_Classifier() == feature
				|| UMLPackage.eINSTANCE.getInstanceSpecification_Slot() == feature
				|| this.isNamedElementFeatureListened(feature)){
			return true;
		}
		return false;
	}
	
	private boolean isEnumerationLiteralFeatureListened(EStructuralFeature feature){
		if(UMLPackage.eINSTANCE.getEnumerationLiteral_Enumeration() == feature
				|| this.isInstanceSpecificationFeatureListener(feature)){
			return true;
		}
		return false;
	}
	
	private boolean isPackageImportFeatureListened(EStructuralFeature feature){
		if(UMLPackage.eINSTANCE.getPackageImport_Visibility() == feature
				|| UMLPackage.eINSTANCE.getPackageImport_ImportedPackage() == feature
			    || UMLPackage.eINSTANCE.getPackageImport_ImportingNamespace() == feature){
			return true;
		}
		return false;	
	}
	
	private boolean isElementImportFeatureListened(EStructuralFeature feature){
		if(UMLPackage.eINSTANCE.getElementImport_ImportedElement() == feature
				|| UMLPackage.eINSTANCE.getElementImport_ImportingNamespace() == feature
				|| UMLPackage.eINSTANCE.getElementImport_Visibility() == feature
				|| UMLPackage.eINSTANCE.getElementImport_Alias() == feature){
			return true;
		}
		return false;
	}
}
