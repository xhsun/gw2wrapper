package me.xhsun.guildwars2wrapper.model.v1;

import java.util.List;

/**
 * For more info on v1 wvw matches API go <a href="https://wiki.guildwars2.com/wiki/API:1/wvw/matches">here</a><br/>
 * Model class for wvw match
 *
 * @author xhsun
 * @since 2017-06-28
 */
public class AllWvWMatchOverview {
	private List<MatchOverview> wvw_matches;

	public List<MatchOverview> getWvWMatches() {
		return wvw_matches;
	}

	@Deprecated
	public List<MatchOverview> getWvw_matches() {
		return wvw_matches;
	}

	public class MatchOverview {
		private String wvw_match_id, start_time, end_time;
		private int red_world_id, blue_world_id, green_world_id;

		public String getWvWMatchId() {
			return wvw_match_id;
		}

		public String getStartTime() {
			return start_time;
		}

		public String getEndTime() {
			return end_time;
		}

		public int getRedWorldId() {
			return red_world_id;
		}

		public int getBlueWorldId() {
			return blue_world_id;
		}

		public int getGreenWorldId() {
			return green_world_id;
		}

		@Deprecated
		public String getWvw_match_id() {
			return wvw_match_id;
		}

		@Deprecated
		public String getStart_time() {
			return start_time;
		}

		@Deprecated
		public String getEnd_time() {
			return end_time;
		}

		@Deprecated
		public int getRed_world_id() {
			return red_world_id;
		}

		@Deprecated
		public int getBlue_world_id() {
			return blue_world_id;
		}

		@Deprecated
		public int getGreen_world_id() {
			return green_world_id;
		}
	}
}
