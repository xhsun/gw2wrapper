package me.xhsun.guildwars2wrapper.error;

/**
 * @author xhsun
 * @since 2017-02-09
 */

public class GuildWars2Exception extends Exception {
	private ErrorCode errorCode;

	public GuildWars2Exception(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

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
	 * @return error code
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
