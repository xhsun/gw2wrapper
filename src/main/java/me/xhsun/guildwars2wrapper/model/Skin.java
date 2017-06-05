package me.xhsun.guildwars2wrapper.model;

import com.google.gson.annotations.Expose;
import me.xhsun.guildwars2wrapper.model.util.comm.Type;
import me.xhsun.guildwars2wrapper.model.util.itemDetail.ItemDetail;

import java.util.Arrays;

/**
 * For more info on Skin API go <a href="https://wiki.guildwars2.com/wiki/API:2/skins">here</a><br/>
 * Skin model class<br/>
 * Note: icon is a url
 *
 * @author xhsun
 * @see Item item info
 * @since 2017-02-07
 */

public class Skin {
	public enum Flag {ShowInWardrobe, NoCost, HideIfLocked, OverrideRarity}

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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Skin skin = (Skin) o;

		return id == skin.id;
	}

	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}

	@Override
	public String toString() {
		return "Skin{" +
				"id=" + id +
				", name='" + name + '\'' +
				", type=" + type +
				", flags=" + Arrays.toString(flags) +
				", restrictions=" + Arrays.toString(restrictions) +
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
		@Expose
		private Type type;
		@Expose
		private ItemDetail.Weight weight_class;
		@Expose
		private ItemDetail.Damage damage_type;

		public Type getType() {
			return type;
		}

		public ItemDetail.Weight getWeight_class() {
			return weight_class;
		}

		public ItemDetail.Damage getDamage_type() {
			return damage_type;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Detail detail = (Detail) o;

			return type == detail.type &&
					weight_class == detail.weight_class &&
					damage_type == detail.damage_type;

		}

		@Override
		public int hashCode() {
			int result = type != null ? type.hashCode() : 0;
			result = 31 * result + (weight_class != null ? weight_class.hashCode() : 0);
			result = 31 * result + (damage_type != null ? damage_type.hashCode() : 0);
			return result;
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
