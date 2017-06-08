package me.xhsun.guildwars2wrapper.model.indentifiable;

/**
 * For models that have an int id and string name
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class Nameable extends IdentifiableInt {
	private String name;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "{" +
				"id=" + getName() +
				", name='" + name + '\'' +
				'}';
	}
}
