package me.xhsun.guildwars2wrapper.requests.v2.emblem;

import java.util.List;
import me.xhsun.guildwars2wrapper.error.ErrorCode;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Emblem extends Request {

	protected Emblem(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on emblem API go <a href="https://wiki.guildwars2.com/wiki/API:2/emblem">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see me.xhsun.guildwars2wrapper.model.v2.Emblem Emblem info
	 */
	public void getAllEmblemType(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllEmblemType().enqueue(callback);
	}

	/**
	 * For more info on emblem API go <a href="https://wiki.guildwars2.com/wiki/API:2/emblem">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param type     foregrounds/backgrounds
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see me.xhsun.guildwars2wrapper.model.v2.Emblem Emblem info
	 */
	public void getAllEmblemIDs(me.xhsun.guildwars2wrapper.model.v2.Emblem.Type type, Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllEmblemIDs(type.name()).enqueue(callback);
	}

	/**
	 * For more info on emblem API go <a href="https://wiki.guildwars2.com/wiki/API:2/emblem">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param type     foregrounds/backgrounds
	 * @param ids      list of emblem id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list | exceeds ID list limit (ie, ids.length>200)
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see me.xhsun.guildwars2wrapper.model.v2.Emblem Emblem info
	 */
	public void getAllEmblemInfo(me.xhsun.guildwars2wrapper.model.v2.Emblem.Type type, int[] ids, Callback<List<me.xhsun.guildwars2wrapper.model.v2.Emblem>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		if (ids.length > 200)
			throw new GuildWars2Exception(ErrorCode.ID, "id list too long; this endpoint is limited to 200 ids at once");
		gw2API.getAllEmblemInfo(type.name(), processIds(ids)).enqueue(callback);
	}

	//SYNC
}
