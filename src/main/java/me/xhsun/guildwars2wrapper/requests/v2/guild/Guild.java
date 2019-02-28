package me.xhsun.guildwars2wrapper.requests.v2.guild;

import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Guild extends Request {
	protected Guild(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC

	/**
	 * For more info on guild API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param id       guild id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see me.xhsun.guildwars2wrapper.model.v2.guild.Guild guild info
	 */
	public void getGeneralGuildInfo(String id, Callback<me.xhsun.guildwars2wrapper.model.v2.guild.Guild> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.GUILD, id));
		gw2API.getGeneralGuildInfo(id).enqueue(callback);
	}

	/**
	 * For more info on guild API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions<br/>
	 * Note: if the given account is not a member, sometime endpoint will return general guild info instead of detailed info
	 *
	 * @param id       guild id
	 * @param api      Guild Wars 2 API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see me.xhsun.guildwars2wrapper.model.v2.guild.Guild guild info
	 */
	public void getDetailedGuildInfo(String id, String api, Callback<me.xhsun.guildwars2wrapper.model.v2.guild.Guild> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		gw2API.getDetailedGuildInfo(id, api).enqueue(callback);
	}

	//SYNC
}
