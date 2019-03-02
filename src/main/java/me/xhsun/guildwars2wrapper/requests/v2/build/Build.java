package me.xhsun.guildwars2wrapper.requests.v2.build;

import me.xhsun.guildwars2wrapper.model.v2.GameBuild;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Build extends Request {

	protected Build(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on build API go <a href="https://wiki.guildwars2.com/wiki/API:2/build">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see GameBuild game build info
	 */
	public void getCurrentGameBuild(Callback<GameBuild> callback) throws NullPointerException {
		gw2API.getCurrentGameBuild().enqueue(callback);
	}

	//SYNC
}
