package me.xhsun.guildwars2wrapper.model.v2.achievement;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;
import me.xhsun.guildwars2wrapper.model.v2.util.comm.Region;

import java.util.List;

/**
 * For more info on achievement API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">here</a><br/>
 * Model class for achievement
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class Achievement extends NameableInt {
	private enum Type {
		Default, ItemSet,
		Coins, Item, Mastery, Title,
		Text, Minipet, Skin
	}

	private enum Flag {
		Pvp, CategoryDisplay, MoveToTop, IgnoreNearlyComplete, Repeatable, Hidden,
		RequiresUnlock, RepairOnLogin, Daily, Weekly, Monthly, Permanent
	}

	private String icon;
	private String description;
	private String requirement;
	private String locked_text;
	private Type type;
	private List<Flag> flags;
	private List<Tier> tiers;
	private List<Integer> prerequisites;//achievement ids
	private List<Reward> rewards;
	private List<Bits> bits;

	public String getIcon() {
		return icon;
	}

	public String getDescription() {
		return description;
	}

	public String getRequirement() {
		return requirement;
	}

	public String getLockedText() {
		return locked_text;
	}

	public Type getType() {
		return type;
	}

	public List<Flag> getFlags() {
		return flags;
	}

	public List<Tier> getTiers() {
		return tiers;
	}

	public List<Integer> getPrerequisites() {
		return prerequisites;
	}

	public List<Reward> getRewards() {
		return rewards;
	}

	public List<Bits> getBits() {
		return bits;
	}

	public class Tier {
		private int count;
		private int points;

		public int getCount() {
			return count;
		}

		public int getPoints() {
			return points;
		}
	}

	public class Reward {
		private Type type;
		private int id;
		private long count;
		private Region region;

		/**
		 * if {@link #type} is
		 * - coins: count
		 * - item: item id, count
		 * - mastery: mastery id, region
		 * - title: title id
		 */
		public Type getType() {
			return type;
		}

		/**
		 * the type of id depend on {@link #type}
		 *
		 * @return item id | mastery id | title id
		 */
		public int getId() {
			return id;
		}

		/**
		 * the type of stuff rewarded depend on {@link #type}
		 *
		 * @return number of coin | item
		 */
		public long getCount() {
			return count;
		}

		public Region getRegion() {
			return region;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Reward reward = (Reward) o;

			return id == reward.id &&
					count == reward.count &&
					type == reward.type &&
					region == reward.region;
		}

		@Override
		public int hashCode() {
			int result = type != null ? type.hashCode() : 0;
			result = 31 * result + id;
			result = 31 * result + (int) (count ^ (count >>> 32));
			result = 31 * result + (region != null ? region.hashCode() : 0);
			return result;
		}
	}

	public class Bits {
		private Type type;
		private int id;
		private String text;

		/**
		 * if {@link #type} is
		 * - text: {@link #text}
		 * - item: item id
		 * - minipet: mini id
		 * - skin: skin id
		 */
		public Type getType() {
			return type;
		}

		public int getId() {
			return id;
		}

		public String getText() {
			return text;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Bits bits = (Bits) o;

			return id == bits.id &&
					type == bits.type &&
					(text != null ? text.equals(bits.text) : bits.text == null);
		}

		@Override
		public int hashCode() {
			int result = type != null ? type.hashCode() : 0;
			result = 31 * result + id;
			result = 31 * result + (text != null ? text.hashCode() : 0);
			return result;
		}
	}
}
