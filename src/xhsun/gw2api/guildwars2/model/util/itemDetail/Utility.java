package xhsun.gw2api.guildwars2.model.util.itemDetail;

/**
 * Item detail for Container, Gathering tools, Gizmo, Salvage kits<br/>
 * Note: getChrages() for Slavage kits only
 * @see ItemDetail item details
 * @author xhsun
 * @since 2017-02-10
 */
public class Utility extends ItemDetail{
	public Type getType() { return super.type; }
	public int getCharges(){ return super.charges; }

	@Override
	public String toString(){
		return "{Type: "+getType()+" Charges: "+getCharges()+"}";
	}
}
