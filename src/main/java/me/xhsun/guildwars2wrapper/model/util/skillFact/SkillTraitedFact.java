package me.xhsun.guildwars2wrapper.model.util.skillFact;

/**
 * Skill traited fact class for {@link me.xhsun.guildwars2wrapper.model.Skill}
 *
 * @author xhsun
 * @since 2017-06-17
 */
public class SkillTraitedFact extends SkillFact {
	private int requires_trait, overrides;

	public int getRequires_trait() {
		return requires_trait;
	}

	public int getOverrides() {
		return overrides;
	}

	@Override
	public String toString() {
		return "SkillTraitedFact{" +
				super.toString() +
				", requires_trait=" + requires_trait +
				", overrides=" + overrides +
				'}';
	}
}
