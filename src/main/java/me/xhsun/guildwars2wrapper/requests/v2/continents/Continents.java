package me.xhsun.guildwars2wrapper.requests.v2.continents;

import java.util.List;
import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.continent.Continent;
import me.xhsun.guildwars2wrapper.model.v2.continent.ContinentFloor;
import me.xhsun.guildwars2wrapper.model.v2.continent.ContinentMap;
import me.xhsun.guildwars2wrapper.model.v2.continent.ContinentRegion;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Continents extends Request {

	protected Continents(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
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
		gw2API.getContinentInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
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
		gw2API.getContinentFloorInfo(Integer.toString(continentID), processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
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
		gw2API.getContinentRegionInfo(Integer.toString(continentID), Integer.toString(floorID), processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
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
		gw2API.getContinentMapInfo(Integer.toString(continentID), Integer.toString(floorID), Integer.toString(regionID), processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
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
		gw2API.getContinentSectorInfo(Integer.toString(continentID), Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID), processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
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
		gw2API.getContinentPOIInfo(Integer.toString(continentID), Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID), processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
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
		gw2API.getContinentTaskInfo(Integer.toString(continentID), Integer.toString(floorID), Integer.toString(regionID), Integer.toString(mapID), processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	//SYNC
}
