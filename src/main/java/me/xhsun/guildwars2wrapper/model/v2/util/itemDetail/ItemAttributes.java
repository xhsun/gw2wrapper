package me.xhsun.guildwars2wrapper.model.v2.util.itemDetail;

import com.google.gson.annotations.SerializedName;

/**
 * For more info on Itemstat API go <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
 * Item attributes model
 *
 * @author xhsun
 * @since 2017-02-07
 */
public class ItemAttributes {
	public enum Attribute {
		Power, Precision, Toughness, Vitality, ConditionDamage,
		ConditionDuration, Healing, BoonDuration, CritDamage,
		AgonyResistance
	}
	private float Power;
	private float Precision;
	private float Toughness;
	private float Vitality;
	@SerializedName("Condition Damage")
	private float cond_dmg;
	@SerializedName("Condition Duration")
	private float cond_duration;
	private float Healing;
	private float BoonDuration;
	private float CritDamage;
	private float AgonyResistance;

	public float getPower() {
		return Power;
	}

	public float getPrecision() {
		return Precision;
	}

	public float getToughness() {
		return Toughness;
	}

	public float getVitality() {
		return Vitality;
	}

	public float getConditionDamage() {
		return cond_dmg;
	}

	public float getConditionDuration() {
		return cond_duration;
	}

	public float getHealing() {
		return Healing;
	}

	public float getBoonDuration() {
		return BoonDuration;
	}

	public float getFerocity() {
		return CritDamage;
	}

	public float getAgonyResistance() {
		return AgonyResistance;
	}
}