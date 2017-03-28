package xhsun.gw2api.guildwars2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import xhsun.gw2api.guildwars2.model.account.Account;
import xhsun.gw2api.guildwars2.model.account.Bank;
import xhsun.gw2api.guildwars2.model.account.Material;
import xhsun.gw2api.guildwars2.model.account.SharedInventory;
import xhsun.gw2api.guildwars2.model.account.Wallet;
import xhsun.gw2api.guildwars2.model.character.CharacterInventory;
import xhsun.gw2api.guildwars2.model.Currency;
import xhsun.gw2api.guildwars2.model.Item;
import xhsun.gw2api.guildwars2.model.MaterialCategory;
import xhsun.gw2api.guildwars2.model.Skin;
import xhsun.gw2api.guildwars2.model.World;
import xhsun.gw2api.guildwars2.model.TokenInfo;
import xhsun.gw2api.guildwars2.model.character.Core;
import xhsun.gw2api.guildwars2.model.commerce.Prices;
import xhsun.gw2api.guildwars2.model.commerce.Transaction;
import xhsun.gw2api.guildwars2.model.ItemStats;

/**
 * API interface for different calls
 * @author xhsun
 * @since 2017-02-07
 */

interface GuildWars2RetrofitInterface {

	//For get account info
	@GET("/v2/account")
	Call<Account> getAccount(@Query("access_token") String token);

	@GET("/v2/account/bank")
	Call<List<Bank>> getBank(@Query("access_token") String token);

	@GET("/v2/account/inventory")
	Call<List<SharedInventory>> getSharedInventory(@Query("access_token") String token);

	@GET("/v2/account/wallet")
	Call<List<Wallet>> getWallet(@Query("access_token") String token);

	@GET("/v2/account/materials")
	Call<List<Material>> getMaterialBank(@Query("access_token") String token);

	//For get character info
	@GET("/v2/characters")
	Call<List<String>> getAllCharacterName(@Query("access_token") String token);

	@GET("/v2/characters/{name}/core")
	Call<Core> getCharacterCore(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/inventory")
	Call<CharacterInventory> getCharacterInventory(@Path("name") String name, @Query("access_token") String token);

	//For TP info
	@GET("/v2/commerce/transactions/{time}/{type}")
	Call<List<Transaction>> getListing(@Path("time") String time, @Path("type") String type, @Query("access_token") String token);

	@GET("/v2/commerce/prices")
	Call<List<Long>> getAllPrices();

	@GET("/v2/commerce/prices")
	Call<List<Prices>> getPrices(@Query("ids") String ids);

	//For other misc items
	@GET("/v2/tokeninfo")
	Call<TokenInfo> getAPIInfo(@Query("access_token") String token);

	@GET("/v2/currencies")
	Call<List<Currency>> getCurrencyInfo(@Query("ids") String ids);

	@GET("/v2/worlds")
	Call<List<World>> getWorldsInfo(@Query("ids") String ids);

	@GET("/v2/materials")
	Call<List<MaterialCategory>> getMaterialBankInfo(@Query("ids") String ids);

	@GET("/v2/skins")
	Call<List<Skin>> getSkinInfo(@Query("ids") String ids);

	@GET("/v2/items")
	Call<List<Item>> getItemInfo(@Query("ids") String ids);

	@GET("/v2/itemstats")
	Call<List<ItemStats>> getItemStatInfo(@Query("ids") String ids);
}
