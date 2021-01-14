package de.e_nexus.vr.tk.frame;

import java.awt.Color;

import de.e_nexus.vr.server.VRServer;
import de.e_nexus.vr.server.mesh.Mesh;
import de.e_nexus.vr.server.mesh.UVNormalMeshBuilder;
import de.e_nexus.vr.server.mesh.tex.TextureStage;
import de.e_nexus.vr.server.util.TextureTools;
import de.e_nexus.vr.tk.component.VRComponentContainer;
import de.e_nexus.vr.tk.component.geo.VRSize;
import de.e_nexus.vr.tk.frame.abs.DefaultFrameLayouter;
import de.e_nexus.vr.tk.frame.layout.VRLayouter;

public class VRFrame extends VRComponentContainer {

	private String title;
	private VRLayouter layouter;
	private VRSize currentSize = VRSize.resolve(0.2f, 0.2f, 0.2f);

	public VRFrame(VRServer vrServer, String title) {
		this(vrServer, new DefaultFrameLayouter(), title);
	}

	public VRFrame(VRServer vrServer, VRLayouter layouter, String title) {
		super(vrServer);
		this.layouter = layouter;
		this.title = title;
		layout();
	}

	public String getTitle() {
		return title;
	}

	public void layout() {
		layouter.layout(this, currentSize);
	}

	public Mesh constructMesh(VRSize s) {
		UVNormalMeshBuilder builder = new UVNormalMeshBuilder();
		float thickness = 0.005f;
		short a1 = builder.addPoint(-s.getWidth() / 2, s.getHeight() / 2, s.getDeep() / 2);
		short a2 = builder.addPointToRight(a1, thickness);
		short a4 = builder.addPointToRight(a1, s.getWidth());
		short a3 = builder.addPointToLeft(a4, thickness);
		short a13 = builder.addPointBelow(a1, s.getHeight());
		short a16 = builder.addPointToRight(a13, s.getWidth());

		short d1 = builder.addPointBackwards(a1, s.getDeep());
		short d4 = builder.addPointBackwards(a4, s.getDeep());
		short d13 = builder.addPointBackwards(a13, s.getDeep());
		short d16 = builder.addPointBackwards(a16, s.getDeep());

		short a5 = builder.addPointBelow(a1, thickness);
		short a6 = builder.addPointToRight(a5, thickness);
		short a8 = builder.addPointToRight(a5, s.getWidth());
		short a7 = builder.addPointToLeft(a8, thickness);

		short a9 = builder.addPointAbove(a13, thickness);
		short a10 = builder.addPointToRight(a9, thickness);
		short a12 = builder.addPointAbove(a16, thickness);
		short a11 = builder.addPointToLeft(a12, thickness);
		short a14 = builder.addPointToRight(a13, thickness);
		short a15 = builder.addPointToLeft(a16, thickness);

		short b1 = builder.addPointBackwards(a1, thickness);
		short b2 = builder.addPointBackwards(a2, thickness);
		short b3 = builder.addPointBackwards(a3, thickness);
		short b4 = builder.addPointBackwards(a4, thickness);
		short b5 = builder.addPointBackwards(a5, thickness);
		short b6 = builder.addPointBackwards(a6, thickness);
		short b7 = builder.addPointBackwards(a7, thickness);
		short b8 = builder.addPointBackwards(a8, thickness);
		short b9 = builder.addPointBackwards(a9, thickness);
		short b10 = builder.addPointBackwards(a10, thickness);
		short b11 = builder.addPointBackwards(a11, thickness);
		short b12 = builder.addPointBackwards(a12, thickness);
		short b13 = builder.addPointBackwards(a13, thickness);
		short b14 = builder.addPointBackwards(a14, thickness);
		short b15 = builder.addPointBackwards(a15, thickness);
		short b16 = builder.addPointBackwards(a16, thickness);

		short d2 = builder.addPointBackwards(a2, s.getDeep());
		short d3 = builder.addPointBackwards(a3, s.getDeep());
		short d5 = builder.addPointBackwards(a5, s.getDeep());
		short d6 = builder.addPointBackwards(a6, s.getDeep());
		short d7 = builder.addPointBackwards(a7, s.getDeep());
		short d8 = builder.addPointBackwards(a8, s.getDeep());
		short d9 = builder.addPointBackwards(a9, s.getDeep());
		short d10 = builder.addPointBackwards(a10, s.getDeep());
		short d11 = builder.addPointBackwards(a11, s.getDeep());
		short d12 = builder.addPointBackwards(a12, s.getDeep());
		short d14 = builder.addPointBackwards(a14, s.getDeep());
		short d15 = builder.addPointBackwards(a15, s.getDeep());

		short c1 = builder.addPointForwards(d1, thickness);
		short c2 = builder.addPointForwards(d2, thickness);
		short c3 = builder.addPointForwards(d3, thickness);
		short c4 = builder.addPointForwards(d4, thickness);
		short c5 = builder.addPointForwards(d5, thickness);
		short c6 = builder.addPointForwards(d6, thickness);
		short c7 = builder.addPointForwards(d7, thickness);
		short c8 = builder.addPointForwards(d8, thickness);
		short c9 = builder.addPointForwards(d9, thickness);
		short c10 = builder.addPointForwards(d10, thickness);
		short c11 = builder.addPointForwards(d11, thickness);
		short c12 = builder.addPointForwards(d12, thickness);
		short c13 = builder.addPointForwards(d13, thickness);
		short c14 = builder.addPointForwards(d14, thickness);
		short c15 = builder.addPointForwards(d15, thickness);
		short c16 = builder.addPointForwards(d16, thickness);

		// a-layer
		builder.addSquare(a1, a5, a8, a4);
		builder.addSquare(a9, a13, a16, a12);
		builder.addSquare(a5, a9, a10, a6);
		builder.addSquare(a7, a11, a12, a8);

		// b-layer
		builder.addSquare(b2, b3, b7, b6);
		builder.addSquare(b7, b8, b12, b11);
		builder.addSquare(b6, b10, b9, b5);
		builder.addSquare(b10, b11, b15, b14);

		// c-layer
		builder.addSquare(c3, c2, c6, c7);
		builder.addSquare(c8, c7, c11, c12);
		builder.addSquare(c6, c5, c9, c10);
		builder.addSquare(c11, c10, c14, c15);

		// d-layer
		builder.addSquare(d1, d4, d8, d5);
		builder.addSquare(d9, d12, d16, d13);
		builder.addSquare(d6, d10, d9, d5);
		builder.addSquare(d8, d12, d11, d7);

		// left-outer-side
		builder.addSquare(a1, d1, d5, a5);
		builder.addSquare(a9, d9, d13, a13);
		builder.addSquare(d5, d9, c9, c5);
		builder.addSquare(a5, b5, b9, a9);

		// left-inner-side
		builder.addSquare(b2, b6, c6, c2);
		builder.addSquare(a6, a10, b10, b6);
		builder.addSquare(c6, c10, d10, d6);
		builder.addSquare(b10, b14, c14, c10);

		// right-inner-side
		builder.addSquare(a7, b7, b11, a11);
		builder.addSquare(b3, c3, c7, b7);
		builder.addSquare(c7, d7, d11, c11);
		builder.addSquare(b11, c11, c15, b15);

		// right-outer-side
		builder.addSquare(a4, a8, d8, d4);
		builder.addSquare(a8, a12, b12, b8);
		builder.addSquare(c8, c12, d12, d8);
		builder.addSquare(a12, a16, d16, d12);

		// outer-top
		builder.addSquare(a1, a4, b4, b1);
		builder.addSquare(c1, c4, d4, d1);
		builder.addSquare(b1, b2, c2, c1);
		builder.addSquare(b4, c4, c3, b3);

		// inner-top
		builder.addSquare(a6, b6, b7, a7);
		builder.addSquare(b6, b5, c5, c6);
		builder.addSquare(b8, b7, c7, c8);
		builder.addSquare(c7, c6, d6, d7);

		// inner-bottom
		builder.addSquare(a10, a11, b11, b10);
		builder.addSquare(b12, c12, c11, b11);
		builder.addSquare(b10, c10, c9, b9);
		builder.addSquare(c11, d11, d10, c10);

		// outer-bottom
		builder.addSquare(a16, a13, b13, b16);
		builder.addSquare(b16, b15, c15, c16);
		builder.addSquare(b14, b13, c13, c14);
		builder.addSquare(c16, c13, d13, d16);

		Mesh frame = builder.buildAndReset();
//
		frame.setTexture(TextureStage.NORMALS, TextureTools.fromColor(Color.blue));
		frame = frame.cloneMoved(-0.7f, 1.5f, -1f);
//		frame.sort();
		return frame;
	}

	@Override
	public void remove() {
		super.remove();
	}

}
