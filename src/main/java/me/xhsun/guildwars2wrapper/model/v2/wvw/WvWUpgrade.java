package me.xhsun.guildwars2wrapper.model.v2.wvw;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

import java.util.List;

/**
 * For more info on WvW upgrades API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">here</a><br/>
 * Model class for WvW upgrade
 *
 * @author xhsun
 * @since 2017-06-20
 */
public class WvWUpgrade extends IdentifiableInt {
	private List<Tier> tiers;

	public List<Tier> getTiers() {
		return tiers;
	}

	public class Tier {
		private String name, description;
		private int yaks_required;
		private List<Upgrade> upgrades;

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}

		public int getYaksRequired() {
			return yaks_required;
		}

		public List<Upgrade> getUpgrades() {
			return upgrades;
		}
	}

	public class Upgrade {
		private String name, description, icon;

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}

		public String getIcon() {
			return icon;
		}
	}
}
