package me.xhsun.guildwars2wrapper.model.v1;

import java.util.List;
import java.util.Map;

/**
 * For more info on event detail API go <a href="https://wiki.guildwars2.com/wiki/API:1/event_details">here</a><br/>
 * Model class for event detail
 *
 * @author xhsun
 * @since 2017-06-27
 */
public class EventDetail {
	public enum EventType {group_event, map_wide}

	public enum EventLocType {sphere, cylinder, poly}

	private Map<String, Event> events;

	/**
	 * @return Map of event id and event detail
	 */
	public Map<String, Event> getEvents() {
		return events;
	}

	public class Event {
		private String name;
		private int level, map_id;
		private List<EventType> flags;
		private EventLocation location;

		public String getName() {
			return name;
		}

		public int getLevel() {
			return level;
		}

		public int getMapId() {
			return map_id;
		}

		@Deprecated
		public int getMap_id() {
			return map_id;
		}

		public List<EventType> getFlags() {
			return flags;
		}

		public EventLocation getLocation() {
			return location;
		}
	}

	public class EventLocation {
		private EventLocType type;
		private double[] center, z_range;
		private double[][] points;
		private double height, radius, rotation;

		public EventLocType getType() {
			return type;
		}

		public double[] getCenter() {
			return center;
		}

		public double[] getZRange() {
			return z_range;
		}

		@Deprecated
		public double[] getZ_range() {
			return z_range;
		}

		public double[][] getPoints() {
			return points;
		}

		public double getHeight() {
			return height;
		}

		public double getRadius() {
			return radius;
		}

		public double getRotation() {
			return rotation;
		}
	}
}
