package me.xhsun.guildwars2wrapper.model.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.util.comm.Type;

/**
 * For more info on Trinket detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Trinket">here</a><br/>
 * Item detail for Trinket
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-10
 */
public class Trinket extends StatSelectable {
	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Trinket{" +
				", infusion_slots=" + infusion_slots +
				", infix_upgrade=" + infix_upgrade +
				", suffix_item_id=" + suffix_item_id +
				", secondary_suffix_item_id='" + secondary_suffix_item_id + '\'' +
				", stat_choices=" + stat_choices +
				'}';
	}
}
