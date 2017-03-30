package xhsun.gw2api.guildwars2;

import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xhsun.gw2api.guildwars2.model.*;
import xhsun.gw2api.guildwars2.model.account.*;
import xhsun.gw2api.guildwars2.model.character.CharacterInventory;
import xhsun.gw2api.guildwars2.model.character.Core;
import xhsun.gw2api.guildwars2.model.commerce.Prices;
import xhsun.gw2api.guildwars2.model.commerce.Transaction;
import xhsun.gw2api.guildwars2.model.util.Bag;
import xhsun.gw2api.guildwars2.err.ErrorCode;
import xhsun.gw2api.guildwars2.err.ErrorResponse;
import xhsun.gw2api.guildwars2.err.GuildWars2Exception;

import java.io.IOException;
import java.util.List;

/**
 * For more Info on GW2 API Version 2 go <a href="https://wiki.guildwars2.com/wiki/API:2">here</a><br/>
 * Guild Wars 2 API Wrapper uses {@link Retrofit} to connect to Guild wars 2 API server<br/>
 * This class provides two ways user can get and process data from the server:<br/>
 * &#32;1) get&#60;name&#62;: return the class containing all the info with regards to &#60;name&#62;<br/>
 * &#32;2) &#60;name&#62;Processor: user can give a custom {@link Callback} to define their own actions<br/><br/>
 * Note: Resulting object from calling the constructor can be used multiple times and creating {@link Retrofit}
 * can be expensive, so it is advised to store the GuildWars object somewhere for repeated use<br/>
 * @author xhsun
 * @since 2017-02-06
 */

public class GuildWars2 {
	private static final String API = "https://api.guildwars2.com";
	private static volatile GuildWars2 instance=null;
	private GuildWars2RetrofitInterface gw2API;

	/**
	 * This class is singleton to reduce the potential need to repeatably create new retrofit object
	 * @return instance of GuildWars2
	 */
	public static GuildWars2 getInstance(){
		if (instance==null) instance=new GuildWars2();
		return instance;
	}

	//constructor
	private GuildWars2(){
		Retrofit retrofit=new Retrofit.Builder()
				.baseUrl(API)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		gw2API=retrofit.create(GuildWars2RetrofitInterface.class);
	}

	/**
	 * For more info on TokenInfo API go <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">here</a><br/>
	 * Get detailed info related to this API key from server
	 * @see TokenInfo API info
	 * @param API API key
	 * @return API info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public TokenInfo getAPIInfo(String API) throws GuildWars2Exception{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		try {
			Response<TokenInfo> response = gw2API.getAPIInfo(API).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Account API go <a href="https://wiki.guildwars2.com/wiki/API:2/account">here</a><br/>
	 * Get detailed info for account link to given API key
	 * @see Account Account info
	 * @param API API key
	 * @return account info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public Account getAccount(String API) throws GuildWars2Exception{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		try {
			Response<Account> response = gw2API.getAccount(API).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Bank API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/bank">here</a><br/>
	 * Get detailed info for bank linked to given API key
	 * @see Bank Bank info
	 * @param API API key
	 * @return bank info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Bank> getBank(String API) throws GuildWars2Exception {
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		try {
			Response<List<Bank>> response = gw2API.getBank(API).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Shared Inventory API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/inventory">here</a><br/>
	 * Get detailed info for shared inventory linked to given API key
	 * @see SharedInventory shared inventory info
	 * @param API API key
	 * @return share inventory info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<SharedInventory> getSharedInventory(String API) throws GuildWars2Exception {
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		try {
			Response<List<SharedInventory>> response = gw2API.getSharedInventory(API).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Wallet API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/wallet">here</a><br/>
	 * Get detailed info for wallet linked to given API key
	 * @see Wallet wallet info
	 * @param API API key
	 * @return wallet info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Wallet> getWallet(String API) throws GuildWars2Exception{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		try {
			Response<List<Wallet>> response = gw2API.getWallet(API).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Material Storage API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/materials">here</a><br/>
	 * Get detailed info for material storage linked to given API key
	 * @see Material material storage info
	 * @param API API key
	 * @return material storage info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Material> getMaterialStorage(String API) throws GuildWars2Exception{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		try {
			Response<List<Material>> response = gw2API.getMaterialBank(API).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Character API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 * Get all character names linked to given API key
	 * @param API API key
	 * @return list of character name
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<String> getAllCharacterName(String API) throws GuildWars2Exception{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		try {
			Response<List<String>> response = gw2API.getAllCharacterName(API).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Character Core API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Core">here</a><br/>
	 * Get character information for the given character name that is linked to given API key
	 * @see Core character info
	 * @param API API key
	 * @param name name of character
	 * @return character detail
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public Core getCharacterInformation(String API, String name) throws GuildWars2Exception{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		if (name==null || name.equals(""))
			throw new GuildWars2Exception(ErrorCode.Character, "Character name cannot be empty");
		try{
			Response<Core> response = gw2API.getCharacterCore(name, API).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}

	}

	/**
	 * For more info on Character Inventory API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Inventory">here</a><br/>
	 * Get inventory info for the given character that is linked to given API key
	 * @see Bag character inventory info
	 * @param API API key
	 * @param name name of character to get inventory info
	 * @return character inventory detail
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public CharacterInventory getCharacterInventory(String API, String name) throws GuildWars2Exception{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		if (name==null || name.equals(""))
			throw new GuildWars2Exception(ErrorCode.Character, "Character name cannot be empty");
		try {
			Response<CharacterInventory> response = gw2API.getCharacterInventory(name, API).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Transaction API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/transactions">here</a><br/>
	 * Get transaction info linked to given API key
	 * @see Transaction transaction info
	 * @param API API key
	 * @param time current | History
	 * @param type buy | sell
	 * @return list of transaction base on the selection, if there is nothing, return empty list
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Transaction> getListing(String API, Transaction.Time time, Transaction.Type type) throws GuildWars2Exception{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		try {
			Response<List<Transaction>> response = gw2API.getListing(processListingTime(time), processListingType(type), API).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Get all id of items that is on the TP
	 * @return list of item ids
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Long> getAllListedItemID() throws GuildWars2Exception{
		try {
			Response<List<Long>> response=gw2API.getAllPrices().execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Get price info for the given item id(s)
	 * @see Prices listing price info
	 * @param ids list of item id
	 * @return list of listing price for given id(s)
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Prices> getPrices(long[] ids) throws GuildWars2Exception{
		if(ids==null || ids.length==0)
			throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
		try {
			Response<List<Prices>> response = gw2API.getPrices(processIds(ids)).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		}catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Currency API go <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">here</a><br/>
	 * Get currency info for the given currency id(s)
	 * @see Currency currency info
	 * @param ids list of currency id
	 * @return list of currency info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Currency> getCurrencyInfo(long[] ids)throws GuildWars2Exception{
		if(ids==null || ids.length==0)
			throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
		try {
			Response<List<Currency>> response=gw2API.getCurrencyInfo(processIds(ids)).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		}catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on World API go <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">here</a><br/>
	 * Get world info for the given world id(s)
	 * @see World world info
	 * @param ids list of currency id
	 * @return list of world info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<World> getWorldsInfo(long[] ids)throws GuildWars2Exception{
		if(ids==null || ids.length==0)
			throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
		try{
			Response<List<World>> response=gw2API.getWorldsInfo(processIds(ids)).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		}catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Material Category API go <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
	 * Get material category info for the given category id(s)
	 * @see MaterialCategory material category info
	 * @param ids list of category id
	 * @return list of material category info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<MaterialCategory> getMaterialCategoryInfo(long[] ids)throws GuildWars2Exception{
		if(ids==null || ids.length==0)
			throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
		try{
			Response<List<MaterialCategory>> response=gw2API.getMaterialBankInfo(processIds(ids)).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		}catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Skin API go <a href="https://wiki.guildwars2.com/wiki/API:2/skins">here</a><br/>
	 * Get skin info for the given skin id(s)
	 * @see Skin skin info
	 * @param ids list of skin id
	 * @return list of skin info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Skin> getSkinInfo(long[] ids)throws GuildWars2Exception{
		if(ids==null || ids.length==0)
			throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
		try{
			Response<List<Skin>> response=gw2API.getSkinInfo(processIds(ids)).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		}catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Item API go <a href="https://wiki.guildwars2.com/wiki/API:2/items">here</a><br/>
	 * Get item info for the given item id(s)
	 * @see Item item info
	 * @param ids list of item id
	 * @return list of item info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<Item> getItemInfo(long[] ids)throws GuildWars2Exception{
		if(ids==null || ids.length==0)
			throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
		try{
			Response<List<Item>> response=gw2API.getItemInfo(processIds(ids)).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		}catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}
	}

	/**
	 * For more info on Itemstat API go <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
	 * Get itemstat info for the given itemstat id(s)
	 * @see ItemStats itemstat info
	 * @param ids list of itemstat id
	 * @return list of itemstat info
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 */
	public List<ItemStats> getItemStatInfo(long[] ids)throws GuildWars2Exception{
		if(ids==null || ids.length==0)
			throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
		try{
			Response<List<ItemStats>> response=gw2API.getItemStatInfo(processIds(ids)).execute();
			if (!response.isSuccessful()){
				GuildWars2Exception exception=ErrorCode.checkErrorResponse(response.code(), response.errorBody().string());
				if (exception!=null) throw exception;
			}
			return response.body();
		}catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: "+e.getMessage());
		}

	}

	//Processor methods
	/**
	 * For more info on TokenInfo API go <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see TokenInfo API info
	 * @param API API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception invalid API key
	 * @throws NullPointerException if given {@link Callback} is null
	 */
	public void APIInfoProcessor(String API, Callback<TokenInfo> callback) throws GuildWars2Exception, NullPointerException{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		gw2API.getAPIInfo(API).enqueue(callback);
	}

	/**
	 * For more info on Account API go <a href="https://wiki.guildwars2.com/wiki/API:2/account">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see Account Account info
	 * @param API API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void accountProcessor(String API, Callback<Account> callback) throws GuildWars2Exception, NullPointerException{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		gw2API.getAccount(API).enqueue(callback);
	}

	/**
	 * For more info on Bank API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/bank">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see Bank Bank info
	 * @param API API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void bankProcessor(String API, Callback<List<Bank>> callback) throws GuildWars2Exception, NullPointerException{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		gw2API.getBank(API).enqueue(callback);
	}

	/**
	 * For more info on Shared Inventory API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/inventory">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see SharedInventory shared inventory info
	 * @param API API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void sharedInventoryProcessor(String API, Callback<List<SharedInventory>> callback) throws GuildWars2Exception, NullPointerException{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		gw2API.getSharedInventory(API).enqueue(callback);
	}

	/**
	 * For more info on Wallet API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/wallet">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see Wallet wallet info
	 * @param API API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void walletProcessor(String API, Callback<List<Wallet>> callback) throws GuildWars2Exception, NullPointerException{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		gw2API.getWallet(API).enqueue(callback);
	}

	/**
	 * For more info on MaterialCategory Storage API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/materials">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see Material material storage info
	 * @param API API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void materialStorageProcessor(String API, Callback<List<Material>> callback) throws GuildWars2Exception, NullPointerException{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		gw2API.getMaterialBank(API).enqueue(callback);
	}

	/**
	 * For more info on Character API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @param API API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void allCharacterNameProcessor(String API, Callback<List<String>> callback) throws GuildWars2Exception, NullPointerException{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		gw2API.getAllCharacterName(API).enqueue(callback);
	}

	/**
	 * For more info on Character Core API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Core">here</a><br/>
	 * Get character information for the given character name that is linked to given API key
	 * @see Core character info
	 * @param API API key
	 * @param name name of character
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void characterInformationProcessor(String API, String name, Callback<Core> callback) throws GuildWars2Exception, NullPointerException{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		if (name==null || name.equals(""))
			throw new GuildWars2Exception(ErrorCode.Character, "Character name cannot be empty");
		gw2API.getCharacterCore(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character Inventory API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Inventory">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see CharacterInventory character inventory info
	 * @param API API key
	 * @param name character name
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void characterInventoryProcessor(String API, String name, Callback<CharacterInventory> callback) throws GuildWars2Exception, NullPointerException{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		if (name==null || name.equals(""))
			throw new GuildWars2Exception(ErrorCode.Character, "Character name cannot be empty");
		gw2API.getCharacterInventory(name, API).enqueue(callback);
	}

	/**
	 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see Transaction transaction info
	 * @param API API key
	 * @param time current | History
	 * @param type buy | sell
	 *  @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void listingProcessor(String API, Transaction.Time time, Transaction.Type type, Callback<List<Transaction>> callback) throws GuildWars2Exception, NullPointerException{
		if(API==null || API.equals(""))
			throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
		gw2API.getListing(processListingTime(time), processListingType(type), API).enqueue(callback);
	}

	/**
	 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *  @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void allListedItemIDProcessor(Callback<List<Long>> callback) throws NullPointerException{
		gw2API.getAllPrices().enqueue(callback);
	}

	/**
	 * For more info on Listing Price API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see Prices listing item price info
	 * @param ids list of item id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void pricesProcessor(long[] ids, Callback<List<Prices>> callback) throws GuildWars2Exception, NullPointerException{
		if(ids==null || ids.length==0)
			throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
		gw2API.getPrices(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on Currency API go <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see Currency currency info
	 * @param ids list of currency id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void currencyInfoProcessor(long[] ids, Callback<List<Currency>> callback) throws GuildWars2Exception, NullPointerException{
		if(ids==null || ids.length==0)
			throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
		gw2API.getCurrencyInfo(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on World API go <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see World world info
	 * @param ids list of world id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void worldsInfoProcessor(long[] ids, Callback<List<World>> callback) throws GuildWars2Exception, NullPointerException{
		if(ids==null || ids.length==0)
			throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
		gw2API.getWorldsInfo(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on Material Category API go <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see MaterialCategory material category info
	 * @param ids list of category id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void materialCategoryInfoProcessor(long[] ids, Callback<List<MaterialCategory>> callback) throws GuildWars2Exception, NullPointerException{
		if(ids==null || ids.length==0)
			throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
		gw2API.getMaterialBankInfo(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on Skin API go <a href="https://wiki.guildwars2.com/wiki/API:2/skins">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see Skin skin info
	 * @param ids list of skin id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void skinInfoProcessor(long[] ids, Callback<List<Skin>> callback) throws GuildWars2Exception, NullPointerException{
		if (ids==null || ids.length==0)
			throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
		gw2API.getSkinInfo(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on Item API go <a href="https://wiki.guildwars2.com/wiki/API:2/items">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see Item item info
	 * @param ids list of item id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void itemInfoProcessor(long[] ids, Callback<List<Item>> callback) throws GuildWars2Exception, NullPointerException{
		if (ids==null || ids.length==0)
			throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
		gw2API.getItemInfo(processIds(ids)).enqueue(callback);
	}

	/**
	 * For more info on Itemstat API go <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 * @see ItemStats itemstat info
	 * @param ids list of itemstat id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void itemStatInfoProcessor(long[] ids, Callback<List<ItemStats>> callback) throws GuildWars2Exception, NullPointerException{
		if (ids==null || ids.length==0)
			throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
		gw2API.getItemStatInfo(processIds(ids)).enqueue(callback);
	}

	//convert list of ids to comma separated list
	private String processIds(long[] list){
		String ids="";
		for(long id:list) ids+=id+",";
		return ids.trim().substring(0, ids.length()-1);
	}

	//convert transaction.Time to string
	private String processListingTime(Transaction.Time time) throws GuildWars2Exception{
		if (time==null) throw new GuildWars2Exception(ErrorCode.TransTime, "Transaction time type cannot be empty");
		switch (time){
			case Current:
				return "current";
			case History:
				return "history";
			default:
				throw new GuildWars2Exception(ErrorCode.TransTime, "Invalid transaction time type");
		}
	}

	//convert transaction.Typr to String
	private String processListingType(Transaction.Type type) throws GuildWars2Exception{
		if (type==null) throw new GuildWars2Exception(ErrorCode.TransType, "Transaction type cannot be empty");
		switch (type){
			case Buy:
				return "buys";
			case Sell:
				return "sells";
			default:
				throw new GuildWars2Exception(ErrorCode.TransType, "Invalid transaction type");
		}
	}
}
