package me.xhsun.guildwars2wrapper.model;

import java.util.Arrays;

/**
 * For more info on gliders API go <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">here</a><br/>
 * Model class for glider
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Glider {
	private int id;
	private int[] unlock_items;//item id
	private int order;
	private String icon;
	private String name;
	private String description;
	private int[] default_dyes;//color id

	public int getId() {
		return id;
	}

	/**
	 * @return array of {@link Item} id(s)
	 */
	public int[] getUnlock_items() {
		return unlock_items;
	}

	public int getOrder() {
		return order;
	}

	public String getIcon() {
		return icon;
	}

	public String getName() {
		return name;
	}

	//TODO method that give striped description, ie, no html
	public String getDescription() {
		return description;
	}

	/**
	 * @return array of {@link Color} id(s)
	 */
	public int[] getDefault_dyes() {
		return default_dyes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Glider glider = (Glider) o;

		return id == glider.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "Glider{" +
				"id=" + id +
				", unlock_items=" + Arrays.toString(unlock_items) +
				", order=" + order +
				", icon='" + icon + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", default_dyes=" + Arrays.toString(default_dyes) +
				'}';
	}
}
