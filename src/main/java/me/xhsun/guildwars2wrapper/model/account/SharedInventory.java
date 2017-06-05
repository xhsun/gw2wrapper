package me.xhsun.guildwars2wrapper.model.account;

import me.xhsun.guildwars2wrapper.model.util.Storage;

/**
 * For more info on Shared Inventory API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/inventory">here</a><br/>
 * Shared Inventory item model class<br/>
 * if slot is empty, return null
 *
 * @author xhsun
 * @see me.xhsun.guildwars2wrapper.model.Item item info
 * @since 2017-02-07
 */

public class SharedInventory extends Storage {
	private long skin;

	public long getSkin() {
		return skin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SharedInventory that = (SharedInventory) o;

		return getItemId() == that.getItemId() &&
				getCount() == that.getCount() &&
				getCharges() == that.getCharges() &&
				skin == that.skin &&
				getBinding() == that.getBinding();
	}

	@Override
	public int hashCode() {
		int result = (int) (getItemId() ^ (getItemId() >>> 32));
		result = 31 * result + getCount();
		result = 31 * result + getCharges();
		result = 31 * result + (getBinding() != null ? getBinding().hashCode() : 0);
		result = 31 * result + (int) (skin ^ (skin >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "SharedInventory{" +
				"id=" + getItemId() +
				", count=" + getCount() +
				", charges=" + getCharges() +
				", binding=" + getBinding() +
				", skin=" + skin +
				'}';
	}
}
