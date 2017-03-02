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
 * 	Jeremie Tatibouet (CEA LIST)
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.text.representation;

import java.io.InputStream;

import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.compare.ITypedElement;
import org.eclipse.compare.rangedifferencer.IRangeComparator;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.xtext.util.StringInputStream;

public abstract class TextualRepresentation
		implements IStreamContentAccessor, ITypedElement {

	protected NamedElement owner;

	protected Comment source;

	protected String text;

	public TextualRepresentation() {
	}

	public TextualRepresentation(NamedElement owner) {
		this.owner = owner;
	}

	public Comment getSource() {
		return this.source;
	}

	public void setSource(Comment source) {
		this.source = source;
	}

	public NamedElement getOwner() {
		return this.owner;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getContent() {
		return this.text;
	}

	public String getName() {
		if (this.getOwner() != null) {
			return this.getOwner().getName();
		}
		return null;
	}

	public Image getImage() {
		return null;
	}

	public String getType() {
		return ITypedElement.TEXT_TYPE;
	}

	public InputStream getContents() throws CoreException {
		return new StringInputStream(this.text);
	}

	/**
	 * Be detached means the textual representation is not attached to a particular comment
	 * 
	 * @return true if no source exists false otherwise
	 */
	public boolean isDetached() {
		return this.source == null;
	}

	/**
	 * Obtain a comparator from the textual representation in order to let the text
	 * be compared using range differencing strategy to another textual representation
	 * 
	 * @return
	 */
	protected abstract IRangeComparator getRangeComparator();

}
