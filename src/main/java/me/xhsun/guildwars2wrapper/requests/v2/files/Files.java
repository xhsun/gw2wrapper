package me.xhsun.guildwars2wrapper.requests.v2.files;

import java.util.List;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.Asset;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Files extends Request {

	protected Files(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on files API go <a href="https://wiki.guildwars2.com/wiki/API:2/files">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Asset file info
	 */
	public void getAllFileID(Callback<List<String>> callback) throws NullPointerException {
		gw2API.getAllFileIDs().enqueue(callback);
	}

	/**
	 * For more info on files API go <a href="https://wiki.guildwars2.com/wiki/API:2/files">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids      list of file id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  empty ID list
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Asset file info
	 */
	public void getAllFileInfo(String[] ids, Callback<List<Asset>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ids));
		gw2API.getAllFileInfo(processIds(ids)).enqueue(callback);
	}

	//SYNC
}
