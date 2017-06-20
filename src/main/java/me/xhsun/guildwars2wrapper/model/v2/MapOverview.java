package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;

import java.util.List;

/**
 * For more info on maps API go <a href="https://wiki.guildwars2.com/wiki/API:2/maps">here</a><br/>
 * Model class for maps
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class MapOverview extends NameableInt {
	private int min_level, max_level, default_floor, region_id, continent_id;
	private String region_name, continent_name;
	private List<Integer> floors;
	private double[][] continent_rect, map_rect;

	public int getRegionId() {
		return region_id;
	}

	public int getContinentId() {
		return continent_id;
	}

	public String getRegionName() {
		return region_name;
	}

	public String getContinentName() {
		return continent_name;
	}

	public int getMinLevel() {
		return min_level;
	}

	public int getMaxLLevel() {
		return max_level;
	}

	public int getDefaultFloor() {
		return default_floor;
	}

	public List<Integer> getFloors() {
		return floors;
	}

	public double[][] getContinentRect() {
		return continent_rect;
	}

	public double[][] getMapRect() {
		return map_rect;
	}
}
