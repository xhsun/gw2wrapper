package me.xhsun.guildwars2wrapper.model.v2.wvw.matches;

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

	public Score getVictoryPoints() {
		return victory_points;
	}

	public List<Skirmish> getSkirmishes() {
		return skirmishes;
	}

	public List<GeneralMap> getMaps() {
		return maps;
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
	}

	public class Skirmish extends IdentifiableInt {
		private Score scores;
		private List<SkirmishMapScore> map_scores;

		public Score getScores() {
			return scores;
		}

		public List<SkirmishMapScore> getMapScores() {
			return map_scores;
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
	}
}
