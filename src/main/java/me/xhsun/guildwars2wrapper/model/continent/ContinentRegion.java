package me.xhsun.guildwars2wrapper.model.continent;

import me.xhsun.guildwars2wrapper.model.indentifiable.NameableInt;

import java.util.Arrays;
import java.util.Map;

/**
 * For more info on continents region API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
 * Model class for continents region
 *
 * @author xhsun
 * @since 2017-06-15
 */
public class ContinentRegion extends NameableInt {
	private double[] label_coord;
	private double[][] continent_rect;
	private Map<Integer, ContinentMap> maps;

	public double[] getLabel_coord() {
		return label_coord;
	}

	public double[][] getContinent_rect() {
		return continent_rect;
	}

	public Map<Integer, ContinentMap> getMaps() {
		return maps;
	}

	@Override
	public String toString() {
		return "ContinentRegion{" +
				super.toString() +
				"label_coord=" + Arrays.toString(label_coord) +
				", continent_rect=" + Arrays.toString(continent_rect) +
				", maps=" + maps +
				'}';
	}
}
