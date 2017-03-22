package xhsun.gw2api.guildwars2.util;

/**
 * @author xhsun
 * @since 2017-02-09
 */
public class GuildWars2Exception extends Exception {
	private ErrorCode errorCode;

	public GuildWars2Exception(ErrorCode errorCode, String message){
		super(message);
		this.errorCode=errorCode;
	}

	/**
	 * Meaning for different error code:<br/>
	 *  APIServer: API server not found<br/>
	 *  APIKey: Invalid API key<br/>
	 *  ID: Invalid ID<br/>
	 *  TransTime: Invalid transaction time<br/>
	 *  TransType: Invalid transaction type<br/>
	 *  Network: Network error<br/>
	 *  Other: Other
	 * @return error code
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
