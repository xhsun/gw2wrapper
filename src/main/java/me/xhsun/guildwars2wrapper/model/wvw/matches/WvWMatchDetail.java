package me.xhsun.guildwars2wrapper.model.wvw.matches;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

import java.util.List;

/**
 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
 * Model class for WvW match
 *
 * @author xhsun
 * @since 2017-06-20
 */
public class WvWMatchDetail extends WvWMatchOverview {
	private Score scores, deaths, kills, victory_points;
	private List<Skirmish> skirmishes;
	private List<GeneralMap> maps;

	public Score getScores() {
		return scores;
	}

	public Score getDeaths() {
		return deaths;
	}

	public Score getKills() {
		return kills;
	}

	public Score getVictory_points() {
		return victory_points;
	}

	public List<Skirmish> getSkirmishes() {
		return skirmishes;
	}

	public List<GeneralMap> getMaps() {
		return maps;
	}

	@Override
	public String toString() {
		return "WvWMatchDetail{" +
				super.toString() +
				", scores=" + scores +
				", deaths=" + deaths +
				", kills=" + kills +
				", victory_points=" + victory_points +
				", skirmishes=" + skirmishes +
				", maps=" + maps +
				'}';
	}

	public class Score {
		private int red, blue, green;

		public int getRed() {
			return red;
		}

		public int getBlue() {
			return blue;
		}

		public int getGreen() {
			return green;
		}

		@Override
		public String toString() {
			return "Score{" +
					"red=" + red +
					", blue=" + blue +
					", green=" + green +
					'}';
		}
	}

	public class Skirmish extends IdentifiableInt {
		private Score scores;
		private List<SkirmishMapScore> map_scores;

		public Score getScores() {
			return scores;
		}

		public List<SkirmishMapScore> getMap_scores() {
			return map_scores;
		}

		@Override
		public String toString() {
			return "Skirmish{" +
					"id=" + getId() +
					", scores=" + scores +
					", map_scores=" + map_scores +
					'}';
		}
	}

	public class SkirmishMapScore {
		private WvWMatchMap.Type type;
		private Score scores;

		public WvWMatchMap.Type getType() {
			return type;
		}

		public Score getScores() {
			return scores;
		}

		@Override
		public String toString() {
			return "MapScore{" +
					"type=" + type +
					", scores=" + scores +
					'}';
		}
	}

	public class GeneralMap extends WvWMatchMap {
		private Score scores, deaths, kills;
		private List<Bonus> bonuses;
		private List<Objective> objectives;

		public Score getScores() {
			return scores;
		}

		public Score getDeaths() {
			return deaths;
		}

		public Score getKills() {
			return kills;
		}

		public List<Bonus> getBonuses() {
			return bonuses;
		}

		public List<Objective> getObjectives() {
			return objectives;
		}

		@Override
		public String toString() {
			return "GeneralMap{" +
					super.toString() +
					", scores=" + scores +
					", deaths=" + deaths +
					", kills=" + kills +
					", bonuses=" + bonuses +
					", objectives=" + objectives +
					'}';
		}
	}
}
