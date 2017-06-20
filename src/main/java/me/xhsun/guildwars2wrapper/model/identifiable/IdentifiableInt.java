package me.xhsun.guildwars2wrapper.model.identifiable;

/**
 * For models that have an int id
 *
 * @author xhsun
 * @since 2017-06-07
 */
public abstract class IdentifiableInt {
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

	@Override
	public String toString() {
		return "{" +
				"id=" + id +
				'}';
	}
}
