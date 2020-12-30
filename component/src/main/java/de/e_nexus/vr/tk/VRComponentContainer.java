package de.e_nexus.vr.tk;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import de.e_nexus.vr.server.VRServer;
import de.e_nexus.vr.tk.abs.VRComponent;
import de.e_nexus.vr.tk.geo.VRSize;

public class VRComponentContainer extends VRComponent {
	public VRComponentContainer(VRServer vrServer) {
		super(vrServer);
	}

	public VRComponentContainer(VRServer vrServer, VRSize minSize) {
		super(vrServer, minSize);
	}

	protected final Set<VRComponent> components = new LinkedHashSet<>();

	public Set<VRComponent> getComponents() {
		return Collections.unmodifiableSet(components);
	}

	public boolean addComponent(VRComponent component) {
		synchronized (components) {
			return components.add(component);
		}
	}

	public boolean removeComponent(VRComponent component) {
		synchronized (components) {
			return components.remove(component);
		}
	}

	public void remove() {
		for (VRComponent vrComponent : components) {
			vrComponent.remove();
		}
		super.remove();
	}

}
