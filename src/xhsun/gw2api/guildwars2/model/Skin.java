package xhsun.gw2api.guildwars2.model;

import com.google.gson.annotations.Expose;

import xhsun.gw2api.guildwars2.model.util.itemDetail.ItemDetail;

/**
 * For more info on Skin API go <a href="https://wiki.guildwars2.com/wiki/API:2/skins">here</a><br/>
 * Skin model class<br/>
 * Note: icon is a url
 * @see Item item info
 * @author xhsun
 * @since 2017-02-07
 */

public class Skin {
	public enum Flag{ShowInWardrobe, NoCost, HideIfLocked, OverrideRarity}
	private long id;
	private String name;
	private Item.Type type;
	private Flag[] flags;
	private Item.Restriction[] restrictions;
	private String icon;
	private Item.Rarity rarity;
	private String description;
	private Detail details;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Item.Type getType() {
		return type;
	}

	public Flag[] getFlags() {
		return flags;
	}

	public Item.Restriction[] getRestrictions() {
		return restrictions;
	}

	public String getIcon() {
		return icon;
	}

	public Item.Rarity getRarity() {
		return rarity;
	}

	public String getDescription() {
		return description;
	}

	public Detail getDetails() {
		return details;
	}

	@Override
	public String toString(){
		String result="{Skin ID: "+id+" Name: "+name+" Type: "+type;
		if (flags!=null){
			result+=" {Flags: ";
			for (Flag flag : flags) result += flag + ", ";
		}
		result=result.substring(0, result.length()-2)+"} ";
		if (restrictions!=null){
			result+=" {Restrictions: ";
			for (Item.Restriction restriction : restrictions) result += restriction + ", ";
		}
		result=result.substring(0, result.length()-2)+"} ";
		result+="Icon: "+icon+" Rarity: "+rarity+" Description: "+description+" Details: "+details;
		return result;
	}

	/**
	 * Skin detail class for skin model
	 * @author xhsun
	 * @since 2017-02-07
	 */

	public class Detail {
		@Expose
		private ItemDetail.Type type;
		@Expose
		private ItemDetail.Weight weight_class;
		@Expose
		private ItemDetail.Damage damage_type;

		public ItemDetail.Type getType() {
			return type;
		}

		public ItemDetail.Weight getWeight_class() {
			return weight_class;
		}

		public ItemDetail.Damage getDamage_type() {
			return damage_type;
		}

		@Override
		public String toString(){
			return "{Type: "+type+" WeightClass: "+weight_class+" DamageType: "+damage_type+"}";
		}
	}
}
