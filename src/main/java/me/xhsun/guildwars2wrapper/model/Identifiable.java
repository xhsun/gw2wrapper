package me.xhsun.guildwars2wrapper.model;

/**
 * For models that have an int id and string name
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class Identifiable {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Identifiable identifiable = (Identifiable) o;

		return id == identifiable.id;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
