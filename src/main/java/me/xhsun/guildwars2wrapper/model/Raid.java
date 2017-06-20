package me.xhsun.guildwars2wrapper.model;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableStr;

import java.util.List;

/**
 * For more info on raids API go <a href="https://wiki.guildwars2.com/wiki/API:2/raids">here</a><br/>
 * Model class for raid
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Raid extends IdentifiableStr {
	public enum EventType {Checkpoint, Boss}
	private List<Wing> wings;

	public List<Wing> getWings() {
		return wings;
	}

	@Override
	public String toString() {
		return "Raid{" +
				"id='" + getId() + '\'' +
				", wings=" + wings +
				'}';
	}

	public class Wing extends IdentifiableStr {
		private List<Event> events;

		public List<Event> getEvents() {
			return events;
		}

		@Override
		public String toString() {
			return "Wing{" +
					"id='" + getId() + '\'' +
					", events=" + events +
					'}';
		}
	}

	public class Event extends IdentifiableStr {
		private EventType type;

		public EventType getType() {
			return type;
		}

		@Override
		public String toString() {
			return "Event{" +
					"id='" + getId() + '\'' +
					", type=" + type +
					'}';
		}
	}
}
