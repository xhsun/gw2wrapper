package me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.subobject;

import java.util.List;

/**
 * For more info on Infix upgrade API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Infix_upgrade_subobject">here</a><br/>
 * Infix upgrade model class
 *
 * @author xhsun
 * @see InfixAttribute infix attribute
 * @see Buff infix buff
 * @since 2017-02-10
 */

public class InfixUpgrade {
	private List<InfixAttribute> attributes;
	private Buff buff;

	public List<InfixAttribute> getAttributes() {
		return attributes;
	}

	public Buff getBuff() {
		return buff;
	}
}
