package me.xhsun.guildwars2wrapper.model;

/**
 * For more info on Mini API go <a href="https://wiki.guildwars2.com/wiki/API:2/minis">here</a><br/>
 * Model class for minis
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class Mini {
	private int id;
	private String name;
	private String unlock;
	private String icon;
	private int order;
	private int item_id;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Mini minis = (Mini) o;

		return id == minis.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "Mini{" +
				"id=" + id +
				", name='" + name + '\'' +
				", unlock='" + unlock + '\'' +
				", icon='" + icon + '\'' +
				", order=" + order +
				", item_id=" + item_id +
				'}';
	}
}
