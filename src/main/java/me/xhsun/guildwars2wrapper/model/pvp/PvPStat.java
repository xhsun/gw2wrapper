package me.xhsun.guildwars2wrapper.model.pvp;

import java.util.Map;

/**
 * For more info on pvp stat API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/stats">here</a><br/>
 * Model class for pvp stat
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class PvPStat {
	private int pvp_rank, pvp_rank_points, pvp_rank_rollovers;
	private WinLoss aggregate;
	private Map<String, WinLoss> professions, ladders;

	public int getPvPRank() {
		return pvp_rank;
	}

	public int getPvpRank_points() {
		return pvp_rank_points;
	}

	public int getPvPRankRollovers() {
		return pvp_rank_rollovers;
	}

	public WinLoss getAggregate() {
		return aggregate;
	}

	public Map<String, WinLoss> getProfessions() {
		return professions;
	}

	public Map<String, WinLoss> getLadders() {
		return ladders;
	}

	@Override
	public String toString() {
		return "PvPStat{" +
				"pvp_rank=" + pvp_rank +
				", pvp_rank_points=" + pvp_rank_points +
				", pvp_rank_rollovers=" + pvp_rank_rollovers +
				", aggregate=" + aggregate +
				", professions=" + professions +
				", ladders=" + ladders +
				'}';
	}

	public class WinLoss {
		private int wins, losses, desertions, byes, forfeits;

		public int getWins() {
			return wins;
		}

		public int getLosses() {
			return losses;
		}

		public int getDesertions() {
			return desertions;
		}

		public int getByes() {
			return byes;
		}

		public int getForfeits() {
			return forfeits;
		}

		@Override
		public String toString() {
			return "WinLoss{" +
					"wins=" + wins +
					", losses=" + losses +
					", desertions=" + desertions +
					", byes=" + byes +
					", forfeits=" + forfeits +
					'}';
		}
	}
}
