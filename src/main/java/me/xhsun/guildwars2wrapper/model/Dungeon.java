package me.xhsun.guildwars2wrapper.model;

import java.util.Arrays;

/**
 * For more info on Dungeons API go <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">here</a><br/>
 * Model class for dungeon
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Dungeon {
	private String id;
	private Path[] paths;

	public String getId() {
		return id;
	}

	public Path[] getPaths() {
		return paths;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Dungeon dungeon = (Dungeon) o;

		return id != null ? id.equals(dungeon.id) : dungeon.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Dungeon{" +
				"id='" + id + '\'' +
				", paths=" + Arrays.toString(paths) +
				'}';
	}

	public class Path {
		private String id;

		public String getId() {
			return id;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Path path = (Path) o;

			return id != null ? id.equals(path.id) : path.id == null;
		}

		@Override
		public int hashCode() {
			return id != null ? id.hashCode() : 0;
		}

		@Override
		public String toString() {
			return "Path{" +
					"id='" + id + '\'' +
					'}';
		}
	}
}
