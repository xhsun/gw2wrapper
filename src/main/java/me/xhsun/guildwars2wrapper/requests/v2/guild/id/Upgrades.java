package me.xhsun.guildwars2wrapper.requests.v2.guild.id;

import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Upgrades extends Request {
	protected Upgrades(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on guild unlocked upgrades API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/upgrades">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions<br/>
	 *
	 * @param id       guild id
	 * @param api      Guild leader's Guild Wars 2 API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getGuildUnlockedUpgradesID(String id, String api, Callback<List<Integer>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		gw2API.getGuildUpgradeIDs(id, api).enqueue(callback);
	}

	//SYNC
}
