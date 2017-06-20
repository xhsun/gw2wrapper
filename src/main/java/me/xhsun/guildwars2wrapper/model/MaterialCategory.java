package me.xhsun.guildwars2wrapper.model;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;

import java.util.List;

/**
 * For more info on Material category API go <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
 * Material category model class
 *
 * @author xhsun
 * @see Item item info
 * @since 2017-02-07
 */

public class MaterialCategory extends NameableInt {
	private List<Integer> items;

	public List<Integer> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "MaterialCategory{" +
				"id=" + getId() +
				", name='" + getName() + '\'' +
				", items=" + items +
				'}';
	}
}
