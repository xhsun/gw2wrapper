package me.xhsun.guildwars2wrapper.requests.v1;

import java.io.IOException;
import java.util.List;
import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.ErrorCode;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v1.SimpleName;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorldNames extends Request {

	protected WorldNames(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on world names API go <a href="https://wiki.guildwars2.com/wiki/API:1/world_names">here</a><br/>
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is null
	 * @see SimpleName world name
	 */
	public void getAllWorldNames(Callback<List<SimpleName>> callback) throws NullPointerException {
		gw2API.getAllWorldNames(GuildWars2.lang.getValue()).enqueue(callback);
	}

	//SYNC
	/**
	 * For more info on world name API go <a href="https://wiki.guildwars2.com/wiki/API:1/world_names">here</a><br/>
	 *
	 * @return list of names
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see SimpleName world name
	 */
	public List<SimpleName> getAllWorldNames() throws GuildWars2Exception {
		try {
			Response<List<SimpleName>> response = gw2API.getAllWorldNames(GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}
}
