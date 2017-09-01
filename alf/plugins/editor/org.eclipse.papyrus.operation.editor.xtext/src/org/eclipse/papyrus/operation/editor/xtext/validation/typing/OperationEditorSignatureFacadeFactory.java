/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.operation.editor.xtext.validation.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.operation.editor.xtext.operation.FormalParameter;
import org.eclipse.papyrus.operation.editor.xtext.operation.OperationDeclaration;

public class OperationEditorSignatureFacadeFactory extends
		SignatureFacadeFactory {

	@Override
	public SignatureFacade createSignatureFacade(EObject o) {
		if (o instanceof OperationDeclaration) {
			OperationDeclaration declaration = (OperationDeclaration) o;
			SignatureFacade signature = new SignatureFacade(null);
			signature.setName(declaration.getName());
			if (declaration.getReturnType() != null) {
				signature.setReturnType(TypeExpressionFactory.eInstance.createTypeExpression(declaration.getReturnType()));
			}
			if (declaration.getFormalParameters() != null && declaration.getFormalParameters().getFormalParameterList() != null) {
				for (FormalParameter p : declaration.getFormalParameters().getFormalParameterList().getFormalParameter()) {
					TypeExpression parameterFacade = TypeExpressionFactory.eInstance.createTypeExpression(p);
					signature.getParameters().add(parameterFacade);
				}
			}
			return signature;
		}
		return super.createSignatureFacade(o);
	}
}
