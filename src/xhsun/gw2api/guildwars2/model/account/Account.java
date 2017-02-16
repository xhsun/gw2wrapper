package xhsun.gw2api.guildwars2.model.account;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.List;

import xhsun.gw2api.guildwars2.model.World;

/**
 * For more info on Account API go <a href="https://wiki.guildwars2.com/wiki/API:2/account">here</a><br/>
 * Account Model class
 * Note: world id equals to negative one if there is an error
 * @see World world info
 * @author xhsun
 * @since 2017-02-06
 */
public class Account {
	public enum Access {None, PlayForFree, GuildWars2, HeartOfThorns}

	private String id;
	private long age;
	private String name;
	private int world = -1;
	private List<String> guilds;
	private List<String> guild_leader;
	private String created;
	private Access access;
	private boolean commander=false;
	private int fractal_level;
	private long daily_ap;
	private long monthly_ap;
	private long wvw_rank;

	public String getId() {
		return id;
	}

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

	public List<String> getGuild_leader() {
		return guild_leader;
	}

	public DateTime getCreated() {
		if (created==null) return null;
		DateTimeFormatter formatter= ISODateTimeFormat.dateTimeNoMillis();
		return formatter.parseDateTime(created);
	}

	public Access getAccess() {
		return access;
	}

	public boolean isCommander() {
		return commander;
	}

	public int getFractal_level() {
		return fractal_level;
	}

	public long getDaily_ap() {
		return daily_ap;
	}

	public long getMonthly_ap() {
		return monthly_ap;
	}

	public long getWvw_rank() {
		return wvw_rank;
	}

	@Override
	public String toString(){
		String result="ID: "+id+" Age: "+age+" Name: "+name+"\n"+" World ID: "+world+"\n";
		if (guilds!=null){
			result+="Guilds ID: ";
			for (String guild : guilds) result += guild + "\n";
		}
		if (guild_leader!=null){
			result+="Guilds ID (leader of): ";
			for (String leader : guild_leader) result += leader + "\n";
		}
		result+="Created: "+getCreated()+" Access: "+access+"\n";
		result+="Fractal Level: "+fractal_level+" Daily AP: "+daily_ap+" Monthly AP: "+monthly_ap+" WvW rank: "+wvw_rank+"\n";
		return result;
	}
}
