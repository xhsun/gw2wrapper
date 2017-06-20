package me.xhsun.guildwars2wrapper.model.wvw.matches;

import java.util.List;

/**
 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
 * Model class for WvW match score
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class WvWMatchScore extends WvWMatch {
	private WvWMatchDetail.Score scores, victory_points;
	private List<WvWMatchDetail.Skirmish> skirmishes;
	private List<MapScore> maps;

	public WvWMatchDetail.Score getScores() {
		return scores;
	}

	public WvWMatchDetail.Score getVictoryPoints() {
		return victory_points;
	}

	public List<WvWMatchDetail.Skirmish> getSkirmishes() {
		return skirmishes;
	}

	public List<MapScore> getMaps() {
		return maps;
	}

	@Override
	public String toString() {
		return "WvWMatchScore{" +
				"id=" + getId() +
				", scores=" + scores +
				", victory_points=" + victory_points +
				", skirmishes=" + skirmishes +
				", maps=" + maps +
				'}';
	}

	public class MapScore extends WvWMatchMap {
		private WvWMatchDetail.Score scores;

		public WvWMatchDetail.Score getScores() {
			return scores;
		}

		@Override
		public String toString() {
			return "GeneralMapScore{" +
					super.toString() +
					", scores=" + scores +
					'}';
		}
	}
}
