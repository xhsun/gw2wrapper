package me.xhsun.guildwars2wrapper.model.v2.wvw.matches;

import java.util.List;

/**
 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
 * Model class for WvW match status
 *
 * @author xhsun
 * @since 2017-06-20
 */
public class WvWMatchStat extends WvWMatch {
	private WvWMatchDetail.Score deaths, kills;
	private List<MapStat> maps;

	public WvWMatchDetail.Score getDeaths() {
		return deaths;
	}

	public WvWMatchDetail.Score getKills() {
		return kills;
	}

	public List<MapStat> getMaps() {
		return maps;
	}

	public class MapStat extends WvWMatchMap {
		private WvWMatchDetail.Score deaths, kills;

		public WvWMatchDetail.Score getDeaths() {
			return deaths;
		}

		public WvWMatchDetail.Score getKills() {
			return kills;
		}
	}
}
