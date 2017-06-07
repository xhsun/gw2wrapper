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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Armor armor = (Armor) o;

		return (defense == armor.defense) &&
				(suffix_item_id == armor.suffix_item_id) &&
				(type == armor.type) &&
				(weight_class == armor.weight_class) &&
				(infusion_slots != null ? infusion_slots.equals(armor.infusion_slots) : armor.infusion_slots == null) &&
				(infix_upgrade != null ? infix_upgrade.equals(armor.infix_upgrade) : armor.infix_upgrade == null) &&
				(secondary_suffix_item_id != null ? secondary_suffix_item_id.equals(armor.secondary_suffix_item_id) : armor.secondary_suffix_item_id == null) &&
				(stat_choices != null ? stat_choices.equals(armor.stat_choices) : armor.stat_choices == null);
	}

	@Override
	public int hashCode() {
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + (weight_class != null ? weight_class.hashCode() : 0);
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
