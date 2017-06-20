package me.xhsun.guildwars2wrapper.model.v2.character;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;
import me.xhsun.guildwars2wrapper.model.v2.util.Inventory;

import java.util.List;

/**
 * Character inventory bag item model class
 *
 * @author xhsun
 * @see Inventory character inventory item
 * @since 2017-02-07
 */
public class CharacterBag extends IdentifiableInt {
	private int size;
	private List<Inventory> inventory;

	public int getSize() {
		return size;
	}

	public List<Inventory> getInventory() {
		return inventory;
	}
}
