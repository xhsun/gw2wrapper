package me.xhsun.guildwars2wrapper.model.v2.continent;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

import java.util.Map;

/**
 * For more info on continents floors API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
 * Model class for continents floor
 *
 * @author xhsun
 * @since 2017-06-15
 */
public class ContinentFloor extends IdentifiableInt {
	private double[] texture_dims;
	private Map<Integer, ContinentRegion> regions;

	public double[] getTextureDims() {
		return texture_dims;
	}

	public Map<Integer, ContinentRegion> getRegions() {
		return regions;
	}

}
