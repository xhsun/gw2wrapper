package xhsun.gw2api.guildwars2.model.commerce;

import com.google.gson.annotations.Expose;
import xhsun.gw2api.guildwars2.model.Item;

/**
 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
 * TP prices info model class<br/>
 * Note: the unit price is in coins
 * @see Item Item id
 * @see Prices buy/sell price
 * @author xhsun
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
	public String toString(){
		return "{Item ID: "+id+" White List: "+whitelisted+" Buys: "+((buys==null)?"NULL":buys)+" Sells: "+((sells==null)?"NULL":sells)+"}";
	}

	/**
	 * Price model for Prices class
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
		public String toString(){
			return "{Unit Price: "+unit_price+" Quantity: "+quantity+"}";
		}
	}
}
