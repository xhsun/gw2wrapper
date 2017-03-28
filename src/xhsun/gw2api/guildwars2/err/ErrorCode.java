package xhsun.gw2api.guildwars2.err;

/**
 * Meaning for different error code:<br/>
 *  Server: API server not found<br/>
 *  Key: Invalid API key<br/>
 *  Limit: Exceed 600 requests per minute limit<br/>
 *  Character: No such character for this account<br/>
 *  ID: Invalid ID<br/>
 *  TransTime: Invalid transaction time<br/>
 *  TransType: Invalid transaction type<br/>
 *  Network: Network error<br/>
 *  Other: Other
 * @author xhsun
 * @since 2017-03-18
 */
public enum ErrorCode {
	Server, Key, Limit, Character, ID, TransTime, TransType, Network, Other
}
