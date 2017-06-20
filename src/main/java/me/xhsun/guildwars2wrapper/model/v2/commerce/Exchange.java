package me.xhsun.guildwars2wrapper.model.v2.commerce;

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

	public long getCoinsPerGem() {
		return coins_per_gem;
	}

	public long getQuantity() {
		return quantity;
	}

}
