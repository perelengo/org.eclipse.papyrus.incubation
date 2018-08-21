/// *******************************************************************************
// * Copyright (c) 2013 CEA LIST.
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// *
// * Contributors:
// * Cedric Dumoulin - cedric.dumoulin@lifl.fr
// ******************************************************************************/
// package org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.operators;
//
// import org.eclipse.emf.common.util.EList;
// import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException;
// import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand;
// import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.BooleanInstance;
// import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ColorInstance;
// import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillInstance;
// import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
// import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance;
//
//
/// **
// * @author cedric dumoulin
// *
// */
// public class FillAverageOperator implements CustomPropertyOperatorsInstance {
//
// public static final BooleanInstance FALSE_INSTANCE;
// public static final BooleanInstance TRUE_INSTANCE;
//
// static {
// FALSE_INSTANCE = LayersFactory.eINSTANCE.createBooleanInstance();
// FALSE_INSTANCE.setValue(false);
// TRUE_INSTANCE = LayersFactory.eINSTANCE.createBooleanInstance();
// TRUE_INSTANCE.setValue(true);
// }
//
// /**
// *
// * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.operators.CustomPropertyOperatorsInstance#getComputePropertyValueCommand(org.eclipse.emf.common.util.EList)
// *
// * @param property
// * @return
// * @throws LayersException
// */
// @Override
// public ComputePropertyValueCommand getComputePropertyValueCommand(EList<ComputePropertyValueCommand> nestedCommand) throws LayersException {
// return new FillAverageCommand(nestedCommand);
// }
//
//
// /**
// * Class implementing an And command.
// *
// */
// class FillAverageCommand implements ComputePropertyValueCommand {
//
// EList<ComputePropertyValueCommand> nestedCommand;
//
// /**
// *
// * Constructor.
// *
// * @param nestedCommand
// */
// public FillAverageCommand(EList<ComputePropertyValueCommand> nestedCommand) {
// this.nestedCommand = nestedCommand;
// }
//
// /**
// * Compute the value.
// *
// * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand#getCmdValue()
// *
// * @return
// * @throws LayersException
// */
// @Override
// public TypeInstance getCmdValue() throws LayersException {
//
// int fill = 0;
// int color = 0;
// // compute the average values
// for (ComputePropertyValueCommand curCmd : nestedCommand) {
// FillInstance curValue = ((FillInstance) curCmd.getCmdValue());
// fill += curValue.getTransparency();
// color += curValue.getFillColor().getValue();
// }
//
// // Create a result
// FillInstance res = LayersFactory.eINSTANCE.createFillInstance();
// ColorInstance colorInstance = LayersFactory.eINSTANCE.createColorInstance();
// res.setFillColor(colorInstance);
// res.setTransparency(fill / nestedCommand.size());
// res.getFillColor().setValue(color / nestedCommand.size());
// return res;
// }
//
// }
// }
