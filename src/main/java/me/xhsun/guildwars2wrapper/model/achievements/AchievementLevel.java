package me.xhsun.guildwars2wrapper.model.achievements;

/**
 * Class that contains info for required level for the daily/monthly achievement to appear
 *
 * @author xhsun
 * @see DailyAchievement daily achievement
 * @since 2017-06-07
 */
public class AchievementLevel {
	private int min, max;

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	@Override
	public String toString() {
		return "AchievementLevel{" +
				"min=" + min +
				", max=" + max +
				'}';
	}
}
