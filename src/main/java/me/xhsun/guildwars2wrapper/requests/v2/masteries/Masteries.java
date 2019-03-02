package me.xhsun.guildwars2wrapper.requests.v2.masteries;

import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.Mastery;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Masteries extends Request {
	protected Masteries(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * or more info on masteries API go <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Mastery mastery info
	 */
	public void getAllMasteryID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllMasteryIDs().enqueue(callback);
	}

	/**
	 * or more info on masteries API go <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of mastery id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Mastery mastery info
	 */
	public void getMasteryInfo(int[] ids, Callback<List<Mastery>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getMasteryInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	//SYNC
}
