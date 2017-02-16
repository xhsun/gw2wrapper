package xhsun.gw2api.guildwars2.model.account;

import java.util.List;

import xhsun.gw2api.guildwars2.model.Item;
import xhsun.gw2api.guildwars2.model.Skin;
import xhsun.gw2api.guildwars2.model.util.Storage;

/**
 * For more info on Bank API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/bank">here</a><br/>
 * Bank item model class<br/>
 * Note: if slot is empty, API will return null
 * @see Item item info
 * @see Skin skin info
 * @author xhsun
 * @since 2017-02-07
 */

public class Bank extends Storage {
	private long skin;
	private List<Integer> upgrades;
	private List<Integer> infusions;
	private Binding binding;
	private int charges;
	private String bound_to;

	public long getSkinId() {
		return skin;
	}

	public List<Integer> getUpgradeIds() {
		return upgrades;
	}

	public List<Integer> getInfusionIds() {
		return infusions;
	}

	public Binding getBinding() {
		return binding;
	}

	public int getCharges() {
		return charges;
	}

	public String getBound_to() {
		return bound_to;
	}

	@Override
	public String toString(){
		String result="{Item ID: "+super.getItemId()+" Count: "+super.getCount()+" Skin ID: "+skin+"\n";
		if (upgrades!=null){
			result+="Upgrade (item) IDs: ";
			for (int upgrade : upgrades) result += upgrade + "\n";
		}
		if (infusions!=null){
			result+="Infusion (item) IDs: ";
			for (int infusion : infusions) result += infusion + "\n";
		}
		result+="Binding: "+binding+" Charges: "+charges+" Bound To: "+bound_to;
		return result+"}";
	}
}
