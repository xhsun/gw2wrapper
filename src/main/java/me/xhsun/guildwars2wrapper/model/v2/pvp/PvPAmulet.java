package me.xhsun.guildwars2wrapper.model.v2.pvp;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;
import me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.ItemAttributes;

/**
 * For more info on pvp amulets API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">here</a><br/>
 * Model class for pvp amulet
 *
 * @author xhsun
 * @since 2017-06-15
 */
public class PvPAmulet extends NameableInt {
	private String icon;
	private ItemAttributes attributes;

	public String getIcon() {
		return icon;
	}

	public ItemAttributes getAttributes() {
		return attributes;
	}
}
