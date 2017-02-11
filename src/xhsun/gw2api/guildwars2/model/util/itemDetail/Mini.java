package xhsun.gw2api.guildwars2.model.util.itemDetail;

/**
 * For more info on Mini detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Miniature">here</a><br/>
 * Item detail for Mini
 * @see ItemDetail item details
 * @author xhsun
 * @since 2017-02-10
 */
public class Mini extends ItemDetail {
	public long getMiniID(){ return super.minipet_id; }

	@Override
	public String toString(){ return "{MiniID:"+getMiniID()+"}"; }
}
