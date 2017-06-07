package me.xhsun.guildwars2wrapper.model;

/**
 * For more info on Mini API go <a href="https://wiki.guildwars2.com/wiki/API:2/minis">here</a><br/>
 * Model class for minis
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class Mini extends Identifiable {
	private String unlock;
	private String icon;
	private int order;
	private int item_id;

	/**
	 * @return A description of how to unlock the mini (only present on a few entries).
	 */
	public String getUnlock() {
		return unlock;
	}

	public String getIcon() {
		return icon;
	}

	public int getOrder() {
		return order;
	}

	public int getItemId() {
		return item_id;
	}

	@Override
	public String toString() {
		return "Mini{" +
				"id=" + getId() +
				", name='" + getName() + '\'' +
				", unlock='" + unlock + '\'' +
				", icon='" + icon + '\'' +
				", order=" + order +
				", item_id=" + item_id +
				'}';
	}
}
