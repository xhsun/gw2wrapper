package me.xhsun.guildwars2wrapper.model.v2.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.v2.util.comm.Type;

/**
 * For more info on Trinket detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Trinket">here</a><br/>
 * Item detail for Trinket
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-10
 */
public class Trinket extends StatSelectable {
	public Type getType() {
		return type;
	}
}
