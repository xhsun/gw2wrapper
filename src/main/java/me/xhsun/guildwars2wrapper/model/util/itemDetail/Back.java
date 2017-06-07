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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Back back = (Back) o;

		return suffix_item_id == back.suffix_item_id &&
				(infusion_slots != null ? infusion_slots.equals(back.infusion_slots) : back.infusion_slots == null) &&
				(infix_upgrade != null ? infix_upgrade.equals(back.infix_upgrade) : back.infix_upgrade == null) &&
				(secondary_suffix_item_id != null ? secondary_suffix_item_id.equals(back.secondary_suffix_item_id) : back.secondary_suffix_item_id == null) &&
				(stat_choices != null ? stat_choices.equals(back.stat_choices) : back.stat_choices == null);
	}

	@Override
	public int hashCode() {
		int result = infusion_slots != null ? infusion_slots.hashCode() : 0;
		result = 31 * result + (infix_upgrade != null ? infix_upgrade.hashCode() : 0);
		result = 31 * result + suffix_item_id;
		result = 31 * result + (secondary_suffix_item_id != null ? secondary_suffix_item_id.hashCode() : 0);
		result = 31 * result + (stat_choices != null ? stat_choices.hashCode() : 0);
		return result;
	}

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
