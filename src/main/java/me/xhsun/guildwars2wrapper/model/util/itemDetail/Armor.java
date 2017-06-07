package me.xhsun.guildwars2wrapper.model.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.util.comm.Type;

/**
 * For more info on Armor detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Armor">here</a><br/>
 * Item detail for Armors
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-07
 */
public class Armor extends StatSelectable {
	public Type getType() {
		return type;
	}

	public Weight getWeightClass() {
		return weight_class;
	}

	public int getDefense() {
		return defense;
	}

	@Override
	public String toString() {
		return "Armor{" +
				"type=" + type +
				", weight_class=" + weight_class +
				", defense=" + defense +
				", infusion_slots=" + infusion_slots +
				", infix_upgrade=" + infix_upgrade +
				", suffix_item_id=" + suffix_item_id +
				", secondary_suffix_item_id='" + secondary_suffix_item_id + '\'' +
				", stat_choices=" + stat_choices +
				'}';
	}
}
