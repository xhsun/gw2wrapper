package me.xhsun.guildwars2wrapper.requests.v2.professions;

import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.Profession;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Professions extends Request {
	protected Professions(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on professions API go <a href="https://wiki.guildwars2.com/wiki/API:2/professions">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Profession profession info
	 */
	public void getAllProfessionID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllProfessionIDs().enqueue(callback);
	}

	/**
	 * For more info on professions API go <a href="https://wiki.guildwars2.com/wiki/API:2/professions">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of profession id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Profession profession info
	 */
	public void getProfessionInfo(String[] ids, Callback<List<Profession>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getProfessionInfo(processIds(ids), GuildWars2.lang.getValue()).enqueue(callback);
	}

	//SYNC
}
