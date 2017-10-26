package me.xhsun.guildwars2wrapper;

import me.xhsun.guildwars2wrapper.error.ErrorCode;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v1.AllWvWMatchOverview;
import me.xhsun.guildwars2wrapper.model.v1.EventDetail;
import me.xhsun.guildwars2wrapper.model.v1.SimpleName;
import me.xhsun.guildwars2wrapper.model.v2.*;
import me.xhsun.guildwars2wrapper.model.v2.account.*;
import me.xhsun.guildwars2wrapper.model.v2.achievement.Achievement;
import me.xhsun.guildwars2wrapper.model.v2.achievement.AchievementCategory;
import me.xhsun.guildwars2wrapper.model.v2.achievement.AchievementGroup;
import me.xhsun.guildwars2wrapper.model.v2.achievement.DailyAchievement;
import me.xhsun.guildwars2wrapper.model.v2.backstory.BackStoryAnswer;
import me.xhsun.guildwars2wrapper.model.v2.backstory.BackStoryQuestion;
import me.xhsun.guildwars2wrapper.model.v2.character.Character;
import me.xhsun.guildwars2wrapper.model.v2.character.*;
import me.xhsun.guildwars2wrapper.model.v2.commerce.*;
import me.xhsun.guildwars2wrapper.model.v2.continent.Continent;
import me.xhsun.guildwars2wrapper.model.v2.continent.ContinentFloor;
import me.xhsun.guildwars2wrapper.model.v2.continent.ContinentMap;
import me.xhsun.guildwars2wrapper.model.v2.continent.ContinentRegion;
import me.xhsun.guildwars2wrapper.model.v2.guild.*;
import me.xhsun.guildwars2wrapper.model.v2.pvp.*;
import me.xhsun.guildwars2wrapper.model.v2.story.Story;
import me.xhsun.guildwars2wrapper.model.v2.story.StorySeason;
import me.xhsun.guildwars2wrapper.model.v2.util.Inventory;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWAbility;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWObjective;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWRank;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWUpgrade;
import me.xhsun.guildwars2wrapper.model.v2.wvw.matches.*;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

	//API:1
	//Event Detail

	/**
	 * For more info on event detail API go <a href="https://wiki.guildwars2.com/wiki/API:1/event_details">here</a><br/>
	 *
	 * @return event details
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see EventDetail event detail
	 */
	public EventDetail getAllEventDetailedInfo() throws GuildWars2Exception {
		try {
			Response<EventDetail> response = gw2API.getAllEventDetailedInfo(GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on event detail API go <a href="https://wiki.guildwars2.com/wiki/API:1/event_details">here</a><br/>
	 *
	 * @param id event id
	 * @return event details
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see EventDetail event detail
	 */
	public EventDetail getEventDetailedInfo(String id) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.ID, id));
		try {
			Response<EventDetail> response = gw2API.getEventDetailedInfo(id, GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Map Names

	/**
	 * For more info on map name API go <a href="https://wiki.guildwars2.com/wiki/API:1/map_names">here</a><br/>
	 *
	 * @return list of names
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see SimpleName map name
	 */
	public List<SimpleName> getAllMapNames() throws GuildWars2Exception {
		try {
			Response<List<SimpleName>> response = gw2API.getAllMapNames(GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//World Names

	/**
	 * For more info on world name API go <a href="https://wiki.guildwars2.com/wiki/API:1/world_names">here</a><br/>
	 *
	 * @return list of names
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see SimpleName world name
	 */
	public List<SimpleName> getAllWorldNames() throws GuildWars2Exception {
		try {
			Response<List<SimpleName>> response = gw2API.getAllWorldNames(GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//WvW Matches

	/**
	 * For more info on v1 wvw matches API go <a href="https://wiki.guildwars2.com/wiki/API:1/wvw/matches">here</a><br/>
	 *
	 * @return simple wvw matches info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see AllWvWMatchOverview wvw matches
	 */
	public AllWvWMatchOverview getAllWvWMatchOverview() throws GuildWars2Exception {
		try {
			Response<AllWvWMatchOverview> response = gw2API.getAllWvWMatchOverview().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//WvW Objective Names

	/**
	 * For more info on WvW objective API go <a href="https://wiki.guildwars2.com/wiki/API:1/wvw/objective_names">here</a><br/>
	 *
	 * @return list of names
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see SimpleName objective name
	 */
	public List<SimpleName> getAllWvWObjectiveNames() throws GuildWars2Exception {
		try {
			Response<List<SimpleName>> response = gw2API.getAllWvWObjectiveNames(GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//API:2
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
	public Account getAccountInfo(String API) throws GuildWars2Exception {
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
	 * @see Inventory Bank info
	 */
	public List<Inventory> getBank(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Inventory>> response = gw2API.getBank(API).execute();
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
	 * @see Inventory shared inventory info
	 */
	public List<Inventory> getSharedInventory(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Inventory>> response = gw2API.getSharedInventory(API).execute();
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
	 * @see MaterialStorage material storage info
	 */
	public List<MaterialStorage> getMaterialStorage(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<MaterialStorage>> response = gw2API.getMaterialBank(API).execute();
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
			Response<List<Achievement>> response = gw2API.getAchievementInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<AchievementCategory>> response = gw2API.getAchievementCategoryInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<AchievementGroup>> response = gw2API.getAchievementGroupInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<BackStoryAnswer>> response = gw2API.getBackStoryAnswerInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<BackStoryQuestion>> response = gw2API.getBackStoryQuestionInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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

	//Cats

	/**
	 * For more info on cats API go <a href="https://wiki.guildwars2.com/wiki/API:2/cats">here</a><br/>
	 * Get list of all available cat id(s)
	 *
	 * @return list of cat id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Color cat info
	 */
	public List<Integer> getAllCatID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllCatIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on cats API go <a href="https://wiki.guildwars2.com/wiki/API:2/cats">here</a><br/>
	 * Get cat info for the given cat id(s)
	 *
	 * @param ids array of cat id
	 * @return list of cat info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Cat cat info
	 */
	public List<Cat> getCatInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Cat>> response = gw2API.getCatInfo(processIds(ids)).execute();
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
	 * @see CharacterCore basic character info
	 */
	public CharacterCore getCharacterInformation(String API, String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		try {
			Response<CharacterCore> response = gw2API.getCharacterCore(name, API).execute();
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
	 * @see CharacterCraftingLevel character crafting info
	 */
	public CharacterCraftingLevel getCharacterCrafting(String API, String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		try {
			Response<CharacterCraftingLevel> response = gw2API.getCharacterCrafting(name, API).execute();
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
	 * @see BackStoryAnswer hero points info
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
	 * @see CharacterInventory character inventory info
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
			Response<List<Color>> response = gw2API.getColorInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//TP

	/**
	 * For more info on delivery API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/delivery">here</a><br/>
	 *
	 * @param API API key
	 * @return list of current items and coins available for pickup on this account
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Delivery delivery info
	 */
	public Delivery getTPDeliveryInfo(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<Delivery> response = gw2API.getTPDeliveryInfo(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on exchange API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/exchange">here</a><br/>
	 *
	 * @return list of accepted resources for the gem exchange
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Exchange Exchange info
	 */
	public List<String> getAllExchangeCurrency() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllExchangeCurrency().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on exchange coins API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/exchange/coins">here</a><br/>
	 *
	 * @param currency exchange currency type
	 * @param quantity The amount to exchange
	 * @return the current coins to gems exchange rate
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Exchange Exchange info
	 */
	public Exchange getExchangeInfo(Exchange.Type currency, long quantity) throws GuildWars2Exception {
		isValueValid(quantity);
		try {
			Response<Exchange> response = gw2API.getExchangeInfo(currency.name(), Long.toString(quantity)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on listings API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/listings">here</a><br/>
	 *
	 * @return list of item ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Listing listing info
	 */
	public List<Integer> getAllTPListingID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllTPListingIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on listings API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/listings">here</a><br/>
	 * Get listing info for the given item id(s)
	 *
	 * @param ids list of item id
	 * @return list of listings for given id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Listing listing info
	 */
	public List<Listing> getTPListingInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Listing>> response = gw2API.getTPListingInfo(processIds(ids)).execute();
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
	public List<Integer> getAllPriceID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllTPPriceIDs().execute();
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
	public List<Prices> getPriceInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Prices>> response = gw2API.getTPPriceInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

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
	public List<Transaction> getTPTransaction(String API, Transaction.Time time, Transaction.Type type) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		if (time == null || type == null)
			throw new GuildWars2Exception(ErrorCode.TransTime, "Transaction time/type cannot be empty");
		try {
			Response<List<Transaction>> response = gw2API.getTPTransaction(time.getValue(), type.getValue(), API).execute();
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
			Response<List<Continent>> response = gw2API.getContinentInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<ContinentFloor>> response = gw2API.getContinentFloorInfo(Integer.toString(continentID), processIds(ids), GuildWars2.lang.getValue()).execute();
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
					Integer.toString(floorID), processIds(ids), GuildWars2.lang.getValue()).execute();
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
					Integer.toString(floorID), Integer.toString(regionID), processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Get all continent map sector ids
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param mapID       {@link ContinentMap#id}
	 * @return list of continent map sector ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ContinentMap.Sector continent map sector info
	 */
	public List<Integer> getAllContinentSectorID(int continentID, int floorID, int regionID, int mapID) throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllContinentSectorIDs(Integer.toString(continentID),
					Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Get continent map sector info for the given continent map sector id(s)
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param mapID       {@link ContinentMap#id}
	 * @param ids         list of continent map sector id
	 * @return list of continent map sector info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ContinentMap.Sector continent map sector info
	 */
	public List<ContinentMap.Sector> getContinentSectorInfo(int continentID, int floorID, int regionID, int mapID, int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<ContinentMap.Sector>> response = gw2API.getContinentSectorInfo(Integer.toString(continentID),
					Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID), processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Get all continent map PoI ids
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param mapID       {@link ContinentMap#id}
	 * @return list of continent map PoI ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ContinentMap.Sector continent map PoI info
	 */
	public List<Integer> getAllContinentPOIID(int continentID, int floorID, int regionID, int mapID) throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllContinentPOIIDs(Integer.toString(continentID),
					Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Get continent map PoI info for the given continent map PoI id(s)
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param mapID       {@link ContinentMap#id}
	 * @param ids         list of continent map PoI id
	 * @return list of continent map PoI info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ContinentMap.PoI continent map PoI info
	 */
	public List<ContinentMap.PoI> getContinentPOIInfo(int continentID, int floorID, int regionID, int mapID, int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<ContinentMap.PoI>> response = gw2API.getContinentPOIInfo(Integer.toString(continentID),
					Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID), processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Get all continent map task ids
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param mapID       {@link ContinentMap#id}
	 * @return list of continent map task ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ContinentMap.Task continent map task info
	 */
	public List<Integer> getAllContinentTaskID(int continentID, int floorID, int regionID, int mapID) throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllContinentTaskIDs(Integer.toString(continentID),
					Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on continents API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Get continent map task info for the given continent map task id(s)
	 *
	 * @param continentID {@link Continent#id}
	 * @param floorID     {@link ContinentFloor#id}
	 * @param regionID    {@link ContinentRegion#id}
	 * @param mapID       {@link ContinentMap#id}
	 * @param ids         list of continent map task id
	 * @return list of continent map task info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ContinentMap.Task continent map task info
	 */
	public List<ContinentMap.Task> getContinentTaskInfo(int continentID, int floorID, int regionID, int mapID, int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<ContinentMap.Task>> response = gw2API.getContinentTaskInfo(Integer.toString(continentID),
					Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID), processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<Currency>> response = gw2API.getCurrencyInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<Dungeon>> response = gw2API.getDungeonInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Emblem

	/**
	 * For more info on emblem API go <a href="https://wiki.guildwars2.com/wiki/API:2/emblem">here</a><br/>
	 *
	 * @return list containing two strings, foregrounds and backgrounds
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Emblem Emblem info
	 */
	public List<String> getAllEmblemType() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllEmblemType().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on emblem API go <a href="https://wiki.guildwars2.com/wiki/API:2/emblem">here</a><br/>
	 *
	 * @param type foregrounds/backgrounds
	 * @return list of emblem id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Emblem Emblem info
	 */
	public List<Integer> getAllEmblemIDs(Emblem.Type type) throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllEmblemIDs(type.name()).execute();
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
	 * @param type foregrounds/backgrounds
	 * @param ids  list of finisher id
	 * @return list of finisher info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Finisher finisher info
	 */
	public List<Emblem> getAllEmblemInfo(Emblem.Type type, int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		if (ids.length > 200)
			throw new GuildWars2Exception(ErrorCode.ID, "id list too long; this endpoint is limited to 200 ids at once");
		try {
			Response<List<Emblem>> response = gw2API.getAllEmblemInfo(type.name(), processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Files

	/**
	 * For more info on files API go <a href="https://wiki.guildwars2.com/wiki/API:2/files">here</a><br/>
	 *
	 * @return list of file id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Asset file info
	 */
	public List<String> getAllFileID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllFileIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on files API go <a href="https://wiki.guildwars2.com/wiki/API:2/files">here</a><br/>
	 * Get file info for the given file id(s)
	 *
	 * @param ids list of file id
	 * @return Map of file id and file icon
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Asset file info
	 */
	public List<Asset> getAllFileInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Asset>> response = gw2API.getAllFileInfo(processIds(ids)).execute();
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
			Response<List<Finisher>> response = gw2API.getFinisherInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Gliders

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
			Response<List<Glider>> response = gw2API.getGliderInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Guild

	/**
	 * For more info on guild API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id">here</a><br/>
	 * Get guild info for the given guild id
	 *
	 * @param id {@link Guild#id}
	 * @return list of guild info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Guild guild info
	 */
	public Guild getGeneralGuildInfo(String id) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.GUILD, id));
		try {
			Response<Guild> response = gw2API.getGeneralGuildInfo(id).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on guild API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id">here</a><br/>
	 * Get guild info for the given guild id<br/>
	 * Note: if the given account is not a member, sometime endpoint will return general guild info instead of detailed info
	 *
	 * @param id  {@link Guild#id}
	 * @param api Guild Wars 2 API key
	 * @return list of guild info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Guild guild info
	 */
	public Guild getDetailedGuildInfo(String id, String api) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		try {
			Response<Guild> response = gw2API.getDetailedGuildInfo(id, api).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Guild Log

	/**
	 * For more info on guild log API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">here</a><br/>
	 * Get guild log info for the given guild id
	 *
	 * @param id  {@link Guild#id}
	 * @param api Guild leader's Guild Wars 2 API key
	 * @return list of guild log info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see GuildLog guild log info
	 */
	public List<GuildLog> getGuildLogInfo(String id, String api) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		try {
			Response<List<GuildLog>> response = gw2API.getGuildLogInfo(id, api).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on guild log API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">here</a><br/>
	 * filter out all log entries not newer than since
	 *
	 * @param id    {@link Guild#id}
	 * @param api   Guild leader's Guild Wars 2 API key
	 * @param since log id used to filter log entries
	 * @return list of guild log info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see GuildLog guild log info
	 */
	public List<GuildLog> getFilteredGuildLogInfo(String id, String api, int since) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		try {
			Response<List<GuildLog>> response = gw2API.getFilteredGuildLogInfo(id, api, Integer.toString(since)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Guild Members

	/**
	 * For more info on guild member API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/members">here</a><br/>
	 * Get guild member info for the given guild id
	 *
	 * @param id  {@link Guild#id}
	 * @param api Guild leader's Guild Wars 2 API key
	 * @return list of guild member info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see GuildMember guild member info
	 */
	public List<GuildMember> getGuildMembersInfo(String id, String api) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		try {
			Response<List<GuildMember>> response = gw2API.getGuildMemberInfo(id, api).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Guild Ranks

	/**
	 * For more info on guild rank API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/ranks">here</a><br/>
	 * Get guild rank info for the given guild id
	 *
	 * @param id  {@link Guild#id}
	 * @param api Guild leader's Guild Wars 2 API key
	 * @return list of guild rank info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see GuildRank guild rank info
	 */
	public List<GuildRank> getGuildRankInfo(String id, String api) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		try {
			Response<List<GuildRank>> response = gw2API.getGuildRankInfo(id, api).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Guild Stash

	/**
	 * For more info on guild stash API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/stash">here</a><br/>
	 * Get guild stash info for the given guild id
	 *
	 * @param id  {@link Guild#id}
	 * @param api Guild leader's Guild Wars 2 API key
	 * @return list of guild stash info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see GuildStash guild stash info
	 */
	public List<GuildStash> getGuildStashInfo(String id, String api) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		try {
			Response<List<GuildStash>> response = gw2API.getGuildStashInfo(id, api).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Guild Teams

	/**
	 * For more info on guild teams API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/teams">here</a><br/>
	 * Get guild team info for the given guild id
	 *
	 * @param id  {@link Guild#id}
	 * @param api Guild leader's Guild Wars 2 API key
	 * @return list of guild team info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see GuildTeam guild team info
	 */
	public List<GuildTeam> getGuildTeamsInfo(String id, String api) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		try {
			Response<List<GuildTeam>> response = gw2API.getGuildTeamsInfo(id, api).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Guild Treasury

	/**
	 * For more info on guild treasury API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/treasury">here</a><br/>
	 * Get guild treasury info for the given guild id
	 *
	 * @param id  {@link Guild#id}
	 * @param api Guild leader's Guild Wars 2 API key
	 * @return list of guild treasury info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see GuildTreasury guild treasury info
	 */
	public List<GuildTreasury> getGuildTreasuryInfo(String id, String api) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		try {
			Response<List<GuildTreasury>> response = gw2API.getGuildTreasuryInfo(id, api).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Guild Unlocked Upgrades

	/**
	 * For more info on guild unlocked upgrades API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/upgrades">here</a><br/>
	 * Get guild unlocked upgrades ids for the given guild id
	 *
	 * @param id  {@link Guild#id}
	 * @param api Guild leader's Guild Wars 2 API key
	 * @return list of unlocked upgrades ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Integer> getGuildUnlockedUpgradesID(String id, String api) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.GUILD, id), new ParamChecker(ParamType.API, api));
		try {
			Response<List<Integer>> response = gw2API.getGuildUpgradeIDs(id, api).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Guild Permissions

	/**
	 * For more info on guild permissions API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/permissions">here</a><br/>
	 * Get all guild permission id(s)
	 *
	 * @return list of guild permission id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see GuildPermission guild permission info
	 */
	public List<String> getAllGuildPermissionID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllGuildPermissionIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on guild permissions API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/permissions">here</a><br/>
	 * Get guild permission info for the given guild permission id(s)
	 *
	 * @param ids list of guild permission id
	 * @return list of guild permission info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see GuildPermission guild permission info
	 */
	public List<GuildPermission> getGuildPermissionInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<GuildPermission>> response = gw2API.getGuildPermissionInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Guild Search

	/**
	 * For more info on guild Search API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/search">here</a><br/>
	 *
	 * @param name guild name
	 * @return list of guild id(s) of guilds that have matching name
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<String> searchGuildID(String name) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.GUILD, name));
		try {
			Response<List<String>> response = gw2API.searchGuildID(name).execute();
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
	 * @see GuildUpgrade guild upgrade info
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
	 * @see GuildUpgrade guild upgrade info
	 */
	public List<GuildUpgrade> getGuildUpgradeInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<GuildUpgrade>> response = gw2API.getGuildUpgradeInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<Item>> response = gw2API.getItemInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<ItemStats>> response = gw2API.getItemStatInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Legends

	/**
	 * For more info on legends API go <a href="https://wiki.guildwars2.com/wiki/API:2/legends">here</a><br/>
	 * Get all legend id(s)
	 *
	 * @return list of legend info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Legend legend info
	 */
	public List<String> getAllLegendID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllLegendIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on legends API go <a href="https://wiki.guildwars2.com/wiki/API:2/legends">here</a><br/>
	 * Get legend info for the given legend id(s)
	 *
	 * @param ids list of legend id
	 * @return list of legend info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Legend legend info
	 */
	public List<Legend> getLegendInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Legend>> response = gw2API.getLegendInfo(processIds(ids)).execute();
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
			Response<List<MailCarrier>> response = gw2API.getMailCarrierInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Maps

	/**
	 * For more info on maps API go <a href="https://wiki.guildwars2.com/wiki/API:2/maps">here</a><br/>
	 * Get all map id(s)
	 *
	 * @return list of map info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see MailCarrier map info
	 */
	public List<Integer> getAllMapID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllMapIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on maps API go <a href="https://wiki.guildwars2.com/wiki/API:2/maps">here</a><br/>
	 * Get map info for the given map id(s)
	 *
	 * @param ids list of map id
	 * @return list of map info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see MapOverview map info
	 */
	public List<MapOverview> getMapInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<MapOverview>> response = gw2API.getMapInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<Mastery>> response = gw2API.getMasteryInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<MaterialCategory>> response = gw2API.getMaterialBankInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<Mini>> response = gw2API.getMiniInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Nodes

	/**
	 * For more info on nodes API go <a href="https://wiki.guildwars2.com/wiki/API:2/nodes">here</a><br/>
	 *
	 * @return list of nodes
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<String> getAllHomeInstanceNodeID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllHomeInstanceNodeIDs().execute();
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
			Response<List<Outfit>> response = gw2API.getOutfitInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Pets

	/**
	 * For more info on pets API go <a href="https://wiki.guildwars2.com/wiki/API:2/pets">here</a><br/>
	 * Get all pet id(s)
	 *
	 * @return list of pet id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Pet pet info
	 */
	public List<Integer> getAllPetID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllPetIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on pets API go <a href="https://wiki.guildwars2.com/wiki/API:2/pets">here</a><br/>
	 * Get pet info for the given pet id(s)
	 *
	 * @param ids list of pet id(s)
	 * @return list of pet info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Pet pet info
	 */
	public List<Pet> getPetInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Pet>> response = gw2API.getPetInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Professions

	/**
	 * For more info on professions API go <a href="https://wiki.guildwars2.com/wiki/API:2/professions">here</a><br/>
	 * Get all profession id(s)
	 *
	 * @return list of profession id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Profession profession info
	 */
	public List<String> getAllProfessionID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllProfessionIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on professions API go <a href="https://wiki.guildwars2.com/wiki/API:2/professions">here</a><br/>
	 * Get profession info for the given profession id(s)
	 *
	 * @param ids list of profession id(s)
	 * @return list of profession info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Profession Profession info
	 */
	public List<Profession> getProfessionInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Profession>> response = gw2API.getProfessionInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//PvP Amulets

	/**
	 * For more info on pvp amulets API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">here</a><br/>
	 * Get all amulet id(s)
	 *
	 * @return list of amulet id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see PvPAmulet amulet info
	 */
	public List<Integer> getAllPvPAmuletID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllPvPAmuletIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on pvp amulets API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">here</a><br/>
	 * Get amulet info for the given amulet id(s)
	 *
	 * @param ids list of amulet id(s)
	 * @return list of amulet info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see PvPAmulet amulet info
	 */
	public List<PvPAmulet> getPvPAmuletInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<PvPAmulet>> response = gw2API.getPvPAmuletInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//PvP Games

	/**
	 * For more info on pvp games API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">here</a><br/>
	 * Get all pvp game id(s)
	 *
	 * @param api Guild Wars 2 API key
	 * @return list of pvp game id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see PvPGame pvp game info
	 */
	public List<String> getAllPvPGameID(String api) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, api));
		try {
			Response<List<String>> response = gw2API.getAllPvPGameIDs(api).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on pvp games API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">here</a><br/>
	 * Get pvp game info for the given pvp game id(s)
	 *
	 * @param api Guild Wars 2 API key
	 * @param ids list of pvp game id(s)
	 * @return list of pvp game info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see PvPGame pvp game info
	 */
	public List<PvPGame> getPvPGameInfo(String api, String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, api), new ParamChecker(ids));
		try {
			Response<List<PvPGame>> response = gw2API.getPvPGameInfo(api, processIds(ids)).execute();
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
	 * @see PvPHero pvp hero info
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
	 * @see PvPHero pvp hero info
	 */
	public List<PvPHero> getPvPHeroInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<PvPHero>> response = gw2API.getPvPHeroInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//PvP Ranks

	/**
	 * For more info on pvp ranks API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">here</a><br/>
	 * Get all PvP rank id(s)
	 *
	 * @return list of PvP rank id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see PvPRank PvP rank info
	 */
	public List<Integer> getAllPvPRankID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllPvPRankIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on pvp ranks API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">here</a><br/>
	 * Get PvP rank info for the given PvP rank id(s)
	 *
	 * @param ids list of PvP rank id(s)
	 * @return list of PvP rank info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see PvPRank PvP rank info
	 */
	public List<PvPRank> getPvPRankInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<PvPRank>> response = gw2API.getPvPRankInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//PvP Seasons

	/**
	 * For more info on pvp season API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">here</a><br/>
	 * Get all pvp season id(s)
	 *
	 * @return list of pvp season id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see PvPSeason pvp season info
	 */
	public List<String> getAllPvPSeasonID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllPvPSeasonIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on pvp season API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">here</a><br/>
	 * Get pvp season info for the given pvp season id(s)
	 *
	 * @param ids list of pvp season id(s)
	 * @return list of pvp season info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see PvPSeason pvp season info
	 */
	public List<PvPSeason> getPvPSeasonInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<PvPSeason>> response = gw2API.getPvPSeasonInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//PvP Seasons LeaderBoard

	/**
	 * For more info on pvp season API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">here</a><br/>
	 * Get pvp season info for the given pvp season id(s)
	 *
	 * @param id     Season id
	 * @param type   ladder/legendary/guild
	 * @param region na/eu
	 * @return list of pvp season info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see PvPSeason pvp season info
	 */
	public List<PvPLeaderBoard> getPvPSeasonLeaderboardInfo(String id, String type, World.Region region) throws GuildWars2Exception {
		try {
			Response<List<PvPLeaderBoard>> response = gw2API.getPvPSeasonLeaderBoardInfo(id, type, region.name().toLowerCase()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//PvP Standings

	/**
	 * For more info on pvp standings API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/standings">here</a><br/>
	 *
	 * @param api Guild Wars 2 API key
	 * @return list of pvp standing info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see PvPStanding pvp standing info
	 */
	public List<PvPStanding> getPvPStandingInfo(String api) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, api));
		try {
			Response<List<PvPStanding>> response = gw2API.getPvPStandingInfo(api).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//PvP Stats

	/**
	 * For more info on pvp stat API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/stats">here</a><br/>
	 *
	 * @param api Guild Wars 2 API key
	 * @return list of pvp stat info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see PvPStat pvp stat info
	 */
	public PvPStat getPvPStatInfo(String api) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, api));
		try {
			Response<PvPStat> response = gw2API.getPvPStatInfo(api).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Quaggans

	/**
	 * For more info on quaggans API go <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">here</a><br/>
	 *
	 * @return list of quaggan id
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<String> getAllQuagganID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllQuagganIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on quaggans API go <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">here</a><br/>
	 *
	 * @param ids list of quaggan id(s)
	 * @return list of map of id and url
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Map<String, String>> getQuagganInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Map<String, String>>> response = gw2API.getQuagganInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Races

	/**
	 * For more info on races API go <a href="https://wiki.guildwars2.com/wiki/API:2/races">here</a><br/>
	 * Get all raid id(s)
	 *
	 * @return list of raid id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Raid raid info
	 */
	public List<String> getAllRaceID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllRaceIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on races API go <a href="https://wiki.guildwars2.com/wiki/API:2/races">here</a><br/>
	 * Get race info for the given race id(s)
	 *
	 * @param ids list of race id(s)
	 * @return list of race info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Race race info
	 */
	public List<Race> getRaceInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Race>> response = gw2API.getRaceInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<Raid>> response = gw2API.getRaidInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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

	//Skills

	/**
	 * For more info on Skills API go <a href="https://wiki.guildwars2.com/wiki/API:2/skills">here</a><br/>
	 * Get list of all available skill ids
	 *
	 * @return list of skill ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Skill skill info
	 */
	public List<Integer> getAllSkillID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllSkillIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Skills API go <a href="https://wiki.guildwars2.com/wiki/API:2/skills">here</a><br/>
	 * Get skill info for the given skill id(s)
	 *
	 * @param ids list of skill id
	 * @return list of skill info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Skill skill info
	 */
	public List<Skill> getSkillInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Skill>> response = gw2API.getSkillInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<Skin>> response = gw2API.getSkinInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Specializations

	/**
	 * For more info on specializations API go <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">here</a><br/>
	 * Get all specialization id(s)
	 *
	 * @return list of specialization id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Specialization specialization info
	 */
	public List<Integer> getAllSpecializationID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllSpecializationIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on specializations API go <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">here</a><br/>
	 * Get specialization info for the specialization title id(s)
	 *
	 * @param ids list of specialization id(s)
	 * @return list of specialization info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Specialization specialization info
	 */
	public List<Specialization> getSpecializationInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Specialization>> response = gw2API.getSpecializationInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Stories

	/**
	 * For more info on stories API go <a href="https://wiki.guildwars2.com/wiki/API:2/stories">here</a><br/>
	 * Get all story id(s)
	 *
	 * @return list of story id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Story story info
	 */
	public List<Integer> getAllStoryID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllStoryIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on stories API go <a href="https://wiki.guildwars2.com/wiki/API:2/stories">here</a><br/>
	 * Get story info for the given story id(s)
	 *
	 * @param ids list of story id(s)
	 * @return list of story info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Story story info
	 */
	public List<Story> getStoryInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Story>> response = gw2API.getStoryInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Stories Seasons

	/**
	 * For more info on stories seasons API go <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">here</a><br/>
	 * Get all story season id(s)
	 *
	 * @return list of story season id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see StorySeason story season info
	 */
	public List<String> getAllStorySeasonID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllStorySeasonIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on stories seasons API go <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">here</a><br/>
	 * Get story season info for the given story season id(s)
	 *
	 * @param ids list of story season id(s)
	 * @return list of story season info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see StorySeason story season info
	 */
	public List<StorySeason> getStorySeasonInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<StorySeason>> response = gw2API.getStorySeasonInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<Title>> response = gw2API.getTitleInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//Trait

	/**
	 * For more info on traits API go <a href="https://wiki.guildwars2.com/wiki/API:2/traits">here</a><br/>
	 * Get list of all available trait id(s)
	 *
	 * @return list of trait id
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Trait trait info
	 */
	public List<Integer> getAllTraitID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllTraitIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on traits API go <a href="https://wiki.guildwars2.com/wiki/API:2/traits">here</a><br/>
	 * Get trait info for the given trait id(s)
	 *
	 * @param ids list of trait id
	 * @return list of trait info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Trait trait info
	 */
	public List<Trait> getTraitInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<Trait>> response = gw2API.getTraitInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
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
			Response<List<World>> response = gw2API.getWorldsInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//WvW Abilities

	/**
	 * For more info on WvW abilities API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">here</a><br/>
	 * Get list of all available wvw ability id(s)
	 *
	 * @return list of wvw ability id
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see WvWAbility wvw ability info
	 */
	public List<Integer> getAllWvWAbilityID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllWvWAbilityIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on WvW abilities API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">here</a><br/>
	 * Get wvw ability info for the given ability id(s)
	 *
	 * @param ids list of wvw ability id
	 * @return list of wvw ability info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see WvWAbility wvw ability info
	 */
	public List<WvWAbility> getWvWAbilityInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<WvWAbility>> response = gw2API.getWvWAbilityInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//WvW Matches

	/**
	 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Get list of all available wvw match id(s)
	 *
	 * @return list of wvw match id
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see WvWMatch wvw match info
	 */
	public List<String> getAllWvWMatchID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllWvWMatchIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Get wvw match info using world id
	 *
	 * @param worldID {@link World#id}
	 * @param type    endpoint type
	 * @return wvw match info, exact class depend on endpoint type
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see WvWMatch wvw match info
	 */
	public WvWMatch getWvWMatchInfo(int worldID, WvWMatch.Endpoint type) throws GuildWars2Exception {
		if (type == null) return getWvWMatchInfoUsingWorld(worldID);
		try {
			switch (type) {
				case All:
					return getWvWMatchInfoUsingWorld(worldID);
				case Overview:
					Response<WvWMatchOverview> overview = gw2API.getWvWMatchOverviewUsingWorld(Integer.toString(worldID)).execute();
					if (!overview.isSuccessful()) throwError(overview.code(), overview.errorBody());
					return overview.body();
				case Stat:
					Response<WvWMatchStat> stat = gw2API.getWvWMatchStatUsingWorld(Integer.toString(worldID)).execute();
					if (!stat.isSuccessful()) throwError(stat.code(), stat.errorBody());
					return stat.body();
				case Score:
					Response<WvWMatchScore> score = gw2API.getWvWMatchScoreUsingWorld(Integer.toString(worldID)).execute();
					if (!score.isSuccessful()) throwError(score.code(), score.errorBody());
					return score.body();
				default:
					return getWvWMatchInfoUsingWorld(worldID);
			}
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Get wvw match info using wvw match id(s)
	 *
	 * @param ids  list of wvw match id(s)
	 * @param type endpoint type
	 * @return list of wvw match info, exact class depend on endpoint type
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see WvWMatch wvw match info
	 */
	public List<? extends WvWMatch> getWvWMatchInfo(String[] ids, WvWMatch.Endpoint type) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		if (type == null) return getWvWMatchInfoUsingID(ids);
		try {
			switch (type) {
				case All:
					return getWvWMatchInfoUsingID(ids);
				case Overview:
					Response<List<WvWMatchOverview>> overview = gw2API.getWvWMatchOverviewUsingID(processIds(ids)).execute();
					if (!overview.isSuccessful()) throwError(overview.code(), overview.errorBody());
					return overview.body();
				case Score:
					Response<List<WvWMatchScore>> stat = gw2API.getWvWMatchScoreUsingID(processIds(ids)).execute();
					if (!stat.isSuccessful()) throwError(stat.code(), stat.errorBody());
					return stat.body();
				case Stat:
					Response<List<WvWMatchStat>> score = gw2API.getWvWMatchStatUsingID(processIds(ids)).execute();
					if (!score.isSuccessful()) throwError(score.code(), score.errorBody());
					return score.body();
				default:
					return getWvWMatchInfoUsingID(ids);
			}
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//for getWvWMatchInfo(String[], WvWMatch.Endpoint)
	private WvWMatchDetail getWvWMatchInfoUsingWorld(int worldID) throws GuildWars2Exception {
		try {
			Response<WvWMatchDetail> response = gw2API.getWvWMatchInfoUsingWorld(Integer.toString(worldID)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//for getWvWMatchInfo(int, WvWMatch.Endpoint)
	private List<WvWMatchDetail> getWvWMatchInfoUsingID(String[] ids) throws GuildWars2Exception {
		try {
			Response<List<WvWMatchDetail>> response = gw2API.getWvWMatchInfoUsingID(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//WvW Objectives

	/**
	 * For more info on WvW objectives API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">here</a><br/>
	 * Get list of all available wvw objective id(s)
	 *
	 * @return list of wvw objective id
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see WvWObjective wvw objective info
	 */
	public List<String> getAllWvWObjectiveID() throws GuildWars2Exception {
		try {
			Response<List<String>> response = gw2API.getAllWvWObjectiveIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on WvW objectives API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">here</a><br/>
	 * Get wvw objective info for the given objective id(s)
	 *
	 * @param ids list of wvw objective id
	 * @return list of wvw objective info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see WvWObjective wvw objective info
	 */
	public List<WvWObjective> getWvWObjectiveInfo(String[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<WvWObjective>> response = gw2API.getWvWObjectiveInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//WvW Ranks

	/**
	 * For more info on WvW ranks API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">here</a><br/>
	 * Get list of all available wvw rank id(s)
	 *
	 * @return list of wvw rank id
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see WvWRank wvw rank info
	 */
	public List<Integer> getAllWvWRankID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllWvWRankIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on WvW ranks API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">here</a><br/>
	 * Get wvw rank info for the given rank id(s)
	 *
	 * @param ids list of wvw rank id
	 * @return list of wvw rank info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see WvWRank wvw rank info
	 */
	public List<WvWRank> getWvWRankInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<WvWRank>> response = gw2API.getWvWRankInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//WvW Upgrades

	/**
	 * For more info on WvW upgrades API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">here</a><br/>
	 * Get list of all available wvw upgrade id(s)
	 *
	 * @return list of wvw upgrade id
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see WvWUpgrade wvw upgrade info
	 */
	public List<Integer> getAllWvWUpgradeID() throws GuildWars2Exception {
		try {
			Response<List<Integer>> response = gw2API.getAllWvWUpgradeIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on WvW upgrades API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">here</a><br/>
	 * Get wvw upgrade info for the given upgrade id(s)
	 *
	 * @param ids list of wvw upgrade id
	 * @return list of wvw upgrade info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see WvWUpgrade wvw upgrade info
	 */
	public List<WvWUpgrade> getWvWUpgradeInfo(int[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ids));
		try {
			Response<List<WvWUpgrade>> response = gw2API.getWvWUpgradeInfo(processIds(ids), GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}
}
