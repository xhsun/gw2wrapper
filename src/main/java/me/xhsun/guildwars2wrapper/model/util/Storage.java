package me.xhsun.guildwars2wrapper.model.util;

/**
 * @author xhsun
 * @since 2017-02-13
 */
public class Storage {
	public enum Binding {Account, Character}

	private int id;
	private int count;
	private int charges;
	private Binding binding;
	private String bound_to;

	public int getItemId() {
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

	public String getBoundTo() {
		return bound_to;
	}
}
