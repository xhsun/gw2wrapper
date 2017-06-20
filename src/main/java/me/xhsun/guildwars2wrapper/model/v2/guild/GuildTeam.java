package me.xhsun.guildwars2wrapper.model.v2.guild;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableStr;
import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;
import me.xhsun.guildwars2wrapper.model.v2.pvp.PvPGame;
import me.xhsun.guildwars2wrapper.model.v2.pvp.PvPStat;

import java.util.List;
import java.util.Map;

/**
 * For more info on guild teams API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/teams">here</a><br/>
 * Model class for guild teams
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class GuildTeam extends NameableInt {
	private List<Member> members;
	private PvPStat.WinLoss aggregate;
	private Map<String, PvPStat.WinLoss> ladders;
	private List<PvPGame> games;
	private List<Season> seasons;

	public List<Member> getMembers() {
		return members;
	}

	public PvPStat.WinLoss getAggregate() {
		return aggregate;
	}

	public Map<String, PvPStat.WinLoss> getLadders() {
		return ladders;
	}

	public List<PvPGame> getGames() {
		return games;
	}

	public List<Season> getSeasons() {
		return seasons;
	}

	public class Member {
		private String name, role;

		public String getName() {
			return name;
		}

		public String getRole() {
			return role;
		}
	}

	public class Season extends IdentifiableStr {
		private int wins, losses, rating;

		public int getWins() {
			return wins;
		}

		public int getLosses() {
			return losses;
		}

		public int getRating() {
			return rating;
		}
	}
}
