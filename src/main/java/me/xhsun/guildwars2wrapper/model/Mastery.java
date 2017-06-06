package me.xhsun.guildwars2wrapper.model;

import me.xhsun.guildwars2wrapper.model.util.comm.Region;

import java.util.Arrays;

/**
 * For more info on masteries API go <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">here</a><br/>
 * Model class for mastery
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Mastery {
	private int id;
	private String name;
	private String requirement;
	private int order;
	private String background;
	private Region region;
	private Detail[] levels;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

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

	public Detail[] getLevels() {
		return levels;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Mastery mastery = (Mastery) o;

		return id == mastery.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "Mastery{" +
				"id=" + id +
				", name='" + name + '\'' +
				", requirement='" + requirement + '\'' +
				", order=" + order +
				", background='" + background + '\'' +
				", region=" + region +
				", levels=" + Arrays.toString(levels) +
				'}';
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

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Detail details = (Detail) o;

			return point_cost == details.point_cost &&
					exp_cost == details.exp_cost &&
					(name != null ? name.equals(details.name) : details.name == null) &&
					(description != null ? description.equals(details.description) : details.description == null) &&
					(instruction != null ? instruction.equals(details.instruction) : details.instruction == null) &&
					(icon != null ? icon.equals(details.icon) : details.icon == null);
		}

		@Override
		public int hashCode() {
			int result = name != null ? name.hashCode() : 0;
			result = 31 * result + (description != null ? description.hashCode() : 0);
			result = 31 * result + (instruction != null ? instruction.hashCode() : 0);
			result = 31 * result + (icon != null ? icon.hashCode() : 0);
			result = 31 * result + point_cost;
			result = 31 * result + exp_cost;
			return result;
		}

		@Override
		public String toString() {
			return "Details{" +
					"name='" + name + '\'' +
					", description='" + description + '\'' +
					", instruction='" + instruction + '\'' +
					", icon='" + icon + '\'' +
					", point_cost=" + point_cost +
					", exp_cost=" + exp_cost +
					'}';
		}
	}
}
