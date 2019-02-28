package me.xhsun.guildwars2wrapper.requests.v2.pvp;

import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.pvp.PvPHero;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Heroes extends Request {
	protected Heroes(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on pvp heroes API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see PvPHero pvp hero info
	 */
	public void getAllPvPHeroID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllPvPHeroIDs().enqueue(callback);
	}

	/**
	 * For more info on pvp heroes API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of pvp hero id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see PvPHero pvp hero info
	 */
	public void getPvPHeroInfo(String[] ids, Callback<List<PvPHero>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getPvPHeroInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	//SYNC
}
