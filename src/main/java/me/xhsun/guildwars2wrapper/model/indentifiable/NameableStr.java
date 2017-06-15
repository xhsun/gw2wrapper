package me.xhsun.guildwars2wrapper.model.indentifiable;

/**
 * For models that have an string id and string name
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class NameableStr extends IdentifiableStr {
	private String name;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "{" +
				"id=" + getId() +
				", name='" + name + '\'' +
				'}';
	}
}
