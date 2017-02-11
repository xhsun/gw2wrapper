package xhsun.gw2api.guildwars2.model.util.itemDetail.subobject;

import xhsun.gw2api.guildwars2.model.util.itemDetail.ItemDetail;

/**
 * Infix attribute model class
 * @see InfixUpgrade infix upgrade
 * @author xhsun
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

	public String toString(){
		return "{Attribute: "+attribute+" Modifier: "+modifier+"}";
	}
}
