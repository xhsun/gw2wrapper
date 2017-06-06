package me.xhsun.guildwars2wrapper.model.achievements;

import com.google.gson.annotations.Expose;

import java.util.Arrays;

/**
 * For more info on achievements API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">here</a><br/>
 * Model class for achievements
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class Achievement {
	private enum Type {
		Default, ItemSet,
		Coins, Item, Mastery, Title,
		Text, Minipet, Skin
	}

	public enum RewardRegion {Tyria, Maguuma}//TODO update this every time new mastery region is out

	private enum Flag {
		Pvp, CategoryDisplay, MoveToTop, IgnoreNearlyComplete, Repeatable, Hidden,
		RequiresUnlock, RepairOnLogin, Daily, Weekly, Monthly, Permanent
	}

	private int id;
	private String icon;
	private String name;
	private String description;
	private String requirement;
	private String locked_text;
	private Type type;
	private Flag[] flags;
	private Tier[] tiers;
	private int[] prerequisites;//achievement ids
	private Reward[] rewards;
	private Bits[] bits;

	public int getId() {
		return id;
	}

	public String getIcon() {
		return icon;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getRequirement() {
		return requirement;
	}

	public String getLocked_text() {
		return locked_text;
	}

	public Type getType() {
		return type;
	}

	public Flag[] getFlags() {
		return flags;
	}

	public Tier[] getTiers() {
		return tiers;
	}

	public int[] getPrerequisites() {
		return prerequisites;
	}

	public Reward[] getRewards() {
		return rewards;
	}

	public Bits[] getBits() {
		return bits;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Achievement that = (Achievement) o;

		return id == that.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "Achievement{" +
				"id=" + id +
				", icon='" + icon + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", requirement='" + requirement + '\'' +
				", locked_text='" + locked_text + '\'' +
				", type=" + type +
				", flags=" + Arrays.toString(flags) +
				", tiers=" + Arrays.toString(tiers) +
				", prerequisites=" + Arrays.toString(prerequisites) +
				", rewards=" + Arrays.toString(rewards) +
				", bits=" + Arrays.toString(bits) +
				'}';
	}

	public class Tier {
		@Expose
		private int count;
		@Expose
		private int points;

		public int getCount() {
			return count;
		}

		public int getPoints() {
			return points;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Tier that = (Tier) o;

			return count == that.count && points == that.points;
		}

		@Override
		public int hashCode() {
			int result = count;
			result = 31 * result + points;
			return result;
		}

		@Override
		public String toString() {
			return "AchievementTier{" +
					"count=" + count +
					", points=" + points +
					'}';
		}
	}

	public class Reward {
		@Expose
		private Type type;
		@Expose
		private int id;
		@Expose
		private long count;
		@Expose
		private RewardRegion region;

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

		public RewardRegion getRegion() {
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

		@Override
		public String toString() {
			return "Reward{" +
					"type=" + type +
					", id=" + id +
					", count=" + count +
					", region=" + region +
					'}';
		}
	}

	public class Bits {
		@Expose
		private Type type;
		@Expose
		private int id;
		@Expose
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

		@Override
		public String toString() {
			return "Bits{" +
					"type=" + type +
					", id=" + id +
					", text='" + text + '\'' +
					'}';
		}
	}
}