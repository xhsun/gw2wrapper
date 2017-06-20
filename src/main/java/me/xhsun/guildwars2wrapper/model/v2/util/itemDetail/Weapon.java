package me.xhsun.guildwars2wrapper.model.v2.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.v2.util.comm.Type;

/**
 * For more info on Weapon detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Weapon">here</a><br/>
 * Item detail for Weapon
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-10
 */
public class Weapon extends StatSelectable {
	public Type getType() {
		return type;
	}

	public Damage getDamageType() {
		return damage_type;
	}

	public int getMinPower() {
		return min_power;
	}

	public int getMaxPower() {
		return max_power;
	}

	public int getDefense() {
		return defense;
	}
}
