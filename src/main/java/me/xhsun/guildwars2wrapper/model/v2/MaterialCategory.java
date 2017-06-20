package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;

import java.util.List;

/**
 * For more info on MaterialStorage category API go <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
 * MaterialStorage category model class
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
}
