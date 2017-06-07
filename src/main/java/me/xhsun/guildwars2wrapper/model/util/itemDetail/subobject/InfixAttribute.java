package me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject;

import me.xhsun.guildwars2wrapper.model.util.itemDetail.ItemDetail;

/**
 * Infix attribute model class
 *
 * @author xhsun
 * @see InfixUpgrade infix upgrade
 * @since 2017-02-10
 */

public class InfixAttribute {
	private ItemDetail.Attribute attribute;
	private int modifier;

	public ItemDetail.Attribute getAttribute() {
		return attribute;
	}

	public int getModifier() {
		return modifier;
	}

	@Override
	public String toString() {
		return "InfixAttribute{" +
				"attribute=" + attribute +
				", modifier=" + modifier +
				'}';
	}
}
