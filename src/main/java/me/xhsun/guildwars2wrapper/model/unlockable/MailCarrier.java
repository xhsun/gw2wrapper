package me.xhsun.guildwars2wrapper.model.unlockable;

import java.util.Arrays;
import java.util.List;

/**
 * For more info on mail carriers API go <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">here</a><br/>
 * Model class for mail carrier
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class MailCarrier extends Unlockable {
	private List<String> flags;

	public List<String> getFlags() {
		return flags;
	}

	@Override
	public String toString() {
		return "MailCarrier{" +
				"id=" + getId() +
				", unlock_items=" + Arrays.toString(getUnlockItems()) +
				", order=" + getOrder() +
				", icon='" + getIcon() + '\'' +
				", name='" + getName() + '\'' +
				", flags=" + flags +
				'}';
	}
}
