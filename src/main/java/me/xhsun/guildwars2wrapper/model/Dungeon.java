package me.xhsun.guildwars2wrapper.model;

import me.xhsun.guildwars2wrapper.model.indentifiable.IdentifiableStr;

import java.util.List;

/**
 * For more info on Dungeons API go <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">here</a><br/>
 * Model class for dungeon
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Dungeon extends IdentifiableStr {
	private List<Path> paths;

	public List<Path> getPaths() {
		return paths;
	}

	@Override
	public String toString() {
		return "Dungeon{" +
				"id='" + getId() + '\'' +
				", paths=" + paths +
				'}';
	}

	public class Path extends IdentifiableStr {

		@Override
		public String toString() {
			return "Path{" +
					"id='" + getId() + '\'' +
					'}';
		}
	}
}
