package xhsun.gw2api.guildwars2.model.character;

import xhsun.gw2api.guildwars2.model.util.Bag;

import java.util.List;

/**
 * For more info on Character Inventory API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Inventory">here</a><br/>
 * Character inventory model class
 * @see Bag bag item
 * @author xhsun
 * @since 2017-02-09
 */

public class CharacterInventory {
	private List<Bag> bags;

	public List<Bag> getBags() {
		return bags;
	}

	public String toString(){
		return bags.toString();
	}
}
