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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Start the LayesStack.
 * This method should be called after the LayersStack creation. It is not called from the constructor, because 
 * the initialisation can differ if the LayersStack is created by the user or by EMF after a reloading.
 * 
 * <!-- end-model-doc -->
 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='Layers'"
 * @generated
 */
public interface LayersPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "layers"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/gmfdiag/layers"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "layers"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayersPackage eINSTANCE = org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerNamedStyleImpl <em>Layer Named Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerNamedStyleImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerNamedStyle()
	 * @generated
	 */
	int LAYER_NAMED_STYLE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_NAMED_STYLE__NAME = NotationPackage.NAMED_STYLE__NAME;

	/**
	 * The feature id for the '<em><b>Layers Stack</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_NAMED_STYLE__LAYERS_STACK = NotationPackage.NAMED_STYLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Layer Named Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_NAMED_STYLE_FEATURE_COUNT = NotationPackage.NAMED_STYLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Layer Named Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @ordered
	 */
	int LAYER_NAMED_STYLE_OPERATION_COUNT = /* NotationPackage.NAMED_STYLE_OPERATION_COUNT + */0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersContainer <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersContainer
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayersContainer()
	 * @generated
	 */
	int LAYERS_CONTAINER = 26;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_CONTAINER_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Add Layer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_CONTAINER___ADD_LAYER__LAYEREXPRESSION = 0;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_CONTAINER_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersStackImpl <em>Stack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersStackImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayersStack()
	 * @generated
	 */
	int LAYERS_STACK = 1;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK__LAYERS = LAYERS_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK__NAME = LAYERS_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK__DESCRIPTION = LAYERS_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK__DIAGRAM = LAYERS_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK__STATE = LAYERS_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Stack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_FEATURE_COUNT = LAYERS_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Add Layer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK___ADD_LAYER__LAYEREXPRESSION = LAYERS_CONTAINER___ADD_LAYER__LAYEREXPRESSION;

	/**
	 * The operation id for the '<em>Get Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY = LAYERS_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Properties Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST = LAYERS_CONTAINER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Views Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY = LAYERS_CONTAINER_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Start After Creation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK___START_AFTER_CREATION = LAYERS_CONTAINER_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Attach Layers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK___ATTACH_LAYERS = LAYERS_CONTAINER_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Attach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK___ATTACH = LAYERS_CONTAINER_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Detach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK___DETACH = LAYERS_CONTAINER_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Enter Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK___ENTER_ATTACHED_STATE = LAYERS_CONTAINER_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Exit Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK___EXIT_ATTACHED_STATE = LAYERS_CONTAINER_OPERATION_COUNT + 8;

	/**
	 * The number of operations of the '<em>Stack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_OPERATION_COUNT = LAYERS_CONTAINER_OPERATION_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.ApplicationDependantElementImpl <em>Application Dependant Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.ApplicationDependantElementImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getApplicationDependantElement()
	 * @generated
	 */
	int APPLICATION_DEPENDANT_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Application</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDANT_ELEMENT__APPLICATION = 0;

	/**
	 * The number of structural features of the '<em>Application Dependant Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDANT_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Application Dependant Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DEPENDANT_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl <em>Layer Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerExpression()
	 * @generated
	 */
	int LAYER_EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>Application</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION__APPLICATION = APPLICATION_DEPENDANT_ELEMENT__APPLICATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION__NAME = APPLICATION_DEPENDANT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION__DESCRIPTION = APPLICATION_DEPENDANT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION__IS_LAYER_ENABLED_INTERNAL = APPLICATION_DEPENDANT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION__IS_LAYER_ENABLED = APPLICATION_DEPENDANT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION__IS_BRANCH_ENABLED = APPLICATION_DEPENDANT_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owning Layers Stack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION__OWNING_LAYERS_STACK = APPLICATION_DEPENDANT_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION__STATE = APPLICATION_DEPENDANT_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Layer Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION_FEATURE_COUNT = APPLICATION_DEPENDANT_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY = APPLICATION_DEPENDANT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Views Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY = APPLICATION_DEPENDANT_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Properties Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST = APPLICATION_DEPENDANT_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Attach To Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION___ATTACH_TO_LAYERS_STACK__LAYERSSTACK = APPLICATION_DEPENDANT_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION___GET_LAYERS_STACK = APPLICATION_DEPENDANT_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Enter Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION___ENTER_ATTACHED_STATE = APPLICATION_DEPENDANT_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Attach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION___ATTACH = APPLICATION_DEPENDANT_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Detach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION___DETACH = APPLICATION_DEPENDANT_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Exit Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION___EXIT_ATTACHED_STATE = APPLICATION_DEPENDANT_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The number of operations of the '<em>Layer Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_EXPRESSION_OPERATION_COUNT = APPLICATION_DEPENDANT_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FolderElementImpl <em>Folder Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FolderElementImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFolderElement()
	 * @generated
	 */
	int FOLDER_ELEMENT = 5;

	/**
	 * The number of structural features of the '<em>Folder Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Folder Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersStackApplicationImpl <em>Stack Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersStackApplicationImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayersStackApplication()
	 * @generated
	 */
	int LAYERS_STACK_APPLICATION = 4;

	/**
	 * The feature id for the '<em><b>Layers Stacks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_APPLICATION__LAYERS_STACKS = FOLDER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Layer Stack Registry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY = FOLDER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Property Registry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY = FOLDER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Layer Descriptor Registry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY = FOLDER_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Factory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_APPLICATION__FACTORY = FOLDER_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Property Setter Registry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY = FOLDER_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Layer Operator Descriptor Registry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY = FOLDER_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Stack Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_APPLICATION_FEATURE_COUNT = FOLDER_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Layers Stack For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_APPLICATION___GET_LAYERS_STACK_FOR__DIAGRAM = FOLDER_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Remove Layers Stack For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_APPLICATION___REMOVE_LAYERS_STACK_FOR__DIAGRAM = FOLDER_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Layers Stack Attached For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_APPLICATION___IS_LAYERS_STACK_ATTACHED_FOR__DIAGRAM = FOLDER_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Create Layers Stack For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_APPLICATION___CREATE_LAYERS_STACK_FOR__DIAGRAM = FOLDER_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Lookup Layers Stack For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_APPLICATION___LOOKUP_LAYERS_STACK_FOR__DIAGRAM = FOLDER_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Stack Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYERS_STACK_APPLICATION_OPERATION_COUNT = FOLDER_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerStackDescriptorRegistryImpl <em>Layer Stack Descriptor Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerStackDescriptorRegistryImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerStackDescriptorRegistry()
	 * @generated
	 */
	int LAYER_STACK_DESCRIPTOR_REGISTRY = 6;

	/**
	 * The number of structural features of the '<em>Layer Stack Descriptor Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_STACK_DESCRIPTOR_REGISTRY_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Layer Stack Descriptor Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_STACK_DESCRIPTOR_REGISTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyRegistryImpl <em>Property Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyRegistryImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getPropertyRegistry()
	 * @generated
	 */
	int PROPERTY_REGISTRY = 7;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REGISTRY__PROPERTIES = 0;

	/**
	 * The feature id for the '<em><b>Type Registry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REGISTRY__TYPE_REGISTRY = 1;

	/**
	 * The feature id for the '<em><b>Properties Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REGISTRY__PROPERTIES_COUNT = 2;

	/**
	 * The number of structural features of the '<em>Property Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REGISTRY_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Get Property Index</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REGISTRY___GET_PROPERTY_INDEX__STRING = 0;

	/**
	 * The operation id for the '<em>Get Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REGISTRY___GET_PROPERTY__STRING = 1;

	/**
	 * The operation id for the '<em>Add Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REGISTRY___ADD_PROPERTY__PROPERTY = 2;

	/**
	 * The number of operations of the '<em>Property Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REGISTRY_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TYPE = FOLDER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DEFAULT_VALUE = FOLDER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = FOLDER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DESCRIPTION = FOLDER_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__INDEX = FOLDER_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = FOLDER_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___CREATE_INSTANCE = FOLDER_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = FOLDER_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TypeImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 9;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__METAMODEL = FOLDER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = FOLDER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__DESCRIPTION = FOLDER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = FOLDER_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___CREATE_INSTANCE = FOLDER_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = FOLDER_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.MetamodelImpl <em>Metamodel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.MetamodelImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getMetamodel()
	 * @generated
	 */
	int METAMODEL = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__NAME = FOLDER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__DESCRIPTION = FOLDER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nsuri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__NSURI = FOLDER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Plugin ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__PLUGIN_ID = FOLDER_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>EPackage Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__EPACKAGE_INSTANCE_NAME = FOLDER_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Type Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__IS_TYPE_VALID = FOLDER_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Metamodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_FEATURE_COUNT = FOLDER_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Get EPackage</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL___GET_EPACKAGE = FOLDER_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Metamodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_OPERATION_COUNT = FOLDER_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand <em>Compute Property Value Command Itf</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getComputePropertyValueCommandItf()
	 * @generated
	 */
	int COMPUTE_PROPERTY_VALUE_COMMAND_ITF = 12;

	/**
	 * The number of structural features of the '<em>Compute Property Value Command Itf</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROPERTY_VALUE_COMMAND_ITF_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get Cmd Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROPERTY_VALUE_COMMAND_ITF___GET_CMD_VALUE = 0;

	/**
	 * The number of operations of the '<em>Compute Property Value Command Itf</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROPERTY_VALUE_COMMAND_ITF_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TypeInstanceImpl <em>Type Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TypeInstanceImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getTypeInstance()
	 * @generated
	 */
	int TYPE_INSTANCE = 11;

	/**
	 * The number of structural features of the '<em>Type Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE_FEATURE_COUNT = COMPUTE_PROPERTY_VALUE_COMMAND_ITF_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Cmd Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE___GET_CMD_VALUE = COMPUTE_PROPERTY_VALUE_COMMAND_ITF___GET_CMD_VALUE;

	/**
	 * The operation id for the '<em>Set Value From String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE___SET_VALUE_FROM_STRING__STRING = COMPUTE_PROPERTY_VALUE_COMMAND_ITF_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Value From Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE = COMPUTE_PROPERTY_VALUE_COMMAND_ITF_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE_OPERATION_COUNT = COMPUTE_PROPERTY_VALUE_COMMAND_ITF_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TypeRegistryImpl <em>Type Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TypeRegistryImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getTypeRegistry()
	 * @generated
	 */
	int TYPE_REGISTRY = 13;

	/**
	 * The feature id for the '<em><b>Types</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REGISTRY__TYPES = 0;

	/**
	 * The number of structural features of the '<em>Type Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REGISTRY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Type Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REGISTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToTypeMapImpl <em>String To Type Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToTypeMapImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStringToTypeMap()
	 * @generated
	 */
	int STRING_TO_TYPE_MAP = 14;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_TYPE_MAP__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_TYPE_MAP__KEY = 1;

	/**
	 * The number of structural features of the '<em>String To Type Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_TYPE_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Type Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_TYPE_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerDescriptorRegistryImpl <em>Layer Descriptor Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerDescriptorRegistryImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerDescriptorRegistry()
	 * @generated
	 */
	int LAYER_DESCRIPTOR_REGISTRY = 15;

	/**
	 * The feature id for the '<em><b>Layer Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_DESCRIPTOR_REGISTRY__LAYER_DESCRIPTORS = 0;

	/**
	 * The number of structural features of the '<em>Layer Descriptor Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_DESCRIPTOR_REGISTRY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Layer Descriptor Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_DESCRIPTOR_REGISTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerDescriptorImpl <em>Layer Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerDescriptorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerDescriptor()
	 * @generated
	 */
	int LAYER_DESCRIPTOR = 16;

	/**
	 * The feature id for the '<em><b>Property Registry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_DESCRIPTOR__PROPERTY_REGISTRY = 0;

	/**
	 * The number of structural features of the '<em>Layer Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_DESCRIPTOR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Layer Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_DESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerApplicationFactoryImpl <em>Layer Application Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerApplicationFactoryImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerApplicationFactory()
	 * @generated
	 */
	int LAYER_APPLICATION_FACTORY = 17;

	/**
	 * The feature id for the '<em><b>Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_APPLICATION_FACTORY__APPLICATION = 0;

	/**
	 * The number of structural features of the '<em>Layer Application Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_APPLICATION_FACTORY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Layer Application Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_APPLICATION_FACTORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertySetterRegistryImpl <em>Property Setter Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertySetterRegistryImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getPropertySetterRegistry()
	 * @generated
	 */
	int PROPERTY_SETTER_REGISTRY = 18;

	/**
	 * The feature id for the '<em><b>Property Setters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS = 0;

	/**
	 * The feature id for the '<em><b>Setter Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTER_REGISTRY__SETTER_MAP = 1;

	/**
	 * The feature id for the '<em><b>Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTER_REGISTRY__APPLICATION = 2;

	/**
	 * The number of structural features of the '<em>Property Setter Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTER_REGISTRY_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Get Property Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTER_REGISTRY___GET_PROPERTY_SETTER__PROPERTY = 0;

	/**
	 * The operation id for the '<em>Get Property Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTER_REGISTRY___GET_PROPERTY_SETTER__STRING = 1;

	/**
	 * The operation id for the '<em>Add Property Setter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTER_REGISTRY___ADD_PROPERTY_SETTER__PROPERTYSETTER = 2;

	/**
	 * The number of operations of the '<em>Property Setter Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTER_REGISTRY_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertySetterImpl <em>Property Setter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertySetterImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getPropertySetter()
	 * @generated
	 */
	int PROPERTY_SETTER = 19;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTER__PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTER__PROPERTY_NAME = 1;

	/**
	 * The number of structural features of the '<em>Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTER_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Set Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE = 0;

	/**
	 * The number of operations of the '<em>Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTER_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToPropertySetterImpl <em>String To Property Setter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToPropertySetterImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStringToPropertySetter()
	 * @generated
	 */
	int STRING_TO_PROPERTY_SETTER = 20;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_PROPERTY_SETTER__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_PROPERTY_SETTER__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_PROPERTY_SETTER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_PROPERTY_SETTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorDescriptorRegistryImpl <em>Layer Operator Descriptor Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorDescriptorRegistryImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerOperatorDescriptorRegistry()
	 * @generated
	 */
	int LAYER_OPERATOR_DESCRIPTOR_REGISTRY = 21;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DESCRIPTORS = 0;

	/**
	 * The feature id for the '<em><b>Property Operators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_OPERATORS = 1;

	/**
	 * The feature id for the '<em><b>Property Collection Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_COLLECTION_SIZE = 2;

	/**
	 * The feature id for the '<em><b>Default Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DEFAULT_OPERATOR = 3;

	/**
	 * The number of structural features of the '<em>Layer Operator Descriptor Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR_REGISTRY_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Add Layer Operator Descriptor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ADD_LAYER_OPERATOR_DESCRIPTOR__LAYEROPERATORDESCRIPTOR = 0;

	/**
	 * The operation id for the '<em>Get Layer Operator Descriptor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR_REGISTRY___GET_LAYER_OPERATOR_DESCRIPTOR__STRING = 1;

	/**
	 * The operation id for the '<em>Add Property Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ADD_PROPERTY_OPERATOR__PROPERTYOPERATOR = 2;

	/**
	 * The operation id for the '<em>Get Property Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR_REGISTRY___GET_PROPERTY_OPERATOR__STRING = 3;

	/**
	 * The operation id for the '<em>Attach Operator To Descriptor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ATTACH_OPERATOR_TO_DESCRIPTOR__PROPERTY_STRING_STRING = 4;

	/**
	 * The operation id for the '<em>Create Layer Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR_REGISTRY___CREATE_LAYER_OPERATOR__STRING = 5;

	/**
	 * The number of operations of the '<em>Layer Operator Descriptor Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR_REGISTRY_OPERATION_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorDescriptorImpl <em>Layer Operator Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorDescriptorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerOperatorDescriptor()
	 * @generated
	 */
	int LAYER_OPERATOR_DESCRIPTOR = 22;

	/**
	 * The feature id for the '<em><b>Property Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR__NAME = 1;

	/**
	 * The number of structural features of the '<em>Layer Operator Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Get Property Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR___GET_PROPERTY_OPERATOR__PROPERTY = 0;

	/**
	 * The operation id for the '<em>Set Property Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_OPERATOR__PROPERTY_PROPERTYOPERATOR = 1;

	/**
	 * The operation id for the '<em>Create Layer Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR___CREATE_LAYER_OPERATOR = 2;

	/**
	 * The operation id for the '<em>Set Property Collection Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_COLLECTION_SIZE__INT_DEFAULTPROPERTYOPERATOR = 3;

	/**
	 * The number of operations of the '<em>Layer Operator Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_DESCRIPTOR_OPERATION_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyOperatorImpl <em>Property Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyOperatorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getPropertyOperator()
	 * @generated
	 */
	int PROPERTY_OPERATOR = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATOR__NAME = 0;

	/**
	 * The number of structural features of the '<em>Property Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATOR_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST = 0;

	/**
	 * The number of operations of the '<em>Property Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATOR_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorImpl <em>Layer Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerOperator()
	 * @generated
	 */
	int LAYER_OPERATOR = 25;

	/**
	 * The feature id for the '<em><b>Application</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR__APPLICATION = LAYER_EXPRESSION__APPLICATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR__NAME = LAYER_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR__DESCRIPTION = LAYER_EXPRESSION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR__IS_LAYER_ENABLED_INTERNAL = LAYER_EXPRESSION__IS_LAYER_ENABLED_INTERNAL;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR__IS_LAYER_ENABLED = LAYER_EXPRESSION__IS_LAYER_ENABLED;

	/**
	 * The feature id for the '<em><b>Is Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR__IS_BRANCH_ENABLED = LAYER_EXPRESSION__IS_BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Owning Layers Stack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR__OWNING_LAYERS_STACK = LAYER_EXPRESSION__OWNING_LAYERS_STACK;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR__STATE = LAYER_EXPRESSION__STATE;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR__LAYERS = LAYER_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Layer Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_FEATURE_COUNT = LAYER_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY = LAYER_EXPRESSION___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY;

	/**
	 * The operation id for the '<em>Get Views Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY = LAYER_EXPRESSION___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY;

	/**
	 * The operation id for the '<em>Get Properties Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST = LAYER_EXPRESSION___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST;

	/**
	 * The operation id for the '<em>Attach To Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR___ATTACH_TO_LAYERS_STACK__LAYERSSTACK = LAYER_EXPRESSION___ATTACH_TO_LAYERS_STACK__LAYERSSTACK;

	/**
	 * The operation id for the '<em>Get Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR___GET_LAYERS_STACK = LAYER_EXPRESSION___GET_LAYERS_STACK;

	/**
	 * The operation id for the '<em>Enter Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR___ENTER_ATTACHED_STATE = LAYER_EXPRESSION___ENTER_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Attach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR___ATTACH = LAYER_EXPRESSION___ATTACH;

	/**
	 * The operation id for the '<em>Detach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR___DETACH = LAYER_EXPRESSION___DETACH;

	/**
	 * The operation id for the '<em>Exit Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR___EXIT_ATTACHED_STATE = LAYER_EXPRESSION___EXIT_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Add Layer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR___ADD_LAYER__LAYEREXPRESSION = LAYER_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Layer Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_OPERATION_COUNT = LAYER_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AbstractLayerOperatorImpl <em>Abstract Layer Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AbstractLayerOperatorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getAbstractLayerOperator()
	 * @generated
	 */
	int ABSTRACT_LAYER_OPERATOR = 24;

	/**
	 * The feature id for the '<em><b>Application</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR__APPLICATION = LAYER_OPERATOR__APPLICATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR__NAME = LAYER_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR__DESCRIPTION = LAYER_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR__IS_LAYER_ENABLED_INTERNAL = LAYER_OPERATOR__IS_LAYER_ENABLED_INTERNAL;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR__IS_LAYER_ENABLED = LAYER_OPERATOR__IS_LAYER_ENABLED;

	/**
	 * The feature id for the '<em><b>Is Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR__IS_BRANCH_ENABLED = LAYER_OPERATOR__IS_BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Owning Layers Stack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR__OWNING_LAYERS_STACK = LAYER_OPERATOR__OWNING_LAYERS_STACK;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR__STATE = LAYER_OPERATOR__STATE;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR__LAYERS = LAYER_OPERATOR__LAYERS;

	/**
	 * The feature id for the '<em><b>Layer Operator Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR = LAYER_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Layer Operator Descriptor Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME = LAYER_OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Layer Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR_FEATURE_COUNT = LAYER_OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY = LAYER_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY;

	/**
	 * The operation id for the '<em>Get Views Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY = LAYER_OPERATOR___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY;

	/**
	 * The operation id for the '<em>Get Properties Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST = LAYER_OPERATOR___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST;

	/**
	 * The operation id for the '<em>Attach To Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR___ATTACH_TO_LAYERS_STACK__LAYERSSTACK = LAYER_OPERATOR___ATTACH_TO_LAYERS_STACK__LAYERSSTACK;

	/**
	 * The operation id for the '<em>Get Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR___GET_LAYERS_STACK = LAYER_OPERATOR___GET_LAYERS_STACK;

	/**
	 * The operation id for the '<em>Enter Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR___ENTER_ATTACHED_STATE = LAYER_OPERATOR___ENTER_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Attach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR___ATTACH = LAYER_OPERATOR___ATTACH;

	/**
	 * The operation id for the '<em>Detach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR___DETACH = LAYER_OPERATOR___DETACH;

	/**
	 * The operation id for the '<em>Exit Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR___EXIT_ATTACHED_STATE = LAYER_OPERATOR___EXIT_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Add Layer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR___ADD_LAYER__LAYEREXPRESSION = LAYER_OPERATOR___ADD_LAYER__LAYEREXPRESSION;

	/**
	 * The operation id for the '<em>Is Descriptor Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR___IS_DESCRIPTOR_SET = LAYER_OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Reset Descriptor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR___RESET_DESCRIPTOR = LAYER_OPERATOR_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Layer Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATOR_OPERATION_COUNT = LAYER_OPERATOR_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.DefaultPropertyOperatorImpl <em>Default Property Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.DefaultPropertyOperatorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getDefaultPropertyOperator()
	 * @generated
	 */
	int DEFAULT_PROPERTY_OPERATOR = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTY_OPERATOR__NAME = PROPERTY_OPERATOR__NAME;

	/**
	 * The number of structural features of the '<em>Default Property Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTY_OPERATOR_FEATURE_COUNT = PROPERTY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTY_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST = PROPERTY_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST;

	/**
	 * The number of operations of the '<em>Default Property Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTY_OPERATOR_OPERATION_COUNT = PROPERTY_OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AbstractLayerImpl <em>Abstract Layer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AbstractLayerImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getAbstractLayer()
	 * @generated
	 */
	int ABSTRACT_LAYER = 28;

	/**
	 * The feature id for the '<em><b>Application</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER__APPLICATION = LAYER_EXPRESSION__APPLICATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER__NAME = LAYER_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER__DESCRIPTION = LAYER_EXPRESSION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER__IS_LAYER_ENABLED_INTERNAL = LAYER_EXPRESSION__IS_LAYER_ENABLED_INTERNAL;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER__IS_LAYER_ENABLED = LAYER_EXPRESSION__IS_LAYER_ENABLED;

	/**
	 * The feature id for the '<em><b>Is Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER__IS_BRANCH_ENABLED = LAYER_EXPRESSION__IS_BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Owning Layers Stack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER__OWNING_LAYERS_STACK = LAYER_EXPRESSION__OWNING_LAYERS_STACK;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER__STATE = LAYER_EXPRESSION__STATE;

	/**
	 * The feature id for the '<em><b>Property Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER__PROPERTY_VALUES = LAYER_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Value Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER__PROPERTY_VALUE_MAP = LAYER_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Layer Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER__LAYER_DESCRIPTOR = LAYER_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Views</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER__VIEWS = LAYER_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Attached Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER__ATTACHED_PROPERTIES = LAYER_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Abstract Layer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_FEATURE_COUNT = LAYER_EXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY = LAYER_EXPRESSION___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY;

	/**
	 * The operation id for the '<em>Get Views Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY = LAYER_EXPRESSION___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY;

	/**
	 * The operation id for the '<em>Get Properties Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST = LAYER_EXPRESSION___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST;

	/**
	 * The operation id for the '<em>Attach To Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER___ATTACH_TO_LAYERS_STACK__LAYERSSTACK = LAYER_EXPRESSION___ATTACH_TO_LAYERS_STACK__LAYERSSTACK;

	/**
	 * The operation id for the '<em>Get Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER___GET_LAYERS_STACK = LAYER_EXPRESSION___GET_LAYERS_STACK;

	/**
	 * The operation id for the '<em>Enter Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER___ENTER_ATTACHED_STATE = LAYER_EXPRESSION___ENTER_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Attach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER___ATTACH = LAYER_EXPRESSION___ATTACH;

	/**
	 * The operation id for the '<em>Detach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER___DETACH = LAYER_EXPRESSION___DETACH;

	/**
	 * The operation id for the '<em>Exit Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER___EXIT_ATTACHED_STATE = LAYER_EXPRESSION___EXIT_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Add Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER___ADD_PROPERTY_INSTANCE__PROPERTY = LAYER_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Remove Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER___REMOVE_PROPERTY_INSTANCE__PROPERTY = LAYER_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__PROPERTY = LAYER_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__STRING = LAYER_EXPRESSION_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Abstract Layer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LAYER_OPERATION_COUNT = LAYER_EXPRESSION_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToTypeInstanceMapImpl <em>String To Type Instance Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToTypeInstanceMapImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStringToTypeInstanceMap()
	 * @generated
	 */
	int STRING_TO_TYPE_INSTANCE_MAP = 29;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_TYPE_INSTANCE_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_TYPE_INSTANCE_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Type Instance Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_TYPE_INSTANCE_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Type Instance Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_TYPE_INSTANCE_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FolderImpl <em>Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FolderImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFolder()
	 * @generated
	 */
	int FOLDER = 30;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__ELEMENTS = FOLDER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__NAME = FOLDER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_FEATURE_COUNT = FOLDER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_OPERATION_COUNT = FOLDER_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IntInstanceImpl <em>Int Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IntInstanceImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getIntInstance()
	 * @generated
	 */
	int INT_INSTANCE = 31;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_INSTANCE__VALUE = TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_INSTANCE_FEATURE_COUNT = TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Cmd Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_INSTANCE___GET_CMD_VALUE = TYPE_INSTANCE___GET_CMD_VALUE;

	/**
	 * The operation id for the '<em>Set Value From String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_INSTANCE___SET_VALUE_FROM_STRING__STRING = TYPE_INSTANCE___SET_VALUE_FROM_STRING__STRING;

	/**
	 * The operation id for the '<em>Set Value From Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE = TYPE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>Int Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_INSTANCE_OPERATION_COUNT = TYPE_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.BooleanInstanceImpl <em>Boolean Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.BooleanInstanceImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getBooleanInstance()
	 * @generated
	 */
	int BOOLEAN_INSTANCE = 32;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_INSTANCE__VALUE = TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_INSTANCE_FEATURE_COUNT = TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Cmd Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_INSTANCE___GET_CMD_VALUE = TYPE_INSTANCE___GET_CMD_VALUE;

	/**
	 * The operation id for the '<em>Set Value From String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_INSTANCE___SET_VALUE_FROM_STRING__STRING = TYPE_INSTANCE___SET_VALUE_FROM_STRING__STRING;

	/**
	 * The operation id for the '<em>Set Value From Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE = TYPE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>Boolean Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_INSTANCE_OPERATION_COUNT = TYPE_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringInstanceImpl <em>String Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringInstanceImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStringInstance()
	 * @generated
	 */
	int STRING_INSTANCE = 33;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INSTANCE__VALUE = TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INSTANCE_FEATURE_COUNT = TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Cmd Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INSTANCE___GET_CMD_VALUE = TYPE_INSTANCE___GET_CMD_VALUE;

	/**
	 * The operation id for the '<em>Set Value From String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INSTANCE___SET_VALUE_FROM_STRING__STRING = TYPE_INSTANCE___SET_VALUE_FROM_STRING__STRING;

	/**
	 * The operation id for the '<em>Set Value From Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE = TYPE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>String Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INSTANCE_OPERATION_COUNT = TYPE_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IntTypeImpl <em>Int Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IntTypeImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getIntType()
	 * @generated
	 */
	int INT_TYPE = 34;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TYPE__METAMODEL = TYPE__METAMODEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TYPE__DESCRIPTION = TYPE__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Int Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TYPE___CREATE_INSTANCE = TYPE___CREATE_INSTANCE;

	/**
	 * The number of operations of the '<em>Int Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.BooleanTypeImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 35;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__METAMODEL = TYPE__METAMODEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__DESCRIPTION = TYPE__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE___CREATE_INSTANCE = TYPE___CREATE_INSTANCE;

	/**
	 * The number of operations of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringTypeImpl <em>String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringTypeImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStringType()
	 * @generated
	 */
	int STRING_TYPE = 36;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__METAMODEL = TYPE__METAMODEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__DESCRIPTION = TYPE__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE___CREATE_INSTANCE = TYPE___CREATE_INSTANCE;

	/**
	 * The number of operations of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CustomTypeImpl <em>Custom Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CustomTypeImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCustomType()
	 * @generated
	 */
	int CUSTOM_TYPE = 37;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_TYPE__METAMODEL = TYPE__METAMODEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_TYPE__DESCRIPTION = TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_TYPE__CLASSIFIER = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Custom Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_TYPE___CREATE_INSTANCE = TYPE___CREATE_INSTANCE;

	/**
	 * The number of operations of the '<em>Custom Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TopLayerOperatorImpl <em>Top Layer Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TopLayerOperatorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getTopLayerOperator()
	 * @generated
	 */
	int TOP_LAYER_OPERATOR = 38;

	/**
	 * The feature id for the '<em><b>Application</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR__APPLICATION = ABSTRACT_LAYER_OPERATOR__APPLICATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR__NAME = ABSTRACT_LAYER_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR__DESCRIPTION = ABSTRACT_LAYER_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR__IS_LAYER_ENABLED_INTERNAL = ABSTRACT_LAYER_OPERATOR__IS_LAYER_ENABLED_INTERNAL;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR__IS_LAYER_ENABLED = ABSTRACT_LAYER_OPERATOR__IS_LAYER_ENABLED;

	/**
	 * The feature id for the '<em><b>Is Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR__IS_BRANCH_ENABLED = ABSTRACT_LAYER_OPERATOR__IS_BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Owning Layers Stack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR__OWNING_LAYERS_STACK = ABSTRACT_LAYER_OPERATOR__OWNING_LAYERS_STACK;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR__STATE = ABSTRACT_LAYER_OPERATOR__STATE;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR__LAYERS = ABSTRACT_LAYER_OPERATOR__LAYERS;

	/**
	 * The feature id for the '<em><b>Layer Operator Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR = ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Layer Operator Descriptor Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME = ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME;

	/**
	 * The number of structural features of the '<em>Top Layer Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR_FEATURE_COUNT = ABSTRACT_LAYER_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY = ABSTRACT_LAYER_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY;

	/**
	 * The operation id for the '<em>Get Views Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY = ABSTRACT_LAYER_OPERATOR___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY;

	/**
	 * The operation id for the '<em>Get Properties Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST = ABSTRACT_LAYER_OPERATOR___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST;

	/**
	 * The operation id for the '<em>Attach To Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR___ATTACH_TO_LAYERS_STACK__LAYERSSTACK = ABSTRACT_LAYER_OPERATOR___ATTACH_TO_LAYERS_STACK__LAYERSSTACK;

	/**
	 * The operation id for the '<em>Get Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR___GET_LAYERS_STACK = ABSTRACT_LAYER_OPERATOR___GET_LAYERS_STACK;

	/**
	 * The operation id for the '<em>Enter Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR___ENTER_ATTACHED_STATE = ABSTRACT_LAYER_OPERATOR___ENTER_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Attach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR___ATTACH = ABSTRACT_LAYER_OPERATOR___ATTACH;

	/**
	 * The operation id for the '<em>Detach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR___DETACH = ABSTRACT_LAYER_OPERATOR___DETACH;

	/**
	 * The operation id for the '<em>Exit Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR___EXIT_ATTACHED_STATE = ABSTRACT_LAYER_OPERATOR___EXIT_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Add Layer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR___ADD_LAYER__LAYEREXPRESSION = ABSTRACT_LAYER_OPERATOR___ADD_LAYER__LAYEREXPRESSION;

	/**
	 * The operation id for the '<em>Is Descriptor Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR___IS_DESCRIPTOR_SET = ABSTRACT_LAYER_OPERATOR___IS_DESCRIPTOR_SET;

	/**
	 * The operation id for the '<em>Reset Descriptor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR___RESET_DESCRIPTOR = ABSTRACT_LAYER_OPERATOR___RESET_DESCRIPTOR;

	/**
	 * The number of operations of the '<em>Top Layer Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR_OPERATION_COUNT = ABSTRACT_LAYER_OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StackedLayerOperatorImpl <em>Stacked Layer Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StackedLayerOperatorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStackedLayerOperator()
	 * @generated
	 */
	int STACKED_LAYER_OPERATOR = 39;

	/**
	 * The feature id for the '<em><b>Application</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR__APPLICATION = ABSTRACT_LAYER_OPERATOR__APPLICATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR__NAME = ABSTRACT_LAYER_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR__DESCRIPTION = ABSTRACT_LAYER_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR__IS_LAYER_ENABLED_INTERNAL = ABSTRACT_LAYER_OPERATOR__IS_LAYER_ENABLED_INTERNAL;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR__IS_LAYER_ENABLED = ABSTRACT_LAYER_OPERATOR__IS_LAYER_ENABLED;

	/**
	 * The feature id for the '<em><b>Is Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR__IS_BRANCH_ENABLED = ABSTRACT_LAYER_OPERATOR__IS_BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Owning Layers Stack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR__OWNING_LAYERS_STACK = ABSTRACT_LAYER_OPERATOR__OWNING_LAYERS_STACK;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR__STATE = ABSTRACT_LAYER_OPERATOR__STATE;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR__LAYERS = ABSTRACT_LAYER_OPERATOR__LAYERS;

	/**
	 * The feature id for the '<em><b>Layer Operator Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR = ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Layer Operator Descriptor Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME = ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME;

	/**
	 * The number of structural features of the '<em>Stacked Layer Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR_FEATURE_COUNT = ABSTRACT_LAYER_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY = ABSTRACT_LAYER_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY;

	/**
	 * The operation id for the '<em>Get Views Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY = ABSTRACT_LAYER_OPERATOR___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY;

	/**
	 * The operation id for the '<em>Get Properties Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST = ABSTRACT_LAYER_OPERATOR___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST;

	/**
	 * The operation id for the '<em>Attach To Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR___ATTACH_TO_LAYERS_STACK__LAYERSSTACK = ABSTRACT_LAYER_OPERATOR___ATTACH_TO_LAYERS_STACK__LAYERSSTACK;

	/**
	 * The operation id for the '<em>Get Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR___GET_LAYERS_STACK = ABSTRACT_LAYER_OPERATOR___GET_LAYERS_STACK;

	/**
	 * The operation id for the '<em>Enter Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR___ENTER_ATTACHED_STATE = ABSTRACT_LAYER_OPERATOR___ENTER_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Attach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR___ATTACH = ABSTRACT_LAYER_OPERATOR___ATTACH;

	/**
	 * The operation id for the '<em>Detach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR___DETACH = ABSTRACT_LAYER_OPERATOR___DETACH;

	/**
	 * The operation id for the '<em>Exit Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR___EXIT_ATTACHED_STATE = ABSTRACT_LAYER_OPERATOR___EXIT_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Add Layer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR___ADD_LAYER__LAYEREXPRESSION = ABSTRACT_LAYER_OPERATOR___ADD_LAYER__LAYEREXPRESSION;

	/**
	 * The operation id for the '<em>Is Descriptor Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR___IS_DESCRIPTOR_SET = ABSTRACT_LAYER_OPERATOR___IS_DESCRIPTOR_SET;

	/**
	 * The operation id for the '<em>Reset Descriptor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR___RESET_DESCRIPTOR = ABSTRACT_LAYER_OPERATOR___RESET_DESCRIPTOR;

	/**
	 * The number of operations of the '<em>Stacked Layer Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR_OPERATION_COUNT = ABSTRACT_LAYER_OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CustomLayerOperatorImpl <em>Custom Layer Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CustomLayerOperatorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCustomLayerOperator()
	 * @generated
	 */
	int CUSTOM_LAYER_OPERATOR = 40;

	/**
	 * The feature id for the '<em><b>Application</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR__APPLICATION = LAYER_OPERATOR__APPLICATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR__NAME = LAYER_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR__DESCRIPTION = LAYER_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR__IS_LAYER_ENABLED_INTERNAL = LAYER_OPERATOR__IS_LAYER_ENABLED_INTERNAL;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR__IS_LAYER_ENABLED = LAYER_OPERATOR__IS_LAYER_ENABLED;

	/**
	 * The feature id for the '<em><b>Is Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR__IS_BRANCH_ENABLED = LAYER_OPERATOR__IS_BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Owning Layers Stack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR__OWNING_LAYERS_STACK = LAYER_OPERATOR__OWNING_LAYERS_STACK;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR__STATE = LAYER_OPERATOR__STATE;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR__LAYERS = LAYER_OPERATOR__LAYERS;

	/**
	 * The number of structural features of the '<em>Custom Layer Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR_FEATURE_COUNT = LAYER_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY = LAYER_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY;

	/**
	 * The operation id for the '<em>Get Views Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY = LAYER_OPERATOR___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY;

	/**
	 * The operation id for the '<em>Get Properties Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST = LAYER_OPERATOR___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST;

	/**
	 * The operation id for the '<em>Attach To Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR___ATTACH_TO_LAYERS_STACK__LAYERSSTACK = LAYER_OPERATOR___ATTACH_TO_LAYERS_STACK__LAYERSSTACK;

	/**
	 * The operation id for the '<em>Get Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR___GET_LAYERS_STACK = LAYER_OPERATOR___GET_LAYERS_STACK;

	/**
	 * The operation id for the '<em>Enter Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR___ENTER_ATTACHED_STATE = LAYER_OPERATOR___ENTER_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Attach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR___ATTACH = LAYER_OPERATOR___ATTACH;

	/**
	 * The operation id for the '<em>Detach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR___DETACH = LAYER_OPERATOR___DETACH;

	/**
	 * The operation id for the '<em>Exit Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR___EXIT_ATTACHED_STATE = LAYER_OPERATOR___EXIT_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Add Layer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR___ADD_LAYER__LAYEREXPRESSION = LAYER_OPERATOR___ADD_LAYER__LAYEREXPRESSION;

	/**
	 * The number of operations of the '<em>Custom Layer Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_LAYER_OPERATOR_OPERATION_COUNT = LAYER_OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyIndexImpl <em>Property Index</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyIndexImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getPropertyIndex()
	 * @generated
	 */
	int PROPERTY_INDEX = 41;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INDEX__PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INDEX__INDEX = 1;

	/**
	 * The number of structural features of the '<em>Property Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INDEX_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Property Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INDEX_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToPropertyIndexMapImpl <em>String To Property Index Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToPropertyIndexMapImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStringToPropertyIndexMap()
	 * @generated
	 */
	int STRING_TO_PROPERTY_INDEX_MAP = 42;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_PROPERTY_INDEX_MAP__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_PROPERTY_INDEX_MAP__KEY = 1;

	/**
	 * The number of structural features of the '<em>String To Property Index Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_PROPERTY_INDEX_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Property Index Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_PROPERTY_INDEX_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.SimpleLayerDescriptorImpl <em>Simple Layer Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.SimpleLayerDescriptorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getSimpleLayerDescriptor()
	 * @generated
	 */
	int SIMPLE_LAYER_DESCRIPTOR = 43;

	/**
	 * The feature id for the '<em><b>Property Registry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_LAYER_DESCRIPTOR__PROPERTY_REGISTRY = LAYER_DESCRIPTOR__PROPERTY_REGISTRY;

	/**
	 * The number of structural features of the '<em>Simple Layer Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_LAYER_DESCRIPTOR_FEATURE_COUNT = LAYER_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Simple Layer Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_LAYER_DESCRIPTOR_OPERATION_COUNT = LAYER_DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.RegExpLayerDescriptorImpl <em>Reg Exp Layer Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.RegExpLayerDescriptorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getRegExpLayerDescriptor()
	 * @generated
	 */
	int REG_EXP_LAYER_DESCRIPTOR = 44;

	/**
	 * The feature id for the '<em><b>Property Registry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER_DESCRIPTOR__PROPERTY_REGISTRY = LAYER_DESCRIPTOR__PROPERTY_REGISTRY;

	/**
	 * The number of structural features of the '<em>Reg Exp Layer Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER_DESCRIPTOR_FEATURE_COUNT = LAYER_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reg Exp Layer Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER_DESCRIPTOR_OPERATION_COUNT = LAYER_DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.NullInstanceImpl <em>Null Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.NullInstanceImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getNullInstance()
	 * @generated
	 */
	int NULL_INSTANCE = 45;

	/**
	 * The number of structural features of the '<em>Null Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_INSTANCE_FEATURE_COUNT = TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Cmd Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_INSTANCE___GET_CMD_VALUE = TYPE_INSTANCE___GET_CMD_VALUE;

	/**
	 * The operation id for the '<em>Set Value From String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_INSTANCE___SET_VALUE_FROM_STRING__STRING = TYPE_INSTANCE___SET_VALUE_FROM_STRING__STRING;

	/**
	 * The operation id for the '<em>Set Value From Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE = TYPE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE;

	/**
	 * The operation id for the '<em>Get Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_INSTANCE___GET_INSTANCE = TYPE_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Null Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_INSTANCE_OPERATION_COUNT = TYPE_INSTANCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.RegExpLayerImpl <em>Reg Exp Layer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.RegExpLayerImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getRegExpLayer()
	 * @generated
	 */
	int REG_EXP_LAYER = 46;

	/**
	 * The feature id for the '<em><b>Application</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__APPLICATION = ABSTRACT_LAYER__APPLICATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__NAME = ABSTRACT_LAYER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__DESCRIPTION = ABSTRACT_LAYER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__IS_LAYER_ENABLED_INTERNAL = ABSTRACT_LAYER__IS_LAYER_ENABLED_INTERNAL;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__IS_LAYER_ENABLED = ABSTRACT_LAYER__IS_LAYER_ENABLED;

	/**
	 * The feature id for the '<em><b>Is Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__IS_BRANCH_ENABLED = ABSTRACT_LAYER__IS_BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Owning Layers Stack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__OWNING_LAYERS_STACK = ABSTRACT_LAYER__OWNING_LAYERS_STACK;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__STATE = ABSTRACT_LAYER__STATE;

	/**
	 * The feature id for the '<em><b>Property Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__PROPERTY_VALUES = ABSTRACT_LAYER__PROPERTY_VALUES;

	/**
	 * The feature id for the '<em><b>Property Value Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__PROPERTY_VALUE_MAP = ABSTRACT_LAYER__PROPERTY_VALUE_MAP;

	/**
	 * The feature id for the '<em><b>Layer Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__LAYER_DESCRIPTOR = ABSTRACT_LAYER__LAYER_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Views</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__VIEWS = ABSTRACT_LAYER__VIEWS;

	/**
	 * The feature id for the '<em><b>Attached Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__ATTACHED_PROPERTIES = ABSTRACT_LAYER__ATTACHED_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__EXPR = ABSTRACT_LAYER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__LANGUAGE = ABSTRACT_LAYER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Domain Changed Event Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__IS_DOMAIN_CHANGED_EVENT_DEPENDANT = ABSTRACT_LAYER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Domain Changed Event Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__DOMAIN_CHANGED_EVENT_LEVEL = ABSTRACT_LAYER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Diagram Changed Event Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__IS_DIAGRAM_CHANGED_EVENT_DEPENDANT = ABSTRACT_LAYER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Diagram Changed Event Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__DIAGRAM_CHANGED_EVENT_LEVEL = ABSTRACT_LAYER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Expression Context Object Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER__EXPRESSION_CONTEXT_OBJECT_TYPE = ABSTRACT_LAYER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Reg Exp Layer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER_FEATURE_COUNT = ABSTRACT_LAYER_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY = ABSTRACT_LAYER___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY;

	/**
	 * The operation id for the '<em>Get Views Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY = ABSTRACT_LAYER___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY;

	/**
	 * The operation id for the '<em>Get Properties Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST = ABSTRACT_LAYER___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST;

	/**
	 * The operation id for the '<em>Attach To Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___ATTACH_TO_LAYERS_STACK__LAYERSSTACK = ABSTRACT_LAYER___ATTACH_TO_LAYERS_STACK__LAYERSSTACK;

	/**
	 * The operation id for the '<em>Get Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___GET_LAYERS_STACK = ABSTRACT_LAYER___GET_LAYERS_STACK;

	/**
	 * The operation id for the '<em>Enter Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___ENTER_ATTACHED_STATE = ABSTRACT_LAYER___ENTER_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Attach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___ATTACH = ABSTRACT_LAYER___ATTACH;

	/**
	 * The operation id for the '<em>Detach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___DETACH = ABSTRACT_LAYER___DETACH;

	/**
	 * The operation id for the '<em>Exit Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___EXIT_ATTACHED_STATE = ABSTRACT_LAYER___EXIT_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Add Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___ADD_PROPERTY_INSTANCE__PROPERTY = ABSTRACT_LAYER___ADD_PROPERTY_INSTANCE__PROPERTY;

	/**
	 * The operation id for the '<em>Remove Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___REMOVE_PROPERTY_INSTANCE__PROPERTY = ABSTRACT_LAYER___REMOVE_PROPERTY_INSTANCE__PROPERTY;

	/**
	 * The operation id for the '<em>Get Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___GET_PROPERTY_INSTANCE__PROPERTY = ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__PROPERTY;

	/**
	 * The operation id for the '<em>Get Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___GET_PROPERTY_INSTANCE__STRING = ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__STRING;

	/**
	 * The operation id for the '<em>Activate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___ACTIVATE__ABSTRACTLAYEROPERATOR = ABSTRACT_LAYER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Deactivate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___DEACTIVATE__ABSTRACTLAYEROPERATOR = ABSTRACT_LAYER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Derived View</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___IS_DERIVED_VIEW__VIEW = ABSTRACT_LAYER_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Attach Derived View</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___ATTACH_DERIVED_VIEW__VIEW = ABSTRACT_LAYER_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Attach Derived Views</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___ATTACH_DERIVED_VIEWS__ELIST = ABSTRACT_LAYER_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Attach Derived Views</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___ATTACH_DERIVED_VIEWS = ABSTRACT_LAYER_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Lookup Derived Views</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER___LOOKUP_DERIVED_VIEWS__ELIST = ABSTRACT_LAYER_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Reg Exp Layer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REG_EXP_LAYER_OPERATION_COUNT = ABSTRACT_LAYER_OPERATION_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerImpl <em>Layer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayer()
	 * @generated
	 */
	int LAYER = 47;

	/**
	 * The feature id for the '<em><b>Application</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__APPLICATION = ABSTRACT_LAYER__APPLICATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__NAME = ABSTRACT_LAYER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__DESCRIPTION = ABSTRACT_LAYER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__IS_LAYER_ENABLED_INTERNAL = ABSTRACT_LAYER__IS_LAYER_ENABLED_INTERNAL;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__IS_LAYER_ENABLED = ABSTRACT_LAYER__IS_LAYER_ENABLED;

	/**
	 * The feature id for the '<em><b>Is Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__IS_BRANCH_ENABLED = ABSTRACT_LAYER__IS_BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Owning Layers Stack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__OWNING_LAYERS_STACK = ABSTRACT_LAYER__OWNING_LAYERS_STACK;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__STATE = ABSTRACT_LAYER__STATE;

	/**
	 * The feature id for the '<em><b>Property Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__PROPERTY_VALUES = ABSTRACT_LAYER__PROPERTY_VALUES;

	/**
	 * The feature id for the '<em><b>Property Value Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__PROPERTY_VALUE_MAP = ABSTRACT_LAYER__PROPERTY_VALUE_MAP;

	/**
	 * The feature id for the '<em><b>Layer Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__LAYER_DESCRIPTOR = ABSTRACT_LAYER__LAYER_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Views</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__VIEWS = ABSTRACT_LAYER__VIEWS;

	/**
	 * The feature id for the '<em><b>Attached Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__ATTACHED_PROPERTIES = ABSTRACT_LAYER__ATTACHED_PROPERTIES;

	/**
	 * The number of structural features of the '<em>Layer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_FEATURE_COUNT = ABSTRACT_LAYER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY = ABSTRACT_LAYER___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY;

	/**
	 * The operation id for the '<em>Get Views Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY = ABSTRACT_LAYER___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY;

	/**
	 * The operation id for the '<em>Get Properties Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST = ABSTRACT_LAYER___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST;

	/**
	 * The operation id for the '<em>Attach To Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER___ATTACH_TO_LAYERS_STACK__LAYERSSTACK = ABSTRACT_LAYER___ATTACH_TO_LAYERS_STACK__LAYERSSTACK;

	/**
	 * The operation id for the '<em>Get Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER___GET_LAYERS_STACK = ABSTRACT_LAYER___GET_LAYERS_STACK;

	/**
	 * The operation id for the '<em>Enter Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER___ENTER_ATTACHED_STATE = ABSTRACT_LAYER___ENTER_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Attach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER___ATTACH = ABSTRACT_LAYER___ATTACH;

	/**
	 * The operation id for the '<em>Detach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER___DETACH = ABSTRACT_LAYER___DETACH;

	/**
	 * The operation id for the '<em>Exit Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER___EXIT_ATTACHED_STATE = ABSTRACT_LAYER___EXIT_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Add Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER___ADD_PROPERTY_INSTANCE__PROPERTY = ABSTRACT_LAYER___ADD_PROPERTY_INSTANCE__PROPERTY;

	/**
	 * The operation id for the '<em>Remove Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER___REMOVE_PROPERTY_INSTANCE__PROPERTY = ABSTRACT_LAYER___REMOVE_PROPERTY_INSTANCE__PROPERTY;

	/**
	 * The operation id for the '<em>Get Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER___GET_PROPERTY_INSTANCE__PROPERTY = ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__PROPERTY;

	/**
	 * The operation id for the '<em>Get Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER___GET_PROPERTY_INSTANCE__STRING = ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__STRING;

	/**
	 * The number of operations of the '<em>Layer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATION_COUNT = ABSTRACT_LAYER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.ColorImpl <em>Color</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.ColorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getColor()
	 * @generated
	 */
	int COLOR = 48;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR__METAMODEL = TYPE__METAMODEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR__DESCRIPTION = TYPE__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Color</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR___CREATE_INSTANCE = TYPE___CREATE_INSTANCE;

	/**
	 * The number of operations of the '<em>Color</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.ColorInstanceImpl <em>Color Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.ColorInstanceImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getColorInstance()
	 * @generated
	 */
	int COLOR_INSTANCE = 49;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_INSTANCE__VALUE = TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Color Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_INSTANCE_FEATURE_COUNT = TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Cmd Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_INSTANCE___GET_CMD_VALUE = TYPE_INSTANCE___GET_CMD_VALUE;

	/**
	 * The operation id for the '<em>Set Value From String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_INSTANCE___SET_VALUE_FROM_STRING__STRING = TYPE_INSTANCE___SET_VALUE_FROM_STRING__STRING;

	/**
	 * The operation id for the '<em>Set Value From Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE = TYPE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>Color Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_INSTANCE_OPERATION_COUNT = TYPE_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FillInstanceImpl <em>Fill Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FillInstanceImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFillInstance()
	 * @generated
	 */
	int FILL_INSTANCE = 50;

	/**
	 * The feature id for the '<em><b>Transparency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_INSTANCE__TRANSPARENCY = TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fill Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_INSTANCE__FILL_COLOR = TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Fill Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_INSTANCE_FEATURE_COUNT = TYPE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Cmd Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_INSTANCE___GET_CMD_VALUE = TYPE_INSTANCE___GET_CMD_VALUE;

	/**
	 * The operation id for the '<em>Set Value From String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_INSTANCE___SET_VALUE_FROM_STRING__STRING = TYPE_INSTANCE___SET_VALUE_FROM_STRING__STRING;

	/**
	 * The operation id for the '<em>Set Value From Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE = TYPE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>Fill Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_INSTANCE_OPERATION_COUNT = TYPE_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FillImpl <em>Fill</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FillImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFill()
	 * @generated
	 */
	int FILL = 51;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL__METAMODEL = TYPE__METAMODEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL__DESCRIPTION = TYPE__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Fill</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL___CREATE_INSTANCE = TYPE___CREATE_INSTANCE;

	/**
	 * The number of operations of the '<em>Fill</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FillPropertySetterImpl <em>Fill Property Setter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FillPropertySetterImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFillPropertySetter()
	 * @generated
	 */
	int FILL_PROPERTY_SETTER = 52;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_PROPERTY_SETTER__PROPERTY = PROPERTY_SETTER__PROPERTY;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_PROPERTY_SETTER__PROPERTY_NAME = PROPERTY_SETTER__PROPERTY_NAME;

	/**
	 * The number of structural features of the '<em>Fill Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_PROPERTY_SETTER_FEATURE_COUNT = PROPERTY_SETTER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE = PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>Fill Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_PROPERTY_SETTER_OPERATION_COUNT = PROPERTY_SETTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IsValidPropertySetterImpl <em>Is Valid Property Setter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IsValidPropertySetterImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getIsValidPropertySetter()
	 * @generated
	 */
	int IS_VALID_PROPERTY_SETTER = 53;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_VALID_PROPERTY_SETTER__PROPERTY = PROPERTY_SETTER__PROPERTY;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_VALID_PROPERTY_SETTER__PROPERTY_NAME = PROPERTY_SETTER__PROPERTY_NAME;

	/**
	 * The number of structural features of the '<em>Is Valid Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_VALID_PROPERTY_SETTER_FEATURE_COUNT = PROPERTY_SETTER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_VALID_PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE = PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>Is Valid Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_VALID_PROPERTY_SETTER_OPERATION_COUNT = PROPERTY_SETTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.NullPropertySetterImpl <em>Null Property Setter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.NullPropertySetterImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getNullPropertySetter()
	 * @generated
	 */
	int NULL_PROPERTY_SETTER = 54;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_PROPERTY_SETTER__PROPERTY = PROPERTY_SETTER__PROPERTY;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_PROPERTY_SETTER__PROPERTY_NAME = PROPERTY_SETTER__PROPERTY_NAME;

	/**
	 * The number of structural features of the '<em>Null Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_PROPERTY_SETTER_FEATURE_COUNT = PROPERTY_SETTER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE = PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>Null Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_PROPERTY_SETTER_OPERATION_COUNT = PROPERTY_SETTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LineTypeImpl <em>Line Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LineTypeImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLineType()
	 * @generated
	 */
	int LINE_TYPE = 55;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_TYPE__METAMODEL = TYPE__METAMODEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_TYPE__DESCRIPTION = TYPE__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Line Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_TYPE___CREATE_INSTANCE = TYPE___CREATE_INSTANCE;

	/**
	 * The number of operations of the '<em>Line Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LineInstanceImpl <em>Line Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LineInstanceImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLineInstance()
	 * @generated
	 */
	int LINE_INSTANCE = 56;

	/**
	 * The feature id for the '<em><b>Line Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_INSTANCE__LINE_COLOR = TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_INSTANCE__LINE_WITH = TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Line Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_INSTANCE_FEATURE_COUNT = TYPE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Cmd Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_INSTANCE___GET_CMD_VALUE = TYPE_INSTANCE___GET_CMD_VALUE;

	/**
	 * The operation id for the '<em>Set Value From String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_INSTANCE___SET_VALUE_FROM_STRING__STRING = TYPE_INSTANCE___SET_VALUE_FROM_STRING__STRING;

	/**
	 * The operation id for the '<em>Set Value From Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE = TYPE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>Line Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_INSTANCE_OPERATION_COUNT = TYPE_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LinePropertySetterImpl <em>Line Property Setter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LinePropertySetterImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLinePropertySetter()
	 * @generated
	 */
	int LINE_PROPERTY_SETTER = 57;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_PROPERTY_SETTER__PROPERTY = PROPERTY_SETTER__PROPERTY;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_PROPERTY_SETTER__PROPERTY_NAME = PROPERTY_SETTER__PROPERTY_NAME;

	/**
	 * The number of structural features of the '<em>Line Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_PROPERTY_SETTER_FEATURE_COUNT = PROPERTY_SETTER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE = PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>Line Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_PROPERTY_SETTER_OPERATION_COUNT = PROPERTY_SETTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FontPropertySetterImpl <em>Font Property Setter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FontPropertySetterImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFontPropertySetter()
	 * @generated
	 */
	int FONT_PROPERTY_SETTER = 58;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_PROPERTY_SETTER__PROPERTY = PROPERTY_SETTER__PROPERTY;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_PROPERTY_SETTER__PROPERTY_NAME = PROPERTY_SETTER__PROPERTY_NAME;

	/**
	 * The number of structural features of the '<em>Font Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_PROPERTY_SETTER_FEATURE_COUNT = PROPERTY_SETTER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE = PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>Font Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_PROPERTY_SETTER_OPERATION_COUNT = PROPERTY_SETTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FontInstanceImpl <em>Font Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FontInstanceImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFontInstance()
	 * @generated
	 */
	int FONT_INSTANCE = 59;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_INSTANCE__FONT_COLOR = TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Font Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_INSTANCE__FONT_NAME = TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Font Heigh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_INSTANCE__FONT_HEIGH = TYPE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_INSTANCE__BOLD = TYPE_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Font Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_INSTANCE_FEATURE_COUNT = TYPE_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Cmd Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_INSTANCE___GET_CMD_VALUE = TYPE_INSTANCE___GET_CMD_VALUE;

	/**
	 * The operation id for the '<em>Set Value From String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_INSTANCE___SET_VALUE_FROM_STRING__STRING = TYPE_INSTANCE___SET_VALUE_FROM_STRING__STRING;

	/**
	 * The operation id for the '<em>Set Value From Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE = TYPE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>Font Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_INSTANCE_OPERATION_COUNT = TYPE_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FontTypeImpl <em>Font Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FontTypeImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFontType()
	 * @generated
	 */
	int FONT_TYPE = 60;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TYPE__METAMODEL = TYPE__METAMODEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TYPE__DESCRIPTION = TYPE__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Font Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TYPE___CREATE_INSTANCE = TYPE___CREATE_INSTANCE;

	/**
	 * The number of operations of the '<em>Font Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IsVisiblePropertySetterImpl <em>Is Visible Property Setter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IsVisiblePropertySetterImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getIsVisiblePropertySetter()
	 * @generated
	 */
	int IS_VISIBLE_PROPERTY_SETTER = 61;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_VISIBLE_PROPERTY_SETTER__PROPERTY = PROPERTY_SETTER__PROPERTY;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_VISIBLE_PROPERTY_SETTER__PROPERTY_NAME = PROPERTY_SETTER__PROPERTY_NAME;

	/**
	 * The number of structural features of the '<em>Is Visible Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_VISIBLE_PROPERTY_SETTER_FEATURE_COUNT = PROPERTY_SETTER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_VISIBLE_PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE = PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>Is Visible Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_VISIBLE_PROPERTY_SETTER_OPERATION_COUNT = PROPERTY_SETTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TopLayerOperatorDescriptorImpl <em>Top Layer Operator Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TopLayerOperatorDescriptorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getTopLayerOperatorDescriptor()
	 * @generated
	 */
	int TOP_LAYER_OPERATOR_DESCRIPTOR = 62;

	/**
	 * The feature id for the '<em><b>Property Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS = LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR_DESCRIPTOR__NAME = LAYER_OPERATOR_DESCRIPTOR__NAME;

	/**
	 * The number of structural features of the '<em>Top Layer Operator Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR_DESCRIPTOR_FEATURE_COUNT = LAYER_OPERATOR_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Property Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR_DESCRIPTOR___GET_PROPERTY_OPERATOR__PROPERTY = LAYER_OPERATOR_DESCRIPTOR___GET_PROPERTY_OPERATOR__PROPERTY;

	/**
	 * The operation id for the '<em>Set Property Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_OPERATOR__PROPERTY_PROPERTYOPERATOR = LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_OPERATOR__PROPERTY_PROPERTYOPERATOR;

	/**
	 * The operation id for the '<em>Create Layer Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR_DESCRIPTOR___CREATE_LAYER_OPERATOR = LAYER_OPERATOR_DESCRIPTOR___CREATE_LAYER_OPERATOR;

	/**
	 * The operation id for the '<em>Set Property Collection Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_COLLECTION_SIZE__INT_DEFAULTPROPERTYOPERATOR = LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_COLLECTION_SIZE__INT_DEFAULTPROPERTYOPERATOR;

	/**
	 * The number of operations of the '<em>Top Layer Operator Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LAYER_OPERATOR_DESCRIPTOR_OPERATION_COUNT = LAYER_OPERATOR_DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StackedLayerOperatorDescriptorImpl <em>Stacked Layer Operator Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StackedLayerOperatorDescriptorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStackedLayerOperatorDescriptor()
	 * @generated
	 */
	int STACKED_LAYER_OPERATOR_DESCRIPTOR = 63;

	/**
	 * The feature id for the '<em><b>Property Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS = LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR_DESCRIPTOR__NAME = LAYER_OPERATOR_DESCRIPTOR__NAME;

	/**
	 * The number of structural features of the '<em>Stacked Layer Operator Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR_DESCRIPTOR_FEATURE_COUNT = LAYER_OPERATOR_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Property Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR_DESCRIPTOR___GET_PROPERTY_OPERATOR__PROPERTY = LAYER_OPERATOR_DESCRIPTOR___GET_PROPERTY_OPERATOR__PROPERTY;

	/**
	 * The operation id for the '<em>Set Property Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_OPERATOR__PROPERTY_PROPERTYOPERATOR = LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_OPERATOR__PROPERTY_PROPERTYOPERATOR;

	/**
	 * The operation id for the '<em>Create Layer Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR_DESCRIPTOR___CREATE_LAYER_OPERATOR = LAYER_OPERATOR_DESCRIPTOR___CREATE_LAYER_OPERATOR;

	/**
	 * The operation id for the '<em>Set Property Collection Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_COLLECTION_SIZE__INT_DEFAULTPROPERTYOPERATOR = LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_COLLECTION_SIZE__INT_DEFAULTPROPERTYOPERATOR;

	/**
	 * The number of operations of the '<em>Stacked Layer Operator Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACKED_LAYER_OPERATOR_DESCRIPTOR_OPERATION_COUNT = LAYER_OPERATOR_DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CustomPropertyOperatorImpl <em>Custom Property Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CustomPropertyOperatorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCustomPropertyOperator()
	 * @generated
	 */
	int CUSTOM_PROPERTY_OPERATOR = 64;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROPERTY_OPERATOR__NAME = PROPERTY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROPERTY_OPERATOR__CLASSNAME = PROPERTY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROPERTY_OPERATOR__OPERATOR_INSTANCE = PROPERTY_OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Class Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROPERTY_OPERATOR__CLASS_BUNDLE_ID = PROPERTY_OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Custom Property Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROPERTY_OPERATOR_FEATURE_COUNT = PROPERTY_OPERATOR_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROPERTY_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST = PROPERTY_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST;

	/**
	 * The operation id for the '<em>Reset Operator Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROPERTY_OPERATOR___RESET_OPERATOR_INSTANCE = PROPERTY_OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Custom Property Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROPERTY_OPERATOR_OPERATION_COUNT = PROPERTY_OPERATOR_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AndStackedLayerOperatorDescriptorImpl <em>And Stacked Layer Operator Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AndStackedLayerOperatorDescriptorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getAndStackedLayerOperatorDescriptor()
	 * @generated
	 */
	int AND_STACKED_LAYER_OPERATOR_DESCRIPTOR = 65;

	/**
	 * The feature id for the '<em><b>Property Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_STACKED_LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS = STACKED_LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_STACKED_LAYER_OPERATOR_DESCRIPTOR__NAME = STACKED_LAYER_OPERATOR_DESCRIPTOR__NAME;

	/**
	 * The number of structural features of the '<em>And Stacked Layer Operator Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_STACKED_LAYER_OPERATOR_DESCRIPTOR_FEATURE_COUNT = STACKED_LAYER_OPERATOR_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Property Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_STACKED_LAYER_OPERATOR_DESCRIPTOR___GET_PROPERTY_OPERATOR__PROPERTY = STACKED_LAYER_OPERATOR_DESCRIPTOR___GET_PROPERTY_OPERATOR__PROPERTY;

	/**
	 * The operation id for the '<em>Set Property Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_STACKED_LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_OPERATOR__PROPERTY_PROPERTYOPERATOR = STACKED_LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_OPERATOR__PROPERTY_PROPERTYOPERATOR;

	/**
	 * The operation id for the '<em>Create Layer Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_STACKED_LAYER_OPERATOR_DESCRIPTOR___CREATE_LAYER_OPERATOR = STACKED_LAYER_OPERATOR_DESCRIPTOR___CREATE_LAYER_OPERATOR;

	/**
	 * The operation id for the '<em>Set Property Collection Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_STACKED_LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_COLLECTION_SIZE__INT_DEFAULTPROPERTYOPERATOR = STACKED_LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_COLLECTION_SIZE__INT_DEFAULTPROPERTYOPERATOR;

	/**
	 * The number of operations of the '<em>And Stacked Layer Operator Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_STACKED_LAYER_OPERATOR_DESCRIPTOR_OPERATION_COUNT = STACKED_LAYER_OPERATOR_DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.OrStackedLayerOperatorDescriptorImpl <em>Or Stacked Layer Operator Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.OrStackedLayerOperatorDescriptorImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getOrStackedLayerOperatorDescriptor()
	 * @generated
	 */
	int OR_STACKED_LAYER_OPERATOR_DESCRIPTOR = 66;

	/**
	 * The feature id for the '<em><b>Property Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_STACKED_LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS = STACKED_LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_STACKED_LAYER_OPERATOR_DESCRIPTOR__NAME = STACKED_LAYER_OPERATOR_DESCRIPTOR__NAME;

	/**
	 * The number of structural features of the '<em>Or Stacked Layer Operator Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_STACKED_LAYER_OPERATOR_DESCRIPTOR_FEATURE_COUNT = STACKED_LAYER_OPERATOR_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Property Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_STACKED_LAYER_OPERATOR_DESCRIPTOR___GET_PROPERTY_OPERATOR__PROPERTY = STACKED_LAYER_OPERATOR_DESCRIPTOR___GET_PROPERTY_OPERATOR__PROPERTY;

	/**
	 * The operation id for the '<em>Set Property Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_STACKED_LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_OPERATOR__PROPERTY_PROPERTYOPERATOR = STACKED_LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_OPERATOR__PROPERTY_PROPERTYOPERATOR;

	/**
	 * The operation id for the '<em>Create Layer Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_STACKED_LAYER_OPERATOR_DESCRIPTOR___CREATE_LAYER_OPERATOR = STACKED_LAYER_OPERATOR_DESCRIPTOR___CREATE_LAYER_OPERATOR;

	/**
	 * The operation id for the '<em>Set Property Collection Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_STACKED_LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_COLLECTION_SIZE__INT_DEFAULTPROPERTYOPERATOR = STACKED_LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_COLLECTION_SIZE__INT_DEFAULTPROPERTYOPERATOR;

	/**
	 * The number of operations of the '<em>Or Stacked Layer Operator Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_STACKED_LAYER_OPERATOR_DESCRIPTOR_OPERATION_COUNT = STACKED_LAYER_OPERATOR_DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IsAbstractUmlSetterImpl <em>Is Abstract Uml Setter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IsAbstractUmlSetterImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getIsAbstractUmlSetter()
	 * @generated
	 */
	int IS_ABSTRACT_UML_SETTER = 67;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_ABSTRACT_UML_SETTER__PROPERTY = PROPERTY_SETTER__PROPERTY;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_ABSTRACT_UML_SETTER__PROPERTY_NAME = PROPERTY_SETTER__PROPERTY_NAME;

	/**
	 * The number of structural features of the '<em>Is Abstract Uml Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_ABSTRACT_UML_SETTER_FEATURE_COUNT = PROPERTY_SETTER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_ABSTRACT_UML_SETTER___SET_VALUE__VIEW_TYPEINSTANCE = PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>Is Abstract Uml Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_ABSTRACT_UML_SETTER_OPERATION_COUNT = PROPERTY_SETTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AllViewsDerivedLayerImpl <em>All Views Derived Layer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AllViewsDerivedLayerImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getAllViewsDerivedLayer()
	 * @generated
	 */
	int ALL_VIEWS_DERIVED_LAYER = 68;

	/**
	 * The feature id for the '<em><b>Application</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER__APPLICATION = ABSTRACT_LAYER__APPLICATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER__NAME = ABSTRACT_LAYER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER__DESCRIPTION = ABSTRACT_LAYER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER__IS_LAYER_ENABLED_INTERNAL = ABSTRACT_LAYER__IS_LAYER_ENABLED_INTERNAL;

	/**
	 * The feature id for the '<em><b>Is Layer Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER__IS_LAYER_ENABLED = ABSTRACT_LAYER__IS_LAYER_ENABLED;

	/**
	 * The feature id for the '<em><b>Is Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER__IS_BRANCH_ENABLED = ABSTRACT_LAYER__IS_BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Owning Layers Stack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER__OWNING_LAYERS_STACK = ABSTRACT_LAYER__OWNING_LAYERS_STACK;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER__STATE = ABSTRACT_LAYER__STATE;

	/**
	 * The feature id for the '<em><b>Property Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER__PROPERTY_VALUES = ABSTRACT_LAYER__PROPERTY_VALUES;

	/**
	 * The feature id for the '<em><b>Property Value Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER__PROPERTY_VALUE_MAP = ABSTRACT_LAYER__PROPERTY_VALUE_MAP;

	/**
	 * The feature id for the '<em><b>Layer Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER__LAYER_DESCRIPTOR = ABSTRACT_LAYER__LAYER_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Views</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER__VIEWS = ABSTRACT_LAYER__VIEWS;

	/**
	 * The feature id for the '<em><b>Attached Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER__ATTACHED_PROPERTIES = ABSTRACT_LAYER__ATTACHED_PROPERTIES;

	/**
	 * The number of structural features of the '<em>All Views Derived Layer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER_FEATURE_COUNT = ABSTRACT_LAYER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY = ABSTRACT_LAYER___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY;

	/**
	 * The operation id for the '<em>Get Views Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY = ABSTRACT_LAYER___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY;

	/**
	 * The operation id for the '<em>Get Properties Compute Property Value Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST = ABSTRACT_LAYER___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST;

	/**
	 * The operation id for the '<em>Attach To Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER___ATTACH_TO_LAYERS_STACK__LAYERSSTACK = ABSTRACT_LAYER___ATTACH_TO_LAYERS_STACK__LAYERSSTACK;

	/**
	 * The operation id for the '<em>Get Layers Stack</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER___GET_LAYERS_STACK = ABSTRACT_LAYER___GET_LAYERS_STACK;

	/**
	 * The operation id for the '<em>Enter Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER___ENTER_ATTACHED_STATE = ABSTRACT_LAYER___ENTER_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Attach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER___ATTACH = ABSTRACT_LAYER___ATTACH;

	/**
	 * The operation id for the '<em>Detach</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER___DETACH = ABSTRACT_LAYER___DETACH;

	/**
	 * The operation id for the '<em>Exit Attached State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER___EXIT_ATTACHED_STATE = ABSTRACT_LAYER___EXIT_ATTACHED_STATE;

	/**
	 * The operation id for the '<em>Add Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER___ADD_PROPERTY_INSTANCE__PROPERTY = ABSTRACT_LAYER___ADD_PROPERTY_INSTANCE__PROPERTY;

	/**
	 * The operation id for the '<em>Remove Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER___REMOVE_PROPERTY_INSTANCE__PROPERTY = ABSTRACT_LAYER___REMOVE_PROPERTY_INSTANCE__PROPERTY;

	/**
	 * The operation id for the '<em>Get Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER___GET_PROPERTY_INSTANCE__PROPERTY = ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__PROPERTY;

	/**
	 * The operation id for the '<em>Get Property Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER___GET_PROPERTY_INSTANCE__STRING = ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__STRING;

	/**
	 * The number of operations of the '<em>All Views Derived Layer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_VIEWS_DERIVED_LAYER_OPERATION_COUNT = ABSTRACT_LAYER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSPropertySetterImpl <em>CSS Property Setter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSPropertySetterImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCSSPropertySetter()
	 * @generated
	 */
	int CSS_PROPERTY_SETTER = 69;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_PROPERTY_SETTER__PROPERTY = PROPERTY_SETTER__PROPERTY;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_PROPERTY_SETTER__PROPERTY_NAME = PROPERTY_SETTER__PROPERTY_NAME;

	/**
	 * The number of structural features of the '<em>CSS Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_PROPERTY_SETTER_FEATURE_COUNT = PROPERTY_SETTER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE = PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>CSS Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_PROPERTY_SETTER_OPERATION_COUNT = PROPERTY_SETTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSTypeImpl <em>CSS Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSTypeImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCSSType()
	 * @generated
	 */
	int CSS_TYPE = 70;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_TYPE__METAMODEL = TYPE__METAMODEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_TYPE__DESCRIPTION = TYPE__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>CSS Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_TYPE___CREATE_INSTANCE = TYPE___CREATE_INSTANCE;

	/**
	 * The number of operations of the '<em>CSS Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSInstanceImpl <em>CSS Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSInstanceImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCSSInstance()
	 * @generated
	 */
	int CSS_INSTANCE = 71;

	/**
	 * The feature id for the '<em><b>Stylesheet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_INSTANCE__STYLESHEET = TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_INSTANCE__STYLE = TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CSS Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_INSTANCE_FEATURE_COUNT = TYPE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Cmd Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_INSTANCE___GET_CMD_VALUE = TYPE_INSTANCE___GET_CMD_VALUE;

	/**
	 * The operation id for the '<em>Set Value From String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_INSTANCE___SET_VALUE_FROM_STRING__STRING = TYPE_INSTANCE___SET_VALUE_FROM_STRING__STRING;

	/**
	 * The operation id for the '<em>Set Value From Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE = TYPE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>CSS Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_INSTANCE_OPERATION_COUNT = TYPE_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHidePropertySetterImpl <em>CSS Hide Property Setter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHidePropertySetterImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCSSHidePropertySetter()
	 * @generated
	 */
	int CSS_HIDE_PROPERTY_SETTER = 72;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_PROPERTY_SETTER__PROPERTY = PROPERTY_SETTER__PROPERTY;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_PROPERTY_SETTER__PROPERTY_NAME = PROPERTY_SETTER__PROPERTY_NAME;

	/**
	 * The number of structural features of the '<em>CSS Hide Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_PROPERTY_SETTER_FEATURE_COUNT = PROPERTY_SETTER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE = PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>CSS Hide Property Setter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_PROPERTY_SETTER_OPERATION_COUNT = PROPERTY_SETTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHideTypeImpl <em>CSS Hide Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHideTypeImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCSSHideType()
	 * @generated
	 */
	int CSS_HIDE_TYPE = 73;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_TYPE__METAMODEL = TYPE__METAMODEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_TYPE__DESCRIPTION = TYPE__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>CSS Hide Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_TYPE___CREATE_INSTANCE = TYPE___CREATE_INSTANCE;

	/**
	 * The number of operations of the '<em>CSS Hide Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHideInstanceImpl <em>CSS Hide Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHideInstanceImpl
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCSSHideInstance()
	 * @generated
	 */
	int CSS_HIDE_INSTANCE = 74;

	/**
	 * The feature id for the '<em><b>Stylesheet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_INSTANCE__STYLESHEET = TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_INSTANCE__STYLE = TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CSS Hide Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_INSTANCE_FEATURE_COUNT = TYPE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Cmd Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_INSTANCE___GET_CMD_VALUE = TYPE_INSTANCE___GET_CMD_VALUE;

	/**
	 * The operation id for the '<em>Set Value From String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_INSTANCE___SET_VALUE_FROM_STRING__STRING = TYPE_INSTANCE___SET_VALUE_FROM_STRING__STRING;

	/**
	 * The operation id for the '<em>Set Value From Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE = TYPE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE;

	/**
	 * The number of operations of the '<em>CSS Hide Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSS_HIDE_INSTANCE_OPERATION_COUNT = TYPE_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerState <em>Layer State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerState
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerState()
	 * @generated
	 */
	int LAYER_STATE = 75;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.EventLevel <em>Event Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.EventLevel
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getEventLevel()
	 * @generated
	 */
	int EVENT_LEVEL = 76;

	/**
	 * The meta object id for the '<em>String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getString()
	 * @generated
	 */
	int STRING = 77;

	/**
	 * The meta object id for the '<em>boolean</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getboolean()
	 * @generated
	 */
	int BOOLEAN = 78;

	/**
	 * The meta object id for the '<em>EPackage</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getEPackage()
	 * @generated
	 */
	int EPACKAGE = 79;

	/**
	 * The meta object id for the '<em>Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayersException()
	 * @generated
	 */
	int LAYERS_EXCEPTION = 80;

	/**
	 * The meta object id for the '<em>int</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getint()
	 * @generated
	 */
	int INT = 81;

	/**
	 * The meta object id for the '<em>Bad State Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.BadStateException
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getBadStateException()
	 * @generated
	 */
	int BAD_STATE_EXCEPTION = 82;

	/**
	 * The meta object id for the '<em>Not Found Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getNotFoundException()
	 * @generated
	 */
	int NOT_FOUND_EXCEPTION = 83;

	/**
	 * The meta object id for the '<em>Compute Property Value Command</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getComputePropertyValueCommand()
	 * @generated
	 */
	int COMPUTE_PROPERTY_VALUE_COMMAND = 84;

	/**
	 * The meta object id for the '<em>Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 85;

	/**
	 * The meta object id for the '<em>Custom Property Opertor Instance</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.operators.CustomPropertyOperatorsInstance
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCustomPropertyOpertorInstance()
	 * @generated
	 */
	int CUSTOM_PROPERTY_OPERTOR_INSTANCE = 86;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerNamedStyle <em>Layer Named Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer Named Style</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerNamedStyle
	 * @generated
	 */
	EClass getLayerNamedStyle();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerNamedStyle#getLayersStack <em>Layers Stack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Layers Stack</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerNamedStyle#getLayersStack()
	 * @see #getLayerNamedStyle()
	 * @generated
	 */
	EReference getLayerNamedStyle_LayersStack();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack <em>Stack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stack</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack
	 * @generated
	 */
	EClass getLayersStack();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getLayers <em>Layers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layers</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getLayers()
	 * @see #getLayersStack()
	 * @generated
	 */
	EReference getLayersStack_Layers();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getName()
	 * @see #getLayersStack()
	 * @generated
	 */
	EAttribute getLayersStack_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getDescription()
	 * @see #getLayersStack()
	 * @generated
	 */
	EAttribute getLayersStack_Description();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Diagram</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getDiagram()
	 * @see #getLayersStack()
	 * @generated
	 */
	EReference getLayersStack_Diagram();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getState()
	 * @see #getLayersStack()
	 * @generated
	 */
	EAttribute getLayersStack_State();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property) <em>Get Compute Property Value Command</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Compute Property Value Command</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property)
	 * @generated
	 */
	EOperation getLayersStack__GetComputePropertyValueCommand__View_Property();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getPropertiesComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, org.eclipse.emf.common.util.EList) <em>Get Properties Compute Property Value Command</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Properties Compute Property Value Command</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getPropertiesComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getLayersStack__GetPropertiesComputePropertyValueCommand__View_EList();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getViewsComputePropertyValueCommand(org.eclipse.emf.common.util.EList, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property) <em>Get Views Compute Property Value Command</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Views Compute Property Value Command</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#getViewsComputePropertyValueCommand(org.eclipse.emf.common.util.EList, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property)
	 * @generated
	 */
	EOperation getLayersStack__GetViewsComputePropertyValueCommand__EList_Property();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#startAfterCreation() <em>Start After Creation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Start After Creation</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#startAfterCreation()
	 * @generated
	 */
	EOperation getLayersStack__StartAfterCreation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#attachLayers() <em>Attach Layers</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Attach Layers</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#attachLayers()
	 * @generated
	 */
	EOperation getLayersStack__AttachLayers();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#attach() <em>Attach</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Attach</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#attach()
	 * @generated
	 */
	EOperation getLayersStack__Attach();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#detach() <em>Detach</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Detach</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#detach()
	 * @generated
	 */
	EOperation getLayersStack__Detach();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#enterAttachedState() <em>Enter Attached State</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Enter Attached State</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#enterAttachedState()
	 * @generated
	 */
	EOperation getLayersStack__EnterAttachedState();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#exitAttachedState() <em>Exit Attached State</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Exit Attached State</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack#exitAttachedState()
	 * @generated
	 */
	EOperation getLayersStack__ExitAttachedState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression <em>Layer Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer Expression</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression
	 * @generated
	 */
	EClass getLayerExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getName()
	 * @see #getLayerExpression()
	 * @generated
	 */
	EAttribute getLayerExpression_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getDescription()
	 * @see #getLayerExpression()
	 * @generated
	 */
	EAttribute getLayerExpression_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#isLayerEnabledInternal <em>Is Layer Enabled Internal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Layer Enabled Internal</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#isLayerEnabledInternal()
	 * @see #getLayerExpression()
	 * @generated
	 */
	EAttribute getLayerExpression_IsLayerEnabledInternal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#isLayerEnabled <em>Is Layer Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Layer Enabled</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#isLayerEnabled()
	 * @see #getLayerExpression()
	 * @generated
	 */
	EAttribute getLayerExpression_IsLayerEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#isBranchEnabled <em>Is Branch Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Branch Enabled</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#isBranchEnabled()
	 * @see #getLayerExpression()
	 * @generated
	 */
	EAttribute getLayerExpression_IsBranchEnabled();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getOwningLayersStack <em>Owning Layers Stack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owning Layers Stack</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getOwningLayersStack()
	 * @see #getLayerExpression()
	 * @generated
	 */
	EReference getLayerExpression_OwningLayersStack();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getState()
	 * @see #getLayerExpression()
	 * @generated
	 */
	EAttribute getLayerExpression_State();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property) <em>Get Compute Property Value Command</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Compute Property Value Command</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property)
	 * @generated
	 */
	EOperation getLayerExpression__GetComputePropertyValueCommand__View_Property();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getViewsComputePropertyValueCommand(org.eclipse.emf.common.util.EList, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property) <em>Get Views Compute Property Value Command</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Views Compute Property Value Command</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getViewsComputePropertyValueCommand(org.eclipse.emf.common.util.EList, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property)
	 * @generated
	 */
	EOperation getLayerExpression__GetViewsComputePropertyValueCommand__EList_Property();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getPropertiesComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, org.eclipse.emf.common.util.EList) <em>Get Properties Compute Property Value Command</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Properties Compute Property Value Command</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getPropertiesComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getLayerExpression__GetPropertiesComputePropertyValueCommand__View_EList();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#attachToLayersStack(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack) <em>Attach To Layers Stack</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Attach To Layers Stack</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#attachToLayersStack(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStack)
	 * @generated
	 */
	EOperation getLayerExpression__AttachToLayersStack__LayersStack();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getLayersStack() <em>Get Layers Stack</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Layers Stack</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#getLayersStack()
	 * @generated
	 */
	EOperation getLayerExpression__GetLayersStack();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#enterAttachedState() <em>Enter Attached State</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Enter Attached State</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#enterAttachedState()
	 * @generated
	 */
	EOperation getLayerExpression__EnterAttachedState();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#attach() <em>Attach</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Attach</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#attach()
	 * @generated
	 */
	EOperation getLayerExpression__Attach();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#detach() <em>Detach</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Detach</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#detach()
	 * @generated
	 */
	EOperation getLayerExpression__Detach();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#exitAttachedState() <em>Exit Attached State</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Exit Attached State</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression#exitAttachedState()
	 * @generated
	 */
	EOperation getLayerExpression__ExitAttachedState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ApplicationDependantElement <em>Application Dependant Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Dependant Element</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ApplicationDependantElement
	 * @generated
	 */
	EClass getApplicationDependantElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ApplicationDependantElement#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Application</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ApplicationDependantElement#getApplication()
	 * @see #getApplicationDependantElement()
	 * @generated
	 */
	EReference getApplicationDependantElement_Application();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication <em>Stack Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stack Application</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication
	 * @generated
	 */
	EClass getLayersStackApplication();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getLayersStacks <em>Layers Stacks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Layers Stacks</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getLayersStacks()
	 * @see #getLayersStackApplication()
	 * @generated
	 */
	EReference getLayersStackApplication_LayersStacks();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getLayerStackRegistry <em>Layer Stack Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layer Stack Registry</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getLayerStackRegistry()
	 * @see #getLayersStackApplication()
	 * @generated
	 */
	EReference getLayersStackApplication_LayerStackRegistry();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getPropertyRegistry <em>Property Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Property Registry</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getPropertyRegistry()
	 * @see #getLayersStackApplication()
	 * @generated
	 */
	EReference getLayersStackApplication_PropertyRegistry();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getLayerDescriptorRegistry <em>Layer Descriptor Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layer Descriptor Registry</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getLayerDescriptorRegistry()
	 * @see #getLayersStackApplication()
	 * @generated
	 */
	EReference getLayersStackApplication_LayerDescriptorRegistry();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getFactory <em>Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Factory</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getFactory()
	 * @see #getLayersStackApplication()
	 * @generated
	 */
	EReference getLayersStackApplication_Factory();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getPropertySetterRegistry <em>Property Setter Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Property Setter Registry</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getPropertySetterRegistry()
	 * @see #getLayersStackApplication()
	 * @generated
	 */
	EReference getLayersStackApplication_PropertySetterRegistry();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getLayerOperatorDescriptorRegistry <em>Layer Operator Descriptor Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layer Operator Descriptor Registry</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getLayerOperatorDescriptorRegistry()
	 * @see #getLayersStackApplication()
	 * @generated
	 */
	EReference getLayersStackApplication_LayerOperatorDescriptorRegistry();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getLayersStackFor(org.eclipse.gmf.runtime.notation.Diagram) <em>Get Layers Stack For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Layers Stack For</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#getLayersStackFor(org.eclipse.gmf.runtime.notation.Diagram)
	 * @generated
	 */
	EOperation getLayersStackApplication__GetLayersStackFor__Diagram();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#removeLayersStackFor(org.eclipse.gmf.runtime.notation.Diagram) <em>Remove Layers Stack For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove Layers Stack For</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#removeLayersStackFor(org.eclipse.gmf.runtime.notation.Diagram)
	 * @generated
	 */
	EOperation getLayersStackApplication__RemoveLayersStackFor__Diagram();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#isLayersStackAttachedFor(org.eclipse.gmf.runtime.notation.Diagram) <em>Is Layers Stack Attached For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Layers Stack Attached For</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#isLayersStackAttachedFor(org.eclipse.gmf.runtime.notation.Diagram)
	 * @generated
	 */
	EOperation getLayersStackApplication__IsLayersStackAttachedFor__Diagram();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#createLayersStackFor(org.eclipse.gmf.runtime.notation.Diagram) <em>Create Layers Stack For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Layers Stack For</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#createLayersStackFor(org.eclipse.gmf.runtime.notation.Diagram)
	 * @generated
	 */
	EOperation getLayersStackApplication__CreateLayersStackFor__Diagram();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#lookupLayersStackFor(org.eclipse.gmf.runtime.notation.Diagram) <em>Lookup Layers Stack For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Lookup Layers Stack For</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersStackApplication#lookupLayersStackFor(org.eclipse.gmf.runtime.notation.Diagram)
	 * @generated
	 */
	EOperation getLayersStackApplication__LookupLayersStackFor__Diagram();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FolderElement <em>Folder Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder Element</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FolderElement
	 * @generated
	 */
	EClass getFolderElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerStackDescriptorRegistry <em>Layer Stack Descriptor Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer Stack Descriptor Registry</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerStackDescriptorRegistry
	 * @generated
	 */
	EClass getLayerStackDescriptorRegistry();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry <em>Property Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Registry</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry
	 * @generated
	 */
	EClass getPropertyRegistry();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#getProperties()
	 * @see #getPropertyRegistry()
	 * @generated
	 */
	EReference getPropertyRegistry_Properties();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#getTypeRegistry <em>Type Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Registry</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#getTypeRegistry()
	 * @see #getPropertyRegistry()
	 * @generated
	 */
	EReference getPropertyRegistry_TypeRegistry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#getPropertiesCount <em>Properties Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Properties Count</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#getPropertiesCount()
	 * @see #getPropertyRegistry()
	 * @generated
	 */
	EAttribute getPropertyRegistry_PropertiesCount();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#getPropertyIndex(java.lang.String) <em>Get Property Index</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Property Index</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#getPropertyIndex(java.lang.String)
	 * @generated
	 */
	EOperation getPropertyRegistry__GetPropertyIndex__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#getProperty(java.lang.String) <em>Get Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Property</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#getProperty(java.lang.String)
	 * @generated
	 */
	EOperation getPropertyRegistry__GetProperty__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#addProperty(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property) <em>Add Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Property</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyRegistry#addProperty(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property)
	 * @generated
	 */
	EOperation getPropertyRegistry__AddProperty__Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property#getType()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Value</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property#getDefaultValue()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property#getDescription()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property#getIndex()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Index();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property#createInstance() <em>Create Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property#createInstance()
	 * @generated
	 */
	EOperation getProperty__CreateInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metamodel</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type#getMetamodel()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_Metamodel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type#getName()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type#getDescription()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Description();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type#createInstance() <em>Create Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type#createInstance()
	 * @generated
	 */
	EOperation getType__CreateInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metamodel</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel
	 * @generated
	 */
	EClass getMetamodel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel#getName()
	 * @see #getMetamodel()
	 * @generated
	 */
	EAttribute getMetamodel_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel#getDescription()
	 * @see #getMetamodel()
	 * @generated
	 */
	EAttribute getMetamodel_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel#getNsuri <em>Nsuri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nsuri</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel#getNsuri()
	 * @see #getMetamodel()
	 * @generated
	 */
	EAttribute getMetamodel_Nsuri();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel#getPluginID <em>Plugin ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin ID</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel#getPluginID()
	 * @see #getMetamodel()
	 * @generated
	 */
	EAttribute getMetamodel_PluginID();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel#getEPackageInstanceName <em>EPackage Instance Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EPackage Instance Name</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel#getEPackageInstanceName()
	 * @see #getMetamodel()
	 * @generated
	 */
	EAttribute getMetamodel_EPackageInstanceName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel#isTypeValid <em>Is Type Valid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Type Valid</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel#isTypeValid()
	 * @see #getMetamodel()
	 * @generated
	 */
	EAttribute getMetamodel_IsTypeValid();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel#getEPackage() <em>Get EPackage</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EPackage</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Metamodel#getEPackage()
	 * @generated
	 */
	EOperation getMetamodel__GetEPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance <em>Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Instance</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance
	 * @generated
	 */
	EClass getTypeInstance();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance#setValueFromString(java.lang.String) <em>Set Value From String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Value From String</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance#setValueFromString(java.lang.String)
	 * @generated
	 */
	EOperation getTypeInstance__SetValueFromString__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance#setValueFromInstance(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance) <em>Set Value From Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Value From Instance</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance#setValueFromInstance(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance)
	 * @generated
	 */
	EOperation getTypeInstance__SetValueFromInstance__TypeInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand <em>Compute Property Value Command Itf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compute Property Value Command Itf</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand
	 * @model instanceClass="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand"
	 * @generated
	 */
	EClass getComputePropertyValueCommandItf();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand#getCmdValue() <em>Get Cmd Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Cmd Value</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand#getCmdValue()
	 * @generated
	 */
	EOperation getComputePropertyValueCommandItf__GetCmdValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeRegistry <em>Type Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Registry</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeRegistry
	 * @generated
	 */
	EClass getTypeRegistry();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeRegistry#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Types</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeRegistry#getTypes()
	 * @see #getTypeRegistry()
	 * @generated
	 */
	EReference getTypeRegistry_Types();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Type Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Type Map</em>'.
	 * @see java.util.Map.Entry
	 * @model features="value key" 
	 *        valueType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Type" valueContainment="true" valueRequired="true" valueOrdered="false"
	 *        keyDataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" keyRequired="true" keyOrdered="false"
	 * @generated
	 */
	EClass getStringToTypeMap();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToTypeMap()
	 * @generated
	 */
	EReference getStringToTypeMap_Value();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToTypeMap()
	 * @generated
	 */
	EAttribute getStringToTypeMap_Key();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptorRegistry <em>Layer Descriptor Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer Descriptor Registry</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptorRegistry
	 * @generated
	 */
	EClass getLayerDescriptorRegistry();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptorRegistry#getLayerDescriptors <em>Layer Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Layer Descriptors</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptorRegistry#getLayerDescriptors()
	 * @see #getLayerDescriptorRegistry()
	 * @generated
	 */
	EReference getLayerDescriptorRegistry_LayerDescriptors();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptor <em>Layer Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer Descriptor</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptor
	 * @generated
	 */
	EClass getLayerDescriptor();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptor#getPropertyRegistry <em>Property Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property Registry</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerDescriptor#getPropertyRegistry()
	 * @see #getLayerDescriptor()
	 * @generated
	 */
	EReference getLayerDescriptor_PropertyRegistry();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerApplicationFactory <em>Layer Application Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer Application Factory</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerApplicationFactory
	 * @generated
	 */
	EClass getLayerApplicationFactory();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerApplicationFactory#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Application</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerApplicationFactory#getApplication()
	 * @see #getLayerApplicationFactory()
	 * @generated
	 */
	EReference getLayerApplicationFactory_Application();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry <em>Property Setter Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Setter Registry</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry
	 * @generated
	 */
	EClass getPropertySetterRegistry();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry#getPropertySetters <em>Property Setters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Property Setters</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry#getPropertySetters()
	 * @see #getPropertySetterRegistry()
	 * @generated
	 */
	EReference getPropertySetterRegistry_PropertySetters();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry#getSetterMap <em>Setter Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Setter Map</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry#getSetterMap()
	 * @see #getPropertySetterRegistry()
	 * @generated
	 */
	EReference getPropertySetterRegistry_SetterMap();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Application</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry#getApplication()
	 * @see #getPropertySetterRegistry()
	 * @generated
	 */
	EReference getPropertySetterRegistry_Application();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry#getPropertySetter(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property) <em>Get Property Setter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Property Setter</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry#getPropertySetter(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property)
	 * @generated
	 */
	EOperation getPropertySetterRegistry__GetPropertySetter__Property();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry#getPropertySetter(java.lang.String) <em>Get Property Setter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Property Setter</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry#getPropertySetter(java.lang.String)
	 * @generated
	 */
	EOperation getPropertySetterRegistry__GetPropertySetter__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry#addPropertySetter(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter) <em>Add Property Setter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Property Setter</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetterRegistry#addPropertySetter(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter)
	 * @generated
	 */
	EOperation getPropertySetterRegistry__AddPropertySetter__PropertySetter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter <em>Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Setter</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter
	 * @generated
	 */
	EClass getPropertySetter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter#getProperty()
	 * @see #getPropertySetter()
	 * @generated
	 */
	EReference getPropertySetter_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter#getPropertyName()
	 * @see #getPropertySetter()
	 * @generated
	 */
	EAttribute getPropertySetter_PropertyName();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter#setValue(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance) <em>Set Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Value</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter#setValue(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance)
	 * @generated
	 */
	EOperation getPropertySetter__SetValue__View_TypeInstance();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Property Setter</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" keyRequired="true" keyOrdered="false"
	 *        valueType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertySetter" valueContainment="true" valueRequired="true" valueOrdered="false"
	 * @generated
	 */
	EClass getStringToPropertySetter();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToPropertySetter()
	 * @generated
	 */
	EAttribute getStringToPropertySetter_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToPropertySetter()
	 * @generated
	 */
	EReference getStringToPropertySetter_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry <em>Layer Operator Descriptor Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer Operator Descriptor Registry</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry
	 * @generated
	 */
	EClass getLayerOperatorDescriptorRegistry();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getDescriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Descriptors</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getDescriptors()
	 * @see #getLayerOperatorDescriptorRegistry()
	 * @generated
	 */
	EReference getLayerOperatorDescriptorRegistry_Descriptors();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getPropertyOperators <em>Property Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Operators</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getPropertyOperators()
	 * @see #getLayerOperatorDescriptorRegistry()
	 * @generated
	 */
	EReference getLayerOperatorDescriptorRegistry_PropertyOperators();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getPropertyCollectionSize <em>Property Collection Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Collection Size</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getPropertyCollectionSize()
	 * @see #getLayerOperatorDescriptorRegistry()
	 * @generated
	 */
	EAttribute getLayerOperatorDescriptorRegistry_PropertyCollectionSize();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getDefaultOperator <em>Default Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Operator</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getDefaultOperator()
	 * @see #getLayerOperatorDescriptorRegistry()
	 * @generated
	 */
	EReference getLayerOperatorDescriptorRegistry_DefaultOperator();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#addLayerOperatorDescriptor(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor) <em>Add Layer Operator Descriptor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Layer Operator Descriptor</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#addLayerOperatorDescriptor(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor)
	 * @generated
	 */
	EOperation getLayerOperatorDescriptorRegistry__AddLayerOperatorDescriptor__LayerOperatorDescriptor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getLayerOperatorDescriptor(java.lang.String) <em>Get Layer Operator Descriptor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Layer Operator Descriptor</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getLayerOperatorDescriptor(java.lang.String)
	 * @generated
	 */
	EOperation getLayerOperatorDescriptorRegistry__GetLayerOperatorDescriptor__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#addPropertyOperator(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator) <em>Add Property Operator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Property Operator</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#addPropertyOperator(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator)
	 * @generated
	 */
	EOperation getLayerOperatorDescriptorRegistry__AddPropertyOperator__PropertyOperator();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getPropertyOperator(java.lang.String) <em>Get Property Operator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Property Operator</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#getPropertyOperator(java.lang.String)
	 * @generated
	 */
	EOperation getLayerOperatorDescriptorRegistry__GetPropertyOperator__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#attachOperatorToDescriptor(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property, java.lang.String, java.lang.String) <em>Attach Operator To Descriptor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Attach Operator To Descriptor</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#attachOperatorToDescriptor(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property, java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getLayerOperatorDescriptorRegistry__AttachOperatorToDescriptor__Property_String_String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#createLayerOperator(java.lang.String) <em>Create Layer Operator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Layer Operator</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptorRegistry#createLayerOperator(java.lang.String)
	 * @generated
	 */
	EOperation getLayerOperatorDescriptorRegistry__CreateLayerOperator__String();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor <em>Layer Operator Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer Operator Descriptor</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor
	 * @generated
	 */
	EClass getLayerOperatorDescriptor();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor#getPropertyOperators <em>Property Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Property Operators</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor#getPropertyOperators()
	 * @see #getLayerOperatorDescriptor()
	 * @generated
	 */
	EReference getLayerOperatorDescriptor_PropertyOperators();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor#getName()
	 * @see #getLayerOperatorDescriptor()
	 * @generated
	 */
	EAttribute getLayerOperatorDescriptor_Name();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor#getPropertyOperator(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property) <em>Get Property Operator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Property Operator</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor#getPropertyOperator(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property)
	 * @generated
	 */
	EOperation getLayerOperatorDescriptor__GetPropertyOperator__Property();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor#setPropertyOperator(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator) <em>Set Property Operator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Property Operator</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor#setPropertyOperator(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator)
	 * @generated
	 */
	EOperation getLayerOperatorDescriptor__SetPropertyOperator__Property_PropertyOperator();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor#createLayerOperator() <em>Create Layer Operator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Layer Operator</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor#createLayerOperator()
	 * @generated
	 */
	EOperation getLayerOperatorDescriptor__CreateLayerOperator();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor#setPropertyCollectionSize(int, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.DefaultPropertyOperator) <em>Set Property Collection Size</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Property Collection Size</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperatorDescriptor#setPropertyCollectionSize(int, org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.DefaultPropertyOperator)
	 * @generated
	 */
	EOperation getLayerOperatorDescriptor__SetPropertyCollectionSize__int_DefaultPropertyOperator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator <em>Property Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Operator</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator
	 * @generated
	 */
	EClass getPropertyOperator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator#getName()
	 * @see #getPropertyOperator()
	 * @generated
	 */
	EAttribute getPropertyOperator_Name();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator#getComputePropertyValueCommand(org.eclipse.emf.common.util.EList) <em>Get Compute Property Value Command</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Compute Property Value Command</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyOperator#getComputePropertyValueCommand(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getPropertyOperator__GetComputePropertyValueCommand__EList();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator <em>Abstract Layer Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Layer Operator</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator
	 * @generated
	 */
	EClass getAbstractLayerOperator();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator#getLayerOperatorDescriptor <em>Layer Operator Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Layer Operator Descriptor</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator#getLayerOperatorDescriptor()
	 * @see #getAbstractLayerOperator()
	 * @generated
	 */
	EReference getAbstractLayerOperator_LayerOperatorDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator#getLayerOperatorDescriptorName <em>Layer Operator Descriptor Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layer Operator Descriptor Name</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator#getLayerOperatorDescriptorName()
	 * @see #getAbstractLayerOperator()
	 * @generated
	 */
	EAttribute getAbstractLayerOperator_LayerOperatorDescriptorName();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator#isDescriptorSet() <em>Is Descriptor Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Descriptor Set</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator#isDescriptorSet()
	 * @generated
	 */
	EOperation getAbstractLayerOperator__IsDescriptorSet();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator#resetDescriptor() <em>Reset Descriptor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Reset Descriptor</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator#resetDescriptor()
	 * @generated
	 */
	EOperation getAbstractLayerOperator__ResetDescriptor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator <em>Layer Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer Operator</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator
	 * @generated
	 */
	EClass getLayerOperator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator#getLayers <em>Layers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Layers</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerOperator#getLayers()
	 * @see #getLayerOperator()
	 * @generated
	 */
	EReference getLayerOperator_Layers();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersContainer
	 * @generated
	 */
	EClass getLayersContainer();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersContainer#addLayer(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression) <em>Add Layer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Layer</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersContainer#addLayer(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerExpression)
	 * @generated
	 */
	EOperation getLayersContainer__AddLayer__LayerExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.DefaultPropertyOperator <em>Default Property Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Property Operator</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.DefaultPropertyOperator
	 * @generated
	 */
	EClass getDefaultPropertyOperator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer <em>Abstract Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Layer</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer
	 * @generated
	 */
	EClass getAbstractLayer();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getPropertyValues <em>Property Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Property Values</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getPropertyValues()
	 * @see #getAbstractLayer()
	 * @generated
	 */
	EReference getAbstractLayer_PropertyValues();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getPropertyValueMap <em>Property Value Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Property Value Map</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getPropertyValueMap()
	 * @see #getAbstractLayer()
	 * @generated
	 */
	EReference getAbstractLayer_PropertyValueMap();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getLayerDescriptor <em>Layer Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Layer Descriptor</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getLayerDescriptor()
	 * @see #getAbstractLayer()
	 * @generated
	 */
	EReference getAbstractLayer_LayerDescriptor();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Views</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getViews()
	 * @see #getAbstractLayer()
	 * @generated
	 */
	EReference getAbstractLayer_Views();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getAttachedProperties <em>Attached Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attached Properties</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getAttachedProperties()
	 * @see #getAbstractLayer()
	 * @generated
	 */
	EReference getAbstractLayer_AttachedProperties();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#addPropertyInstance(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property) <em>Add Property Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Property Instance</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#addPropertyInstance(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property)
	 * @generated
	 */
	EOperation getAbstractLayer__AddPropertyInstance__Property();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#removePropertyInstance(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property) <em>Remove Property Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove Property Instance</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#removePropertyInstance(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property)
	 * @generated
	 */
	EOperation getAbstractLayer__RemovePropertyInstance__Property();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getPropertyInstance(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property) <em>Get Property Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Property Instance</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getPropertyInstance(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Property)
	 * @generated
	 */
	EOperation getAbstractLayer__GetPropertyInstance__Property();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getPropertyInstance(java.lang.String) <em>Get Property Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Property Instance</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayer#getPropertyInstance(java.lang.String)
	 * @generated
	 */
	EOperation getAbstractLayer__GetPropertyInstance__String();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Type Instance Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Type Instance Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" keyRequired="true" keyOrdered="false"
	 *        valueType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TypeInstance" valueContainment="true" valueRequired="true" valueOrdered="false"
	 * @generated
	 */
	EClass getStringToTypeInstanceMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToTypeInstanceMap()
	 * @generated
	 */
	EAttribute getStringToTypeInstanceMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToTypeInstanceMap()
	 * @generated
	 */
	EReference getStringToTypeInstanceMap_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Folder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Folder
	 * @generated
	 */
	EClass getFolder();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Folder#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Folder#getElements()
	 * @see #getFolder()
	 * @generated
	 */
	EReference getFolder_Elements();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Folder#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Folder#getName()
	 * @see #getFolder()
	 * @generated
	 */
	EAttribute getFolder_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IntInstance <em>Int Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Instance</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IntInstance
	 * @generated
	 */
	EClass getIntInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IntInstance#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IntInstance#getValue()
	 * @see #getIntInstance()
	 * @generated
	 */
	EAttribute getIntInstance_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.BooleanInstance <em>Boolean Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Instance</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.BooleanInstance
	 * @generated
	 */
	EClass getBooleanInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.BooleanInstance#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.BooleanInstance#isValue()
	 * @see #getBooleanInstance()
	 * @generated
	 */
	EAttribute getBooleanInstance_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StringInstance <em>String Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Instance</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StringInstance
	 * @generated
	 */
	EClass getStringInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StringInstance#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StringInstance#getValue()
	 * @see #getStringInstance()
	 * @generated
	 */
	EAttribute getStringInstance_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IntType <em>Int Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Type</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IntType
	 * @generated
	 */
	EClass getIntType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Type</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StringType
	 * @generated
	 */
	EClass getStringType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomType <em>Custom Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Type</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomType
	 * @generated
	 */
	EClass getCustomType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomType#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classifier</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomType#getClassifier()
	 * @see #getCustomType()
	 * @generated
	 */
	EAttribute getCustomType_Classifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperator <em>Top Layer Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Layer Operator</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperator
	 * @generated
	 */
	EClass getTopLayerOperator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StackedLayerOperator <em>Stacked Layer Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stacked Layer Operator</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StackedLayerOperator
	 * @generated
	 */
	EClass getStackedLayerOperator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomLayerOperator <em>Custom Layer Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Layer Operator</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomLayerOperator
	 * @generated
	 */
	EClass getCustomLayerOperator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyIndex <em>Property Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Index</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyIndex
	 * @generated
	 */
	EClass getPropertyIndex();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyIndex#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyIndex#getProperty()
	 * @see #getPropertyIndex()
	 * @generated
	 */
	EReference getPropertyIndex_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyIndex#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyIndex#getIndex()
	 * @see #getPropertyIndex()
	 * @generated
	 */
	EAttribute getPropertyIndex_Index();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Property Index Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Property Index Map</em>'.
	 * @see java.util.Map.Entry
	 * @model features="value key" 
	 *        valueType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.PropertyIndex" valueContainment="true" valueOrdered="false"
	 *        keyDataType="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.String" keyRequired="true" keyOrdered="false"
	 * @generated
	 */
	EClass getStringToPropertyIndexMap();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToPropertyIndexMap()
	 * @generated
	 */
	EReference getStringToPropertyIndexMap_Value();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToPropertyIndexMap()
	 * @generated
	 */
	EAttribute getStringToPropertyIndexMap_Key();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.SimpleLayerDescriptor <em>Simple Layer Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Layer Descriptor</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.SimpleLayerDescriptor
	 * @generated
	 */
	EClass getSimpleLayerDescriptor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayerDescriptor <em>Reg Exp Layer Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reg Exp Layer Descriptor</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayerDescriptor
	 * @generated
	 */
	EClass getRegExpLayerDescriptor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NullInstance <em>Null Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Instance</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NullInstance
	 * @generated
	 */
	EClass getNullInstance();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NullInstance#getInstance() <em>Get Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Instance</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NullInstance#getInstance()
	 * @generated
	 */
	EOperation getNullInstance__GetInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer <em>Reg Exp Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reg Exp Layer</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer
	 * @generated
	 */
	EClass getRegExpLayer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expr</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#getExpr()
	 * @see #getRegExpLayer()
	 * @generated
	 */
	EAttribute getRegExpLayer_Expr();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#getLanguage()
	 * @see #getRegExpLayer()
	 * @generated
	 */
	EAttribute getRegExpLayer_Language();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#isDomainChangedEventDependant <em>Is Domain Changed Event Dependant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Domain Changed Event Dependant</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#isDomainChangedEventDependant()
	 * @see #getRegExpLayer()
	 * @generated
	 */
	EAttribute getRegExpLayer_IsDomainChangedEventDependant();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#getDomainChangedEventLevel <em>Domain Changed Event Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Changed Event Level</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#getDomainChangedEventLevel()
	 * @see #getRegExpLayer()
	 * @generated
	 */
	EAttribute getRegExpLayer_DomainChangedEventLevel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#isDiagramChangedEventDependant <em>Is Diagram Changed Event Dependant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Diagram Changed Event Dependant</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#isDiagramChangedEventDependant()
	 * @see #getRegExpLayer()
	 * @generated
	 */
	EAttribute getRegExpLayer_IsDiagramChangedEventDependant();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#getDiagramChangedEventLevel <em>Diagram Changed Event Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagram Changed Event Level</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#getDiagramChangedEventLevel()
	 * @see #getRegExpLayer()
	 * @generated
	 */
	EAttribute getRegExpLayer_DiagramChangedEventLevel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#getExpressionContextObjectType <em>Expression Context Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Context Object Type</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#getExpressionContextObjectType()
	 * @see #getRegExpLayer()
	 * @generated
	 */
	EAttribute getRegExpLayer_ExpressionContextObjectType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#activate(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator) <em>Activate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Activate</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#activate(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator)
	 * @generated
	 */
	EOperation getRegExpLayer__Activate__AbstractLayerOperator();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#deactivate(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator) <em>Deactivate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Deactivate</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#deactivate(org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AbstractLayerOperator)
	 * @generated
	 */
	EOperation getRegExpLayer__Deactivate__AbstractLayerOperator();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#isDerivedView(org.eclipse.gmf.runtime.notation.View) <em>Is Derived View</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Derived View</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#isDerivedView(org.eclipse.gmf.runtime.notation.View)
	 * @generated
	 */
	EOperation getRegExpLayer__IsDerivedView__View();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#attachDerivedView(org.eclipse.gmf.runtime.notation.View) <em>Attach Derived View</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Attach Derived View</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#attachDerivedView(org.eclipse.gmf.runtime.notation.View)
	 * @generated
	 */
	EOperation getRegExpLayer__AttachDerivedView__View();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#attachDerivedViews(org.eclipse.emf.common.util.EList) <em>Attach Derived Views</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Attach Derived Views</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#attachDerivedViews(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getRegExpLayer__AttachDerivedViews__EList();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#attachDerivedViews() <em>Attach Derived Views</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Attach Derived Views</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#attachDerivedViews()
	 * @generated
	 */
	EOperation getRegExpLayer__AttachDerivedViews();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#lookupDerivedViews(org.eclipse.emf.common.util.EList) <em>Lookup Derived Views</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Lookup Derived Views</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.RegExpLayer#lookupDerivedViews(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getRegExpLayer__LookupDerivedViews__EList();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Layer <em>Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Layer
	 * @generated
	 */
	EClass getLayer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Color <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Color
	 * @generated
	 */
	EClass getColor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ColorInstance <em>Color Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Instance</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ColorInstance
	 * @generated
	 */
	EClass getColorInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ColorInstance#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.ColorInstance#getValue()
	 * @see #getColorInstance()
	 * @generated
	 */
	EAttribute getColorInstance_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillInstance <em>Fill Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fill Instance</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillInstance
	 * @generated
	 */
	EClass getFillInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillInstance#getTransparency <em>Transparency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transparency</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillInstance#getTransparency()
	 * @see #getFillInstance()
	 * @generated
	 */
	EAttribute getFillInstance_Transparency();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillInstance#getFillColor <em>Fill Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fill Color</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillInstance#getFillColor()
	 * @see #getFillInstance()
	 * @generated
	 */
	EReference getFillInstance_FillColor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Fill <em>Fill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fill</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.Fill
	 * @generated
	 */
	EClass getFill();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillPropertySetter <em>Fill Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fill Property Setter</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FillPropertySetter
	 * @generated
	 */
	EClass getFillPropertySetter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IsValidPropertySetter <em>Is Valid Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Valid Property Setter</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IsValidPropertySetter
	 * @generated
	 */
	EClass getIsValidPropertySetter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NullPropertySetter <em>Null Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Property Setter</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.NullPropertySetter
	 * @generated
	 */
	EClass getNullPropertySetter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LineType <em>Line Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Type</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LineType
	 * @generated
	 */
	EClass getLineType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LineInstance <em>Line Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Instance</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LineInstance
	 * @generated
	 */
	EClass getLineInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LineInstance#getLineColor <em>Line Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Color</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LineInstance#getLineColor()
	 * @see #getLineInstance()
	 * @generated
	 */
	EAttribute getLineInstance_LineColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LineInstance#getLineWith <em>Line With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line With</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LineInstance#getLineWith()
	 * @see #getLineInstance()
	 * @generated
	 */
	EAttribute getLineInstance_LineWith();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LinePropertySetter <em>Line Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Property Setter</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LinePropertySetter
	 * @generated
	 */
	EClass getLinePropertySetter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontPropertySetter <em>Font Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font Property Setter</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontPropertySetter
	 * @generated
	 */
	EClass getFontPropertySetter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontInstance <em>Font Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font Instance</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontInstance
	 * @generated
	 */
	EClass getFontInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontInstance#getFontColor <em>Font Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Color</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontInstance#getFontColor()
	 * @see #getFontInstance()
	 * @generated
	 */
	EAttribute getFontInstance_FontColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontInstance#getFontName <em>Font Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Name</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontInstance#getFontName()
	 * @see #getFontInstance()
	 * @generated
	 */
	EAttribute getFontInstance_FontName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontInstance#getFontHeigh <em>Font Heigh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Heigh</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontInstance#getFontHeigh()
	 * @see #getFontInstance()
	 * @generated
	 */
	EAttribute getFontInstance_FontHeigh();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontInstance#isBold <em>Bold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bold</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontInstance#isBold()
	 * @see #getFontInstance()
	 * @generated
	 */
	EAttribute getFontInstance_Bold();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontType <em>Font Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font Type</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.FontType
	 * @generated
	 */
	EClass getFontType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IsVisiblePropertySetter <em>Is Visible Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Visible Property Setter</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IsVisiblePropertySetter
	 * @generated
	 */
	EClass getIsVisiblePropertySetter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperatorDescriptor <em>Top Layer Operator Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Layer Operator Descriptor</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.TopLayerOperatorDescriptor
	 * @generated
	 */
	EClass getTopLayerOperatorDescriptor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StackedLayerOperatorDescriptor <em>Stacked Layer Operator Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stacked Layer Operator Descriptor</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.StackedLayerOperatorDescriptor
	 * @generated
	 */
	EClass getStackedLayerOperatorDescriptor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomPropertyOperator <em>Custom Property Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Property Operator</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomPropertyOperator
	 * @generated
	 */
	EClass getCustomPropertyOperator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomPropertyOperator#getClassname <em>Classname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classname</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomPropertyOperator#getClassname()
	 * @see #getCustomPropertyOperator()
	 * @generated
	 */
	EAttribute getCustomPropertyOperator_Classname();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomPropertyOperator#getOperatorInstance <em>Operator Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator Instance</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomPropertyOperator#getOperatorInstance()
	 * @see #getCustomPropertyOperator()
	 * @generated
	 */
	EAttribute getCustomPropertyOperator_OperatorInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomPropertyOperator#getClassBundleID <em>Class Bundle ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Bundle ID</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomPropertyOperator#getClassBundleID()
	 * @see #getCustomPropertyOperator()
	 * @generated
	 */
	EAttribute getCustomPropertyOperator_ClassBundleID();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomPropertyOperator#resetOperatorInstance() <em>Reset Operator Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Reset Operator Instance</em>' operation.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CustomPropertyOperator#resetOperatorInstance()
	 * @generated
	 */
	EOperation getCustomPropertyOperator__ResetOperatorInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AndStackedLayerOperatorDescriptor <em>And Stacked Layer Operator Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Stacked Layer Operator Descriptor</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AndStackedLayerOperatorDescriptor
	 * @generated
	 */
	EClass getAndStackedLayerOperatorDescriptor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.OrStackedLayerOperatorDescriptor <em>Or Stacked Layer Operator Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Stacked Layer Operator Descriptor</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.OrStackedLayerOperatorDescriptor
	 * @generated
	 */
	EClass getOrStackedLayerOperatorDescriptor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IsAbstractUmlSetter <em>Is Abstract Uml Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Abstract Uml Setter</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.IsAbstractUmlSetter
	 * @generated
	 */
	EClass getIsAbstractUmlSetter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AllViewsDerivedLayer <em>All Views Derived Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Views Derived Layer</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.AllViewsDerivedLayer
	 * @generated
	 */
	EClass getAllViewsDerivedLayer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSPropertySetter <em>CSS Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CSS Property Setter</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSPropertySetter
	 * @generated
	 */
	EClass getCSSPropertySetter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSType <em>CSS Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CSS Type</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSType
	 * @generated
	 */
	EClass getCSSType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSInstance <em>CSS Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CSS Instance</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSInstance
	 * @generated
	 */
	EClass getCSSInstance();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSInstance#getStylesheet <em>Stylesheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stylesheet</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSInstance#getStylesheet()
	 * @see #getCSSInstance()
	 * @generated
	 */
	EReference getCSSInstance_Stylesheet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSInstance#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSInstance#getStyle()
	 * @see #getCSSInstance()
	 * @generated
	 */
	EAttribute getCSSInstance_Style();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHidePropertySetter <em>CSS Hide Property Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CSS Hide Property Setter</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHidePropertySetter
	 * @generated
	 */
	EClass getCSSHidePropertySetter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideType <em>CSS Hide Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CSS Hide Type</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideType
	 * @generated
	 */
	EClass getCSSHideType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideInstance <em>CSS Hide Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CSS Hide Instance</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideInstance
	 * @generated
	 */
	EClass getCSSHideInstance();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideInstance#getStylesheet <em>Stylesheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stylesheet</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideInstance#getStylesheet()
	 * @see #getCSSHideInstance()
	 * @generated
	 */
	EReference getCSSHideInstance_Stylesheet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideInstance#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.CSSHideInstance#getStyle()
	 * @see #getCSSHideInstance()
	 * @generated
	 */
	EAttribute getCSSHideInstance_Style();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerState <em>Layer State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Layer State</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerState
	 * @generated
	 */
	EEnum getLayerState();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.EventLevel <em>Event Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Event Level</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.EventLevel
	 * @generated
	 */
	EEnum getEventLevel();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getString();

	/**
	 * Returns the meta object for data type '<em>boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>boolean</em>'.
	 * @model instanceClass="boolean"
	 * @generated
	 */
	EDataType getboolean();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.ecore.EPackage <em>EPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EPackage</em>'.
	 * @see org.eclipse.emf.ecore.EPackage
	 * @model instanceClass="org.eclipse.emf.ecore.EPackage"
	 * @generated
	 */
	EDataType getEPackage();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Exception</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException
	 * @model instanceClass="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException"
	 * @generated
	 */
	EDataType getLayersException();

	/**
	 * Returns the meta object for data type '<em>int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>int</em>'.
	 * @model instanceClass="int"
	 * @generated
	 */
	EDataType getint();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.BadStateException <em>Bad State Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Bad State Exception</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.BadStateException
	 * @model instanceClass="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.BadStateException"
	 *        extendedMetaData="baseType='LayersException'"
	 * @generated
	 */
	EDataType getBadStateException();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException <em>Not Found Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Not Found Exception</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException
	 * @model instanceClass="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException"
	 *        extendedMetaData="baseType='LayersException'"
	 * @generated
	 */
	EDataType getNotFoundException();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand <em>Compute Property Value Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Compute Property Value Command</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand
	 * @model instanceClass="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand"
	 * @generated
	 */
	EDataType getComputePropertyValueCommand();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getObject();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.operators.CustomPropertyOperatorsInstance <em>Custom Property Opertor Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Custom Property Opertor Instance</em>'.
	 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.operators.CustomPropertyOperatorsInstance
	 * @model instanceClass="org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.operators.CustomPropertyOperatorsInstance"
	 * @generated
	 */
	EDataType getCustomPropertyOpertorInstance();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LayersFactory getLayersFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerNamedStyleImpl <em>Layer Named Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerNamedStyleImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerNamedStyle()
		 * @generated
		 */
		EClass LAYER_NAMED_STYLE = eINSTANCE.getLayerNamedStyle();

		/**
		 * The meta object literal for the '<em><b>Layers Stack</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_NAMED_STYLE__LAYERS_STACK = eINSTANCE.getLayerNamedStyle_LayersStack();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersStackImpl <em>Stack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersStackImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayersStack()
		 * @generated
		 */
		EClass LAYERS_STACK = eINSTANCE.getLayersStack();

		/**
		 * The meta object literal for the '<em><b>Layers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYERS_STACK__LAYERS = eINSTANCE.getLayersStack_Layers();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYERS_STACK__NAME = eINSTANCE.getLayersStack_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYERS_STACK__DESCRIPTION = eINSTANCE.getLayersStack_Description();

		/**
		 * The meta object literal for the '<em><b>Diagram</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYERS_STACK__DIAGRAM = eINSTANCE.getLayersStack_Diagram();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYERS_STACK__STATE = eINSTANCE.getLayersStack_State();

		/**
		 * The meta object literal for the '<em><b>Get Compute Property Value Command</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_STACK___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY = eINSTANCE.getLayersStack__GetComputePropertyValueCommand__View_Property();

		/**
		 * The meta object literal for the '<em><b>Get Properties Compute Property Value Command</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_STACK___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST = eINSTANCE.getLayersStack__GetPropertiesComputePropertyValueCommand__View_EList();

		/**
		 * The meta object literal for the '<em><b>Get Views Compute Property Value Command</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_STACK___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY = eINSTANCE.getLayersStack__GetViewsComputePropertyValueCommand__EList_Property();

		/**
		 * The meta object literal for the '<em><b>Start After Creation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_STACK___START_AFTER_CREATION = eINSTANCE.getLayersStack__StartAfterCreation();

		/**
		 * The meta object literal for the '<em><b>Attach Layers</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_STACK___ATTACH_LAYERS = eINSTANCE.getLayersStack__AttachLayers();

		/**
		 * The meta object literal for the '<em><b>Attach</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_STACK___ATTACH = eINSTANCE.getLayersStack__Attach();

		/**
		 * The meta object literal for the '<em><b>Detach</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_STACK___DETACH = eINSTANCE.getLayersStack__Detach();

		/**
		 * The meta object literal for the '<em><b>Enter Attached State</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_STACK___ENTER_ATTACHED_STATE = eINSTANCE.getLayersStack__EnterAttachedState();

		/**
		 * The meta object literal for the '<em><b>Exit Attached State</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_STACK___EXIT_ATTACHED_STATE = eINSTANCE.getLayersStack__ExitAttachedState();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl <em>Layer Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerExpressionImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerExpression()
		 * @generated
		 */
		EClass LAYER_EXPRESSION = eINSTANCE.getLayerExpression();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER_EXPRESSION__NAME = eINSTANCE.getLayerExpression_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER_EXPRESSION__DESCRIPTION = eINSTANCE.getLayerExpression_Description();

		/**
		 * The meta object literal for the '<em><b>Is Layer Enabled Internal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER_EXPRESSION__IS_LAYER_ENABLED_INTERNAL = eINSTANCE.getLayerExpression_IsLayerEnabledInternal();

		/**
		 * The meta object literal for the '<em><b>Is Layer Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER_EXPRESSION__IS_LAYER_ENABLED = eINSTANCE.getLayerExpression_IsLayerEnabled();

		/**
		 * The meta object literal for the '<em><b>Is Branch Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER_EXPRESSION__IS_BRANCH_ENABLED = eINSTANCE.getLayerExpression_IsBranchEnabled();

		/**
		 * The meta object literal for the '<em><b>Owning Layers Stack</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_EXPRESSION__OWNING_LAYERS_STACK = eINSTANCE.getLayerExpression_OwningLayersStack();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER_EXPRESSION__STATE = eINSTANCE.getLayerExpression_State();

		/**
		 * The meta object literal for the '<em><b>Get Compute Property Value Command</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_EXPRESSION___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY = eINSTANCE.getLayerExpression__GetComputePropertyValueCommand__View_Property();

		/**
		 * The meta object literal for the '<em><b>Get Views Compute Property Value Command</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_EXPRESSION___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY = eINSTANCE.getLayerExpression__GetViewsComputePropertyValueCommand__EList_Property();

		/**
		 * The meta object literal for the '<em><b>Get Properties Compute Property Value Command</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_EXPRESSION___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST = eINSTANCE.getLayerExpression__GetPropertiesComputePropertyValueCommand__View_EList();

		/**
		 * The meta object literal for the '<em><b>Attach To Layers Stack</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_EXPRESSION___ATTACH_TO_LAYERS_STACK__LAYERSSTACK = eINSTANCE.getLayerExpression__AttachToLayersStack__LayersStack();

		/**
		 * The meta object literal for the '<em><b>Get Layers Stack</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_EXPRESSION___GET_LAYERS_STACK = eINSTANCE.getLayerExpression__GetLayersStack();

		/**
		 * The meta object literal for the '<em><b>Enter Attached State</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_EXPRESSION___ENTER_ATTACHED_STATE = eINSTANCE.getLayerExpression__EnterAttachedState();

		/**
		 * The meta object literal for the '<em><b>Attach</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_EXPRESSION___ATTACH = eINSTANCE.getLayerExpression__Attach();

		/**
		 * The meta object literal for the '<em><b>Detach</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_EXPRESSION___DETACH = eINSTANCE.getLayerExpression__Detach();

		/**
		 * The meta object literal for the '<em><b>Exit Attached State</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_EXPRESSION___EXIT_ATTACHED_STATE = eINSTANCE.getLayerExpression__ExitAttachedState();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.ApplicationDependantElementImpl <em>Application Dependant Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.ApplicationDependantElementImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getApplicationDependantElement()
		 * @generated
		 */
		EClass APPLICATION_DEPENDANT_ELEMENT = eINSTANCE.getApplicationDependantElement();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_DEPENDANT_ELEMENT__APPLICATION = eINSTANCE.getApplicationDependantElement_Application();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersStackApplicationImpl <em>Stack Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersStackApplicationImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayersStackApplication()
		 * @generated
		 */
		EClass LAYERS_STACK_APPLICATION = eINSTANCE.getLayersStackApplication();

		/**
		 * The meta object literal for the '<em><b>Layers Stacks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYERS_STACK_APPLICATION__LAYERS_STACKS = eINSTANCE.getLayersStackApplication_LayersStacks();

		/**
		 * The meta object literal for the '<em><b>Layer Stack Registry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY = eINSTANCE.getLayersStackApplication_LayerStackRegistry();

		/**
		 * The meta object literal for the '<em><b>Property Registry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY = eINSTANCE.getLayersStackApplication_PropertyRegistry();

		/**
		 * The meta object literal for the '<em><b>Layer Descriptor Registry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY = eINSTANCE.getLayersStackApplication_LayerDescriptorRegistry();

		/**
		 * The meta object literal for the '<em><b>Factory</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYERS_STACK_APPLICATION__FACTORY = eINSTANCE.getLayersStackApplication_Factory();

		/**
		 * The meta object literal for the '<em><b>Property Setter Registry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY = eINSTANCE.getLayersStackApplication_PropertySetterRegistry();

		/**
		 * The meta object literal for the '<em><b>Layer Operator Descriptor Registry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY = eINSTANCE.getLayersStackApplication_LayerOperatorDescriptorRegistry();

		/**
		 * The meta object literal for the '<em><b>Get Layers Stack For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_STACK_APPLICATION___GET_LAYERS_STACK_FOR__DIAGRAM = eINSTANCE.getLayersStackApplication__GetLayersStackFor__Diagram();

		/**
		 * The meta object literal for the '<em><b>Remove Layers Stack For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_STACK_APPLICATION___REMOVE_LAYERS_STACK_FOR__DIAGRAM = eINSTANCE.getLayersStackApplication__RemoveLayersStackFor__Diagram();

		/**
		 * The meta object literal for the '<em><b>Is Layers Stack Attached For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_STACK_APPLICATION___IS_LAYERS_STACK_ATTACHED_FOR__DIAGRAM = eINSTANCE.getLayersStackApplication__IsLayersStackAttachedFor__Diagram();

		/**
		 * The meta object literal for the '<em><b>Create Layers Stack For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_STACK_APPLICATION___CREATE_LAYERS_STACK_FOR__DIAGRAM = eINSTANCE.getLayersStackApplication__CreateLayersStackFor__Diagram();

		/**
		 * The meta object literal for the '<em><b>Lookup Layers Stack For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_STACK_APPLICATION___LOOKUP_LAYERS_STACK_FOR__DIAGRAM = eINSTANCE.getLayersStackApplication__LookupLayersStackFor__Diagram();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FolderElementImpl <em>Folder Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FolderElementImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFolderElement()
		 * @generated
		 */
		EClass FOLDER_ELEMENT = eINSTANCE.getFolderElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerStackDescriptorRegistryImpl <em>Layer Stack Descriptor Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerStackDescriptorRegistryImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerStackDescriptorRegistry()
		 * @generated
		 */
		EClass LAYER_STACK_DESCRIPTOR_REGISTRY = eINSTANCE.getLayerStackDescriptorRegistry();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyRegistryImpl <em>Property Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyRegistryImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getPropertyRegistry()
		 * @generated
		 */
		EClass PROPERTY_REGISTRY = eINSTANCE.getPropertyRegistry();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_REGISTRY__PROPERTIES = eINSTANCE.getPropertyRegistry_Properties();

		/**
		 * The meta object literal for the '<em><b>Type Registry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_REGISTRY__TYPE_REGISTRY = eINSTANCE.getPropertyRegistry_TypeRegistry();

		/**
		 * The meta object literal for the '<em><b>Properties Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_REGISTRY__PROPERTIES_COUNT = eINSTANCE.getPropertyRegistry_PropertiesCount();

		/**
		 * The meta object literal for the '<em><b>Get Property Index</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_REGISTRY___GET_PROPERTY_INDEX__STRING = eINSTANCE.getPropertyRegistry__GetPropertyIndex__String();

		/**
		 * The meta object literal for the '<em><b>Get Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_REGISTRY___GET_PROPERTY__STRING = eINSTANCE.getPropertyRegistry__GetProperty__String();

		/**
		 * The meta object literal for the '<em><b>Add Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_REGISTRY___ADD_PROPERTY__PROPERTY = eINSTANCE.getPropertyRegistry__AddProperty__Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__TYPE = eINSTANCE.getProperty_Type();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__DEFAULT_VALUE = eINSTANCE.getProperty_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__DESCRIPTION = eINSTANCE.getProperty_Description();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__INDEX = eINSTANCE.getProperty_Index();

		/**
		 * The meta object literal for the '<em><b>Create Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY___CREATE_INSTANCE = eINSTANCE.getProperty__CreateInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TypeImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE__METAMODEL = eINSTANCE.getType_Metamodel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__NAME = eINSTANCE.getType_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__DESCRIPTION = eINSTANCE.getType_Description();

		/**
		 * The meta object literal for the '<em><b>Create Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___CREATE_INSTANCE = eINSTANCE.getType__CreateInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.MetamodelImpl <em>Metamodel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.MetamodelImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getMetamodel()
		 * @generated
		 */
		EClass METAMODEL = eINSTANCE.getMetamodel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METAMODEL__NAME = eINSTANCE.getMetamodel_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METAMODEL__DESCRIPTION = eINSTANCE.getMetamodel_Description();

		/**
		 * The meta object literal for the '<em><b>Nsuri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METAMODEL__NSURI = eINSTANCE.getMetamodel_Nsuri();

		/**
		 * The meta object literal for the '<em><b>Plugin ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METAMODEL__PLUGIN_ID = eINSTANCE.getMetamodel_PluginID();

		/**
		 * The meta object literal for the '<em><b>EPackage Instance Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METAMODEL__EPACKAGE_INSTANCE_NAME = eINSTANCE.getMetamodel_EPackageInstanceName();

		/**
		 * The meta object literal for the '<em><b>Is Type Valid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METAMODEL__IS_TYPE_VALID = eINSTANCE.getMetamodel_IsTypeValid();

		/**
		 * The meta object literal for the '<em><b>Get EPackage</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation METAMODEL___GET_EPACKAGE = eINSTANCE.getMetamodel__GetEPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TypeInstanceImpl <em>Type Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TypeInstanceImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getTypeInstance()
		 * @generated
		 */
		EClass TYPE_INSTANCE = eINSTANCE.getTypeInstance();

		/**
		 * The meta object literal for the '<em><b>Set Value From String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_INSTANCE___SET_VALUE_FROM_STRING__STRING = eINSTANCE.getTypeInstance__SetValueFromString__String();

		/**
		 * The meta object literal for the '<em><b>Set Value From Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_INSTANCE___SET_VALUE_FROM_INSTANCE__TYPEINSTANCE = eINSTANCE.getTypeInstance__SetValueFromInstance__TypeInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand <em>Compute Property Value Command Itf</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getComputePropertyValueCommandItf()
		 * @generated
		 */
		EClass COMPUTE_PROPERTY_VALUE_COMMAND_ITF = eINSTANCE.getComputePropertyValueCommandItf();

		/**
		 * The meta object literal for the '<em><b>Get Cmd Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPUTE_PROPERTY_VALUE_COMMAND_ITF___GET_CMD_VALUE = eINSTANCE.getComputePropertyValueCommandItf__GetCmdValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TypeRegistryImpl <em>Type Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TypeRegistryImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getTypeRegistry()
		 * @generated
		 */
		EClass TYPE_REGISTRY = eINSTANCE.getTypeRegistry();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_REGISTRY__TYPES = eINSTANCE.getTypeRegistry_Types();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToTypeMapImpl <em>String To Type Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToTypeMapImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStringToTypeMap()
		 * @generated
		 */
		EClass STRING_TO_TYPE_MAP = eINSTANCE.getStringToTypeMap();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_TYPE_MAP__VALUE = eINSTANCE.getStringToTypeMap_Value();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_TYPE_MAP__KEY = eINSTANCE.getStringToTypeMap_Key();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerDescriptorRegistryImpl <em>Layer Descriptor Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerDescriptorRegistryImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerDescriptorRegistry()
		 * @generated
		 */
		EClass LAYER_DESCRIPTOR_REGISTRY = eINSTANCE.getLayerDescriptorRegistry();

		/**
		 * The meta object literal for the '<em><b>Layer Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_DESCRIPTOR_REGISTRY__LAYER_DESCRIPTORS = eINSTANCE.getLayerDescriptorRegistry_LayerDescriptors();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerDescriptorImpl <em>Layer Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerDescriptorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerDescriptor()
		 * @generated
		 */
		EClass LAYER_DESCRIPTOR = eINSTANCE.getLayerDescriptor();

		/**
		 * The meta object literal for the '<em><b>Property Registry</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_DESCRIPTOR__PROPERTY_REGISTRY = eINSTANCE.getLayerDescriptor_PropertyRegistry();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerApplicationFactoryImpl <em>Layer Application Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerApplicationFactoryImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerApplicationFactory()
		 * @generated
		 */
		EClass LAYER_APPLICATION_FACTORY = eINSTANCE.getLayerApplicationFactory();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_APPLICATION_FACTORY__APPLICATION = eINSTANCE.getLayerApplicationFactory_Application();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertySetterRegistryImpl <em>Property Setter Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertySetterRegistryImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getPropertySetterRegistry()
		 * @generated
		 */
		EClass PROPERTY_SETTER_REGISTRY = eINSTANCE.getPropertySetterRegistry();

		/**
		 * The meta object literal for the '<em><b>Property Setters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS = eINSTANCE.getPropertySetterRegistry_PropertySetters();

		/**
		 * The meta object literal for the '<em><b>Setter Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SETTER_REGISTRY__SETTER_MAP = eINSTANCE.getPropertySetterRegistry_SetterMap();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SETTER_REGISTRY__APPLICATION = eINSTANCE.getPropertySetterRegistry_Application();

		/**
		 * The meta object literal for the '<em><b>Get Property Setter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_SETTER_REGISTRY___GET_PROPERTY_SETTER__PROPERTY = eINSTANCE.getPropertySetterRegistry__GetPropertySetter__Property();

		/**
		 * The meta object literal for the '<em><b>Get Property Setter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_SETTER_REGISTRY___GET_PROPERTY_SETTER__STRING = eINSTANCE.getPropertySetterRegistry__GetPropertySetter__String();

		/**
		 * The meta object literal for the '<em><b>Add Property Setter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_SETTER_REGISTRY___ADD_PROPERTY_SETTER__PROPERTYSETTER = eINSTANCE.getPropertySetterRegistry__AddPropertySetter__PropertySetter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertySetterImpl <em>Property Setter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertySetterImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getPropertySetter()
		 * @generated
		 */
		EClass PROPERTY_SETTER = eINSTANCE.getPropertySetter();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SETTER__PROPERTY = eINSTANCE.getPropertySetter_Property();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_SETTER__PROPERTY_NAME = eINSTANCE.getPropertySetter_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Set Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE = eINSTANCE.getPropertySetter__SetValue__View_TypeInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToPropertySetterImpl <em>String To Property Setter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToPropertySetterImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStringToPropertySetter()
		 * @generated
		 */
		EClass STRING_TO_PROPERTY_SETTER = eINSTANCE.getStringToPropertySetter();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_PROPERTY_SETTER__KEY = eINSTANCE.getStringToPropertySetter_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_PROPERTY_SETTER__VALUE = eINSTANCE.getStringToPropertySetter_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorDescriptorRegistryImpl <em>Layer Operator Descriptor Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorDescriptorRegistryImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerOperatorDescriptorRegistry()
		 * @generated
		 */
		EClass LAYER_OPERATOR_DESCRIPTOR_REGISTRY = eINSTANCE.getLayerOperatorDescriptorRegistry();

		/**
		 * The meta object literal for the '<em><b>Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DESCRIPTORS = eINSTANCE.getLayerOperatorDescriptorRegistry_Descriptors();

		/**
		 * The meta object literal for the '<em><b>Property Operators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_OPERATORS = eINSTANCE.getLayerOperatorDescriptorRegistry_PropertyOperators();

		/**
		 * The meta object literal for the '<em><b>Property Collection Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_COLLECTION_SIZE = eINSTANCE.getLayerOperatorDescriptorRegistry_PropertyCollectionSize();

		/**
		 * The meta object literal for the '<em><b>Default Operator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DEFAULT_OPERATOR = eINSTANCE.getLayerOperatorDescriptorRegistry_DefaultOperator();

		/**
		 * The meta object literal for the '<em><b>Add Layer Operator Descriptor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ADD_LAYER_OPERATOR_DESCRIPTOR__LAYEROPERATORDESCRIPTOR = eINSTANCE.getLayerOperatorDescriptorRegistry__AddLayerOperatorDescriptor__LayerOperatorDescriptor();

		/**
		 * The meta object literal for the '<em><b>Get Layer Operator Descriptor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_OPERATOR_DESCRIPTOR_REGISTRY___GET_LAYER_OPERATOR_DESCRIPTOR__STRING = eINSTANCE.getLayerOperatorDescriptorRegistry__GetLayerOperatorDescriptor__String();

		/**
		 * The meta object literal for the '<em><b>Add Property Operator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ADD_PROPERTY_OPERATOR__PROPERTYOPERATOR = eINSTANCE.getLayerOperatorDescriptorRegistry__AddPropertyOperator__PropertyOperator();

		/**
		 * The meta object literal for the '<em><b>Get Property Operator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_OPERATOR_DESCRIPTOR_REGISTRY___GET_PROPERTY_OPERATOR__STRING = eINSTANCE.getLayerOperatorDescriptorRegistry__GetPropertyOperator__String();

		/**
		 * The meta object literal for the '<em><b>Attach Operator To Descriptor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ATTACH_OPERATOR_TO_DESCRIPTOR__PROPERTY_STRING_STRING = eINSTANCE.getLayerOperatorDescriptorRegistry__AttachOperatorToDescriptor__Property_String_String();

		/**
		 * The meta object literal for the '<em><b>Create Layer Operator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_OPERATOR_DESCRIPTOR_REGISTRY___CREATE_LAYER_OPERATOR__STRING = eINSTANCE.getLayerOperatorDescriptorRegistry__CreateLayerOperator__String();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorDescriptorImpl <em>Layer Operator Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorDescriptorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerOperatorDescriptor()
		 * @generated
		 */
		EClass LAYER_OPERATOR_DESCRIPTOR = eINSTANCE.getLayerOperatorDescriptor();

		/**
		 * The meta object literal for the '<em><b>Property Operators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS = eINSTANCE.getLayerOperatorDescriptor_PropertyOperators();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER_OPERATOR_DESCRIPTOR__NAME = eINSTANCE.getLayerOperatorDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Get Property Operator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_OPERATOR_DESCRIPTOR___GET_PROPERTY_OPERATOR__PROPERTY = eINSTANCE.getLayerOperatorDescriptor__GetPropertyOperator__Property();

		/**
		 * The meta object literal for the '<em><b>Set Property Operator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_OPERATOR__PROPERTY_PROPERTYOPERATOR = eINSTANCE.getLayerOperatorDescriptor__SetPropertyOperator__Property_PropertyOperator();

		/**
		 * The meta object literal for the '<em><b>Create Layer Operator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_OPERATOR_DESCRIPTOR___CREATE_LAYER_OPERATOR = eINSTANCE.getLayerOperatorDescriptor__CreateLayerOperator();

		/**
		 * The meta object literal for the '<em><b>Set Property Collection Size</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_COLLECTION_SIZE__INT_DEFAULTPROPERTYOPERATOR = eINSTANCE.getLayerOperatorDescriptor__SetPropertyCollectionSize__int_DefaultPropertyOperator();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyOperatorImpl <em>Property Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyOperatorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getPropertyOperator()
		 * @generated
		 */
		EClass PROPERTY_OPERATOR = eINSTANCE.getPropertyOperator();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_OPERATOR__NAME = eINSTANCE.getPropertyOperator_Name();

		/**
		 * The meta object literal for the '<em><b>Get Compute Property Value Command</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST = eINSTANCE.getPropertyOperator__GetComputePropertyValueCommand__EList();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AbstractLayerOperatorImpl <em>Abstract Layer Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AbstractLayerOperatorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getAbstractLayerOperator()
		 * @generated
		 */
		EClass ABSTRACT_LAYER_OPERATOR = eINSTANCE.getAbstractLayerOperator();

		/**
		 * The meta object literal for the '<em><b>Layer Operator Descriptor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR = eINSTANCE.getAbstractLayerOperator_LayerOperatorDescriptor();

		/**
		 * The meta object literal for the '<em><b>Layer Operator Descriptor Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME = eINSTANCE.getAbstractLayerOperator_LayerOperatorDescriptorName();

		/**
		 * The meta object literal for the '<em><b>Is Descriptor Set</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_LAYER_OPERATOR___IS_DESCRIPTOR_SET = eINSTANCE.getAbstractLayerOperator__IsDescriptorSet();

		/**
		 * The meta object literal for the '<em><b>Reset Descriptor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_LAYER_OPERATOR___RESET_DESCRIPTOR = eINSTANCE.getAbstractLayerOperator__ResetDescriptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorImpl <em>Layer Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerOperatorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerOperator()
		 * @generated
		 */
		EClass LAYER_OPERATOR = eINSTANCE.getLayerOperator();

		/**
		 * The meta object literal for the '<em><b>Layers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_OPERATOR__LAYERS = eINSTANCE.getLayerOperator_Layers();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersContainer <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayersContainer
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayersContainer()
		 * @generated
		 */
		EClass LAYERS_CONTAINER = eINSTANCE.getLayersContainer();

		/**
		 * The meta object literal for the '<em><b>Add Layer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYERS_CONTAINER___ADD_LAYER__LAYEREXPRESSION = eINSTANCE.getLayersContainer__AddLayer__LayerExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.DefaultPropertyOperatorImpl <em>Default Property Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.DefaultPropertyOperatorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getDefaultPropertyOperator()
		 * @generated
		 */
		EClass DEFAULT_PROPERTY_OPERATOR = eINSTANCE.getDefaultPropertyOperator();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AbstractLayerImpl <em>Abstract Layer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AbstractLayerImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getAbstractLayer()
		 * @generated
		 */
		EClass ABSTRACT_LAYER = eINSTANCE.getAbstractLayer();

		/**
		 * The meta object literal for the '<em><b>Property Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_LAYER__PROPERTY_VALUES = eINSTANCE.getAbstractLayer_PropertyValues();

		/**
		 * The meta object literal for the '<em><b>Property Value Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_LAYER__PROPERTY_VALUE_MAP = eINSTANCE.getAbstractLayer_PropertyValueMap();

		/**
		 * The meta object literal for the '<em><b>Layer Descriptor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_LAYER__LAYER_DESCRIPTOR = eINSTANCE.getAbstractLayer_LayerDescriptor();

		/**
		 * The meta object literal for the '<em><b>Views</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_LAYER__VIEWS = eINSTANCE.getAbstractLayer_Views();

		/**
		 * The meta object literal for the '<em><b>Attached Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_LAYER__ATTACHED_PROPERTIES = eINSTANCE.getAbstractLayer_AttachedProperties();

		/**
		 * The meta object literal for the '<em><b>Add Property Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_LAYER___ADD_PROPERTY_INSTANCE__PROPERTY = eINSTANCE.getAbstractLayer__AddPropertyInstance__Property();

		/**
		 * The meta object literal for the '<em><b>Remove Property Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_LAYER___REMOVE_PROPERTY_INSTANCE__PROPERTY = eINSTANCE.getAbstractLayer__RemovePropertyInstance__Property();

		/**
		 * The meta object literal for the '<em><b>Get Property Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__PROPERTY = eINSTANCE.getAbstractLayer__GetPropertyInstance__Property();

		/**
		 * The meta object literal for the '<em><b>Get Property Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__STRING = eINSTANCE.getAbstractLayer__GetPropertyInstance__String();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToTypeInstanceMapImpl <em>String To Type Instance Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToTypeInstanceMapImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStringToTypeInstanceMap()
		 * @generated
		 */
		EClass STRING_TO_TYPE_INSTANCE_MAP = eINSTANCE.getStringToTypeInstanceMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_TYPE_INSTANCE_MAP__KEY = eINSTANCE.getStringToTypeInstanceMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_TYPE_INSTANCE_MAP__VALUE = eINSTANCE.getStringToTypeInstanceMap_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FolderImpl <em>Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FolderImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFolder()
		 * @generated
		 */
		EClass FOLDER = eINSTANCE.getFolder();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOLDER__ELEMENTS = eINSTANCE.getFolder_Elements();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOLDER__NAME = eINSTANCE.getFolder_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IntInstanceImpl <em>Int Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IntInstanceImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getIntInstance()
		 * @generated
		 */
		EClass INT_INSTANCE = eINSTANCE.getIntInstance();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_INSTANCE__VALUE = eINSTANCE.getIntInstance_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.BooleanInstanceImpl <em>Boolean Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.BooleanInstanceImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getBooleanInstance()
		 * @generated
		 */
		EClass BOOLEAN_INSTANCE = eINSTANCE.getBooleanInstance();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_INSTANCE__VALUE = eINSTANCE.getBooleanInstance_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringInstanceImpl <em>String Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringInstanceImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStringInstance()
		 * @generated
		 */
		EClass STRING_INSTANCE = eINSTANCE.getStringInstance();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_INSTANCE__VALUE = eINSTANCE.getStringInstance_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IntTypeImpl <em>Int Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IntTypeImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getIntType()
		 * @generated
		 */
		EClass INT_TYPE = eINSTANCE.getIntType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.BooleanTypeImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringTypeImpl <em>String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringTypeImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getStringType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CustomTypeImpl <em>Custom Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CustomTypeImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCustomType()
		 * @generated
		 */
		EClass CUSTOM_TYPE = eINSTANCE.getCustomType();

		/**
		 * The meta object literal for the '<em><b>Classifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_TYPE__CLASSIFIER = eINSTANCE.getCustomType_Classifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TopLayerOperatorImpl <em>Top Layer Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TopLayerOperatorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getTopLayerOperator()
		 * @generated
		 */
		EClass TOP_LAYER_OPERATOR = eINSTANCE.getTopLayerOperator();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StackedLayerOperatorImpl <em>Stacked Layer Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StackedLayerOperatorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStackedLayerOperator()
		 * @generated
		 */
		EClass STACKED_LAYER_OPERATOR = eINSTANCE.getStackedLayerOperator();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CustomLayerOperatorImpl <em>Custom Layer Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CustomLayerOperatorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCustomLayerOperator()
		 * @generated
		 */
		EClass CUSTOM_LAYER_OPERATOR = eINSTANCE.getCustomLayerOperator();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyIndexImpl <em>Property Index</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.PropertyIndexImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getPropertyIndex()
		 * @generated
		 */
		EClass PROPERTY_INDEX = eINSTANCE.getPropertyIndex();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_INDEX__PROPERTY = eINSTANCE.getPropertyIndex_Property();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_INDEX__INDEX = eINSTANCE.getPropertyIndex_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToPropertyIndexMapImpl <em>String To Property Index Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StringToPropertyIndexMapImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStringToPropertyIndexMap()
		 * @generated
		 */
		EClass STRING_TO_PROPERTY_INDEX_MAP = eINSTANCE.getStringToPropertyIndexMap();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_PROPERTY_INDEX_MAP__VALUE = eINSTANCE.getStringToPropertyIndexMap_Value();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_PROPERTY_INDEX_MAP__KEY = eINSTANCE.getStringToPropertyIndexMap_Key();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.SimpleLayerDescriptorImpl <em>Simple Layer Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.SimpleLayerDescriptorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getSimpleLayerDescriptor()
		 * @generated
		 */
		EClass SIMPLE_LAYER_DESCRIPTOR = eINSTANCE.getSimpleLayerDescriptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.RegExpLayerDescriptorImpl <em>Reg Exp Layer Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.RegExpLayerDescriptorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getRegExpLayerDescriptor()
		 * @generated
		 */
		EClass REG_EXP_LAYER_DESCRIPTOR = eINSTANCE.getRegExpLayerDescriptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.NullInstanceImpl <em>Null Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.NullInstanceImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getNullInstance()
		 * @generated
		 */
		EClass NULL_INSTANCE = eINSTANCE.getNullInstance();

		/**
		 * The meta object literal for the '<em><b>Get Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NULL_INSTANCE___GET_INSTANCE = eINSTANCE.getNullInstance__GetInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.RegExpLayerImpl <em>Reg Exp Layer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.RegExpLayerImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getRegExpLayer()
		 * @generated
		 */
		EClass REG_EXP_LAYER = eINSTANCE.getRegExpLayer();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REG_EXP_LAYER__EXPR = eINSTANCE.getRegExpLayer_Expr();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REG_EXP_LAYER__LANGUAGE = eINSTANCE.getRegExpLayer_Language();

		/**
		 * The meta object literal for the '<em><b>Is Domain Changed Event Dependant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REG_EXP_LAYER__IS_DOMAIN_CHANGED_EVENT_DEPENDANT = eINSTANCE.getRegExpLayer_IsDomainChangedEventDependant();

		/**
		 * The meta object literal for the '<em><b>Domain Changed Event Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REG_EXP_LAYER__DOMAIN_CHANGED_EVENT_LEVEL = eINSTANCE.getRegExpLayer_DomainChangedEventLevel();

		/**
		 * The meta object literal for the '<em><b>Is Diagram Changed Event Dependant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REG_EXP_LAYER__IS_DIAGRAM_CHANGED_EVENT_DEPENDANT = eINSTANCE.getRegExpLayer_IsDiagramChangedEventDependant();

		/**
		 * The meta object literal for the '<em><b>Diagram Changed Event Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REG_EXP_LAYER__DIAGRAM_CHANGED_EVENT_LEVEL = eINSTANCE.getRegExpLayer_DiagramChangedEventLevel();

		/**
		 * The meta object literal for the '<em><b>Expression Context Object Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REG_EXP_LAYER__EXPRESSION_CONTEXT_OBJECT_TYPE = eINSTANCE.getRegExpLayer_ExpressionContextObjectType();

		/**
		 * The meta object literal for the '<em><b>Activate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REG_EXP_LAYER___ACTIVATE__ABSTRACTLAYEROPERATOR = eINSTANCE.getRegExpLayer__Activate__AbstractLayerOperator();

		/**
		 * The meta object literal for the '<em><b>Deactivate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REG_EXP_LAYER___DEACTIVATE__ABSTRACTLAYEROPERATOR = eINSTANCE.getRegExpLayer__Deactivate__AbstractLayerOperator();

		/**
		 * The meta object literal for the '<em><b>Is Derived View</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REG_EXP_LAYER___IS_DERIVED_VIEW__VIEW = eINSTANCE.getRegExpLayer__IsDerivedView__View();

		/**
		 * The meta object literal for the '<em><b>Attach Derived View</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REG_EXP_LAYER___ATTACH_DERIVED_VIEW__VIEW = eINSTANCE.getRegExpLayer__AttachDerivedView__View();

		/**
		 * The meta object literal for the '<em><b>Attach Derived Views</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REG_EXP_LAYER___ATTACH_DERIVED_VIEWS__ELIST = eINSTANCE.getRegExpLayer__AttachDerivedViews__EList();

		/**
		 * The meta object literal for the '<em><b>Attach Derived Views</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REG_EXP_LAYER___ATTACH_DERIVED_VIEWS = eINSTANCE.getRegExpLayer__AttachDerivedViews();

		/**
		 * The meta object literal for the '<em><b>Lookup Derived Views</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REG_EXP_LAYER___LOOKUP_DERIVED_VIEWS__ELIST = eINSTANCE.getRegExpLayer__LookupDerivedViews__EList();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerImpl <em>Layer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayerImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayer()
		 * @generated
		 */
		EClass LAYER = eINSTANCE.getLayer();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.ColorImpl <em>Color</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.ColorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getColor()
		 * @generated
		 */
		EClass COLOR = eINSTANCE.getColor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.ColorInstanceImpl <em>Color Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.ColorInstanceImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getColorInstance()
		 * @generated
		 */
		EClass COLOR_INSTANCE = eINSTANCE.getColorInstance();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_INSTANCE__VALUE = eINSTANCE.getColorInstance_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FillInstanceImpl <em>Fill Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FillInstanceImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFillInstance()
		 * @generated
		 */
		EClass FILL_INSTANCE = eINSTANCE.getFillInstance();

		/**
		 * The meta object literal for the '<em><b>Transparency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILL_INSTANCE__TRANSPARENCY = eINSTANCE.getFillInstance_Transparency();

		/**
		 * The meta object literal for the '<em><b>Fill Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILL_INSTANCE__FILL_COLOR = eINSTANCE.getFillInstance_FillColor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FillImpl <em>Fill</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FillImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFill()
		 * @generated
		 */
		EClass FILL = eINSTANCE.getFill();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FillPropertySetterImpl <em>Fill Property Setter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FillPropertySetterImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFillPropertySetter()
		 * @generated
		 */
		EClass FILL_PROPERTY_SETTER = eINSTANCE.getFillPropertySetter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IsValidPropertySetterImpl <em>Is Valid Property Setter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IsValidPropertySetterImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getIsValidPropertySetter()
		 * @generated
		 */
		EClass IS_VALID_PROPERTY_SETTER = eINSTANCE.getIsValidPropertySetter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.NullPropertySetterImpl <em>Null Property Setter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.NullPropertySetterImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getNullPropertySetter()
		 * @generated
		 */
		EClass NULL_PROPERTY_SETTER = eINSTANCE.getNullPropertySetter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LineTypeImpl <em>Line Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LineTypeImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLineType()
		 * @generated
		 */
		EClass LINE_TYPE = eINSTANCE.getLineType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LineInstanceImpl <em>Line Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LineInstanceImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLineInstance()
		 * @generated
		 */
		EClass LINE_INSTANCE = eINSTANCE.getLineInstance();

		/**
		 * The meta object literal for the '<em><b>Line Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE_INSTANCE__LINE_COLOR = eINSTANCE.getLineInstance_LineColor();

		/**
		 * The meta object literal for the '<em><b>Line With</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE_INSTANCE__LINE_WITH = eINSTANCE.getLineInstance_LineWith();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LinePropertySetterImpl <em>Line Property Setter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LinePropertySetterImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLinePropertySetter()
		 * @generated
		 */
		EClass LINE_PROPERTY_SETTER = eINSTANCE.getLinePropertySetter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FontPropertySetterImpl <em>Font Property Setter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FontPropertySetterImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFontPropertySetter()
		 * @generated
		 */
		EClass FONT_PROPERTY_SETTER = eINSTANCE.getFontPropertySetter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FontInstanceImpl <em>Font Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FontInstanceImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFontInstance()
		 * @generated
		 */
		EClass FONT_INSTANCE = eINSTANCE.getFontInstance();

		/**
		 * The meta object literal for the '<em><b>Font Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT_INSTANCE__FONT_COLOR = eINSTANCE.getFontInstance_FontColor();

		/**
		 * The meta object literal for the '<em><b>Font Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT_INSTANCE__FONT_NAME = eINSTANCE.getFontInstance_FontName();

		/**
		 * The meta object literal for the '<em><b>Font Heigh</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT_INSTANCE__FONT_HEIGH = eINSTANCE.getFontInstance_FontHeigh();

		/**
		 * The meta object literal for the '<em><b>Bold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT_INSTANCE__BOLD = eINSTANCE.getFontInstance_Bold();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FontTypeImpl <em>Font Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.FontTypeImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getFontType()
		 * @generated
		 */
		EClass FONT_TYPE = eINSTANCE.getFontType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IsVisiblePropertySetterImpl <em>Is Visible Property Setter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IsVisiblePropertySetterImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getIsVisiblePropertySetter()
		 * @generated
		 */
		EClass IS_VISIBLE_PROPERTY_SETTER = eINSTANCE.getIsVisiblePropertySetter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TopLayerOperatorDescriptorImpl <em>Top Layer Operator Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.TopLayerOperatorDescriptorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getTopLayerOperatorDescriptor()
		 * @generated
		 */
		EClass TOP_LAYER_OPERATOR_DESCRIPTOR = eINSTANCE.getTopLayerOperatorDescriptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StackedLayerOperatorDescriptorImpl <em>Stacked Layer Operator Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.StackedLayerOperatorDescriptorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getStackedLayerOperatorDescriptor()
		 * @generated
		 */
		EClass STACKED_LAYER_OPERATOR_DESCRIPTOR = eINSTANCE.getStackedLayerOperatorDescriptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CustomPropertyOperatorImpl <em>Custom Property Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CustomPropertyOperatorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCustomPropertyOperator()
		 * @generated
		 */
		EClass CUSTOM_PROPERTY_OPERATOR = eINSTANCE.getCustomPropertyOperator();

		/**
		 * The meta object literal for the '<em><b>Classname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_PROPERTY_OPERATOR__CLASSNAME = eINSTANCE.getCustomPropertyOperator_Classname();

		/**
		 * The meta object literal for the '<em><b>Operator Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_PROPERTY_OPERATOR__OPERATOR_INSTANCE = eINSTANCE.getCustomPropertyOperator_OperatorInstance();

		/**
		 * The meta object literal for the '<em><b>Class Bundle ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_PROPERTY_OPERATOR__CLASS_BUNDLE_ID = eINSTANCE.getCustomPropertyOperator_ClassBundleID();

		/**
		 * The meta object literal for the '<em><b>Reset Operator Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CUSTOM_PROPERTY_OPERATOR___RESET_OPERATOR_INSTANCE = eINSTANCE.getCustomPropertyOperator__ResetOperatorInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AndStackedLayerOperatorDescriptorImpl <em>And Stacked Layer Operator Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AndStackedLayerOperatorDescriptorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getAndStackedLayerOperatorDescriptor()
		 * @generated
		 */
		EClass AND_STACKED_LAYER_OPERATOR_DESCRIPTOR = eINSTANCE.getAndStackedLayerOperatorDescriptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.OrStackedLayerOperatorDescriptorImpl <em>Or Stacked Layer Operator Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.OrStackedLayerOperatorDescriptorImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getOrStackedLayerOperatorDescriptor()
		 * @generated
		 */
		EClass OR_STACKED_LAYER_OPERATOR_DESCRIPTOR = eINSTANCE.getOrStackedLayerOperatorDescriptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IsAbstractUmlSetterImpl <em>Is Abstract Uml Setter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.IsAbstractUmlSetterImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getIsAbstractUmlSetter()
		 * @generated
		 */
		EClass IS_ABSTRACT_UML_SETTER = eINSTANCE.getIsAbstractUmlSetter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AllViewsDerivedLayerImpl <em>All Views Derived Layer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.AllViewsDerivedLayerImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getAllViewsDerivedLayer()
		 * @generated
		 */
		EClass ALL_VIEWS_DERIVED_LAYER = eINSTANCE.getAllViewsDerivedLayer();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSPropertySetterImpl <em>CSS Property Setter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSPropertySetterImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCSSPropertySetter()
		 * @generated
		 */
		EClass CSS_PROPERTY_SETTER = eINSTANCE.getCSSPropertySetter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSTypeImpl <em>CSS Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSTypeImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCSSType()
		 * @generated
		 */
		EClass CSS_TYPE = eINSTANCE.getCSSType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSInstanceImpl <em>CSS Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSInstanceImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCSSInstance()
		 * @generated
		 */
		EClass CSS_INSTANCE = eINSTANCE.getCSSInstance();

		/**
		 * The meta object literal for the '<em><b>Stylesheet</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CSS_INSTANCE__STYLESHEET = eINSTANCE.getCSSInstance_Stylesheet();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CSS_INSTANCE__STYLE = eINSTANCE.getCSSInstance_Style();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHidePropertySetterImpl <em>CSS Hide Property Setter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHidePropertySetterImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCSSHidePropertySetter()
		 * @generated
		 */
		EClass CSS_HIDE_PROPERTY_SETTER = eINSTANCE.getCSSHidePropertySetter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHideTypeImpl <em>CSS Hide Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHideTypeImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCSSHideType()
		 * @generated
		 */
		EClass CSS_HIDE_TYPE = eINSTANCE.getCSSHideType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHideInstanceImpl <em>CSS Hide Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.CSSHideInstanceImpl
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCSSHideInstance()
		 * @generated
		 */
		EClass CSS_HIDE_INSTANCE = eINSTANCE.getCSSHideInstance();

		/**
		 * The meta object literal for the '<em><b>Stylesheet</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CSS_HIDE_INSTANCE__STYLESHEET = eINSTANCE.getCSSHideInstance_Stylesheet();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CSS_HIDE_INSTANCE__STYLE = eINSTANCE.getCSSHideInstance_Style();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerState <em>Layer State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.LayerState
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayerState()
		 * @generated
		 */
		EEnum LAYER_STATE = eINSTANCE.getLayerState();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.EventLevel <em>Event Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.EventLevel
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getEventLevel()
		 * @generated
		 */
		EEnum EVENT_LEVEL = eINSTANCE.getEventLevel();

		/**
		 * The meta object literal for the '<em>String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getString()
		 * @generated
		 */
		EDataType STRING = eINSTANCE.getString();

		/**
		 * The meta object literal for the '<em>boolean</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getboolean()
		 * @generated
		 */
		EDataType BOOLEAN = eINSTANCE.getboolean();

		/**
		 * The meta object literal for the '<em>EPackage</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecore.EPackage
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getEPackage()
		 * @generated
		 */
		EDataType EPACKAGE = eINSTANCE.getEPackage();

		/**
		 * The meta object literal for the '<em>Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.LayersException
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getLayersException()
		 * @generated
		 */
		EDataType LAYERS_EXCEPTION = eINSTANCE.getLayersException();

		/**
		 * The meta object literal for the '<em>int</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getint()
		 * @generated
		 */
		EDataType INT = eINSTANCE.getint();

		/**
		 * The meta object literal for the '<em>Bad State Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.BadStateException
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getBadStateException()
		 * @generated
		 */
		EDataType BAD_STATE_EXCEPTION = eINSTANCE.getBadStateException();

		/**
		 * The meta object literal for the '<em>Not Found Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.NotFoundException
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getNotFoundException()
		 * @generated
		 */
		EDataType NOT_FOUND_EXCEPTION = eINSTANCE.getNotFoundException();

		/**
		 * The meta object literal for the '<em>Compute Property Value Command</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.command.ComputePropertyValueCommand
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getComputePropertyValueCommand()
		 * @generated
		 */
		EDataType COMPUTE_PROPERTY_VALUE_COMMAND = eINSTANCE.getComputePropertyValueCommand();

		/**
		 * The meta object literal for the '<em>Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getObject()
		 * @generated
		 */
		EDataType OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em>Custom Property Opertor Instance</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.operators.CustomPropertyOperatorsInstance
		 * @see org.eclipse.papyrus.internal.infra.gmfdiag.layers.model.layers.impl.LayersPackageImpl#getCustomPropertyOpertorInstance()
		 * @generated
		 */
		EDataType CUSTOM_PROPERTY_OPERTOR_INSTANCE = eINSTANCE.getCustomPropertyOpertorInstance();

	}

} // LayersPackage
