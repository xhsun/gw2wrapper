package me.xhsun.guildwars2wrapper.model;

import me.xhsun.guildwars2wrapper.model.achievements.Achievement;

import java.util.List;

/**
 * For more info on titles API go <a href="https://wiki.guildwars2.com/wiki/API:2/titles">here</a><br/>
 * Model class for title
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Title {
	private int id;
	private String name;
	private int achievement;
	private List<Integer> achievements;
	private int ap_required;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Title title = (Title) o;

		return id == title.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "Title{" +
				"id=" + id +
				", name='" + name + '\'' +
				", achievement=" + achievement +
				", achievements=" + achievements +
				", ap_required=" + ap_required +
				'}';
	}
}
