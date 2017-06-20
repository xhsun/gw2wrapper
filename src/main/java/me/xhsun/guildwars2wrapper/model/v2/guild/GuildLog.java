package me.xhsun.guildwars2wrapper.model.v2.guild;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

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

	public String getInvitedBy() {
		return invited_by;
	}

	public String getKickedBy() {
		return kicked_by;
	}

	public String getChangedBy() {
		return changed_by;
	}

	public String getOldRank() {
		return old_rank;
	}

	public String getNewRank() {
		return new_rank;
	}

	public String getMotd() {
		return motd;
	}

	public int getItemId() {
		return item_id;
	}

	public int getUpgradeId() {
		return upgrade_id;
	}

	public int getRecipeId() {
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
}
