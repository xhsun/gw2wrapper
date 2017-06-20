package me.xhsun.guildwars2wrapper.model.identifiable;

/**
 * For models that have an string id and string name
 *
 * @author xhsun
 * @since 2017-06-07
 */
public abstract class NameableStr extends IdentifiableStr {
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
