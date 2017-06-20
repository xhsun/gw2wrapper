package me.xhsun.guildwars2wrapper.model.v2.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.v2.util.comm.Type;
import me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.subobject.InfixUpgrade;

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

	public List<ItemDetail.Infusion> getInfusionUpgradeFlags() {
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
}
