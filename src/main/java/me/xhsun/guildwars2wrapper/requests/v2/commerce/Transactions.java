package me.xhsun.guildwars2wrapper.requests.v2.commerce;

import java.util.List;
import me.xhsun.guildwars2wrapper.error.ErrorCode;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.commerce.Transaction;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Transactions extends Request {

	protected Transactions(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
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

	//SYNC
}
