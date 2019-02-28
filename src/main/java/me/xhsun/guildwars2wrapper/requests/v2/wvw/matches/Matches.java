package me.xhsun.guildwars2wrapper.requests.v2.wvw.matches;

import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.World;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWAbility;
import me.xhsun.guildwars2wrapper.model.v2.wvw.matches.WvWMatchDetail;
import me.xhsun.guildwars2wrapper.model.v2.wvw.matches.WvWMatchOverview;
import me.xhsun.guildwars2wrapper.model.v2.wvw.matches.WvWMatchScore;
import me.xhsun.guildwars2wrapper.model.v2.wvw.matches.WvWMatchStat;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Matches extends Request {
	protected Matches(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWAbility WvW match info
	 */
	public void getAllWvWMatchID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllWvWMatchIDs().enqueue(callback);
	}

	/**
	 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param worldID  {@link World#id}
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWMatchDetail WvW match detailed info
	 */
	public void getWvWMatchDetail(int worldID, Callback<WvWMatchDetail> callback) throws NullPointerException {
		gw2API.getWvWMatchInfoUsingWorld(Integer.toString(worldID)).enqueue(callback);
	}

	/**
	 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of wvw match id(s)
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @throws GuildWars2Exception  empty ID list
	 * @see WvWMatchDetail WvW match detailed info
	 */
	public void getWvWMatchDetail(String[] ids, Callback<List<WvWMatchDetail>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getWvWMatchInfoUsingID(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param worldID  {@link World#id}
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWMatchOverview WvW match overview info
	 */
	public void getWvWMatchOverview(int worldID, Callback<WvWMatchOverview> callback) throws NullPointerException {
		gw2API.getWvWMatchOverviewUsingWorld(Integer.toString(worldID)).enqueue(callback);
	}

	/**
	 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of wvw match id(s)
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @throws GuildWars2Exception  empty ID list
	 * @see WvWMatchOverview WvW match overview info
	 */
	public void getWvWMatchOverview(String[] ids, Callback<List<WvWMatchOverview>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getWvWMatchOverviewUsingID(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param worldID  {@link World#id}
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWMatchScore WvW match score info
	 */
	public void getWvWMatchScore(int worldID, Callback<WvWMatchScore> callback) throws NullPointerException {
		gw2API.getWvWMatchScoreUsingWorld(Integer.toString(worldID)).enqueue(callback);
	}

	/**
	 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of wvw match id(s)
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @throws GuildWars2Exception  empty ID list
	 * @see WvWMatchScore WvW match score info
	 */
	public void getWvWMatchScore(String[] ids, Callback<List<WvWMatchScore>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getWvWMatchScoreUsingID(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param worldID  {@link World#id}
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWMatchStat WvW match stat info
	 */
	public void getWvWMatchStat(int worldID, Callback<WvWMatchStat> callback) throws NullPointerException {
		gw2API.getWvWMatchStatUsingWorld(Integer.toString(worldID)).enqueue(callback);
	}

	/**
	 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of wvw match id(s)
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @throws GuildWars2Exception  empty ID list
	 * @see WvWMatchStat WvW match stat info
	 */
	public void getWvWMatchStat(String[] ids, Callback<List<WvWMatchStat>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getWvWMatchStatUsingID(processIds(ids)).enqueue(callback);
	}

	//SYNC
}
