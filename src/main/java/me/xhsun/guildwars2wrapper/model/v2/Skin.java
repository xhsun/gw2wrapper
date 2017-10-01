package me.xhsun.guildwars2wrapper.model.v2;

import com.google.gson.annotations.SerializedName;
import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;
import me.xhsun.guildwars2wrapper.model.v2.util.comm.Type;
import me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.ItemDetail;

import java.util.List;
import java.util.Map;

/**
 * For more info on Skin API go <a href="https://wiki.guildwars2.com/wiki/API:2/skins">here</a><br/>
 * Skin model class<br/>
 * Note: icon is a url
 *
 * @author xhsun
 * @see Item item info
 * @since 2017-02-07
 */

public class Skin extends NameableInt {
	public enum Flag {ShowInWardrobe, NoCost, HideIfLocked, OverrideRarity}

	public enum ColorMaterial {cloth, leather, metal}
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
		private DyeSlot dye_slots;

		public Type getType() {
			return type;
		}

		public ItemDetail.Weight getWeightClass() {
			return weight_class;
		}

		public ItemDetail.Damage getDamageType() {
			return damage_type;
		}

		/**
		 * Only available if the skin type is armor
		 */
		public DyeSlot getDyeSlots() {
			return dye_slots;
		}
	}

	public class DyeSlot {
		@SerializedName("default")
		private List<DefaultColor> _default;
		private Map<String, DefaultColor> overrides;

		public List<DefaultColor> getDefault() {
			return _default;
		}

		public Map<String, DefaultColor> getOverrides() {
			return overrides;
		}
	}

	public class DefaultColor {
		private int color_id;
		private ColorMaterial material;

		public int getColorID() {
			return color_id;
		}

		public ColorMaterial getMaterial() {
			return material;
		}
	}
}
