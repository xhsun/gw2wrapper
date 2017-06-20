package me.xhsun.guildwars2wrapper.model.v2.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.v2.util.comm.Type;

/**
 * For more info on Armor detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Armor">here</a><br/>
 * Item detail for Armors
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-07
 */
public class Armor extends StatSelectable {
	public Type getType() {
		return type;
	}

	public Weight getWeightClass() {
		return weight_class;
	}

	public int getDefense() {
		return defense;
	}
}
