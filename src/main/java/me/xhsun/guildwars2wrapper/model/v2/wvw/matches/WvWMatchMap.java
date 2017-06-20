package me.xhsun.guildwars2wrapper.model.v2.wvw.matches;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;
import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableStr;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWObjective;

import java.util.List;

/**
 * Template class for Map objects in WvW Matches
 *
 * @author xhsun
 * @since 2017-06-20
 */
public class WvWMatchMap extends IdentifiableInt {
	public enum Team {Red, Green, Blue, Neutral}

	public enum BonusType {Bloodlust}

	public enum Type {Center, RedHome, BlueHome, GreenHome, EdgeOfTheMists}

	private Type type;

	public Type getType() {
		return type;
	}

	public class Bonus {
		private BonusType type;
		private Team owner;

		public BonusType getType() {
			return type;
		}

		public Team getOwner() {
			return owner;
		}
	}

	public class Objective extends IdentifiableStr {
		private Team owner;
		private WvWObjective.Type type;
		private String last_flipped, claimed_by, claimed_at;
		private int points_tick, points_capture, yaks_delivered;
		private List<Integer> guild_upgrades;

		public Team getOwner() {
			return owner;
		}

		public WvWObjective.Type getType() {
			return type;
		}

		public String getLastFlipped() {
			return last_flipped;
		}

		public String getClaimedBy() {
			return claimed_by;
		}

		public String getClaimedAt() {
			return claimed_at;
		}

		public int getPointsTick() {
			return points_tick;
		}

		public int getPointsCapture() {
			return points_capture;
		}

		public int getYaksDelivered() {
			return yaks_delivered;
		}

		public List<Integer> getGuildUpgrades() {
			return guild_upgrades;
		}
	}
}
