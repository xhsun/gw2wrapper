package me.xhsun.guildwars2wrapper.requests.v2.nodes;

import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Nodes extends Request {
	protected Nodes(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on nodes API go <a href="https://wiki.guildwars2.com/wiki/API:2/nodes">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getAllHomeInstanceNodeID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllHomeInstanceNodeIDs().enqueue(callback);
	}

	//SYNC
}
