package me.xhsun.guildwars2wrapper.model.indentifiable;

/**
 * For models that have an int id, string name, and string chat_link
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class Linkable extends NameableInt {
	private String chat_link;

	public String getChatLink() {
		return chat_link;
	}

	@Override
	public String toString() {
		return "{" +
				"id=" + getId() +
				", name='" + getName() + '\'' +
				", chat_link='" + chat_link + '\'' +
				'}';
	}
}
