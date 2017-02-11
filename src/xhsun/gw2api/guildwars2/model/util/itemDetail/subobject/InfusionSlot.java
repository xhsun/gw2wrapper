package xhsun.gw2api.guildwars2.model.util.itemDetail.subobject;

import xhsun.gw2api.guildwars2.model.util.itemDetail.ItemDetail;

/**
 * For more info on Infusion slots API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Infusion_slot_subobject">here</a><br/>
 * Infusion slots subobject model class
 * @author xhsun
 * @since 2017-02-10
 */

public class InfusionSlot {
	private ItemDetail.Flag[] flags;
	private long item_id;

	public ItemDetail.Flag[] getFlags() {
		return flags;
	}

	public long getID() {
		return item_id;
	}

	public String toString(){
		String result="{Item ID: "+item_id;
		if (flags!=null){
			result+=" {Flags: ";
			for (ItemDetail.Flag flag : flags) result += flag + ", ";
		}
		return result.substring(0, result.length()-2)+"} ";
	}
}
