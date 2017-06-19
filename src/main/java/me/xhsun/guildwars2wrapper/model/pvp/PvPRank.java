package me.xhsun.guildwars2wrapper.model.pvp;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;

import java.util.List;

/**
 * For more info on pvp ranks API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">here</a><br/>
 * Model class for pvp rank
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class PvPRank extends NameableInt {
	private int finisher_id, min_rank, max_rank;
	private String icon;
	private List<Level> levels;

	public int getFinisher_id() {
		return finisher_id;
	}

	public int getMin_rank() {
		return min_rank;
	}

	public int getMax_rank() {
		return max_rank;
	}

	public String getIcon() {
		return icon;
	}

	public List<Level> getLevels() {
		return levels;
	}

	@Override
	public String toString() {
		return "PvPRank{" +
				super.toString() +
				", finisher_id=" + finisher_id +
				", min_rank=" + min_rank +
				", max_rank=" + max_rank +
				", icon='" + icon + '\'' +
				", levels=" + levels +
				'}';
	}

	private class Level {
		private int min_rank, max_rank, points;

		public int getMin_rank() {
			return min_rank;
		}

		public int getMax_rank() {
			return max_rank;
		}

		public int getPoints() {
			return points;
		}

		@Override
		public String toString() {
			return "Level{" +
					"min_rank=" + min_rank +
					", max_rank=" + max_rank +
					", points=" + points +
					'}';
		}
	}
}
