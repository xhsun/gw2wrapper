package me.xhsun.guildwars2wrapper.model.util.itemDetail;


import me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject.InfixUpgrade;
import me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject.InfusionSlot;

import java.util.Arrays;

/**
 * For more info on Back detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Back_item">here</a><br/>
 * Item detail for back item
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-10
 */
public class Back extends ItemDetail {
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

		Back back = (Back) o;

		return suffix_item_id == back.suffix_item_id &&
				Arrays.equals(infusion_slots, back.infusion_slots) &&
				(infix_upgrade != null ? infix_upgrade.equals(back.infix_upgrade) : back.infix_upgrade == null) &&
				(secondary_suffix_item_id != null ? secondary_suffix_item_id.equals(back.secondary_suffix_item_id) : back.secondary_suffix_item_id == null) &&
				Arrays.equals(stat_choices, back.stat_choices);
	}

	@Override
	public int hashCode() {
		int result = Arrays.hashCode(infusion_slots);
		result = 31 * result + (infix_upgrade != null ? infix_upgrade.hashCode() : 0);
		result = 31 * result + (int) (suffix_item_id ^ (suffix_item_id >>> 32));
		result = 31 * result + (secondary_suffix_item_id != null ? secondary_suffix_item_id.hashCode() : 0);
		result = 31 * result + Arrays.hashCode(stat_choices);
		return result;
	}

	@Override
	public String toString() {
		return "Back{" +
				"infusion_slots=" + Arrays.toString(infusion_slots) +
				", infix_upgrade=" + infix_upgrade +
				", suffix_item_id=" + suffix_item_id +
				", secondary_suffix_item_id='" + secondary_suffix_item_id + '\'' +
				", stat_choices=" + Arrays.toString(stat_choices) +
				'}';
	}
}
