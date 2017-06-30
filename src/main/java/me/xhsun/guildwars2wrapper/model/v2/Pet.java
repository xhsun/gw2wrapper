package me.xhsun.guildwars2wrapper.model.v2;

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
	private List<Skills> skills;

	public String getDescription() {
		return description;
	}

	public String getIcon() {
		return icon;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public class Skills extends IdentifiableInt {
	}
}
