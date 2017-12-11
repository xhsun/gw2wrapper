package me.xhsun.guildwars2wrapper;

import me.xhsun.guildwars2wrapper.error.ErrorCode;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
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
	String processIds(int[] list) throws GuildWars2Exception {
		if (list.length > 200) throw new GuildWars2Exception(ErrorCode.ID, "Exceeded upper limit (200 ids) for id list");
		StringBuilder ids = new StringBuilder();
		for (int id : list) ids.append(id).append(",");
		return ids.toString().trim().substring(0, ids.length() - 1);
	}

	String processIds(String[] list) throws GuildWars2Exception {
		if (list.length > 200) throw new GuildWars2Exception(ErrorCode.ID, "Exceeded upper limit (200 ids) for id list");
		StringBuilder ids = new StringBuilder();
		for (String id : list) ids.append(id).append(",");
		return ids.toString().trim().substring(0, ids.length() - 1);
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
			if (c.type != ParamType.IDS && c.type != ParamType.STR_IDS) {
				if (c.value == null || c.value.equals("")) {
					switch (c.type) {
						case API:
							throw new GuildWars2Exception(ErrorCode.Key, "API Key cannot be empty");
						case CHAR:
							throw new GuildWars2Exception(ErrorCode.Character, "Character name cannot be empty");
						case GUILD:
							throw new GuildWars2Exception(ErrorCode.ID, "Invalid Guild id/name");
						case ID:
							throw new GuildWars2Exception(ErrorCode.ID, "Invalid id");
						default:
							throw new GuildWars2Exception(ErrorCode.Other, "Unexpected error occured of type: " + c.type);
					}
				}
			} else {
				switch (c.type) {
					case IDS:
						if (c.ids == null || c.ids.length == 0)
							throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
						break;
					case STR_IDS:
						if (c.str_id == null || c.str_id.length == 0)
							throw new GuildWars2Exception(ErrorCode.ID, "List of id cannot be empty");
						break;
					default:
						throw new GuildWars2Exception(ErrorCode.Other, "Unexpected error occured of type: " + c.type);
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
			type = ParamType.IDS;
			ids = i;
		}

		ParamChecker(String[] i) {
			type = ParamType.STR_IDS;
			str_id = i;
		}
	}

	enum ParamType {API, CHAR, GUILD, ID, IDS, STR_IDS}
}
