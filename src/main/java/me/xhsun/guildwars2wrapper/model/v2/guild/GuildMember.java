package me.xhsun.guildwars2wrapper.model.v2.guild;

/**
 * For more info on guild member API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/members">here</a><br/>
 * Model class for guild member
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class GuildMember {
	private String name, rank, joined;

	public String getName() {
		return name;
	}

	public String getRank() {
		return rank;
	}

	public String getJoined() {
		return joined;
	}
}
