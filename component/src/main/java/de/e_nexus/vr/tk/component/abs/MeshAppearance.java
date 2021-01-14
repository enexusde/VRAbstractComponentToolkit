package de.e_nexus.vr.tk.component.abs;

import java.util.Objects;

import de.e_nexus.vr.server.VRServer;
import de.e_nexus.vr.server.mesh.Mesh;

public class MeshAppearance {
	private Mesh<?> mesh;
	private VRServer server;

	public MeshAppearance(VRServer server) throws NullPointerException {
		this.server = Objects.requireNonNull(server, "Server must not be null!");
	}

	public void setMesh(Mesh<?> mesh) throws NullPointerException {
		server.removeMesh(this.mesh);
		this.mesh = Objects.requireNonNull(mesh, "Mesh must not be null");
		server.addMesh(mesh);
	}

	protected Mesh<?> getMesh() {
		return mesh;
	}
}
