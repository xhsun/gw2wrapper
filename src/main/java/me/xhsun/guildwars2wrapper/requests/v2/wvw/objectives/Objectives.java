package me.xhsun.guildwars2wrapper.requests.v2.wvw.objectives;

import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWObjective;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Objectives extends Request {
	protected Objectives(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on WvW objectives API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWObjective WvW objective info
	 */
	public void getAllWvWObjectiveID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllWvWObjectiveIDs().enqueue(callback);
	}

	/**
	 * For more info on WvW objectives API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of WvW objective id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWObjective WvW objective info
	 */
	public void getWvWObjectiveInfo(String[] ids, Callback<List<WvWObjective>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getWvWObjectiveInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	//SYNC
}
