package me.xhsun.guildwars2wrapper.model.v2.guild;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableStr;

import java.util.List;

/**
 * For more info on guild ranks API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/ranks">here</a><br/>
 * Model class for guild ranks
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class GuildRank extends IdentifiableStr {
	private int order;
	private String icon;
	private List<String> permissions;

	public int getOrder() {
		return order;
	}

	public String getIcon() {
		return icon;
	}

	public List<String> getPermissions() {
		return permissions;
	}
}
