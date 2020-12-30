package de.e_nexus.vr.tk.layout;

import de.e_nexus.vr.tk.VRComponentContainer;
import de.e_nexus.vr.tk.geo.VRSize;

public interface VRLayouter<T extends VRComponentContainer> {
	public void layout(T frame, VRSize currentSize);
}
