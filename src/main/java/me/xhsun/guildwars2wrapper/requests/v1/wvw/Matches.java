package me.xhsun.guildwars2wrapper.requests.v1.wvw;

import java.io.IOException;
import java.util.List;
import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.ErrorCode;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v1.AllWvWMatchOverview;
import me.xhsun.guildwars2wrapper.model.v1.SimpleName;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Matches extends Request {

	protected Matches(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on WvW objective names API go <a href="https://wiki.guildwars2.com/wiki/API:1/wvw/objective_names">here</a><br/>
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is null
	 * @see SimpleName objective name
	 */
	public void getAllWvWObjectiveNames(Callback<List<SimpleName>> callback) throws NullPointerException {
		gw2API.getAllWvWObjectiveNames(GuildWars2.lang.getValue()).enqueue(callback);
	}

	//SYNC
	/**
	 * For more info on v1 wvw matches API go <a href="https://wiki.guildwars2.com/wiki/API:1/wvw/matches">here</a><br/>
	 *
	 * @return simple wvw matches info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see AllWvWMatchOverview wvw matches
	 */
	public AllWvWMatchOverview getAllWvWMatchOverview() throws GuildWars2Exception {
		try {
			Response<AllWvWMatchOverview> response = gw2API.getAllWvWMatchOverview().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}
}
