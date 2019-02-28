package me.xhsun.guildwars2wrapper.requests.v2.pvp.id;

import me.xhsun.guildwars2wrapper.model.v2.World;
import me.xhsun.guildwars2wrapper.model.v2.pvp.PvPLeaderBoard;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Leaderboard extends Request {
	protected Leaderboard(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on pvp season API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param id       Season id
	 * @param type     ladder/legendary/guild
	 * @param region   na/eu
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see PvPLeaderBoard pvp season info
	 */
	public void getPvPSeasonLeaderBoardInfo(String id, String type, World.Region region, Callback<List<PvPLeaderBoard>> callback) throws NullPointerException {
		gw2API.getPvPSeasonLeaderBoardInfo(id, type, region.name().toLowerCase()).enqueue(callback);
	}

	//SYNC
}
