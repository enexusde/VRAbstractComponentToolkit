package de.e_nexus.vr.tk.abs;

import de.e_nexus.vr.tk.VRFrame;
import de.e_nexus.vr.tk.geo.VRSize;
import de.e_nexus.vr.tk.layout.VRLayouter;

public class DefaultFrameLayouter implements VRLayouter<VRFrame> {

	@Override
	public void layout(VRFrame frame, VRSize currentSize) {
		frame.setMesh(frame.constructMesh(currentSize));
	}

}
