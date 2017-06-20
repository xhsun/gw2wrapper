package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;

/**
 * For more info on Mini API go <a href="https://wiki.guildwars2.com/wiki/API:2/minis">here</a><br/>
 * Model class for minis
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class Mini extends NameableInt {
	private String unlock;
	private String icon;
	private int order;
	private int item_id;

	/**
	 * @return A description of how to unlock the mini (only present on a few entries).
	 */
	public String getUnlock() {
		return unlock;
	}

	public String getIcon() {
		return icon;
	}

	public int getOrder() {
		return order;
	}

	public int getItemId() {
		return item_id;
	}
}
