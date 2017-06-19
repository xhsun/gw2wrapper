package me.xhsun.guildwars2wrapper.model.guild;

import me.xhsun.guildwars2wrapper.model.indentifiable.NameableStr;

/**
 * For more info on guild permissions API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/permissions">here</a><br/>
 * Model class for guild permissions
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class GuildPermission extends NameableStr {
	private String description;

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "GuildPermission{" +
				super.toString() +
				", description='" + description + '\'' +
				'}';
	}
}
