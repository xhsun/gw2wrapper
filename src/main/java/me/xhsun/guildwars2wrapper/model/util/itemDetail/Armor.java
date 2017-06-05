package me.xhsun.guildwars2wrapper.model.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject.InfixUpgrade;
import me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject.InfusionSlot;

import java.util.Arrays;

/**
 * For more info on Armor detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Armor">here</a><br/>
 * Item detail for Armors
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-07
 */
public class Armor extends ItemDetail {
	public Type getType() {
		return type;
	}

	public Weight getWeightClass() {
		return weight_class;
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

		Armor armor = (Armor) o;

		return (defense == armor.defense) &&
				(suffix_item_id == armor.suffix_item_id) &&
				(type == armor.type) &&
				(weight_class == armor.weight_class) &&
				(Arrays.equals(infusion_slots, armor.infusion_slots)) &&
				(infix_upgrade != null ? infix_upgrade.equals(armor.infix_upgrade) : armor.infix_upgrade == null) &&
				(secondary_suffix_item_id != null ? secondary_suffix_item_id.equals(armor.secondary_suffix_item_id) : armor.secondary_suffix_item_id == null) &&
				(Arrays.equals(stat_choices, armor.stat_choices));
	}

	@Override
	public int hashCode() {
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + (weight_class != null ? weight_class.hashCode() : 0);
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
		return "Armor{" +
				"type=" + type +
				", weight_class=" + weight_class +
				", defense=" + defense +
				", infusion_slots=" + Arrays.toString(infusion_slots) +
				", infix_upgrade=" + infix_upgrade +
				", suffix_item_id=" + suffix_item_id +
				", secondary_suffix_item_id='" + secondary_suffix_item_id + '\'' +
				", stat_choices=" + Arrays.toString(stat_choices) +
				'}';
	}
}
