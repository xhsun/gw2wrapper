package xhsun.gw2api.guildwars2.model.util.itemDetail;

import xhsun.gw2api.guildwars2.model.util.itemDetail.subobject.InfixUpgrade;
import xhsun.gw2api.guildwars2.model.util.itemDetail.subobject.InfusionSlot;

/**
 * For more info on Armor detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Armor">here</a><br/>
 * Item detail for Armors
 * @see ItemDetail item details
 * @author xhsun
 * @since 2017-02-07
 */
public class Armor extends ItemDetail {
	public Type getType() { return super.type; }
	public Weight getWeightClass(){ return super.weight_class; }
	public int getDefense(){ return super.defense; }
	public InfusionSlot[] getInfusionSlots(){ return super.infusion_slots; }
	public InfixUpgrade getInfxUpgrade(){ return super.infix_upgrade; }
	public long getSuffixID(){ return super.suffix_item_id; }
	public String getSecSuffixID(){ return super.secondary_suffix_item_id;}
	public String[] getStatChoice(){ return super.stat_choices; }

	@Override
	public String toString(){
		String result="{Type: "+getType()+" Weight: "+getWeightClass()+" Defense: "+defense;
		if (super.infusion_slots!=null){
			result+=" {InfusionSlots: ";
			for (InfusionSlot slot : super.infusion_slots) result += slot + ", ";
			result=result.substring(0, result.length()-2)+"} ";
		}

		result+="Infix: "+getInfxUpgrade()+" SuffixID: "+getSuffixID()+" SecondarySuffixID: "+getSecSuffixID();
		if (super.stat_choices!=null){
			result+=" {StatChoices: ";
			for (String  stat : super.stat_choices) result += stat + ", ";
			result=result.substring(0, result.length()-2)+"} ";
		}
		return result+"}";
	}
}
