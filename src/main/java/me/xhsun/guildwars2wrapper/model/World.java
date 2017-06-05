package me.xhsun.guildwars2wrapper.model;

/**
 * For more info on World API go <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">here</a><br/>
 * World detail model class<br/>
 * -id:<br/>
 * &#32;&#32;-first digit indicates the world's region<br/>
 * &#32;&#32;&#32;- 1:NA, 2:EU<br/>
 * &#32;&#32;-second digit currently correlates with world's assigned language<br/>
 * &#32;&#32;&#32;- 1:French, 2:German, 3: Spanish, 0:English or Unknown (?)<br/>
 * Note: I'm not sure what the second digit means exactly, so I will not provide a getLanguage method
 *
 * @author xhsun
 * @since 2017-02-07
 */

public class World {
	public enum Region {EU, NA, ERROR}

	private int id;
	private String name;
	private String population;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Region getRegion() {
		switch (Integer.parseInt(Integer.toString(id).substring(0, 1))) {
			case 1:
				return Region.NA;
			case 2:
				return Region.EU;
			default:
				return Region.ERROR;
		}
	}

	public String getPopulation() {
		return population;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		World world = (World) o;

		return id == world.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "World{" +
				"id=" + id +
				", name='" + name + '\'' +
				", population='" + population + '\'' +
				'}';
	}
}
