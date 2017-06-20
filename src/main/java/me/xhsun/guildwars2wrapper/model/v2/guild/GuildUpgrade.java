package me.xhsun.guildwars2wrapper.model.v2.guild;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;

import java.util.List;

/**
 * For more info on guild upgrades API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">here</a><br/>
 * Model class for guild upgrade
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class GuildUpgrade extends NameableInt {
	public enum Type {
		AccumulatingCurrency, BankBag, Boost, Claimable, Consumable, Decoration, GuildHall, GuildHallExpedition,
		Hub, Queue, Unlock
	}

	public enum CostType {Item, Collectible, Currency, Coins}

	private String description;
	private Type type;
	private int bag_max_items;
	private int bag_max_coins;
	private String icon;
	private int build_time;
	private int required_level;
	private int experience;
	private List<Integer> prerequisites;
	private List<Cost> costs;

	public String getDescription() {
		return description;
	}

	public Type getType() {
		return type;
	}

	/**
	 * Only used when {@link #type} is {@link Type#BankBag}
	 */
	public int getBagMaxItems() {
		return bag_max_items;
	}

	/**
	 * Only used when {@link #type} is {@link Type#BankBag}
	 */
	public int getBagMaxCoins() {
		return bag_max_coins;
	}

	public String getIcon() {
		return icon;
	}

	public int getBuildTime() {
		return build_time;
	}

	public int getRequiredLevel() {
		return required_level;
	}

	public int getExperience() {
		return experience;
	}

	/**
	 * @return list of {@link GuildUpgrade} ids
	 */
	public List<Integer> getPrerequisites() {
		return prerequisites;
	}

	public List<Cost> getCosts() {
		return costs;
	}

	public class Cost {
		private CostType type;
		private String name;
		private int count;
		private int item_id;

		public CostType getType() {
			return type;
		}

		public String getName() {
			return name;
		}

		public int getCount() {
			return count;
		}

		public int getItemId() {
			return item_id;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Cost cost = (Cost) o;

			return count == cost.count &&
					item_id == cost.item_id &&
					type == cost.type;
		}

		@Override
		public int hashCode() {
			int result = type != null ? type.hashCode() : 0;
			result = 31 * result + count;
			result = 31 * result + item_id;
			return result;
		}
	}
}
