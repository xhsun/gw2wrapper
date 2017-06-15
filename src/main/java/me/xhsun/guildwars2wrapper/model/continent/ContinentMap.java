package me.xhsun.guildwars2wrapper.model.continent;

import me.xhsun.guildwars2wrapper.model.indentifiable.*;
import me.xhsun.guildwars2wrapper.model.util.comm.Region;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * For more info on continents map API go <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
 * Model class for continents map
 *
 * @author xhsun
 * @since 2017-06-15
 */
public class ContinentMap extends NameableInt {
	public enum PoIType {landmark, waypoint, vista}

	private int min_level, max_level;
	private int default_floor;
	private double[] label_coord;
	private double[][] continent_rect, map_rect;
	private Map<Integer, PoI> points_of_interest;
	private Map<Integer, Task> tasks;
	private List<SkillChallenge> skill_challenges;
	private Map<Integer, Sector> sectors;
	private List<Adventure> adventures;
	private List<Mastery> mastery_points;

	public int getMin_level() {
		return min_level;
	}

	public int getMax_level() {
		return max_level;
	}

	public int getDefault_floor() {
		return default_floor;
	}

	public double[] getLabel_coord() {
		return label_coord;
	}

	public double[][] getContinent_rect() {
		return continent_rect;
	}

	public double[][] getMap_rect() {
		return map_rect;
	}

	public Map<Integer, PoI> getPoints_of_interest() {
		return points_of_interest;
	}

	public Map<Integer, Task> getTasks() {
		return tasks;
	}

	public List<SkillChallenge> getSkill_challenges() {
		return skill_challenges;
	}

	public Map<Integer, Sector> getSectors() {
		return sectors;
	}

	public List<Adventure> getAdventures() {
		return adventures;
	}

	public List<Mastery> getMastery_points() {
		return mastery_points;
	}

	@Override
	public String toString() {
		return "ContinentMap{" +
				super.toString() +
				"min_level=" + min_level +
				", max_level=" + max_level +
				", default_floor=" + default_floor +
				", label_coord=" + Arrays.toString(label_coord) +
				", continent_rect=" + Arrays.toString(continent_rect) +
				", map_rect=" + Arrays.toString(map_rect) +
				", points_of_interest=" + points_of_interest +
				", tasks=" + tasks +
				", skill_challenges=" + skill_challenges +
				", sectors=" + sectors +
				", adventures=" + adventures +
				", mastery_points=" + mastery_points +
				'}';
	}

	public class PoI extends Linkable {
		private PoIType type;
		private int floor;
		private double[] coord;

		public PoIType getType() {
			return type;
		}

		public int getFloor() {
			return floor;
		}

		public double[] getCoord() {
			return coord;
		}

		@Override
		public String toString() {
			return "PoI{" +
					super.toString() +
					", type=" + type +
					", floor=" + floor +
					", coord=" + Arrays.toString(coord) +
					'}';
		}
	}

	public class Sector extends Linkable {
		private int level;
		private double[] coord;
		private double[][] bounds;

		public int getLevel() {
			return level;
		}

		public double[] getCoord() {
			return coord;
		}

		public double[][] getBounds() {
			return bounds;
		}

		@Override
		public String toString() {
			return "Sector{" +
					super.toString() +
					"level=" + level +
					", coord=" + Arrays.toString(coord) +
					", bounds=" + Arrays.toString(bounds) +
					'}';
		}
	}

	public class Task extends IdentifiableInt {
		private String objective;
		private String chat_link;
		private int level;
		private double[] coord;
		private double[][] bounds;

		public String getObjective() {
			return objective;
		}

		public String getChatLink() {
			return chat_link;
		}

		public int getLevel() {
			return level;
		}

		public double[] getCoord() {
			return coord;
		}

		public double[][] getBounds() {
			return bounds;
		}

		@Override
		public String toString() {
			return "Task{" +
					"id=" + getId() +
					", objective='" + objective + '\'' +
					", chat_link='" + chat_link + '\'' +
					", level=" + level +
					", coord=" + Arrays.toString(coord) +
					", bounds=" + Arrays.toString(bounds) +
					'}';
		}
	}

	public class Mastery extends IdentifiableInt {
		private double[] coord;
		private Region region;

		public double[] getCoord() {
			return coord;
		}

		public Region getRegion() {
			return region;
		}

		@Override
		public String toString() {
			return "Mastery{" +
					"id=" + getId() +
					", coord=" + Arrays.toString(coord) +
					", region=" + region +
					'}';
		}
	}

	public class Adventure extends NameableStr {
		private String description;
		private double[] coord;

		public String getDescription() {
			return description;
		}

		public double[] getCoord() {
			return coord;
		}

		@Override
		public String toString() {
			return "Adventure{" +
					super.toString() +
					"description='" + description + '\'' +
					", coord=" + Arrays.toString(coord) +
					'}';
		}
	}

	public class SkillChallenge extends IdentifiableStr {
		private double[] coord;

		public double[] getCoord() {
			return coord;
		}

		@Override
		public String toString() {
			return "SkillChallenge{" +
					"id=" + getId() +
					", coord=" + Arrays.toString(coord) +
					'}';
		}
	}
}
