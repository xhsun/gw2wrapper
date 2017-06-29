package me.xhsun.guildwars2wrapper.model.v1;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableStr;

/**
 * model class for objective name, world name, and map name
 *
 * @author xhsun
 * @since 2017-06-28
 */
public class SimpleName extends NameableStr {

	/**
	 * @return integer representation of the id, -1 if id isn't a simple integer
	 */
	public int idToInt() {
		if (getId().matches("[0-9]+")) return Integer.parseInt(getId());
		else return -1;
	}
}
