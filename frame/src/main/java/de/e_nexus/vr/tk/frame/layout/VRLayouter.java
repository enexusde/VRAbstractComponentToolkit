package de.e_nexus.vr.tk.frame.layout;

import de.e_nexus.vr.tk.component.VRComponentContainer;
import de.e_nexus.vr.tk.component.geo.VRSize;

public interface VRLayouter<T extends VRComponentContainer> {
	public void layout(T frame, VRSize currentSize);
}
