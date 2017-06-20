package me.xhsun.guildwars2wrapper.model.v2.character;

import java.util.List;

/**
 * For more info on Character Inventory API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Inventory">here</a><br/>
 * Character inventory model class
 *
 * @author xhsun
 * @see CharacterBag bag item
 * @since 2017-02-09
 */

public class CharacterInventory {
	private List<CharacterBag> bags;

	public List<CharacterBag> getBags() {
		return bags;
	}
}
