package me.xhsun.guildwars2wrapper;

import me.xhsun.guildwars2wrapper.model.*;
import me.xhsun.guildwars2wrapper.model.account.*;
import me.xhsun.guildwars2wrapper.model.character.CharacterInventory;
import me.xhsun.guildwars2wrapper.model.character.Core;
import me.xhsun.guildwars2wrapper.model.commerce.Prices;
import me.xhsun.guildwars2wrapper.model.commerce.Transaction;
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
	//get account info
	@GET("/v2/account")
	Call<Account> getAccount(@Query("access_token") String token);

	@GET("/v2/account/bank")
	Call<List<Bank>> getBank(@Query("access_token") String token);

	@GET("/v2/account/inventory")
	Call<List<SharedInventory>> getSharedInventory(@Query("access_token") String token);

	@GET("/v2/account/wallet")
	Call<List<Wallet>> getWallet(@Query("access_token") String token);

	@GET("/v2/account/skins")
	Call<List<Long>> getUnlockedSkins(@Query("access_token") String token);

	@GET("/v2/account/materials")
	Call<List<Material>> getMaterialBank(@Query("access_token") String token);

	//get character info
	@GET("/v2/characters")
	Call<List<String>> getAllCharacterName(@Query("access_token") String token);

	@GET("/v2/characters/{name}/core")
	Call<Core> getCharacterCore(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/inventory")
	Call<CharacterInventory> getCharacterInventory(@Path("name") String name, @Query("access_token") String token);

	//TP info
	@GET("/v2/commerce/transactions/{time}/{type}")
	Call<List<Transaction>> getListing(@Path("time") String time, @Path("type") String type, @Query("access_token") String token);

	@GET("/v2/commerce/prices")
	Call<List<Long>> getAllPrices();

	@GET("/v2/commerce/prices")
	Call<List<Prices>> getPrices(@Query("ids") String ids);

	//other info
	@GET("/v2/tokeninfo")
	Call<TokenInfo> getAPIInfo(@Query("access_token") String token);

	@GET("/v2/currencies")
	Call<List<Long>> getAllCurrencies();

	@GET("/v2/currencies")
	Call<List<Currency>> getCurrencyInfo(@Query("ids") String ids);

	@GET("/v2/worlds")
	Call<List<World>> getWorldsInfo(@Query("ids") String ids);

	@GET("/v2/materials")
	Call<List<MaterialCategory>> getMaterialBankInfo(@Query("ids") String ids);

	@GET("/v2/skins")
	Call<List<Skin>> getSkinInfo(@Query("ids") String ids);

	@GET("/v2/items")
	Call<List<Long>> getAllItemIDs();

	@GET("/v2/items")
	Call<List<Item>> getItemInfo(@Query("ids") String ids);

	@GET("/v2/itemstats")
	Call<List<Long>> getAllItemStatIDs();

	@GET("/v2/itemstats")
	Call<List<ItemStats>> getItemStatInfo(@Query("ids") String ids);
}
