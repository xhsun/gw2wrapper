package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;
import me.xhsun.guildwars2wrapper.model.v2.achievement.Achievement;

import java.util.List;

/**
 * For more info on titles API go <a href="https://wiki.guildwars2.com/wiki/API:2/titles">here</a><br/>
 * Model class for title
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Title extends NameableInt {
	private int achievement;
	private List<Integer> achievements;
	private int ap_required;

	/**
	 * @return {@link Achievement} id
	 */
	public int getAchievement() {
		return achievement;
	}

	/**
	 * @return list of {@link Achievement} id
	 */
	public List<Integer> getAchievements() {
		return achievements;
	}

	public int getApRequired() {
		return ap_required;
	}
}
