package me.xhsun.guildwars2wrapper;

import me.xhsun.guildwars2wrapper.model.*;
import me.xhsun.guildwars2wrapper.model.account.*;
import me.xhsun.guildwars2wrapper.model.achievements.Achievement;
import me.xhsun.guildwars2wrapper.model.character.CharacterInventory;
import me.xhsun.guildwars2wrapper.model.character.Core;
import me.xhsun.guildwars2wrapper.model.commerce.Prices;
import me.xhsun.guildwars2wrapper.model.commerce.Transaction;
import me.xhsun.guildwars2wrapper.model.unlockable.Finisher;
import me.xhsun.guildwars2wrapper.model.unlockable.Glider;
import me.xhsun.guildwars2wrapper.model.unlockable.MailCarrier;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * API interface for different calls
 *
 * @author xhsun
 * @since 2017-02-07
 */
interface GuildWars2API {
	//accounts
	@GET("/v2/account")
	Call<Account> getAccount(@Query("access_token") String token);

	@GET("/v2/account/achievements")
	Call<List<AchievementProgression>> getAchievementProgression(@Query("access_token") String token);

	@GET("/v2/account/bank")
	Call<List<Bank>> getBank(@Query("access_token") String token);

	@GET("/v2/account/dungeons")
	Call<List<String>> getDailyDungeonProgression(@Query("access_token") String token);

	@GET("/v2/account/dyes")
	Call<List<Integer>> getUnlockedDyes(@Query("access_token") String token);

	@GET("/v2/account/finishers")
	Call<List<UnlockedFinisher>> getUnlockedFinishers(@Query("access_token") String token);

	@GET("/v2/account/gliders")
	Call<List<Integer>> getUnlockedGliders(@Query("access_token") String token);

	@GET("/v2/account/home/cats")
	Call<List<Cat>> getUnlockedCats(@Query("access_token") String token);

	@GET("/v2/account/home/nodes")
	Call<List<String>> getUnlockedHomeNodes(@Query("access_token") String token);

	@GET("/v2/account/inventory")
	Call<List<SharedInventory>> getSharedInventory(@Query("access_token") String token);

	@GET("/v2/account/mailcarriers")
	Call<List<Integer>> getUnlockedMailCarriers(@Query("access_token") String token);

	@GET("/v2/account/masteries")
	Call<List<UnlockedMastery>> getUnlockedMasteries(@Query("access_token") String token);

	@GET("/v2/account/materials")
	Call<List<Material>> getMaterialBank(@Query("access_token") String token);

	@GET("/v2/account/minis")
	Call<List<Integer>> getUnlockedMinis(@Query("access_token") String token);

	@GET("/v2/account/outfits")
	Call<List<Integer>> getUnlockedOutfits(@Query("access_token") String token);

	@GET("/v2/account/pvp/heroes")
	Call<List<Integer>> getUnlockedPvpHeroes(@Query("access_token") String token);

	@GET("/v2/account/raids")
	Call<List<String>> getWeeklyRaidProgression(@Query("access_token") String token);

	@GET("/v2/account/recipes")
	Call<List<Integer>> getUnlockedRecipes(@Query("access_token") String token);

	@GET("/v2/account/skins")
	Call<List<Integer>> getUnlockedSkins(@Query("access_token") String token);

	@GET("/v2/account/titles")
	Call<List<Integer>> getUnlockedTitles(@Query("access_token") String token);

	@GET("/v2/account/wallet")
	Call<List<Wallet>> getWallet(@Query("access_token") String token);

	//achievements
	@GET("/v2/achievements")
	Call<List<Integer>> getAllAchievementIDs();

	@GET("/v2/achievements")
	Call<List<Achievement>> getAchievementInfo(@Query("ids") String ids);

	//characters
	@GET("/v2/characters")
	Call<List<String>> getAllCharacterName(@Query("access_token") String token);

	@GET("/v2/characters/{name}/core")
	Call<Core> getCharacterCore(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/inventory")
	Call<CharacterInventory> getCharacterInventory(@Path("name") String name, @Query("access_token") String token);

	//colors
	@GET("/v2/colors")
	Call<List<Integer>> getAllColorIDs();

	@GET("/v2/colors")
	Call<List<Color>> getColorInfo(@Query("ids") String ids);

	//TP
	@GET("/v2/commerce/transactions/{time}/{type}")
	Call<List<Transaction>> getListing(@Path("time") String time, @Path("type") String type, @Query("access_token") String token);

	@GET("/v2/commerce/prices")
	Call<List<Integer>> getAllPrices();

	@GET("/v2/commerce/prices")
	Call<List<Prices>> getPrices(@Query("ids") String ids);

	//currencies
	@GET("/v2/currencies")
	Call<List<Integer>> getAllCurrencies();

	@GET("/v2/currencies")
	Call<List<Currency>> getCurrencyInfo(@Query("ids") String ids);

	//dungeons
	@GET("/v2/dungeons")
	Call<List<String>> getAllDungeonName();

	@GET("/v2/dungeons")
	Call<List<Dungeon>> getDungeonInfo(@Query("ids") String ids);

	//Finishers
	@GET("/v2/finishers")
	Call<List<Integer>> getAllFinisherIDs();

	@GET("/v2/finishers")
	Call<List<Finisher>> getFinisherInfo(@Query("ids") String ids);

	//Gliders
	@GET("/v2/gliders")
	Call<List<Integer>> getAllGliderIDs();

	@GET("/v2/gliders")
	Call<List<Glider>> getGliderInfo(@Query("ids") String ids);

	//items
	@GET("/v2/items")
	Call<List<Integer>> getAllItemIDs();

	@GET("/v2/items")
	Call<List<Item>> getItemInfo(@Query("ids") String ids);

	//item stat
	@GET("/v2/itemstats")
	Call<List<Integer>> getAllItemStatIDs();

	@GET("/v2/itemstats")
	Call<List<ItemStats>> getItemStatInfo(@Query("ids") String ids);

	//mail carriers
	@GET("/v2/mailcarriers")
	Call<List<Integer>> getAllMailCarrierIDs();

	@GET("/v2/mailcarriers")
	Call<List<MailCarrier>> getMailCarrierInfo(@Query("ids") String ids);

	//masteries
	@GET("/v2/masteries")
	Call<List<Integer>> getAllMasteryIDs();

	@GET("/v2/masteries")
	Call<List<Mastery>> getMasteryInfo(@Query("ids") String ids);

	//material categories
	@GET("/v2/materials")
	Call<List<Integer>> getAllMaterialBankIDs();

	@GET("/v2/materials")
	Call<List<MaterialCategory>> getMaterialBankInfo(@Query("ids") String ids);

	//minis
	@GET("/v2/minis")
	Call<List<Integer>> getAllMiniIDs();

	@GET("/v2/minis")
	Call<List<Mini>> getMiniInfo(@Query("ids") String ids);

	//skins
	@GET("/v2/skins")
	Call<List<Integer>> getAllSkinIDs();

	@GET("/v2/skins")
	Call<List<Skin>> getSkinInfo(@Query("ids") String ids);

	//recipes
	@GET("/v2/recipes")
	Call<List<Integer>> getAllRecipeIDs();

	@GET("/v2/recipes")
	Call<List<Recipe>> getRecipeInfo(@Query("ids") String ids);

	//recipes search
	@GET("/v2/recipes/search")
	Call<List<Integer>> searchInputRecipes(@Query("input") String id);

	@GET("/v2/recipes/search")
	Call<List<Integer>> searchOutputRecipes(@Query("output") String id);

	//token info
	@GET("/v2/tokeninfo")
	Call<TokenInfo> getAPIInfo(@Query("access_token") String token);

	//worlds
	@GET("/v2/worlds")
	Call<List<Integer>> getAllWorldsIDs();

	@GET("/v2/worlds")
	Call<List<World>> getWorldsInfo(@Query("ids") String ids);
}
