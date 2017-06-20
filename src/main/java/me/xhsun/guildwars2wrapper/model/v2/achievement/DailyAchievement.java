package me.xhsun.guildwars2wrapper.model.v2.achievement;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;
import me.xhsun.guildwars2wrapper.model.v2.account.Account;

import java.util.List;

/**
 * For more info on achievement daily API go <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/daily">here</a><br/>
 * Model class for achievement daily
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class DailyAchievement {
	private List<Daily> pve, pvp, wvw, fractals, special;

	public List<Daily> getPve() {
		return pve;
	}

	public List<Daily> getPvp() {
		return pvp;
	}

	public List<Daily> getWvw() {
		return wvw;
	}

	public List<Daily> getFractals() {
		return fractals;
	}

	public List<Daily> getSpecial() {
		return special;
	}

	public class Daily extends IdentifiableInt {
		private AchievementLevel level;
		private List<Account.Access> required_access;

		public AchievementLevel getLevel() {
			return level;
		}

		public List<Account.Access> getRequiredAccess() {
			return required_access;
		}

	}

	public class AchievementLevel {
		private int min, max;

		public int getMin() {
			return min;
		}

		public int getMax() {
			return max;
		}

	}
}
