package me.xhsun.guildwars2wrapper.model;

/**
 * For more info on Currency API go <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">here</a><br/>
 * Currency model class<br/>
 * Note: icon is a url for the icon
 *
 * @author xhsun
 * @since 2017-02-07
 */

public class Currency {
	private int id;
	private String name;
	private String description;
	private String icon;
	private int order;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getIcon() {
		return icon;
	}

	public int getOrder() {
		return order;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Currency currency = (Currency) o;

		return id == currency.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "Currency{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", icon='" + icon + '\'' +
				", order=" + order +
				'}';
	}
}
