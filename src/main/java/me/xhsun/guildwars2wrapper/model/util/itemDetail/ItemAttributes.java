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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ItemAttributes that = (ItemAttributes) o;

		return Float.compare(that.Power, Power) == 0 &&
				Float.compare(that.Precision, Precision) == 0 &&
				Float.compare(that.Toughness, Toughness) == 0 &&
				Float.compare(that.Vitality, Vitality) == 0 &&
				Float.compare(that.cond_dmg, cond_dmg) == 0 &&
				Float.compare(that.cond_duration, cond_duration) == 0 &&
				Float.compare(that.Healing, Healing) == 0 &&
				Float.compare(that.BoonDuration, BoonDuration) == 0;
	}

	@Override
	public int hashCode() {
		int result = (Power != +0.0f ? Float.floatToIntBits(Power) : 0);
		result = 31 * result + (Precision != +0.0f ? Float.floatToIntBits(Precision) : 0);
		result = 31 * result + (Toughness != +0.0f ? Float.floatToIntBits(Toughness) : 0);
		result = 31 * result + (Vitality != +0.0f ? Float.floatToIntBits(Vitality) : 0);
		result = 31 * result + (cond_dmg != +0.0f ? Float.floatToIntBits(cond_dmg) : 0);
		result = 31 * result + (cond_duration != +0.0f ? Float.floatToIntBits(cond_duration) : 0);
		result = 31 * result + (Healing != +0.0f ? Float.floatToIntBits(Healing) : 0);
		result = 31 * result + (BoonDuration != +0.0f ? Float.floatToIntBits(BoonDuration) : 0);
		return result;
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