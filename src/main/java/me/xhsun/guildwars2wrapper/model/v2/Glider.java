package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.Unlockable;

import java.util.List;

/**
 * For more info on gliders API go <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">here</a><br/>
 * Model class for glider
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Glider extends Unlockable {
	private String description;
	private List<Integer> default_dyes;//color id

	public String getDescription() {
		return description;
	}

	/**
	 * @return array of {@link Color} id(s)
	 */
	public List<Integer> getDefaultDyes() {
		return default_dyes;
	}
}
