package xhsun.gw2api.guildwars2.model.util;

/**
 * @author xhsun
 * @since 2017-02-13
 */
public class Storage {
	public enum Binding{Account, Character}
	private long id;
	private int count;

	public long getItemId() {
		return id;
	}

	public int getCount() {
		return count;
	}
}
