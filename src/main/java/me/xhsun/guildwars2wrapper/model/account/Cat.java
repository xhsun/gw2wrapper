package me.xhsun.guildwars2wrapper.model.account;

/**
 * <a href="https://wiki.guildwars2.com/wiki/API:2/account/home/cats">Cat</a>
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class Cat {
	private int id;
	private String hint;

	public int getId() {
		return id;
	}

	public String getHint() {
		return hint;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Cat cat = (Cat) o;

		return id == cat.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "Cat{" +
				"id=" + id +
				", hint='" + hint + '\'' +
				'}';
	}
}
