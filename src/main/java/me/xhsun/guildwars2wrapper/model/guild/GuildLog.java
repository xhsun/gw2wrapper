package me.xhsun.guildwars2wrapper.model.guild;

import me.xhsun.guildwars2wrapper.model.indentifiable.IdentifiableInt;

/**
 * For more info on guild log API go <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">here</a><br/>
 * Model class for guild log
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class GuildLog extends IdentifiableInt {
	public enum Type {
		joined, invited, kick, rank_change, treasury, stash, motd, upgrade
	}

	public enum Operation {deposit, withdraw}

	public enum Action {queued, cancelled, completed, sped_up}

	private String time, user, invited_by, kicked_by,
			changed_by, old_rank, new_rank, motd;
	private int item_id, upgrade_id, recipe_id, count;
	private long coins;
	private Type type;
	private Operation operation;
	private Action action;

	public String getTime() {
		return time;
	}

	public String getUser() {
		return user;
	}

	public String getInvited_by() {
		return invited_by;
	}

	public String getKicked_by() {
		return kicked_by;
	}

	public String getChanged_by() {
		return changed_by;
	}

	public String getOld_rank() {
		return old_rank;
	}

	public String getNew_rank() {
		return new_rank;
	}

	public String getMotd() {
		return motd;
	}

	public int getItem_id() {
		return item_id;
	}

	public int getUpgrade_id() {
		return upgrade_id;
	}

	public int getRecipe_id() {
		return recipe_id;
	}

	public int getCount() {
		return count;
	}

	public long getCoins() {
		return coins;
	}

	public Type getType() {
		return type;
	}

	public Operation getOperation() {
		return operation;
	}

	public Action getAction() {
		return action;
	}

	@Override
	public String toString() {
		return "GuildLog{" +
				"id=" + getId() +
				", time='" + time + '\'' +
				", user='" + user + '\'' +
				", invited_by='" + invited_by + '\'' +
				", kicked_by='" + kicked_by + '\'' +
				", changed_by='" + changed_by + '\'' +
				", old_rank='" + old_rank + '\'' +
				", new_rank='" + new_rank + '\'' +
				", motd='" + motd + '\'' +
				", item_id=" + item_id +
				", upgrade_id=" + upgrade_id +
				", recipe_id=" + recipe_id +
				", count=" + count +
				", coins=" + coins +
				", type=" + type +
				", operation=" + operation +
				", action=" + action +
				'}';
	}
}
