package me.xhsun.guildwars2wrapper.model;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;

import java.util.List;

/**
 * For more info on specializations API go <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">here</a><br/>
 * Model class for specialization
 *
 * @author xhsun
 * @since 2017-06-15
 */
public class Specialization extends NameableInt {
	private Item.Restriction profession;
	private boolean elite;
	private String background, icon;
	private List<Integer> minor_traits, major_traits;

	public Item.Restriction getProfession() {
		return profession;
	}

	public boolean isElite() {
		return elite;
	}

	public String getIcon() {
		return icon;
	}

	public String getBackground() {
		return background;
	}

	public List<Integer> getMinor_traits() {
		return minor_traits;
	}

	public List<Integer> getMajor_traits() {
		return major_traits;
	}

	@Override
	public String toString() {
		return "Specialization{" +
				super.toString() +
				", profession=" + profession +
				", elite=" + elite +
				", icon='" + icon + '\'' +
				", background='" + background + '\'' +
				", minor_traits=" + minor_traits +
				", major_traits=" + major_traits +
				'}';
	}
}
