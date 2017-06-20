package me.xhsun.guildwars2wrapper.model.identifiable;

/**
 * For models that have an int id and string name
 *
 * @author xhsun
 * @since 2017-06-07
 */
public abstract class NameableInt extends IdentifiableInt {
	private String name;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "{" +
				super.toString() +
				", name='" + name + '\'' +
				'}';
	}
}
