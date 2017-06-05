package me.xhsun.guildwars2wrapper.model.colors;

import java.util.Arrays;
import java.util.List;

/**
 * For more info on Colors API go <a href="https://wiki.guildwars2.com/wiki/API:2/colors">here</a><br/>
 * Model class for color
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class Color {
	public enum Categories {
		Gray, Brown, Red, Orange, Yellow, Green, Blue, Purple,
		Vibrant, Leather, Metal,
		Starter, Common, Uncommon, Rare
	}

	private long id;
	private String name;
	private int[] base_rgb;
	private ColorDetail cloth;
	private ColorDetail leather;
	private ColorDetail metal;
	private long item;//item id for the dye
	private List<Categories> categories;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int[] getBase_rgb() {
		return base_rgb;
	}

	public ColorDetail getCloth() {
		return cloth;
	}

	public ColorDetail getLeather() {
		return leather;
	}

	public ColorDetail getMetal() {
		return metal;
	}

	/**
	 * @return id for {@link me.xhsun.guildwars2wrapper.model.Item}
	 */
	public long getItem() {
		return item;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Color color = (Color) o;

		return id == color.id && item == color.item;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (int) (item ^ (item >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Color{" +
				"id=" + id +
				", name='" + name + '\'' +
				", base_rgb=" + Arrays.toString(base_rgb) +
				", cloth=" + cloth +
				", leather=" + leather +
				", metal=" + metal +
				", item=" + item +
				", categories=" + categories +
				'}';
	}
}
