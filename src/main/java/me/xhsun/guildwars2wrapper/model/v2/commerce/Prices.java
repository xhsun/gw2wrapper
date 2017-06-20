package me.xhsun.guildwars2wrapper.model.v2.commerce;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;
import me.xhsun.guildwars2wrapper.model.v2.Item;

/**
 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
 * TP prices info model class<br/>
 * Note: the unit price is in coins
 *
 * @author xhsun
 * @see Item Item id
 * @see Prices buy/sell price
 * @since 2017-02-07
 */

public class Prices extends IdentifiableInt {
	private boolean whitelisted;
	private Price buys, sells;

	public boolean isWhitelisted() {
		return whitelisted;
	}

	public Price getBuys() {
		return buys;
	}

	public Price getSells() {
		return sells;
	}

	/**
	 * Price model for Prices class
	 *
	 * @author xhsun
	 * @since 2017-02-07
	 */
	public class Price {
		private long listings, unit_price, quantity;

		public long getListings() {
			return listings;
		}

		public long getUnitPrice() {
			return unit_price;
		}

		public long getQuantity() {
			return quantity;
		}
	}
}
