package me.xhsun.guildwars2wrapper.requests.v2.quaggans;

import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
import java.util.Map;

public class Quaggans extends Request {
	protected Quaggans(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on quaggans API go <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getAllQuagganID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllQuagganIDs().enqueue(callback);
	}

	/**
	 * For more info on quaggans API go <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of quaggan id(s)
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getQuagganInfo(String[] ids, Callback<List<Map<String, String>>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getQuagganInfo(processIds(ids)).enqueue(callback);
	}

	//SYNC
}
