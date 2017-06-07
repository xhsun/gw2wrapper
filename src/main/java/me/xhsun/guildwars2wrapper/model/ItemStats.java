package me.xhsun.guildwars2wrapper.model;


import me.xhsun.guildwars2wrapper.model.util.itemDetail.ItemAttributes;

/**
 * For more info on Itemstat API go <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
 * Itemstat model class
 *
 * @author xhsun
 * @see ItemAttributes item attribute
 * @since 2017-02-07
 */
public class ItemStats {
	private int id;
	private String name;
	private ItemAttributes attributes;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ItemAttributes getAttributes() {
		return attributes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ItemStats itemStats = (ItemStats) o;

		return id == itemStats.id &&
				(name != null ? name.equals(itemStats.name) : itemStats.name == null) &&
				(attributes != null ? attributes.equals(itemStats.attributes) : itemStats.attributes == null);
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ItemStats{" +
				"id=" + id +
				", name='" + name + '\'' +
				", attributes=" + attributes +
				'}';
	}
}