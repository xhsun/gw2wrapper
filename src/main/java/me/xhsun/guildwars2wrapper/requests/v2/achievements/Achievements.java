package me.xhsun.guildwars2wrapper.requests.v2.achievements;

import java.util.List;
import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.achievement.Achievement;
import me.xhsun.guildwars2wrapper.model.v2.achievement.AchievementCategory;
import me.xhsun.guildwars2wrapper.model.v2.achievement.AchievementGroup;
import me.xhsun.guildwars2wrapper.model.v2.achievement.DailyAchievement;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Achievements extends Request {

	protected Achievements(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on achievement API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Achievement achievement info
	 */
	public void getAllAchievementID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllAchievementIDs().enqueue(callback);
	}

	/**
	 * For more info on achievement API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of achievement id(s)
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Achievement achievement info
	 */
	public void getAchievementInfo(int[] ids, Callback<List<Achievement>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getAchievementInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	/**
	 * For more info on achievement categories API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see AchievementCategory achievement category info
	 */
	public void getAllAchievementCategoryIDs(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllAchievementCategoryIDs().enqueue(callback);
	}

	/**
	 * For more info on achievements categories API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of achievement category id(s)
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see AchievementCategory achievement category info
	 */
	public void getAchievementCategoryInfo(int[] ids, Callback<List<AchievementCategory>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getAchievementCategoryInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	/**
	 * For more info on achievements daily API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/daily">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see DailyAchievement daily achievement info
	 */
	public void getCurrentDailyAchievements(Callback<DailyAchievement> callback) throws NullPointerException {
		gw2API.getCurrentDailyAchievements().enqueue(callback);
	}

	/**
	 * For more info on next achievements daily API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/daily/tomorrow">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see DailyAchievement daily achievement info
	 */
	public void getNextDailyAchievements(Callback<DailyAchievement> callback) throws GuildWars2Exception, NullPointerException {
		gw2API.getNextDailyAchievements().enqueue(callback);
	}

	/**
	 * For more info on achievements groups API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see AchievementGroup achievement group info
	 */
	public void getAllAchievementGroupID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllAchievementGroupIDs().enqueue(callback);
	}

	/**
	 * For more info on achievements groups API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of achievement group id(s)
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see AchievementGroup achievement group info
	 */
	public void getAchievementGroupInfo(String[] ids, Callback<List<AchievementGroup>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getAchievementGroupInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	//SYNC
}
