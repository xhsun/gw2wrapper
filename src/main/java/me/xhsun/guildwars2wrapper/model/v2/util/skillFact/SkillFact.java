package me.xhsun.guildwars2wrapper.model.v2.util.skillFact;

import com.google.gson.annotations.JsonAdapter;
import me.xhsun.guildwars2wrapper.helper.BooleanAdapter;
import me.xhsun.guildwars2wrapper.model.v2.Skill;
import me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.ItemAttributes;

/**
 * ProfessionSkill fact class for {@link Skill}
 *
 * @author xhsun
 * @since 2017-06-17
 */
public class SkillFact {
	public enum Type {
		AttributeAdjust, Buff, ComboField, ComboFinisher,
		Damage, Distance, Duration, Heal, HealingAdjust,
		NoData, Number, Percent, PrefixedBuff, Radius,
		Range, Recharge, Time, Unblockable
	}

	public enum Effect {
		Aegis, Fury, Might, Protection, Quickness, Regeneration, Resistance,
		Retaliation, Stability, Swiftness, Vigor,
		Bleeding, Blind, Burning, Chilled, Confusion, Crippled, Fear, Immobile, Poison, Slow, Taunt, Torment,
		Vulnerability, Weakness,
		Daze, Float, Knockback, Knockdown, Launch, Pull, Sink, Stun,
		Agony, Alacrity, Invulnerability, Revealed, Stealth, Superspeed
	}

	public enum Field {
		Air, Dark, Fire, Ice, Light, Lightning, Poison, Smoke, Ethereal, Water
	}

	public enum Finisher {Blast, Leap, Projectile, Whirl}

	private String text, icon, description;
	private Type type;
	private int apply_count, duration, percent, hit_count, distance;
	@JsonAdapter(BooleanAdapter.class)
	private int value;
	private float dmg_multiplier;
	private ItemAttributes.Attribute target, source;
	private Effect status;
	private Field field_type;
	private Finisher finisher_type;
	private SkillFact prefix;

	public String getText() {
		return text;
	}

	public String getIcon() {
		return icon;
	}

	public String getDescription() {
		return description;
	}

	public Type getType() {
		return type;
	}

	public int getApplyCount() {
		return apply_count;
	}

	public int getDuration() {
		return duration;
	}

	public int getPercent() {
		return percent;
	}

	public int getHitCount() {
		return hit_count;
	}

	public int getDistance() {
		return distance;
	}

	public float getDamageMultiplier() {
		return dmg_multiplier;
	}

	public ItemAttributes.Attribute getTarget() {
		return target;
	}

	public int getValue() {
		return value;
	}

	public ItemAttributes.Attribute getSource() {
		return source;
	}

	public Effect getStatus() {
		return status;
	}

	public Field getFieldType() {
		return field_type;
	}

	public Finisher getFinisherType() {
		return finisher_type;
	}

	public SkillFact getPrefix() {
		return prefix;
	}
}
