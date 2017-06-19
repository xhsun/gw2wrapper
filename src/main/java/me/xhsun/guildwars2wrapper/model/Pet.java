package me.xhsun.guildwars2wrapper.model;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;
import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;

import java.util.List;

/**
 * For more info on pets API go <a href="https://wiki.guildwars2.com/wiki/API:2/pets">here</a><br/>
 * Model class for pets
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class Pet extends NameableInt {
	private String description, icon;
	private List<IdentifiableInt> skills;

	public String getDescription() {
		return description;
	}

	public String getIcon() {
		return icon;
	}

	public List<IdentifiableInt> getSkills() {
		return skills;
	}

	@Override
	public String toString() {
		return "Pet{" +
				super.toString() +
				", description='" + description + '\'' +
				", icon='" + icon + '\'' +
				", skills=" + skills +
				'}';
	}
}
