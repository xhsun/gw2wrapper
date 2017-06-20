package me.xhsun.guildwars2wrapper.model.v2.account;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

/**
 * For more info on Account finishers API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/finishers">here</a><br/>
 * Model class for account finishers
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class UnlockedFinisher extends IdentifiableInt {
	private boolean permanent;
	private int quantity;

	public boolean isPermanent() {
		return permanent;
	}

	public int getQuantity() {
		return quantity;
	}
}
