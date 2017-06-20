package me.xhsun.guildwars2wrapper.model;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableStr;

/**
 * For more info on files API go <a href="https://wiki.guildwars2.com/wiki/API:2/files">here</a><br/>
 * Model class for asset file
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class Asset extends IdentifiableStr {
	private String icon;

	public String getIcon() {
		return icon;
	}

	@Override
	public String toString() {
		return "Asset{" +
				"id=" + getId() +
				", icon='" + icon + '\'' +
				'}';
	}
}
