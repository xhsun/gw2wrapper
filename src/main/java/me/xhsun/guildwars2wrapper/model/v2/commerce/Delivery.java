package me.xhsun.guildwars2wrapper.model.v2.commerce;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

import java.util.List;

/**
 * For more info on delivery API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/delivery">here</a><br/>
 * TP delivery info model class<br/>
 *
 * @author xhsun
 * @since 2017-02-19
 */

public class Delivery {
	private long coins;
	private List<Item> items;

	public long getCoins() {
		return coins;
	}

	public List<Item> getItems() {
		return items;
	}

	public class Item extends IdentifiableInt {
		private int count;

		public int getCount() {
			return count;
		}
	}
}
