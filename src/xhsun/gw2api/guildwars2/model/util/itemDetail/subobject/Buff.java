package xhsun.gw2api.guildwars2.model.util.itemDetail.subobject;

/**
 * Infix Buff model class
 * @see InfixUpgrade infix upgrade
 * @author xhsun
 * @since 2017-02-10
 */

public class Buff {
	private long skill_id;
	private String description;

	public String getDescription() {
		return description;
	}

	public long getSkillID() {
		return skill_id;
	}

	public String toString(){
		return "{Skill ID: "+skill_id+" Description: "+description+"}";
	}
}
