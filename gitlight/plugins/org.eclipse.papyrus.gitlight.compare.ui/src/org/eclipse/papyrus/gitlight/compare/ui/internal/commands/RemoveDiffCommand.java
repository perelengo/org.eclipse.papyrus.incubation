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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.papyrus.gitlight.compare.ui.contentmergeviewer.provider.PapyrusMergeViewerItem;

/**
 * This allows to remove a diff from the list of papyrus items.
 */
@SuppressWarnings("restriction")
public class RemoveDiffCommand extends AbstractCommand {

	/**
	 * The papyrus items.
	 */
	private List<PapyrusMergeViewerItem> papyrusMergeViewerItems;

	/**
	 * The diff to remove from the list of papyrus items.
	 */
	private PapyrusMergeViewerItem diffToRemove;

	/**
	 * The papyrus items removed by command.
	 */
	private Map<PapyrusMergeViewerItem, Integer> papyrusItemsAndIndexRemoved;

	/**
	 * Default constructor.
	 *
	 * @param papyrusMergeViewerItems
	 *            The papyrus items.
	 * @param diffToRemove
	 *            The diff to remove from the list.
	 */
	public RemoveDiffCommand(final List<PapyrusMergeViewerItem> papyrusMergeViewerItems, final PapyrusMergeViewerItem diffToRemove) {
		this.papyrusMergeViewerItems = papyrusMergeViewerItems;
		this.diffToRemove = diffToRemove;
		this.papyrusItemsAndIndexRemoved = null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.command.Command#execute()
	 */
	@Override
	public void execute() {
		if (null != diffToRemove) {
			papyrusItemsAndIndexRemoved = new HashMap<PapyrusMergeViewerItem, Integer>();
			for (final PapyrusMergeViewerItem item : papyrusMergeViewerItems) {
				if (null != item && diffToRemove.getDiff().equals(item.getDiff())) {
					papyrusItemsAndIndexRemoved.put(item, papyrusMergeViewerItems.indexOf(item));
				}
			}
			if (!papyrusItemsAndIndexRemoved.isEmpty()) {
				papyrusMergeViewerItems.removeAll(papyrusItemsAndIndexRemoved.keySet());
			}
		}
		this.diffToRemove = null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#undo()
	 */
	@Override
	public void undo() {
		if (!papyrusItemsAndIndexRemoved.isEmpty()) {
			for (final Entry<PapyrusMergeViewerItem, Integer> entry : papyrusItemsAndIndexRemoved.entrySet()) {
				papyrusMergeViewerItems.add(entry.getValue(), entry.getKey());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	@Override
	public void redo() {
		if (!papyrusItemsAndIndexRemoved.isEmpty()) {
			papyrusMergeViewerItems.removeAll(papyrusItemsAndIndexRemoved.keySet());
		}
	}


}
