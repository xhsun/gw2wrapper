package me.xhsun.guildwars2wrapper.model.commerce;

import java.util.Map;

/**
 * For more info on delivery API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/delivery">here</a><br/>
 * TP delivery info model class<br/>
 * WARNING No testing yet, use with caution
 *
 * @author xhsun
 * @since 2017-02-19
 */

public class Delivery {
	private long coins;
	private Map<Integer, Integer> items;

	public long getCoins() {
		return coins;
	}

	/**
	 * @return Map of {@link me.xhsun.guildwars2wrapper.model.Item#id} and count
	 */
	public Map<Integer, Integer> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Delivery{" +
				"coins=" + coins +
				", items=" + items +
				'}';
	}
}
