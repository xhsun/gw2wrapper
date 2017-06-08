package me.xhsun.guildwars2wrapper.model.achievements;

import me.xhsun.guildwars2wrapper.model.indentifiable.IdentifiableStr;

import java.util.List;

/**
 * For more info on achievements groups API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">here</a><br/>
 * Model class for achievement group
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class AchievementGroup extends IdentifiableStr {
	private String name, description;
	private int order;
	private List<Integer> categories;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getOrder() {
		return order;
	}

	/**
	 * @return list of {@link AchievementCategory#id}
	 */
	public List<Integer> getCategories() {
		return categories;
	}

	@Override
	public String toString() {
		return "AchievementGroup{" +
				"id='" + getId() + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", order=" + order +
				", categories=" + categories +
				'}';
	}
}
