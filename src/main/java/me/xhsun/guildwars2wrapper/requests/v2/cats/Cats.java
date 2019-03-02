package me.xhsun.guildwars2wrapper.requests.v2.cats;

import java.util.List;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.Cat;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cats extends Request {

	protected Cats(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on cats API go <a href="https://wiki.guildwars2.com/wiki/API:2/cats">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Cat cat info
	 */
	public void getAllCatID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllCatIDs().enqueue(callback);
	}

	/**
	 * For more info on cats API go <a href="https://wiki.guildwars2.com/wiki/API:2/cats">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of cat id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Cat cat info
	 */
	public void getCatInfo(int[] ids, Callback<List<Cat>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getCatInfo(processIds(ids)).enqueue(callback);
	}

	//SYNC
}
