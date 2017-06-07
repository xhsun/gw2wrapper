package me.xhsun.guildwars2wrapper.model.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.util.comm.Type;
import me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject.InfixUpgrade;

import java.util.List;

/**
 * For more info on upgrade component detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Upgrade_component">here</a><br/>
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class UpgradeComponent extends ItemDetail {
	public Type getType() {
		return type;
	}

	public List<ItemDetail.Flag> getFlags() {
		return flags;
	}

	public List<ItemDetail.Infusion> getInfusion_upgrade_flags() {
		return infusion_upgrade_flags;
	}

	public String getSuffix() {
		return suffix;
	}

	public InfixUpgrade getInfix_upgrade() {
		return infix_upgrade;
	}

	public List<String> getBonuses() {
		return bonuses;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UpgradeComponent that = (UpgradeComponent) o;

		return type == that.type &&
				(flags != null ? flags.equals(that.flags) : that.flags == null) &&
				(infusion_upgrade_flags != null ? infusion_upgrade_flags.equals(that.infusion_upgrade_flags) : that.infusion_upgrade_flags == null) &&
				(suffix != null ? suffix.equals(that.suffix) : that.suffix == null) &&
				(infix_upgrade != null ? infix_upgrade.equals(that.infix_upgrade) : that.infix_upgrade == null) &&
				(bonuses != null ? bonuses.equals(that.bonuses) : that.bonuses == null);
	}

	@Override
	public int hashCode() {
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + (flags != null ? flags.hashCode() : 0);
		result = 31 * result + (infusion_upgrade_flags != null ? infusion_upgrade_flags.hashCode() : 0);
		result = 31 * result + (suffix != null ? suffix.hashCode() : 0);
		result = 31 * result + (infix_upgrade != null ? infix_upgrade.hashCode() : 0);
		result = 31 * result + (bonuses != null ? bonuses.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "UpgradeComponent{" +
				"type=" + type +
				", flags=" + flags +
				", infusion_upgrade_flags=" + infusion_upgrade_flags +
				", suffix='" + suffix + '\'' +
				", infix_upgrade=" + infix_upgrade +
				", bonuses=" + bonuses +
				'}';
	}
}
