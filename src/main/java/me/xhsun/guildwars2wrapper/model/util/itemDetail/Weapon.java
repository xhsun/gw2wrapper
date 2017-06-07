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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Weapon weapon = (Weapon) o;

		return min_power == weapon.min_power &&
				max_power == weapon.max_power &&
				defense == weapon.defense &&
				suffix_item_id == weapon.suffix_item_id &&
				type == weapon.type &&
				damage_type == weapon.damage_type &&
				(infusion_slots != null ? infusion_slots.equals(weapon.infusion_slots) : weapon.infusion_slots == null) &&
				(infix_upgrade != null ? infix_upgrade.equals(weapon.infix_upgrade) : weapon.infix_upgrade == null) &&
				(secondary_suffix_item_id != null ? secondary_suffix_item_id.equals(weapon.secondary_suffix_item_id) : weapon.secondary_suffix_item_id == null) &&
				(stat_choices != null ? stat_choices.equals(weapon.stat_choices) : weapon.stat_choices == null);
	}

	@Override
	public int hashCode() {
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + (damage_type != null ? damage_type.hashCode() : 0);
		result = 31 * result + min_power;
		result = 31 * result + max_power;
		result = 31 * result + defense;
		result = 31 * result + (infusion_slots != null ? infusion_slots.hashCode() : 0);
		result = 31 * result + (infix_upgrade != null ? infix_upgrade.hashCode() : 0);
		result = 31 * result + suffix_item_id;
		result = 31 * result + (secondary_suffix_item_id != null ? secondary_suffix_item_id.hashCode() : 0);
		result = 31 * result + (stat_choices != null ? stat_choices.hashCode() : 0);
		return result;
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
