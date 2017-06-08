package me.xhsun.guildwars2wrapper.model.account;

import me.xhsun.guildwars2wrapper.model.indentifiable.IdentifiableInt;

/**
 * <a href="https://wiki.guildwars2.com/wiki/API:2/account/home/cats">Cat</a>
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class Cat extends IdentifiableInt {
	private String hint;

	public String getHint() {
		return hint;
	}

	@Override
	public String toString() {
		return "Cat{" +
				"id=" + getId() +
				", hint='" + hint + '\'' +
				'}';
	}
}
