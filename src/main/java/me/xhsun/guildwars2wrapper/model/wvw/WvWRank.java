package me.xhsun.guildwars2wrapper.model.wvw;

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

	public int getMin_rank() {
		return min_rank;
	}

	@Override
	public String toString() {
		return "WvWRank{" +
				"id=" + getId() +
				", title='" + title + '\'' +
				", min_rank=" + min_rank +
				'}';
	}
}
