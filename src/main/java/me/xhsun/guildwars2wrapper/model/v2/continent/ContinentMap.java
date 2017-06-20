package me.xhsun.guildwars2wrapper.model.v2.continent;

import me.xhsun.guildwars2wrapper.model.identifiable.*;
import me.xhsun.guildwars2wrapper.model.v2.util.comm.Region;

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
	public enum PoIType {landmark, waypoint, vista, unlock}

	private int min_level, max_level;
	private int default_floor;
	private List<Integer> floors;
	private double[] label_coord;
	private double[][] continent_rect, map_rect;
	private Map<Integer, PoI> points_of_interest;
	private Map<Integer, Task> tasks;
	private List<SkillChallenge> skill_challenges;
	private Map<Integer, Sector> sectors;
	private List<Adventure> adventures;
	private List<Mastery> mastery_points;

	public int getMinLevel() {
		return min_level;
	}

	public int getMaxLevel() {
		return max_level;
	}

	public int getDefaultFloor() {
		return default_floor;
	}

	public List<Integer> getFloors() {
		return floors;
	}

	public double[] getLabelCoord() {
		return label_coord;
	}

	public double[][] getContinentRect() {
		return continent_rect;
	}

	public double[][] getMapRect() {
		return map_rect;
	}

	public Map<Integer, PoI> getPointsOfInterest() {
		return points_of_interest;
	}

	public Map<Integer, Task> getTasks() {
		return tasks;
	}

	public List<SkillChallenge> getSkillChallenges() {
		return skill_challenges;
	}

	public Map<Integer, Sector> getSectors() {
		return sectors;
	}

	public List<Adventure> getAdventures() {
		return adventures;
	}

	public List<Mastery> getMasteryPoints() {
		return mastery_points;
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
	}

	public class SkillChallenge extends IdentifiableStr {
		private double[] coord;

		public double[] getCoord() {
			return coord;
		}
	}
}
