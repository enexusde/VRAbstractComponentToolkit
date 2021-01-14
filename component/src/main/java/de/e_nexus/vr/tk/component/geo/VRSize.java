package de.e_nexus.vr.tk.component.geo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class VRSize implements Serializable {

	private static final long serialVersionUID = 1047756548089311708L;

	private static final Map<Long, Set<VRSize>> VALUES = new LinkedHashMap<Long, Set<VRSize>>();

	private final int width;
	private final int height;
	private final int deep;

	private VRSize(int widthCM, int heightCM, int deepCM) {
		this.width = widthCM;
		this.height = heightCM;
		this.deep = deepCM;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getDeep() {
		return deep;
	}

	public Object readResolve() {
		return resolve(width, height, deep);
	}

	public static VRSize resolve(int widthCM, int heightCM, int deepCM) {
		long v = widthCM + heightCM + deepCM;
		synchronized (VALUES) {
			if (!VALUES.containsKey(v)) {
				LinkedHashSet<VRSize> list = new LinkedHashSet<VRSize>();
				VALUES.put(v, list);
				return saveConstruct(widthCM, heightCM, deepCM, list);
			} else {
				Set<VRSize> set = VALUES.get(v);
				for (VRSize vrSize : set) {
					if (vrSize.is(widthCM, heightCM, deepCM)) {
						return vrSize;
					}
				}
				return saveConstruct(widthCM, heightCM, deepCM, set);
			}
		}
	}

	public boolean is(int widthCM, int heightCM, int deepCM) {
		return widthCM == width && heightCM == height && deep == deepCM;
	}

	private static VRSize saveConstruct(int width, int height, int deep, Set<VRSize> list) {
		VRSize newSize = new VRSize(width, height, deep);
		list.add(newSize);
		return newSize;
	}
}
