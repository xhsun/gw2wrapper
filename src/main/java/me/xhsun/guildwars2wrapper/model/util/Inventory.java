package me.xhsun.guildwars2wrapper.model.util;

import me.xhsun.guildwars2wrapper.model.ItemStats;

import java.util.Arrays;

/**
 * Character inventory bag inventory model class
 *
 * @author xhsun
 * @see me.xhsun.guildwars2wrapper.model.Item item info
 * @see me.xhsun.guildwars2wrapper.model.Skin skin info
 * @see ItemStats item stat info
 * @since 2017-02-07
 */
public class Inventory extends Storage {
	private int[] infusions;
	private int[] upgrades;
	private long skin;
	private ItemStats stats;

	public int[] getInfusions() {
		return infusions;
	}

	public int[] getUpgrades() {
		return upgrades;
	}

	public long getSkin() {
		return skin;
	}

	public ItemStats getStats() {
		return stats;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Inventory inventory = (Inventory) o;

		return getItemId() == inventory.getItemId() &&
				getCount() == inventory.getCount() &&
				getCharges() == inventory.getCharges() &&
				skin == inventory.skin &&
				getBinding() == inventory.getBinding() &&
				(getBound_to() != null ? getBound_to().equals(inventory.getBound_to()) : inventory.getBound_to() == null) &&
				Arrays.equals(infusions, inventory.infusions) && Arrays.equals(upgrades, inventory.upgrades) &&
				(stats != null ? stats.equals(inventory.stats) : inventory.stats == null);
	}

	@Override
	public int hashCode() {
		int result = (int) (getItemId() ^ (getItemId() >>> 32));
		result = 31 * result + getCount();
		result = 31 * result + getCharges();
		result = 31 * result + (getBinding() != null ? getBinding().hashCode() : 0);
		result = 31 * result + (getBound_to() != null ? getBound_to().hashCode() : 0);
		result = 31 * result + Arrays.hashCode(infusions);
		result = 31 * result + Arrays.hashCode(upgrades);
		result = 31 * result + (int) (skin ^ (skin >>> 32));
		result = 31 * result + (stats != null ? stats.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Inventory{" +
				"id=" + getItemId() +
				", count=" + getCount() +
				", charges=" + getCharges() +
				", binding=" + getBinding() +
				", bound_to='" + getBound_to() + '\'' +
				", infusions=" + Arrays.toString(infusions) +
				", upgrades=" + Arrays.toString(upgrades) +
				", skin=" + skin +
				", stats=" + stats +
				'}';
	}
}