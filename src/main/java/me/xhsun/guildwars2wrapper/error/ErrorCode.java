package me.xhsun.guildwars2wrapper.error;

import com.google.gson.Gson;

/**
 * Meaning for different error code:<br/>
 * Server: API server not found<br/>
 * Key: Invalid API key<br/>
 * Limit: Exceed 600 requests per minute limit<br/>
 * Character: No such character for this account<br/>
 * ID: Invalid ID<br/>
 * TransTime: Invalid transaction time<br/>
 * TransType: Invalid transaction type<br/>
 * Network: Network error<br/>
 * Other: Other
 *
 * @author xhsun
 * @since 2017-03-18
 */

public enum ErrorCode {
	Server, Key, Limit, Character, ID, TransTime, TransType, Network, Other;

	/**
	 * generate apporiate gw2 exception base on the error code and message
	 *
	 * @param code  error code
	 * @param error error message
	 * @return {@link GuildWars2Exception}
	 */
	public static GuildWars2Exception checkErrorResponse(int code, String error) {
		ErrorResponse errorResponse = null;
		if (error != null && !error.equals("")) errorResponse = new Gson().fromJson(error, ErrorResponse.class);
		switch (code) {
			case 404://server unavailable or invalid id
				if (errorResponse != null && errorResponse.getText().contains("id"))
					return new GuildWars2Exception(ErrorCode.ID, "Invalid id");
				return new GuildWars2Exception(ErrorCode.Server, "Cannot connect to GW2 API Server");
			case 403://invalid key
				return new GuildWars2Exception(ErrorCode.Key, "Invalid API key");
			case 429://exceeded limit
				return new GuildWars2Exception(ErrorCode.Limit, "Exceeded 600 requests per minute limit");
			case 400://no such character
				if (errorResponse != null && (errorResponse.getText().contains("key")))
					return new GuildWars2Exception(ErrorCode.Key, "Invalid key");
				else if (errorResponse != null && errorResponse.getText().matches(".*\\b(input|output|id|ids|floor|region)\\b.*"))
					return new GuildWars2Exception(ErrorCode.ID, "Invalid id");
				return new GuildWars2Exception(ErrorCode.Character, "No such character for this account");
			case 200://what... why pass OK response
				return null;
			default://uhhh...
				return new GuildWars2Exception(ErrorCode.Other, "Unknown error occurred");
		}
	}
}
