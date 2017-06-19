package me.xhsun.guildwars2wrapper.model.util;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

import java.util.List;

/**
 * Character inventory bag item model class
 *
 * @author xhsun
 * @see Inventory character inventory item
 * @since 2017-02-07
 */
public class Bag extends IdentifiableInt {
	private int size;
	private List<Inventory> inventory;

	public int getSize() {
		return size;
	}

	public List<Inventory> getInventory() {
		return inventory;
	}

	@Override
	public String toString() {
		return "Bag{" +
				"id=" + getId() +
				", size=" + size +
				", inventory=" + inventory +
				'}';
	}
}
