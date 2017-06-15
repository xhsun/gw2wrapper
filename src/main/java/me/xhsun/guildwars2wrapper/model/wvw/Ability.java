package me.xhsun.guildwars2wrapper.model.wvw;

import me.xhsun.guildwars2wrapper.model.indentifiable.NameableInt;

import java.util.List;

/**
 * For more info on WvW abilities API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">here</a><br/>
 * Model class for WvW abilities
 *
 * @author xhsun
 * @since 2017-06-15
 */
public class Ability extends NameableInt {
	private String icon, description;
	private List<Rank> ranks;

	public String getIcon() {
		return icon;
	}

	public String getDescription() {
		return description;
	}

	public List<Rank> getRanks() {
		return ranks;
	}

	@Override
	public String toString() {
		return "Ability{" +
				super.toString() +
				", icon='" + icon + '\'' +
				", description='" + description + '\'' +
				", ranks=" + ranks +
				'}';
	}

	public class Rank {
		private int cost;
		private String effect;

		public int getCost() {
			return cost;
		}

		public String getEffect() {
			return effect;
		}

		@Override
		public String toString() {
			return "Rank{" +
					"cost=" + cost +
					", effect='" + effect + '\'' +
					'}';
		}
	}
}
