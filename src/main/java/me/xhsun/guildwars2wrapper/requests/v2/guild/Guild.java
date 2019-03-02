package me.xhsun.guildwars2wrapper.requests.v2.guild;

import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.guild.*;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

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

	/**
	 * For more info on guild permissions API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/permissions">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see GuildPermission guild permission info
	 */
	public void getAllGuildPermissionID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllGuildPermissionIDs().enqueue(callback);
	}

	/**
	 * For more info on guild permissions API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/permissions">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of guild permission id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see GuildPermission guild permission info
	 */
	public void getGuildPermissionInfo(String[] ids, Callback<List<GuildPermission>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getGuildPermissionInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	/**
	 * For more info on guild Search API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/search">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param name     guild name
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see GuildPermission guild permission info
	 */
	public void searchGuildID(String name, Callback<List<String>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.GUILD, name));
		gw2API.searchGuildID(name).enqueue(callback);
	}

	/**
	 * For more info on guild upgrades API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see GuildUpgrade guild upgrade info
	 */
	public void getGuildUpgradeID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllGuildUpgradeIDs().enqueue(callback);
	}

	/**
	 * For more info on guild upgrades API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of guild upgrade id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see GuildUpgrade guild upgrade info
	 */
	public void getGuildUpgradeInfo(int[] ids, Callback<List<GuildUpgrade>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getGuildUpgradeInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

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

	/**
	 * For more info on guild member API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/members">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions<br/>
	 *
	 * @param id       guild id
	 * @param api      Guild leader's Guild Wars 2 API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see GuildMember guild member info
	 */
	public void getGuildMemberInfo(String id, String api, Callback<List<GuildMember>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		gw2API.getGuildMemberInfo(id, api).enqueue(callback);
	}

	/**
	 * For more info on guild teams API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/teams">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions<br/>
	 *
	 * @param id       guild id
	 * @param api      Guild leader's Guild Wars 2 API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see GuildTeam guild team info
	 */
	public void getGuildTeamsInfo(String id, String api, Callback<List<GuildTeam>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		gw2API.getGuildTeamsInfo(id, api).enqueue(callback);
	}

	/**
	 * For more info on guild treasury API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/treasury">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions<br/>
	 *
	 * @param id       guild id
	 * @param api      Guild leader's Guild Wars 2 API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see GuildTreasury guild treasury info
	 */
	public void getGuildTreasuryInfo(String id, String api, Callback<List<GuildTreasury>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		gw2API.getGuildTreasuryInfo(id, api).enqueue(callback);
	}

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
