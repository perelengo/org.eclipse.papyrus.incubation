/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.elk;

import java.util.Collection;

import org.eclipse.core.runtime.Platform;
import org.eclipse.elk.conn.gmf.GmfDiagramLayoutConnector;
import org.eclipse.elk.conn.gmf.GmfLayoutConfigurationStore;
import org.eclipse.elk.conn.gmf.GmfLayoutSetup;
import org.eclipse.elk.conn.gmf.GmfLayoutSetup.GmfLayoutModule;
import org.eclipse.elk.core.service.IDiagramLayoutConnector;
import org.eclipse.elk.core.service.ILayoutConfigurationStore;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * Specific Papyrus implementation to override the papyryus edit part support
 */
public class PapyrusLayoutSetup extends GmfLayoutSetup {

	@Override
	public boolean supports(Object object) {
		if (object instanceof Collection) {
			Collection<?> collection = (Collection<?>) object;
			for (Object o : collection) {
				if (isPapyrusEditPart(o)) {
					return true;
				}
			}
			return false;
		}

		return getDiagramEditor(object) != null || isPapyrusEditPart(object);
	}

	protected boolean isPapyrusEditPart(Object o) {
		if (o instanceof IGraphicalEditPart) {
			try {
				return ServiceUtilsForEditPart.getInstance().getServiceRegistry((IGraphicalEditPart) o) != null;
			} catch (ServiceException ex) {
				return false;
			}
		}
		return false;
	}
	
	protected DiagramEditor getDiagramEditor(Object object) {
		if (object == null) {
			return null;
		}
		IEditorPart activeEditor = Platform.getAdapterManager().getAdapter(object, IEditorPart.class);
		if (activeEditor instanceof IMultiDiagramEditor) {
			activeEditor = ((IMultiDiagramEditor) activeEditor).getActiveEditor();
		}

		if (activeEditor instanceof DiagramEditor) {
			return (DiagramEditor) activeEditor;
		}

		return null;
	}
	
	 /**
     * {@inheritDoc}
     */
    @Override
    public Injector createInjector(final Module defaultModule) {
        return Guice.createInjector(Modules.override(defaultModule).with(new PapyrusLayoutModule()));
    }
    
    /**
     * Guice module for the generic GMF connector.
     */
    public static class PapyrusLayoutModule implements Module {

        @Override
        public void configure(final Binder binder) {
            binder.bind(IDiagramLayoutConnector.class).to(PapyrusDiagramLayoutConnector.class);
            binder.bind(ILayoutConfigurationStore.Provider.class).to(GmfLayoutConfigurationStore.Provider.class);
        }
        
    }

}
