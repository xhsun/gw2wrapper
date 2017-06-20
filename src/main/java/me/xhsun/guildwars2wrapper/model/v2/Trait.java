package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;
import me.xhsun.guildwars2wrapper.model.v2.util.skillFact.SkillFact;
import me.xhsun.guildwars2wrapper.model.v2.util.skillFact.SkillTraitedFact;

import java.util.List;

/**
 * For more info on traits API go <a href="https://wiki.guildwars2.com/wiki/API:2/traits">here</a><br/>
 * Model class for traits
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class Trait extends NameableInt {
	public enum Slot {Major, Minor}

	private String icon, description;
	private Slot slot;
	private int specialization, tier, order;
	private List<SkillFact> facts;
	private List<SkillTraitedFact> traited_facts;
	private List<Skill> skills;

	public String getIcon() {
		return icon;
	}

	public String getDescription() {
		return description;
	}

	public Slot getSlot() {
		return slot;
	}

	public int getSpecialization() {
		return specialization;
	}

	public int getTier() {
		return tier;
	}

	public int getOrder() {
		return order;
	}

	public List<SkillFact> getFacts() {
		return facts;
	}

	public List<SkillTraitedFact> getTraited_facts() {
		return traited_facts;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public class Skill extends NameableInt {
		private String description, icon;
		private List<SkillFact> facts;
		private List<SkillTraitedFact> traited_facts;

		public String getDescription() {
			return description;
		}

		public String getIcon() {
			return icon;
		}

		public List<SkillFact> getFacts() {
			return facts;
		}

		public List<SkillTraitedFact> getTraited_facts() {
			return traited_facts;
		}
	}
}
