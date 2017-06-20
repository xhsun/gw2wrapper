package me.xhsun.guildwars2wrapper.model.identifiable;

import me.xhsun.guildwars2wrapper.model.v2.Item;
import me.xhsun.guildwars2wrapper.model.v2.Outfit;
import me.xhsun.guildwars2wrapper.model.v2.pvp.PvPHero.Skin;

import java.util.Arrays;

/**
 * Super class for model classes that have unlock item field
 *
 * @author xhsun
 * @since 2017-06-06
 */
public abstract class Unlockable extends NameableInt {
	private int[] unlock_items;//item id
	private int order;
	private String icon;

	/**
	 * @return array of {@link Item} id(s)
	 */
	public int[] getUnlockItems() {
		return unlock_items;
	}

	/**
	 * not applicable to {@link Outfit}, {@link Skin}
	 *
	 * @return Order shown in game
	 */
	public int getOrder() {
		return order;
	}

	public String getIcon() {
		return icon;
	}

	@Override
	public String toString() {
		return "{" +
				super.toString() +
				", unlock_items=" + Arrays.toString(unlock_items) +
				", order=" + order +
				", icon='" + icon + '\'' +
				'}';
	}
}
