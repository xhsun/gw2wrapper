package me.xhsun.guildwars2wrapper.requests.v2.recipes.search;

import me.xhsun.guildwars2wrapper.model.v2.Recipe;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Search extends Request {
	protected Search(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on Recipes search API go <a href="https://wiki.guildwars2.com/wiki/API:2/recipes/search">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Recipe recipe info
	 */
	public void searchRecipes(boolean isInput, int id, Callback<List<Integer>> callback) throws NullPointerException {
		if (isInput) gw2API.searchInputRecipes(Integer.toString(id)).enqueue(callback);
		else gw2API.searchOutputRecipes(Integer.toString(id)).enqueue(callback);
	}

	//SYNC
}
