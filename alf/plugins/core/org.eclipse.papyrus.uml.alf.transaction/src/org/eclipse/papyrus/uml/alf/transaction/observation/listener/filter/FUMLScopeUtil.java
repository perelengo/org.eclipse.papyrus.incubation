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

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.CommunicationPath;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Provides utility to check if an object is part of the fUML scope 
 */
public class FUMLScopeUtil {
	
	/**
	 * Check if the given notifier is strictly a Class
	 * 
	 * @param notifier
	 * 
	 * @return true if constraint is verified false otherwise
	 */
	public static boolean isClass(Object notifier) {
		if (notifier instanceof Class &&
				(!(notifier instanceof AssociationClass) &&
						!(notifier instanceof Component) &&
						!(notifier instanceof Node) &&
						!(notifier instanceof Stereotype) &&
				!(notifier instanceof Behavior))) {
			return true;
		}
		return false;
	}

	/**
	 * Check if the given notifier is strictly a Signal
	 * 
	 * @param notifier
	 * 
	 * @return true if constraint is verified false otherwise
	 */
	public static boolean isSignal(Object notifier) {
		return notifier instanceof Signal;
	}

	/**
	 * Check if the given notifier is strictly a DataType
	 * 
	 * @param notifier
	 * 
	 * @return true if constraint is verified false otherwise
	 */
	public static boolean isDataType(Object notifier) {
		if (notifier instanceof DataType
				&& !(notifier instanceof Enumeration)) {
			return true;
		}
		return false;
	}

	/**
	 * Check if the given notifier is strictly a Package
	 * 
	 * @param notifier
	 * 
	 * @return true if constraint is verified false otherwise
	 */
	public static boolean isPackage(Object notifier) {
		if (notifier != null
				&& notifier instanceof Package
				&& !(notifier instanceof Model)
				&& !(notifier instanceof Profile)) {
			return true;
		}
		return false;
	}

	/**
	 * Check if the given notifier is strictly an Enumeration
	 * 
	 * @param notifier
	 * 
	 * @return true if constraint is verified false otherwise 
	 */
	public static boolean isEnumeration(Object notifier) {
		return notifier instanceof Enumeration;
	}

	/**
	 * Check if the given notifier is strictly an Association
	 * 
	 * @param notifier
	 * 
	 * @return true if constraint is verified false otherwise
	 */
	public static boolean isAssociation(Object notifier) {
		if (notifier instanceof Association
				&& !(notifier instanceof AssociationClass)
				&& !(notifier instanceof Extension)
				&& !(notifier instanceof CommunicationPath)) {
			Association association = (Association)notifier;
			return association.getOwnedEnds().size() == association.getMemberEnds().size();
		}
		return false;
	}
	
	/**
	 * Check if the given notifier is strictly a Generalization
	 * 
	 * @param notifier
	 * 
	 * @return true if constraint is verified false otherwise
	 */
	public static boolean isGeneralization(Object notifier) {
		return notifier instanceof Generalization;
	}
	
	/**
	 * Check if the given notifier is strictly a property
	 * 
	 * @param notifier
	 * 
	 * @return true if constraint is verified false otherwise
	 */
	public static boolean isProperty(Object notifier){
		if(notifier instanceof Property
				&& !(notifier instanceof Port)
				&& !(notifier instanceof ExtensionEnd) ){
			return true;
		}
		return false;
	}
	
	public static boolean isActivity(Object notifier){
		return notifier instanceof Activity;
	}
	
	public static boolean isLiteralUnlimitedNatural(Object notifier){
		return notifier instanceof LiteralUnlimitedNatural;
	}
	
	/**
	 * Check if the given notifier is strictly an Operation
	 * 
	 * @param notifier
	 * 
	 * @return true if constraint is verified false otherwise
	 */
	public static boolean isOperation(Object notifier){
		return notifier instanceof Operation;
	}
	
	/**
	 * This predictate is only valid if:
	 * 1 - the notified is an Operation
	 * 2 - the operation is not abstract
	 * 3 - there is only one implementation for the operation
	 * 4 - the implementation is given as an activity
	 * 
	 * @param notifier
	 * 
	 * @return true if constraint is verified false otherwise
	 */
	public static boolean isOperationWithImplementation(Object notifier){
		return isOperation(notifier) 
				&& !((Operation)notifier).isAbstract() 
				&& ((Operation)notifier).getMethods().size()==1
				&& ((Operation)notifier).getMethods().get(0) instanceof Activity;
	}
	
	/**
	 * Check if the given notifier is strictly a Reception
	 * 
	 * @param notifier
	 * 
	 * @return true if constraint is verified false otherwise
	 */
	public static boolean isReception(Object notifier){
		return notifier instanceof Reception;
	}
	
	/**
	 * Check if the given notifier is strictly an Enumeration literal
	 * 
	 * @param notifier
	 * 
	 * @return true if constraint is verified false otherwise
	 */
	public static boolean isEnumerationLiteral(Object notifier){
		return notifier instanceof EnumerationLiteral;
	}
	
	/**
	 * Check if the given notifier is strictly a PackageImport
	 * 
	 * @param notifier
	 * 
	 * @return true if constraint is verified false otherwise
	 */
	public static boolean isPackageImport(Object notifier){
		return notifier instanceof PackageImport;
	}
	
	/**
	 * Check if the given notifier is strictly an ElementImport
	 * 
	 * @param notifier
	 * 
	 * @return true if constraint is verified false otherwise
	 */
	public static boolean isElementImport(Object notifier){
		return notifier instanceof ElementImport;
	}

}
