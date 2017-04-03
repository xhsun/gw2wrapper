package xhsun.gw2api.guildwars2.model.util;

/**
 * @author xhsun
 * @since 2017-02-13
 */
public class Storage {
	public enum Binding{Account, Character}
	private long id;
	private int count;
	private int charges;
	private Binding binding;
	private String bound_to;

	public long getItemId() {
		return id;
	}

	public int getCount() {
		return count;
	}

	public int getCharges() {
		return charges;
	}

	public Binding getBinding() {
		return binding;
	}

	public String getBound_to() {
		return bound_to;
	}
}
