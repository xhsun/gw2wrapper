package me.xhsun.guildwars2wrapper.model.v2.guild;

import java.util.List;

/**
 * For more info on guild treasury API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/treasury">here</a><br/>
 * Model class for guild treasury
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class GuildTreasury {
	private int item_id, count;
	private List<NeedBy> needed_by;

	public int getItemId() {
		return item_id;
	}

	public int getCount() {
		return count;
	}

	public List<NeedBy> getNeededBy() {
		return needed_by;
	}

	public class NeedBy {
		private int upgrade_id, count;

		public int getUpgradeId() {
			return upgrade_id;
		}

		public int getCount() {
			return count;
		}
	}
}
