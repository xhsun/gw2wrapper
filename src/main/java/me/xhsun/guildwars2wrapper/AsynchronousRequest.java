package me.xhsun.guildwars2wrapper;

import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.*;
import me.xhsun.guildwars2wrapper.model.account.*;
import me.xhsun.guildwars2wrapper.model.achievements.Achievement;
import me.xhsun.guildwars2wrapper.model.character.CharacterInventory;
import me.xhsun.guildwars2wrapper.model.character.Core;
import me.xhsun.guildwars2wrapper.model.commerce.Prices;
import me.xhsun.guildwars2wrapper.model.commerce.Transaction;
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

	//Accounts
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
	 * For more info on Character Core API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Core">here</a><br/>
	 * Get character information for the given character name that is linked to given API key
	 *
	 * @param API      API key
	 * @param name     name of character
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Core character info
	 */
	public void getCharacterInformation(String API, String name, Callback<Core> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterCore(name, API).enqueue(callback);
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
		gw2API.getListing(processListingTime(time), processListingType(type), API).enqueue(callback);
	}

	/**
	 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getAllListedItemID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllPrices().enqueue(callback);
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
	public void getPrices(int[] ids, Callback<List<Prices>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getPrices(processIds(ids)).enqueue(callback);
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

	//Dungeons
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

	//Finishers

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
	 * For more info on Material Category API go <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
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

	/**
	 * For more info on Material Category API go <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
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
}
