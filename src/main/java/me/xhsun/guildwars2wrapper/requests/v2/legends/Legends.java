package me.xhsun.guildwars2wrapper.requests.v2.legends;

import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.Legend;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Legends extends Request {
	protected Legends(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on legends API go <a href="https://wiki.guildwars2.com/wiki/API:2/legends">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Legend legend info
	 */
	public void getAllLegendID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllLegendIDs().enqueue(callback);
	}

	/**
	 * For more info on legends API go <a href="https://wiki.guildwars2.com/wiki/API:2/legends">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of legend id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Legend legend info
	 */
	public void getLegendInfo(String[] ids, Callback<List<Legend>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getLegendInfo(processIds(ids)).enqueue(callback);
	}

	//SYNC
}
