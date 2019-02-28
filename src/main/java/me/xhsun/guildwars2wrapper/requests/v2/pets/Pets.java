package me.xhsun.guildwars2wrapper.requests.v2.pets;

import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.Pet;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Pets extends Request {
	protected Pets(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on pets API go <a href="https://wiki.guildwars2.com/wiki/API:2/pets">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Pet pet info
	 */
	public void getAllPetID(Callback<List<Integer>> callback) throws NullPointerException {
		gw2API.getAllPetIDs().enqueue(callback);
	}

	/**
	 * For more info on pets API go <a href="https://wiki.guildwars2.com/wiki/API:2/pets">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of pet id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Pet pet info
	 */
	public void getPetInfo(int[] ids, Callback<List<Pet>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getPetInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	//SYNC
}
