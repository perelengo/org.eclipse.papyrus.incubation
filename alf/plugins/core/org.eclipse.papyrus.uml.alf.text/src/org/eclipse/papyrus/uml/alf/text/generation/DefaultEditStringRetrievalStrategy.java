package org.eclipse.papyrus.uml.alf.text.generation;

/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Jeremie Tatibouet (CEA LIST);
 *****************************************************************************/
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.uml.alf.Member;
import org.eclipse.papyrus.uml.alf.PropertyDefinition;
import org.eclipse.papyrus.uml.alf.text.ActivatorText;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;
import org.eclipse.papyrus.uml.alf.text.representation.util.RepresentationParser;
import org.eclipse.papyrus.uml.alf.text.representation.util.RepresentationParsingError;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;

public class DefaultEditStringRetrievalStrategy extends EditStringRetrievalStrategy {

	/**
	 * The serializer associated to the ALF grammar
	 */
	private ISerializer serializer;

	public DefaultEditStringRetrievalStrategy() {
		this.serializer = ActivatorText.getDefault().getInjector().getInstance(ISerializer.class);
	}

	/**
	 * Return the textual representation associated to a given model element
	 * 
	 * @param element
	 *            - the element for which the textual representation is computed
	 * @return generated - the textual representation computed for this element
	 */
	public String getGeneratedEditString(Element element) {
		String generated = "";
		Resource alfModel = this.getAlfModel((NamedElement) element);
		if (this.serializer != null) {
			EObject serializationTarget = null;
			if (element instanceof Property) {
				serializationTarget = this.getPropertyDefinition((Property) element, alfModel);
			} else {
				serializationTarget = alfModel.getContents().get(0);
			}
			generated = this.serializer.serialize(serializationTarget, SaveOptions.newBuilder().noValidation().getOptions());
		}
		return generated;
	}

	/**
	 * When opened the editor retrieve the based string on which the user is going to work.
	 * There are two possibilities:
	 * 1 - The element already has a textual representation associated. Then the return string is the registered representation
	 * 2 - The element does not have an associated textual representation. Then the return string is the one dynamically calculated
	 * 
	 * @param element
	 *            - the element for which the textual representation is computed
	 * @return registered - the textual representation computed for this element
	 */
	public String getEditString(Element element) {
		AlfTextualRepresentation registeredRep = null;
		/* 1. Parse the representation associated to model element */
		try {
			registeredRep = RepresentationParser.getInstance().
					parse((NamedElement) element);
		} catch (RepresentationParsingError e) {
			e.printStackTrace();
		}
		/* 2. If the representation is in detached state (i.e. there is no model element owning it) then rely on the issued from a snapshot */
		if (registeredRep != null && registeredRep.isDetached()) {
			AlfTextualRepresentation generatedRep = null;
			try {
				generatedRep = RepresentationParser.getInstance().
						getSnapshot((NamedElement) element);
			} catch (RepresentationParsingError e) {
				e.printStackTrace();
			}
			if (generatedRep != null) {
				registeredRep.setText(generatedRep.getContent());
			}
		}
		return registeredRep.getContent();
	}


	private EObject getPropertyDefinition(Property property, Resource alfModelResource) {
		EObject memberDefinition = null;
		Iterator<EObject> contentIterator = alfModelResource.getAllContents();
		boolean found = false;
		while (contentIterator.hasNext() && !found) {
			EObject currentObject = contentIterator.next();
			if (currentObject instanceof Member) {
				Member member = (Member) currentObject;
				if (member.getVisibility().equals(property.getVisibility().toString())
						&& member.getDefinition() instanceof PropertyDefinition) {
					PropertyDefinition definition = (PropertyDefinition) member.getDefinition();
					if (definition.getName().equals(property.getName())) {
						found = (definition.getTypePart().isIsAny() && property.getType() == null)
								|| definition.getTypePart().getTypeName().toString().equals(property.getType().toString());
						memberDefinition = member;
					}
				}
			}
		}
		return memberDefinition;
	}
}
