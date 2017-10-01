package me.xhsun.guildwars2wrapper.error;

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
		if (error == null) error = "";
		else error = error.replace("\"", "").replace("\n", "");

		switch (code) {
			case 404://server unavailable or invalid id
				if (error.matches(".*\\b(id|ids|guild|season|world)\\b.*"))
					return new GuildWars2Exception(ErrorCode.ID, "Invalid id");
				else if (error.matches(".*\\b(leaderboard)\\b.*"))
					return new GuildWars2Exception(ErrorCode.Other, "Invalid leaderboard");
				else if (error.matches(".*\\b(character)\\b.*"))
					return new GuildWars2Exception(ErrorCode.Character, "No such character for this account");
				return new GuildWars2Exception(ErrorCode.Server, "Cannot connect to GW2 API Server");
			case 403://invalid key
				return new GuildWars2Exception(ErrorCode.Key, "Invalid API key");
			case 429://exceeded limit
				return new GuildWars2Exception(ErrorCode.Limit, "Exceeded 600 requests per minute limit");
			case 400://no such character
				if (error.contains("key"))
					return new GuildWars2Exception(ErrorCode.Key, "Invalid key");
				else if (error.matches(".*\\b(character)\\b.*"))
					return new GuildWars2Exception(ErrorCode.Character, "No such character for this account");
				else if (error.matches("too few (gems|coins)\\b.*"))
					return new GuildWars2Exception(ErrorCode.Other, "Not enough currency");
				return new GuildWars2Exception(ErrorCode.ID, "Invalid id");
			case 200://what... why pass OK response
				if (error.contains("membership"))
					return new GuildWars2Exception(ErrorCode.Key, "Given account not a member");
				break;
			case 503:
				return new GuildWars2Exception(ErrorCode.Other, "Endpoint not available");
			default://uhhh...
				return new GuildWars2Exception(ErrorCode.Other, "Unknown error occurred");
		}
		return null;
	}
}
