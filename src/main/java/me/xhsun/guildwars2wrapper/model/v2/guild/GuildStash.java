package me.xhsun.guildwars2wrapper.model.v2.guild;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

import java.util.List;

/**
 * For more info on guild stash API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/stash">here</a><br/>
 * Model class for guild stash
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class GuildStash {
	private int upgrade_id, size;
	private long coins;
	private String note;
	private List<Inventory> inventory;

	public int getUpgradeId() {
		return upgrade_id;
	}

	public int getSize() {
		return size;
	}

	public long getCoins() {
		return coins;
	}

	public String getNote() {
		return note;
	}

	public List<Inventory> getInventory() {
		return inventory;
	}

	public class Inventory extends IdentifiableInt {
		private int count;

		public int getCount() {
			return count;
		}
	}
}
