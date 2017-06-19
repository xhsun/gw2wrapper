package me.xhsun.guildwars2wrapper.model.story;

import me.xhsun.guildwars2wrapper.model.Item;
import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;

import java.util.List;

/**
 * For more info on stories API go <a href="https://wiki.guildwars2.com/wiki/API:2/stories">here</a><br/>
 * Model class for story
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class Story extends NameableInt {
	private enum Flag {RequiresUnlock}

	private String season, description, timeline;
	private int level, order;
	private List<Chapter> chapters;
	private List<Item.Restriction> races;
	private List<Flag> flags;

	public String getSeason() {
		return season;
	}

	public String getDescription() {
		return description;
	}

	public String getTimeline() {
		return timeline;
	}

	public int getLevel() {
		return level;
	}

	public int getOrder() {
		return order;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public List<Item.Restriction> getRaces() {
		return races;
	}

	public List<Flag> getFlags() {
		return flags;
	}

	@Override
	public String toString() {
		return "Story{" +
				super.toString() +
				", season='" + season + '\'' +
				", description='" + description + '\'' +
				", timeline='" + timeline + '\'' +
				", level=" + level +
				", order=" + order +
				", chapters=" + chapters +
				", races=" + races +
				", flags=" + flags +
				'}';
	}

	public class Chapter {
		private String name;

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return "Chapters{" +
					"name='" + name + '\'' +
					'}';
		}
	}
}
