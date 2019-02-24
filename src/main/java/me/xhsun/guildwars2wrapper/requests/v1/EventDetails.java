package me.xhsun.guildwars2wrapper.requests.v1;

import java.io.IOException;
import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.error.ErrorCode;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v1.EventDetail;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventDetails extends Request {

	protected EventDetails(GuildWars2API gw2API) {
		super(gw2API);
	}

	// ASYNC
	/**
	 * For more info on event detail API go <a href="https://wiki.guildwars2.com/wiki/API:1/event_details">here</a><br/>
	 *
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws NullPointerException if given {@link Callback} is null
	 * @see EventDetail event detail
	 */
	public void getAllEventDetailedInfo(Callback<EventDetail> callback) throws NullPointerException {
		gw2API.getAllEventDetailedInfo(GuildWars2.lang.getValue()).enqueue(callback);
	}

	/**
	 * For more info on event detail API go <a href="https://wiki.guildwars2.com/wiki/API:1/event_details">here</a><br/>
	 *
	 * @param id       event id
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid id
	 * @throws NullPointerException if given {@link Callback} is null
	 * @see EventDetail event detail
	 */
	public void getEventDetailedInfo(String id, Callback<EventDetail> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.ID, id));
		gw2API.getEventDetailedInfo(id, GuildWars2.lang.getValue()).enqueue(callback);
	}

	//SYNC
	/**
	 * For more info on event detail API go <a href="https://wiki.guildwars2.com/wiki/API:1/event_details">here</a><br/>
	 *
	 * @return event details
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see EventDetail event detail
	 */
	public EventDetail getAllEventDetailedInfo() throws GuildWars2Exception {
		try {
			Response<EventDetail> response = gw2API.getAllEventDetailedInfo(GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	/**
	 * For more info on event detail API go <a href="https://wiki.guildwars2.com/wiki/API:1/event_details">here</a><br/>
	 *
	 * @param id event id
	 * @return event details
	 * @throws GuildWars2Exception see {@link ErrorCode} for detail
	 * @see EventDetail event detail
	 */
	public EventDetail getEventDetailedInfo(String id) throws GuildWars2Exception {
		isParamValid(new ParamChecker(ParamType.ID, id));
		try {
			Response<EventDetail> response = gw2API.getEventDetailedInfo(id, GuildWars2.lang.getValue()).execute();
			if (!response.isSuccessful()) throwError(response.code(), response.errorBody());
			return response.body();
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}
}
