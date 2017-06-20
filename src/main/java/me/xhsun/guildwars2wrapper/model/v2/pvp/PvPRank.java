package me.xhsun.guildwars2wrapper.model.v2.pvp;

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

	public int getFinisherId() {
		return finisher_id;
	}

	public int getMinRank() {
		return min_rank;
	}

	public int getMaxRank() {
		return max_rank;
	}

	public String getIcon() {
		return icon;
	}

	public List<Level> getLevels() {
		return levels;
	}

	private class Level {
		private int min_rank, max_rank, points;

		public int getMinRank() {
			return min_rank;
		}

		public int getMaxRank() {
			return max_rank;
		}

		public int getPoints() {
			return points;
		}
	}
}
