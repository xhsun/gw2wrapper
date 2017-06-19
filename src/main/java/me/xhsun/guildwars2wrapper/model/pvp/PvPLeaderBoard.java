package me.xhsun.guildwars2wrapper.model.pvp;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableStr;
import me.xhsun.guildwars2wrapper.model.identifiable.NameableStr;

import java.util.List;

/**
 * For more info on pvp leaderboards API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/leaderboards">here</a><br/>
 * Model class for pvp leaderboard
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class PvPLeaderBoard extends NameableStr {
	private int rank, team_id;
	private String team, date;
	private List<Score> scores;

	public int getRank() {
		return rank;
	}

	public int getTeamId() {
		return team_id;
	}

	public String getTeam() {
		return team;
	}

	public String getDate() {
		return date;
	}

	public List<Score> getScores() {
		return scores;
	}

	@Override
	public String toString() {
		return "PvPLeaderBoard{" +
				super.toString() +
				", rank=" + rank +
				", team_id=" + team_id +
				", team='" + team + '\'' +
				", date='" + date + '\'' +
				", scores=" + scores +
				'}';
	}

	public class Score extends IdentifiableStr {
		private int value;

		public int getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "Score{" +
					"id=" + getId() +
					", value=" + value +
					'}';
		}
	}
}
