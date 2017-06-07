package me.xhsun.guildwars2wrapper.model.util;

import java.util.List;

/**
 * Character inventory bag item model class
 *
 * @author xhsun
 * @see Inventory character inventory item
 * @since 2017-02-07
 */
public class Bag {
	private int id;
	private int size;
	private List<Inventory> inventory;

	public int getId() {
		return id;
	}

	public int getSize() {
		return size;
	}

	public List<Inventory> getInventory() {
		return inventory;
	}

	@Override
	public String toString() {
		return "Bag{" +
				"id=" + id +
				", size=" + size +
				", inventory=" + inventory +
				'}';
	}
}
