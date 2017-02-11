package xhsun.gw2api.guildwars2.model.util.itemDetail;

/**
 * For more info on Bag detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Bag">here</a><br/>
 * Item detail for Bag
 * @see ItemDetail item details
 * @author xhsun
 * @since 2017-02-10
 */
public class Bag extends ItemDetail{
	public int getSize(){ return super.size; }
	private boolean isInvisible(){ return super.no_sell_or_sort; }

	@Override
	public String toString(){
		return "{Size: "+getSize()+" Invisible/Safe: "+isInvisible()+"}";
	}
}
