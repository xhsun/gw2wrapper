package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableStr;

import java.util.List;

/**
 * For more info on legends API go <a href="https://wiki.guildwars2.com/wiki/API:2/legends">here</a><br/>
 * Model class for legend
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class Legend extends IdentifiableStr {
	private int swap, heal, elite;
	private List<Integer> utilities;

	public int getSwap() {
		return swap;
	}

	public int getHeal() {
		return heal;
	}

	public int getElite() {
		return elite;
	}

	public List<Integer> getUtilities() {
		return utilities;
	}
}
