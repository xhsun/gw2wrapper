package me.xhsun.guildwars2wrapper.model.unlockable;

import java.util.Arrays;

/**
 * For more info on mail carriers API go <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">here</a><br/>
 * Model class for mail carrier
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class MailCarrier extends Unlockable {
	private String[] flags;

	public String[] getFlags() {
		return flags;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MailCarrier that = (MailCarrier) o;

		return getId() == that.getId();
	}

	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public String toString() {
		return "MailCarrier{" +
				"id=" + getId() +
				", unlock_items=" + Arrays.toString(getUnlockItems()) +
				", order=" + getOrder() +
				", icon='" + getIcon() + '\'' +
				", name='" + getName() + '\'' +
				", flags=" + Arrays.toString(flags) +
				'}';
	}
}
