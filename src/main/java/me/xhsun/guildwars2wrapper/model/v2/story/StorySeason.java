package me.xhsun.guildwars2wrapper.model.v2.story;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableStr;

import java.util.List;

/**
 * For more info on stories seasons API go <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">here</a><br/>
 * Model class for story season
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class StorySeason extends NameableStr {
	private int order;
	private List<Integer> stories;

	public int getOrder() {
		return order;
	}

	public List<Integer> getStories() {
		return stories;
	}
}
