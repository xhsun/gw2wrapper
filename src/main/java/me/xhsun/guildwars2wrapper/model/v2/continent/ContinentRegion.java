package me.xhsun.guildwars2wrapper.model.v2.continent;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;

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

	public double[] getLabelCoord() {
		return label_coord;
	}

	public double[][] getContinentRect() {
		return continent_rect;
	}

	public Map<Integer, ContinentMap> getMaps() {
		return maps;
	}

}
