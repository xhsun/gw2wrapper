package me.xhsun.guildwars2wrapper;

import me.xhsun.guildwars2wrapper.error.ErrorCode;
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
import me.xhsun.guildwars2wrapper.model.commerce.Prices;
import me.xhsun.guildwars2wrapper.model.commerce.Transaction;
import me.xhsun.guildwars2wrapper.model.continent.Continent;
import me.xhsun.guildwars2wrapper.model.continent.ContinentFloor;
import me.xhsun.guildwars2wrapper.model.continent.ContinentMap;
import me.xhsun.guildwars2wrapper.model.continent.ContinentRegion;
import me.xhsun.guildwars2wrapper.model.guild.Upgrade;
import me.xhsun.guildwars2wrapper.model.pvp.Hero;
import me.xhsun.guildwars2wrapper.model.unlockable.Finisher;
import me.xhsun.guildwars2wrapper.model.unlockable.Glider;
import me.xhsun.guildwars2wrapper.model.unlockable.MailCarrier;
import me.xhsun.guildwars2wrapper.model.unlockable.Outfit;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * This class contains all the method for accessing data synchronously
 *
 * @author xhsun
 * @since 2017-06-04
 */

public class SynchronousRequest extends Request {
	SynchronousRequest(GuildWars2API gw2API) {
		super(gw2API);
	}

	//Token info
	/**
	 * For more info on TokenInfo API go <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">here</a><br/>
	 * Get detailed info related to this API key from server
	 *
	 * @param API API key
	 * @return API info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see TokenInfo API info
	 */
	public TokenInfo getAPIInfo(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<TokenInfo> response = gw2API.getAPIInfo(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Accounts
	/**
	 * For more info on Account API go <a href="https://wiki.guildwars2.com/wiki/API:2/account">here</a><br/>
	 * Get detailed info for account link to given API key
	 *
	 * @param API API key
	 * @return account info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Account Account info
	 */
	public Account getAccount(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<Account> response = gw2API.getAccount(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Account API go <a href="https://wiki.guildwars2.com/wiki/API:2/account">here</a><br/>
	 * Get an account's progress towards all their achievements.
	 *
	 * @param API API key
	 * @return list of account achievement info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see AchievementProgression account achievement info
	 */
	public List<AchievementProgression> getAchievementProgression(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<AchievementProgression>> response = gw2API.getAchievementProgression(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Bank API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/bank">here</a><br/>
	 * Get detailed info for bank linked to given API key
	 *
	 * @param API API key
	 * @return bank info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Bank Bank info
	 */
	public List<Bank> getBank(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Bank>> response = gw2API.getBank(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Dungeon progression API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/dungeons">here</a><br/>
	 *
	 * @param API API key
	 * @return an array of strings representing dungeon path names completed since daily dungeon reset
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<String> getDailyDungeonProgression(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<String>> response = gw2API.getDailyDungeonProgression(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Account dyes API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/dyes">here</a><br/>
	 * Get list of unlocked dyes ids linked to given API key
	 *
	 * @param API API key
	 * @return list of color ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Color
	 */
	public List<Integer> getUnlockedDyes(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Integer>> response = gw2API.getUnlockedDyes(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Account finishers API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/finishers">here</a><br/>
	 * Get list of unlocked finishers linked to given API key
	 *
	 * @param API API key
	 * @return list of unlocked finisher info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see UnlockedFinisher unlocked finisher info
	 */
	public List<UnlockedFinisher> getUnlockedFinishers(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<UnlockedFinisher>> response = gw2API.getUnlockedFinishers(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Account gliders API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/gliders">here</a><br/>
	 * Get list of unlocked glider id(s) linked to given API key
	 *
	 * @param API API key
	 * @return list of gliders id
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Integer> getUnlockedGliders(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Integer>> response = gw2API.getUnlockedGliders(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Account cats API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/home/cats">here</a><br/>
	 * Get list of unlocked cats linked to given API key
	 *
	 * @param API API key
	 * @return list of cats
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Cat cat info
	 */
	public List<Cat> getUnlockedCats(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Cat>> response = gw2API.getUnlockedCats(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Account nodes API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/home/nodes">here</a><br/>
	 * Get list of unlocked home nodes linked to given API key
	 *
	 * @param API API key
	 * @return list of strings
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<String> getUnlockedHomeNodes(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<String>> response = gw2API.getUnlockedHomeNodes(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Shared Inventory API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/inventory">here</a><br/>
	 * Get detailed info for shared inventory linked to given API key
	 *
	 * @param API API key
	 * @return share inventory info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see SharedInventory shared inventory info
	 */
	public List<SharedInventory> getSharedInventory(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<SharedInventory>> response = gw2API.getSharedInventory(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on account mail carrier API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/mailcarriers">here</a><br/>
	 * Get list of unlocked mail carrier id(s) linked to given API key
	 *
	 * @param API API key
	 * @return list of mail carrier id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Integer> getUnlockedMailCarriers(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Integer>> response = gw2API.getUnlockedMailCarriers(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on account masteries API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/masteries">here</a><br/>
	 * Get list of unlocked masteries linked to given API key
	 *
	 * @param API API key
	 * @return list of unlocked masteries
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see UnlockedMastery unlocked mastery info
	 */
	public List<UnlockedMastery> getUnlockedMasteries(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<UnlockedMastery>> response = gw2API.getUnlockedMasteries(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Material Storage API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/materials">here</a><br/>
	 * Get detailed info for material storage linked to given API key
	 *
	 * @param API API key
	 * @return material storage info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Material material storage info
	 */
	public List<Material> getMaterialStorage(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Material>> response = gw2API.getMaterialBank(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on account minis API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/minis">here</a><br/>
	 * Get list of unlocked mini id(s) linked to given API key
	 *
	 * @param API API key
	 * @return list of mini id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Mini mini info
	 */
	public List<Integer> getUnlockedMinis(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Integer>> response = gw2API.getUnlockedMinis(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on account outfits API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/outfits">here</a><br/>
	 * Get list of unlocked outfit id(s) linked to given API key
	 *
	 * @param API API key
	 * @return list of outfit id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Integer> getUnlockedOutfits(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Integer>> response = gw2API.getUnlockedOutfits(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on account pvp heroes API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/pvp/heroes">here</a><br/>
	 * Get list of unlocked pvp hero id(s) linked to given API key
	 *
	 * @param API API key
	 * @return list of pvp heroes id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Integer> getUnlockedPvpHeroes(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Integer>> response = gw2API.getUnlockedPvpHeroes(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on account raid API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/raids">here</a><br/>
	 * Get list of cleared raid linked to given API key
	 *
	 * @param API API key
	 * @return list of cleared raid
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<String> getWeeklyRaidProgression(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<String>> response = gw2API.getWeeklyRaidProgression(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on account recipes API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/raids">here</a><br/>
	 * Get list of unlocked recipe id(s) linked to given API key
	 *
	 * @param API API key
	 * @return list of unlocked recipe id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Recipe recipe info
	 */
	public List<Integer> getUnlockedRecipes(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Integer>> response = gw2API.getUnlockedRecipes(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Account/Skins API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/skins">here</a><br/>
	 * Get list of unlocked skin ids linked to given API key
	 *
	 * @param API API key
	 * @return list of ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Skin skin info
	 */
	public List<Integer> getUnlockedSkins(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Integer>> response = gw2API.getUnlockedSkins(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Account titles API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/titles">here</a><br/>
	 * Get list of unlocked title id(s) linked to given API key
	 *
	 * @param API API key
	 * @return list of unlocked title id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */

	public List<Integer> getUnlockedTitles(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Integer>> response = gw2API.getUnlockedTitles(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Wallet API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/wallet">here</a><br/>
	 * Get detailed info for wallet linked to given API key
	 *
	 * @param API API key
	 * @return wallet info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Wallet wallet info
	 */
	public List<Wallet> getWallet(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Wallet>> response = gw2API.getWallet(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Achievements
	/**
	 * For more info on achievement API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">here</a><br/>
	 * Get list of all available achievement id(s)
	 *
	 * @return list of achievement id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Achievement achievement info
	 */
	public List<Integer> getAllAchievementID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllAchievementIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on achievement API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">here</a><br/>
	 * Get list of achievement info corresponding to the given id(s)
	 *
	 * @param ids list of achievement id(s)
	 * @return list of achievement info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Achievement achievement info
	 */
	public List<Achievement> getAchievementInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Achievement>> response = gw2API.getAchievementInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on achievements categories API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">here</a><br/>
	 * Get list of all available achievement categories id(s)
	 *
	 * @return list of achievement categories id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see AchievementCategory achievement categories info
	 */
	public List<Integer> getAllAchievementCategoryID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllAchievementCategoryIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on achievements categories API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">here</a><br/>
	 * Get list of achievement categories info corresponding to the given id(s)
	 *
	 * @param ids list of achievement categories id(s)
	 * @return list of achievement categories info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see AchievementCategory achievement categories info
	 */
	public List<AchievementCategory> getAchievementCategoryInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<AchievementCategory>> response = gw2API.getAchievementCategoryInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on achievements daily API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/daily">here</a><br/>
	 * Get list of current daily achievements
	 *
	 * @return list of current daily achievements
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see DailyAchievement daily achievement info
	 */
	public DailyAchievement getCurrentDailyAchievements() throws GuildWars2Exception {
		try {
			Response<DailyAchievement> response = gw2API.getCurrentDailyAchievements().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on next achievements daily API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/daily/tomorrow">here</a><br/>
	 * Get list of tomorrow's daily achievements
	 *
	 * @return list of tomorrow's daily achievements
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see DailyAchievement daily achievement info
	 */
	public DailyAchievement getNextDailyAchievements() throws GuildWars2Exception {
		try {
			Response<DailyAchievement> response = gw2API.getNextDailyAchievements().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on achievements groups API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">here</a><br/>
	 * Get list of all available achievement group id(s)
	 *
	 * @return list of achievement group id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see AchievementGroup achievement group info
	 */
	public List<String> getAllAchievementGroupID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllAchievementGroupIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on achievements groups API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">here</a><br/>
	 * Get list of achievement group info corresponding to the given id(s)
	 *
	 * @param ids list of achievement group id(s)
	 * @return list of achievement group info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see AchievementGroup achievement group info
	 */
	public List<AchievementGroup> getAchievementGroupInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<AchievementGroup>> response = gw2API.getAchievementGroupInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Back Story
	/**
	 * For more info on back story answer API go <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">here</a><br/>
	 * Get list of all back story answer id(s)
	 *
	 * @return list of back story answer id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see BackStoryAnswer back story answer info
	 */
	public List<String> getAllBackStoryAnswerID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllBackStoryAnswerIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on back story answer API go <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">here</a><br/>
	 * Get list of back story answer info corresponding to the given id(s)
	 *
	 * @param ids list of back story answer id(s)
	 * @return list of back story answer info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see BackStoryAnswer back story answer info
	 */
	public List<BackStoryAnswer> getBackStoryAnswerInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<BackStoryAnswer>> response = gw2API.getBackStoryAnswerInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on back story questions API go <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">here</a><br/>
	 * Get list of all available back story question id(s)
	 *
	 * @return list of back story question id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see BackStoryQuestion back story question info
	 */
	public List<Integer> getAllBackStoryQuestionID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllBackStoryQuestionIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on back story questions API go <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">here</a><br/>
	 * Get list of back story question info corresponding to the given id(s)
	 *
	 * @param ids list of back story question id(s)
	 * @return list of back story question info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see BackStoryQuestion back story question info
	 */
	public List<BackStoryQuestion> getBackStoryQuestionInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<BackStoryQuestion>> response = gw2API.getBackStoryQuestionInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Game Build
	/**
	 * For more info on build API go <a href="https://wiki.guildwars2.com/wiki/API:2/build">here</a><br/>
	 * get current game bild
	 *
	 * @return current game build
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see GameBuild game build info
	 */
	public GameBuild getCurrentGameBuild() throws GuildWars2Exception {
		try {
			Response<GameBuild> response = gw2API.getCurrentGameBuild().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Characters
	/**
	 * For more info on Character API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 *
	 * @param API API key
	 * @return list of character name
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<String> getAllCharacterName(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<String>> response = gw2API.getAllCharacterName(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on character overview API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 *
	 * @param API  API key
	 * @param name name of character
	 * @return character detail
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Character character info
	 */
	public Character getCharacter(String API, String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		try {
			Response<Character> response = gw2API.getCharacter(name, API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on character back story API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Backstory">here</a><br/>
	 *
	 * @param API  API key
	 * @param name name of character
	 * @return list of {@link BackStoryAnswer#id}
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see CharacterBackStory back store answer info
	 */
	public CharacterBackStory getCharacterBackStory(String API, String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		try {
			Response<CharacterBackStory> response = gw2API.getCharacterBackStory(name, API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Character Core API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Core">here</a><br/>
	 *
	 * @param API  API key
	 * @param name name of character
	 * @return character detail
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Core basic character info
	 */
	public Core getCharacterInformation(String API, String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		try {
			Response<Core> response = gw2API.getCharacterCore(name, API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on character crafting API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Crafting">here</a><br/>
	 *
	 * @param API  API key
	 * @param name name of character
	 * @return list of character crafting info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see CraftingLevel character crafting info
	 */
	public CraftingLevel getCharacterCrafting(String API, String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		try {
			Response<CraftingLevel> response = gw2API.getCharacterCrafting(name, API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on character equipment API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Equipment">here</a><br/>
	 *
	 * @param API  API key
	 * @param name name of character
	 * @return list of equipment
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see CharacterEquipment equipment info
	 */
	public CharacterEquipment getCharacterEquipment(String API, String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		try {
			Response<CharacterEquipment> response = gw2API.getCharacterEquipment(name, API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on character hero points API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Heropoints">here</a><br/>
	 *
	 * @param API  API key
	 * @param name name of character
	 * @return list of {@link BackStoryAnswer#id}
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see BackStoryAnswer hero points info TODO /v2/continents
	 */
	public List<String> getCharacterHeroPoints(String API, String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		try {
			Response<List<String>> response = gw2API.getCharacterHeroPoints(name, API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Character Inventory API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Inventory">here</a><br/>
	 *
	 * @param API  API key
	 * @param name name of character
	 * @return character inventory detail
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see me.xhsun.guildwars2wrapper.model.util.Bag character inventory info
	 */
	public CharacterInventory getCharacterInventory(String API, String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		try {
			Response<CharacterInventory> response = gw2API.getCharacterInventory(name, API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Character Recipes API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 *
	 * @param API  API key
	 * @param name name of character
	 * @return list of {@link Recipe#id}
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Recipe recipe info
	 */
	public CharacterRecipes getCharacterUnlockedRecipes(String API, String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		try {
			Response<CharacterRecipes> response = gw2API.getCharacterUnlockedRecipes(name, API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Character SAB API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Super_Adventure_Box_.28sab.29">here</a><br/>
	 *
	 * @param API  API key
	 * @param name name of character
	 * @return character SAB detail
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see CharacterSAB character SAB info
	 */
	public CharacterSAB getCharacterSAB(String API, String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		try {
			Response<CharacterSAB> response = gw2API.getCharacterSAB(name, API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Character Skills API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Skills">here</a><br/>
	 *
	 * @param API  API key
	 * @param name name of character
	 * @return character inventory detail
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see CharacterSkills character skills info
	 */
	public CharacterSkills getCharacterSkills(String API, String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		try {
			Response<CharacterSkills> response = gw2API.getCharacterSkills(name, API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Character Specialization API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Specialization">here</a><br/>
	 *
	 * @param API  API key
	 * @param name name of character
	 * @return character specialization detail
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see CharacterSpecialization character specialization info
	 */
	public CharacterSpecialization getCharacterSpecialization(String API, String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		try {
			Response<CharacterSpecialization> response = gw2API.getCharacterSpecialization(name, API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Character Training API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Training">here</a><br/>
	 *
	 * @param API  API key
	 * @param name name of character
	 * @return list of character training detail
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see CharacterTraining character training info
	 */
	public CharacterTraining getCharacterTraining(String API, String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		try {
			Response<CharacterTraining> response = gw2API.getCharacterTraining(name, API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Colors

	/**
	 * For more info on Color API go <a href="https://wiki.guildwars2.com/wiki/API:2/colors">here</a><br/>
	 * Get list of all available color id(s)
	 *
	 * @return list of color id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Color color info
	 */
	public List<Integer> getAllColorID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllColorIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Color API go <a href="https://wiki.guildwars2.com/wiki/API:2/colors">here</a><br/>
	 * Get color info for the given color id(s)
	 *
	 * @param ids array of color id
	 * @return list of color info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Color color info
	 */
	public List<Color> getColorInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Color>> response = gw2API.getColorInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//TP
	/**
	 * For more info on Transaction API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/transactions">here</a><br/>
	 * Get transaction info linked to given API key
	 *
	 * @param API  API key
	 * @param time current | History
	 * @param type buy | sell
	 * @return list of transaction base on the selection, if there is nothing, return empty list
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Transaction transaction info
	 */
	public List<Transaction> getListing(String API, Transaction.Time time, Transaction.Type type) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Transaction>> response = gw2API.getListing(processListingTime(time), processListingType(type), API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Get all id of items that is on the TP
	 *
	 * @return list of item ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Integer> getAllListedItemID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllPrices().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Get price info for the given item id(s)
	 *
	 * @param ids list of item id
	 * @return list of listing price for given id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Prices listing price info
	 */
	public List<Prices> getPrices(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Prices>> response = gw2API.getPrices(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Continents

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Get all continent ids
	 *
	 * @return list of continent ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Continent continent info
	 */
	public List<Integer> getAllContinentID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllContinentIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Get continent info for the given continent id(s)
	 *
	 * @param ids list of continent id
	 * @return list of continent info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Continent continent info
	 */
	public List<Continent> getContinentInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Continent>> response = gw2API.getContinentInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Get all continent floor ids
	 *
	 * @param continentID {@link Continent#id}
	 * @return list of continent floor ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ContinentFloor continent floor info
	 */
	public List<Integer> getAllContinentFloorID(int continentID) throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllContinentFloorIDs(Integer.toString(continentID)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Get continent info for the given continent floor id(s)
	 *
	 * @param continentID {@link Continent#id}
	 * @param ids list of continent floor id
	 * @return list of continent floor info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ContinentFloor continent floor info
	 */
	public List<ContinentFloor> getContinentFloorInfo(int continentID, int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<ContinentFloor>> response = gw2API.getContinentFloorInfo(Integer.toString(continentID), processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Get all continent region ids
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @return list of continent region ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ContinentRegion continent region info
	 */
	public List<Integer> getAllContinentRegionID(int continentID, int floorID) throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllContinentRegionIDs(Integer.toString(continentID),
					Integer.toString(floorID)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Get continent region info for the given continent region id(s)
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param ids         list of continent region id
	 * @return list of continent region info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ContinentRegion continent region info
	 */
	public List<ContinentRegion> getContinentRegionInfo(int continentID, int floorID, int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<ContinentRegion>> response = gw2API.getContinentRegionInfo(Integer.toString(continentID),
					Integer.toString(floorID), processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Get all continent map ids
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @return list of continent map ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ContinentMap continent map info
	 */
	public List<Integer> getAllContinentMapID(int continentID, int floorID, int regionID) throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllContinentMapIDs(Integer.toString(continentID),
					Integer.toString(floorID), Integer.toString(regionID)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Get continent map info for the given continent map id(s)
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param ids         list of continent map id
	 * @return list of continent map info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ContinentMap continent map info
	 */
	public List<ContinentMap> getContinentMapInfo(int continentID, int floorID, int regionID, int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<ContinentMap>> response = gw2API.getContinentMapInfo(Integer.toString(continentID),
					Integer.toString(floorID), Integer.toString(regionID), processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Currencies

	/**
	 * For more info on Currency API go <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">here</a><br/>
	 * Get all currency ids
	 *
	 * @return list of currency ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Currency currency info
	 */
	public List<Integer> getAllCurrencyID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllCurrencies().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Currency API go <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">here</a><br/>
	 * Get currency info for the given currency id(s)
	 *
	 * @param ids list of currency id
	 * @return list of currency info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Currency currency info
	 */
	public List<Currency> getCurrencyInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Currency>> response = gw2API.getCurrencyInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Dungeons

	/**
	 * For more info on Dungeons API go <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">here</a><br/>
	 * Get all dungeon name(s)
	 *
	 * @return list of dungeon name(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Dungeon dungeon info
	 */
	public List<String> getAllDungeonName() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllDungeonName().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Dungeons API go <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">here</a><br/>
	 * Get dungeon info for the given dungeon id(s)
	 *
	 * @param ids list of dungeon id
	 * @return list of dungeon info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Dungeon dungeon info
	 */
	public List<Dungeon> getDungeonInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Dungeon>> response = gw2API.getDungeonInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Finishers

	/**
	 * For more info on Finishers API go <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">here</a><br/>
	 * Get all finisher id(s)
	 *
	 * @return list of finisher id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Finisher finisher info
	 */
	public List<Integer> getAllFinisherID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllFinisherIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Finishers API go <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">here</a><br/>
	 * Get finisher info for the given finisher id(s)
	 *
	 * @param ids list of finisher id
	 * @return list of finisher info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Finisher finisher info
	 */
	public List<Finisher> getFinisherInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Finisher>> response = gw2API.getFinisherInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Glider

	/**
	 * For more info on gliders API go <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">here</a><br/>
	 * Get all glider id(s)
	 *
	 * @return list of glider id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Glider glider info
	 */
	public List<Integer> getAllGliderID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllGliderIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on gliders API go <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">here</a><br/>
	 * Get glider info for the given glider id(s)
	 *
	 * @param ids list of glider id
	 * @return list of glider info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Glider glider info
	 */
	public List<Glider> getGliderInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Glider>> response = gw2API.getGliderInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Guild Upgrades

	/**
	 * For more info on guild upgrades API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">here</a><br/>
	 * Get all guild upgrade id(s)
	 *
	 * @return list of guild upgrade id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Upgrade guild upgrade info
	 */
	public List<Integer> getAllGuildUpgradeID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllGuildUpgradeIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on guild upgrades API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">here</a><br/>
	 * Get guild upgrade info for the given guild upgrade id(s)
	 *
	 * @param ids list of guild upgrade id
	 * @return list of guild upgrade info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Upgrade guild upgrade info
	 */
	public List<Upgrade> getGuildUpgradeInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Upgrade>> response = gw2API.getGuildUpgradeInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Items

	/**
	 * For more info on Item API go <a href="https://wiki.guildwars2.com/wiki/API:2/items">here</a><br/>
	 * Get all available item ids
	 *
	 * @return list of item ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Item item info
	 */
	public List<Integer> getAllItemID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllItemIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Item API go <a href="https://wiki.guildwars2.com/wiki/API:2/items">here</a><br/>
	 * Get item info for the given item id(s)
	 *
	 * @param ids list of item id
	 * @return list of item info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Item item info
	 */
	public List<Item> getItemInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Item>> response = gw2API.getItemInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Item Stats

	/**
	 * For more info on Itemstat API go <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
	 * Get all available itemstat ids
	 *
	 * @return list of itemstat ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ItemStats itemstat info
	 */
	public List<Integer> getAllItemStatID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllItemStatIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Itemstat API go <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
	 * Get itemstat info for the given itemstat id(s)
	 *
	 * @param ids list of itemstat id
	 * @return list of itemstat info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ItemStats itemstat info
	 */
	public List<ItemStats> getItemStatInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<ItemStats>> response = gw2API.getItemStatInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Mail Carriers

	/**
	 * For more info on mail carriers API go <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">here</a><br/>
	 * Get all mail carrier id(s)
	 *
	 * @return list of mail carrier info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see MailCarrier mail carrier info
	 */
	public List<Integer> getAllMailCarrierID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllMailCarrierIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on mail carriers API go <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">here</a><br/>
	 * Get mail carrier info for the given mail carrier id(s)
	 *
	 * @param ids list of mail carrier id
	 * @return list of mail carrier info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see MailCarrier mail carrier info
	 */
	public List<MailCarrier> getMailCarrierInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<MailCarrier>> response = gw2API.getMailCarrierInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Masteries

	/**
	 * For more info on masteries API go <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">here</a><br/>
	 * Get all mastery id(s)
	 *
	 * @return list of mastery id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Mastery mastery info
	 */
	public List<Integer> getAllMasteryID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllMasteryIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on masteries API go <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">here</a><br/>
	 * Get mastery info for the given mastery id(s)
	 *
	 * @param ids list of mastery id
	 * @return list of mastery info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Mastery mastery info
	 */
	public List<Mastery> getMasteryInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Mastery>> response = gw2API.getMasteryInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Material Categories

	/**
	 * For more info on Material MaterialCategory API go <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
	 * Get list of all available material category ids
	 *
	 * @return list of material category id
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see MaterialCategory material category info
	 */
	public List<Integer> getAllMaterialCategoryID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllMaterialBankIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Material MaterialCategory API go <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
	 * Get material category info for the given category id(s)
	 *
	 * @param ids list of category id
	 * @return list of material category info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see MaterialCategory material category info
	 */
	public List<MaterialCategory> getMaterialCategoryInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<MaterialCategory>> response = gw2API.getMaterialBankInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Minis

	/**
	 * For more info on Mini API go <a href="https://wiki.guildwars2.com/wiki/API:2/minis">here</a><br/>
	 * Get list of all available mini id(s)
	 *
	 * @return list of mini id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Mini mini info
	 */
	public List<Integer> getAllMiniID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllMiniIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Mini API go <a href="https://wiki.guildwars2.com/wiki/API:2/minis">here</a><br/>
	 * Get mini info for the given mini id(s)
	 *
	 * @param ids list of mini id(s)
	 * @return list of mini info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Mini mini info
	 */
	public List<Mini> getMiniInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Mini>> response = gw2API.getMiniInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Outfits

	/**
	 * For more info on Outfits API go <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">here</a><br/>
	 * Get all outfit id(s)
	 *
	 * @return list of outfit id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Outfit outfit info
	 */
	public List<Integer> getAllOutfitID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllOutfitIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Outfits API go <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">here</a><br/>
	 * Get outfit info for the given outfit id(s)
	 *
	 * @param ids list of outfit id(s)
	 * @return list of outfit info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Outfit outfit info
	 */
	public List<Outfit> getOutfitInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Outfit>> response = gw2API.getOutfitInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//PvP Heroes

	/**
	 * For more info on pvp heroes API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">here</a><br/>
	 * Get all pvp hero id(s)
	 *
	 * @return list of pvp hero id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Hero pvp hero info
	 */
	public List<String> getAllPvPHeroID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllPvPHeroIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on pvp heroes API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">here</a><br/>
	 * Get pvp hero info for the given pvp hero id(s)
	 *
	 * @param ids list of pvp hero id(s)
	 * @return list of pvp hero info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Hero pvp hero info
	 */
	public List<Hero> getPvPHeroInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Hero>> response = gw2API.getPvPHeroInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Raids

	/**
	 * For more info on raids API go <a href="https://wiki.guildwars2.com/wiki/API:2/raids">here</a><br/>
	 * Get all raid id(s)
	 *
	 * @return list of raid id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Raid raid info
	 */
	public List<String> getAllRaidID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllRaidIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on raids API go <a href="https://wiki.guildwars2.com/wiki/API:2/raids">here</a><br/>
	 * Get raid info for the given raid id(s)
	 *
	 * @param ids list of raid id(s)
	 * @return list of raid info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Raid raid info
	 */
	public List<Raid> getRaidInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Raid>> response = gw2API.getRaidInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Recipes

	/**
	 * For more info on Recipes API go <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">here</a><br/>
	 * Get list of all available recipe id(s)
	 *
	 * @return list of recipe ids(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Recipe recipe info
	 */
	public List<Integer> getAllRecipeID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllRecipeIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Recipes API go <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">here</a><br/>
	 * Get recipe info for the given recipe id(s)
	 *
	 * @param ids array of recipe id
	 * @return list of recipe info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Recipe recipe info
	 */
	public List<Recipe> getRecipeInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Recipe>> response = gw2API.getRecipeInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Recipes Search

	/**
	 * For more info on Recipes search API go <a href="https://wiki.guildwars2.com/wiki/API:2/recipes/search">here</a><br/>
	 *
	 * @param isInput is given id an ingredient
	 * @param id      recipe id
	 * @return list of recipe id
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Integer> searchRecipes(boolean isInput, int id) throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = (isInput) ?
					gw2API.searchInputRecipes(Integer.toString(id)).execute() :
					gw2API.searchOutputRecipes(Integer.toString(id)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Skins

	/**
	 * For more info on Skin API go <a href="https://wiki.guildwars2.com/wiki/API:2/skins">here</a><br/>
	 * Get list of all available skin ids
	 *
	 * @return list of skin ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Skin skin info
	 */
	public List<Integer> getAllSkinID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllSkinIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Skin API go <a href="https://wiki.guildwars2.com/wiki/API:2/skins">here</a><br/>
	 * Get skin info for the given skin id(s)
	 *
	 * @param ids list of skin id
	 * @return list of skin info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Skin skin info
	 */
	public List<Skin> getSkinInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Skin>> response = gw2API.getSkinInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Titles

	/**
	 * For more info on titles API go <a href="https://wiki.guildwars2.com/wiki/API:2/titles">here</a><br/>
	 * Get all title id(s)
	 *
	 * @return list of title id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Title title info
	 */
	public List<Integer> getAllTitleID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllTitleIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on titles API go <a href="https://wiki.guildwars2.com/wiki/API:2/titles">here</a><br/>
	 * Get title info for the given title id(s)
	 *
	 * @param ids list of title id(s)
	 * @return list of title info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Title title info
	 */
	public List<Title> getTitleInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Title>> response = gw2API.getTitleInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Worlds

	/**
	 * For more info on World API go <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">here</a><br/>
	 * Get list of all available world id(s)
	 *
	 * @return list of world id
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see World world info
	 */
	public List<Integer> getAllWorldID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllWorldsIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on World API go <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">here</a><br/>
	 * Get world info for the given world id(s)
	 *
	 * @param ids list of world id
	 * @return list of world info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see World world info
	 */
	public List<World> getWorldInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<World>> response = gw2API.getWorldsInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}
}
