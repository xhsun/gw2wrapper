package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

/**
 * For more info on cats API go <a href="https://wiki.guildwars2.com/wiki/API:2/cats">here</a><br/>
 * Model class for cats
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class Cat extends IdentifiableInt {
	private String hint;

	public String getHint() {
		return hint;
	}
}
