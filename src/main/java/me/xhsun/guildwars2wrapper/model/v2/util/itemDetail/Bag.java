package me.xhsun.guildwars2wrapper.model.v2.util.itemDetail;

/**
 * For more info on CharacterBag detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Bag">here</a><br/>
 * Item detail for CharacterBag
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-10
 */
public class Bag extends ItemDetail {

	public int getSize() {
		return size;
	}

	public boolean isInvisible() {
		return no_sell_or_sort;
	}
}
