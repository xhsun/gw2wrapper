package me.xhsun.guildwars2wrapper.model.commerce;

import com.google.gson.annotations.Expose;
import me.xhsun.guildwars2wrapper.model.indentifiable.IdentifiableInt;

/**
 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
 * TP prices info model class<br/>
 * Note: the unit price is in coins
 *
 * @author xhsun
 * @see me.xhsun.guildwars2wrapper.model.Item Item id
 * @see Prices buy/sell price
 * @since 2017-02-07
 */

public class Prices extends IdentifiableInt {
	private boolean whitelisted;
	private Price buys;
	private Price sells;

	public int getItemId() {
		return getId();
	}

	public boolean isWhitelisted() {
		return whitelisted;
	}

	public Price getBuys() {
		return buys;
	}

	public Price getSells() {
		return sells;
	}

	@Override
	public String toString() {
		return "Prices{" +
				"id=" + getId() +
				", whitelisted=" + whitelisted +
				", buys=" + buys +
				", sells=" + sells +
				'}';
	}

	/**
	 * Price model for Prices class
	 *
	 * @author xhsun
	 * @since 2017-02-07
	 */
	public static class Price {
		@Expose
		private long unit_price;
		@Expose
		private long quantity;

		public long getUnitPrice() {
			return unit_price;
		}

		public long getQuantity() {
			return quantity;
		}

		@Override
		public String toString() {
			return "Price{" +
					"unit_price=" + unit_price +
					", quantity=" + quantity +
					'}';
		}
	}
}
