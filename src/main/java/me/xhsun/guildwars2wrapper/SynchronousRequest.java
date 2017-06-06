package me.xhsun.guildwars2wrapper;

import me.xhsun.guildwars2wrapper.error.ErrorCode;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.*;
import me.xhsun.guildwars2wrapper.model.account.*;
import me.xhsun.guildwars2wrapper.model.character.CharacterInventory;
import me.xhsun.guildwars2wrapper.model.character.Core;
import me.xhsun.guildwars2wrapper.model.commerce.Prices;
import me.xhsun.guildwars2wrapper.model.commerce.Transaction;
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
	 * TODO /v2/dungeons
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
	 */
	public List<Long> getUnlockedDyes(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Long>> response = gw2API.getUnlockedDyes(API).execute();
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
	 * TODO /v2/gliders
	 *
	 * @param API API key
	 * @return list of gliders id
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Long> getUnlockedGliders(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Long>> response = gw2API.getUnlockedGliders(API).execute();
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
	 * TODO /v2/mailcarriers
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
	 */
	public List<Long> getUnlockedMinis(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Long>> response = gw2API.getUnlockedMinis(API).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on account outfits API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/outfits">here</a><br/>
	 * Get list of unlocked outfit id(s) linked to given API key
	 * TODO /v2/outfits
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
	 * TODO /v2/pvp/heroes
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
	 * TODO /v2/raids
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
	 * For more info on Account/Skins API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/skins">here</a><br/>
	 * Get list of unlocked skin ids linked to given API key
	 *
	 * @param API API key
	 * @return list of ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Long> getUnlockedSkins(String API) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.API, API));
		try {
			Response<List<Long>> response = gw2API.getUnlockedSkins(API).execute();
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

	/**
	 * For more info on Character API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 * Get all character names linked to given API key
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
	 * For more info on Character Core API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Core">here</a><br/>
	 * Get character information for the given character name that is linked to given API key
	 *
	 * @param API  API key
	 * @param name name of character
	 * @return character detail
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Core character info
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
	 * For more info on Character Inventory API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Inventory">here</a><br/>
	 * Get inventory info for the given character that is linked to given API key
	 *
	 * @param API  API key
	 * @param name name of character to get inventory info
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
	public List<Long> getAllListedItemID() throws GuildWars2Exception {
		try {
			Response<List<Long>> response = gw2API.getAllPrices().execute();
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
	public List<Prices> getPrices(long[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.ID, ids));
		try {
			Response<List<Prices>> response = gw2API.getPrices(processIds(ids)).execute();
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
	public List<Currency> getCurrencyInfo(long[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.ID, ids));
		try {
			Response<List<Currency>> response = gw2API.getCurrencyInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Currency API go <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">here</a><br/>
	 * Get all currency ids
	 *
	 * @return list of currency ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Currency currency info
	 */
	public List<Long> getAllCurrencyID() throws GuildWars2Exception {
		try {
			Response<List<Long>> response = gw2API.getAllCurrencies().execute();
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
	public List<World> getWorldInfo(long[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.ID, ids));
		try {
			Response<List<World>> response = gw2API.getWorldsInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

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
	 * For more info on Material Category API go <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
	 * Get material category info for the given category id(s)
	 *
	 * @param ids list of category id
	 * @return list of material category info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see MaterialCategory material category info
	 */
	public List<MaterialCategory> getMaterialCategoryInfo(long[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.ID, ids));
		try {
			Response<List<MaterialCategory>> response = gw2API.getMaterialBankInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Material Category API go <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
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
	 * For more info on Skin API go <a href="https://wiki.guildwars2.com/wiki/API:2/skins">here</a><br/>
	 * Get skin info for the given skin id(s)
	 *
	 * @param ids list of skin id
	 * @return list of skin info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Skin skin info
	 */
	public List<Skin> getSkinInfo(long[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.ID, ids));
		try {
			Response<List<Skin>> response = gw2API.getSkinInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Skin API go <a href="https://wiki.guildwars2.com/wiki/API:2/skins">here</a><br/>
	 * Get list of all available skin ids
	 *
	 * @return list of skin ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Skin skin info
	 */
	public List<Long> getAllSkinID() throws GuildWars2Exception {
		try {
			Response<List<Long>> response = gw2API.getAllSkinIDs().execute();
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
	public List<Item> getItemInfo(long[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.ID, ids));
		try {
			Response<List<Item>> response = gw2API.getItemInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Item API go <a href="https://wiki.guildwars2.com/wiki/API:2/items">here</a><br/>
	 * Get all available item ids
	 *
	 * @return list of item ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Item item info
	 */
	public List<Long> getAllItemID() throws GuildWars2Exception {
		try {
			Response<List<Long>> response = gw2API.getAllItemIDs().execute();
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
	public List<ItemStats> getItemStatInfo(long[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.ID, ids));
		try {
			Response<List<ItemStats>> response = gw2API.getItemStatInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Itemstat API go <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
	 * Get all available itemstat ids
	 *
	 * @return list of itemstat ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see ItemStats itemstat info
	 */
	public List<Long> getAllItemStatID() throws GuildWars2Exception {
		try {
			Response<List<Long>> response = gw2API.getAllItemStatIDs().execute();
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
	public List<Color> getColorInfo(long[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.ID, ids));
		try {
			Response<List<Color>> response = gw2API.getColorInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Color API go <a href="https://wiki.guildwars2.com/wiki/API:2/colors">here</a><br/>
	 * Get list of all available color id(s)
	 *
	 * @return list of color id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Color color info
	 */
	public List<Long> getAllColorID() throws GuildWars2Exception {
		try {
			Response<List<Long>> response = gw2API.getAllColorIDs().execute();
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
	public List<Recipe> getRecipeInfo(long[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.ID, ids));
		try {
			Response<List<Recipe>> response = gw2API.getRecipeInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Recipes API go <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">here</a><br/>
	 * Get list of all available recipe id(s)
	 *
	 * @return list of recipe ids(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Recipe recipe info
	 */
	public List<Long> getAllRecipeID() throws GuildWars2Exception {
		try {
			Response<List<Long>> response = gw2API.getAllRecipeIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Recipes search API go <a href="https://wiki.guildwars2.com/wiki/API:2/recipes/search">here</a><br/>
	 *
	 * @param isInput is given id an ingredient
	 * @param id      recipe id
	 * @return list of recipe id
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Long> searchRecipes(boolean isInput, long id) throws GuildWars2Exception {
		try {
			Response<List<Long>> response = (isInput) ?
					gw2API.searchInputRecipes(Long.toString(id)).execute() :
					gw2API.searchOutputRecipes(Long.toString(id)).execute();
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
	public List<Mini> getMiniInfo(long[] ids) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.ID, ids));
		try {
			Response<List<Mini>> response = gw2API.getMiniInfo(processIds(ids)).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on Mini API go <a href="https://wiki.guildwars2.com/wiki/API:2/minis">here</a><br/>
	 * Get list of all available mini id(s)
	 *
	 * @return list of mini id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see Mini mini info
	 */
	public List<Long> getAllMiniID() throws GuildWars2Exception {
		try {
			Response<List<Long>> response = gw2API.getAllMiniIDs().execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}
}
