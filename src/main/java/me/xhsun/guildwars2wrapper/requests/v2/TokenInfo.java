package me.xhsun.guildwars2wrapper.requests.v2;

import java.io.IOException;
import me.xhsun.guildwars2wrapper.error.ErrorCode;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TokenInfo extends Request {

	protected TokenInfo(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on TokenInfo API go <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is null
	 * @see me.xhsun.guildwars2wrapper.model.v2.TokenInfo API info
	 */
	public void getAPIInfo(String API, Callback<me.xhsun.guildwars2wrapper.model.v2.TokenInfo> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getAPIInfo(API).enqueue(callback);
	}

	//SYNC
	/**
	 * For more info on TokenInfo API go <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">here</a><br/>
	 * Get detailed info related to this API key from server
	 *
	 * @param API API key
	 * @return API info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see me.xhsun.guildwars2wrapper.model.v2.TokenInfo API info
	 */
	public me.xhsun.guildwars2wrapper.model.v2.TokenInfo getAPIInfo(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<me.xhsun.guildwars2wrapper.model.v2.TokenInfo> response = gw2API.getAPIInfo(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}
}
