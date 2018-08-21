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
// import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory;
// import org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance;
//
//
/// **
// * @author cedric dumoulin
// *
// */
// public class BooleanOrOperator implements CustomPropertyOperatorsInstance {
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
// return new BooleanOrOperatorCommand(nestedCommand);
// }
//
//
// /**
// * Class implementing an And command.
// *
// */
// class BooleanOrOperatorCommand implements ComputePropertyValueCommand {
//
// EList<ComputePropertyValueCommand> nestedCommand;
//
// /**
// *
// * Constructor.
// *
// * @param nestedCommand
// */
// public BooleanOrOperatorCommand(EList<ComputePropertyValueCommand> nestedCommand) {
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
// // Do an boolean or: at least one value should be true.
// // Return as soon as a true is encountered
// for (ComputePropertyValueCommand curCmd : nestedCommand) {
// boolean curCmdRes = ((BooleanInstance) curCmd.getCmdValue()).isValue();
// if (curCmdRes == true) {
// return TRUE_INSTANCE;
// }
// }
//
// return FALSE_INSTANCE;
// }
//
// }
// }
