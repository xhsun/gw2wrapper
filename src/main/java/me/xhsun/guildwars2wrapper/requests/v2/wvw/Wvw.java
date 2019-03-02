package me.xhsun.guildwars2wrapper.requests.v2.wvw;

import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.World;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWAbility;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWObjective;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWRank;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWUpgrade;
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

public class Wvw extends Request {
	protected Wvw(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on WvW abilities API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWAbility WvW abilities info
	 */
	public void getAllWvWAbilityID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllWvWAbilityIDs().enqueue(callback);
	}

	/**
	 * For more info on WvW abilities API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of WvW abilities id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWAbility WvW abilities info
	 */
	public void getWvWAbilityInfo(int[] ids, Callback<List<WvWAbility>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getWvWAbilityInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

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

	/**
	 * For more info on WvW objectives API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWObjective WvW objective info
	 */
	public void getAllWvWObjectiveID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllWvWObjectiveIDs().enqueue(callback);
	}

	/**
	 * For more info on WvW objectives API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of WvW objective id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWObjective WvW objective info
	 */
	public void getWvWObjectiveInfo(String[] ids, Callback<List<WvWObjective>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getWvWObjectiveInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	/**
	 * For more info on WvW ranks API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWRank WvW rank info
	 */
	public void getAllWvWRankID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllWvWRankIDs().enqueue(callback);
	}

	/**
	 * For more info on WvW ranks API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of WvW rank id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWRank WvW rank info
	 */
	public void getWvWRankInfo(int[] ids, Callback<List<WvWRank>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getWvWRankInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	/**
	 * For more info on WvW upgrades API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWUpgrade WvW upgrade info
	 */
	public void getAllWvWUpgradeID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllWvWUpgradeIDs().enqueue(callback);
	}

	/**
	 * For more info on WvW upgrades API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of WvW upgrade id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see WvWUpgrade WvW upgrade info
	 */
	public void getWvWUpgradeInfo(int[] ids, Callback<List<WvWUpgrade>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getWvWUpgradeInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	//ASYNC
}
