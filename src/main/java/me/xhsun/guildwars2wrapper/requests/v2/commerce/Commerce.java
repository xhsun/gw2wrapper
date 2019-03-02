package me.xhsun.guildwars2wrapper.requests.v2.commerce;

import me.xhsun.guildwars2wrapper.error.ErrorCode;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.commerce.Exchange;
import me.xhsun.guildwars2wrapper.model.v2.commerce.Listing;
import me.xhsun.guildwars2wrapper.model.v2.commerce.Transaction;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Commerce extends Request {
	protected Commerce(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of item id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Listing listing item price info
	 */
	public void getTPListingInfo(int[] ids, Callback<List<Listing>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getTPListingInfo(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getAllPriceID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllTPPriceIDs().enqueue(callback);
	}

	/**
	 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of item id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see me.xhsun.guildwars2wrapper.model.v2.commerce.Prices listing item price info
	 */
	public void getPriceInfo(int[] ids, Callback<List<me.xhsun.guildwars2wrapper.model.v2.commerce.Prices>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getTPPriceInfo(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on transactions API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/transactions">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param time     current | History
	 * @param type     buy | sell
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Transaction transaction info
	 */
	public void getTPTransaction(String API, Transaction.Time time, Transaction.Type type, Callback<List<Transaction>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		if (time == null || type == null)
			throw new GuildWars2Exception(ErrorCode.TransTime, "Transaction time/type cannot be empty");
		gw2API.getTPTransaction(time.getValue(), type.getValue(), API).enqueue(callback);
	}

	/**
	 * For more info on delivery API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/delivery">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see me.xhsun.guildwars2wrapper.model.v2.commerce.Delivery devlivery info
	 */
	public void getTPDeliveryInfo(String API, Callback<me.xhsun.guildwars2wrapper.model.v2.commerce.Delivery> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getTPDeliveryInfo(API).enqueue(callback);
	}

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
