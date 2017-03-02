/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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
package org.eclipse.papyrus.infra.gmfdiag.elk.tests.classdiag;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.compare.ITypedElement;
import org.eclipse.compare.internal.BufferedResourceNode;
import org.eclipse.compare.structuremergeviewer.DiffNode;
import org.eclipse.compare.structuremergeviewer.Differencer;
import org.eclipse.compare.structuremergeviewer.IDiffContainer;
import org.eclipse.compare.structuremergeviewer.IStructureComparator;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.elk.core.service.DiagramLayoutEngine;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.l10n.SharedImages;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramGenerator;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramImageGenerator;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramSVGGenerator;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.DiagramUIRenderDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.DiagramUIRenderPlugin;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.gmf.runtime.draw2d.ui.render.awt.internal.image.ImageConverter;
import org.eclipse.gmf.runtime.draw2d.ui.render.awt.internal.svg.export.GraphicsSVG;
import org.eclipse.gmf.runtime.draw2d.ui.render.factory.RenderedImageFactory;
import org.eclipse.gmf.runtime.draw2d.ui.render.internal.RenderedImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.gmfdiag.export.actions.ExportAllDiagramsParameter;
import org.eclipse.papyrus.junit.framework.classification.FailingTest;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.junit.utils.rules.UIThreadRule;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.w3c.dom.Element;

/**
 * Basic tests for Class diagram layout by ELK
 */
@PluginResource(ClassDiagramLayoutTests.SOURCE_FOLDER + "model.di")
public class ClassDiagramLayoutTests extends AbstractPapyrusTest {

	static final String SOURCE_FOLDER = "/resource/simple-classdiag/";

	public static final String BASIC_DIAGRAM_NAME = "Basic";
	public static final String ADVANCED_DIAGRAM_NAME = "Advanced";

	@ClassRule
	public static final TestRule uiThread = new UIThreadRule();

	@ClassRule
	public static final PapyrusEditorFixture editor = new PapyrusEditorFixture();

	private static final int TOLERANCE = 1;

	private final Rectangle class1Bounds = new Rectangle(104, 307, 202, 179);

	private final Rectangle class1BoundsAfterLayout = new Rectangle(12, 21, 202, 179);

	/**
	 * Creates a new {@link ClassDiagramLayoutTests}
	 */
	public ClassDiagramLayoutTests() {
		// Empty constructor.
	}

	@Test
	@FailingTest("waiting for resolution from svg comparison")
	public void testELKAdvancedLayout() {
		editor.openDiagram(ADVANCED_DIAGRAM_NAME);
		assertThat("Active diagram is not the one expected", editor.getActiveDiagram().getDiagramView().getName(), equalTo(ADVANCED_DIAGRAM_NAME));
		runLayout(editor.getEditor().getSite().getPart());
		IFile currentFile = exportDiagramToFile();
		IFile expectedFile = retrieveReferenceFile(editor.getActiveDiagram().getDiagramView().getName());
		compareResult(expectedFile, currentFile);
		editor.undo();
	}

	@Test
	@FailingTest("waiting for resolution from svg comparison")
	public void testELKBasicLayout() {
		editor.openDiagram(BASIC_DIAGRAM_NAME);
		assertThat("Active diagram is not the one expected", editor.getActiveDiagram().getDiagramView().getName(), equalTo(BASIC_DIAGRAM_NAME));
		runLayout(editor.getEditor().getSite().getPart());
		EditPart class1EditPart = editor.requireEditPart(editor.getActiveDiagram().getChildBySemanticHint("Class_Shape"), editor.getModel().getPackagedElement("Class1"));
		Rectangle class1NewBounds = ((GraphicalEditPart) class1EditPart).getFigure().getBounds();
		assertThat("Class position after layout is not the expected one", class1NewBounds, equalTo(this.class1BoundsAfterLayout));
		IFile currentFile = exportDiagramToFile();
		IFile expectedFile = retrieveReferenceFile(editor.getActiveDiagram().getDiagramView().getName());
		compareResult(expectedFile, currentFile);
		editor.undo();
	}

	@Test
	public void testInitialConditions() {
		EditPart class1EditPart = editor.requireEditPart(editor.getActiveDiagram().getChildBySemanticHint("Class_Shape"), editor.getModel().getPackagedElement("Class1"));
		assertThat("Impossible to find Class1 edit part or is not a GraphicalEditPart", class1EditPart, instanceOf(GraphicalEditPart.class));
		// get class1 position (no layout yet)
		Rectangle class1Bounds = ((GraphicalEditPart) class1EditPart).getFigure().getBounds();
		assertThat("Initial condition does not match test configuration", class1Bounds, equalTo(this.class1Bounds));
		// check status of the ELK layout handler
		ICommandService commandService = PlatformUI.getWorkbench().getService(ICommandService.class);
		org.eclipse.core.commands.Command cmd = commandService.getCommand("org.eclipse.elk.core.ui.command.layout"); //$NON-NLS-1$
		IHandler handler = cmd.getHandler();
		((AbstractHandler) handler).setEnabled("org.eclipse.elk.core.ui.command.layout"); //$NON-NLS-1$
		boolean res = handler.isEnabled();
		assertTrue("Layout must be enable", res); //$NON-NLS-1$
	}

	private IFile retrieveReferenceFile(String diagramName) {
		Bundle bundle = FrameworkUtil.getBundle(ClassDiagramLayoutTests.class);
		URL url = bundle.getResource(SOURCE_FOLDER + "expected/" + diagramName + "-expected.svg");
		try (InputStream contents = url.openStream()) {
			IFile expectedFile = editor.getProject().getProject().getFile(URI.createURI(url.toExternalForm()).lastSegment());
			expectedFile.create(contents, false, null);
		} catch (Exception e) {
			throw new WrappedException(e);
		}
		return editor.getProject().getProject().getFile(diagramName + "-expected.svg");
	}

	private IFile exportDiagramToFile() {

		CopyToImageUtil copyImageUtil = new TestCopyToImageUtil();

		ExportAllDiagramsParameter exportParameter = new ExportAllDiagramsParameter(editor.getModelSet());
		exportParameter.setExportFormat("SVG");
		exportParameter.setOutputDirectory(editor.getProject().getProject());
		exportParameter.setDisplayStatus(false); // avoid popup at the end of the export

		IPath imagePath = new Path(exportParameter.getOutputDirectoryPath() + File.separator + editor.getActiveDiagram().getDiagramView().getName());
		imagePath = imagePath.addFileExtension(exportParameter.getExportFormat().getName().toLowerCase());

		try {
			System.setProperty("line.separator", "\n");
			copyImageUtil.copyToImage(editor.getActiveDiagram(), imagePath, exportParameter.getExportFormat(), new NullProgressMonitor());
		} catch (Throwable e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		return editor.getProject().getProject().getFile(editor.getActiveDiagram().getDiagramView().getName() + "." + exportParameter.getExportFormat().getName().toLowerCase());
	}

	public void runLayout(IWorkbenchPart part) {
		DiagramLayoutEngine.invokeLayout(part, null, false, false, false, false);
		editor.flushDisplayEvents();
	}

	public void compareResult(IFile expected, IFile current) {
		IStructureComparator currentStructureComparator = new BufferedResourceNode(current);
		IStructureComparator expectedStructureComparator = new BufferedResourceNode(expected);

		Differencer d = new Differencer() {
			protected Object visit(Object parent, int description, Object ancestor, Object left, Object right) {
				return new DebugDiffNode((IDiffContainer) parent, description, (ITypedElement) ancestor, (ITypedElement) left, (ITypedElement) right);
			}
		};

		Object fRoot = d.findDifferences(false, null, null, null, currentStructureComparator, expectedStructureComparator);
		if (fRoot != null) {
			System.err.println("SVG export: issue on the current file");
			StringBuilder inputStringBuilder = new StringBuilder();
			BufferedReader bufferedReader;
			try {
				bufferedReader = new BufferedReader(new InputStreamReader(current.getContents(), "UTF-8"));
				String line = bufferedReader.readLine();

				while (line != null) {
					inputStringBuilder.append(line);
					inputStringBuilder.append('\n');
					line = bufferedReader.readLine();
				}
				System.out.println(inputStringBuilder.toString());
			} catch (CoreException | IOException e) {
				e.printStackTrace();
			}
		}
		assertThat("There should not be any difference, but some diffs were found.", fRoot, nullValue());

	}

	public class DebugDiffNode extends DiffNode {

		/**
		 * Constructor.
		 *
		 * @param parent
		 * @param kind
		 * @param ancestor
		 * @param left
		 * @param right
		 */
		public DebugDiffNode(IDiffContainer parent, int kind, ITypedElement ancestor, ITypedElement left, ITypedElement right) {
			super(parent, kind, ancestor, left, right);
		}

		/**
		 * @see java.lang.Object#toString()
		 *
		 * @return
		 */
		@Override
		public String toString() {
			String name = null;
			if (getAncestor() != null)
				name = getAncestor().getName();
			if (name == null && getLeft() != null)
				name = getLeft().getName();
			if (name == null && getRight() != null)
				name = getRight().getName();
			if (name == null)
				name = "???"; //$NON-NLS-1$

			return (getDiffType(getKind()) + name);
		}


		private String getDiffType(int code) {
			String dir = " "; //$NON-NLS-1$
			switch (code & Differencer.DIRECTION_MASK) {
			case Differencer.LEFT:
				dir = ">"; //$NON-NLS-1$
				break;
			case Differencer.RIGHT:
				dir = "<"; //$NON-NLS-1$
				break;
			case Differencer.CONFLICTING:
				dir = "!"; //$NON-NLS-1$
				break;
			}
			String change = "="; //$NON-NLS-1$
			switch (code & Differencer.CHANGE_TYPE_MASK) {
			case Differencer.ADDITION:
				change = "+"; //$NON-NLS-1$
				break;
			case Differencer.DELETION:
				change = "-"; //$NON-NLS-1$
				break;
			case Differencer.CHANGE:
				change = "#"; //$NON-NLS-1$
				break;
			}
			return dir + change + " "; //$NON-NLS-1$
		}

	}


	public class TestCopyToImageUtil extends CopyToImageUtil {
		/**
		 * Creates the appropriate <code>DiagramGenerator</code> from <code>DiagramEditPart</code>
		 * based on the supplied <code>ImageFileFormat</code>
		 * 
		 * @param diagramEP
		 *            diagram editpart
		 * @param format
		 *            image file format
		 * @return appropriate diagram generator
		 */
		protected DiagramGenerator getDiagramGenerator(DiagramEditPart diagramEP, ImageFileFormat format) {
			if (format.equals(ImageFileFormat.SVG) || format.equals(ImageFileFormat.PDF)) {
				return new TestDiagramSVGGenerator(diagramEP);
			} else {
				return new DiagramImageGenerator(diagramEP);
			}
		}
	}


	public static class TestDiagramSVGGenerator extends DiagramSVGGenerator {

		private RenderedImage renderedImage = null;

		private Element svgRoot = null;

		private Rectangle viewBox = null;

		/**
		 * Creates a new instance.
		 * 
		 * @param diagramEditPart
		 *            the diagram editpart
		 */
		public TestDiagramSVGGenerator(DiagramEditPart diagramEditPart) {
			super(diagramEditPart);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramGenerator#setUpGraphics(int, int)
		 */
		protected Graphics setUpGraphics(int width, int height) {
			viewBox = new Rectangle(0, 0, width, height);
			return GraphicsSVG.getInstance(viewBox);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramGenerator#getImageDescriptor(org.eclipse.draw2d.Graphics)
		 */
		protected ImageDescriptor getImageDescriptor(Graphics g) {
			try {
				GraphicsSVG svgG = (GraphicsSVG) g;
				// Get the root element (the svg element)
				svgRoot = svgG.getRoot();

				ByteArrayOutputStream os = new ByteArrayOutputStream(5000); // 5K
																			// buffer
				stream(os);
				os.close();

				setRenderedImage(RenderedImageFactory.getInstance(os.toByteArray()));

				return RenderedImageDescriptor
						.createFromRenderedImage(getRenderedImage());
			} catch (IOException ex) {
				Log.error(DiagramUIRenderPlugin.getInstance(), IStatus.ERROR, ex
						.getMessage(), ex);
			}

			return null;
		}

		/**
		 * Writes the SVG Model out to a file.
		 * 
		 * @param outputStream
		 *            output stream to store the SVG Model
		 */
		public void stream(OutputStream outputStream) {
			try {

				// Define the view box
				svgRoot.setAttributeNS(null,
						"viewBox", String.valueOf(viewBox.x) + " " + //$NON-NLS-1$ //$NON-NLS-2$
								String.valueOf(viewBox.y) + " " + //$NON-NLS-1$
								String.valueOf(viewBox.width) + " " + //$NON-NLS-1$
								String.valueOf(viewBox.height));

				// Write the document to the stream
				Transformer transformer = TransformerFactory.newInstance()
						.newTransformer();
				transformer.setOutputProperty(OutputKeys.METHOD, "xml"); //$NON-NLS-1$
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); //$NON-NLS-1$
				transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //$NON-NLS-1$
				transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //$NON-NLS-1$
				transformer.setOutputProperty("{http://xml.apache.org/xalan}line-separator", "\n");

				DOMSource source = new DOMSource(svgRoot);
				StreamResult result = new StreamResult(outputStream);
				transformer.transform(source, result);
			} catch (Exception ex) {
				Log.error(DiagramUIRenderPlugin.getInstance(), IStatus.ERROR, ex
						.getMessage(), ex);
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.gmf.runtime.diagram.ui.internal.clipboard.DiagramGenerator#createAWTImageForParts(java.util.List)
		 */
		public Image createAWTImageForParts(List editparts, org.eclipse.swt.graphics.Rectangle sourceRect) {
			createSWTImageDescriptorForParts(editparts, sourceRect);
			if (getRenderedImage() != null) {
				try {
					BufferedImage bufImg = (BufferedImage) getRenderedImage().getAdapter(BufferedImage.class);
					if (bufImg == null)
						bufImg = ImageConverter.convert(getRenderedImage().getSWTImage());
					return bufImg;
				} catch (Error e) {
					// log the Error but allow execution to continue
					Trace.catching(DiagramUIRenderPlugin.getInstance(),
							DiagramUIRenderDebugOptions.EXCEPTIONS_THROWING, getClass(),
							"createAWTImageForParts() failed to generate image", //$NON-NLS-1$
							e);
					return ImageConverter.convert(SharedImages
							.get(SharedImages.IMG_ERROR));

				} catch (Exception ex) {
					// log the Exception but allow execution to continue
					Trace.catching(DiagramUIRenderPlugin.getInstance(),
							DiagramUIRenderDebugOptions.EXCEPTIONS_THROWING, getClass(),
							"createAWTImageForParts() failed to generate image", //$NON-NLS-1$
							ex);
					return ImageConverter.convert(SharedImages
							.get(SharedImages.IMG_ERROR));
				}
			}

			return ImageConverter.convert(SharedImages.get(SharedImages.IMG_ERROR));
		}

		/**
		 * @return Returns the rendered image created by previous
		 *         call to createSWTImageDescriptorForParts
		 */
		public RenderedImage getRenderedImage() {
			return renderedImage;
		}

		/**
		 * @param svgImage
		 *            The svgImage to set.
		 */
		private void setRenderedImage(RenderedImage renderedImage) {
			this.renderedImage = renderedImage;
		}
	}
}