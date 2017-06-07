package me.xhsun.guildwars2wrapper.model;

import java.util.List;

/**
 * For more info on raids API go <a href="https://wiki.guildwars2.com/wiki/API:2/raids">here</a><br/>
 * Model class for raid
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Raid {
	public enum EventType {Checkpoint, Boss}

	private String id;
	private List<Wing> wings;

	public String getId() {
		return id;
	}

	public List<Wing> getWings() {
		return wings;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Raid raid = (Raid) o;

		return id != null ? id.equals(raid.id) : raid.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Raid{" +
				"id='" + id + '\'' +
				", wings=" + wings +
				'}';
	}

	public class Wing {
		private String id;
		private List<Event> events;

		public String getId() {
			return id;
		}

		public List<Event> getEvents() {
			return events;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Wing wing = (Wing) o;

			return id != null ? id.equals(wing.id) : wing.id == null;
		}

		@Override
		public int hashCode() {
			return id != null ? id.hashCode() : 0;
		}

		@Override
		public String toString() {
			return "Wing{" +
					"id='" + id + '\'' +
					", events=" + events +
					'}';
		}
	}

	public class Event {
		private String id;
		private EventType type;

		public String getId() {
			return id;
		}

		public EventType getType() {
			return type;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Event event = (Event) o;

			return id != null ? id.equals(event.id) : event.id == null;
		}

		@Override
		public int hashCode() {
			return id != null ? id.hashCode() : 0;
		}

		@Override
		public String toString() {
			return "Event{" +
					"id='" + id + '\'' +
					", type=" + type +
					'}';
		}
	}
}
