package me.xhsun.guildwars2wrapper.model.unlockable;

import java.util.Arrays;

/**
 * For more info on Outfits API go <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">here</a><br/>
 * Model class for outfit
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Outfit extends Unlockable {

	@Override
	public String toString() {
		return "Outfit{" +
				"id=" + getId() +
				", unlock_items=" + Arrays.toString(getUnlockItems()) +
				", icon='" + getIcon() + '\'' +
				", name='" + getName() + '\'' +
				'}';
	}
}
