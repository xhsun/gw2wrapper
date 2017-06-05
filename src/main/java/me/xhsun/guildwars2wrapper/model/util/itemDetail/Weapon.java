package me.xhsun.guildwars2wrapper.model.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.util.comm.Type;
import me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject.InfixUpgrade;
import me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject.InfusionSlot;

import java.util.Arrays;

/**
 * For more info on Weapon detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Weapon">here</a><br/>
 * Item detail for Weapon
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-10
 */
public class Weapon extends ItemDetail {
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

	public InfusionSlot[] getInfusionSlots() {
		return infusion_slots;
	}

	public InfixUpgrade getInfixUpgrade() {
		return infix_upgrade;
	}

	public long getSuffixID() {
		return suffix_item_id;
	}

	public String getSecSuffixID() {
		return secondary_suffix_item_id;
	}

	public String[] getStatChoice() {
		return stat_choices;
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
				Arrays.equals(infusion_slots, weapon.infusion_slots) &&
				(infix_upgrade != null ? infix_upgrade.equals(weapon.infix_upgrade) : weapon.infix_upgrade == null) &&
				(secondary_suffix_item_id != null ? secondary_suffix_item_id.equals(weapon.secondary_suffix_item_id) : weapon.secondary_suffix_item_id == null) &&
				Arrays.equals(stat_choices, weapon.stat_choices);
	}

	@Override
	public int hashCode() {
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + (damage_type != null ? damage_type.hashCode() : 0);
		result = 31 * result + min_power;
		result = 31 * result + max_power;
		result = 31 * result + defense;
		result = 31 * result + Arrays.hashCode(infusion_slots);
		result = 31 * result + (infix_upgrade != null ? infix_upgrade.hashCode() : 0);
		result = 31 * result + (int) (suffix_item_id ^ (suffix_item_id >>> 32));
		result = 31 * result + (secondary_suffix_item_id != null ? secondary_suffix_item_id.hashCode() : 0);
		result = 31 * result + Arrays.hashCode(stat_choices);
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
				", infusion_slots=" + Arrays.toString(infusion_slots) +
				", infix_upgrade=" + infix_upgrade +
				", suffix_item_id=" + suffix_item_id +
				", secondary_suffix_item_id='" + secondary_suffix_item_id + '\'' +
				", stat_choices=" + Arrays.toString(stat_choices) +
				'}';
	}
}
