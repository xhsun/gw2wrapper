package me.xhsun.guildwars2wrapper.model.v2;

/**
 * For more info on build API go <a href="https://wiki.guildwars2.com/wiki/API:2/build">here</a><br/>
 * Model class for current game guild
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class GameBuild {
	private long id;

	public long getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		GameBuild build = (GameBuild) o;

		return id == build.id;
	}

	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}
}
