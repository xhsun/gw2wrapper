package me.xhsun.guildwars2wrapper.model.account;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableStr;

import java.util.List;

/**
 * For more info on Account API go <a href="https://wiki.guildwars2.com/wiki/API:2/account">here</a><br/>
 * Account Model class
 * Note: world id equals to negative one if there is an error
 *
 * @author xhsun
 * @see me.xhsun.guildwars2wrapper.model.World world info
 * @since 2017-02-06
 */

public class Account extends IdentifiableStr {
	public enum Access {None, PlayForFree, GuildWars2, HeartOfThorns}

	private long age;
	private String name;
	private int world = -1;
	private List<String> guilds;
	private List<String> guild_leader;
	private String created;
	private Access access;
	private boolean commander = false;
	private int fractal_level;
	private long daily_ap;
	private long monthly_ap;
	private long wvw_rank;

	public long getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public int getWorldId() {
		return world;
	}

	public List<String> getGuilds() {
		return guilds;
	}

	public List<String> getGuildLeader() {
		return guild_leader;
	}

	/**
	 * @return ISO-8601 standard timestamp
	 */
	public String getCreated() {
		return created;
	}

	public Access getAccess() {
		return access;
	}

	public boolean isCommander() {
		return commander;
	}

	public int getFractalLevel() {
		return fractal_level;
	}

	public long getDailyAP() {
		return daily_ap;
	}

	public long getMonthlyAP() {
		return monthly_ap;
	}

	public long getWvwRank() {
		return wvw_rank;
	}

	@Override
	public String toString() {
		return "Account{" +
				"id='" + getId() + '\'' +
				", age=" + age +
				", name='" + name + '\'' +
				", world=" + world +
				", guilds=" + guilds +
				", guild_leader=" + guild_leader +
				", created='" + created + '\'' +
				", access=" + access +
				", commander=" + commander +
				", fractal_level=" + fractal_level +
				", daily_ap=" + daily_ap +
				", monthly_ap=" + monthly_ap +
				", wvw_rank=" + wvw_rank +
				'}';
	}
}
