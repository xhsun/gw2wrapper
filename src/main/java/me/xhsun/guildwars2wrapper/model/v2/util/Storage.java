package me.xhsun.guildwars2wrapper.model.v2.util;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

/**
 * @author xhsun
 * @since 2017-02-13
 */
public class Storage extends IdentifiableInt {
	public enum Binding {Account, Character}
	private int count;
	private int charges;
	private Binding binding;
	private String bound_to;

	public int getItemId() {
		return getId();
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
