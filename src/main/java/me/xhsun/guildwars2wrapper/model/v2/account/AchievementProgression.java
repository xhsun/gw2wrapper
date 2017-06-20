package me.xhsun.guildwars2wrapper.model.v2.account;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

/**
 * For more info on Account Achievements API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/achievements">here</a><br/>
 * Model class for account achievement
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class AchievementProgression extends IdentifiableInt {
	private int current;
	private int max;//default -1 or 0
	private boolean done;
	private long repeated;
	private int[] bits;

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
}
