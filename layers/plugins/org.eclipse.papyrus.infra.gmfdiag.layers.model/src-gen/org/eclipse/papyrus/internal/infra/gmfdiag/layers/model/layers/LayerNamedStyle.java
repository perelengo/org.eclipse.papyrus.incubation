/**
 * Copyright (c) 2013, 2017 CEA LIST & LIFL 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *   Quentin Le Menez quentin.lemenez@cea.fr
 * 
 */
package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers;

import java.util.List;

import org.eclipse.gmf.runtime.notation.NamedStyle;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Named Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerNamedStyle#getLayersStack <em>Layers Stack</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getLayerNamedStyle()
 * @model
 * @generated
 */
public interface LayerNamedStyle extends NamedStyle {
	/**
	 * Returns the value of the '<em><b>Layers Stack</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layers Stack</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layers Stack</em>' containment reference list.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersPackage#getLayerNamedStyle_LayersStack()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	List<LayersStack> getLayersStack();

} // LayerNamedStyle
