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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Trinket trinket = (Trinket) o;

		return type == trinket.type &&
				suffix_item_id == trinket.suffix_item_id &&
				(infusion_slots != null ? infusion_slots.equals(trinket.infusion_slots) : trinket.infusion_slots == null) &&
				(infix_upgrade != null ? infix_upgrade.equals(trinket.infix_upgrade) : trinket.infix_upgrade == null) &&
				(secondary_suffix_item_id != null ? secondary_suffix_item_id.equals(trinket.secondary_suffix_item_id) : trinket.secondary_suffix_item_id == null) &&
				(stat_choices != null ? stat_choices.equals(trinket.stat_choices) : trinket.stat_choices == null);
	}

	@Override
	public int hashCode() {
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + (infusion_slots != null ? infusion_slots.hashCode() : 0);
		result = 31 * result + (infix_upgrade != null ? infix_upgrade.hashCode() : 0);
		result = 31 * result + suffix_item_id;
		result = 31 * result + (secondary_suffix_item_id != null ? secondary_suffix_item_id.hashCode() : 0);
		result = 31 * result + (stat_choices != null ? stat_choices.hashCode() : 0);
		return result;
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
