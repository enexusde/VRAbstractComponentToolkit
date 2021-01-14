package de.e_nexus.vr.tk.component.abs;

import java.io.Serializable;

import de.e_nexus.vr.server.VRServer;
import de.e_nexus.vr.server.mesh.Mesh;
import de.e_nexus.vr.tk.component.geo.VRSize;

public abstract class VRComponent extends MeshAppearance implements Serializable {

	private static final int DEFAULT_SIZE = 20;
	private transient VRServer vrServer;
	private VRSize minSize;

	public VRComponent(VRServer vrServer) {
		this(vrServer, VRSize.resolve(DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_SIZE));
	}

	public VRComponent(VRServer vrServer, VRSize minSize, Mesh m) {
		super(vrServer);
		this.vrServer = vrServer;
		this.minSize = minSize;
		setMesh(m);
	}

	public VRComponent(VRServer vrServer, VRSize minSize) {
		this(vrServer, minSize, new Mesh());
	}

	public VRServer getVrServer() {
		return vrServer;
	}

	public VRSize getMinSize() {
		return minSize;
	}

	public void remove() {
		vrServer.removeMesh(getMesh());
	}
}
