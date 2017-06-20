package me.xhsun.guildwars2wrapper.model.v2.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.v2.util.comm.Type;

/**
 * Item detail for Container, Gathering tools, Gizmo, Salvage kits<br/>
 * Note: getChrages() for Slavage kits only
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-10
 */
public class Utility extends ItemDetail {
	public Type getType() {
		return type;
	}

	public int getCharges() {
		return charges;
	}
}
