package me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject;

import me.xhsun.guildwars2wrapper.model.util.itemDetail.ItemDetail;

import java.util.List;

/**
 * For more info on Infusion slots API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Infusion_slot_subobject">here</a><br/>
 * Infusion slots subobject model class
 *
 * @author xhsun
 * @since 2017-02-10
 */

public class InfusionSlot {
	private List<ItemDetail.Flag> flags;
	private int item_id;

	public List<ItemDetail.Flag> getFlags() {
		return flags;
	}

	public int getID() {
		return item_id;
	}

	@Override
	public String toString() {
		return "InfusionSlot{" +
				"flags=" + flags +
				", item_id=" + item_id +
				'}';
	}
}
