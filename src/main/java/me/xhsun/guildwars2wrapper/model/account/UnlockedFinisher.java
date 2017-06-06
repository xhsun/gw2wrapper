package me.xhsun.guildwars2wrapper.model.account;

/**
 * For more info on Account finishers API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/finishers">here</a><br/>
 * Model class for account finishers
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class UnlockedFinisher {
	private int id;//TODO /v2/finishers
	private boolean permanent;
	private int quantity;

	public int getId() {
		return id;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UnlockedFinisher finisher = (UnlockedFinisher) o;

		return id == finisher.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "UnlockedFinisher{" +
				"id=" + id +
				", permanent=" + permanent +
				", quantity=" + quantity +
				'}';
	}
}
