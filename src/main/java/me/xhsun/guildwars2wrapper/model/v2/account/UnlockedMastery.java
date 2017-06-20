package me.xhsun.guildwars2wrapper.model.v2.account;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

/**
 * For more info on Account masteries API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/masteries">here</a><br/>
 * Model class of account masteries
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class UnlockedMastery extends IdentifiableInt {
	private int level;

	/**
	 * @return level at which the mastery is on the account | 0 if not started
	 */
	public int getLevel() {
		return level;
	}
}
