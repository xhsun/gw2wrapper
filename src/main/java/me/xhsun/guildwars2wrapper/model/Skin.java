package me.xhsun.guildwars2wrapper.model;

import me.xhsun.guildwars2wrapper.model.indentifiable.Nameable;
import me.xhsun.guildwars2wrapper.model.util.comm.Type;
import me.xhsun.guildwars2wrapper.model.util.itemDetail.ItemDetail;

import java.util.List;

/**
 * For more info on Skin API go <a href="https://wiki.guildwars2.com/wiki/API:2/skins">here</a><br/>
 * Skin model class<br/>
 * Note: icon is a url
 *
 * @author xhsun
 * @see Item item info
 * @since 2017-02-07
 */

public class Skin extends Nameable {
	public enum Flag {ShowInWardrobe, NoCost, HideIfLocked, OverrideRarity}
	private Item.Type type;
	private List<Flag> flags;
	private List<Item.Restriction> restrictions;
	private String icon;
	private Item.Rarity rarity;
	private String description;
	private Detail details;

	public Item.Type getType() {
		return type;
	}

	public List<Flag> getFlags() {
		return flags;
	}

	public List<Item.Restriction> getRestrictions() {
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
	public String toString() {
		return "Skin{" +
				"id=" + getId() +
				", name='" + getName() + '\'' +
				", type=" + type +
				", flags=" + flags +
				", restrictions=" + restrictions +
				", icon='" + icon + '\'' +
				", rarity=" + rarity +
				", description='" + description + '\'' +
				", details=" + details +
				'}';
	}

	/**
	 * Skin detail class for skin model
	 *
	 * @author xhsun
	 * @since 2017-02-07
	 */

	public class Detail {
		private Type type;
		private ItemDetail.Weight weight_class;
		private ItemDetail.Damage damage_type;

		public Type getType() {
			return type;
		}

		public ItemDetail.Weight getWeightClass() {
			return weight_class;
		}

		public ItemDetail.Damage getDamageType() {
			return damage_type;
		}

		@Override
		public String toString() {
			return "Detail{" +
					"type=" + type +
					", weight_class=" + weight_class +
					", damage_type=" + damage_type +
					'}';
		}
	}
}
