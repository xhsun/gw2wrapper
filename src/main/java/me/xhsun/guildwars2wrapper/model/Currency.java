package me.xhsun.guildwars2wrapper.model;

/**
 * For more info on Currency API go <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">here</a><br/>
 * Currency model class<br/>
 * Note: icon is a url for the icon
 *
 * @author xhsun
 * @since 2017-02-07
 */

public class Currency extends Identifiable {
	private String description;
	private String icon;
	private int order;

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

		return getId() == currency.getId();
	}

	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public String toString() {
		return "Currency{" +
				"id=" + getId() +
				", name='" + getName() + '\'' +
				", description='" + description + '\'' +
				", icon='" + icon + '\'' +
				", order=" + order +
				'}';
	}
}
