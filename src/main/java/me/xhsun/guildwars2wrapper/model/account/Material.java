package me.xhsun.guildwars2wrapper.model.account;

import me.xhsun.guildwars2wrapper.model.util.Storage;

/**
 * For more info on MaterialCategory Storage API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/materials">here</a><br/>
 * Material storage item model class<br/>
 * Note: for item that is empty the count will be zero
 *
 * @author xhsun
 * @see me.xhsun.guildwars2wrapper.model.Item item info
 * @see me.xhsun.guildwars2wrapper.model.MaterialCategory material category info
 * @since 2017-02-07
 */

public class Material extends Storage {
	private int category;

	public int getCategory() {
		return category;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Material material = (Material) o;

		return getItemId() == material.getItemId() &&
				getCount() == material.getCount() &&
				category == material.category &&
				getBinding() == material.getBinding();
	}

	@Override
	public int hashCode() {
		int result = (int) (getItemId() ^ (getItemId() >>> 32));
		result = 31 * result + getCount();
		result = 31 * result + (getBinding() != null ? getBinding().hashCode() : 0);
		result = 31 * result + category;
		return result;
	}

	@Override
	public String toString() {
		return "Material{" +
				"id=" + getItemId() +
				", count=" + getCount() +
				", binding=" + getBinding() +
				", category=" + category +
				'}';
	}
}
