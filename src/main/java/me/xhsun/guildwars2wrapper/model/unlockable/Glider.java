package me.xhsun.guildwars2wrapper.model.unlockable;

import me.xhsun.guildwars2wrapper.model.Color;

import java.util.Arrays;
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

	//TODO method that give striped description, ie, no html
	public String getDescription() {
		return description;
	}

	/**
	 * @return array of {@link Color} id(s)
	 */
	public List<Integer> getDefaultDyes() {
		return default_dyes;
	}

	@Override
	public String toString() {
		return "Glider{" +
				"id=" + getId() +
				", unlock_items=" + Arrays.toString(getUnlockItems()) +
				", order=" + getOrder() +
				", icon='" + getIcon() + '\'' +
				", name='" + getName() + '\'' +
				", description='" + description + '\'' +
				", default_dyes=" + default_dyes +
				'}';
	}
}
