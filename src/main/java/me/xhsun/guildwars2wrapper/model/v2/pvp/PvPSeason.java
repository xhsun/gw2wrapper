package me.xhsun.guildwars2wrapper.model.v2.pvp;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableStr;

import java.util.List;

/**
 * For more info on pvp season API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">here</a><br/>
 * Model class for pvp season
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class PvPSeason extends NameableStr {
	public enum DivisionFlag {CanLosePoints, CanLoseTiers, Repeatable}
	private String start, end;
	private boolean active;
	private List<Division> divisions;
	private LeaderBoard leaderboards;

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public boolean isActive() {
		return active;
	}

	public List<Division> getDivisions() {
		return divisions;
	}

	public LeaderBoard getLeaderBoards() {
		return leaderboards;
	}

	public class Division {
		private String name, large_icon, small_icon, pip_icon;
		private List<DivisionTier> tiers;
		private List<DivisionFlag> flags;

		public String getName() {
			return name;
		}

		public String getLargeIcon() {
			return large_icon;
		}

		public String getSmallIcon() {
			return small_icon;
		}

		public String getPipIcon() {
			return pip_icon;
		}

		public List<DivisionFlag> getFlags() {
			return flags;
		}

		public List<DivisionTier> getTiers() {
			return tiers;
		}
	}

	public class DivisionTier {
		private int points;

		public int getPoints() {
			return points;
		}
	}

	public class LeaderBoard {
		private LeaderBoardDetail ladder, legendary, guild;

		public LeaderBoardDetail getLadder() {
			return ladder;
		}

		public LeaderBoardDetail getLegendary() {
			return legendary;
		}

		public LeaderBoardDetail getGuild() {
			return guild;
		}
	}

	public class LeaderBoardDetail {
		private LeaderBoardSetting settings;
		private List<LeaderBoardScoring> scorings;

		public LeaderBoardSetting getSettings() {
			return settings;
		}

		public List<LeaderBoardScoring> getScorings() {
			return scorings;
		}
	}

	public class LeaderBoardSetting {
		private String name, scoring;
		private int duration;
		private List<LeaderBoardTier> tiers;

		public String getName() {
			return name;
		}

		public String getScoring() {
			return scoring;
		}

		public int getDuration() {
			return duration;
		}

		public List<LeaderBoardTier> getTiers() {
			return tiers;
		}
	}

	public class LeaderBoardScoring extends NameableStr {
		private String type, description, ordering;

		public String getType() {
			return type;
		}

		public String getDescription() {
			return description;
		}

		public String getOrdering() {
			return ordering;
		}
	}

	public class LeaderBoardTier {
		private String color, type, name;
		private List<Float> range;

		public String getColor() {
			return color;
		}

		public String getType() {
			return type;
		}

		public String getName() {
			return name;
		}

		public List<Float> getRange() {
			return range;
		}
	}
}
