package me.xhsun.guildwars2wrapper.model.achievements;

import me.xhsun.guildwars2wrapper.model.indentifiable.NameableInt;

import java.util.List;

/**
 * For more info on achievements categories API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">here</a><br/>
 * Model class for achievement category
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class AchievementCategory extends NameableInt {
	private String description, icon;
	private int order;
	private List<Integer> achievements;

	public String getDescription() {
		return description;
	}

	public String getIcon() {
		return icon;
	}

	public int getOrder() {
		return order;
	}

	/**
	 * @return list of {@link Achievement#id}
	 */
	public List<Integer> getAchievements() {
		return achievements;
	}

	@Override
	public String toString() {
		return "MaterialCategory{" +
				"id=" + getId() +
				", name='" + getName() + '\'' +
				", description='" + description + '\'' +
				", icon='" + icon + '\'' +
				", order=" + order +
				", achievements=" + achievements +
				'}';
	}
}
