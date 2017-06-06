package me.xhsun.guildwars2wrapper.model.account;

/**
 * For more info on Account masteries API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/masteries">here</a><br/>
 * Model class of account masteries
 * TODO /v2/masteries
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class UnlockedMastery {
	private int id;
	private int level;

	public int getId() {
		return id;
	}

	/**
	 * @return level at which the mastery is on the account | 0 if not started
	 */
	public int getLevel() {
		return level;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UnlockedMastery that = (UnlockedMastery) o;

		return id == that.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "UnlockedMastery{" +
				"id=" + id +
				", level=" + level +
				'}';
	}
}
