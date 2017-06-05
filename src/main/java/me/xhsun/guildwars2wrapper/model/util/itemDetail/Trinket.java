package me.xhsun.guildwars2wrapper.model.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject.InfixUpgrade;

import java.util.Arrays;

/**
 * For more info on Trinket detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Trinket">here</a><br/>
 * Item detail for Trinket
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-10
 */
public class Trinket extends ItemDetail {
	public Type getType() {
		return type;
	}

	public Flag[] getFlags() {
		return flags;
	}

	public Infusion[] getInfusionUpgradeFlag() {
		return infusion_upgrade_flags;
	}

	public String getSuffix() {
		return suffix;
	}

	public InfixUpgrade getInfxUpgrade() {
		return infix_upgrade;
	}

	public String[] getBonuses() {
		return bonuses;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Trinket trinket = (Trinket) o;

		return type == trinket.type &&
				Arrays.equals(flags, trinket.flags) &&
				Arrays.equals(infusion_upgrade_flags, trinket.infusion_upgrade_flags) &&
				(suffix != null ? suffix.equals(trinket.suffix) : trinket.suffix == null) &&
				Arrays.equals(bonuses, trinket.bonuses);
	}

	@Override
	public int hashCode() {
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + Arrays.hashCode(flags);
		result = 31 * result + Arrays.hashCode(infusion_upgrade_flags);
		result = 31 * result + (suffix != null ? suffix.hashCode() : 0);
		result = 31 * result + Arrays.hashCode(bonuses);
		return result;
	}

	@Override
	public String toString() {
		return "Trinket{" +
				"type=" + type +
				", flags=" + Arrays.toString(flags) +
				", infusion_upgrade_flags=" + Arrays.toString(infusion_upgrade_flags) +
				", suffix='" + suffix + '\'' +
				", bonuses=" + Arrays.toString(bonuses) +
				'}';
	}
}
