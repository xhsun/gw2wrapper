package me.xhsun.guildwars2wrapper.requests.v2.pvp;

import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.pvp.PvPLeaderBoard;
import me.xhsun.guildwars2wrapper.model.v2.pvp.PvPStanding;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Standings extends Request {
	protected Standings(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on pvp season API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/standings">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param api      Guild Wars 2 API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @throws GuildWars2Exception  invalid api key
	 * @see PvPLeaderBoard pvp season info
	 */
	public void getPvPStandingInfo(String api, Callback<List<PvPStanding>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, api));
		gw2API.getPvPStandingInfo(api).enqueue(callback);
	}

	//SYNC
}
