package me.xhsun.guildwars2wrapper.model.account;

import java.util.Arrays;

/**
 * For more info on Account Achievements API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/achievements">here</a><br/>
 * Model class for account achievements
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class AchievementProgression {
	private int id;
	private int current;
	private int max;//default -1 or 0
	private boolean done;
	private long repeated;
	private int[] bits;

	public int getId() {
		return id;
	}

	public int getCurrent() {
		return current;
	}

	/**
	 * this number can be negative
	 *
	 * @return amount needed to complete an achievement
	 */
	public int getMax() {
		return max;
	}

	public boolean isDone() {
		return done;
	}

	public long getRepeated() {
		return repeated;
	}

	/**
	 * giving more specific information on the progress for the achievement<br/>
	 * Note: meaning of bits will added in the future
	 *
	 * @return array of ints
	 */
	public int[] getBits() {
		return bits;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AchievementProgression that = (AchievementProgression) o;

		return id == that.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "AchievementProgression{" +
				"id=" + id +
				", current=" + current +
				", max=" + max +
				", done=" + done +
				", repeated=" + repeated +
				", bits=" + Arrays.toString(bits) +
				'}';
	}
}
