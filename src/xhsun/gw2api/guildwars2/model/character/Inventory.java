package xhsun.gw2api.guildwars2.model.character;

import xhsun.gw2api.guildwars2.model.account.Bank;
import xhsun.gw2api.guildwars2.model.util.Item;
import xhsun.gw2api.guildwars2.model.util.Skin;
import xhsun.gw2api.guildwars2.model.util.itemDetail.ItemStats;

/**
 * Character inventory bag inventory model class
 * @see Item item info
 * @see Skin skin info
 * @see ItemStats item stat info
 * @author xhsun
 * @since 2017-02-07
 */
public class Inventory {
	private long id;
	private int count;
	private int[] infusions;
	private int[] upgrades;
	private long skin;
	private ItemStats stats;
	private Bank.Binding binding;
	private String bound_to;

	public long getId() {
		return id;
	}

	public int getCount() {
		return count;
	}

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

	public Bank.Binding getBinding() {
		return binding;
	}

	public String getBound_to() {
		return bound_to;
	}

	@Override
	public String toString(){
		String result="{Item ID: "+id+" Count: "+count;
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