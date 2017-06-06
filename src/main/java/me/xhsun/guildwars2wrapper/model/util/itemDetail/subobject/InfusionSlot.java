package me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject;

import me.xhsun.guildwars2wrapper.model.util.itemDetail.ItemDetail;

import java.util.Arrays;

/**
 * For more info on Infusion slots API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Infusion_slot_subobject">here</a><br/>
 * Infusion slots subobject model class
 *
 * @author xhsun
 * @since 2017-02-10
 */

public class InfusionSlot {
	private ItemDetail.Flag[] flags;
	private int item_id;

	public ItemDetail.Flag[] getFlags() {
		return flags;
	}

	public int getID() {
		return item_id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		InfusionSlot that = (InfusionSlot) o;

		return item_id == that.item_id && Arrays.equals(flags, that.flags);
	}

	@Override
	public int hashCode() {
		int result = Arrays.hashCode(flags);
		result = 31 * result + item_id;
		return result;
	}

	@Override
	public String toString() {
		return "InfusionSlot{" +
				"flags=" + Arrays.toString(flags) +
				", item_id=" + item_id +
				'}';
	}
}
