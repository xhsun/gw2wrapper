package me.xhsun.guildwars2wrapper.model.v2;


import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;
import me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.ItemAttributes;

import java.util.List;

/**
 * For more info on Itemstat API go <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
 * Itemstat model class
 *
 * @author xhsun
 * @see ItemAttributes item attribute
 * @since 2017-02-07
 */
public class ItemStats extends NameableInt {
	private List<ItemAttributes> attributes;

	public List<ItemAttributes> getAttributes() {
		return attributes;
	}
}