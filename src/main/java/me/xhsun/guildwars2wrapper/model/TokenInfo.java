package me.xhsun.guildwars2wrapper.model;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableStr;

import java.util.List;

/**
 * For more info on TokenInfo API go <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">here</a><br/>
 * Token info model class
 *
 * @author xhsun
 * @since 2017-02-07
 */

public class TokenInfo extends IdentifiableStr {
	private String name;
	private List<String> permissions;

	public String getName() {
		return name;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	@Override
	public String toString() {
		return "TokenInfo{" +
				"id='" + getId() + '\'' +
				", name='" + name + '\'' +
				", permissions=" + permissions +
				'}';
	}
}
