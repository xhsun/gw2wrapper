package xhsun.gw2api.guildwars2.model.util.itemDetail;

import xhsun.gw2api.guildwars2.model.util.itemDetail.subobject.InfixUpgrade;

/**
 * For more info on Trinket detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Trinket">here</a><br/>
 * Item detail for Trinket
 * @see ItemDetail item details
 * @author xhsun
 * @since 2017-02-10
 */
public class Trinket extends ItemDetail {
	public Type getType() { return super.type; }
	public Flag[] getFlags(){ return super.flags; }
	public Infusion[] getInfusionUpgradeFlag(){ return super.infusion_upgrade_flags; }
	public String getSuffix(){ return super.suffix; }
	public InfixUpgrade getInfxUpgrade(){ return super.infix_upgrade; }
	public String[] getBonuses(){ return super.bonuses; }

	@Override
	public String toString(){
		String result="{Type: "+getType();
		if (super.flags!=null){
			result+=" {Flags: ";
			for (Flag flag : super.flags) result += flag + ", ";
			result=result.substring(0, result.length()-2)+"}";
		}
		if (super.infusion_upgrade_flags!=null){
			result+=" {InfusionUpgradeFlag: ";
			for (Infusion flag : super.infusion_upgrade_flags) result += flag + ", ";
			result=result.substring(0, result.length()-2)+"} ";
		}

		result+=" Suffix: "+getSuffix()+" Infix: "+getInfxUpgrade();

		if (super.bonuses!=null){
			result+=" {Bonuses: ";
			for (String  bonus : super.bonuses) result += bonus + ", ";
			result=result.substring(0, result.length()-2)+"} ";
		}
		return result+"}";
	}
}
