/*****************************************************************************
 * Copyright (c) 2019 CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gitlight.compare.ui.internal.commands;

import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.compare.command.ICompareCopyCommand;

/**
 * CompoundCommand for compare copy command of EMF compare.
 */
public class CompoundCompareCommand extends CompoundCommand implements ICompareCopyCommand {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.command.ICompareCopyCommand#isLeftToRight()
	 */
	@Override
	public boolean isLeftToRight() {
		final Collection<ICompareCopyCommand> compareCopyCommands = getCommandList().stream().filter(command -> command instanceof ICompareCopyCommand)
				.map(command -> (ICompareCopyCommand) command).collect(Collectors.toList());
		return compareCopyCommands.stream().allMatch(command -> command.isLeftToRight());
	}

}
