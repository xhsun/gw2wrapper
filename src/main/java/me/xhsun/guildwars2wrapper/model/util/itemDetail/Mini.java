package me.xhsun.guildwars2wrapper.model.util.itemDetail;

/**
 * For more info on Mini detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Miniature">here</a><br/>
 * Item detail for Mini
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-10
 */
public class Mini extends ItemDetail {
	public int getMiniID() {
		return minipet_id;
	}

	@Override
	public String toString() {
		return "Mini{" +
				"minipet_id=" + minipet_id +
				'}';
	}
}
