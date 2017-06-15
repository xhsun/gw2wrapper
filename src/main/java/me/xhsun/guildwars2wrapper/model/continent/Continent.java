package me.xhsun.guildwars2wrapper.model.continent;

import me.xhsun.guildwars2wrapper.model.indentifiable.NameableInt;

import java.util.Arrays;
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

	public double[] getContinent_dims() {
		return continent_dims;
	}

	public int getMin_zoom() {
		return min_zoom;
	}

	public int getMax_zoom() {
		return max_zoom;
	}

	public List<Integer> getFloors() {
		return floors;
	}

	@Override
	public String toString() {
		return "Continent{" +
				super.toString() +
				"continent_dims=" + Arrays.toString(continent_dims) +
				", min_zoom=" + min_zoom +
				", max_zoom=" + max_zoom +
				", floors=" + floors +
				'}';
	}
}
