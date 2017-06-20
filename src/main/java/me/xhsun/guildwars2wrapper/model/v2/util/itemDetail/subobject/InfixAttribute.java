package me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.subobject;

import me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.ItemAttributes;

/**
 * Infix attribute model class
 *
 * @author xhsun
 * @see InfixUpgrade infix upgrade
 * @since 2017-02-10
 */

public class InfixAttribute {
	private ItemAttributes.Attribute attribute;
	private int modifier;

	public ItemAttributes.Attribute getAttribute() {
		return attribute;
	}

	public int getModifier() {
		return modifier;
	}
}
