package me.xhsun.guildwars2wrapper.model.v2.wvw.matches;

import java.util.List;

/**
 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
 * Model class for WvW match overview
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class WvWMatchOverview extends WvWMatch {
	private String start_time, end_time;
	private WvWMatchDetail.Score worlds;
	private AllWorld all_worlds;

	public String getStartTime() {
		return start_time;
	}

	public String getEndTime() {
		return end_time;
	}

	public WvWMatchDetail.Score getWorlds() {
		return worlds;
	}

	public AllWorld getAllWorlds() {
		return all_worlds;
	}

	public class AllWorld {
		private List<Integer> red, blue, green;

		public List<Integer> getRed() {
			return red;
		}

		public List<Integer> getBlue() {
			return blue;
		}

		public List<Integer> getGreen() {
			return green;
		}
	}
}
