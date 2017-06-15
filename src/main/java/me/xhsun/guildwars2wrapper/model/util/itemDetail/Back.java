package me.xhsun.guildwars2wrapper.model.util.itemDetail;


/**
 * For more info on Back detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Back_item">here</a><br/>
 * Item detail for back item
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-10
 */
public class Back extends StatSelectable {

	@Override
	public String toString() {
		return "Back{" +
				"infusion_slots=" + infusion_slots +
				", infix_upgrade=" + infix_upgrade +
				", suffix_item_id=" + suffix_item_id +
				", secondary_suffix_item_id='" + secondary_suffix_item_id + '\'' +
				", stat_choices=" + stat_choices +
				'}';
	}
}
