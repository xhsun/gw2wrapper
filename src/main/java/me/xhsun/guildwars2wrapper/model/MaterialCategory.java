package me.xhsun.guildwars2wrapper.model;

import java.util.List;

/**
 * For more info on Material Category API go <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
 * Material category model class
 *
 * @author xhsun
 * @see Item item info
 * @since 2017-02-07
 */

public class MaterialCategory {
	private int id;
	private String name;
	private List<Integer> items;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Integer> getItems() {
		return items;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MaterialCategory that = (MaterialCategory) o;

		return id == that.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "MaterialCategory{" +
				"id=" + id +
				", name='" + name + '\'' +
				", items=" + items +
				'}';
	}
}
