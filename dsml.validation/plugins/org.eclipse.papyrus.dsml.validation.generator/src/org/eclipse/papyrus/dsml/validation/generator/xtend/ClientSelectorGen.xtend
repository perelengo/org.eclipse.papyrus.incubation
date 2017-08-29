/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.dsml.validation.generator.xtend

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.papyrus.dsml.validation.model.profilenames.Utils
import org.eclipse.uml2.uml.Stereotype
import org.eclipse.papyrus.infra.tools.file.IPFileSystemAccess

/**
 * Generator for producing client selector files: Java files that filter the stereotype
 * for validation
 */
public class ClientSelectorGen {

	static def generateValidationContext(Stereotype stereotype) '''
		/**
		 * Created by the Papyrus DSML plugin generator
		 */

		package «Utils.getTopPkg()».selectors;

		import org.eclipse.emf.validation.model.IClientSelector;
		import org.eclipse.papyrus.uml.service.validation.StereotypeUtil;

		/**
		 * This class filters (selects) passed stereotype applications. It returns true, if the
		 * associated stereotype (or one of its super-stereotypes) has the name '[stereotype.name/]'.
		 *
		 * @generated
		 */
		public class «stereotype.name»ClientSelector implements IClientSelector {

			public boolean selects(Object stereoApplicationObj) {
				return StereotypeUtil.checkStereoApplication(stereoApplicationObj, "«stereotype.name»"); //$NON-NLS-1$
			}
		}
	'''
	
	/**
	 * @see org.eclipse.xtext.generator.IGenerator#doGenerate(org.eclipse.emf.ecore.resource.Resource, org.eclipse.xtext.generator.IFileSystemAccess)
	 *
	 * @param input
	 * @param fsa
	 */
	static def generate(Resource input, IPFileSystemAccess fsa) {
		val contentIterator = input.allContents.filter(typeof(Stereotype))
		while (contentIterator.hasNext) {
			val stereotype = contentIterator.next
			val fileName = Utils.getTopPkg().replaceAll('\\.', '/') + '/selectors/' + stereotype.name +'ClientSelector.java'
			fsa.generateFile(fileName, stereotype.generateValidationContext.toString)
		}
	}
}
