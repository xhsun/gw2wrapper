package me.xhsun.guildwars2wrapper;

import me.xhsun.guildwars2wrapper.error.ErrorCode;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.commerce.Transaction;
import okhttp3.ResponseBody;

import java.io.IOException;

/**
 * Super class for {@link SynchronousRequest} and {@link AsynchronousRequest},
 * this class is mainly for to store {@link GuildWars2API} and common methods for them
 *
 * @author xhsun
 * @since 2017-06-04
 */

abstract class Request {
	GuildWars2API gw2API;

	Request(GuildWars2API gw2API) {
		this.gw2API = gw2API;
	}

	//convert list of ids to comma separated list
	String processIds(int[] list) {
		StringBuilder ids = new StringBuilder();
		for (int id : list) ids.append(id).append(",");
		return ids.toString().trim().substring(0, ids.length() - 1);
	}

	String processIds(String[] list) {
		StringBuilder ids = new StringBuilder();
		for (String id : list) ids.append(id).append(",");
		return ids.toString().trim().substring(0, ids.length() - 1);
	}

	//convert transaction.Time to string
	String processListingTime(Transaction.Time time) throws GuildWars2Exception {
		if (time == null) throw new GuildWars2Exception(ErrorCode.TransTime, "Transaction time type cannot be empty");
		switch (time) {
			case Current:
				return "current";
			case History:
				return "history";
			default:
				throw new GuildWars2Exception(ErrorCode.TransTime, "Invalid transaction time type");
		}
	}

	//convert transaction.Typr to String
	String processListingType(Transaction.Type type) throws GuildWars2Exception {
		if (type == null) throw new GuildWars2Exception(ErrorCode.TransType, "Transaction type cannot be empty");
		switch (type) {
			case Buy:
				return "buys";
			case Sell:
				return "sells";
			default:
				throw new GuildWars2Exception(ErrorCode.TransType, "Invalid transaction type");
		}
	}

	void isValueValid(long value) throws GuildWars2Exception {
		if (value > 0) return;
		throw new GuildWars2Exception(ErrorCode.Other, "Invalid Value");
	}

	//throw error base on error code and error response
	void throwError(int code, ResponseBody body) throws GuildWars2Exception {
		try {
			String respond;
			if (body == null) respond = "";
			else respond = body.string();
			GuildWars2Exception exception = ErrorCode.checkErrorResponse(code, respond);
			if (exception != null) throw exception;
		} catch (IOException e) {
			throw new GuildWars2Exception(ErrorCode.Network, "Network Error: " + e.getMessage());
		}
	}

	//check if parameters are valid or not
	void isParamValid(ParamChecker... items) throws GuildWars2Exception {
		for (ParamChecker c : items) {
			if (c.type != ParamType.ID) {
				if (c.value == null || c.value.equals("")) {
					switch (c.type) {
						case API:
							throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
						case CHAR:
							throw new GuildWars2Exception(ErrorCode.Character, "Character name cannot be empty");
					}
				}
			} else {
				switch (c.type) {
					case ID:
						if (c.ids == null || c.ids.length == 0)
							throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
						break;
					case STR_ID:
						if (c.str_id == null || c.str_id.length == 0)
							throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
				}
			}
		}
	}

	//for helping with throwing appropriate if parameters are invalid
	class ParamChecker {
		ParamType type;
		String value;
		int[] ids;
		String[] str_id;

		ParamChecker(ParamType t, String s) {
			type = t;
			value = s;
		}

		ParamChecker(int[] i) {
			type = ParamType.ID;
			ids = i;
		}

		ParamChecker(String[] i) {
			type = ParamType.STR_ID;
			str_id = i;
		}
	}

	enum ParamType {API, CHAR, ID, STR_ID}
}
