package me.xhsun.guildwars2wrapper.model;

import java.util.Arrays;

/**
 * For more info on Finishers API go <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">here</a><br/>
 * Model class for finisher
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Finisher {
	private int id;
	private String unlock_details;
	private int[] unlock_items;//item ids
	private int order;
	private String icon;
	private String name;

	public int getId() {
		return id;
	}

	public String getUnlock_details() {
		return unlock_details;
	}

	public int[] getUnlock_items() {
		return unlock_items;
	}

	public int getOrder() {
		return order;
	}

	public String getIcon() {
		return icon;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Finisher finisher = (Finisher) o;

		return id == finisher.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "Finisher{" +
				"id=" + id +
				", unlock_details='" + unlock_details + '\'' +
				", unlock_items=" + Arrays.toString(unlock_items) +
				", order=" + order +
				", icon='" + icon + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
