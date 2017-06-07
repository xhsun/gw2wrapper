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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Bag bag = (Bag) o;

		return id == bag.id &&
				size == bag.size &&
				(inventory != null ? inventory.equals(bag.inventory) : bag.inventory == null);
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + size;
		result = 31 * result + (inventory != null ? inventory.hashCode() : 0);
		return result;
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
