package me.xhsun.guildwars2wrapper.model.util.itemDetail;

import com.google.gson.annotations.SerializedName;

/**
 * For more info on Itemstat API go <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
 * Item attributes model
 *
 * @author xhsun
 * @since 2017-02-07
 */
public class ItemAttributes {
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

	@Override
	public String toString() {
		return "ItemAttributes{" +
				"Power=" + Power +
				", Precision=" + Precision +
				", Toughness=" + Toughness +
				", Vitality=" + Vitality +
				", cond_dmg=" + cond_dmg +
				", cond_duration=" + cond_duration +
				", Healing=" + Healing +
				", BoonDuration=" + BoonDuration +
				'}';
	}
}