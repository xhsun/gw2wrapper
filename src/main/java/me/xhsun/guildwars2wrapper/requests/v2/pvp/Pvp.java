package me.xhsun.guildwars2wrapper.requests.v2.pvp;

import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.World;
import me.xhsun.guildwars2wrapper.model.v2.pvp.*;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Pvp extends Request {
	protected Pvp(GuildWars2API gw2API) {
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

	/**
	 * For more info on pvp games API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param api      Guild Wars 2 API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @throws GuildWars2Exception  invalid API key
	 * @see PvPGame pvp game info
	 */
	public void getAllPvPGameID(String api, Callback<List<String>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, api));
		gw2API.getAllPvPGameIDs(api).enqueue(callback);
	}

	/**
	 * For more info on pvp games API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param api      Guild Wars 2 API key
	 * @param ids      list of pvp game id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see PvPGame pvp game info
	 */
	public void getPvPGameInfo(String api, String[] ids, Callback<List<PvPGame>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, api), new ParamChecker(ids));
		gw2API.getPvPGameInfo(api, processIds(ids)).enqueue(callback);
	}

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

	/**
	 * For more info on pvp ranks API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see PvPRank PvP rank info
	 */
	public void getAllPvPRankID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllPvPRankIDs().enqueue(callback);
	}

	/**
	 * For more info on pvp ranks API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of PvP rank id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see PvPRank PvP rank info
	 */
	public void getPvPRankInfo(int[] ids, Callback<List<PvPRank>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getPvPRankInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	/**
	 * For more info on pvp season API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see PvPSeason pvp season info
	 */
	public void getAllPvPSeasonID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllPvPSeasonIDs().enqueue(callback);
	}

	/**
	 * For more info on pvp season API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of pvp season id(s)
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see PvPSeason pvp season info
	 */
	public void getPvPSeasonInfo(String[] ids, Callback<List<PvPSeason>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getPvPSeasonInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

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

	/**
	 * For more info on pvp stat API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/stats">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param api      Guild Wars 2 API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @throws GuildWars2Exception  invalid api key
	 * @see PvPStat pvp stat info
	 */
	public void getPvPStatInfo(String api, Callback<PvPStat> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, api));
		gw2API.getPvPStatInfo(api).enqueue(callback);
	}

	/**
	 * For more info on pvp season API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param id       Season id
	 * @param type     ladder/legendary/guild
	 * @param region   na/eu
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see PvPLeaderBoard pvp season info
	 */
	public void getPvPSeasonLeaderBoardInfo(String id, String type, World.Region region, Callback<List<PvPLeaderBoard>> callback) throws NullPointerException {
		gw2API.getPvPSeasonLeaderBoardInfo(id, type, region.name().toLowerCase()).enqueue(callback);
	}

	//SYNC
}
