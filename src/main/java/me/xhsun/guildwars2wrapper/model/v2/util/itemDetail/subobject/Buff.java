package me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.subobject;

/**
 * Infix Buff model class
 *
 * @author xhsun
 * @see InfixUpgrade infix upgrade
 * @since 2017-02-10
 */

public class Buff {
	private int skill_id;
	private String description;

	public String getDescription() {
		return description;
	}

	public int getSkillID() {
		return skill_id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Buff buff = (Buff) o;

		return (skill_id == buff.skill_id);
	}

	@Override
	public int hashCode() {
		return skill_id;
	}
}
