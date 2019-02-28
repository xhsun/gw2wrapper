package me.xhsun.guildwars2wrapper.requests.v2.guild.id;

import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.guild.GuildLog;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Log extends Request {
	protected Log(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on guild log API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions<br/>
	 *
	 * @param id       guild id
	 * @param api      Guild leader's Guild Wars 2 API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see GuildLog guild log info
	 */
	public void getGuildLogInfo(String id, String api, Callback<List<GuildLog>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		gw2API.getGuildLogInfo(id, api).enqueue(callback);
	}

	/**
	 * For more info on guild log API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions<br/>
	 *
	 * @param id       guild id
	 * @param api      Guild leader's Guild Wars 2 API key
	 * @param since    log id used to filter log entries
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see GuildLog guild log info
	 */
	public void getFilteredGuildLogInfo(String id, String api, int since, Callback<List<GuildLog>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		gw2API.getFilteredGuildLogInfo(id, api, Integer.toString(since)).enqueue(callback);
	}

	//SYNC
}
