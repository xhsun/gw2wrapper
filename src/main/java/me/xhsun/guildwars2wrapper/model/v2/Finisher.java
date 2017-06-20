package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.Unlockable;

/**
 * For more info on Finishers API go <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">here</a><br/>
 * Model class for finisher
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Finisher extends Unlockable {
	private String unlock_details;

	public String getUnlockDetails() {
		return unlock_details;
	}
}
