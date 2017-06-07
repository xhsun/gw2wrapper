package me.xhsun.guildwars2wrapper.model.util;

import me.xhsun.guildwars2wrapper.model.ItemStats;

import java.util.List;

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
	private List<Integer> infusions;
	private List<Integer> upgrades;
	private int skin;
	private ItemStats stats;

	public List<Integer> getInfusions() {
		return infusions;
	}

	public List<Integer> getUpgrades() {
		return upgrades;
	}

	public int getSkin() {
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
				(getBoundTo() != null ? getBoundTo().equals(inventory.getBoundTo()) : inventory.getBoundTo() == null) &&
				(infusions != null ? infusions.equals(inventory.infusions) : inventory.infusions == null) &&
				(upgrades != null ? upgrades.equals(inventory.upgrades) : inventory.upgrades == null) &&
				(stats != null ? stats.equals(inventory.stats) : inventory.stats == null);
	}

	@Override
	public int hashCode() {
		int result = getItemId();
		result = 31 * result + getCount();
		result = 31 * result + getCharges();
		result = 31 * result + (getBinding() != null ? getBinding().hashCode() : 0);
		result = 31 * result + (getBoundTo() != null ? getBoundTo().hashCode() : 0);
		result = 31 * result + (infusions != null ? infusions.hashCode() : 0);
		result = 31 * result + (upgrades != null ? upgrades.hashCode() : 0);
		result = 31 * result + skin;
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
				", bound_to='" + getBoundTo() + '\'' +
				", infusions=" + infusions +
				", upgrades=" + upgrades +
				", skin=" + skin +
				", stats=" + stats +
				'}';
	}
}