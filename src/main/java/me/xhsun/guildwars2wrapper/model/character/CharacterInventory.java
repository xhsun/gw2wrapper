package me.xhsun.guildwars2wrapper.model.character;

import me.xhsun.guildwars2wrapper.model.util.Bag;

import java.util.List;

/**
 * For more info on Character Inventory API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Inventory">here</a><br/>
 * Character inventory model class
 *
 * @author xhsun
 * @see Bag bag item
 * @since 2017-02-09
 */

public class CharacterInventory {
	private List<Bag> bags;

	public List<Bag> getBags() {
		return bags;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CharacterInventory that = (CharacterInventory) o;

		return bags != null ? bags.equals(that.bags) : that.bags == null;
	}

	@Override
	public int hashCode() {
		return bags != null ? bags.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "CharacterInventory{" +
				"bags=" + bags +
				'}';
	}
}
