package xhsun.gw2api.guildwars2.err;

/**
 * Model class for error response body
 *
 * @author xhsun
 * @since 2017-03-22
 */
public class ErrorResponse {
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
