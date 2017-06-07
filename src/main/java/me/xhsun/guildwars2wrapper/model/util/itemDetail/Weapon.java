package me.xhsun.guildwars2wrapper.model.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.util.comm.Type;

/**
 * For more info on Weapon detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Weapon">here</a><br/>
 * Item detail for Weapon
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-10
 */
public class Weapon extends StatSelectable {
	public Type getType() {
		return type;
	}

	public Damage getDamageType() {
		return damage_type;
	}

	public int getMinPower() {
		return min_power;
	}

	public int getMaxPower() {
		return max_power;
	}

	public int getDefense() {
		return defense;
	}

	@Override
	public String toString() {
		return "Weapon{" +
				"type=" + type +
				", damage_type=" + damage_type +
				", min_power=" + min_power +
				", max_power=" + max_power +
				", defense=" + defense +
				", infusion_slots=" + infusion_slots +
				", infix_upgrade=" + infix_upgrade +
				", suffix_item_id=" + suffix_item_id +
				", secondary_suffix_item_id='" + secondary_suffix_item_id + '\'' +
				", stat_choices=" + stat_choices +
				'}';
	}
}
