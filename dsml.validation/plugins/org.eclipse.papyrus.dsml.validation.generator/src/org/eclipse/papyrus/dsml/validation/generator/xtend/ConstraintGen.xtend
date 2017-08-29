package org.eclipse.papyrus.dsml.validation.generator.xtend;

import org.eclipse.uml2.uml.Constraint
import org.eclipse.papyrus.dsml.validation.model.profilenames.Utils
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.papyrus.infra.tools.file.IPFileSystemAccess

/**
 * A generator for Java based constraints
 */
class ConstraintGen {

	static def generateConstraint(Constraint constraint) '''
		/**
		 * Created by the Papyrus DSML plugin generator
		 */
		
		package «Utils.getTopPkg()».constraints;
		
		import org.eclipse.core.runtime.IStatus;
		import org.eclipse.emf.validation.AbstractModelConstraint;
		import org.eclipse.emf.validation.IValidationContext;
		import org.eclipse.emf.ecore.EObject;
		«IF !Utils.staticProfile»
			import org.eclipse.uml2.uml.Element;
			import org.eclipse.uml2.uml.Stereotype;
			import org.eclipse.uml2.uml.util.UMLUtil;
		«ENDIF»
		
		public class «constraint.name»Constraint extends AbstractModelConstraint {
		
			public IStatus validate(IValidationContext ctx) {
				EObject target = ctx.getTarget();
		
				«IF Utils.isConstraintForStereotype(constraint)»
					«val qStereotypeName = Utils.getConstraintForStereotype(constraint)»
					«IF Utils.staticProfile»
						«val qStereotypeNameJava = qStereotypeName.replace("::", ".")»
						if (target instanceof «qStereotypeNameJava») {
							if (evaluateConstraint((«qStereotypeNameJava») target)) {
					«ELSE»
						Stereotype stereotype = UMLUtil.getStereotype(target);
						if (stereotype.getQualifiedName().equals("«qStereotypeName»")) { //$NON-NLS-1$
							Element element = UMLUtil.getBaseElement(target);
							if (evaluateConstraint(element, stereotype)) {
					«ENDIF»
							return ctx.createSuccessStatus();
						}
						else {
							return ctx.createFailureStatus(""); //$NON-NLS-1$ failure message is in plugin.xml
						}
					}
					return ctx.createSuccessStatus();
				«ELSE»
					if (evaluateConstraint(target)) {
						return ctx.createSuccessStatus();
					}
					else {
						return ctx.createFailureStatus(""); //$NON-NLS-1$ failure message is in plugin.xml
					}
				«ENDIF»
			}
		
			«IF Utils.isConstraintForStereotype(constraint)»
				«IF Utils.staticProfile»
					«val qStereotypeName = Utils.getConstraintForStereotype(constraint)»
					«val qStereotypeNameJava = qStereotypeName.replace("::", ".")»
					private boolean evaluateConstraint(«qStereotypeNameJava» self) {
				«ELSE»
					private boolean evaluateConstraint(Element self, Stereotype appliedStereotype) {
				«ENDIF»
					«IF Utils.getJavaConstraintBody(constraint.specification) != null»
						«Utils.getJavaConstraintBody(constraint.specification)»
					«ELSE»
						return true;
					«ENDIF»
				}
			«ENDIF»	
		
			«IF !Utils.isConstraintForStereotype(constraint)»
				private boolean evaluateConstraint(EObject self) {
					«IF Utils.getJavaConstraintBody(constraint.specification) != null»
						«Utils.getJavaConstraintBody(constraint.specification)»
					«ELSE»
						return true;
					«ENDIF»
				}
			«ENDIF»
		}
	'''

	/**
	 * @see org.eclipse.xtext.generator.IGenerator#doGenerate(org.eclipse.emf.ecore.resource.Resource, org.eclipse.xtext.generator.IFileSystemAccess)
	 *
	 * @param input
	 * @param fsa
	 */
	static def generate(Resource input, IPFileSystemAccess fsa) {
		val contentIterator = input.allContents.filter(typeof(Constraint))
		while (contentIterator.hasNext) {
			val constraint = contentIterator.next
			if (Utils.hasSpecificationForJava(constraint)) {
				if (constraint.name == null) {
					throw new RuntimeException("Constraint has no name, context: " + constraint.context.qualifiedName);
				}
				val fileName = Utils.getTopPkg().replaceAll('\\.', '/') + '/constraints/' + constraint.getName() +
					'Constraint.java';
				fsa.generateFile(fileName, constraint.generateConstraint.toString)
			}
		}
	}
}
