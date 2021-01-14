package de.e_nexus.vr.tk.frame.abs;

import de.e_nexus.vr.tk.component.geo.VRSize;
import de.e_nexus.vr.tk.frame.VRFrame;
import de.e_nexus.vr.tk.frame.layout.VRLayouter;

public class DefaultFrameLayouter implements VRLayouter<VRFrame> {

	@Override
	public void layout(VRFrame frame, VRSize currentSize) {
		frame.setMesh(frame.constructMesh(currentSize));
	}

}
