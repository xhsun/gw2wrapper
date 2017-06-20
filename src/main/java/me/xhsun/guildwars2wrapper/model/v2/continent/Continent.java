package me.xhsun.guildwars2wrapper.model.v2.continent;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;

import java.util.List;

/**
 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
 * Model class for continents
 *
 * @author xhsun
 * @since 2017-06-15
 */
public class Continent extends NameableInt {
	private double[] continent_dims;
	private int min_zoom, max_zoom;
	private List<Integer> floors;

	public double[] getContinentDims() {
		return continent_dims;
	}

	public int getMinZoom() {
		return min_zoom;
	}

	public int getMaxZoom() {
		return max_zoom;
	}

	public List<Integer> getFloors() {
		return floors;
	}
}
