package me.xhsun.guildwars2wrapper.requests.v2.guild;

import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.guild.GuildPermission;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Permissions extends Request {
	protected Permissions(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
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

	//SYNC
}
