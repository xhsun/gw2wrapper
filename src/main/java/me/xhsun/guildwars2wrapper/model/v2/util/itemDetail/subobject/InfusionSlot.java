package me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.subobject;

import me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.ItemDetail;

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
}
