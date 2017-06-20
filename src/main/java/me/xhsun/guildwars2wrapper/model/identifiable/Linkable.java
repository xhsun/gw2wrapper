package me.xhsun.guildwars2wrapper.model.identifiable;

/**
 * For models that have an int id, string name, and string chat_link
 *
 * @author xhsun
 * @since 2017-06-07
 */
public abstract class Linkable extends NameableInt {
	private String chat_link;

	public String getChatLink() {
		return chat_link;
	}

	@Override
	public String toString() {
		return "{" +
				super.toString() +
				", name='" + getName() + '\'' +
				", chat_link='" + chat_link + '\'' +
				'}';
	}
}
