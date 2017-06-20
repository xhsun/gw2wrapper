package me.xhsun.guildwars2wrapper.model.v2.wvw;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

/**
 * For more info on WvW ranks API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">here</a><br/>
 * Model class for WvW rank
 *
 * @author xhsun
 * @since 2017-06-20
 */
public class WvWRank extends IdentifiableInt {
	private String title;
	private int min_rank;

	public String getTitle() {
		return title;
	}

	public int getMinRank() {
		return min_rank;
	}
}
