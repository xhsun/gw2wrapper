package me.xhsun.guildwars2wrapper.requests.v2.commerce.exchange;

import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.commerce.Exchange;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Coins extends Request {

	protected Coins(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on exchange coins API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/exchange/coins">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param currency exchange currency type
	 * @param quantity The amount to exchange
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid value
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see me.xhsun.guildwars2wrapper.model.v2.commerce.Exchange Exchange info
	 */
	public void getExchangeInfo(me.xhsun.guildwars2wrapper.model.v2.commerce.Exchange.Type currency, long quantity, Callback<Exchange> callback) throws GuildWars2Exception, NullPointerException {
		isValueValid(quantity);
		gw2API.getExchangeInfo(currency.name(), Long.toString(quantity)).enqueue(callback);
	}

	//SYNC
}
