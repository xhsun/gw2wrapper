package xhsun.gw2api.guildwars2.model.util;

import xhsun.gw2api.guildwars2.model.Item;
import xhsun.gw2api.guildwars2.model.Skin;
import xhsun.gw2api.guildwars2.model.ItemStats;

/**
 * Character inventory bag inventory model class
 * @see Item item info
 * @see Skin skin info
 * @see ItemStats item stat info
 * @author xhsun
 * @since 2017-02-07
 */
public class Inventory extends Storage{
	private int[] infusions;
	private int[] upgrades;
	private long skin;
	private ItemStats stats;
	private Binding binding;
	private String bound_to;

	public int[] getInfusions() {
		return infusions;
	}

	public int[] getUpgrades() {
		return upgrades;
	}

	public long getSkin() {
		return skin;
	}

	public ItemStats getStats() {
		return stats;
	}

	public Binding getBinding() {
		return binding;
	}

	public String getBound_to() {
		return bound_to;
	}

	@Override
	public String toString(){
		String result="{Item ID: "+super.getItemId()+" Count: "+super.getCount();
		if (upgrades!=null){
			result+=" Upgrade (item) IDs: ";
			for (int upgrade : upgrades) result += upgrade + "\n";
		}
		if (infusions!=null){
			result+=" Infusion (item) IDs: ";
			for (int infusion : infusions) result += infusion + "\n";
		}
		result+=" Skin ID: "+skin+" Item Stat: "+stats+" Binding: "+binding+" Bound To: "+bound_to+"}";
		return result;
	}
}