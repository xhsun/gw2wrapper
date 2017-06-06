package me.xhsun.guildwars2wrapper.model.unlockable;

import java.util.Arrays;

/**
 * For more info on Finishers API go <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">here</a><br/>
 * Model class for finisher
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Finisher extends Unlockable {
	private String unlock_details;

	public String getUnlockDetails() {
		return unlock_details;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Finisher finisher = (Finisher) o;

		return getId() == finisher.getId();
	}

	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public String toString() {
		return "Finisher{" +
				"id=" + getId() +
				", unlock_details='" + unlock_details + '\'' +
				", unlock_items=" + Arrays.toString(getUnlockItems()) +
				", order=" + getOrder() +
				", icon='" + getIcon() + '\'' +
				", name='" + getName() + '\'' +
				'}';
	}
}
