package me.xhsun.guildwars2wrapper.error;

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
