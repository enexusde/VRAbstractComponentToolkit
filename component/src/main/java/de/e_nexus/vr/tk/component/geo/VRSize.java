package de.e_nexus.vr.tk.component.geo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class VRSize implements Serializable {

	private static final long serialVersionUID = 1047756548089311708L;

	private static final Map<Float, Set<VRSize>> VALUES = new LinkedHashMap<>();

	private final float width;
	private final float height;
	private final float deep;

	private VRSize(float widthCM, float heightCM, float deepCM) {
		this.width = widthCM;
		this.height = heightCM;
		this.deep = deepCM;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public float getDeep() {
		return deep;
	}

	public Object readResolve() {
		return resolve(width, height, deep);
	}

	public static VRSize resolve(float widthCM, float heightCM, float deepCM) {
		float v = widthCM + heightCM + deepCM;
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

	public boolean is(float widthCM, float heightCM, float deepCM) {
		return widthCM == width && heightCM == height && deep == deepCM;
	}

	private static VRSize saveConstruct(float width, float height, float deep, Set<VRSize> list) {
		VRSize newSize = new VRSize(width, height, deep);
		list.add(newSize);
		return newSize;
	}

	@Override
	public String toString() {
		return "VRSize[width:" + width + ", height:" + height + ", deep:" + deep + "]";
	}
}
