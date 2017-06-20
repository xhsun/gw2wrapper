package me.xhsun.guildwars2wrapper.model.v2.util.skillFact;

import me.xhsun.guildwars2wrapper.model.v2.Skill;

/**
 * ProfessionSkill traited fact class for {@link Skill}
 *
 * @author xhsun
 * @since 2017-06-17
 */
public class SkillTraitedFact extends SkillFact {
	private int requires_trait, overrides;

	public int getRequiresTrait() {
		return requires_trait;
	}

	public int getOverrides() {
		return overrides;
	}
}
