package me.xhsun.guildwars2wrapper.model.v2.commerce;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

import java.util.List;

/**
 * For more info on Listing API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/listings">here</a><br/>
 * TP listings info model class<br/>
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class Listing extends IdentifiableInt {
	private List<Prices.Price> buys, sells;

	public List<Prices.Price> getBuys() {
		return buys;
	}

	public List<Prices.Price> getSells() {
		return sells;
	}
}
