/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Jérémie Tatibouet (CEA LIST)
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf.properties.xtext.sheet.tooling;

import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;

public class StyledTextWithUndoRedo extends StyledText {
	
	public StyledTextWithUndoRedo(Composite parent, int style) {
		super(parent, style);
	}
	
	@Override
	public void replaceTextRange(int start, int length, String text) {
		int contentLength = getCharCount();
		int end = start + length;
		if (start > end || start < 0 || end > contentLength) {
			return;
		}
		super.replaceTextRange(start, length, text);
	}
	
	@Override
	public void redrawRange(int start, int length, boolean clearBackground) {
		int end = start + length;
		int contentLength = getContent().getCharCount();
		if (start > end || start < 0 || end > contentLength) {
			return;
		}else{
			super.redrawRange(start, length, clearBackground);
		}
	}
	
	@Override
	public Rectangle getTextBounds(int start, int end) {
		int contentLength = getCharCount();	
		if (start < 0 || start >= contentLength || end < 0 || end >= contentLength || start > end) {
			return new Rectangle(0, 0, 0, 0);
		}else{
			return super.getTextBounds(start, end);
		}
	}
	
	@Override
	public void replaceStyleRanges(int start, int length, StyleRange[] ranges) {
		try{
			super.replaceStyleRanges(start, length, ranges);
		}catch(IllegalArgumentException e){}
	}
}
