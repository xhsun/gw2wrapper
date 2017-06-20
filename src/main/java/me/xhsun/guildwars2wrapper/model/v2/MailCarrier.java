package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.Unlockable;

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
}
