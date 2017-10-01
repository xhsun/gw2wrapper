package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableStr;

import java.util.List;

/**
 * For more info on Dungeons API go <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">here</a><br/>
 * Model class for dungeon
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Dungeon extends IdentifiableStr {
	public enum PathType {Story, Explorable}
	private List<Path> paths;

	public List<Path> getPaths() {
		return paths;
	}

	public class Path extends IdentifiableStr {
		private PathType type;

		public PathType getType() {
			return type;
		}
	}
}
