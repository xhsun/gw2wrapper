package me.xhsun.guildwars2wrapper.requests.v2.pvp;

import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.pvp.PvPAmulet;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Amulets extends Request {
	protected Amulets(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on pvp amulets API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see PvPAmulet amulet info
	 */
	public void getAllPvPAmuletID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllPvPAmuletIDs().enqueue(callback);
	}

	/**
	 * For more info on pvp amulets API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of amulet id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see PvPAmulet amulet info
	 */
	public void getPvPAmuletInfo(int[] ids, Callback<List<PvPAmulet>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getPvPAmuletInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	//SYNC
}
