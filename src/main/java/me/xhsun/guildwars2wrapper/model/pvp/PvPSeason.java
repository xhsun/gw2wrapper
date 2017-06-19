package me.xhsun.guildwars2wrapper.model.pvp;

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

	@Override
	public String toString() {
		return "PvPSeason{" +
				super.toString() +
				", started='" + start + '\'' +
				", ended='" + end + '\'' +
				", active=" + active +
				", divisions=" + divisions +
				", leaderBoards=" + leaderboards +
				'}';
	}

	public class Division {
		private String name, large_icon, small_icon, pip_icon;
		private List<DivisionTier> tiers;

		public String getName() {
			return name;
		}

		public String getLarge_icon() {
			return large_icon;
		}

		public String getSmall_icon() {
			return small_icon;
		}

		public String getPip_icon() {
			return pip_icon;
		}

		public List<DivisionTier> getTiers() {
			return tiers;
		}

		@Override
		public String toString() {
			return "Division{" +
					"name='" + name + '\'' +
					", large_icon='" + large_icon + '\'' +
					", small_icon='" + small_icon + '\'' +
					", pip_icon='" + pip_icon + '\'' +
					", tiers=" + tiers +
					'}';
		}
	}

	public class DivisionTier {
		private int points;

		public int getPoints() {
			return points;
		}

		@Override
		public String toString() {
			return "DivisionTier{" +
					"points=" + points +
					'}';
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

		@Override
		public String toString() {
			return "LeaderBoard{" +
					"ladder=" + ladder +
					", legendary=" + legendary +
					", guild=" + guild +
					'}';
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

		@Override
		public String toString() {
			return "LeaderBoardDetail{" +
					"settings=" + settings +
					", scorings=" + scorings +
					'}';
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

		@Override
		public String toString() {
			return "LeaderBoardSetting{" +
					"name='" + name + '\'' +
					", scoring='" + scoring + '\'' +
					", duration=" + duration +
					", tiers=" + tiers +
					'}';
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

		@Override
		public String toString() {
			return "LeaderBoardScoring{" +
					super.toString() +
					", type='" + type + '\'' +
					", description='" + description + '\'' +
					", ordering='" + ordering + '\'' +
					'}';
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

		@Override
		public String toString() {
			return "LeaderBoardTier{" +
					"color='" + color + '\'' +
					", type='" + type + '\'' +
					", name='" + name + '\'' +
					", range=" + range +
					'}';
		}
	}
}
