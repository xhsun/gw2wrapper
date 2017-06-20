package me.xhsun.guildwars2wrapper.model.commerce;

/**
 * For more info on exchange coins API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/exchange/coins">here</a><br/>
 * TP Exchange info model class<br/>
 *
 * @author xhsun
 * @since 2017-06-19
 */

public class Exchange {
	public enum Type {coins, gems}

	private long coins_per_gem, quantity;

	public long getCoins_per_gem() {
		return coins_per_gem;
	}

	public long getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Exchange{" +
				"coins_per_gem=" + coins_per_gem +
				", quantity=" + quantity +
				'}';
	}
}
