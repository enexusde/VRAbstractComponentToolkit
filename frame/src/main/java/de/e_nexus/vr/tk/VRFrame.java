package de.e_nexus.vr.tk;

import java.awt.Color;

import de.e_nexus.vr.server.VRServer;
import de.e_nexus.vr.server.mesh.Mesh;
import de.e_nexus.vr.server.mesh.UVVector;
import de.e_nexus.vr.server.mesh.Vector;
import de.e_nexus.vr.server.mesh.tex.TextureStage;
import de.e_nexus.vr.server.util.TextureTools;
import de.e_nexus.vr.tk.abs.DefaultFrameLayouter;
import de.e_nexus.vr.tk.geo.VRSize;
import de.e_nexus.vr.tk.layout.VRLayouter;

public class VRFrame extends VRComponentContainer {

	private String title;
	private VRLayouter layouter;
	private VRSize currentSize = VRSize.resolve(100, 100, 10);

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

	public Mesh constructMesh(VRSize currentSize2) {
		Mesh m = new Mesh<UVVector>();
		m.addSquareCounterClockwise(m.addVector(new Vector(5, 0, 0)), m.addVector(new Vector(5, currentSize2.getHeight(), 0)), m.addVector(new Vector(0, currentSize2.getHeight() - 5, 0)),
				m.addVector(new Vector(0, 5, 0)));
		m = m.cloneMoved(0, 0, 5);
		m.setTexture(TextureStage.NORMALS, TextureTools.fromColor(Color.black));
		return m;
	}

}
