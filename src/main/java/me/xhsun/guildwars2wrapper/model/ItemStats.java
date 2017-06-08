package me.xhsun.guildwars2wrapper.model;


import me.xhsun.guildwars2wrapper.model.indentifiable.Nameable;
import me.xhsun.guildwars2wrapper.model.util.itemDetail.ItemAttributes;

/**
 * For more info on Itemstat API go <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
 * Itemstat model class
 *
 * @author xhsun
 * @see ItemAttributes item attribute
 * @since 2017-02-07
 */
public class ItemStats extends Nameable {
	private ItemAttributes attributes;

	public ItemAttributes getAttributes() {
		return attributes;
	}

	@Override
	public String toString() {
		return "ItemStats{" +
				"id=" + getId() +
				", name='" + getName() + '\'' +
				", attributes=" + attributes +
				'}';
	}
}