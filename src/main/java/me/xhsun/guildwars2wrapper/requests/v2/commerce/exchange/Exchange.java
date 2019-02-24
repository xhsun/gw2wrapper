package me.xhsun.guildwars2wrapper.requests.v2.commerce.exchange;

import java.util.List;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Exchange extends Request {

	protected Exchange(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on exchange API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/exchange">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getAllExchangeCurrency(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllExchangeCurrency().enqueue(callback);
	}

	//SYNC
}
