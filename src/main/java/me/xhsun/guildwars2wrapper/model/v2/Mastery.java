package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;
import me.xhsun.guildwars2wrapper.model.v2.util.comm.Region;

import java.util.List;

/**
 * For more info on masteries API go <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">here</a><br/>
 * Model class for mastery
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Mastery extends NameableInt {
	private String requirement;
	private int order;
	private String background;
	private Region region;
	private List<Detail> levels;

	public String getRequirement() {
		return requirement;
	}

	public int getOrder() {
		return order;
	}

	public String getBackground() {
		return background;
	}

	public Region getRegion() {
		return region;
	}

	public List<Detail> getLevels() {
		return levels;
	}

	public class Detail {
		private String name;
		private String description;
		private String instruction;
		private String icon;
		private int point_cost;
		private int exp_cost;

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}

		public String getInstruction() {
			return instruction;
		}

		public String getIcon() {
			return icon;
		}

		public int getPointCost() {
			return point_cost;
		}

		public int getExpCost() {
			return exp_cost;
		}
	}
}
