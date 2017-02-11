package xhsun.gw2api.guildwars2.model.util.itemDetail;

import xhsun.gw2api.guildwars2.model.util.itemDetail.subobject.InfixUpgrade;
import xhsun.gw2api.guildwars2.model.util.itemDetail.subobject.InfusionSlot;

/**
 * For more info on Back detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Back_item">here</a><br/>
 * Item detail for back item
 * @see ItemDetail item details
 * @author xhsun
 * @since 2017-02-10
 */
public class Back extends ItemDetail{
	public InfusionSlot[] getInfusionSlots(){ return super.infusion_slots; }
	public InfixUpgrade getInfxUpgrade(){ return super.infix_upgrade; }
	public long getSuffixID(){ return super.suffix_item_id; }
	public String getSecSuffixID(){ return super.secondary_suffix_item_id;}
	public String[] getStatChoice(){ return super.stat_choices; }

	@Override
	public String toString(){
		String result="";
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
