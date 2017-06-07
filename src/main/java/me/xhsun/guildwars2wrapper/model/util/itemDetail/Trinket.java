package me.xhsun.guildwars2wrapper.model.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.util.comm.Type;
import me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject.InfixUpgrade;

import java.util.List;

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

	public List<Flag> getFlags() {
		return flags;
	}

	public List<Infusion> getInfusionUpgradeFlag() {
		return infusion_upgrade_flags;
	}

	public String getSuffix() {
		return suffix;
	}

	public InfixUpgrade getInfixUpgrade() {
		return infix_upgrade;
	}

	public List<String> getBonuses() {
		return bonuses;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Trinket trinket = (Trinket) o;

		return type == trinket.type &&
				(flags != null ? flags.equals(trinket.flags) : trinket.flags == null) &&
				(infusion_upgrade_flags != null ? infusion_upgrade_flags.equals(trinket.infusion_upgrade_flags) : trinket.infusion_upgrade_flags == null) &&
				(suffix != null ? suffix.equals(trinket.suffix) : trinket.suffix == null) &&
				(bonuses != null ? bonuses.equals(trinket.bonuses) : trinket.bonuses == null);
	}

	@Override
	public int hashCode() {
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + (flags != null ? flags.hashCode() : 0);
		result = 31 * result + (infusion_upgrade_flags != null ? infusion_upgrade_flags.hashCode() : 0);
		result = 31 * result + (suffix != null ? suffix.hashCode() : 0);
		result = 31 * result + (bonuses != null ? bonuses.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Trinket{" +
				"type=" + type +
				", flags=" + flags +
				", infusion_upgrade_flags=" + infusion_upgrade_flags +
				", suffix='" + suffix + '\'' +
				", bonuses=" + bonuses +
				'}';
	}
}
