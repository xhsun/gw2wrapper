package me.xhsun.guildwars2wrapper;

import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.*;
import me.xhsun.guildwars2wrapper.model.account.*;
import me.xhsun.guildwars2wrapper.model.achievements.Achievement;
import me.xhsun.guildwars2wrapper.model.achievements.AchievementCategory;
import me.xhsun.guildwars2wrapper.model.achievements.AchievementGroup;
import me.xhsun.guildwars2wrapper.model.achievements.DailyAchievement;
import me.xhsun.guildwars2wrapper.model.backstory.BackStoryAnswer;
import me.xhsun.guildwars2wrapper.model.backstory.BackStoryQuestion;
import me.xhsun.guildwars2wrapper.model.character.Character;
import me.xhsun.guildwars2wrapper.model.character.*;
import me.xhsun.guildwars2wrapper.model.commerce.Exchange;
import me.xhsun.guildwars2wrapper.model.commerce.Prices;
import me.xhsun.guildwars2wrapper.model.commerce.Transaction;
import me.xhsun.guildwars2wrapper.model.continent.Continent;
import me.xhsun.guildwars2wrapper.model.continent.ContinentFloor;
import me.xhsun.guildwars2wrapper.model.continent.ContinentMap;
import me.xhsun.guildwars2wrapper.model.continent.ContinentRegion;
import me.xhsun.guildwars2wrapper.model.guild.Upgrade;
import me.xhsun.guildwars2wrapper.model.pvp.Amulet;
import me.xhsun.guildwars2wrapper.model.pvp.Hero;
import me.xhsun.guildwars2wrapper.model.unlockable.Finisher;
import me.xhsun.guildwars2wrapper.model.unlockable.Glider;
import me.xhsun.guildwars2wrapper.model.unlockable.MailCarrier;
import me.xhsun.guildwars2wrapper.model.unlockable.Outfit;
import me.xhsun.guildwars2wrapper.model.wvw.Ability;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

/**
 * This class contains all the method for accessing data asynchronously
 *
 * @author xhsun
 * @since 2017-06-04
 */

public class AsynchronousRequest extends Request {
	AsynchronousRequest(GuildWars2API gw2API) {
		super(gw2API);
	}

	//Token info

	/**
	 * For more info on TokenInfo API go <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is null
	 * @see TokenInfo API info
	 */
	public void getAPIInfo(String API, Callback<TokenInfo> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getAPIInfo(API).enqueue(callback);
	}

	//Accounts
	/**
	 * For more info on Account API go <a href="https://wiki.guildwars2.com/wiki/API:2/account">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Account Account info
	 */
	public void getAccount(String API, Callback<Account> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getAccount(API).enqueue(callback);
	}

	/**
	 * For more info on Account API go <a href="https://wiki.guildwars2.com/wiki/API:2/account">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see AchievementProgression Account achievement info
	 */
	public void getAchievementProgression(String API, Callback<List<AchievementProgression>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getAchievementProgression(API).enqueue(callback);
	}

	/**
	 * For more info on Bank API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/bank">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Bank Bank info
	 */
	public void getBank(String API, Callback<List<Bank>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getBank(API).enqueue(callback);
	}

	/**
	 * For more info on Dungeon progression API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/dungeons">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getDailyDungeonProgression(String API, Callback<List<String>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getDailyDungeonProgression(API).enqueue(callback);
	}

	/**
	 * For more info on Account dyes API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/dyes">here</a><br/>
	 * Get list of unlocked dyes ids linked to given API key
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Color color info
	 */
	public void getUnlockedDyes(String API, Callback<List<Integer>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getUnlockedDyes(API).enqueue(callback);
	}

	/**
	 * For more info on Account finishers API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/finishers">here</a><br/>
	 * Get list of unlocked finishers linked to given API key
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see UnlockedFinisher unlocked finisher info
	 */
	public void getUnlockedFinishers(String API, Callback<List<UnlockedFinisher>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getUnlockedFinishers(API).enqueue(callback);
	}

	/**
	 * For more info on Account gliders API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/gliders">here</a><br/>
	 * Get list of unlocked glider id(s) linked to given API key
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getUnlockedGliders(String API, Callback<List<Integer>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getUnlockedGliders(API).enqueue(callback);
	}

	/**
	 * For more info on Account cats API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/home/cats">here</a><br/>
	 * Get list of unlocked cats linked to given API key
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Cat cat info
	 */
	public void getUnlockedCats(String API, Callback<List<Cat>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getUnlockedCats(API).enqueue(callback);
	}

	/**
	 * For more info on Account nodes API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/home/nodes">here</a><br/>
	 * Get list of unlocked glider id(s) linked to given API key
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getUnlockedHomeNodes(String API, Callback<List<String>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getUnlockedHomeNodes(API).enqueue(callback);
	}

	/**
	 * For more info on Shared Inventory API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/inventory">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see SharedInventory shared inventory info
	 */
	public void getSharedInventory(String API, Callback<List<SharedInventory>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getSharedInventory(API).enqueue(callback);
	}

	/**
	 * For more info on account mail carrier API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/mailcarriers">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getUnlockedMailCarriers(String API, Callback<List<Integer>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getUnlockedMailCarriers(API).enqueue(callback);
	}

	/**
	 * For more info on account masteries API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/masteries">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see UnlockedMastery unlocked mastery info
	 */
	public void getUnlockedMasteries(String API, Callback<List<UnlockedMastery>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getUnlockedMasteries(API).enqueue(callback);
	}

	/**
	 * For more info on MaterialCategory Storage API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/materials">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Material material storage info
	 */
	public void getMaterialStorage(String API, Callback<List<Material>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getMaterialBank(API).enqueue(callback);
	}

	/**
	 * For more info on account minis API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/minis">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Mini mini info
	 */
	public void getUnlockedMinis(String API, Callback<List<Integer>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getUnlockedMinis(API).enqueue(callback);
	}

	/**
	 * For more info on account outfits API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/outfits">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getUnlockedOutfits(String API, Callback<List<Integer>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getUnlockedOutfits(API).enqueue(callback);
	}

	/**
	 * For more info on account pvp heroes API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/pvp/heroes">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getUnlockedPvpHeroes(String API, Callback<List<Integer>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getUnlockedPvpHeroes(API).enqueue(callback);
	}

	/**
	 * For more info on account raid API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/raids">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getWeeklyRaidProgression(String API, Callback<List<String>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getWeeklyRaidProgression(API).enqueue(callback);
	}

	/**
	 * For more info on account recipes API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/raids">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Recipe recipe info
	 */
	public void getUnlockedRecipes(String API, Callback<List<Integer>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getUnlockedRecipes(API).enqueue(callback);
	}

	/**
	 * For more info on Account/Skins API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/skins">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Skin skin info
	 */
	public void getUnlockedSkins(String API, Callback<List<Integer>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getUnlockedSkins(API).enqueue(callback);
	}

	/**
	 * For more info on Account titles API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/titles">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getUnlockedTitles(String API, Callback<List<Integer>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getUnlockedTitles(API).enqueue(callback);
	}

	/**
	 * For more info on Wallet API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/wallet">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Wallet wallet info
	 */
	public void getWallet(String API, Callback<List<Wallet>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getWallet(API).enqueue(callback);
	}

	//Achievements
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
		gw2API.getAchievementInfo(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on achievements categories API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">here</a><br/>
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
		gw2API.getAchievementCategoryInfo(processIds(ids)).enqueue(callback);
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
		gw2API.getAchievementGroupInfo(processIds(ids)).enqueue(callback);
	}

	//Back Story
	/**
	 * For more info on back story answer API go <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see BackStoryAnswer back story answer info
	 */
	public void getAllBackStoryAnswerID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllBackStoryAnswerIDs().enqueue(callback);
	}

	/**
	 * For more info on back story answer API go <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of back story answer id(s)
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see BackStoryAnswer back story answer info
	 */
	public void getBackStoryAnswerInfo(String[] ids, Callback<List<BackStoryAnswer>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getBackStoryAnswerInfo(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on back story questions API go <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see BackStoryQuestion back story question info
	 */
	public void getAllBackStoryQuestionID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllBackStoryQuestionIDs().enqueue(callback);
	}

	/**
	 * For more info on back story questions API go <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of back story question id(s)
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see BackStoryQuestion back story question info
	 */
	public void getBackStoryQuestionInfo(int[] ids, Callback<List<BackStoryQuestion>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getBackStoryQuestionInfo(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on build API go <a href="https://wiki.guildwars2.com/wiki/API:2/build">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see GameBuild game build info
	 */
	public void getCurrentGameBuild(Callback<GameBuild> callback) throws NullPointerException {
		gw2API.getCurrentGameBuild().enqueue(callback);
	}

	//Cats

	/**
	 * For more info on cats API go <a href="https://wiki.guildwars2.com/wiki/API:2/cats">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Cat cat info
	 */
	public void getAllCatID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllCatIDs().enqueue(callback);
	}

	/**
	 * For more info on cats API go <a href="https://wiki.guildwars2.com/wiki/API:2/cats">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of cat id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Cat cat info
	 */
	public void getCatInfo(int[] ids, Callback<List<Cat>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getCatInfo(processIds(ids)).enqueue(callback);
	}

	//Characters
	/**
	 * For more info on Character API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getAllCharacterName(String API, Callback<List<String>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getAllCharacterName(API).enqueue(callback);
	}

	/**
	 * For more info on character overview API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 * Get character information for the given character name that is linked to given API key
	 *
	 * @param API      API key
	 * @param name     name of character
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Character character info
	 */
	public void getCharacter(String API, String name, Callback<Character> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacter(name, API).enqueue(callback);
	}

	/**
	 * For more info on character back story API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Backstory">here</a><br/>
	 *
	 * @param API      API key
	 * @param name     name of character
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterBackStory back store answer info
	 */
	public void getCharacterBackStory(String API, String name, Callback<CharacterBackStory> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterBackStory(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character Core API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Core">here</a><br/>
	 * Get basic character information for the given character name that is linked to given API key
	 *
	 * @param API      API key
	 * @param name     name of character
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Core basic character info
	 */
	public void getCharacterInformation(String API, String name, Callback<Core> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterCore(name, API).enqueue(callback);
	}

	/**
	 * For more info on character crafting API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Crafting">here</a><br/>
	 *
	 * @param API      API key
	 * @param name     name of character
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CraftingLevel character crafting info
	 */
	public void getCharacterCrafting(String API, String name, Callback<CraftingLevel> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterCrafting(name, API).enqueue(callback);
	}

	/**
	 * For more info on character equipment API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Equipment">here</a><br/>
	 *
	 * @param API      API key
	 * @param name     name of character
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterEquipment equipment info
	 */
	public void getCharacterEquipment(String API, String name, Callback<CharacterEquipment> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterEquipment(name, API).enqueue(callback);
	}

	/**
	 * For more info on character hero points API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Heropoints">here</a><br/>
	 *
	 * @param API      API key
	 * @param name     name of character
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getCharacterHeroPoints(String API, String name, Callback<List<String>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterHeroPoints(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character Inventory API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Inventory">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param name     character name
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterInventory character inventory info
	 */
	public void getCharacterInventory(String API, String name, Callback<CharacterInventory> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterInventory(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character Recipes API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param name     character name
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Recipe recipe info
	 */
	public void getCharacterUnlockedRecipes(String API, String name, Callback<CharacterRecipes> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterUnlockedRecipes(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character SAB API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Super_Adventure_Box_.28sab.29">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param name     character name
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterSAB character SAB info
	 */
	public void getCharacterSAB(String API, String name, Callback<CharacterSAB> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterSAB(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character Skills API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Skills">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param name     character name
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterSkills character skills info
	 */
	public void getCharacterSkills(String API, String name, Callback<CharacterSkills> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterSkills(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character Specialization API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Specialization">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param name     character name
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterSpecialization character specialization info
	 */
	public void getCharacterSpecialization(String API, String name, Callback<CharacterSpecialization> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterSpecialization(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character Training API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Training">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param name     character name
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterTraining character training info
	 */
	public void getCharacterTraining(String API, String name, Callback<CharacterTraining> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterTraining(name, API).enqueue(callback);
	}

	//Colors
	/**
	 * For more info on Color API go <a href="https://wiki.guildwars2.com/wiki/API:2/colors">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Color color info
	 */
	public void getAllColorID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllColorIDs().enqueue(callback);
	}

	/**
	 * For more info on Color API go <a href="https://wiki.guildwars2.com/wiki/API:2/colors">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of color id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Color color info
	 */
	public void getColorInfo(int[] ids, Callback<List<Color>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getColorInfo(processIds(ids)).enqueue(callback);
	}

	//TP

	/**
	 * For more info on exchange API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/exchange">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getAllExchangeCurrency(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllExchangeCurrency().enqueue(callback);
	}

	/**
	 * For more info on exchange coins API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/exchange/coins">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param currency exchange currency type
	 * @param quantity The amount to exchange
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid value
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Exchange Exchange info
	 */
	public void getExchangeInfo(Exchange.Type currency, long quantity, Callback<Exchange> callback) throws GuildWars2Exception, NullPointerException {
		isValueValid(quantity);
		gw2API.getExchangeInfo(currency.name(), Long.toString(quantity)).enqueue(callback);
	}

	/**
	 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param time     current | History
	 * @param type     buy | sell
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Transaction transaction info
	 */
	public void getListing(String API, Transaction.Time time, Transaction.Type type, Callback<List<Transaction>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getTPTransaction(processListingTime(time), processListingType(type), API).enqueue(callback);
	}

	/**
	 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getAllPriceID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllTPPriceIDs().enqueue(callback);
	}

	/**
	 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of item id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Prices listing item price info
	 */
	public void getPriceInfo(int[] ids, Callback<List<Prices>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getTPPriceInfo(processIds(ids)).enqueue(callback);
	}

	//Continents
	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Continent continents info
	 */
	public void getAllContinentID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllContinentIDs().enqueue(callback);
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of continents id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Continent continents info
	 */
	public void getContinentInfo(int[] ids, Callback<List<Continent>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getContinentInfo(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID {@link Continent#id}
	 * @param callback    callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see ContinentFloor continents floor info
	 */
	public void getAllContinentFloorID(int continentID, Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllContinentFloorIDs(Integer.toString(continentID)).enqueue(callback);
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID {@link Continent#id}
	 * @param ids         list of floor id
	 * @param callback    callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see ContinentFloor continents floor info
	 */
	public void getContinentFloorInfo(int continentID, int[] ids, Callback<List<ContinentFloor>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getContinentFloorInfo(Integer.toString(continentID), processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param callback    callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see ContinentRegion continents region info
	 */
	public void getAllContinentRegionID(int continentID, int floorID, Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllContinentRegionIDs(Integer.toString(continentID), Integer.toString(floorID)).enqueue(callback);
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param ids         list of region id
	 * @param callback    callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see ContinentRegion continents region info
	 */
	public void getContinentRegionInfo(int continentID, int floorID, int[] ids, Callback<List<ContinentRegion>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getContinentRegionInfo(Integer.toString(continentID), Integer.toString(floorID), processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param callback    callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see ContinentMap continents map info
	 */
	public void getAllContinentMapID(int continentID, int floorID, int regionID, Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllContinentMapIDs(Integer.toString(continentID), Integer.toString(floorID), Integer.toString(regionID)).enqueue(callback);
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param ids         list of region map id
	 * @param callback    callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see ContinentMap continents map info
	 */
	public void getContinentMapInfo(int continentID, int floorID, int regionID, int[] ids, Callback<List<ContinentMap>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getContinentMapInfo(Integer.toString(continentID), Integer.toString(floorID), Integer.toString(regionID), processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param mapID       {@link ContinentMap#id}
	 * @param callback    callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see ContinentMap.Sector continents map sector info
	 */
	public void getAllContinentSectorID(int continentID, int floorID, int regionID, int mapID, Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllContinentSectorIDs(Integer.toString(continentID), Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID)).enqueue(callback);
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param mapID       {@link ContinentMap#id}
	 * @param ids         list of region map sector id
	 * @param callback    callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see ContinentMap.Sector continents map sector info
	 */
	public void getContinentSectorInfo(int continentID, int floorID, int regionID, int mapID, int[] ids, Callback<List<ContinentMap.Sector>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getContinentSectorInfo(Integer.toString(continentID), Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID), processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param mapID       {@link ContinentMap#id}
	 * @param callback    callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see ContinentMap.PoI continents map PoI info
	 */
	public void getAllContinentPOIID(int continentID, int floorID, int regionID, int mapID, Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllContinentPOIIDs(Integer.toString(continentID), Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID)).enqueue(callback);
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param mapID       {@link ContinentMap#id}
	 * @param ids         list of region map PoI id
	 * @param callback    callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see ContinentMap.PoI continents map PoI info
	 */
	public void getContinentPOIInfo(int continentID, int floorID, int regionID, int mapID, int[] ids, Callback<List<ContinentMap.PoI>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getContinentPOIInfo(Integer.toString(continentID), Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID), processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param mapID       {@link ContinentMap#id}
	 * @param callback    callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see ContinentMap.Task continents map task info
	 */
	public void getAllContinentTaskID(int continentID, int floorID, int regionID, int mapID, Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllContinentTaskIDs(Integer.toString(continentID), Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID)).enqueue(callback);
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param mapID       {@link ContinentMap#id}
	 * @param ids         list of region map task id
	 * @param callback    callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see ContinentMap.Task continents map task info
	 */
	public void getContinentTaskInfo(int continentID, int floorID, int regionID, int mapID, int[] ids, Callback<List<ContinentMap.Task>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getContinentTaskInfo(Integer.toString(continentID), Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID), processIds(ids)).enqueue(callback);
	}

	//Currencies
	/**
	 * For more info on Currency API go <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Currency currency info
	 */
	public void getAllCurrencyID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllCurrencies().enqueue(callback);
	}

	/**
	 * For more info on Currency API go <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of currency id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Currency currency info
	 */
	public void getCurrencyInfo(int[] ids, Callback<List<Currency>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getCurrencyInfo(processIds(ids)).enqueue(callback);
	}

	//Dungeons

	/**
	 * For more info on Dungeons API go <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Dungeon dungeon info
	 */
	public void getAllDungeonName(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllDungeonName().enqueue(callback);
	}

	/**
	 * For more info on Dungeons API go <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of dungeon id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Dungeon dungeon info
	 */
	public void getDungeonInfo(String[] ids, Callback<List<Dungeon>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getDungeonInfo(processIds(ids)).enqueue(callback);
	}

	//Finishers

	/**
	 * For more info on Finishers API go <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Finisher finisher info
	 */
	public void getAllFinisherID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllFinisherIDs().enqueue(callback);
	}

	/**
	 * For more info on Finishers API go <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of finisher id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Finisher finisher info
	 */
	public void getFinisherInfo(int[] ids, Callback<List<Finisher>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getFinisherInfo(processIds(ids)).enqueue(callback);
	}

	//Gliders

	/**
	 * For more info on gliders API go <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Glider glider info
	 */
	public void getAllGliderID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllGliderIDs().enqueue(callback);
	}

	/**
	 * For more info on gliders API go <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of glider id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Glider glider info
	 */
	public void getGliderInfo(int[] ids, Callback<List<Glider>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getGliderInfo(processIds(ids)).enqueue(callback);
	}

	//Guild Upgrades

	/**
	 * For more info on guild upgrades API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Upgrade guild upgrade info
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
	 * @see Upgrade guild upgrade info
	 */
	public void getGuildUpgradeInfo(int[] ids, Callback<List<Upgrade>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getGuildUpgradeInfo(processIds(ids)).enqueue(callback);
	}

	//Items

	/**
	 * For more info on Item API go <a href="https://wiki.guildwars2.com/wiki/API:2/items">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Item item info
	 */
	public void getAllItemID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllItemIDs().enqueue(callback);
	}

	/**
	 * For more info on Item API go <a href="https://wiki.guildwars2.com/wiki/API:2/items">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of item id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Item item info
	 */
	public void getItemInfo(int[] ids, Callback<List<Item>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getItemInfo(processIds(ids)).enqueue(callback);
	}

	//Item Stats

	/**
	 * For more info on Itemstat API go <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see ItemStats itemstat info
	 */
	public void getAllItemStatID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllItemStatIDs().enqueue(callback);
	}

	/**
	 * For more info on Itemstat API go <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of itemstat id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see ItemStats itemstat info
	 */
	public void getItemStatInfo(int[] ids, Callback<List<ItemStats>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getItemStatInfo(processIds(ids)).enqueue(callback);
	}

	//Mail Carriers

	/**
	 * For more info on mail carriers API go <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see MailCarrier mail carrier info
	 */
	public void getAllMailCarrierID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllMailCarrierIDs().enqueue(callback);
	}

	/**
	 * For more info on mail carriers API go <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of mail carrier id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see MailCarrier mail carrier info
	 */
	public void getMailCarrierInfo(int[] ids, Callback<List<MailCarrier>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getMailCarrierInfo(processIds(ids)).enqueue(callback);
	}

	//Masteries

	/**
	 * or more info on masteries API go <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Mastery mastery info
	 */
	public void getAllMasteryID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllMasteryIDs().enqueue(callback);
	}

	/**
	 * or more info on masteries API go <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of mastery id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Mastery mastery info
	 */
	public void getMasteryInfo(int[] ids, Callback<List<Mastery>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getMasteryInfo(processIds(ids)).enqueue(callback);
	}

	//Material Categories

	/**
	 * For more info on Material MaterialCategory API go <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see MaterialCategory material category info
	 */
	public void getAllMaterialCategoryID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllMaterialBankIDs().enqueue(callback);
	}

	/**
	 * For more info on Material MaterialCategory API go <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of category id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see MaterialCategory material category info
	 */
	public void getMaterialCategoryInfo(int[] ids, Callback<List<MaterialCategory>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getMaterialBankInfo(processIds(ids)).enqueue(callback);
	}

	//Minis

	/**
	 * For more info on Mini API go <a href="https://wiki.guildwars2.com/wiki/API:2/minis">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Mini mini info
	 */
	public void getAllMiniID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllMiniIDs().enqueue(callback);
	}

	/**
	 * For more info on Mini API go <a href="https://wiki.guildwars2.com/wiki/API:2/minis">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of mini id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Mini mini info
	 */
	public void getMiniInfo(int[] ids, Callback<List<Mini>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getMiniInfo(processIds(ids)).enqueue(callback);
	}

	//Outfits

	/**
	 * For more info on Outfits API go <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Outfit outfit info
	 */
	public void getAllOutfitID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllOutfitIDs().enqueue(callback);
	}

	/**
	 * For more info on Outfits API go <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of outfit id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Outfit outfit info
	 */
	public void getOutfitInfo(int[] ids, Callback<List<Outfit>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getOutfitInfo(processIds(ids)).enqueue(callback);
	}

	//Professions

	/**
	 * For more info on professions API go <a href="https://wiki.guildwars2.com/wiki/API:2/professions">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Profession profession info
	 */
	public void getAllProfessionID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllProfessionIDs().enqueue(callback);
	}

	/**
	 * For more info on professions API go <a href="https://wiki.guildwars2.com/wiki/API:2/professions">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of profession id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Profession profession info
	 */
	public void getProfessionInfo(String[] ids, Callback<List<Profession>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getProfessionInfo(processIds(ids)).enqueue(callback);
	}

	//PvP Amulets

	/**
	 * For more info on pvp amulets API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Amulet amulet info
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
	 * @see Amulet amulet info
	 */
	public void getPvPAmuletInfo(int[] ids, Callback<List<Amulet>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getPvPAmuletInfo(processIds(ids)).enqueue(callback);
	}

	//PvP Heroes

	/**
	 * For more info on pvp heroes API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Hero pvp hero info
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
	 * @see Hero pvp hero info
	 */
	public void getPvPHeroInfo(String[] ids, Callback<List<Hero>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getPvPHeroInfo(processIds(ids)).enqueue(callback);
	}

	//Raids

	/**
	 * For more info on raids API go <a href="https://wiki.guildwars2.com/wiki/API:2/raids">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Raid raid info
	 */
	public void getAllRaidID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllRaidIDs().enqueue(callback);
	}

	/**
	 * For more info on raids API go <a href="https://wiki.guildwars2.com/wiki/API:2/raids">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of raid id(s)
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Raid raid info
	 */
	public void getRaidInfo(String[] ids, Callback<List<Raid>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getRaidInfo(processIds(ids)).enqueue(callback);
	}

	//Recipes

	/**
	 * For more info on Recipes API go <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Recipe recipe info
	 */
	public void getAllRecipeID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllRecipeIDs().enqueue(callback);
	}

	/**
	 * For more info on Recipes API go <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of recipe id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Recipe recipe info
	 */
	public void getRecipeInfo(int[] ids, Callback<List<Recipe>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getRecipeInfo(processIds(ids)).enqueue(callback);
	}

	//Recipes Search

	/**
	 * For more info on Recipes search API go <a href="https://wiki.guildwars2.com/wiki/API:2/recipes/search">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Recipe recipe info
	 */
	public void searchRecipes(boolean isInput, int id, Callback<List<Integer>> callback) throws NullPointerException {
		if (isInput) gw2API.searchInputRecipes(Integer.toString(id)).enqueue(callback);
		else gw2API.searchOutputRecipes(Integer.toString(id)).enqueue(callback);
	}

	//Skills

	/**
	 * For more info on Skills API go <a href="https://wiki.guildwars2.com/wiki/API:2/skills">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Skill skill info
	 */
	public void getAllSkillID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllSkillIDs().enqueue(callback);
	}

	/**
	 * For more info on Skills API go <a href="https://wiki.guildwars2.com/wiki/API:2/skills">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of skill id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Skill skill info
	 */
	public void getSkillInfo(int[] ids, Callback<List<Skill>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getSkillInfo(processIds(ids)).enqueue(callback);
	}

	//Skins

	/**
	 * For more info on Skin API go <a href="https://wiki.guildwars2.com/wiki/API:2/skins">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Skin skin info
	 */
	public void getAllSkinID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllSkinIDs().enqueue(callback);
	}

	/**
	 * For more info on Skin API go <a href="https://wiki.guildwars2.com/wiki/API:2/skins">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of skin id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Skin skin info
	 */
	public void getSkinInfo(int[] ids, Callback<List<Skin>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getSkinInfo(processIds(ids)).enqueue(callback);
	}

	//Specializations

	/**
	 * For more info on specializations API go <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Specialization specialization info
	 */
	public void getAllSpecializationID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllSpecializationIDs().enqueue(callback);
	}

	/**
	 * For more info on specializations API go <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of specialization id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Specialization specialization info
	 */
	public void getSpecializationInfo(int[] ids, Callback<List<Specialization>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getSpecializationInfo(processIds(ids)).enqueue(callback);
	}

	//Titles

	/**
	 * For more info on titles API go <a href="https://wiki.guildwars2.com/wiki/API:2/titles">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Title title info
	 */
	public void getAllTitleID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllTitleIDs().enqueue(callback);
	}

	/**
	 * For more info on titles API go <a href="https://wiki.guildwars2.com/wiki/API:2/titles">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of title id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Title title info
	 */
	public void getTitleInfo(int[] ids, Callback<List<Title>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getTitleInfo(processIds(ids)).enqueue(callback);
	}

	//Traits

	/**
	 * For more info on traits API go <a href="https://wiki.guildwars2.com/wiki/API:2/traits">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Trait trait info
	 */
	public void getAllTraitID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllTraitIDs().enqueue(callback);
	}

	/**
	 * For more info on traits API go <a href="https://wiki.guildwars2.com/wiki/API:2/traits">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of trait id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Trait trait info
	 */
	public void getTraitInfo(int[] ids, Callback<List<Trait>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getTraitInfo(processIds(ids)).enqueue(callback);
	}

	//Worlds

	/**
	 * For more info on World API go <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see World world info
	 */
	public void getAllWorldID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllWorldsIDs().enqueue(callback);
	}

	/**
	 * For more info on World API go <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of world id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see World world info
	 */
	public void getWorldInfo(int[] ids, Callback<List<World>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getWorldsInfo(processIds(ids)).enqueue(callback);
	}

	//WvW Abilities

	/**
	 * For more info on WvW abilities API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Ability WvW abilities info
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
	 * @see Ability WvW abilities info
	 */
	public void getWvWAbilityInfo(int[] ids, Callback<List<Ability>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getWvWAbilityInfo(processIds(ids)).enqueue(callback);
	}

}
