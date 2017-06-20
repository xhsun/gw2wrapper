package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

import java.util.List;

/**
 * For more info on emblem API go <a href="https://wiki.guildwars2.com/wiki/API:2/emblem">here</a><br/>
 * Model class for emblem
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class Emblem extends IdentifiableInt {
	public enum Type {foregrounds, backgrounds}

	private List<String> layers;

	public List<String> getLayers() {
		return layers;
	}
}
