package me.xhsun.guildwars2wrapper.model.v2.wvw.matches;

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

	public class MapScore extends WvWMatchMap {
		private WvWMatchDetail.Score scores;

		public WvWMatchDetail.Score getScores() {
			return scores;
		}
	}
}
