package me.xhsun.guildwars2wrapper.model;

import java.util.Arrays;

/**
 * For more info on TokenInfo API go <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">here</a><br/>
 * Token info model class
 *
 * @author xhsun
 * @since 2017-02-07
 */

public class TokenInfo {
	private String id;
	private String name;
	private String[] permissions;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String[] getPermissions() {
		return permissions;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TokenInfo tokenInfo = (TokenInfo) o;

		return id != null ? id.equals(tokenInfo.id) : tokenInfo.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "TokenInfo{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", permissions=" + Arrays.toString(permissions) +
				'}';
	}
}
