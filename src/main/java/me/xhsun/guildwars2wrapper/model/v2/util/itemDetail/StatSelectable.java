package me.xhsun.guildwars2wrapper.model.v2.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.subobject.InfixUpgrade;
import me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.subobject.InfusionSlot;

import java.util.List;

/**
 * Method container class for all item detail that have a stat
 *
 * @author xhsun
 * @since 2017-06-07
 */
class StatSelectable extends ItemDetail {
	public List<InfusionSlot> getInfusionSlots() {
		return infusion_slots;
	}

	public InfixUpgrade getInfixUpgrade() {
		return infix_upgrade;
	}

	public int getSuffixID() {
		return suffix_item_id;
	}

	public String getSecSuffixID() {
		return secondary_suffix_item_id;
	}

	public List<String> getStatChoice() {
		return stat_choices;
	}
}
