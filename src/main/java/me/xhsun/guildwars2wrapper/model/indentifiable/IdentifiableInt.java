package me.xhsun.guildwars2wrapper.model.indentifiable;

/**
 * For models that have an int id
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class IdentifiableInt {
	private int id;

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		IdentifiableInt identifiable = (IdentifiableInt) o;

		return id == identifiable.id;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
