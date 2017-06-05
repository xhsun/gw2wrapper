package me.xhsun.guildwars2wrapper.model.commerce;

import com.google.gson.annotations.Expose;

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

public class Prices {
	private long id;
	private boolean whitelisted;
	private Price buys;
	private Price sells;

	public long getId() {
		return id;
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Prices prices = (Prices) o;

		return id == prices.id && whitelisted == prices.whitelisted;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (whitelisted ? 1 : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Prices{" +
				"id=" + id +
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

		public long getUnit_price() {
			return unit_price;
		}

		public long getQuantity() {
			return quantity;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Price price = (Price) o;

			return unit_price == price.unit_price && quantity == price.quantity;
		}

		@Override
		public int hashCode() {
			int result = (int) (unit_price ^ (unit_price >>> 32));
			result = 31 * result + (int) (quantity ^ (quantity >>> 32));
			return result;
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
