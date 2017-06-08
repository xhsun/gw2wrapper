package me.xhsun.guildwars2wrapper.model.indentifiable;

/**
 * For models that have a string id
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class IdentifiableStr {
	private String id;

	public String getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		IdentifiableStr that = (IdentifiableStr) o;

		return id != null ? id.equals(that.id) : that.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
