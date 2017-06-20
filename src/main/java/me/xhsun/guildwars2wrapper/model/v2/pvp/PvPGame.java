package me.xhsun.guildwars2wrapper.model.v2.pvp;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableStr;
import me.xhsun.guildwars2wrapper.model.v2.Item;

/**
 * For more info on pvp games API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">here</a><br/>
 * Model class for pvp game
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class PvPGame extends IdentifiableStr {
	public enum RatingType {Ranked, Unranked, None}

	private int map_id, rating_change;
	private String started, ended, result, team, season;
	private Item.Restriction profession;
	private Score scores;
	private RatingType rating_type;

	public int getMapId() {
		return map_id;
	}

	public int getRatingChange() {
		return rating_change;
	}

	public String getStarted() {
		return started;
	}

	public String getEnded() {
		return ended;
	}

	public String getResult() {
		return result;
	}

	public String getTeam() {
		return team;
	}

	public String getSeason() {
		return season;
	}

	public Item.Restriction getProfession() {
		return profession;
	}

	public Score getScores() {
		return scores;
	}

	public RatingType getRatingType() {
		return rating_type;
	}

	public class Score {
		private int red, blue;

		public int getRed() {
			return red;
		}

		public int getBlue() {
			return blue;
		}
	}
}
