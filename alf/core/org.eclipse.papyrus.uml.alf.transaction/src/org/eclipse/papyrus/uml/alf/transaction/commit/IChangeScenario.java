package org.eclipse.papyrus.uml.alf.transaction.commit;

import org.eclipse.uml2.uml.NamedElement;

public interface IChangeScenario {

	/**
	 * The core method of a scenario
	 * 
	 * @param target
	 *            - the element for which the scenario is executed
	 * @param lastEditedVersion
	 *            - the last version of the textual representation (usually in an editor)
	 */
	public void execute(NamedElement target, final String lastEditedVersion);

}
